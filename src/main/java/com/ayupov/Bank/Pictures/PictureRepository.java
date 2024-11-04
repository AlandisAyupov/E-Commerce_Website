package com.ayupov.Bank.Pictures;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface PictureRepository extends MongoRepository<Picture, String> {
    List<Picture> findByPictureID(@Param("pictureID") String pictureID);
}