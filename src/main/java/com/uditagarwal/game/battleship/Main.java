package com.uditagarwal.game.battleship;

import com.uditagarwal.game.battleship.io.input.IInputProvider;
import com.uditagarwal.game.battleship.io.input.SysInInputProvider;
import com.uditagarwal.game.battleship.model.boundary.RectangularBoundary;
import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.io.output.SysOutOutputPrinter;
import com.uditagarwal.game.battleship.model.Board;
import com.uditagarwal.game.battleship.model.boundary.IBoundary;
import com.uditagarwal.game.battleship.model.Coordinate;
import com.uditagarwal.game.battleship.model.BoardItem;
import com.uditagarwal.game.battleship.strategy.DefaultWinnerStrategy;
import com.uditagarwal.game.battleship.strategy.LocalChanceGeneration;
import com.uditagarwal.game.battleship.strategy.RoundRobinPlayerPickingStrategy;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final IInputProvider inputProvider = new SysInInputProvider();
        List<Player> players = new ArrayList<>();
        players.add(getPlayer1(inputProvider));
        players.add(getPlayer2(inputProvider));
        GameLoop gameLoop = new GameLoop(
                players,
                new DefaultWinnerStrategy(),
                new SysOutOutputPrinter(),
                new RoundRobinPlayerPickingStrategy());
        gameLoop.start();
    }

    private static Player getPlayer1(@NonNull final IInputProvider inputProvider) {
        final IBoundary boardBoundary = new RectangularBoundary(new Coordinate(0, 10), new Coordinate(10, 0));

        BoardItem ship1 = new BoardItem("Carrier", new RectangularBoundary(new Coordinate(0, 7), new Coordinate(4,7)));
        BoardItem ship2 = new BoardItem("Battleship", new RectangularBoundary(new Coordinate(4, 1), new Coordinate(4,4)));
        BoardItem ship3 = new BoardItem("Cruiser", new RectangularBoundary(new Coordinate(7, 3), new Coordinate(7, 5)));
        BoardItem ship4 = new BoardItem("Destroyer", new RectangularBoundary(new Coordinate(4, 9), new Coordinate(6,9)));
        BoardItem ship5 = new BoardItem("Submarine", new RectangularBoundary(new Coordinate(3, 6), new Coordinate(4,3)));

        ArrayList<BoardItem> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);
        ships.add(ship4);
        ships.add(ship5);

        Board board = new Board(ships, boardBoundary);

        return new Player(board, 1, new LocalChanceGeneration(inputProvider));
    }

    private static Player getPlayer2(@NonNull final IInputProvider inputProvider) {
        final IBoundary boardBoundary = new RectangularBoundary(new Coordinate(0, 10), new Coordinate(10, 0));

        BoardItem ship1 = new BoardItem("Carrier", new RectangularBoundary(new Coordinate(0, 7), new Coordinate(4,7)));
        BoardItem ship2 = new BoardItem("Battleship", new RectangularBoundary(new Coordinate(4, 1), new Coordinate(4,4)));
        BoardItem ship3 = new BoardItem("Cruiser", new RectangularBoundary(new Coordinate(7, 3), new Coordinate(7, 5)));
        BoardItem ship4 = new BoardItem("Destroyer", new RectangularBoundary(new Coordinate(4, 9), new Coordinate(6,9)));
        BoardItem ship5 = new BoardItem("Submarine", new RectangularBoundary(new Coordinate(3, 6), new Coordinate(4,3)));

        ArrayList<BoardItem> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);
        ships.add(ship4);
        ships.add(ship5);

        Board board = new Board(ships, boardBoundary);

        return new Player(board, 2, new LocalChanceGeneration(inputProvider));
    }
}
