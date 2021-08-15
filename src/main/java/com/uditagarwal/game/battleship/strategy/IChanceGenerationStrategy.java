package com.uditagarwal.game.battleship.strategy;

import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.model.PlayerChanceTarget;

import java.util.List;

public interface IChanceGenerationStrategy {

    PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents);
}
