package org.kiriienko.game;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class DotComTest extends TestCase {

    @Test
    public void testCheckYourselfHit() {
        DotCom dotCom = new DotCom();
        int[] locationCells = {2, 3, 4};
        dotCom.setLocationCells(locationCells);

        String result = dotCom.checkYourself("3");

        assertEquals("hit", result);
    }

    @Test
    public void testCheckYourselfMiss() {
        DotCom dotCom = new DotCom();
        int[] locationCells = {2, 3, 4};
        dotCom.setLocationCells(locationCells);

        String result = dotCom.checkYourself("7");

        assertEquals("miss", result);
    }

    @Test
    public void testCheckYourselfKill() {
        DotCom dotCom = new DotCom();
        int[] locationCells = {2, 3, 4};
        dotCom.setLocationCells(locationCells);

        dotCom.checkYourself("2");
        dotCom.checkYourself("3");
        String result = dotCom.checkYourself("4");

        assertEquals("kill", result);
    }
}