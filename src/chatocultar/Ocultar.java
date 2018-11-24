package chatocultar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Carlos Solis
 * @version
 * @param
 * @comentarios
 */
public class Ocultar {

    char[] ocultarMsj;
    char[] mostrarMsj;
    String o, msj;
    char c;
    static Queue<String> colamsg = new LinkedList<>();
    static Queue<String> colatxt = new LinkedList<>();

    public String ocultar(String mensaje) {
        //List<CharArray> listmsg = new ArrayList<>();
        //System.out.println(mensaje);
        ocultarMsj = mensaje.toCharArray();
        for (int i = 0; i < ocultarMsj.length; i++) {
            ocultarMsj[i] = (char) (ocultarMsj[i] + 3);
        }
        System.out.println(ocultarMsj);
        o = String.valueOf(ocultarMsj);
        almacenar(o);
        return o;
    }

    public static void almacenar(String msg) {
        colamsg.add(msg);
    }

    public static Queue<String> mostrarCola() {
        return colamsg;
    }
//prueba modificar repositorio
    public String mostrar() {
       // while (!mostrarCola().isEmpty()) {
            String msj = mostrarCola().poll();
            mostrarMsj = msj.toCharArray();
            for (short j = 0; j < mostrarMsj.length; j++) {
                mostrarMsj[j] = (char) (mostrarMsj[j] - 3);
            }
            String m = String.valueOf(mostrarMsj);
            //colatxt.add(m);
            return m;
        }


    }
