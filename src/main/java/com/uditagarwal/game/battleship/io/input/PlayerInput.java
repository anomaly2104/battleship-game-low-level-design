package com.uditagarwal.game.battleship.io.input;

import com.uditagarwal.game.battleship.model.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerInput {

    private final Integer playerNum;
    private final Integer targetX;
    private final Integer targetY;
}
