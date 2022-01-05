import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import competition_AA.*;


public class TournamentTest {

	@Test(expected=NotEnoughCompetitorsException.class)
	public void testPlayThrowsExceptionWhenNotEnoughCompetitors() throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException{
		Competitor c1 = new Competitor("Ayoub");
		List<Competitor> lcompetitors = new ArrayList<>();
		lcompetitors.add(c1);
		Tournament tournoi = new Tournament(lcompetitors);
		tournoi.play();
	}

	@Test(expected=NotGoodSizeForTournamentException.class)
	public void testPlayThrowsExceptionWhenNumberOfCompetitorsIsNotAPowerOfTwo() throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException{
		Competitor c1 = new Competitor("Ayoub");
		Competitor c2 = new Competitor("Drift");
		Competitor c3 = new Competitor("Lynx");
		List<Competitor> lcompetitors = new ArrayList<>();
		lcompetitors.add(c1);
		lcompetitors.add(c2);
		lcompetitors.add(c3);
		Tournament tournoi = new Tournament(lcompetitors);
		tournoi.play();
	}

	@Test
	public void testPlayDeosntThrowsExceptionWhenNumberOfCompetitorsIsAPowerOfTwoAndBiggerThanOne() throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException{
		Competitor c1 = new Competitor("Ayoub");
		Competitor c2 = new Competitor("Drift");
		Competitor c3 = new Competitor("Lynx");
		Competitor c4 = new Competitor("Abir");
		List<Competitor> lcompetitors = new ArrayList<>();
		lcompetitors.add(c1);
		lcompetitors.add(c2);
		lcompetitors.add(c3);
		lcompetitors.add(c4);
		Tournament tournoi = new Tournament(lcompetitors);
		tournoi.play();
	}

	@Test
    public void testPlayMatchOneOfTheCompetitorGetsEliminated() throws AddingNegativePointsException {
        Competitor c1 = new Competitor("Ayoub");
        Competitor c2 = new Competitor("Abir");
        List<Competitor> lcompetitors = new ArrayList<>();
        lcompetitors.add(c1);
        lcompetitors.add(c2);
        Tournament t1 = new Tournament(lcompetitors);
        t1.playMatch(c1, c2);
        List<Competitor> winnersAfter = t1.getWinners();
        assertTrue((winnersAfter.contains(c1) == false && winnersAfter.contains(c2))||(winnersAfter.contains(c2) == false && winnersAfter.contains(c1)));
    }

	@Test
	public void testAtTheEndOfPlayWeOnlyHaveTheWinnerInTheList() throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException{
		Competitor c1 = new Competitor("Ayoub");
		Competitor c2 = new Competitor("Drift");
		Competitor c3 = new Competitor("Lynx");
		Competitor c4 = new Competitor("Abir");
		List<Competitor> lcompetitors = new ArrayList<>();
		lcompetitors.add(c1);
		lcompetitors.add(c2);
		lcompetitors.add(c3);
		lcompetitors.add(c4);
		Tournament tournoi = new Tournament(lcompetitors);
		List<Competitor> winnersBefore = tournoi.getWinners();
		assertEquals(4, winnersBefore.size());
		tournoi.play();
		List<Competitor> winnersAfter = tournoi.getWinners();
		assertEquals(1, winnersAfter.size());
	}
}
