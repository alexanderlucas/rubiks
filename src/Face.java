import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexlucas on 29/11/2016.
 */


public enum Face {

    TOP(FaceClass.CAP, 0),
    BOTTOM(FaceClass.CAP, 2),
    LEFT(FaceClass.SIDE, 0),
    RIGHT(FaceClass.SIDE, 2),
    FRONT(FaceClass.VERTICAL, 0),
    BACK(FaceClass.VERTICAL, 2);

    private final FaceClass faceClass;
    private final int setIndex;


    Face(FaceClass faceClass, int setIndex) {
        this.faceClass = faceClass;
        this.setIndex = setIndex;

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
    
    public int[] getIBounds(){
        if(faceClass == FaceClass.SIDE){
            return new int[]{setIndex, setIndex};
        }
        else{
            return new int[]{0, 2};
        }
    }
    public int[] getJBounds(){
        if(faceClass == FaceClass.CAP){
            return new int[]{setIndex, setIndex};
        }
        else{
            return new int[]{0, 2};
        }
    }
    public int[] getKBounds(){
        if(faceClass == FaceClass.VERTICAL){
            return new int[]{setIndex, setIndex};
        }
        else{
            return new int[]{0, 2};
        }
    }



    public enum FaceClass {
        VERTICAL,
        SIDE,
        CAP
    }
}
