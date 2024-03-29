package javaKampDay5.business.abstracts;

import javaKampDay5.Entities.Concretes.User;

public interface IUserService {
	void signUp(User user);
	void update(User user);
	void delete(User user);
	boolean mailVerification(User user);
	boolean passwordVerification(User user);
	boolean nameVerification(User user);
}
