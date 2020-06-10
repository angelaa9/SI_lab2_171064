import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class SILab2Test {

    private List<String> createList(String... list) {

        return new ArrayList<>(Arrays.asList(list));
    }

    @Test
    void EveryBranchTest() {
        IllegalArgumentException ex;

        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(null));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));

        assertEquals("#, #, #, #, #", SILab2.function(createList("#, #, #, #, #")));
        assertEquals("#, 2, #, 2, #", SILab2.function(createList("#, 0, #, 0, #")));

    }

    @Test
    void multipleConditionsTest() {
        //if (i - 1 >= 0 && list.get(i - 1).equals("#")) { //9
        //F && X 
        //T && F

	assertEquals("0,0,1", SILab2.function(createList("0,0,0,#")));
        assertEquals("0,0,1", SILab2.function(createList("0,0,0,#")));

        //if (i + 1 < list.size() && list.get(i + 1).equals("#")) { //12
        //F && X
        //T && F

	assertEquals("1,0,0", SILab2.function(createList("#,0,0,0")));
        assertEquals("1,0,0", SILab2.function(createList("#,0,0,0")));
    }
}
