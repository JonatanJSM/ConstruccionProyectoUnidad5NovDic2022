package Utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class employeeEliminateTest {
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
    @DisplayName("No se ingresa un ID existente")
    public void IdEmployee(){
        int indice = 20;
        boolean result = employeeModifier.detelteEmployee(indice);
        assertTrue(result);
    }

    @Test
    @DisplayName("No se hizo modificaciones en el JSON")
    public void testLongitudArray(){
        int lognntiudadAntes, longitudDespues;
        lognntiudadAntes = employeeModifier.getArrayJSONobject().toString().length();

        int indice = 4;
        employeeModifier.detelteEmployee(indice);
        longitudDespues = employeeModifier.getArrayJSONobject().toString().length();

        assertFalse(lognntiudadAntes == longitudDespues);
    }

}
