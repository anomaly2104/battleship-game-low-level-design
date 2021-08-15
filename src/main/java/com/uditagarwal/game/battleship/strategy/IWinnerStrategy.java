package com.uditagarwal.game.battleship.strategy;

import com.uditagarwal.game.battleship.model.player.Player;

import java.util.List;

public interface IWinnerStrategy {

    Player getWinner(List<Player> playerList);
}
