package model;
import java.util.ResourceBundle;

public class Bulb implements Device {

    private ResourceBundle bundle;
    private static String BULB = "BULB";
    private static String ON_MESSAGE = "ON_MESSAGE";
    private static String OFF_MESSAGE = "OFF_MESSAGE";
    private int numView = 1;

    public Bulb() {
        bundle = ResourceBundle.getBundle("name");
    }

    public String printMessage() {
        String name = (String)bundle.getObject(BULB);
        if(numView == 1){
            return name+" : "+(String)bundle.getObject(ON_MESSAGE);
        }
        return name+" : "+(String)bundle.getObject(OFF_MESSAGE);
    }

    public void setView(int numView) {
        this.numView = numView;
    }
}
