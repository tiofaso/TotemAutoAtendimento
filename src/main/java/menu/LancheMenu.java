package menu;

import connection.BuscaLanchesConnection;

import java.awt.*;
import java.util.List;

public class LancheMenu {
    private int id = 1;

    public void mostraLanche(){
        BuscaLanchesConnection lista = new BuscaLanchesConnection();
        List<String> lanches = lista.buscaLanches();

        System.out.println("> LANCHES");
        System.out.println("Escolha uma das opções abaixo:");

        for (String i : lanches ) {
            System.out.println(id + " - " + i);
            id++;
        }

    }
}
