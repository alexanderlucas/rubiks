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
        assertArrayEquals(cube, rubiksCube.cube);
    }

    @Test
    public void rotateTopFaceForward() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.TOP, Direction.FORWARD);

        int j = 0;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                assertEquals(old[i][j][k], rubiksCube.cube[k][j][2-i]);
            }
        }

    }
    @Test
    public void rotateTopFaceBackwards() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.TOP, Direction.BACKWARDS);
        int j = 0;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                assertEquals(old[i][j][k], rubiksCube.cube[2-k][j][i]);
            }
        }

    }


    @Test
    public void rotateBottomFaceForward() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.BOTTOM, Direction.FORWARD);

        int j = 2;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                assertEquals(old[i][j][k], rubiksCube.cube[k][j][2-i]);
            }
        }

    }
    @Test
    public void rotateBottomFaceBackwards() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.BOTTOM, Direction.BACKWARDS);
        int j = 2;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                assertEquals(old[i][j][k], rubiksCube.cube[2-k][j][i]);
            }
        }
    }


    @Test
    public void rotateLeftFaceForward() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.LEFT, Direction.FORWARD);

        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                assertEquals(old[i][j][k], rubiksCube.cube[i][2-k][j]);
            }
        }

    }
    @Test
    public void rotateLeftFaceBackwards() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.LEFT, Direction.BACKWARDS);

        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                assertEquals(old[i][j][k], rubiksCube.cube[i][k][2-j]);
            }
        }
    }

    @Test
    public void rotateRightFaceForward() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.RIGHT, Direction.FORWARD);
        int i = 2;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                assertEquals(old[i][j][k], rubiksCube.cube[i][2-k][j]);
            }
        }
    }
    @Test
    public void rotateRightFaceBackwards() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.RIGHT, Direction.BACKWARDS);

        int i = 2;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                assertEquals(old[i][j][k], rubiksCube.cube[i][k][2-j]);
            }
        }
    }

    @Test
    public void rotateFrontFaceForward() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();

        rubiksCube.rotateFace(Face.FRONT, Direction.FORWARD);
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(old[i][j][k], rubiksCube.cube[2-j][i][k]);
            }
        }
    }
    @Test
    public void rotateFrontFaceBackwards() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.FRONT, Direction.BACKWARDS);

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(old[i][j][k], rubiksCube.cube[j][2-i][k]);
            }
        }
    }

    @Test
    public void rotateBackFaceForward() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.BACK, Direction.FORWARD);
        int k = 2;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(old[i][j][k], rubiksCube.cube[2-j][i][k]);
            }
        }
    }
    @Test
    public void rotateBackFaceBackwards() throws Exception {
        Piece[][][] old = rubiksCube.getCubeCopy();
        rubiksCube.rotateFace(Face.BACK, Direction.BACKWARDS);
        int k = 2;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(old[i][j][k], rubiksCube.cube[j][2-i][k]);
            }
        }
    }

}