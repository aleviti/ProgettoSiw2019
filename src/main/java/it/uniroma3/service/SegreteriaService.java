package it.uniroma3.service;

import it.uniroma3.model.Segreteria;
import it.uniroma3.repository.SegreteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegreteriaService {

    @Autowired
    private SegreteriaRepository segreteriaRepository;

    public Segreteria findSegreteria(String username) {
        return this.segreteriaRepository.findByUsername(username);
    }

    public void save(Segreteria segreteria) {
        this.segreteriaRepository.save(segreteria);
    }

    public List<Segreteria> findByAzienda(Long id) {
        return this.segreteriaRepository.findByAzienda_Id(id);
    }


}
