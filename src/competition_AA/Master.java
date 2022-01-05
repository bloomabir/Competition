package competition_AA;

import java.util.List;

public class Master extends Competition{

	private MasterStrategy strategy;

	/** the constructor of the class Master
	 * @param competitors the competitors in this competition
     */
	public Master(List<Competitor> competitors) {
		super(competitors);
	}

	/**
	 * set the strategy that we want to use for the selecting competitors in the second phase
	 * @param strategy the strategy that we want to use
	 * @exception NotEnoughCompetitorsException if the list of competitors is less than 1
     * @exception AddingNegativePointsException if we add ay negative point to a competitor
     * @exception NotGoodSizeForTournamentException if the number of competitors is not a power of 2
	 */
	public void setStrategy(MasterStrategy strategy) throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException {
		this.strategy = strategy;

	}

	/** return a list of competitor who won the first phase (League)
	 * @return a list of competitor who won the first phase (League)
     */
	public List<Competitor> getWinnerLeague() {
		return this.strategy.getWinnerLeague();
	}

	/**
	 * plays the games depending on wich strategy is used
     */
	@Override
	public void play()
			throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException {
		this.strategy.play();

	}

	@Override
	protected void playMatch(Competitor c1, Competitor c2) throws AddingNegativePointsException {
	}

	/**
	 * getter for the strategy selected
	 * @return MasterStrategy the strategy used in this master match
     */
	public MasterStrategy getStrategy() {
		return this.strategy;
	}

}
