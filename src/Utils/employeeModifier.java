package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class employeeModifier {
    private JSONArray arrayJSONobject;
    private JSONObject jsonObject;
    public employeeModifier(){
        ValidarLectura v = new ValidarLectura("json2.txt");
        arrayJSONobject = v.getArrayJSONobject();
        jsonObject = v.getJsonObject();
    }

    public boolean modifyEmployee(String[] elementsEmployee){
        try{
            if(elementsEmployee[0].isEmpty() || arrayJSONobject.size()<Integer.parseInt(elementsEmployee[0])){
                return false;
            }
            else {
                boolean result = false;
                int i = 0;
                while (i < arrayJSONobject.size()){
                    JSONObject tempEmployee = (JSONObject) arrayJSONobject.get(i);
                    int x = Integer.parseInt((String) tempEmployee.get("id"));
                    if(x == Integer.parseInt(elementsEmployee[0])){
                        if (!elementsEmployee[1].isEmpty())
                            tempEmployee.replace("firstName", elementsEmployee[1]);
                        if (!elementsEmployee[2].isEmpty())
                            tempEmployee.replace("lastName", elementsEmployee[2]);
                        if (!elementsEmployee[3].isEmpty())
                            tempEmployee.replace("photo", elementsEmployee[3]);
                        i = arrayJSONobject.size() + 2;
                        updateJSONFile();
                        result = true;
                    }
                    i++;
                }
                return result;
            }
        }catch(NullPointerException | NumberFormatException e){
            return false;
        }
    }

    public boolean detelteEmployee(int indexToDelete){
        boolean result = false;
        int i = 0;
        while (i < arrayJSONobject.size()){
            JSONObject tempEmployee = (JSONObject) arrayJSONobject.get(i);
            int x = Integer.parseInt((String) tempEmployee.get("id"));
            if(x == indexToDelete){
                arrayJSONobject.remove(i);
                updateJSONFile();
                result = true;
            }
            i++;
        }
        return result;
    }

    private void updateJSONFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("json2.txt"));
            //System.out.println("resultado es: "+jsonObject.toString());
            String x = jsonObject.toString();
            bw.write("");
            bw.write(x);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray getArrayJSONobject() {
        return arrayJSONobject;
    }
}
