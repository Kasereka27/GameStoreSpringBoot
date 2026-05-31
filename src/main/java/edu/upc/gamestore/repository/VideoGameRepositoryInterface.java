package edu.upc.gamestore.repository;

import edu.upc.gamestore.models.VideoGame;

import java.util.List;

public interface VideoGameRepositoryInterface {
    List<VideoGame> getGame(String keyword);
}
