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

    /**
     * Returns the FaceClass corresponds to this face
     *
     * @return FaceClass corresponding to the given face
     *
     */
    public FaceClass getFaceClass() {
        return faceClass;
    }

    /**
     * Returns the affected faces by a rotation of this face
     *
     * @return ArrayList of Faces that touch this face
     *
     */
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

    /**
     * Returns the i bounds for this face
     * If the face is a Side Face, then the i bounds should not change
     * otherwise they should go as normal from 0 to 2
     *
     * @return an int[] the first element of which is the lower i bound and
     * the second element of which is the upper i bound
     *
     */
    public int[] getIBounds(){
        if(faceClass == FaceClass.SIDE){
            return new int[]{setIndex, setIndex};
        }
        else{
            return new int[]{0, 2};
        }
    }
    /**
     * Returns the j bounds for this face
     * If the face is a Cap Face, then the j bounds should not change
     * otherwise they should go as normal from 0 to 2
     *
     * @return an int[] the first element of which is the lower j bound and
     * the second element of which is the upper j bound
     *
     */
    public int[] getJBounds(){
        if(faceClass == FaceClass.CAP){
            return new int[]{setIndex, setIndex};
        }
        else{
            return new int[]{0, 2};
        }
    }
    /**
     * Returns the k bounds for this face
     * If the face is a Vertical Face, then the k bounds should not change
     * otherwise they should go as normal from 0 to 2
     *
     * @return an int[] the first element of which is the lower k bound and
     * the second element of which is the upper k bound
     *
     */
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
