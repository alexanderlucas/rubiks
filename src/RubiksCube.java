
import java.util.ArrayList;


/**
 * Created by alexlucas on 29/11/2016.
 */
public class RubiksCube {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    Piece[][][] cube = new Piece[3][3][3];

    public RubiksCube(){

        initializeCenterPieces();
        initializeCornerPieces();
        initializeEdgePieces();

    }



    public Piece[][][] getCube(){
        return cube;
    }

    public void toString(){

        printBottomFace();
        printBackFace();
        printLeftTopRight();
        printFrontFace();

    }

    public void rotateFace(Face face, Direction direction){
        switch (face.getFaceClass()){
            case CAP:
                rotateCapFace(face, direction);
                break;
            case VERTICAL:
                rotateVerticalFace(face, direction);
                break;
            case SIDE:
                rotateSideFace(face, direction);
                break;
        }
    }



    private void initializeCenterPieces(){
        cube[ONE][ONE][ZERO] = new CenterPiece(Color.RED, Face.FRONT);
        cube[ONE][ONE][TWO] = new CenterPiece(Color.GREEN, Face.BACK);
        cube[ZERO][ONE][ONE] = new CenterPiece(Color.WHITE, Face.LEFT);
        cube[TWO][ONE][ONE] = new CenterPiece(Color.BLUE, Face.RIGHT);
        cube[ONE][ZERO][ONE] = new CenterPiece(Color.YELLOW, Face.TOP);
        cube[ONE][TWO][ONE] = new CenterPiece(Color.ORANGE, Face.BOTTOM);
    }

    private void initializeCornerPieces(){
        ArrayList<Color> colors = new ArrayList<>();
        ArrayList<Face> faces = new ArrayList<>();

        //front top left
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.WHITE);

        faces.add(Face.FRONT);
        faces.add(Face.TOP);
        faces.add(Face.LEFT);

        cube[ZERO][ZERO][ZERO] = new CornerPiece(colors, faces);

