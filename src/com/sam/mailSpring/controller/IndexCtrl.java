package com.sam.mailSpring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexCtrl {
	
	@Autowired
	private JavaMailSender java_mail_sender;
	//private SimpleMailMessage simple_mail_message;
	
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String send(HttpServletRequest r) {
		SimpleMailMessage simple_mail_message = new SimpleMailMessage();
		simple_mail_message.setFrom("reservaciones@loyola.edu.mx");
		simple_mail_message.setReplyTo("nada");
		simple_mail_message.setSentDate(new Date());
		simple_mail_message.setTo(r.getParameter("to"));
		simple_mail_message.setSubject(r.getParameter("asunto"));
		simple_mail_message.setText(r.getParameter("msj"));
		
		System.out.println("Para: " + r.getParameter("to") + "\nAsunto: " + r.getParameter("asunto") + "\nMensaje: " + r.getParameter("msj"));
		try {
			System.out.println("SIMPLE MAIL MESSAGE2: " + simple_mail_message);
			java_mail_sender.send(simple_mail_message);
		} catch (Exception e) {
			System.out.println("AL INTENTAR MANDAR EL CORREO SURGIO EL ERROR: " + e);
		}
		return "redirect:/";
	}

}
