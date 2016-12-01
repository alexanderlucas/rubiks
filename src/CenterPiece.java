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

    @Override
    public Color getColorForFace(Face face) {
        return colors.get(faces.indexOf(face));
    }

    @Override
    public void updateFaces(boolean forward, Face rotatedFace) {
        if(rotatedFace != faces.get(0)){
            throw new IllegalStateException("Center pieces cannot changes faces");
        }
    }
}
