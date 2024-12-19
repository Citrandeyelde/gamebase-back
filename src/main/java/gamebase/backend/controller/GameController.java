package gamebase.backend.controller;

import gamebase.backend.model.Game;
import gamebase.backend.model.Genre;
import gamebase.backend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("")
public class GameController {
    @Autowired
    private GameService gameServices;

    @GetMapping("/inicio")
    public String Iniciar() {
        return "index";
    }

    //acciones con mvc

    @GetMapping("/listarjuegos")
    public String listarJuegos(Model model){
        model.addAttribute("juegos",
                gameServices.getGames());
        return "Game/game";
    }

    @GetMapping("/agregarjuego")
    public String agregarjuego(Model model){
        model.addAttribute("newGame",new Game());
        return "Game/frmgame";
    }
    @PostMapping("/guardarjuego")
    public String guardarjuego(@Validated Game game, Genre genre, BindingResult result, Model model){
        if(result.hasErrors()){
            return "Game/frmgame";
        }
        gameServices.saveGame(game);
        listarJuegos(model);
        return "Game/game";
    }

    // acciones para api

    @GetMapping("/listarjson")
    @ResponseBody
    public List<Game> listarJson(){
        List<Game> games = gameServices.getGames();
        return games;
    }

    @GetMapping("/listar/{id}")
    @ResponseBody
    public Game listarid(@PathVariable("id") Integer id){
        Game game = gameServices.getGame(id);
        return game;
    }
}
