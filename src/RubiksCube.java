/**
 * Created by alexlucas on 29/11/2016.
 */
public class RubiksCube {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    Piece[][][] cube = new Piece[3][3][3];

    public RubiksCube(){
        //make center pieces
        //make corner pieces
        //make edge pieces

    }

    private void initializeCenterPieces(){
        cube[ONE][ONE][ZERO] = new CenterPiece(Color.RED, Face.FRONT);
        cube[ONE][ONE][TWO] = new CenterPiece(Color.GREEN, Face.BACK);
        cube[ZERO][ONE][ONE] = new CenterPiece(Color.WHITE, Face.LEFT);
        cube[TWO][ONE][ONE] = new CenterPiece(Color.BLUE, Face.RIGHT);
        cube[ONE][ZERO][ONE] = new CenterPiece(Color.YELLOW, Face.TOP);
        cube[ONE][TWO][ONE] = new CenterPiece(Color.ORANGE, Face.BOTTOM);
    }

    private void initializeEdgePieces(){
        //front top
        cube[ONE][ZERO][ZERO] = new
        //front left
        cube[ZERO][ONE][ZERO];
        //front right
        cube[TWO][ONE][ZERO];
        //front bottom
        cube[ONE][TWO][ZERO];

        //back top
        cube[ONE][ZERO][TWO];

        //back left
        cube[ZERO][ONE][TWO];

        //back right
        cube[TWO][ONE][TWO];

        //back bottom
        cube[ONE][TWO][TWO];


        //top left
        cube[ZERO][ZERO][ONE];
        //top right
        cube[TWO][ZERO][ONE];

        //bottom left
        cube[ZERO][TWO][ONE];

        //bottom right
        cube[TWO][TWO][ONE];

    }
}
