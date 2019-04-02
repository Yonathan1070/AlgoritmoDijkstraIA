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
    private HashMap<String,HMGrafo> grafos;
    
    public Sistema(){
        grafos=new HashMap();
    }
    
    public void guardarArchivo(HashMap<String, HMGrafo> hmGrafos){
        try{
            File fileOne=new File("Archivos/Grafos");
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
    /* Metodo para el manejo de la lectura del archivo */
    public HashMap leerArchivo(){
        try{
            File toRead=new File("Archivos/Grafos");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            grafos=(HashMap<String,HMGrafo>)ois.readObject();
            
            ois.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        } 
        return grafos;
    }
}
