package com.desafio.zup.repository;

import com.desafio.zup.model.CreatorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<CreatorModel, Long> {
}
