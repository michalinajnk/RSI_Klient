
import org.apache.xmlrpc.XmlRpcClient;

import java.util.Vector;

public class KlientRPC {

    public static void main(String[] args) {
        try {
            XmlRpcClient srv = new XmlRpcClient("http://localhost:10005");
            Vector<Integer> params = new Vector<Integer>();
            params.addElement(new Integer(13));
            params.addElement(new Integer(21));
            Object result = srv.execute("MojSerwer.echo", params);
            int wynik = ((Integer) result).intValue();
            System.out.println("wynik to:" + wynik);
            AC cb = new AC();

            Vector<Integer> params2 = new Vector<Integer>();
            params2.addElement(new Integer(3000));
            srv.executeAsync("MojSerwer.execAsy", params2, cb);
            System.out.println("Wywolano asynchronicznie");




        } catch (Exception exception) {
            System.err.println("Klient XML-RPC: " + exception);
        }


    }
}





