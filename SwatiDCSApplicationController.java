package com.SwatiDCSApplication.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SwatiDCSApplication.Model.Appointment;
import com.SwatiDCSApplication.Model.Contact;
import com.SwatiDCSApplication.Model.Login;

@Controller
public class SwatiDCSApplicationController {

	@Autowired
	SessionFactory sf;

	@RequestMapping("/")
	public String name() {
		return "swati";
	}

	@RequestMapping("/swati")
	public String swatiLogin(Login login, Model model) {
		
		Session session = sf.openSession();

		Login dbLogin = session.get(Login.class, login.getPassword()); // swati // anil

		String page = "swati";
		String msg = null;
		if (dbLogin != null) {
			if (login.getUsername().equals(dbLogin.getUsername())) { // 1234 //1234
				page = "home";
			} else {
				msg = "Invalid Username";
			}
		} else {
			msg = "Invalid Password";
		}
		model.addAttribute("msg", msg); // front end
		return page;
		
		
	}

	@RequestMapping("/swatiWaghamodeCreateAccount")
	public String swatiwaghamodeCreateAccount() {
		return "swatiWaghamode";
	}

	@RequestMapping("/swatiWaghamode")
	public Login swatiwaghamode(Login login) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(login);
		System.out.println(login);
		tx.commit();
		return login;
	}
	
	@RequestMapping("/homepage")
	public String homePage() {
		return "home";
	}

	@RequestMapping("/aboutpage")
	public String aboutPage() {
		return "about";
	}

	@RequestMapping("/appointmentpage")
	public String appointmentPage() {
		return "appointment";
	}

	@RequestMapping("/appointment")
	public Appointment appointmentSave(Appointment appointment) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(appointment);
		System.out.println(appointment);
		tx.commit();
		return appointment;
	}

	@RequestMapping("/contactpage")
	public String contactPage() {
		return "contact";
	}

	@RequestMapping("/contact")
	public Contact contactSave(Contact contact) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(contact);
		System.out.println(contact);
		tx.commit();
		return contact;
	}

	@RequestMapping("/pricepage")
	public String pricePage() {
		return "price";
	}

	@RequestMapping("/servicepage")
	public String servicePage() {
		return "service";
	}

	@RequestMapping("/teampage")
	public String teamPage() {
		return "team";
	}

	@RequestMapping("/testimonialpage")
	public String testimonialPage() {
		return "testimonial";
	}
	
	@RequestMapping("/backToLogin")
	public String backToLogin() {
		return "swati";
	}

	@RequestMapping("/myadvancejavabatch137teams")
	public String batch136Teams() {
		return "batch137";
	}
	
}
