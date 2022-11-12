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
        Object obj = validacionJSON.readJSON(path);
        System.out.println(obj);
        assertFalse(obj == null);
    }
    
    @Test
    public void testExtractJSONObject() {
        JSONObject jsonObject = validacionJSON.extractJSONObject(validacionJSON.readJSON(path));
        System.out.println(jsonObject);
        assertFalse(jsonObject == null);
    }
    
    @Test
    public void testExtractJSONObjectbyKey() {
        JSONObject employeeObject = new JSONObject();
        employeeObject = validacionJSON.extractJSONObjectbyKey(validacionJSON.extractJSONObject(validacionJSON.readJSON(path)), "employees");
        System.out.println(employeeObject);
        assertFalse(employeeObject == null);
    }
    
    @Test
    public void testExtractEmployeeJSONArray() {
        JSONObject employeeObject = validacionJSON.extractJSONObjectbyKey(validacionJSON.extractJSONObject(validacionJSON.readJSON(path)), "employees");
        JSONArray employeeArray = validacionJSON.extractEmployeeJSONArray(employeeObject, "employee");
        System.out.println(employeeArray); 
        assertFalse(employeeArray == null);
    }
}
