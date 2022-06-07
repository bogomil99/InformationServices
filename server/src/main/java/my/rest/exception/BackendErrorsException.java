package my.rest.exception;

/**
 * @author bborisov
 */
public class BackendErrorsException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorMessageType;

	public BackendErrorsException(String errorMessageType) {
		super(errorMessageType);
		this.errorMessageType = errorMessageType;
	}

	@Override
	public String getMessage() {
		String msg = "";

		switch (this.errorMessageType) {
			case "email": {
				msg = "Оnly email can be entered in the field email.";
				break;
			}
			case "latinOrCyrillicWords": {
				msg = "User name can only contains Latin and Cyrillic characters, spaces or dashes.";
				break;
			}
			default: {
				msg = this.errorMessageType;
				break;
			}
		}

		return msg;
	}

}
