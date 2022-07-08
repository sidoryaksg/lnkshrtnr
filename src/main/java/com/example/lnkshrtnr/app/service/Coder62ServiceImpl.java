package com.example.lnkshrtnr.app.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "app.coder.alg", havingValue = "62")
public class Coder62ServiceImpl implements CoderService {
    @Override
    public String encode(int value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int decode(String value) {
        throw new UnsupportedOperationException();
    }
}
