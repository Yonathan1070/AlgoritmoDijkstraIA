/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodijkstra;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Yonathan
 */
public class HMGrafo implements Serializable{
    private String id;
    HashMap<String, Enlaces> enlaces;
    HashMap<String, HMNodos> nodos;

    public HMGrafo(String id) {
        this.id = id;
        enlaces = new HashMap();
        nodos  = new HashMap();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Enlaces> getEnlaces() {
        return enlaces;
    }

    public void setEnlaces(HashMap<String, Enlaces> enlaces) {
        this.enlaces = enlaces;
    }

    public HashMap<String, HMNodos> getNodos() {
        return nodos;
    }

    public void setNodos(HashMap<String, HMNodos> nodos) {
        this.nodos = nodos;
    }
    
}
