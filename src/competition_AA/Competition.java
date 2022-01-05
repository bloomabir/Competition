package competition_AA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * The Class that manages a comepition
 * Abstract class
 */
public abstract class Competition {

	// Attributs of the class Competition

	private final List<Competitor> competitors;

	/** the constructor of the class League
	 * @param competitors the competitors of this competition
     */
	public Competition(List<Competitor> competitors) {
		this.competitors = competitors;
	}
	/**
	 * {@link competition_AA.League#play()}
	 * {@link competition_AA.Tournament#play()}
	 */
	protected abstract void play() throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException;

	/**
	 * {@link competition_AA.League#playMatch(Competitor c1, Competitor c2)}
	 * {@link competition_AA.Tournament#playMatch(Competitor c1, Competitor c2)}
	 */
	protected abstract void playMatch(Competitor c1,Competitor c2) throws AddingNegativePointsException;

	/** return a hashmap sorted by values competitor as key and his number of points as value
	 * @return a hashmap for ranking the competitors
     */
	public Map<Competitor,Integer> ranking(){

		Map<Competitor,Integer> competitorsPoints = new HashMap<Competitor,Integer>();

    	for (Competitor competitor:competitors) {

    		competitorsPoints.put(competitor,competitor.getNbPoints());
    	}

    	competitorsPoints = MapUtil.sortByDescendingValue(competitorsPoints);

    	return competitorsPoints;
	}

	/** return the list of competitors of this competition
	 * @return the list of competitors of this competition
     */
	public List<Competitor> getCompetitors() {
		// TODO Auto-generated method stub
		return competitors;
	}


}
