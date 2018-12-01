package chatocultar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ocultar {

    char[] ocultarMsj;
    char[] mostrarMsj;
    String o, msj;
    static Queue<String> colamsg = new LinkedList<>();
    static Queue<String> colatxt = new LinkedList<>();

    public String ocultar(String mensaje) {
        ocultarMsj = mensaje.toCharArray();
        for (int i = 0; i < ocultarMsj.length; i++) {
            ocultarMsj[i] = (char) (ocultarMsj[i] + 6);
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

    public String mostrar() {
        while (!mostrarCola().isEmpty()) {
            msj = mostrarCola().poll();
            mostrarMsj = msj.toCharArray();
            for (short j = 0; j < mostrarMsj.length; j++) {
                mostrarMsj[j] = (char) (mostrarMsj[j] + 3);
            }
            String m = String.valueOf(mostrarMsj);
            System.out.println(m);
            colatxt.add(m);
        }
        String txt = null;
        if (!colatxt.isEmpty()) {
            while (!colatxt.isEmpty()) {
                String txt2 = String.valueOf(colatxt.poll());
                //txt.concat(txt, txt2);
                txt2 = txt;
                
            }
            return txt;
        } else {
            return null;
        }

    }

}
