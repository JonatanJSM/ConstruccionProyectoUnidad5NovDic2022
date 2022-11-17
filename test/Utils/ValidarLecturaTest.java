package Utils;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidarLecturaTest {
    private String path = "json2.txt";
    private static ValidarLectura validacionJSON;

    @BeforeEach
    public void setUp(){
        validacionJSON = new ValidarLectura();
    }

    @Test
    @DisplayName("Estructura general JSON incorrecta")
    public void testReadJSON(){
        System.out.println(" +Probando parseo general JSON");
        boolean obj = validacionJSON.readJSON(path);
        assertTrue(obj);
    }

    @Test
    @DisplayName("La llave employees no existe")
    public void testExtractJSONObjectbyKey(){
        System.out.println("+ Probando exitencia de employees");
        validacionJSON.readJSON(path);
        JSONObject employeeObject = new JSONObject();
        employeeObject = validacionJSON.extractJSONObjectbyKey("employees");
        assertFalse(employeeObject == null);
    }

    @Test
    @DisplayName("No existe arreglo employee")
    public void testExtractEmployeeJSONArray(){
        System.out.println("+ Probando exitencia arreglo de employee");
        validacionJSON.readJSON(path);
        JSONObject employeeObject = validacionJSON.extractJSONObjectbyKey("employees");

        boolean employeeArray = validacionJSON.extractEmployeeJSONArray(employeeObject, "employee");
        assertTrue(employeeArray);
    }

    @Test
    @DisplayName("No está correcta la información de algún elemento de employee")
    public void testValidateEmployee(){
        System.out.println("+ Probando exitencia de los atributos employees");
        validacionJSON.readJSON(path);
        JSONObject employeeObject = validacionJSON.extractJSONObjectbyKey("employees");
        validacionJSON.extractEmployeeJSONArray(employeeObject, "employee");

        boolean verificationResult = validacionJSON.extracEmployeeInfo();
        assertTrue(verificationResult);
    }

    @Test
    void readJSON() {
        boolean a = true;
        assertTrue(a);
    }
}