package menu;

import java.util.HashMap;
import java.util.Map;

public class PagamentoMenu {
    private final Map<Integer, String> menu = new HashMap<Integer, String>();

    public void mostraMenu() {//Menu padrão do programa

        menu.put(1, "Débito");
        menu.put(2, "Crédito");
        menu.put(3, "Vale Refeição");

        System.out.println("> FORMA DE PAGAMENTO");
        System.out.println("Escolha uma das opções abaixo:");
        for (Integer key : menu.keySet()) {
            System.out.println(key + " - " + menu.get(key));
        }
    }
}
