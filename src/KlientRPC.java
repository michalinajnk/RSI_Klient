
import org.apache.xmlrpc.XmlRpcClient;

import java.util.Vector;
import java.util.regex.Pattern;

public class KlientRPC {

    public static void main(String[] args) {
        try {
            MyData.info();
            String address = args.length>0 && Pattern.matches("\\d+\\.\\d+\\.\\d+\\.\\d+",args[0])?args[0]:"localhost";//if first argument doesn't seem like an address, use localhost
            XmlRpcClient srv = new XmlRpcClient(String.format("http://%s:10004",address));
            Vector<Integer> params = new Vector<Integer>();
            params.addElement(Integer.valueOf(13));
            params.addElement(Integer.valueOf(21));
            Object result = srv.execute("MojSerwer.echo", params);
            int wynik = ((Integer) result).intValue();
            System.out.println("wynik to:" + wynik);
            AC cb = new AC();

            Vector<Integer> params2 = new Vector<Integer>();
            params2.addElement(Integer.valueOf(3000));
            srv.executeAsync("MojSerwer.execAsy", params2, cb);
            System.out.println("Wywolano asynchronicznie");




        } catch (Exception exception) {
            System.err.println("Klient XML-RPC: " + exception);
        }


    }
}





