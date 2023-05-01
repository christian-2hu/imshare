package com.imshare.repositories;

import org.springframework.data.repository.CrudRepository;

import com.imshare.models.Images;

public interface ImagesRepository extends CrudRepository<Images, Long> {
    
}
