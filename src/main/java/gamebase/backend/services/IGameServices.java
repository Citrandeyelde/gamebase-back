package gamebase.backend.services;

import gamebase.backend.model.Game;

import java.util.List;

public interface IGameServices {
    List<Game> getGames ();
    Game getGame(Integer id_game);
    Game saveGame (Game game);
    void deleteGame (Integer id_game);
 }
