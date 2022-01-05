package competition_AA;

public class NotEnoughCompetitorsException extends Exception {
	public NotEnoughCompetitorsException(String errorMessage) {
        super(errorMessage);
    }
}
