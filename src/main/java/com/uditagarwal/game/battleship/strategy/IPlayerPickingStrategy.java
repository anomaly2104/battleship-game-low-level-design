package com.uditagarwal.game.battleship.strategy;

import com.uditagarwal.game.battleship.model.player.Player;

import java.util.List;

public interface IPlayerPickingStrategy {

    Integer firstPlayer(List<Player> allPlayers);
    Integer pickNextPlayer(Integer currentPlayerIndex, List<Player> allPlayers);
}
