package com.mycompany.ejemplodijkstra;

import java.io.Serializable;

/**
 *
 * @author Yonathan
 */
public class Enlaces implements Serializable{
    private String origen;
    private String destino;
    private int peso;

    public Enlaces(String origen, String destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
}
