import javafx.scene.control.Cell;

import java.util.*;

/**
 * Created by Ria G on 24-07-2016.
 */
public class Board {
    private Set<CellUnit> cells = new HashSet<>();

    public void addCell(CellUnit cellUnit) {

        cells.add(cellUnit);

    }

    public Set<CellUnit> getNeighbours(CellUnit cellUnit) {
        Set<CellUnit> neighbours = new HashSet<>();
        Set<CellUnit> neighbourhood = getNeighbourhood(cellUnit);

        for (CellUnit c : neighbourhood) {
            if (isAlive(c)) {
                neighbours.add(c);
            }
        }

        neighbours.remove(cellUnit);

        return neighbours;
    }

    public Board nextGeneration() {
        Board board = new Board();

        Set<CellUnit> potentialCellsToBeReborn = new HashSet<>();

        for (CellUnit c : cells) {
            if (shouldBeAliveInNextIteration(c)) {
                board.addCell(c);
            }

            potentialCellsToBeReborn.addAll(getNeighbourhood(c));
        }

        for (CellUnit c : potentialCellsToBeReborn) {
            if (shouldBeReborn(c)) {
                board.addCell(c);
            }
        }

        return board;
    }

    private boolean shouldBeReborn(CellUnit c) {
        return !isAlive(c) && getNeighbours(c).size() == 3;
    }


    private Set<CellUnit> getNeighbourhood(CellUnit cellUnit) {
        Set<CellUnit> neighbourhood = new HashSet<>();

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                CellUnit c = new CellUnit(cellUnit.x + dx, cellUnit.y + dy);
                neighbourhood.add(c);
            }
        }
        return neighbourhood;
    }




    private boolean shouldBeAliveInNextIteration(CellUnit c) {
    return getNeighbours(c).size() == 2 || getNeighbours(c).size() == 3;
        
    }

    public boolean isAlive(CellUnit cellUnit) {
        return cells.contains(cellUnit);
    }
}
