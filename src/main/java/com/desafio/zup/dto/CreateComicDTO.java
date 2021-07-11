package com.desafio.zup.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CreateComicDTO {

    @NotNull
    private Long comicId;
    @NotNull
    private Long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateComicDTO that = (CreateComicDTO) o;
        return Objects.equals(comicId, that.comicId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comicId, userId);
    }

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
