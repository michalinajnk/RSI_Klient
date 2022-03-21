
import org.apache.xmlrpc.XmlRpcClient;

import java.net.MalformedURLException;
import java.util.Vector;
import java.util.regex.Pattern;

public class KlientRPC {

    static XmlRpcClient srv = null;

    public static void main(String[] args) {
        try {
            MyData.info();
            new GUI();
            autoconnect(args);
            /*Vector<Integer> params = new Vector<Integer>();
            params.addElement(Integer.valueOf(13));
            params.addElement(Integer.valueOf(21));
            Object result = srv.execute("MojSerwer.echo", params);
            int wynik = ((Integer) result).intValue();
            System.out.println("wynik to:" + wynik);*/

            //AC cb = new AC();

            /*Vector<Integer> params2 = new Vector<Integer>();
            params2.addElement(Integer.valueOf(3000));
            srv.executeAsync("MojSerwer.execAsy", params2, cb);
            System.out.println("Wywolano asynchronicznie");

            System.out.println("Is the task done?: ");*/


            /*Vector<Object> params3 = new Vector<Object>();

            params3.addElement("c");
            params3.addElement("it has been already done");
            params3.addElement( 1.5);
            params3.addElement( 1);
            Object result2 = (String) srv.execute("MojSerwer.handleTask", params3);
            System.out.println(result2.toString());*/
        } catch (Exception exception) {
            System.err.println("Klient XML-RPC: " + exception);
        }

    }
    public static void connect(String address) throws MalformedURLException {
        srv = new XmlRpcClient(String.format("http://%s:10004",address));
    }
    private static void autoconnect(String[] args){
        try {
            String address = args.length>0 && Pattern.matches("\\d+\\.\\d+\\.\\d+\\.\\d+",args[0])?args[0]:"localhost";//if first argument doesn't seem like an address, use localhost
            connect(address);
        } catch (Exception exception) {
            System.err.println("Autoconnection failed");
        }
    }
    public static void info(){
        try {
            Object result = srv.execute("MojSerwer.info", new Vector());
            System.out.println(result.toString());
        } catch (Exception e){
            System.err.println("Info call: " + e.toString());
        }
    }
    public static void primes(int min,int max){
        try {
            Vector<Object> params = new Vector<Object>();
            params.addElement(min);
            params.addElement(max);
            AC cb = new AC();
            srv.executeAsync("MojSerwer.myPrimes", params, cb);
        } catch (Exception e){
            System.err.println("Calling myPrimes: " + e.toString());
        }
    }
    public static void dist(double lat1, double lon1, double lat2, double lon2){
        try {
            Vector<Object> params = new Vector<Object>();
            params.addElement(lat1);
            params.addElement(lon1);
            params.addElement(lat2);
            params.addElement(lon2);
            Object result2 = srv.execute("MojSerwer.distance", params);
            System.out.println(result2.toString());
        } catch (Exception e){
            System.err.println("Calling distance: " + e.toString());
        }
    }
    public static void task(String p1, String p2, double p3, int p4){
        try {
            Vector<Object> params = new Vector<Object>();
            params.addElement(p1);
            params.addElement(p2);
            params.addElement(p3);
            params.addElement(p4);
            Object result2 = srv.execute("MojSerwer.handleTask", params);
            System.out.println(result2.toString());
        } catch (Exception e){
            System.err.println("Calling handleTask: " + e.toString());
        }
    }
    public static void demo(){
        System.out.println("Starting demo");
        primes(0,10);
        primes(100000,1000000);
        dist(51.1,17.03,50.0,19.9);
        dist(-33.9,18.4,52.2,21.0);
        task("cos","costam",1.0,2);
        info();
    }
}




