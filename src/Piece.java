
/**
 * Created by alexlucas on 29/11/2016.
 */
public interface Piece {

    Color getColorForFace(Face face);

    void updateFaces(Face rotatedFace);

    void printPiece(Face face);
}
