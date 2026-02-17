package View;
import java.util.Scanner;

public class ViewMenus {
    String entrada="",pin;
    double monto;
    
    Scanner read=new Scanner(System.in);
    
    public void showMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public String login(){
        System.out.println("Ingrese su PIN: ");
        pin=read.nextLine();
        return pin;
    }

    public String menuPrincipal(){
        System.out.println("\n1. Ver saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        entrada=read.nextLine();
        return entrada;
    }

    public double solicitarMonto(String mensaje){
        System.out.println(mensaje);
        monto=read.nextDouble();
        return monto;
    }

    public static void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("No se pudo limpiar la consola.");
        }
    }

}
