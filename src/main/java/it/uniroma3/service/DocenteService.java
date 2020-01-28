package it.uniroma3.service;

import it.uniroma3.model.Docente;
import it.uniroma3.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class DocenteService {
	
	@Autowired
	private DocenteRepository docenteRepository;
	

	public Docente save(Docente docente) {
		return this.docenteRepository.save(docente);
	}
	
	@Transactional
	public List<Docente> findByNome(String nome){
		return this.docenteRepository.findByNome(nome);
	}
	
	@Transactional
	public List<Docente> findAll(){
		return (List<Docente>)this.docenteRepository.findAll();
	}
	
	@Transactional
	public Docente findById(Long id) {
		return this.docenteRepository.findOne(id);
	}
	


}

