package edu.upc.gamestore.services;

import edu.upc.gamestore.models.VideoGame;

import java.util.List;

public interface VideoGameServiceInterface {
    List<VideoGame> getGame(String keyword);
}
