package edu.upc.gamestore.controllers;

import edu.upc.gamestore.repository.VideoGameRepositoryInterface;
import edu.upc.gamestore.services.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class VideoGameController {
    @Autowired
    private VideoGameService videoGameService;

    @GetMapping("/games")
    public String getVideoGames(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("videoGames", videoGameService.getGame(keyword));
        return "index";
    }
}
