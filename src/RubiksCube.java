
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

    /**
     * Returns the Cube representation as a 3D array of Pieces
     *
     * @return  the cube
     */
    public Piece[][][] getCube(){
        return cube;
    }

    /**
     * Returns a cube object with all the Pieces of the cube in a
     * new 3D array
     *
     * @return  a copy of the cube
     */
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

    /**
     * Prints a representation of an unfolded cube to the console
     * with the following order of faces:
     *      Bottom
     *       Back
     *  Left Top Right
     *      Front
     *
     */
    public void showCube(){ //because it prints

        printBottomFace();
        printBackFace();
        printLeftTopRight();
        printFrontFace();

    }

    /**
     * Rotates the specified face in the given direction
     *
     * @param face a value of the enum Face, specifying the face to be rotated
     *
     * @param direction a value of the enum Direction specifying which direction
     *                  the face is to be rotated (FORWARD or BACKWARDS)
     *
     */
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

    /**
     * Initializes the center pieces at each face with default,
     * out of the package face and color
     *
     */
    private void initializeCenterPieces(){
        cube[ONE][ONE][ZERO] = new CenterPiece(Color.WHITE, Face.FRONT);
        cube[ONE][ONE][TWO] = new CenterPiece(Color.ORANGE, Face.BACK);
        cube[ONE][ZERO][ONE] = new CenterPiece(Color.RED, Face.TOP);
        cube[ONE][TWO][ONE] = new CenterPiece(Color.GREEN, Face.BOTTOM);
        cube[ZERO][ONE][ONE] = new CenterPiece(Color.YELLOW, Face.LEFT);
        cube[TWO][ONE][ONE] = new CenterPiece(Color.BLUE, Face.RIGHT);
    }

    /**
     * Initializes the corner pieces of the square
     *
     * There are 8 corner pieces and the count of the indices
     * of each count in binary from 0 to 7 with the 1's replaced
     * by 2's
     *
     *
     */
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

    /**
     * Initializes the edge pieces of the square
     *
     * There are 12 edge pieces, the indices of which are the odd
     * numbers from 1-25 (excluding 13) in ternary
     *
     */
    private void initializeEdgePieces(){

        //the indices of edge pieces are all the odd numbers 1-25 in ternary
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

    /**
     * Returns the faces for a piece at a given index i, j, k in the
     * cube
     *
     * if i is 0, the face is left and the color is yellow
     * if i is 2, the face is right and the color is blue
     * if j is 0, the face is top and the color is red
     * if j is 2, the face is bottom and the color is green
     * if k is 0, the face is front and the color is white
     * if k is 2, the face is back and the color is orange
     *
     * @param i the i index of the piece
     * @param j the j index of the piece
     * @param k the k index of the piece
     *
     * @return an ArrayList of Faces corresponding to the Colors at non-1 indices i, j, k
     */
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

    /**
     * Returns the colors for a piece at a given index i, j, k in the
     * cube
     *
     * if i is 0, the face is left and the color is yellow
     * if i is 2, the face is right and the color is blue
     * if j is 0, the face is top and the color is red
     * if j is 2, the face is bottom and the color is green
     * if k is 0, the face is front and the color is white
     * if k is 2, the face is back and the color is orange
     *
     * @param i the i index of the piece
     * @param j the j index of the piece
     * @param k the k index of the piece
     *
     * @return an ArrayList of Colors corresponding to the Faces at non-1 indices i, j, k
     */
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

    /**
     * Prints the left face, the top face, and the right face of the cube
     * one row at a time so the three faces are read left to right
     *
     */
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

    /**
     * Prints the bottom face of the cube preceded by 6 spaces so it is in line
     * with the top face in the printout
     *
     */
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

    /**
     * Prints the back face of the cube preceded by 6 spaces so it is in line
     * with the top face in the printout
     *
     */
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

    /**
     * Prints the front face of the cube preceded by 6 spaces so it is in line
     * with the top face in the printout
     *
     */
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

    /**
     * Returns an int array of the new indices for a forward rotation of a face from
     * given indices i, j, k
     *
     * @param face the face that is being rotated
     * @param i the i index of the piece that is being rotated
     * @param j the j index of the piece that is being rotated
     * @param k the k index of the piece that is being rotated
     *
     * @return int[] that reorders i, j, and k for the given face type and takes
     * the difference between the correct one and 2
     *
     */
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

    /**
     * Rotates given face clockwise
     *
     * @param face value of Face enum representing the face being rotated
     *
     */
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
