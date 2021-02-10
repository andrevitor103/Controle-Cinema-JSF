/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import entities.*;
import javax.ejb.EJB;
import model.FilmeFacade;

/**
 *
 * @author Andre Vitor
 */
@Named(value = "cinemaController")
@SessionScoped
public class cinemaController implements Serializable {

    @EJB
    private FilmeFacade filmeFacade;
    
    Filme c = new Filme();

    public Filme getC() {
        return c;
    }

    public void setC(Filme c) {
        this.c = c;
    }
    
    public cinemaController() {
    }
    
    public List<Filme> findAll(){
        return this.filmeFacade.findAll();
    }
    
    public String adicionar(){
        this.filmeFacade.create(this.c);
        this.c = new Filme();
        return "index";
    }
    
    public void delete(Filme c){
        this.filmeFacade.remove(c);
    }
    
    public String editar(Filme c){
        this.c = c;
        return "editarFilme";
    }
    
    public String editar(){
        this.filmeFacade.edit(this.c);
        this.c = new Filme();
        return "index";
    }

    
}
