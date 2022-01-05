package competition_AA;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException {

		Competitor c1 = new Competitor("Blastoff");
		Competitor c2 = new Competitor("Drift");
		Competitor c3 = new Competitor("Lynx");
		Competitor c4 = new Competitor("Catalyst");
		Competitor c5 = new Competitor("Raven");
		Competitor c6 = new Competitor("Midas");

		List<Competitor> competitors = new ArrayList<Competitor>();

		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		competitors.add(c5);
		competitors.add(c6);
		
		Journaliste j1 = new Journaliste("KAMILI");
		Bookmaker b1 = new Bookmaker("BEZZAZI", competitors);

		System.out.println("***League***");
		League league = new League(competitors,j1,b1);
		

		league.play();

		c1 = new Competitor("Blastoff");
		c2 = new Competitor("Drift");
		c3 = new Competitor("Lynx");
		c4 = new Competitor("Catalyst");
		c5 = new Competitor("Raven");
		c6 = new Competitor("Midas");
		Competitor c7 = new Competitor("Ayoub");
		Competitor c8 = new Competitor("Abir");

		competitors = new ArrayList<Competitor>();

		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		competitors.add(c5);
		competitors.add(c6);
		competitors.add(c7);
		competitors.add(c8);
		
		j1 = new Journaliste("KAMILI");
		b1 = new Bookmaker("BEZZAZI", competitors);

		System.out.println("***Tournament***");
		Tournament tournament = new Tournament(competitors,j1,b1);
		
		
		tournament.play();

		c1 = new Competitor("Blastoff");
		c2 = new Competitor("Drift");
		c3 = new Competitor("Lynx");
		c4 = new Competitor("Catalyst");
		c5 = new Competitor("Raven");
		c6 = new Competitor("Midas");
		c7 = new Competitor("Ayoub");
		c8 = new Competitor("Abir");

		competitors = new ArrayList<Competitor>();

		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		competitors.add(c5);
		competitors.add(c6);
		competitors.add(c7);
		competitors.add(c8);
		
		j1 = new Journaliste("KAMILI");
		b1 = new Bookmaker("BEZZAZI", competitors);

		System.out.println("**Master**");
		Master master = new Master(competitors);
		ClassicStrategy cS = new ClassicStrategy(competitors, j1, b1);
		master.setStrategy(cS);
		master.play();

	}

}
