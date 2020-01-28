package it.uniroma3.controller;

import it.uniroma3.model.Corso;
import it.uniroma3.model.Docente;
import it.uniroma3.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;




@Controller
public class DocenteController {
	@Autowired
	private DocenteService docenteService;

	@RequestMapping("/toAddDocente")
	public String toAddDocente(Model model) {
		model.addAttribute("docente", new Docente());
		return "docenteForm";
	}


	@RequestMapping(name = "/addDocente", method = RequestMethod.POST)
	public String addDocente(@ModelAttribute Docente docente, Model model) {

		model.addAttribute("docente", docente);

		docenteService.save(docente);
		return "homeSegreteria";
	}
	@RequestMapping(value = "/docenti", method = RequestMethod.GET)
    public String listaDocenti(@ModelAttribute Docente docente, Model model) {
        return "docentiList";

}
}
	

