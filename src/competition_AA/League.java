package competition_AA;

import java.util.List;
import java.util.Map;

/**
 * The Class that manages a type of comepition(League)
 */


public class League extends Competition{

	/** the constructor of the class League
     */
	private Journaliste journalist;
	private Bookmaker bookmaker;

    public League(List<Competitor> competitors) {
        super(competitors);
    }
    
    public League(List<Competitor> competitors,Journaliste journaliste, Bookmaker bookmaker) {
        super(competitors);
        this.journalist = journaliste;
        this.bookmaker = bookmaker;
    }


    /** play a match between two competitors the winner gets one point
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
    @Override
	public void playMatch(Competitor c1, Competitor c2) throws AddingNegativePointsException {

        Match m = new Match(c1, c2);
        m.playMatch();
        Competitor winner = m.getWinner();
        winner.addPoints(1);
        //ADD journaliste.reactToMatch here
        this.journalist.reactToMatchResult(c1, c2, m.getWinner().equals(c1)? 0 : 1);
        this.bookmaker.reactToMatchResult(c1, c2, m.getWinner().equals(c1)? 0 : 1);
    }

    /** calls the method playMatch for each competitor in the competitors list
     * each competitor plays with the rest twice
     * prints the state of the game
     * @exception NotEnoughCompetitorsException if the list of competitors is less than one
     * @exception AddingNegativePointsException if we add a negative point to a competitor
     */
    @Override
	public void play() throws NotEnoughCompetitorsException, AddingNegativePointsException {
    	List<Competitor> competitors = super.getCompetitors();

    	if (competitors.size() <= 1) {
    		throw new NotEnoughCompetitorsException("Not Enough competitors to play");
    	}
    	for (int i = 0; i < competitors.size(); i++) {

            for(int j = 0; j < competitors.size(); j++) {
            	if(j!=i) {
            		playMatch(competitors.get(i), competitors.get(j));
            	}
            }
        }

    	System.out.println("*** Ranking ***");

    	Map<Competitor,Integer> competitorsPoints = super.ranking();

    	for (Map.Entry<Competitor, Integer> entry : competitorsPoints.entrySet()) {
    		System.out.println(entry.getKey().getName() + " - " + entry.getValue());
    	}

    }


	public Journaliste getJournalist() {
		return journalist;
	}


	public void setJournalist(Journaliste journalist) {
		this.journalist = journalist;
	}


	public Bookmaker getBookmaker() {
		return bookmaker;
	}


	public void setBookmaker(Bookmaker bookmaker) {
		this.bookmaker = bookmaker;
	}
    
    

}
