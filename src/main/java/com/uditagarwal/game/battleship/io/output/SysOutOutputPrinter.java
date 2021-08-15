package com.uditagarwal.game.battleship.io.output;

import com.uditagarwal.game.battleship.model.player.Player;
import lombok.NonNull;

import java.util.List;

public class SysOutOutputPrinter implements IOutputPrinter {

    @Override
    public void printMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printWinner(@NonNull final Player player) {
        System.out.println("Game Finished!");
        System.out.println("Player: " + player.getId() + " won");
    }

    private void printPlayerInfo(@NonNull final Player player) {
        printMsg("Player: " + player.getId());
    }

    @Override
    public void printSelfBoard(@NonNull final Player player) {
        printMsg("Your board status: ");
        printPlayerInfo(player);
        printMsg("Board boundary: " + player.getBoard().getBoundary());
        printMsg("Ships: " + player.getBoard().getShips());
        printMsg("Hit locations: " + player.getBoard().hitLocations());
        printMsg("Missed locations: " + player.getBoard().missLocations());
    }

    private void printOpponentBoard(@NonNull final Player player) {
        printMsg("\nOpponent board status: ");
        printPlayerInfo(player);
        printMsg("Board boundary: " + player.getBoard().getBoundary());
        printMsg("Hit locations: " + player.getBoard().hitLocations());
        printMsg("Missed locations: " + player.getBoard().missLocations());
    }

    @Override
    public void printOpponentBoard(@NonNull final List<Player> allPlayers, @NonNull final Player currentPlayer) {

        for (Player player : allPlayers) {
            if (player.getId() != currentPlayer.getId()) {
                printOpponentBoard(player);
            }
        }
    }
}
