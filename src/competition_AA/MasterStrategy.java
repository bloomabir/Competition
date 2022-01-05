package competition_AA;

import java.util.List;

public interface MasterStrategy {
	public List<Competitor> getWinnerLeague();

	public void play() throws NotEnoughCompetitorsException, AddingNegativePointsException, NotGoodSizeForTournamentException;
}
