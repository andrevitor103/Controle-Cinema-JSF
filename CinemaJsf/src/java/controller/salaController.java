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
import model.SalaFacade;

/**
 *
 * @author Andre Vitor
 */
@Named(value = "salaController")
@SessionScoped
public class salaController implements Serializable {

    @EJB
    private SalaFacade salaFacade;

    Sala sala = new Sala();

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    public salaController() {
    }
    
    public List<Sala> findAll(){
        return this.salaFacade.findAll();
    }
    
    public String adicionar(){
        this.salaFacade.create(this.sala);
        this.sala = new Sala();
        return "ListaSala";
    }
    
    public void delete(Sala sala){
        this.salaFacade.remove(sala);
    }
    
    public String editar(Sala sala){
        this.sala = sala;
        return "editarSala";
    }
    
    public String editar(){
        this.salaFacade.edit(sala);
        this.sala = new Sala();
        return "ListaSala";
    }
    
    
}

