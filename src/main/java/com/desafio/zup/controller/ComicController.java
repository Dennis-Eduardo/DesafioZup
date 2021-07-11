package com.desafio.zup.controller;

import com.desafio.zup.dto.CreateComicDTO;
import com.desafio.zup.model.ComicModel;
import com.desafio.zup.service.impl.ComicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comics")
public class ComicController {


    @Autowired
    private ComicServiceImpl comicService;

    @PostMapping
    public ResponseEntity<ComicModel> save(@Valid @RequestBody CreateComicDTO comic) {
        ComicModel comicModel = this.comicService.save(comic);
        return new ResponseEntity<>(comicModel, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ComicModel>> getAll() {
        List<ComicModel> comicModels = this.comicService.getComics();
        return new ResponseEntity<>(comicModels, HttpStatus.OK);
    }

    @GetMapping({"/{comicId}"})
    public ResponseEntity<ComicModel> getById(@PathVariable("comicId") Long id) {
        return new ResponseEntity<>(this.comicService.getById(id), HttpStatus.OK);
    }
}
