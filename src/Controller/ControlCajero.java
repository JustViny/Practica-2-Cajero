package Controller;

import View.ViewMenus;
import Model.ModeloEnlistado;

public class ControlCajero {
    ViewMenus v=new ViewMenus();
    ModeloEnlistado m=new ModeloEnlistado();
    String mensaje="";
    int intentos=0;
    boolean salir=false;
    double saldo,retiro,deposito;
    int usuarioActual=-1;
    String opcion;

    public void inicio(){
        mensaje="=== Bienvenido al Cajero ===";
        v.showMensaje(mensaje);
        while(intentos<3 && usuarioActual==-1){
            for(int i=0;i<m.getCliente().size();i++){
                mensaje=v.login();
                if(m.getCliente().get(0).getPin().equals(mensaje)){
                    usuarioActual=i;
                    break;
                }
            }
            if(usuarioActual==-1){
                mensaje="PIN Incorrecto";
                v.showMensaje(mensaje);
                intentos++;
            }
        }
        if(usuarioActual==-1){
            mensaje="Demasiados intentos, adios.";
            v.showMensaje(mensaje);
            return;
        }
        mensaje="Bienvenido, "+m.getCliente().get(usuarioActual).getNombre();
        v.showMensaje(mensaje);

        while(!salir){
            opcion=v.menuPrincipal();
            switch(opcion){
                case "1":
                    mensaje="Su saldo es: $"+m.getCliente().get(usuarioActual).getSaldo();
                    v.showMensaje(mensaje);
                    break;
                case "2":
                    retiro=v.solicitarMonto("Ingrese cantidad a retirar: ");
                    saldo=m.getCliente().get(usuarioActual).getSaldo();
                    if(retiro<=m.getCliente().get(usuarioActual).getSaldo()){
                        saldo=saldo-retiro;
                        mensaje="Retiro exitoso.\nNuevo saldo: $"+saldo+"\n";
                        v.showMensaje(mensaje);
                        m.getCliente().get(usuarioActual).setSaldo(saldo);
                        break;
                    }else{
                        mensaje="Fondos insuficientes.";
                        v.showMensaje(mensaje);
                    }
                    break;
                case "3":
                    deposito=v.solicitarMonto("Ingrese cantidad a depositar: ");
                    saldo=m.getCliente().get(usuarioActual).getSaldo();
                    saldo=saldo+deposito;
                    mensaje="Deposito exitoso.\nNuevo saldo: $"+saldo+"\n";
                    v.showMensaje(mensaje);
                    m.getCliente().get(usuarioActual).setSaldo(saldo);
                    break;
                case "4":
                    salir=true;
                    break;
            }
        }
    }


}
