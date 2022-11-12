/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivo;

import Doubly.LinkedLists;
import java.io.*;

/**
 *
 * @author Juan Pablo Rivera y Andres Torres Ciceri
 */
public class Archivo {

    private BufferedWriter writing;
    private BufferedReader reader;

    public void Writer(String datos) throws IOException {

        writing.write(datos);
        writing.newLine();
    }
        public boolean IsRead() throws IOException {
        return reader.ready();
    }
    public void Open(String nombre, boolean is) throws IOException {

        if (is == true) {
            this.writing = new BufferedWriter(new FileWriter(nombre, true));
        } else {
            this.reader = new BufferedReader(new FileReader(nombre));
        }
        
    }
    
        public LinkedLists ReadArchive() throws IOException {
        this.Open("datos.txt", false);
        String linea = "";
        LinkedLists list = new LinkedLists();
        while ((linea = this.Reader()) != null) {
            list.addStart(linea);
        }
        this.Close();
        return list;
    }

    public String Reader() throws IOException {
        return reader.readLine();
    }

    public void Close() throws IOException {

        if (writing != null) {
            writing.close();
        }
        if (reader != null) {
            reader.close();
        }
    }

        public void ToArchive(LinkedLists list) throws IOException {
        this.Open("BLOC.txt", true);
        while (!list.isEmpty()) {
            String dato = list.DeleteSE();
            this.Writer(dato);
        }
        this.Close();
    }

    public int Plus(String nombreArchivo) throws IOException {
        Open(nombreArchivo, false);
        int row = 0;
        while (IsRead()) {
            Reader();
            row++;
        }
        Close();
        return row;
    }




}
