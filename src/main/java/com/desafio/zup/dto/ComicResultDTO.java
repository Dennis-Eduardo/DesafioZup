package com.desafio.zup.dto;

public class ComicResultDTO {


    private ComicDataDTO data;
    private Integer code;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ComicResultDTO(ComicDataDTO data) {
        this.data = data;
    }

    public ComicResultDTO() {
    }

    @Override
    public String toString() {
        return "ComicResult{" +
                "data=" + data.toString() +
                '}';
    }

    public ComicDataDTO getData() {
        return data;
    }

    public void setData(ComicDataDTO data) {
        this.data = data;
    }
}
