package javaKampDay5.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javaKampDay5.Entities.Concretes.User;
import javaKampDay5.business.abstracts.IUserService;
import javaKampDay5.core.IEmailSender;
import javaKampDay5.dataAccess.abstracts.UserDao;

public class UserManager implements IUserService{
	
	List<String> emailList=new ArrayList<String>();
	
	private UserDao userDao;
	private IEmailSender emailSender;
	
	public UserManager(UserDao userDao, IEmailSender emailSender) 
	{
		super();
		this.userDao = userDao;
		this.emailSender = emailSender;
	}

	@Override
	public void signUp(User user) {
		if(MailVerification(user)==true && PasswordVerification(user)==true)
		{
			this.emailSender.sendVerifyEmail();
			this.emailSender.isEmailClicked();
			this.userDao.signUp(user);
			System.out.println("Kullan�c� ba�ar�yla kay�t oldu.");
		}
		else
		{
			this.emailSender.signUpIsFail();
		}
		
	}

	@Override
	public void update(User user) {
		
		userDao.update(user);
		System.out.println("Kullan�c� hesab�n� g�ncelledi.");
		
	}

	@Override
	public void delete(User user) {
		
		userDao.delete(user);
		System.out.println("Kullan�c� hesab�n� sildi.");
		
		
	}

	
	public boolean MailVerification(User user) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getEmail());
		if(matcher.matches()==true && emailList.contains(user.getEmail())==false)
		{
			emailList.add(user.getEmail());
			return true;
		}
		else
		{
			return false;
		}
	}

	
	public boolean PasswordVerification(User user) {
		String regex = "[0-9a-zA-Z]{6,}";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getPassword());
		if(matcher.matches()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	public boolean NameVerification(User user) {
		String regex = "[0-9a-zA-Z]{6,}";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getFirstName());
	    Matcher matcherLastName = pattern.matcher(user.getLastName());
		if(matcher.matches()==true && matcherLastName.matches()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}