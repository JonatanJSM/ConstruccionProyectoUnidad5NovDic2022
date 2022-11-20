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
        System.out.println("Antes: "+ arrayJSONobject);
    }

    public void modifyEmployee(String[] elementsEmployee){
        try{
            int index = Integer.parseInt(elementsEmployee[0]);
            System.out.println("indice+ "+index);
            JSONObject tempEmployee = (JSONObject) arrayJSONobject.get(index-1);

            if(!elementsEmployee[1].isEmpty())
                tempEmployee.replace("firstName",elementsEmployee[1]);
            if(!elementsEmployee[2].isEmpty())
                tempEmployee.replace("lastName",elementsEmployee[2]);
            if(!elementsEmployee[3].isEmpty())
                tempEmployee.replace("photo",elementsEmployee[3]);

            System.out.println("Despues: "+ arrayJSONobject);
            updateJSONFile();
        }catch(NullPointerException | NumberFormatException e){
        }
    }

    private void updateJSONFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("json2.txt"));
            System.out.println("resultado es: "+jsonObject.toString());
            String x = jsonObject.toString();
            bw.write("");
            bw.write(x);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
