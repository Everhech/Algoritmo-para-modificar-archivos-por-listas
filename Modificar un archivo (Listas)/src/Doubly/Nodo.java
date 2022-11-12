/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doubly;

/**
 *
 * @author Juan Pablo Rivera y Andres Torres Ciceri
 */
public class Nodo {

    public String dato;
    Nodo next, previous;

    public Nodo(String cont) {
        this(cont, null, null);
    }

    public Nodo(String cont, Nodo n, Nodo p) {
        this.dato = cont;
        this.next = n;
        this.previous = p;
    }
    
}
