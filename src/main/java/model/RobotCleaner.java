package model;

import java.util.ResourceBundle;

public class RobotCleaner implements Device {

    private ResourceBundle bundle;
    private static String ROBOTCLEANER = "ROBOTCLEANER";
    private static String ON_MESSAGE = "ON_MESSAGE";
    private static String OFF_MESSAGE = "OFF_MESSAGE";
    private int numView = 1;

    public RobotCleaner() {
        bundle = ResourceBundle.getBundle("name");
    }

    public String printMessage() {
        String name = (String)bundle.getObject(ROBOTCLEANER);
        if(numView == 1){
            return name+" : "+(String)bundle.getObject(ON_MESSAGE);
        }
        return name+" : "+(String)bundle.getObject(OFF_MESSAGE);
    }

    public void setView(int numView) {
        this.numView = numView;
    }
}
