package fr.dta.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;

@Service
// @Scope("singleton")  un changement du bean agira sur toutes les instances de la classe
@Scope("prototype") // chaque instance est séparé dans le bean
@Transactional
public class MailService {

	private String message;
	
	public void sendMail(Employee e) {
		System.out.println(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
