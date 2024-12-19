package gamebase.backend.services;

import gamebase.backend.model.Game;
import gamebase.backend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService implements IGameServices{

    @Autowired
    GameRepository gameRepository;

    @Override
    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game getGame(Integer id_game) {
        return gameRepository.findById(id_game).orElse(null);
    }

    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(Integer id_game) {
        gameRepository.delete(getGame(id_game));
    }
}
