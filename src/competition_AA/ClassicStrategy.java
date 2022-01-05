package competition_AA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ClassicStrategy extends Competition implements MasterStrategy{

	private Competitor winner = null;
	private List<Competitor> winnerLeague = null;
	
	private Journaliste journalist;
	private Bookmaker bookmaker;

	/** The constructor of class ClassicStrategy
     */
	public ClassicStrategy(List<Competitor> competitors) {
		super(competitors);
	}
	
	public ClassicStrategy(List<Competitor> competitors,Journaliste journaliste, Bookmaker bookmaker) {
		this(competitors);
		this.journalist = journaliste;
        this.bookmaker = bookmaker;
	}

	/** return a list of competitor who won the first phase (League)
	 * @return a list of competitor who won the first phase (League)
     */
	@Override
	public List<Competitor> getWinnerLeague() {
		return this.winnerLeague;
	}

	 /** calls the method makeGroupsOfFour to create a group of four and calls play method of league for each group the winners play then a tournament
    * each competitor plays with the rest twice
    * prints the state of the game
    * @exception NotEnoughCompetitorsException if the list of competitors is less than 1
    * @exception AddingNegativePointsException if we add a negative point to a competitor
    * @exception NotGoodSizeForTournamentException if the number of competitors is not a power of 2
     */
	@Override
	public void play() throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException
			 {
		List<List<Competitor>> groups = makeGroupsOfFour();
		List<Competitor> secondPhase = new ArrayList<Competitor>();
		for (List<Competitor> group : groups) {
			League l = new League(group,journalist, bookmaker);
			l.play();
			Map<Competitor,Integer> competitorsPoints = super.ranking();
			Map.Entry<Competitor,Integer> entry = competitorsPoints.entrySet().iterator().next();
			secondPhase.add(entry.getKey());
		}
		this.winnerLeague = secondPhase;
		Tournament t = new Tournament(secondPhase,journalist, bookmaker);
		t.play();
		Map<Competitor,Integer> competitorsPoints = super.ranking();
		Map.Entry<Competitor,Integer> entry = competitorsPoints.entrySet().iterator().next();
		this.winner = entry.getKey();


	}

	@Override
	protected void playMatch(Competitor c1, Competitor c2) throws AddingNegativePointsException {
		// TODO Auto-generated method stub

	}

	/** return a list of list of four competitors to prepare them for league matches
	 * @return a list of list of four competitors
     */
	public List<List<Competitor>> makeGroupsOfFour() {
		List<Competitor> competitors = super.getCompetitors();
		int numberCompetitors = competitors.size();
		int count = 0;
		List<List<Competitor>> d = new ArrayList<List<Competitor>>();
		for(int i = 0; i < numberCompetitors/4; i++) {
			List<Competitor> c = new ArrayList<Competitor>();
			for(int j = 0; j < 4; j++) {
				c.add(competitors.get(count));
				count++;
			}
			d.add(c);
		}
		return d;
	}

	/** return a competitor the winner of the Master match
	 * @return a competitor the winner of the Master match
     */
	public Competitor getWinner() {
		return winner;
	}


}
