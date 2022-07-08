package com.example.lnkshrtnr.app.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "app.coder.alg", havingValue = "8", matchIfMissing = true)
public class Coder8ServiceImpl implements CoderService {
    @Override
    public String encode(int value) {
        return Integer.toOctalString(value);
    }

    @Override
    public int decode(String value) {
        return Integer.parseInt(value, 8);
    }
}
