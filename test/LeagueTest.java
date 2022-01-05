import static org.junit.Assert.*;

import java.util.*;
import java.util.List;

import org.junit.Test;
import competition_AA.*;

public class LeagueTest {

	@Test(expected=NotEnoughCompetitorsException.class)
	public void testPlayThrowsExceptionWhenNotEnoughCompetitors() throws NotEnoughCompetitorsException, AddingNegativePointsException{
		Competitor c1 = new Competitor("Ayoub");
		List<Competitor> lcompetitors = new ArrayList<>();
		lcompetitors.add(c1);
		League l1 = new League(lcompetitors);
		l1.play();
	}

	@Test
	public void testPlayDoesntThrowExceptionWhenEnoughCompetitors() throws NotEnoughCompetitorsException, AddingNegativePointsException{
		Competitor c1 = new Competitor("Ayoub");
		Competitor c2 = new Competitor("Abir");
		List<Competitor> lcompetitors = new ArrayList<>();
		lcompetitors.add(c1);
		lcompetitors.add(c2);
		League l1 = new League(lcompetitors);
		l1.play();
	}

	@Test
	public void testPlayCallsPlayMatchTwiceForTwoCompetitors() throws NotEnoughCompetitorsException, AddingNegativePointsException {
		Competitor c1 = new Competitor("Ayoub");
		Competitor c2 = new Competitor("Abir");
		List<Competitor> lcompetitors = new ArrayList<>();
		lcompetitors.add(c1);
		lcompetitors.add(c2);
		MockLeague mockL = new MockLeague(lcompetitors);
		mockL.play();
		assertEquals(2, mockL.playMatchCalled);
	}

	@Test
	public void testPlayCallsPlayMatchSixTimesForThreeCompetitors() throws NotEnoughCompetitorsException, AddingNegativePointsException {
		Competitor c1 = new Competitor("Ayoub");
		Competitor c2 = new Competitor("Abir");
		Competitor c3 = new Competitor("Apo");
		List<Competitor> lcompetitors = new ArrayList<>();
		lcompetitors.add(c1);
		lcompetitors.add(c2);
		lcompetitors.add(c3);
		MockLeague mockL = new MockLeague(lcompetitors);
		mockL.play();
		assertEquals(6, mockL.playMatchCalled);
	}
		
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(LeagueTest.class);
    }
}

class MockLeague extends League{
	public int playMatchCalled = 0;

	public MockLeague(List<Competitor> competitors) {
		super(competitors);
	}

	public void playMatch(Competitor c1,Competitor c2) {
		this.playMatchCalled ++;
	}
}
