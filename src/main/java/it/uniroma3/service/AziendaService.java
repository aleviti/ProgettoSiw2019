package it.uniroma3.service;

import it.uniroma3.model.Azienda;
import it.uniroma3.repository.AziendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AziendaService {
	
	@Autowired
	private AziendaRepository aziendaRepository;

	
	public Azienda save(Azienda azienda) {
		return this.aziendaRepository.save(azienda);
	}
	
	public List<Azienda> findAll(){
		return (List<Azienda>)this.aziendaRepository.findAll();
	}
	
	public Azienda findById(Long id) {
		return this.aziendaRepository.findOne(id);
	}

	public Azienda findAzienda(String username) {
		return this.aziendaRepository.findByUsername(username);
	}
	


}
