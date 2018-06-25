
public class MissingChoiceException extends Exception {
	public MissingChoiceException() {
		super ("None of the available choices match the given answer");
	}
}
