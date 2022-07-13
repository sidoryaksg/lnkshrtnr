package com.example.lnkshrtnr.web;


import com.example.lnkshrtnr.app.domain.Link;
import com.example.lnkshrtnr.app.repository.LinkRepository;
import com.example.lnkshrtnr.app.service.CoderService;
import com.example.lnkshrtnr.app.service.LinkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest

class LinkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LinkService linkService;

    @MockBean
    private CoderService coderService;

    @Test
    void createLink() throws Exception {

        String shortUrlCode = UUID.randomUUID().toString();

        Mockito.when(coderService.encode(ArgumentMatchers.anyInt())).thenReturn(shortUrlCode);


        String linkUrl = String.format("https://example.com/%s", UUID.randomUUID());


        mockMvc.perform(MockMvcRequestBuilders.post("/")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(String.format("linkUrl=%s", linkUrl)))
                .andExpect(status().isOk())
                .andExpect(model().attribute("shortUrlCode", shortUrlCode));


        ArgumentCaptor<Integer> linkIdCaptor = ArgumentCaptor.forClass(Integer.class);

        Mockito.verify(coderService).encode(linkIdCaptor.capture());


        Link link = linkService.getById(linkIdCaptor.getValue());

        Assertions.assertEquals(linkUrl, link.getUrl());
    }
}