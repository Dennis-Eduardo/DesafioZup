package com.desafio.zup.http;

import com.desafio.zup.dto.ComicResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "usuario", url = "https://gateway.marvel.com/v1/public")
public interface ComicHttp {
    @RequestMapping(method = RequestMethod.GET, value = "/comics/{comidId}?ts=1&hash=71aca1d19c8dfe892d595f065798fe65&apikey=cf6be5f9f2ef658afd36f132b0c680e4")
    ComicResultDTO getComicItemDetails(@PathVariable("comidId") Long comicId);
}


