package competition_AA;

/**
 * The Class that manages the Match
 */
public class Match {

	// Attributs of the class Match
	private final Competitor c1;
	private final Competitor c2;
	private Competitor winner;
	private Competitor looser;

	/** the constructor of the class Match
	 * @param c1 the first competitor who is going to play
	 * @param c2 the second competitor who is going to play
     */
	public Match(Competitor c1, Competitor c2) {
		this.c1 = c1;
		this.c2 = c2;
		this.winner = null;
		this.looser = null;
	}

	/** return the first competitor
	 * @return the firt competitor
     */
	public Competitor getC1() {
		return c1;
	}

	/** return the second competitor
	 * @return the second competitor
     */
	public Competitor getC2() {
		return c2;
	}

	/** chooses a random number 0 or 1
	 * if the random number is 1 the winner is c1 otherwise the winner is c1
     */
	public void playMatch() {

		double random = Math.random();

		if (random > 0.5) {

			this.setWinner(c1);
			this.setLooser(c2);
		}

		else {

			this.setWinner(c2);
			this.setLooser(c1);
		}

		System.out.println(c1.getName()+" vs "+c2.getName()+" --> "+this.getWinner().getName()+" wins!");

	}

	/** return the winner
	 * @return the winner
     */
	public Competitor getWinner(){

		return winner;

	}

	/** setter to set the winner
	 * @param c the competitor to set as a winner
     */
	public void setWinner(Competitor c) {
		winner=c;
	}

	/** return the looser
	 * @return the looser
     */
	public Competitor getLooser(){

		return looser;

	}

	/** setter to set the looser
	 * @param c the competitor to set as a looser
     */
	public void setLooser(Competitor c) {
		looser=c;
	}
}
