
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
    public Color getColorForFace(Face face) {
        return colors.get(faces.indexOf(face));
    }

    @Override
    public void updateFaces(boolean forward, Face rotatedFace) {
        ArrayList<Face> affectedFaces = rotatedFace.getAffectedFaces();
        int size = affectedFaces.size();
        for (int i = 0; i < 2; i++) { //edge pieces have two faces
            Face face = faces.get(i);
            if(face != rotatedFace){
                Face newFace;
                if (forward){
                    int index = (affectedFaces.indexOf(face) + 1);
                    index = Math.floorMod(index, size);
                    newFace = affectedFaces.get(index);
                }
                else {
                    int index = affectedFaces.indexOf(face) - 1;
                    index = Math.floorMod(index, size);
                    newFace = affectedFaces.get(index);
                }
                faces.set(i, newFace);

            }
        }
    }
}
