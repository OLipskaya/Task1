package action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.DataBaseManager;

public class MainController {
    private MainForm form;
    private MainAction action;
    private DataBaseManager manager;
    private String message = "keyword not found";

    public MainController() {
        form = new MainForm();
        action = new MainAction();
        manager = new DataBaseManager();
    }

    public void parseJson(String input){
        input = input.replace(" ","");
        Gson gson = new GsonBuilder().create();
        form = gson.fromJson(input, MainForm.class);
    }

    public void start(){
        manager.start(form.getKey());
        String className = manager.getClassName();
        if(!className.equals("")){
            int num = 1;
            if(form.getView().equals("off")){ num = 2; }
            action.loadClass(className, num);
            String msg = action.getMessage();
            if(!msg.equals(null)){ message = msg; }
        }
    }

    public void setParametrs(String key, String view){
        form.setKey(key);
        form.setView(view);
    }

    public String getResultMessage(){
        return message;
    }
}
