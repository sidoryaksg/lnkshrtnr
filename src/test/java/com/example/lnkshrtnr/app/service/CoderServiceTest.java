package com.example.lnkshrtnr.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
class CoderServiceTest {

    private static final Random random = new Random();

    private List<CoderService> coderServices = List.of(
            new Coder8ServiceImpl(),
            new Coder16ServiceImpl(),
            new Coder62ServiceImpl()
    );

    @Test
    void consistency() {
        for (CoderService coderService : coderServices) {
            for (int i = 0; i < 10; i++) {
                int value = random.nextInt(Integer.MAX_VALUE);

                Assertions.assertEquals(value, coderService.decode(coderService.encode(value)));

            }
            
        } 

    }

}