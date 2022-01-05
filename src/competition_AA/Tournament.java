package competition_AA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The Class that manages a type of comepition(Tournament)
 */

public class Tournament extends Competition{

	// Attributes of the class Competition
	private List<Competitor> winners;
	private Journaliste journalist;
	private Bookmaker bookmaker;

	/** the constructor of the class Tournament
     */

	public Tournament(List<Competitor> competitors) {
		super(competitors);

		winners= new ArrayList<Competitor>(competitors);

	}
	
	public Tournament(List<Competitor> competitors,Journaliste journaliste, Bookmaker bookmaker) {
		this(competitors);
		this.journalist = journaliste;
        this.bookmaker = bookmaker;

	}

	/** return the list of winners
     * @return the list of winners
     */
	public List<Competitor> getWinners(){

		return winners;
	}

	/** play a match between two competitors and remove the loser from the winners list and the winner gets one point
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
	@Override
	public void playMatch(Competitor c1, Competitor c2) throws AddingNegativePointsException {
        Match m = new Match(c1, c2);
        m.playMatch();
        Competitor winner = m.getWinner();
        winner.addPoints(1);
        Competitor looser = m.getLooser();
        winners.remove(looser);
        this.journalist.reactToMatchResult(c1, c2, m.getWinner().equals(c1)? 0 : 1);
        this.bookmaker.reactToMatchResult(c1, c2, m.getWinner().equals(c1)? 0 : 1);

    }

	/** calls the method playMatch for each competitor with the competitor next to it in the list
     * tournament bracket algorithm
     * prints the state of the game
     * @exception NotEnoughCompetitorsException if the list of competitors is less than one
     * @exception AddingNegativePointsException if we add a negative point to a competitor
     * @exception NotGoodSizeForTournamentException if the number of competitors is not a power of two
     */
    @Override
	public void play() throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException {
    	List<Competitor> competitors = super.getCompetitors();

    	double log = (int) (Math.log(competitors.size())/Math.log(2));
        double pow = Math.pow(2,log);

    	if (competitors.size() <= 1) {
    		throw new NotEnoughCompetitorsException("Not Enough competitors to play");
    	}
    	else if (pow != competitors.size()) {
    		throw new NotGoodSizeForTournamentException("Not Enough competitors to play");
    	}
    	for (int p = 0; p <log;p++) {

    		int size = winners.size()/2;

    		for (int i = 0; i < size; i++) {

        		playMatch(winners.get(i), winners.get(i+1));

            }
    	}

    	System.out.println("*** Ranking ***");

    	Map<Competitor,Integer> competitorsPoints = super.ranking();

    	for (Map.Entry<Competitor, Integer> entry : competitorsPoints.entrySet()) {
    		System.out.println(entry.getKey().getName() + " - " + entry.getValue());
    	}

    }

}
