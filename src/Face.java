import java.lang.reflect.Array;
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

    public ArrayList<Face> getAffectedFaces(){
        ArrayList<Face> affected = new ArrayList<>();
        switch(faceClass){
            case CAP:
                affected.add(BACK);
                affected.add(RIGHT);
                affected.add(FRONT);
                affected.add(LEFT);
                break;
            case SIDE:
                affected.add(TOP);
                affected.add(FRONT);
                affected.add(BOTTOM);
                affected.add(BACK);
                break;
            case VERTICAL:
                affected.add(TOP);
                affected.add(RIGHT);
                affected.add(BOTTOM);
                affected.add(LEFT);
                break;
        }
        return affected;
    }

    public enum FaceClass {
        VERTICAL,
        SIDE,
        CAP
    }
}
