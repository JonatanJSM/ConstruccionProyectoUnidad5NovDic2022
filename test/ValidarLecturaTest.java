/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Utils.ValidarLectura;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fer98
 */
public class ValidarLecturaTest {
    private String path = "C:\\Users\\fer98\\Documents\\NetBeansProjects\\validacionJSON\\src\\validacionjson\\json2.txt";
    
    public ValidarLecturaTest() {
    }

    @Test
    public void testReadJSON() {
        ValidarLectura validacionJSON = new ValidarLectura();
        Object obj = validacionJSON.readJSON(path);
        System.out.println(obj);
        assertFalse(obj == null);
    }
    
    @Test
    public void testExtractJSONObject() {
        ValidarLectura validacionJSON = new ValidarLectura();
        JSONObject jsonObject = validacionJSON.extractJSONObject(validacionJSON.readJSON(path));
        System.out.println(jsonObject);
        assertFalse(jsonObject == null);
    }
    
    @Test
    public void testExtractJSONObjectbyKey() {
        ValidarLectura validacionJSON = new ValidarLectura();
        JSONObject employeeObject = new JSONObject();
        employeeObject = validacionJSON.extractJSONObjectbyKey(validacionJSON.extractJSONObject(validacionJSON.readJSON(path)), "employees");
        System.out.println(employeeObject);
        assertFalse(employeeObject == null);
    }
    
    @Test
    public void testExtractEmployeeJSONArray() {
        ValidarLectura validacionJSON = new ValidarLectura();
        JSONObject employeeObject = validacionJSON.extractJSONObjectbyKey(validacionJSON.extractJSONObject(validacionJSON.readJSON(path)), "employees");
        JSONArray employeeArray = validacionJSON.extractEmployeeJSONArray(employeeObject, "employee");
        System.out.println(employeeArray); 
        assertFalse(employeeArray == null);
    }
}
