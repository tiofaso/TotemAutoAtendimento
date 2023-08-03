package menu;

import java.util.HashMap;
import java.util.Map;

public class AdmMenu {
    private final Map<Integer, String> menu = new HashMap<Integer, String>();

    public void mostraMenu() {//Menu padrão do programa

        menu.put(1, "Lanches");
        menu.put(2, "Bebidas");
        menu.put(3, "Sair");

        System.out.println("> MENU PRINCIPAL");
        System.out.println("Escolha uma das opções abaixo:");
        for (Integer key : menu.keySet()) {
            System.out.println(key + " - " + menu.get(key));
        }
    }

}
