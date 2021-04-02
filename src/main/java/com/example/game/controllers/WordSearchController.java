package com.example.game.controllers;

import com.example.game.services.WordGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController("/")
public class WordSearchController {

    @Autowired
    private WordGridService wordGridService;

    @GetMapping("/wordgrid")
    @CrossOrigin(origins = "http://localhost:1234")
    public String createWordGrid(@RequestParam int gridSize, @RequestParam String wordList) {
        List<String> words = Arrays.asList(wordList.split(","));
        char[][] grid = wordGridService.generateGrid(gridSize, words);
        String gridToString = "";
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                gridToString += grid[i][j] + " ";
            }
            gridToString += "\r\n";
        }
        return gridToString;
    }
}


