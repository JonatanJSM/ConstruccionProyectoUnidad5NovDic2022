package test;

import Utils.ValidarLectura;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 * @author fer98
 */
public class ValidarLecturaTest {
    private String path = "json2.txt";
    private static ValidarLectura validacionJSON;
    
    public ValidarLecturaTest() {
    }
    
    @BeforeEach
    public void setUp(){
        validacionJSON = new ValidarLectura();
    }

    @Test
    @DisplayName("Estructura general JSON incorrecta")
    public void testReadJSON() {
        boolean obj = validacionJSON.readJSON(path);
        assertTrue(obj);
    }
    
    @Test
    @DisplayName("La llave employees no existe")
    public void testExtractJSONObjectbyKey() {
        validacionJSON.readJSON(path);
        
        JSONObject employeeObject = new JSONObject();
        employeeObject = validacionJSON.extractJSONObjectbyKey("employees");
        assertFalse(employeeObject == null);
    }
    
    @Test
    @DisplayName("No existe arreglo employee")
    public void testExtractEmployeeJSONArray() {
        validacionJSON.readJSON(path);
        JSONObject employeeObject = validacionJSON.extractJSONObjectbyKey("employees");
        
        boolean employeeArray = validacionJSON.extractEmployeeJSONArray(employeeObject, "employee"); 
        assertTrue(employeeArray);
    }
    
    @Test
    @DisplayName("No está correcta la información de algún elemento de employee")
    public void testValidateEmployye(){
        validacionJSON.readJSON(path);
        JSONObject employeeObject = validacionJSON.extractJSONObjectbyKey("employees");
        validacionJSON.extractEmployeeJSONArray(employeeObject, "employee"); 
        
        boolean verificationResult = validacionJSON.extracEmployeeInfo();
        assertTrue(verificationResult);
    }
}
