/**
 * Created by alexlucas on 29/11/2016.
 */
public enum Color {
    RED('R'),
    GREEN('G'),
    YELLOW('Y'),
    BLUE('B'),
    WHITE('W'),
    ORANGE('O');

    private final char character;

    Color(char character) {
        this.character = character;
    }

    /**
     * Returns the character of this Color
     *
     * @@return char that is the first letter of this color
     **
     */
    public char getCharacter() {
        return character;
    }

}
