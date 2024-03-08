package com.example.demo.agenda;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {
	private long id;
	private String login;
	private String psw;
	private String clogin;
	private String cpsw;
public Client(String login, String psw) {
	super();
	this.login = login;
	this.psw = psw;
}


@Id
@GeneratedValue
public long getId() { return id;}
public void setId( long id) { this.id=id;}

public Client() {
	
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}

}
