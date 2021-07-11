package com.desafio.zup.service;

import com.desafio.zup.dto.CreateComicDTO;
import com.desafio.zup.model.ComicModel;

import java.util.List;

public interface ComicService {
    ComicModel save(CreateComicDTO comic);
    List<ComicModel> getComics();
    ComicModel getById(Long id);
}
