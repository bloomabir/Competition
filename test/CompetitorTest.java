import static org.junit.Assert.*;


import org.junit.Test;


import competition_AA.*;
public class CompetitorTest {

    @Test
    public void testCompetitorCreation() {
        Competitor c1 = new Competitor("Ludo");
        assertEquals(0, c1.getNbPoints());
        assertEquals("Ludo", c1.getName());
    }

    @Test
    public void testAddingPositivePointsToCompetitor() throws AddingNegativePointsException {
        Competitor c1 = new Competitor("Ludo");
        c1.addPoints(3);
        assertEquals(3, c1.getNbPoints());
    }

    @Test(expected = AddingNegativePointsException.class)
    public void shouldThrowExceptionWhenAddingNegativePointsToCompetitor() throws AddingNegativePointsException{
        Competitor c1 = new Competitor("Ludo");
        c1.addPoints(-3);
    }

    @Test
    public void compareTest() {
        Competitor c1 = new Competitor("Ludo");
        Competitor c2 = new Competitor("Ludo");
        Competitor c3 = new Competitor("Abir");
        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
        assertFalse(c2.equals(c3));
    }


    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(CompetitorTest.class);
    }

}
