import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by alexlucas on 29/11/2016.
 */
public class CenterPiece implements Piece {
    ArrayList<Color> colors = new ArrayList<>();
    ArrayList<Face> faces = new ArrayList<>();


    public CenterPiece(Color color, Face face){
        colors.add(color);
        faces.add(face);
    }
    @Override
    public HashSet<Color> getColors() {
        HashSet<Color> col = new HashSet<>();
        col.add(colors.get(0));
        return col;
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
        ArrayList<Face> affectedFaces = rotatedFace.getAffectedFaces();

        int size = affectedFaces.size();
        for (Face face:faces) {
            if(face != rotatedFace){
                Face newFace;
                if (forward){
                    newFace = affectedFaces.get((affectedFaces.indexOf(face) + 1) % size);
                }
                else {
                    newFace = affectedFaces.get((affectedFaces.indexOf(face) - 1) % size);
                }
                faces.set(faces.indexOf(face), newFace);

            }
        }
    }
}
