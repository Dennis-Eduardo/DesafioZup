package com.desafio.zup.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Objects;

public class ComicItemDTO {

    private String title;
    private String description;
    private String isbn;

    @JsonDeserialize(contentAs = PriceDTO.class)
    private ArrayList<PriceDTO> prices;

    private CreatorDataDTO creators;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;


    public ArrayList<PriceDTO> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<PriceDTO> prices) {
        this.prices = prices;
    }

    public CreatorDataDTO getCreators() {
        return creators;
    }

    public void setCreators(CreatorDataDTO creators) {
        this.creators = creators;
    }

    public ComicItemDTO(String title, String description, String isbn) {
        this.title = title;
        this.description = description;
        this.isbn = isbn;
    }

    public ComicItemDTO() {

    }

    @Override
    public String toString() {
        return "ComicItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComicItemDTO comicItemDTO = (ComicItemDTO) o;
        return Objects.equals(title, comicItemDTO.title) && Objects.equals(description, comicItemDTO.description) && Objects.equals(isbn, comicItemDTO.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, isbn);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
