package com.desafio.zup.repository;

import com.desafio.zup.model.ComicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<ComicModel, Long> {
}
