import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by alexlucas on 29/11/2016.
 */
public interface Piece {
//    HashMap<Color, Face> pieceColors = new HashMap<>();

    public HashSet<Color> getColors();
    public Color getColorForFace(Face face);
    public void setFace(Color color);
}
