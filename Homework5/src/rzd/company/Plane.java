package rzd.company;

public class Plane {
    private String planeName;
    private int planeNumber;

    public Plane(String planeName, Integer planeNumber) {
        this.planeName = planeName;
        this.planeNumber = planeNumber;
    }
    public String toString(){
        return planeNumber+ " " + planeName;

    }
//    public String getPlaneName() {
//        return planeName;
//    }
//
//    public int getPlaneNumber() {
//        return planeNumber;
//    }
}
