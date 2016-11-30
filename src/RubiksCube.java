import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

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
        //make center pieces
        //make corner pieces
        //make edge pieces

        initializeCenterPieces();
        initializeCornerPieces();
        initializeEdgePieces();

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
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);

        faces.add(Face.FRONT);
        faces.add(Face.TOP);
        faces.add(Face.RIGHT);

        cube[TWO][ZERO][ZERO] = new CornerPiece(colors, faces);

        //front bottom left
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.WHITE);

        faces.add(Face.FRONT);
        faces.add(Face.BOTTOM);
        faces.add(Face.LEFT);

        cube[ZERO][TWO][ZERO] = new CornerPiece(colors, faces);

        //front bottom right
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);

        faces.add(Face.FRONT);
        faces.add(Face.BOTTOM);
        faces.add(Face.RIGHT);

        cube[TWO][TWO][ZERO] = new CornerPiece(colors, faces);

        //back top left
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.WHITE);

        faces.add(Face.BACK);
        faces.add(Face.TOP);
        faces.add(Face.LEFT);

        cube[ZERO][ZERO][TWO] = new CornerPiece(colors, faces);

        //back top right
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);

        faces.add(Face.BACK);
        faces.add(Face.TOP);
        faces.add(Face.RIGHT);

        cube[TWO][ZERO][TWO] = new CornerPiece(colors, faces);

        //back bottom left
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
        colors.add(Color.WHITE);

        faces.add(Face.BACK);
        faces.add(Face.BOTTOM);
        faces.add(Face.LEFT);

        cube[ZERO][TWO][TWO] = new CornerPiece(colors, faces);

        //back bottom right
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
        colors.add(Color.BLUE);

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

    private void printVerticalFace(Face face){
        int k;
        switch (face){
            case FRONT:
                k = ZERO;
            case BACK:
                k = TWO;
            default:
                k = -1;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Piece piece = cube[i][j][k];
                //get color for the face of the piece
                Color color = piece.getColorForFace(face);
                //get the char of that color
                char c = color.getCharacter();
                //print that char
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void showCube(){
        System.out.println("Front");
        //print front face
        printVerticalFace(Face.FRONT);

        System.out.println("Right");
        //print right face

        System.out.println("Back");
        //print back face

        System.out.println("Left");
        //print left face

        System.out.println("Top");
        //print top face

        System.out.println("Bottom");
        //print bottom face
    }


}
