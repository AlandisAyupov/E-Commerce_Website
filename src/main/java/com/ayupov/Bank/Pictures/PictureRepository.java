package com.ayupov.bank.Pictures;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface PictureRepository extends MongoRepository<Picture, String> {
    List<Picture> findByPictureID(@Param("pictureID") String pictureID);
}