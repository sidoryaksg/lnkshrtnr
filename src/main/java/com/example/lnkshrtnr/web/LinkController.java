package com.example.lnkshrtnr.web;

import com.example.lnkshrtnr.app.domain.Link;
import com.example.lnkshrtnr.app.service.CoderService;
import com.example.lnkshrtnr.app.service.LinkService;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
public class LinkController {

    private final LinkService service;

    private final CoderService coderService;

    @GetMapping(path = "/")
    public String getPage() {
        return "index";
    }

    @PostMapping(path="/")
    public String createLink(@RequestParam String linkUrl, Model model){
        int linkId = service.save (linkUrl);

        String shortUrlCode = coderService.encode(linkId);

        model.addAttribute("shortUrlCode", shortUrlCode);

        return "index";


    }

    @GetMapping(path = "/{shortUrlCode}")
    public String redirectToUrl(@PathVariable String shortUrlCode){
        int linkId = coderService.decode(shortUrlCode);

        Link link = service.getById(linkId);

        String targetUrl = link.getUrl();
        if (!targetUrl.startsWith("http://") && !targetUrl.startsWith("https://")) {
            targetUrl = "http://" + targetUrl;
        }



        return "redirect:" + targetUrl;

    }

}
