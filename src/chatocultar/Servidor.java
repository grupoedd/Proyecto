/*
 * Servidor.java
 *
 * Created on 1 de noviembre de 2007, 22:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package chatocultar;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Servidor extends Thread{
    
    private int puerto;
    private JFrame ventana;
    

    public Servidor(JFrame ventana, int puerto) {
        this.puerto = puerto;
        this.ventana = ventana;
    }
    
    public void run(){
        ServerSocket ss=null;
        try{
            ss=new ServerSocket(puerto);
            while (true){
                Socket s=ss.accept();
                GestorConexiones.getInstance().conectaNuevo(new Conexion(s));
            }
            //JOptionPane.showMessageDialog(ventana,"Se han conectado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana,"Error al abrir el puerto. Posiblemente ya est� en uso.");
        }
        try{
            ss.close();
        }catch(Exception e){
        }
    }
    
}
