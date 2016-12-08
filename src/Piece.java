
/**
 * Created by alexlucas on 29/11/2016.
 */
public interface Piece {

    /**
     * Returns the color that corresponds to the given face
     *
     * @param face the face of the Piece for which you want the color
     *
     * @return Color that corresponds to the given face
     *
     */
    Color getColorForFace(Face face);

    /**
     * Updates faces in the Piece in relation to the rotated face
     *
     * @param rotatedFace the face of the Piece that has been rotated
     **
     */
    void updateFaces(Face rotatedFace);

    /**
     * Prints the character representation of the Color corresponding
     * to the given face of this Piece
     *
     * @param face the face of the Piece to be printed
     **
     */
    void printPiece(Face face);
}
