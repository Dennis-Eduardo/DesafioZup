package com.desafio.zup.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Objects;

public class CreatorDataDTO {

    @JsonDeserialize(contentAs = CreatorItemDTO.class)
    private List<CreatorItemDTO> items;

    public List<CreatorItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CreatorItemDTO> items) {
        this.items = items;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatorDataDTO that = (CreatorDataDTO) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
