package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONToObjectConverterTest {
    private String path = "json2.txt";
    private static ValidarLectura validacionJSON;
    private static JSONObject employeesJSONObject;
    private static JSONArray employeesJSONArray;
    private static JSONToObjectConverter converter;

    @BeforeEach
    void setUp() {
        validacionJSON = new ValidarLectura();
        validacionJSON.readJSON(path);
        employeesJSONObject = validacionJSON.extractJSONObjectbyKey("employees");
        validacionJSON.extractEmployeeJSONArray(employeesJSONObject, "employee");
        converter = new JSONToObjectConverter();
    }

    @Test
    @DisplayName("Probando conversión de array JSON a array Employee")
    public void testConvertJSONtoArray(){

        boolean allAreEmployee = true;
        converter.convertJSONtoArray(validacionJSON.getArrayJSONobject());
        //converter.getArrayEmployee().add(new NullEmployee());
        for (Employee emp : converter.getArrayEmployee())
        {
            allAreEmployee = emp.getClass().getName().equals(Employee.class.getName());
            if(!allAreEmployee){
                break;
            }
        }
        assertTrue(allAreEmployee, "Algún objeto del array no es de tipo Employee");
    }
}