        //front top right
        colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);

        faces = new ArrayList<>();
        faces.add(Face.FRONT);
        faces.add(Face.TOP);
        faces.add(Face.RIGHT);

        cube[TWO][ZERO][ZERO] = new CornerPiece(colors, faces);

        //front bottom left
        colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.WHITE);

        faces = new ArrayList<>();
        faces.add(Face.FRONT);
        faces.add(Face.BOTTOM);
        faces.add(Face.LEFT);

        cube[ZERO][TWO][ZERO] = new CornerPiece(colors, faces);

        //front bottom right
        colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);

        faces = new ArrayList<>();
        faces.add(Face.FRONT);
        faces.add(Face.BOTTOM);
        faces.add(Face.RIGHT);

        cube[TWO][TWO][ZERO] = new CornerPiece(colors, faces);

        //back top left
        colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.WHITE);

        faces = new ArrayList<>();
        faces.add(Face.BACK);
        faces.add(Face.TOP);
        faces.add(Face.LEFT);

        cube[ZERO][ZERO][TWO] = new CornerPiece(colors, faces);

        //back top right
        colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);

        faces = new ArrayList<>();
        faces.add(Face.BACK);
        faces.add(Face.TOP);
        faces.add(Face.RIGHT);

        cube[TWO][ZERO][TWO] = new CornerPiece(colors, faces);

        //back bottom left
        colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
        colors.add(Color.WHITE);

        faces = new ArrayList<>();
        faces.add(Face.BACK);
        faces.add(Face.BOTTOM);
        faces.add(Face.LEFT);

        cube[ZERO][TWO][TWO] = new CornerPiece(colors, faces);

        //back bottom right
        colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);

        faces = new ArrayList<>();
        faces.add(Face.BACK);
        faces.add(Face.BOTTOM);
        faces.add(Face.RIGHT);

        cube[TWO][TWO][TWO] = new CornerPiece(colors, faces);

    }

    private void initializeEdgePieces(){


        //front top
        ArrayList<Color> colors= new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        ArrayList<Face> faces = new ArrayList<>();
        faces.add(Face.FRONT);
        faces.add(Face.TOP);

        cube[ONE][ZERO][ZERO] = new EdgePiece(colors, faces);

        //front left
        colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.WHITE);

        faces = new ArrayList<>();
        faces.add(Face.FRONT);
        faces.add(Face.LEFT);

        cube[ZERO][ONE][ZERO] = new EdgePiece(colors, faces);

        //front right
        colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.BLUE);

        faces = new ArrayList<>();
        faces.add(Face.FRONT);
        faces.add(Face.RIGHT);
        cube[TWO][ONE][ZERO] = new EdgePiece(colors, faces);

        //front bottom
        colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.ORANGE);

        faces = new ArrayList<>();
        faces.add(Face.FRONT);
        faces.add(Face.BOTTOM);
        cube[ONE][TWO][ZERO] = new EdgePiece(colors, faces);

        //back top
        colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);

        faces = new ArrayList<>();
        faces.add(Face.BACK);
        faces.add(Face.TOP);
        cube[ONE][ZERO][TWO] = new EdgePiece(colors, faces);

        //back left
        colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.WHITE);

        faces = new ArrayList<>();
        faces.add(Face.BACK);
        faces.add(Face.LEFT);
        cube[ZERO][ONE][TWO] = new EdgePiece(colors, faces);

        //back right
        colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);

        faces = new ArrayList<>();
        faces.add(Face.BACK);
        faces.add(Face.RIGHT);
        cube[TWO][ONE][TWO] = new EdgePiece(colors, faces);

        //back bottom
        colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);

        faces = new ArrayList<>();
        faces.add(Face.BACK);
        faces.add(Face.BOTTOM);
        cube[ONE][TWO][TWO] = new EdgePiece(colors, faces);


        //top left
        colors = new ArrayList<>();
        colors.add(Color.YELLOW);
        colors.add(Color.WHITE);

        faces = new ArrayList<>();
        faces.add(Face.TOP);
        faces.add(Face.LEFT);
        cube[ZERO][ZERO][ONE] = new EdgePiece(colors, faces);

        //top right
        colors = new ArrayList<>();
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);

        faces = new ArrayList<>();
        faces.add(Face.TOP);
        faces.add(Face.RIGHT);
        cube[TWO][ZERO][ONE] = new EdgePiece(colors, faces);

        //bottom left
        colors = new ArrayList<>();
        colors.add(Color.ORANGE);
        colors.add(Color.WHITE);

        faces = new ArrayList<>();
        faces.add(Face.BOTTOM);
        faces.add(Face.LEFT);
        cube[ZERO][TWO][ONE] = new EdgePiece(colors, faces);

        //bottom right
        colors = new ArrayList<>();
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);

        faces = new ArrayList<>();
        faces.add(Face.BOTTOM);
        faces.add(Face.RIGHT);
        cube[TWO][TWO][ONE] = new EdgePiece(colors, faces);

    }

    private void printPiece(Face face, Piece piece) {
        //get color for the face of the piece
        Color color = piece.getColorForFace(face);
        //get the char of that color
        char c = color.getCharacter();
        //print that char
        System.out.print(c + " ");
    }

    private void printLeftTopRight(){
        for (int k = 2; k >= 0; k--) {
            for (int j = 2; j >= 0; j--) {
                printPiece(Face.LEFT, cube[ZERO][j][k]);

            }
            for (int i = 0; i < 3; i++) {
                printPiece(Face.TOP, cube[i][ZERO][k]);
            }
            for (int j = 0; j < 3; j++) {
                printPiece(Face.RIGHT, cube[TWO][j][k]);

            }
            System.out.println();

        }
    }

    private void printBottomFace(){
        int j = TWO;
        for (int k = 0; k < 3; k++) {
            System.out.print("      ");
            for (int i = 0; i < 3; i++) {
                printPiece(Face.BOTTOM, cube[i][j][k]);
            }
            System.out.println();
        }
    }

    private void printBackFace(){
        int k = TWO;
        for (int j = 2; j >= 0 ; j--) {
            System.out.print("      ");

            for (int i = 0; i < 3; i++) {
                printPiece(Face.BACK, cube[i][j][k]);
            }
            System.out.println();
        }
    }

    private void printFrontFace(){
        int k = ZERO;
        for (int j = 0; j < 3; j++) {
            System.out.print("      ");

            for (int i = 0; i < 3; i++) {
                printPiece(Face.FRONT, cube[i][j][k]);
            }
            System.out.println();
        }
    }

    private void rotateCapFace(Face face, Direction direction){
        int j;
        if(face == Face.TOP){
            j = ZERO;
        }
        else {
            j = TWO;
        }

        Piece[][][] cubeCopy = getCubeCopy();
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                Piece piece = cubeCopy[i][j][k];

                if(direction == Direction.FORWARD){
                    cube[k][j][2-i] = piece;
                    piece.updateFaces(true, face);
                }
                else {
                    cube[2-k][j][i] = piece;
                    piece.updateFaces(false, face);
                }


            }
        }

    }

    private void rotateVerticalFace(Face face, Direction direction){
        int k;
        if(face == Face.FRONT){
            k = ZERO;
        }
        else {
            k = TWO;
        }

        Piece[][][] cubeCopy = getCubeCopy();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Piece piece = cubeCopy[i][j][k];

                if(direction == Direction.FORWARD){
                    cube[2-j][i][k] = piece;
                    piece.updateFaces(true, face);
                }
                else{
                    cube[j][2-i][k] = piece;
                    piece.updateFaces(false, face);
                }

            }
        }
    }

    private void rotateSideFace(Face face, Direction direction){
        int i;
        if(face == Face.LEFT){
            i = ZERO;
        }
        else {
            i = TWO;
        }

        Piece[][][] cubeCopy = getCubeCopy();
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                Piece piece = cubeCopy[i][j][k];

                if(direction == Direction.FORWARD){
                    cube[i][2-k][j] = piece;
                    piece.updateFaces(true, face);
                }
                else {
                    cube[i][k][2-j] = piece;
                    piece.updateFaces(false, face);
                }


            }
        }
    }

    public Piece[][][] getCubeCopy(){
        Piece[][][] cubeCopy = new Piece[3][3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cubeCopy[i][j][k] = cube[i][j][k];
                }
            }
        }
        return cubeCopy;
    }


}
