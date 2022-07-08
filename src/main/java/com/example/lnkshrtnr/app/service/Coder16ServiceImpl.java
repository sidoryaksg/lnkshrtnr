package com.example.lnkshrtnr.app.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "app.coder.alg", havingValue = "16")
public class Coder16ServiceImpl implements CoderService {
    @Override
    public String encode(int value) {
        return Integer.toHexString(value);
    }

    @Override
    public int decode(String value) {
        return Integer.parseInt(value, 16);
    }
}
