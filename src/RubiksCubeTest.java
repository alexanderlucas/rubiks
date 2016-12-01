import org.junit.Before;
import org.junit.Test;


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
    public void rotateTopFaceForward() throws Exception {
        rubiksCube.rotateFace(Face.TOP, Direction.FORWARD);


    }
    @Test
    public void rotateTopFaceBackwards() throws Exception {
        rubiksCube.rotateFace(Face.TOP, Direction.BACKWARDS);


    }


    @Test
    public void rotateBottomFaceForward() throws Exception {
        rubiksCube.rotateFace(Face.BOTTOM, Direction.FORWARD);

    }
    @Test
    public void rotateBottomFaceBackwards() throws Exception {
        rubiksCube.rotateFace(Face.BOTTOM, Direction.BACKWARDS);
    }


    @Test
    public void rotateLeftFaceForward() throws Exception {
        rubiksCube.rotateFace(Face.LEFT, Direction.FORWARD);

    }
    @Test
    public void rotateLeftFaceBackwards() throws Exception {
        rubiksCube.rotateFace(Face.LEFT, Direction.BACKWARDS);
    }

    @Test
    public void rotateRightFaceForward() throws Exception {
        rubiksCube.rotateFace(Face.RIGHT, Direction.FORWARD);
    }
    @Test
    public void rotateRightFaceBackwards() throws Exception {
        rubiksCube.rotateFace(Face.RIGHT, Direction.BACKWARDS);
    }

    @Test
    public void rotateFrontFaceForward() throws Exception {
        rubiksCube.rotateFace(Face.FRONT, Direction.FORWARD);
    }
    @Test
    public void rotateFrontFaceBackwards() throws Exception {
        rubiksCube.rotateFace(Face.FRONT, Direction.BACKWARDS);
    }

    @Test
    public void rotateBackFaceForward() throws Exception {
        rubiksCube.rotateFace(Face.BACK, Direction.FORWARD);
    }
    @Test
    public void rotateBackFaceBackwards() throws Exception {
        rubiksCube.rotateFace(Face.BACK, Direction.BACKWARDS);
    }

}