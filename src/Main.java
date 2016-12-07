/**
 * Created by alexlucas on 30/11/2016.
 */
public class Main {
    public static void main(String[] args) {
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
