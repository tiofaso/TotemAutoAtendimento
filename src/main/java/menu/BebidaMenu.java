package menu;

import connection.BuscaBebidasConnection;
import connection.BuscaLanchesConnection;

import java.util.List;

public class BebidaMenu {
    private int id = 1;
    public void mostraBebida(){
        BuscaBebidasConnection lista = new BuscaBebidasConnection();
        List<String> bebidas = lista.buscaBebidas();

        System.out.println("> BEBIDAS");
        System.out.println("Escolha uma das opções abaixo:");

            for (String i : bebidas ) {
                System.out.println(id + " - " + i);
                id++;
            }
    }
}
