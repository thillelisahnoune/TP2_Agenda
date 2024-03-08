package com.example.demo.agenda;

public interface ClientService {
	//void init();
	void ajouterClient(String login, String psw);
	Iterable<Client> getAllClients(); 
}
