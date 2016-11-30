import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

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

    @Override
    public HashSet<Color> getColors() {
        HashSet<Color> set = new HashSet<>();
        for (Color c: colors) {
            set.add(c);
        }
        return set;
    }

    @Override
    public Color getColorForFace(Face face) {
        return colors.get(faces.indexOf(face));
    }

    @Override
    public void setFace(Color color) {

    }

    @Override
    public void updateFaces(boolean forward, Face rotatedFace) {
        Face[] affectedFaces = rotatedFace.getFaceClass().getAffectedFaces();

        for (Face face:faces) {
            if(face != rotatedFace){
                if (forward){
                    int index = 
                }
                else {

                }
            }
        }
    }
}
