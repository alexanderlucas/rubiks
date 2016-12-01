import java.util.ArrayList;

/**
 * Created by alexlucas on 29/11/2016.
 */
public class CornerPiece implements Piece {
    protected ArrayList<Color> colors = new ArrayList<>();
    protected ArrayList<Face> faces = new ArrayList<>();

    public CornerPiece(ArrayList<Color> colors, ArrayList<Face> faces){
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
        for (int i = 0; i < 3; i++) { //corner pieces have 3 faces
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
