package com.example.mappingexercise.service;

import com.example.mappingexercise.model.dto.GameAddDto;

import java.math.BigDecimal;

public interface GameService {

    void addGame(GameAddDto gameAddDto);

    void editGame(Long gameId, BigDecimal price, Double size);

    void deleteGame(Long id);

    void allGames();

    void detailGame (String title);
}
