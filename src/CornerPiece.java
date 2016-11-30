import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by alexlucas on 29/11/2016.
 */
public class CornerPiece implements Piece {
    ArrayList<Color> colors = new ArrayList<>();
    ArrayList<Face> faces = new ArrayList<>();


    @Override
    public HashSet<Color> getColors() {
        return null;
    }

    @Override
    public Color getColorForFace(Face face) {
        return null;
    }

    @Override
    public void setFace(Color color) {

    }
}
