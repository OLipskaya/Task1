package action;

import model.Device;

public class MainAction {
    private String message = "error";

    public MainAction() {}

    public void loadClass(String className, int num) {
        try {
            Class device = Class.forName(className);
            if(!device.equals(null)){
                Object obj = device.newInstance();
                if(!(obj instanceof Device)){
                    throw new Exception("Сlass is not a device!");
                }
                ((Device) obj).setView(num);
                message = ((Device) obj).printMessage();
            }
        } catch(Exception e){
            System.out.println("Class not found!"+e.getMessage());
        }
    }

    public String getMessage() {
        return message;
    }
}
