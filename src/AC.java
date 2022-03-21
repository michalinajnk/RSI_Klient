

import org.apache.xmlrpc.AsyncCallback;

import java.net.URL;

public class AC implements AsyncCallback {

    public void handleResult(Object rezultat, URL url, String metoda){
        System.out.println("Adres URL to: " + url.toString()+ "metoda: " + metoda +  "Rezultat :"  + rezultat.toString());

    }

    public void handleError(Exception e, URL url, String metoda){
        System.out.println("Adres URL : " + url.toString()+ "Wystapił błąd: "+ e.getMessage() + " przy wywołaniu metody: " + metoda );
    }
}
