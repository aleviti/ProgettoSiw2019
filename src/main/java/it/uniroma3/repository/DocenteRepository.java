package it.uniroma3.repository;

import it.uniroma3.model.Docente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocenteRepository extends CrudRepository<Docente, Long> {
	
	public List<Docente> findByNome(String nome);

	


	

	

}

