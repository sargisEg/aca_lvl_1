package com.aca.homework.week18.website.service.core;

import com.aca.homework.week18.website.entity.Image;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ImageService {

    Image create(CreateImageParams params);

    Optional<Image> findById(Long id);

    Optional<Image> findByBlobId(String blobId);
}
