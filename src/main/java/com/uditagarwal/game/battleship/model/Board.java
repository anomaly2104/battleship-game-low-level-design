package com.uditagarwal.game.battleship.model;

import com.uditagarwal.game.battleship.exceptions.CoordinateOutOfBoundaryException;
import com.uditagarwal.game.battleship.model.boundary.IBoundary;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {

    private final List<BoardItem> ships;
    private final IBoundary boundary;
    private final List<Coordinate> allBombLocations;

    public Board(@NonNull final List<BoardItem> ships, @NonNull final IBoundary boundary) {
        // TODO: Validate whether ships in board's boundary
        this.ships = ships;
        this.boundary = boundary;
        this.allBombLocations = new ArrayList<>();
    }

    public void takeHit(@NonNull final Coordinate coordinate) {
        if (!boundary.contains(coordinate)) {
            throw new CoordinateOutOfBoundaryException();
        }

        allBombLocations.add(coordinate);
    }

    public boolean areAllShipsKilled() {
        for (BoardItem ship : ships) {
            if (!ship.isKilled(allBombLocations)) {
                return false;
            }
        }
        return true;
    }

    public List<Coordinate> hitLocations() {
        final List<Coordinate> result = new ArrayList<>();

        for (Coordinate coordinate: allBombLocations) {
            for (BoardItem ship: ships) {
                if (ship.containsCoordinate(coordinate)) {
                    result.add(coordinate);
                    break;
                }
            }
        }

        return result;
    }

    public List<Coordinate> missLocations() {
        final List<Coordinate> result = new ArrayList<>();

        for (Coordinate coordinate: allBombLocations) {
            boolean doesBelongToShip = false;
            for (BoardItem ship: ships) {
                if (ship.containsCoordinate(coordinate)) {
                    doesBelongToShip = true;
                    break;
                }
            }
            if (!doesBelongToShip) {
                result.add(coordinate);
            }
        }

        return result;
    }
}
