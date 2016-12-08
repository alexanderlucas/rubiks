import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by alexlucas on 29/11/2016.
 */
public class CenterPiece implements Piece {
    protected ArrayList<Color> colors = new ArrayList<>();
    protected ArrayList<Face> faces = new ArrayList<>();

    public CenterPiece(Color color, Face face){
        colors.add(color);
        faces.add(face);
    }

    /**
     * Returns the color that corresponds to the given face
     *
     * @param face the face of the Piece for which you want the color
     *
     * @return Color that corresponds to the given face
     *
     */
    @Override
    public Color getColorForFace(Face face) {
        return colors.get(faces.indexOf(face));
    }

    /**
     * Updates faces in the Piece in relation to the rotated face
     *
     * @param rotatedFace the face of the Piece that has been rotated
     **
     */
    @Override
    public void updateFaces( Face rotatedFace) {
        if(rotatedFace != faces.get(0)){
            throw new IllegalStateException("Center pieces cannot changes faces");
        }
    }

    /**
     * Prints the character representation of the Color corresponding
     * to the given face of this Piece
     *
     * @param face the face of the Piece to be printed
     **
     */
    @Override
    public void printPiece(Face face) {
        Color color = getColorForFace(face);
        //get the char of that color
        char c = color.getCharacter();
        //print that char
        System.out.print(c + " ");

    }
}
