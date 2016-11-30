import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by alexlucas on 29/11/2016.
 */
public class EdgePiece implements Piece {

    ArrayList<Color> colors = new ArrayList<>();
    ArrayList<Face> faces = new ArrayList<>();

    public EdgePiece(ArrayList)

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
}
