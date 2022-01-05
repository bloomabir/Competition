package competition_AA;

/**
 * The Class that manages the competitor
 */

public class Competitor {

	// Attributes of the class Competitor

    private String name;
    private int nbPoints;

    /** the constructor of the class Competitor with 1 parameter
     * @param name the name of the competitor
     */
    public Competitor(String name) {
        this.name = name;
        this.nbPoints = 0;
    }

    /** return the number of competitor's points
     * @return int the number of points that had the competitor
     */
    public int getNbPoints() {
        return this.nbPoints;
    }

    /** return competitor's name
     * @return String the name of the competitor
     */
    public String getName() {
        return this.name;
    }

    /** add n points to the competitor
     * @param n the number of points that we want to add to the competitor
     */
    public void addPoints(int n) throws AddingNegativePointsException{
    	if ( n < 0)
    		throw new AddingNegativePointsException("Can't add engative points");
        this.nbPoints += n;
    }

    /** two competitors are equals if they have the same name and the same number of points
     * @param o the object to test equality with
     * @return <code>true</code> if o is a competitor with the same name and number of points than this objec
     */

    public boolean equals(Object o) {
        if (o instanceof Competitor) {
            Competitor theOther = ((Competitor) o);
            return this.name.equals(theOther.name)
                    && this.nbPoints == theOther.nbPoints;
        } else {
            return false;
        }
    }

    /**
     * @return a string description of this competitor
     */
    public String toString() {
        return "This name of this player is " + this.name + " and he has " + this.nbPoints + " points.";
    }


}
