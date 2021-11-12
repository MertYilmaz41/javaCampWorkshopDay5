package javaKampDay5.core;

import javaKampDay5.Google.jGoogle;

public class jGoogleServiceAdapter implements ISignUpService{

	@Override
	public void signUp(String message) {
		jGoogle google = new jGoogle();
		google.signWithGoogle(message);
	
	}

}
