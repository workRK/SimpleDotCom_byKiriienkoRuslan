package org.kiriienko.game;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DotComTest extends TestCase {

    @Test
    public void testCheckYourself_Hit() {
        DotCom dotCom = new DotCom();
        dotCom.setName("Pets.com");

        // Set up DotCom with a specific location
        ArrayList<String> location = new ArrayList<>();
        location.add("A0");
        location.add("A1");
        location.add("A2");
        dotCom.setLocationCells(location);

        // Perform a hit on the DotCom
        assertEquals("hit", dotCom.checkYourself("A1"));
        assertEquals(2, dotCom.getLocationCells().size());
    }

    @Test
    public void testCheckYourself_Kill() {
        DotCom dotCom = new DotCom();
        dotCom.setName("Pets.com");

        // Set up DotCom with a specific location
        ArrayList<String> location = new ArrayList<>();
        location.add("A0");
        location.add("A1");
        location.add("A2");
        dotCom.setLocationCells(location);

        // Perform a hit on the DotCom
        dotCom.checkYourself("A0");
        dotCom.checkYourself("A1");
        assertEquals("kill", dotCom.checkYourself("A2"));
        assertTrue(dotCom.getLocationCells().isEmpty());
    }
}