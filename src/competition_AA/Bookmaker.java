package competition_AA;
import java.util.*;

public class Bookmaker implements MatchObserver {

	public String nom;

	private HashMap<Competitor,Integer> cotes = new HashMap<Competitor,Integer>();


	/** the constructor of the class Bookmaker
	 * @param nom name of the bookmaker
	 * @param competitors competitors of the match
     */
	public Bookmaker(String nom, List<Competitor> competitors) {
		this.nom=nom;
		for(Competitor c : competitors) {
			this.cotes.put(c, 2);
		}
		
	}

	/** affect the rating of a competitor
	 * @param c the competitor
	 * @param delta defines the number we add to the rating. This number is -1 or 1 depends on the result. 
     */
	public void affectCoteOfCompetitor(Competitor c,int delta) {

		if(this.cotes.get(c)!=1 || delta>0) { // Once the rating is given, it can't never decrease
			this.cotes.put(c, this.cotes.get(c)+delta);
		}
		
	}
	
	@Override
	public void reactToMatchResult(Competitor c1, Competitor c2, int win) {
		// TODO Auto-generated method stub
		if(win==0) {
			this.affectCoteOfCompetitor(c1, -1);
			this.affectCoteOfCompetitor(c2, 1);
		}
		else {
			this.affectCoteOfCompetitor(c2, -1);
			this.affectCoteOfCompetitor(c1, 1);
		}
		System.out.println("-------Bookmaker "+this.nom+" ----------------");
		System.out.println("Le joueur "+c1.getName()+" a une cote de "+this.cotes.get(c1));
		System.out.println("Le joueur "+c2.getName()+" a une cote de "+this.cotes.get(c2));
	}

}
