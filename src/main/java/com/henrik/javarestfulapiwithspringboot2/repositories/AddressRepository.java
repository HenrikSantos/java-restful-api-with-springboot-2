package com.henrik.javarestfulapiwithspringboot2.repositories;

import com.henrik.javarestfulapiwithspringboot2.models.AddressModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressModel, String> {
}
