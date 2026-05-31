package edu.upc.gamestore.controllers;

import edu.upc.gamestore.services.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VideoGameRestController {
    @Autowired
    private VideoGameService videoGameService;

    @GetMapping("/games")
    public Object getVideoGames(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        return videoGameService.getGame(keyword);
    }
}
