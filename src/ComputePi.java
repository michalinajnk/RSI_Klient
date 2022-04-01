import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;


//Klient
public class ComputePi {
    public static void main(String args[]) {

        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) java.rmi.Naming.lookup(name);
            Pi task = new Pi(45); //Integer.parseInt(args[1])
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            System.err.println(e.getMessage());
            System.err.println( e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
