package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class modificadorEmployee {
    int idEmployee = 1;
    String firstName = "Jon";
    String lastName= "Santana";
    String photo="felix.png";

    public void modi(JSONArray jsonEmployees){
        try{
                JSONObject tempEmployee = (JSONObject) jsonEmployees.get(idEmployee);
                System.out.println("Antes: "+tempEmployee);
                tempEmployee.replace("firstName",firstName);
                System.out.println("Despues: "+tempEmployee);
                System.out.println("Arreglo modificado: "+jsonEmployees);
                //Employee newEmployee = new Employee(Integer.parseInt(tempEmployee.get("id").toString()),
                    //    tempEmployee.get("firstName").toString(),
                  //      tempEmployee.get("lastName").toString(),
                //        tempEmployee.get("photo").toString()
                //);
                //System.out.println(arrayEmployee.get(i).toString());
        }catch(NullPointerException e){
        }
    }


}
