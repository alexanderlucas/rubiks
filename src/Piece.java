import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by alexlucas on 29/11/2016.
 */
public interface Piece {

    public Color getColorForFace(Face face);

    public void updateFaces(boolean forward, Face rotatedFace);
}
