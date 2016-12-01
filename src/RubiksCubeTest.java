import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexlucas on 1/12/2016.
 */
public class RubiksCubeTest {

    RubiksCube rubiksCube;
    @Before
    public void setup() {
        rubiksCube = new RubiksCube();
    }
    @Test
    public void getCube() throws Exception {
        Piece[][][] cube = rubiksCube.getCube();
        //assertEquals();
    }

    @Test
    public void showCube() throws Exception {

    }

    @Test
    public void rotateFace() throws Exception {

    }

}