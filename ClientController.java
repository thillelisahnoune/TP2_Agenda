package com.example.demo.agenda;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;




	@Controller
	@RequestMapping("/agenda")
	public class ClientController {
		@Autowired
		private ClientService service;
		
		@GetMapping("/home")
		public String home(Model model){
		Iterable<Client> clients = service.getAllClients();
		model.addAttribute("clients", clients);  // clients avec s comme la vue
		return "/agenda/home";
		}
		
		@GetMapping("/loged")
		public String loged(Model model){
		Iterable<Client> clients = service.getAllClients();
		return "/agenda/loged";
		}
		
		@PostMapping("/add")
		public String addClient( @RequestParam String login, @RequestParam String psw) { // ce que nous avons récuperer du form		
		service.ajouterClient(login, psw); // ce que nous allons mettre dans bdd
		return "redirect:/agenda/home";
		}
		
		
		
		
		@PostMapping("/login")
		public String logClient( @RequestParam String login, @RequestParam String psw, HttpSession session, Model model) { // ce que nous avons récuperer du form
			Iterable<Client> clients = service.getAllClients();
			for (Client client : clients) {
			    // Faites quelque chose avec chaque client
				if (login.equals(client.getLogin())) {
					if (psw.equals(client.getPsw())) {
				        session.setAttribute("login", login);
						return "redirect:/agenda/loged";						
					}					
				}			    
			}
			return "redirect:/agenda/home";
		
		}
		
		@GetMapping("/logout")
		public String logout(Model model){			
		return "/agenda/home";
		}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

