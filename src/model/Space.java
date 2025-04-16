package model;

/**
 * Representa um espaço no tabuleiro do jogo.
 */
public class Space {

    private Integer actual;
    private final int expected;
    private final boolean fixed;

    /**
     * Construtor da classe Space.
     * 
     * @param expected Valor esperado para o espaço (deve estar entre 1 e 9).
     * @param fixed    Indica se o espaço é fixo.
     */
    public Space(final int expected, final boolean fixed) {
        if (expected < 1 || expected > 9) { // Exemplo: valores válidos de 1 a 9
            throw new IllegalArgumentException("Valor esperado deve estar entre 1 e 9.");
        }
        this.expected = expected;
        this.fixed = fixed;
        if (fixed) {
            this.actual = expected;
        }
    }

    public Integer getActual() {
        return actual;
    }

    public void setActual(final Integer actual) {
        if (fixed) return;
        this.actual = actual;
    }

    public void clearSpace() {
        setActual(null);
    }

    public int getExpected() {
        return expected;
    }

    public boolean isFixed() {
        return fixed;
    }
}