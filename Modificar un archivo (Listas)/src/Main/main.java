/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Archivo.Archivo;
import Doubly.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Pablo Rivera y Andres Torres Ciceri
 */
public class main {

    public static void main(String[] args) throws IOException {
        LinkedLists list = new LinkedLists();
        Archivo dataBase = new Archivo();
        int option = 0;
        String cont;
        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar texto al inicio del bloc\n"
                        + "2. Agregar texto al final del bloc\n"
                        + "3. Mostrar lo escrito en el bloc\n"
                        + "4. Eliminar una linea de texto del inicio\n"
                        + "5. Eliminar una linea de texto del final\n"
                        + "6. Eliminar una linea en especifico\n"
                        + "7. Editar una linea en especifico\n"
                        + "8. Eliminar todo\n"
                        + "9. Insertar en una linea en especifico\n"
                        + "10. Guardar\n"
                        + "11. Salir\n"
                        + "Seleccione una opcion", "Menu", JOptionPane.INFORMATION_MESSAGE));

                switch (option) {
                    case 1:
                        cont = JOptionPane.showInputDialog(null, "Ingrese el texto a insertar al inicio del bloc");
                        list.addStart(cont);
                        break;
                    case 2:
                        cont = JOptionPane.showInputDialog(null, "Ingrese el texto a insertar al final del bloc");
                        list.addEnd(cont);
                        break;
                    case 3:
                        if (!list.isEmpty()) {
                            list.showListSE();
                        } else {
                            JOptionPane.showMessageDialog(null, "No es posible realizar la acción");
                            JOptionPane.showMessageDialog(null, "No existen registros de textos en este archivo de bloc");
                        }
                        break;
                    case 4:
                        if (!list.isEmpty()) {
                            list.DeleteSE();
                            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente:");
                        } else {
                            JOptionPane.showMessageDialog(null, "No es posible realizar la acción");
                            JOptionPane.showMessageDialog(null, "No existen registros de textos en este archivo de bloc");
                        }
                        break;
                    case 5:
                        if (!list.isEmpty()) {
                            list.DeleteES();
                            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente:");
                        } else {
                            JOptionPane.showMessageDialog(null, "No es posible realizar la acción");
                            JOptionPane.showMessageDialog(null, "No existen registros de textos en este archivo de bloc");
                        }
                        break;
                    case 6:
                        cont = JOptionPane.showInputDialog(null, "Ingrese el texto a eliminar en el bloc");
                        list.Delete(cont);
                        break;
                    case 7:
                        String edit;
                        cont = JOptionPane.showInputDialog(null, "Ingrese el texto a buscar en el bloc");
                        if (list.IsHere(cont, cont)) {
                            JOptionPane.showMessageDialog(null, "Se procedera a modificar el texto");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontraron registros ");
                            break;

                        }
                        edit = JOptionPane.showInputDialog(null, "Ingrese el texto que pondrá en su lugar");
                        list.IsHere(cont, edit);
                        break;
                    case 8:
                        if (!list.isEmpty()) {
 
                            while (!list.isEmpty()) {
                                list.DeleteSE();
                            }
                            JOptionPane.showMessageDialog(null, "Se han eliminado todos los registros");
                        } else {
                            JOptionPane.showMessageDialog(null, "No es posible realizar la acción");
                            JOptionPane.showMessageDialog(null, "No existen registros de textos en este archivo de bloc");
                        }
                        break;
                    case 9:
                        cont = JOptionPane.showInputDialog(null, "Ingrese el texto a buscar en el bloc");
                        if (list.IsHere(cont, cont)) {
                            JOptionPane.showMessageDialog(null, "Se procedera a añadir el texto");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontraron registros ");
                            break;

                        }
                        edit = JOptionPane.showInputDialog(null, "Ingrese el texto que ingresara");
                        list.Insert(cont, edit);
                        break;
                    case 10:
                    try {
                        dataBase.ToArchive(list);
                    } catch (IOException z) {
                        JOptionPane.showMessageDialog(null, "Error" + z.getMessage());
                    }
                    break;

                    case 11:
                        JOptionPane.showMessageDialog(null, "Adios!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Error, ingrese nuevamente una opción valida");
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
            }
        } while (option != 11);
    }

}
