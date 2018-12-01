/*
 * Cliente.java
 *
 * Created on 1 de noviembre de 2007, 22:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package chatocultar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Cliente extends Thread{

    private int puerto;
    private String url;
    private Socket s;
    private boolean bConectado;
    VCliente ventana;
    private String nick;

    public Cliente(int puerto, String url, String nick, VCliente ventana) {
        this.puerto=puerto;
        this.url=url;
        this.ventana=ventana;
        this.nick=nick;
    }
    
    public void run(){
        try{
            s=new Socket(url, puerto);
            DataInputStream dis=new DataInputStream(s.getInputStream());
            enviarTrama(1, nick);
            bConectado=true;
            while(bConectado){
                int nCodigo =dis.readInt();
                String sTrama=dis.readUTF();
                switch(nCodigo){
                    case 1:
                        ventana.nuevaPersona(sTrama);
                        break;
                    case 2:
                        ventana.mensajeRecibido(sTrama);
                        break;
                    case 3:
                        try{
                            int nPos = Integer.parseInt(sTrama);
                            ventana.borrarPersona(nPos);
                        }catch(Exception e2){
                        }
                        break;
                }
            }
            //JOptionPane.showMessageDialog(ventana, "Se ha podido conectar");
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se pudo establecer la conexi�n");
        }
    }
    
    public void enviarMensaje(String sMensaje){
        Ocultar o = new Ocultar();
        enviarTrama(2, o.ocultar(sMensaje));
    }
    
    public void mostrarMensaje(){
        Ocultar o = new Ocultar();
        enviarTrama(2, o.mostrar());
    }
    
    public void enviarTrama(int nCodigo, String sTrama){
        try{
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            dos.writeInt(nCodigo);
            dos.writeUTF(sTrama);
        }catch(IOException e){
            JOptionPane.showMessageDialog(ventana, "No se pudo enviar el mensaje"+e.getMessage());
        }
        
    }

}
