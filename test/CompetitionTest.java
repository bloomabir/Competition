import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competition_AA.*;

public class CompetitionTest {

	@Test
	public void testPlayMatchAddsPointsToTheWinner() throws AddingNegativePointsException {
		Competitor c1 = new Competitor("Ayoub");
		Competitor c2 = new Competitor("Abir");
		List<Competitor> lcompetitors = new ArrayList<>();
		lcompetitors.add(c1);
		lcompetitors.add(c2);
		MockCompetition comp = new MockCompetition(lcompetitors);
		int actualPoints = c1.getNbPoints();
		comp.playMatch(c1, c2);
		assertEquals(c1.getNbPoints(), actualPoints + 1);
		comp.playMatch(c1, c2);
		assertEquals(c1.getNbPoints(), actualPoints + 2);
	}

}
class MockCompetition extends Competition{

	public MockCompetition(List<Competitor> competitors) {
		super(competitors);
	}

	public void playMatch(Competitor c1,Competitor c2) throws AddingNegativePointsException{
		MockMatch m = new MockMatch(c1, c2);
        Competitor winner = m.getWinner();
        winner.addPoints(1);
	}


	public void play() throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException {

	}



}

class MockMatch extends Match{

	public MockMatch(Competitor c1, Competitor c2) {
		super(c1, c2);
	}

	public Competitor getWinner(){
		return getC1();
	}

}
