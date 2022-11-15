package Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author fer98
 */
public class ValidarLectura {
    private Object readResult;
    private JSONObject jsonObject;
    private JSONArray arrayJSONobject;
    
    
    public boolean readJSON(String pathToJSONFile){
        try{
            FileReader reader = new FileReader(pathToJSONFile);
            JSONParser jsonParser = new JSONParser();
            readResult = jsonParser.parse(reader);
            jsonObject = extractJSONObject(readResult);
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }catch(IOException e){
            e.printStackTrace();
        }catch(ParseException e){
            System.out.println("Estructura del JSON incorrecta\n");
            return false;
        }
        return true;
    }
    
    private JSONObject extractJSONObject(Object obj){
        JSONObject jsonObj = null;
        try{
            jsonObj  = new JSONObject((Map) obj);
        }catch(Exception e){
        }
        return jsonObj;
    }
    
    public JSONObject extractJSONObjectbyKey(String key){
        JSONObject employeeObject = new JSONObject();
        employeeObject = (JSONObject) jsonObject.get(key);
        try{
            JSONObject arr = (JSONObject) employeeObject.get(key);
        }catch(Exception e){
            System.out.println("No esta definido "+key+" en el archivo JSON\n");
        }
        return employeeObject;
    }
    
    public boolean extractEmployeeJSONArray(JSONObject jsonObj, String arrayName){
        JSONArray jsonArray = new JSONArray();
        jsonArray = (JSONArray) jsonObj.get(arrayName);
        try{
            jsonArray.isEmpty();
            arrayJSONobject = jsonArray;
        }catch(Exception e){
            System.out.println("No esta difnido "+arrayName+" como arreglo en el JSON");
            return false;
        }
        return true;
    }
    
    public boolean extracEmployeeInfo(){
        JSONArray employeeList = arrayJSONobject;
        int i = 0; boolean result=true;
        for (Object exployye: employeeList) {
            JSONObject auxEmployee = (JSONObject) exployye;
            if(!validateEmployee(auxEmployee)){
                i++;
                System.out.print("Algun atributo del empleado "+ i+" es incorrecto");
                result = false;
                break;
            }
            i++;
        }
        return result;
    }
    
    private boolean validateEmployee(JSONObject employee){
        return !(!employee.containsKey("id") || !employee.containsKey("firstName") || !employee.containsKey("lastName") || !employee.containsKey("photo"));
    }
    
}
