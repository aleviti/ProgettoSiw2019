package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String orario;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date dataInizio;


	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date dataFine;

	@Column(nullable = false)
	private String giorni;

	@ManyToOne
	private Docente docente;

	@ManyToMany(mappedBy = "corsi")
	private List<Studente> studenti;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}

	public String getGiorni() {
		return giorni;
	}

	public void setGiorni(String giorni) {
		this.giorni = giorni;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Studente> getStudente() {
		return studenti;
	}

	public void setStudente(List<Studente> studenti) {
		this.studenti = studenti;
	}
}
