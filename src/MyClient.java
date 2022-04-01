import java.net.UnknownHostException;

public class MyClient {
    /*
    public static void main(String[] args) {
        try {
            MyData.info();
        } catch (UnknownHostException e) {e.printStackTrace();}
        double wynik;
        ResultType wynik2;
        InputType inObj;

        CalcObject zObiekt;
        CalcObject2 zObiekt2;
        if (args.length == 0) {
            System.out.println("You have to enter RMI object address in the form: // host_address/service_name ");
            return;
        }
        String adres = args[0];
// //use this if needed
// if (System.getSecurityManager() == null)
// System.setSecurityManager(new SecurityManager());
        try {
            zObiekt = (CalcObject) java.rmi.Naming.lookup(adres);
        } catch (Exception e) {
            System.out.println("Nie mozna pobrac referencji do "+adres);
            e.printStackTrace();
            return;
        }
        System.out.println("Referencja do "+adres+" jest pobrana.");
        try {
            wynik = zObiekt.calculate(0.3, 0.7);
        } catch (Exception e) {
            System.out.println("Blad zdalnego wywolania.");
            e.printStackTrace();
            return;
        }
        System.out.println("Wynik = "+wynik);

        String adres2 = args[1];

        try {
            zObiekt2 = (CalcObject2) java.rmi.Naming.lookup(adres2);
        } catch (Exception e) {
            System.out.println("Nie mozna pobrac referencji do "+adres2);
            e.printStackTrace();
            return;
        }
        System.out.println("Referencja do "+adres2+" jest pobrana.");
        try {
            inObj = new InputType();
            inObj.x1=101.1;
            inObj.x2=202.2;
            inObj.operation="add";
            wynik2 = zObiekt2.calculate(inObj);
        } catch (Exception e) {
            System.out.println("Blad zdalnego wywolania.");
            e.printStackTrace();
            return;
        }
        System.out.println(wynik2.result_description+", wynik = "+wynik2.result);
        return;


    }

     */
}