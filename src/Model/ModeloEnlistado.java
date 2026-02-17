package Model;
import java.util.ArrayList;

public class ModeloEnlistado {
    private ArrayList<ModeloCliente> cliente; 
    public ModeloEnlistado(){
        cliente=new ArrayList<>();
        cliente.add(new ModeloCliente("1234","Juan",1000.0));
        cliente.add(new ModeloCliente("5678","Maria",1000.0));
    }
    public ArrayList<ModeloCliente> getCliente(){
        return cliente;
    }
}
