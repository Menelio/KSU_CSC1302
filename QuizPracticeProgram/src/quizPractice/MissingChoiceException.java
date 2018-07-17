package quizPractice;

public class MissingChoiceException extends Exception {
	private static final long serialVersionUID = -4332760899169139699L;

	public MissingChoiceException() {
		super ("None of the available choices match the given answer");
	}
}
