
import java.util.ArrayList;

/**
 * Created by alexlucas on 29/11/2016.
 */
public class EdgePiece implements Piece {
    private ArrayList<Color> colors = new ArrayList<>();
    private ArrayList<Face> faces = new ArrayList<>();

    public EdgePiece(ArrayList<Color> colors, ArrayList<Face> faces){
        this.colors = colors;
        this.faces = faces;
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
    public void updateFaces(Face rotatedFace) {
        ArrayList<Face> affectedFaces = rotatedFace.getAffectedFaces();
        int size = affectedFaces.size();
        for (int i = 0; i < 2; i++) { //edge pieces have two faces
            Face face = faces.get(i);
            if(face != rotatedFace){
                Face newFace;
                int index = (affectedFaces.indexOf(face) + 1);
                index = Math.floorMod(index, size);
                newFace = affectedFaces.get(index);

                faces.set(i, newFace);

            }
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
