package com.desafio.zup.service.impl;

import com.desafio.zup.exception.ComicNotFoundException;
import com.desafio.zup.repository.ComicRepository;
import com.desafio.zup.service.ComicService;
import com.desafio.zup.dto.ComicResultDTO;
import com.desafio.zup.dto.CreateComicDTO;
import com.desafio.zup.http.ComicHttp;
import com.desafio.zup.model.ComicModel;
import com.desafio.zup.model.UserModel;
import com.desafio.zup.service.UserService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComicServiceImpl implements ComicService {


    @Autowired
    ComicRepository comicRepository;

    @Autowired
    private ComicHttp comicHttp;

    @Autowired
    private UserService userService;

    @Override
    public ComicModel save(CreateComicDTO createComicDTO) {
        try {
            UserModel user = this.userService.getUserById(createComicDTO.getUserId());
            Optional<ComicResultDTO> comic = Optional.ofNullable(this.comicHttp.getComicItemDetails(createComicDTO.getComicId()));
            if (comic.isEmpty()) {
                throw new ComicNotFoundException(createComicDTO.getComicId());
            }
            ComicModel comicModel = new ComicModel();
            comicModel.toComicModel(comic.get().getData().getResults().get(0));
            comicModel.setUser(user);
            return this.comicRepository.save(comicModel);

        } catch (FeignException e) {
            throw new ComicNotFoundException(createComicDTO.getComicId());
        }
    }

    @Override
    public List<ComicModel> getComics() {
        List<ComicModel> users = new ArrayList<>();
        this.comicRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public ComicModel getById(Long id) {
        return this.comicRepository.findById(id).orElseThrow(() -> new ComicNotFoundException(id));
    }
}
