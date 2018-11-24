/*
 * GestorConexiones.java
 *
 * Created on 1 de noviembre de 2007, 23:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package chatocultar;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class GestorConexiones {
    
    private static GestorConexiones singleton=new GestorConexiones();
    public  static GestorConexiones getInstance(){
        return singleton;
    }
    
    private ArrayList<Conexion> conexiones = new ArrayList<Conexion>();
    
    public void enviarTrama(int nCodigo, String sTrama){
        for (Conexion ms:conexiones){
            ms.enviarTrama(nCodigo, sTrama);
        }
    }
    
    public void conectaNuevo(Conexion nuevo){
        for (Conexion ms:conexiones){
            nuevo.enviarTrama(1, ms.getNick());
        }
        conexiones.add(nuevo);
    }
    
    public void desconecta(Conexion eliminar){
        int nPos=-1;
        for (int n=0;n<conexiones.size();n++){
            if (conexiones.get(n)==eliminar){
                nPos=n;
            }
        }
        if (nPos!=-1){
            for (int n=0;n<conexiones.size();n++){
                if (n!=nPos){
                    conexiones.get(n).enviarTrama(3, ""+nPos);
                }
            }
            conexiones.remove(nPos);
        }
    }    
    
}
