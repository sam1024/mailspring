package com.sam.mailSpring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexCtrl {
	
	private JavaMailSender java_mail_sender;
	private SimpleMailMessage simple_mail_message;
	
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
//	public String send(@ModelAttribute("to") String to, @ModelAttribute("asunto") String asunto,
//			@ModelAttribute("msj") String msj, Model model) {
	public String send(HttpServletRequest r) {
		simple_mail_message = new SimpleMailMessage();
		simple_mail_message.setTo(r.getParameter("to"));
		simple_mail_message.setSubject(r.getParameter("asunto"));
		simple_mail_message.setText(r.getParameter("msj"));
		System.out.println("Para: " + r.getParameter("to") + "\nAsunto: " + r.getParameter("asunto") + "\nMensaje: " + r.getParameter("msj"));
		try {
			java_mail_sender.send(simple_mail_message);
		} catch (Exception e) {
			System.out.println("AL INTENTAR MANDAR EL CORREO SURGIO EL ERROR: " + e);
		}
		return "redirect:/";
	}

}
