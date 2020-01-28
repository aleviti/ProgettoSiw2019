package it.uniroma3.controller;

import it.uniroma3.model.Corso;
import it.uniroma3.model.Docente;
import it.uniroma3.service.CorsoService;
import it.uniroma3.service.DocenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CorsoController {

    @Autowired
    private CorsoService corsoService;

    @Autowired
    private DocenteService docenteService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor( dateFormat, true));
    }

    @RequestMapping(value = "/toAddCorso", method = RequestMethod.GET)
    public String toAddCorso(@ModelAttribute Corso corso, Model model) {
        List<Docente> docenti = this.docenteService.findAll();
        model.addAttribute("docenti", docenti);
        model.addAttribute("corso",corso);
        System.out.println("size" + docenti.size());
        return "corsoForm";
    }

    @RequestMapping(value = "/addCorso", method = RequestMethod.POST)
    public String addCorso(@ModelAttribute Corso corso,
                           @ModelAttribute("dataInizio") String dataInizio,
                           @ModelAttribute("dataFine") String dataFine,Model model, HttpServletRequest request) throws ParseException {
        model.addAttribute("corso",corso);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        corso.setDataInizio(simpleDateFormat.parse(dataInizio));
        corso.setDataFine(simpleDateFormat.parse(dataFine));
        this.corsoService.save(corso);
        return "homeSegreteria";
    }
    
    @RequestMapping(value = "/corsiList", method = RequestMethod.GET)
    public String listaCorsi(@ModelAttribute Corso corso, Model model) {
        return "corsiList";
    }
}
