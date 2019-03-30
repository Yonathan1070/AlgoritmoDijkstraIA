/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodijkstra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author Yonathan
 */
public class Sistema {
    private HashMap<String,Grafo> grafos;
    public Sistema(){
        grafos=new HashMap();
    }
    
    public void guardarArchivo(HashMap<String, Grafo> hmGrafos){
        try{
            File fileOne=new File("Grafo");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            
            oos.writeObject(hmGrafos);
            oos.flush();
            oos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public HashMap leerArchivo(){
        try{
            File toRead=new File("Grafo");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            grafos=(HashMap<String,Grafo>)ois.readObject();
            
            ois.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        } 
        return grafos;
    }
}
