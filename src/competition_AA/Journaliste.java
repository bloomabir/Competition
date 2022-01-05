package competition_AA;

public class Journaliste implements MatchObserver {

	public String nom;
	

	/** the constructor of the class Journaliste
     */
	public Journaliste(String nom) {
		this.nom=nom;
	}
	

    /** play a match between two competitors the winner gets one point
     * @param c1 the first competitor
     * @param c2 the second competitor
     * @param win the winner of the competition
     */
	@Override
	public void reactToMatchResult(Competitor c1,Competitor c2, int win) {
		// win takes the value 0 or 1 to indicate who's the winner of the match
		assert(win==0 || win==1);
		System.out.println("-------Journalist "+this.nom+"----------------");
		System.out.println("Match between "+c1.getName()+" and "+c2.getName());
		if (win==0) {
			System.out.println(c1.getName()+" won ");
		}
		else if (win==1) {
			System.out.println(c2.getName()+" won ");
		}
		System.out.println("-------End Journalist----------------");

	}

}
