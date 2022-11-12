/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doubly;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan Pablo Rivera y Andres Torres Ciceri
 */
public class LinkedLists {

    private Nodo start, end;

    public LinkedLists() {
        this.start = this.end = null;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public void addEnd(String cont) {
        if (!isEmpty()) {
            end = new Nodo(cont, null, end);
            end.previous.next = end;
        } else {
            start = end = new Nodo(cont);
        }

    }

    public void addStart(String cont) {
        if (!isEmpty()) {
            start = new Nodo(cont, start, null);
            start.next.previous = start;
        } else {
            start = end = new Nodo(cont);
        }
    }

    public void showListSE() {
        if (!isEmpty()) {
            String content = "";
            Nodo aux = start;
            while (aux != null) {
                content += "~ | " + aux.dato + " | ~" + "\n";
                aux = aux.next;
            }
            JOptionPane.showMessageDialog(null, "BLOC: " + "\n"
                    + content);
            /*System.out.println("BLOC: ");
                System.out.println(content);*/
        }
    }

    public void showListES() {
        if (!isEmpty()) {
            String content = "~ ";
            Nodo aux = end;
            while (aux != null) {
                content += "|" + aux.dato + "| ~";
                aux = aux.previous;
            }
            JOptionPane.showMessageDialog(null, "BLOC: " + "\n"
                    + content);
        }
    }

    public String DeleteSE() {
        String cont = start.dato;
        if (start == end) {
            start = end = null;
        } else {
            start = start.next;
            start.previous = null;
        }
        return cont;
    }

    public String DeleteES() {
        String cont = end.dato;
        if (start == end) {
            start = end = null;
        } else {
            end = end.previous;
            end.next = null;
        }
        return cont;
    }

    public void Delete(String dato) {
        Nodo aux, aux2 = null;
        aux = start;
        boolean is = false;
        while ((!aux.dato.equalsIgnoreCase(dato)) && is == false) {
            if (aux.next != null) {
                aux2 = aux;
                aux = aux.next;
            } else {
                is = true;
            }
        }
        if (is == true) {
            JOptionPane.showMessageDialog(null, "No hay registros del texto ingresado");
        } else {
            if (start.equals(aux)) {
                start = aux.next;
            } else {
                aux2.next = aux.next;
            }
        }
    }

    public void Insert(String dato, String edit) {
        Nodo aux = start;
        boolean verify = false;
        while (!dato.equals(aux.dato) && verify == false) {
            if (aux.next != null) {
                aux = aux.next;
            } else {
                verify = true;
            }
        }
        if (verify == false) {
            Nodo modify = new Nodo(edit);
            modify.next = aux.next;
            aux.next = modify;
        }
    }


    public boolean IsHere(String cont, String edit) {
        Nodo aux = start;
        boolean is = false;
        while (aux != null && is == false) {
            if (aux.dato.equalsIgnoreCase(cont)) {
                aux.dato = edit;
                is = true;
            }
            //aux.dato.equalsIgnoreCase(cont)
            aux = aux.next;
        }
        return is;
    }
}
