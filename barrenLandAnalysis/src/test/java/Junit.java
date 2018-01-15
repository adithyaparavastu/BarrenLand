/**
 * Created by adithya_paravastu on 1/12/18.
 */

import org.junit.Test;

import static org.junit.Assert.*;


public class Junit {

    AreaOfFertileLand test;

    @Test(timeout = 500)
    public void testZero() {

        test = new AreaOfFertileLand();
        String result = "116800 116800";
        String[] input = new String[] {"0 292 399 307"};

        test.sortedAreas(input);
        test.printOutput(input);

        assertEquals(result,test.printOutput(input));
    }

    @Test(timeout = 500)
    public void testOne() {

        test = new AreaOfFertileLand();
        String result = "22816 192608";
        String[] input = new String[] {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};

        test.sortedAreas(input);
        test.printOutput(input);

        assertEquals(result,test.printOutput(input));
    }
}
