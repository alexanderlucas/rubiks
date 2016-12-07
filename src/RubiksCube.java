
import java.util.ArrayList;


/**
 * Created by alexlucas on 29/11/2016.
 */
public class RubiksCube {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    private Color[] colorValues = Color.values();
    private Face[] faceValues = Face.values();


    Piece[][][] cube = new Piece[3][3][3];

    public RubiksCube(){

        initializeCenterPieces();
        initializeCornerPieces();
        initializeEdgePieces();

    }



    public Piece[][][] getCube(){
        return cube;
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

    public void showCube(){ //because it prints

        printBottomFace();
        printBackFace();
        printLeftTopRight();
        printFrontFace();

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

    private void initializeCenterPieces(){
        cube[ONE][ONE][ZERO] = new CenterPiece(Color.WHITE, Face.FRONT);
        cube[ONE][ONE][TWO] = new CenterPiece(Color.ORANGE, Face.BACK);
        cube[ONE][ZERO][ONE] = new CenterPiece(Color.RED, Face.TOP);
        cube[ONE][TWO][ONE] = new CenterPiece(Color.GREEN, Face.BOTTOM);
        cube[ZERO][ONE][ONE] = new CenterPiece(Color.YELLOW, Face.LEFT);
        cube[TWO][ONE][ONE] = new CenterPiece(Color.BLUE, Face.RIGHT);
    }

    private void initializeCornerPieces(){

        for (int l = 0; l < 8; l++) {
            int i =((l/4)%2) * 2;
            int j =((l/2)%2) * 2;
            int k =(l%2) * 2;

            ArrayList<Color> colors = getColors(i, j, k);
            ArrayList<Face> faces = getFaces(i, j, k);

            cube[i][j][k] = new CornerPiece(colors, faces);
        }

    }

    private void initializeEdgePieces(){

        for (int l = 0; l < 13; l++) {
            int odd = l*2 + 1;

            int i =((odd/9)%3);
            int j =((odd/3)%3);
            int k =(odd%3);

            if(odd != 13){
                System.out.println(i+""+j+""+k);
                ArrayList<Color> colors = getColors(i, j, k);
                ArrayList<Face> faces = getFaces(i, j, k);
                cube[i][j][k] = new EdgePiece(colors, faces);

            }

        }
    }

    private ArrayList<Face> getFaces(int i, int j, int k){
        Face[] faceValues = Face.values();

        ArrayList<Face> faces = new ArrayList<>();

        if (i != 1) {
            faces.add(faceValues[i/2 + 2]);
        }
        if(j != 1){
            faces.add(faceValues[j/2]);
        }
        if(k != 1){
            faces.add(faceValues[k/2 + 4]);
        }

        return faces;
    }

    private ArrayList<Color> getColors(int i, int j, int k){
        Color[] colorValues = Color.values();

        ArrayList<Color> colors = new ArrayList<>();
        if(i != 1){
            colors.add(colorValues[i/2 + 2]);
        }
        if(j != 1){
            colors.add(colorValues[j/2]);
        }
        if(k != 1){
            colors.add(colorValues[k/2 + 4]);
        }

        return colors;
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
                    piece.updateFaces(face);

                }
            }
        }
    }



}
