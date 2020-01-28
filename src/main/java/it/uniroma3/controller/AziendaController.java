package it.uniroma3.controller;


import it.uniroma3.model.Azienda;
import it.uniroma3.model.Segreteria;
import it.uniroma3.service.AziendaService;
import it.uniroma3.service.SegreteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AziendaController {

    @Autowired
    private SegreteriaService segreteriaService;

    @Autowired
    private AziendaService aziendaService;

    @RequestMapping(value = "/resistrazioneSegreteria", method = RequestMethod.GET)
    public String registrazione(@ModelAttribute Segreteria segreteria, Model model) {
        model.addAttribute("segreteria", segreteria);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Azienda azienda = this.aziendaService.findAzienda(auth.getName());
        List<Segreteria> segreterie = this.segreteriaService.findByAzienda(azienda.getId());
        if(segreterie.isEmpty()) {

            return "registraSegreteria";
        }
        else {
            return "homeAzienda";
        }
    }

    @RequestMapping(value = "/aggiungiSegreteria", method = RequestMethod.POST)
    public String aggiungiSegreteria(@ModelAttribute Segreteria segreteria, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Azienda azienda = this.aziendaService.findAzienda(auth.getName());
        model.addAttribute("segreteria", segreteria);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncode = passwordEncoder.encode(segreteria.getPassword());
        segreteria.setAzienda(azienda);
        segreteria.setPassword(passwordEncode);
        this.segreteriaService.save(segreteria);
        return "homeAzienda";
    }


}
