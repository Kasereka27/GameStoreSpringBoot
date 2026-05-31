package edu.upc.gamestore.services;

import edu.upc.gamestore.models.VideoGame;
import edu.upc.gamestore.repository.VideoGameRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoGameService implements VideoGameServiceInterface {

    @Autowired
    private VideoGameRepositoryInterface videoGameRepository;

    @Override
    public List<VideoGame> getGame(String keyword) {
        return videoGameRepository.getGame(keyword);
    }
}
