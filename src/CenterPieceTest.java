import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by alexlucas on 1/12/2016.
 */
public class CenterPieceTest {
    Piece center;
    @Before
    public void setup(){
        center = new CenterPiece(Color.GREEN, Face.BACK);
    }
    @Test(expected=IllegalStateException.class)
    public void updateFacesIllegalState() throws Exception {
        center.updateFaces(true, Face.FRONT);
    }

}