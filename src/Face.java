import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexlucas on 29/11/2016.
 */


public enum Face {

    TOP(FaceClass.CAP),
    BOTTOM(FaceClass.CAP),
    LEFT(FaceClass.SIDE),
    RIGHT(FaceClass.SIDE),
    FRONT(FaceClass.VERTICAL),
    BACK(FaceClass.VERTICAL);

    private final FaceClass faceClass;

    Face(FaceClass faceClass) {
        this.faceClass = faceClass;
    }

    public FaceClass getFaceClass() {
        return faceClass;
    }

    public enum FaceClass {
        VERTICAL(new ArrayList(Arrays.asList(new Face[]{TOP, RIGHT, BOTTOM, LEFT}))),
        SIDE(new ArrayList(Arrays.asList(new Face[]{TOP, FRONT, BOTTOM, BACK}))),
        CAP(new ArrayList(Arrays.asList(new Face[]{BACK, RIGHT, FRONT, LEFT})));

        private final ArrayList<Face> affectedFaces;

        FaceClass(ArrayList faces){
            this.affectedFaces = faces;
        }
        public ArrayList<Face> getAffectedFaces(){
            return affectedFaces;
        }
    }
}
