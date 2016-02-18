package four.pda.client.model;

import java.util.List;

/**
 * Created by asavinova on 16/02/16.
 */
public class LoginResult {

	public enum Result {
		OK,
		ERROR
	}

	private Result result;
	private List<String> errors;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
