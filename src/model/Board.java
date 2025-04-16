package model;

import java.util.Collection;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Representa o tabuleiro do jogo e gerencia sua lógica.
 */
public class Board {

    private static final GameStatusEnum NON_STARTED = GameStatusEnum.NON_STARTED;
    private static final GameStatusEnum INCOMPLETE = GameStatusEnum.INCOMPLETE;
    private static final GameStatusEnum COMPLETE = GameStatusEnum.COMPLETE;

    private final List<List<Space>> spaces;

    public Board(final List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatusEnum getStatus() {
        boolean allSpacesEmpty = spaces.stream()
            .flatMap(Collection::stream)
            .noneMatch(s -> !s.isFixed() && s.getActual() != null);

        if (allSpacesEmpty) {
            return NON_STARTED;
        }

        boolean hasEmptySpaces = spaces.stream()
            .flatMap(Collection::stream)
            .anyMatch(s -> s.getActual() == null);

        return hasEmptySpaces ? INCOMPLETE : COMPLETE;
    }

    public boolean hasErrors() {
        if (getStatus() == NON_STARTED) {
            return false;
        }
        return spaces.stream()
            .flatMap(Collection::stream)
            .anyMatch(s -> s.getActual() != null && !s.getActual().equals(s.getExpected()));
    }

    public boolean changeValue(final int col, final int row, final int value) {
        if (value < 1 || value > 9) { // Exemplo: valores válidos de 1 a 9
            return false;
        }
        if (col < 0 || col >= spaces.size() || row < 0 || row >= spaces.get(col).size()) {
            return false;
        }
        var space = spaces.get(col).get(row);
        if (space.isFixed()) {
            return false;
        }
        space.setActual(value);
        return true;
    }

    public boolean clearValue(final int col, final int row) {
        if (col < 0 || col >= spaces.size() || row < 0 || row >= spaces.get(col).size()) {
            return false;
        }
        var space = spaces.get(col).get(row);
        if (space.isFixed()) {
            return false;
        }
        space.clearSpace();
        return true;
    }

    public void reset() {
        spaces.forEach(c -> c.forEach(Space::clearSpace));
    }

    public boolean gameIsFinished() {
        return !hasErrors() && getStatus().equals(COMPLETE);
    }
}