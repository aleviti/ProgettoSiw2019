package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Segreteria {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO )
	private Long id;
	
	@Column(nullable= false)
	private String  numTelefono;;

	@Column(nullable= false)
	private String orarioRicevimento;

	@Column(nullable = false)
	private String role;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;
    
	@OneToOne
	private  Azienda azienda;

	public Segreteria () {
		this.role = "ROLE_USER";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getOrarioRicevimento() {
		return orarioRicevimento;
	}

	public void setOrarioRicevimento(String orarioRicevimento) {
		this.orarioRicevimento = orarioRicevimento;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
