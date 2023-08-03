package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenFigurePositionIsH5() {
        Figure bishopBlack = new BishopBlack(Cell.H5);
        Cell result = bishopBlack.position();
        assertThat(result).isEqualTo(Cell.H5);
    }

    @Test
    void whenBishopBlackMoveFromC1ToG5ThenCellArray() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        assertThat(result).isEqualTo(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }

    @Test
    void whenMoveFromC1toG5IsDiagonalIsTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean result = bishopBlack.isDiagonal(Cell.C1, Cell.G5);
        assertThat(result).isTrue();
    }

    @Test
    void whenMoveFromC1ToG3IsDiagonalIsFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean result = bishopBlack.isDiagonal(Cell.C1, Cell.G3);
        assertThat(result).isFalse();
    }

    @Test
    void whenCopyFigureFromH5toF8() {
        Figure bishopBlack = new BishopBlack(Cell.H5);
        Figure bishopBlackCopy = bishopBlack.copy(Cell.F8);
        Cell result = bishopBlackCopy.position();
        assertThat(result).isEqualTo(Cell.F8);
    }
}