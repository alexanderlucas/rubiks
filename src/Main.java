/**
 * Created by alexlucas on 30/11/2016.
 */
public class Main {
    public static void main(String[] args) {
//        RubiksCube rubiksCube = new RubiksCube();
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.BOTTOM, Direction.FORWARD);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.BOTTOM, Direction.BACKWARDS);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.TOP, Direction.FORWARD);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.TOP, Direction.BACKWARDS);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.LEFT, Direction.FORWARD);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.LEFT, Direction.BACKWARDS);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.RIGHT, Direction.FORWARD);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.RIGHT, Direction.BACKWARDS);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.FRONT, Direction.FORWARD);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.FRONT, Direction.BACKWARDS);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.BACK, Direction.FORWARD);
//        rubiksCube.showCube();
//        rubiksCube.rotateFace(Face.BACK, Direction.BACKWARDS);
//        rubiksCube.showCube();
        stressTest();
    }

    public static void stressTest() {
        RubiksCube rubiksCube = new RubiksCube();

        for (int i = 0; i < 10000; i++) {
            Face face = Face.values()[(int)(Math.random()*6)];
            Direction direction = Direction.values()[(int)(Math.random()*2)];

            rubiksCube.rotateFace(face, direction);
            if(i%1000 == 0){
                rubiksCube.showCube();
                System.out.println();
            }
        }
    }
}
