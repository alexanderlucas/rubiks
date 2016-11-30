/**
 * Created by alexlucas on 30/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        RubiksCube rubiksCube = new RubiksCube();
        rubiksCube.showCube();
        rubiksCube.rotateFace(Face.TOP, Direction.CLOCKWISE);
        rubiksCube.showCube();
    }
}
