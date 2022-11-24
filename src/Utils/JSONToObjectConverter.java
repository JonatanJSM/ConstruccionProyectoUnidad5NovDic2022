package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class JSONToObjectConverter {
    private ArrayList<Employee> arrayEmployee = new ArrayList<>();
    public void convertJSONtoArray(JSONArray jsonEmployees){

        try{
            for(int i = 0; i < jsonEmployees.size(); i++){
                JSONObject tempEmployee = (JSONObject) jsonEmployees.get(i);
                Employee newEmployee = new Employee(Integer.parseInt(tempEmployee.get("id").toString()),
                        tempEmployee.get("firstName").toString(),
                        tempEmployee.get("lastName").toString(),
                        tempEmployee.get("photo").toString());
                arrayEmployee.add(newEmployee);
                //System.out.println(arrayEmployee.get(i).toString());
            }
        }catch(NullPointerException e){
            arrayEmployee.add(new NullEmployee());
        }
    }

    public void removeNullInstances(){
        for(Employee emp : arrayEmployee){
            if(emp.isNull()){
                arrayEmployee.remove(emp);
            }
        }
    }

    public ArrayList<Employee> getArrayEmployee() {
        return arrayEmployee;
    }

    public Iterator<Employee> getIterator(){
        return arrayEmployee.iterator();
    }
}
