package com.example.demo.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientRepository repo;
	
	
	@Override
	public void ajouterClient(String login, String psw) {
		repo.save(new Client(login, psw));
	}
	
	@Override
	public Iterable<Client> getAllClients(){
		return repo.findAll();
	}
	
}
