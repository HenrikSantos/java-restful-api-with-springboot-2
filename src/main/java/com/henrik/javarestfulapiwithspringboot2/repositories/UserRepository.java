package com.henrik.javarestfulapiwithspringboot2.repositories;

import com.henrik.javarestfulapiwithspringboot2.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

}
