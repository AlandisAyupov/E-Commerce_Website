package com.ayupov.bank.Pictures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PictureService {
    private static final Logger log = LoggerFactory.getLogger(PictureService.class);

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

    public Picture getPicture(String pictureID)
    {
        Optional<Picture> opt = pictureRepository.findById(pictureID);
        if(opt.isPresent())
        {
            log.info("item exists");
            return opt.get();
        }
        return null;
    }
}
