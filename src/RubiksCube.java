
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

    public void showCube(){ //because it prints

        printBottomFace();
        printBackFace();
        printLeftTopRight();
        printFrontFace();

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

    private void printLeftTopRight(){
        for (int k = 2; k >= 0; k--) {
            for (int j = 2; j >= 0; j--) {
                cube[ZERO][j][k].printPiece(Face.LEFT);

            }
            for (int i = 0; i < 3; i++) {
                cube[i][ZERO][k].printPiece(Face.TOP);
            }
            for (int j = 0; j < 3; j++) {
                cube[TWO][j][k].printPiece(Face.RIGHT);

            }
            System.out.println();

        }
    }

    private void printBottomFace(){
        int j = TWO;
        for (int k = 0; k < 3; k++) {
            System.out.print("      ");
            for (int i = 0; i < 3; i++) {
                cube[i][j][k].printPiece(Face.BOTTOM);
            }
            System.out.println();
        }
    }

    private void printBackFace(){
        int k = TWO;
        for (int j = 2; j >= 0 ; j--) {
            System.out.print("      ");

            for (int i = 0; i < 3; i++) {
                cube[i][j][k].printPiece(Face.BACK);
            }
            System.out.println();
        }
    }

    private void printFrontFace(){
        int k = ZERO;
        for (int j = 0; j < 3; j++) {
            System.out.print("      ");

            for (int i = 0; i < 3; i++) {
                cube[i][j][k].printPiece(Face.FRONT);
            }
            System.out.println();
        }
    }

    private int[] orderIndices(Face face, int i, int j, int k){
        int[] orderedIndices = new int[2];

        switch (face.getFaceClass()){
            case CAP:
                orderedIndices = new int[]{k, j,2-i};
                break;
            case VERTICAL:
                orderedIndices = new int[]{2-j, i, k};
                break;
            case SIDE:
                orderedIndices = new int[]{i, 2-k, j};
                break;
        }

        return orderedIndices;
    }

    private void rotateFace(Face face){
        int[] indices;
        Piece[][][] cubeCopy = getCubeCopy();

        int[] iBounds = face.getIBounds();
        int[] jBounds = face.getJBounds();
        int[] kBounds = face.getKBounds();

        for (int i = iBounds[0]; i <= iBounds[1]; i++) {
            for (int j = jBounds[0]; j <= jBounds[1]; j++) {
                for (int k = kBounds[0]; k <= kBounds[1]; k++) {
                    indices = orderIndices(face, i, j, k);
                    Piece piece = cubeCopy[i][j][k];

                    cube[indices[0]][indices[1]][indices[2]] = piece;
                    piece.updateFaces(true, face);

                }
            }
        }
    }

    public void rotateFace(Face face, Direction direction){
        if(direction == Direction.FORWARD){
            rotateFace(face);
        }
        else {
            for (int i = 0; i < 3; i++) {
                rotateFace(face);
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
