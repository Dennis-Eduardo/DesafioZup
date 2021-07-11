package com.desafio.zup.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


import java.util.ArrayList;

public class ComicDataDTO {


    @JsonDeserialize(contentAs = ComicItemDTO.class)
    private ArrayList<ComicItemDTO> results;
    private Integer offset;

    public ArrayList<ComicItemDTO> getResults() {
        return results;
    }

    public void setResults(ArrayList<ComicItemDTO> results) {
        this.results = results;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public ArrayList<ComicItemDTO> getResult() {
        return results;
    }

    public void setResult(ArrayList<ComicItemDTO> result) {
        this.results = result;
    }

    public ComicDataDTO(ArrayList<ComicItemDTO> results) {
        this.results = results;
    }

    public ComicDataDTO() {
    }
}
