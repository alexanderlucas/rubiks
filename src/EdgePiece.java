
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
        System.out.println(rotatedFace.getFaceClass());
        ArrayList<Face> affectedFaces = rotatedFace.getAffectedFaces();
        for (Face face:affectedFaces) {
            System.out.println(face);
        }
        int size = affectedFaces.size();
        for (Face face:faces) {
            if(face != rotatedFace){
                Face newFace;
                if (forward){
                    System.out.println(face);
                    System.out.println(affectedFaces.indexOf(face));
                    int index = (affectedFaces.indexOf(face) + 1) % size;
                    System.out.println(index);
                    newFace = affectedFaces.get(index);
                }
                else {
                    newFace = affectedFaces.get((affectedFaces.indexOf(face) - 1) % size);
                }
                System.out.println("old: "+face);
                System.out.println("new: "+newFace);
                faces.set(faces.indexOf(face), newFace);

            }
        }
    }
}
