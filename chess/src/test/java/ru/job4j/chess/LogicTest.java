package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.C1, Cell.H5);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to H5");
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.D2));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Cell is already occupied");
    }

    @Test
    public void whenMoveFigureFromC1toH6ThenSuccess() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
        logic.move(Cell.C1, Cell.H6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Figure[] figures = logic.getFigures();
        Cell result = figures[0].position();
        assertThat(result).isEqualTo(Cell.H6);
    }

    @Test
    public void whenAddFigureToC1ThenSuccess() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        Figure[] figures = logic.getFigures();
        Cell result = figures[0].position();
        assertThat(result).isEqualTo(Cell.C1);
    }
}