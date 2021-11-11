package javaKampDay5.dataAccess.concretes;

import javaKampDay5.Entities.Concretes.User;
import javaKampDay5.dataAccess.abstracts.UserDao;

public class HibernateUserDao implements UserDao{

	@Override
	public void signUp(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " : " + "sisteme kayýt oldu.");
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " : " + "hesabýný güncelledi");
		
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName() + " : " + "hesabýný sildi.");
		
	}

}
