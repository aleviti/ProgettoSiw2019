package it.uniroma3.repository;

import it.uniroma3.model.Segreteria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SegreteriaRepository extends CrudRepository<Segreteria, Long> {
	


	public Segreteria findByUsername(String username);
	public List<Segreteria> findByAzienda_Id(Long id);

	

}
