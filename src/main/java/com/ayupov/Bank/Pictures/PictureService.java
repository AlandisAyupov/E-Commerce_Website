package com.ayupov.Bank.Pictures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ayupov.Bank.Application;
import com.ayupov.Bank.Pictures.PictureRepository;

@Service
public class PictureService {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private final PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository)
    {
        // this keyword refers to current instance
        this.pictureRepository = pictureRepository;
    }

    public int addPicture(Picture picture)
    {
        pictureRepository.save(picture);
        return 200;
    }
}
