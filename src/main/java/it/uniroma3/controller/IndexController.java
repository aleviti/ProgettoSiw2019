package it.uniroma3.controller;

import it.uniroma3.model.Azienda;
import it.uniroma3.service.AziendaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    private AziendaService aziendaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToIndex(Model model) {

        if(this.aziendaService.findAll().size() == 0) {

            Azienda azienda = new Azienda();
            azienda.setNome("CorsiOnline");
            azienda.setCitta("Roma");
            azienda.setVia("Via della Vasca Navale");
            azienda.setCivico("79");
            azienda.setCap("00100");
            azienda.setEmail("corsionline@gmail.com");
            azienda.setTelefono("0657333201");
            azienda.setUsername("admin");
            azienda.setPassword("admin");
            model.addAttribute("azienda", azienda);
            this.aziendaService.save(azienda);
        }

        return "index";
    }

    @RequestMapping("/")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }


}
