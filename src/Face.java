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
    private final Face left;
    private final Face right;

    Face(FaceClass faceClass, Face left, Face right) {
        this.faceClass = faceClass;
        this.left = left;
        this.right = right;
    }

    public FaceClass getFaceClass() {
        return faceClass;
    }

    public enum FaceClass {
        VERTICAL, SIDE, CAP
    }
}
