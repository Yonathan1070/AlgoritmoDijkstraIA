package com.mycompany.ejemplodijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Yonathan
 */
public class Ejemplos {
    public BufferedReader entradaDatos=new BufferedReader(new InputStreamReader (System.in));
    
    public char[] grafoDijkstra(HashMap<String, HMGrafo>grafo, String idGrafo, Grafo g){
        for(Enlaces e : grafo.get(idGrafo).enlaces.values()) {
            g.agregarRuta(e.getOrigen().toCharArray()[0],e.getDestino().toCharArray()[0], e.getPeso());
        }
        String dato="";
        try{
            System.out.println("Digite el origen.");
            String origen = entradaDatos.readLine().toLowerCase();
            System.out.println("Digite el destino.");
            String destino = entradaDatos.readLine().toLowerCase();
            dato = origen+destino;
        }catch(IOException ioe){
            
        }
        
        return dato.toCharArray();
    }
}
