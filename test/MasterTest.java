import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competition_AA.AddingNegativePointsException;
import competition_AA.Competitor;
import competition_AA.Master;
import competition_AA.Match;
import competition_AA.NotEnoughCompetitorsException;
import competition_AA.NotGoodSizeForTournamentException;
import competition_AA.Tournament;
import competition_AA.ClassicStrategy;

public class MasterTest {

	@Test
	public void testMasterCreation() {
		Competitor c1 = new Competitor("Ayoub");
		List<Competitor> lcompetitors = new ArrayList<>();
		ClassicStrategy cS = new ClassicStrategy(lcompetitors);
		Master master = new Master(lcompetitors);
		master.setStrategy(cS);
		assertFalse(null, master.getStrategy());
	}


	@Test
	public void testMasterPlayALeagueAndATournament()
			 {
		Competitor c1 = new Competitor("Ayoub");
		Competitor c2 = new Competitor("Drift");
		Competitor c3 = new Competitor("Lynx");
		Competitor c4 = new Competitor("Abir");
		List<Competitor> lcompetitors = new ArrayList<>();
		lcompetitors.add(c1);
		lcompetitors.add(c2);
		lcompetitors.add(c3);
		lcompetitors.add(c4);
		Master master = new Master(lcompetitors);
		MockLeague mockLeague = new MockLeague(lcompetitors);
		MockTournament mockTournament = new MockTournament(null);
		ClassicStrategy cS = new ClassicStrategy(lcompetitors);
		master.setStrategy(cs);
		master.play();
		assertTrue(mockLeague.getCount() == 1 && mockTournament.getCount() == 1);
	}
}

class MockLeague extends League{

	private int count;

	public MockLeague(List<Competitor> competitors) {
        super(competitors);
        count = 0;
    }

	public int getCount() {
		return count;
	}

	public void play(){
		count++;
	}

}

class MockTournament extends Tournament{

	private int count;

	public MockTournament(List<Competitor> competitors) {
        super(competitors);
        count = 0;
    }

	public int getCount() {
		return count;
	}

	public void play(){
		count++;
	}

}
