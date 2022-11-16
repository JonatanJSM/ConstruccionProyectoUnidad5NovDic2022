import Utils.ValidarLectura;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author fer98
 */
public class ValidarLecturaTest {
    private String path = "json2.txt";
    private static ValidarLectura validacionJSON;
    
    public ValidarLecturaTest() {
    }
    
    @Before
    public void setUp(){
        validacionJSON = new ValidarLectura();
    }

    @Test
    public void testReadJSON() {
        System.out.println(" +Probando parseo general JSON");
        boolean obj = validacionJSON.readJSON(path);
        assertTrue(obj);
    }
    
    @Test
    public void testExtractJSONObjectbyKey() {
        System.out.println("+ Probando exitencia de employees");
        validacionJSON.readJSON(path);
        
        JSONObject employeeObject = new JSONObject();
        employeeObject = validacionJSON.extractJSONObjectbyKey("employees");
        assertFalse(employeeObject == null);
    }
    
    @Test
    public void testExtractEmployeeJSONArray() {
        System.out.println("+ Probando exitencia arreglo de employee");
        validacionJSON.readJSON(path);
        JSONObject employeeObject = validacionJSON.extractJSONObjectbyKey("employees");
        
        boolean employeeArray = validacionJSON.extractEmployeeJSONArray(employeeObject, "employee"); 
        assertTrue(employeeArray);
    }
    
    @Test
    public void testValidateEmployye(){
        System.out.println("+ Probando exitencia de los atributos employees");
        validacionJSON.readJSON(path);
        JSONObject employeeObject = validacionJSON.extractJSONObjectbyKey("employees");
        validacionJSON.extractEmployeeJSONArray(employeeObject, "employee"); 
        
        boolean verificationResult = validacionJSON.extracEmployeeInfo();
        assertTrue(verificationResult);
    }
}
