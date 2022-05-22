package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.service.core.LocalDateTimeService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LocalDateTimeServiceImpl implements LocalDateTimeService {

    @Override
    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
