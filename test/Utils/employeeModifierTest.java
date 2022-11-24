package Utils;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class employeeModifierTest {
    private static ValidarLectura validacionJSON;
    private static employeeModifier employeeModifier;
    private String path = "json2.txt";

    @BeforeEach
    void setUp() {
        validacionJSON = new ValidarLectura();
        validacionJSON.readJSON(path);
        employeeModifier = new employeeModifier();
    }

    @Test
    @DisplayName("No es correcto el formato del ID")
    public void IdEmployee(){
        String camposAModificar[] = {"wo,","Pepito","Usumaki",""};
        boolean result = employeeModifier.modifyEmployee(camposAModificar);
        assertTrue(result);
    }

    @Test
    @DisplayName("No se hizo modificaciones en el JSON")
    public void testLongitudArray(){
        int lognntiudadAntes, longitudDespues;
        lognntiudadAntes = employeeModifier.getArrayJSONobject().toString().length();
        String camposAModificar[] = {"2","Job","",""};
        employeeModifier.modifyEmployee(camposAModificar);
        longitudDespues = employeeModifier.getArrayJSONobject().toString().length();
        assertFalse(lognntiudadAntes == longitudDespues);
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
    @DisplayName("Longitud no es la adecuada")
    public void IdEmployeeSize(){
        String camposAModificar[] = {"10","","cruise",""};
        boolean result = employeeModifier.modifyEmployee(camposAModificar);
        assertTrue(result);
    }
}
