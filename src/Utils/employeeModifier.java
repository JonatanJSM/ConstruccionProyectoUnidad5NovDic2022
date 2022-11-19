package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class employeeModifier {
    public employeeModifier(){

    }

    public void modifyEmployee(JSONArray jsonEmployees,String[] elementsEmployee){
        try{
            JSONObject tempEmployee = (JSONObject) jsonEmployees.get(Integer.parseInt(elementsEmployee[0]));
            if(!elementsEmployee[1].isEmpty())
                tempEmployee.replace("firstName",elementsEmployee[1]);
            if(!elementsEmployee[2].isEmpty())
                tempEmployee.replace("lastName",elementsEmployee[2]);
            if(!elementsEmployee[3].isEmpty())
                tempEmployee.replace("photo",elementsEmployee[3]);
        }catch(NullPointerException | NumberFormatException e){
        }
    }
}
