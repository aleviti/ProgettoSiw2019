package it.uniroma3.service;

import it.uniroma3.model.Corso;
import it.uniroma3.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorsoService {

    @Autowired
    private CorsoRepository corsoRepository;

    public void save(Corso corso) {
        this.corsoRepository.save(corso);
    }
}
