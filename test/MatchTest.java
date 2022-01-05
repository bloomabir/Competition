import static org.junit.Assert.*;

import org.junit.Test;

import competition_AA.*;
import java.util.*;

public class MatchTest {


	@Test
	public void testMatchCreationAndGetters() {
		Competitor c1 = new Competitor("Ayoub");
		Competitor c2 = new Competitor("Abir");
		List<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(c1);
		competitors.add(c2);
		Match m1 = new Match(c1, c2);
		assertEquals(c1, m1.getC1());
		assertEquals(c2, m1.getC2());
	}

	@Test
    public void testAddingWinnerAndLooser() {
        Competitor c1 = new Competitor("Ludo");
        Competitor c2 = new Competitor("Abir");
        Match m = new Match(c1,c2);
        m.playMatch();
        assertTrue((m.getWinner()==c1 && m.getLooser()==c2) || (m.getWinner()==c2 && m.getLooser()==c1));
    }


	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MatchTest.class);
    }
}
