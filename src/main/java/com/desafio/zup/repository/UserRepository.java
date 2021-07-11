package com.desafio.zup.repository;

import com.desafio.zup.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {

}
