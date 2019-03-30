package com.mycompany.ejemplodijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Yonathan
 */
public class Ejemplos {
    public BufferedReader entradaDatos=new BufferedReader(new InputStreamReader (System.in));
    public char[] GrafoAH(Grafo g){
        g.agregarRuta('a','b', 45);
        g.agregarRuta('a','c', 4);
        g.agregarRuta('a','d', 39);
        g.agregarRuta('a','g', 5);
        g.agregarRuta('b','a', 45);
        g.agregarRuta('b','d', 3);
        g.agregarRuta('b','e', 60);
        g.agregarRuta('b','f', 31);
        g.agregarRuta('b','g', 40);
        g.agregarRuta('c','a', 4);
        g.agregarRuta('c','e', 7);
        g.agregarRuta('c','h', 8);
        g.agregarRuta('d','a', 39);
        g.agregarRuta('d','b', 3);
        g.agregarRuta('d','f', 2);
        g.agregarRuta('e','b', 60);
        g.agregarRuta('e','c', 7);
        g.agregarRuta('e','f', 9);
        g.agregarRuta('e','g', 6);
        g.agregarRuta('e','h', 1);
        g.agregarRuta('f','b', 31);
        g.agregarRuta('f','d', 2);
        g.agregarRuta('f','e', 9);
        g.agregarRuta('f','h', 25);
        g.agregarRuta('g','a', 5);
        g.agregarRuta('g','b', 40);
        g.agregarRuta('g','e', 6);
        g.agregarRuta('g','h', 14);
        g.agregarRuta('h','c', 8);
        g.agregarRuta('h','e', 1);
        g.agregarRuta('h','f', 25);
        g.agregarRuta('h','g', 14);
        char[] nodos = new char[2];
        String dato="";
        try{
            System.out.println("Digite el origen.");
            String origen = entradaDatos.readLine().toLowerCase();
            System.out.println("Seleccione una opcion.");
            String destino = entradaDatos.readLine().toLowerCase();
            dato = origen+destino;
        }catch(IOException ioe){
            
        }
        return dato.toCharArray();
    }
    
    public char[] GrafoLaberinto(Grafo g){
        g.agregarRuta('a','b', 15);
        g.agregarRuta('b','a', 15);
        g.agregarRuta('b','ñ', 16);
        g.agregarRuta('ñ','b', 16);
        g.agregarRuta('b','c', 17);
        g.agregarRuta('c','b', 17);
        g.agregarRuta('e','f', 37);
        g.agregarRuta('f','e', 37);
        g.agregarRuta('e','d', 60);
        g.agregarRuta('d','e', 60);
        g.agregarRuta('e','g', 27);
        g.agregarRuta('g','e', 27);
        g.agregarRuta('a','n', 0);
        g.agregarRuta('n','a', 0);
        g.agregarRuta('a','i', 0);
        g.agregarRuta('i','a', 0);
        g.agregarRuta('g','n', 5);
        g.agregarRuta('n','g', 5);
        g.agregarRuta('g','h', 10);
        g.agregarRuta('h','g', 10);
        g.agregarRuta('h','i', 8);
        g.agregarRuta('i','h', 8);
        g.agregarRuta('g','k', 70);
        g.agregarRuta('k','g', 70);
        g.agregarRuta('h','j', 80);
        g.agregarRuta('j','h', 80);
        g.agregarRuta('k','m', 5);
        g.agregarRuta('m','k', 5);
        g.agregarRuta('k','l', 70);
        g.agregarRuta('l','k', 70);
        
        String dato = "al";
        
        return dato.toCharArray();
    }
}
