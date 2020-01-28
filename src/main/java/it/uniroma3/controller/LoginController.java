package it.uniroma3.controller;


import it.uniroma3.model.Azienda;
import it.uniroma3.model.Segreteria;
import it.uniroma3.service.AziendaService;
import it.uniroma3.service.SegreteriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController
{

    @Autowired
    private AziendaService aziendaService;

    @Autowired
    private SegreteriaService segreteriaService;


    @RequestMapping(value={"/login"}, method={RequestMethod.GET})
    public String login(ModelMap model, @RequestParam(value="error", required=false) String error)
    {
        if (error != null) {
            model.addAttribute("error", "Username o password non validi");
        }
        model.addAttribute("segreteria", new Segreteria());
        model.addAttribute("azienda", new Azienda());
        return "login";
    }

    @RequestMapping(value={"*/logout"}, method={RequestMethod.GET})
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value={"/role"}, method={RequestMethod.GET})
    public String loginRole(Model model, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        Segreteria segreteria = segreteriaService.findSegreteria(auth.getName());
        Azienda azienda = aziendaService.findAzienda(auth.getName());
        List<Segreteria> segreterie = this.segreteriaService.findByAzienda(azienda.getId());
        int size = segreterie.size();
        model.addAttribute("size", size);
        session.setAttribute("size",size);
        String targetUrl = "";
        if (role.contains("ROLE_USER")) {
            session.setAttribute("segreteria", segreteria);
            model.addAttribute("segreteria", segreteria);
            targetUrl = "homeSegreteria";
        } else if (role.contains("ROLE_ADMIN")) {
            session.setAttribute("azienda", azienda);
            targetUrl = "homeAzienda";
        }
        return targetUrl;
    }
}