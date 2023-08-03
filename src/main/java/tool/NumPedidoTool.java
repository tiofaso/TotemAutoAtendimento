package tool;

import java.util.Random;

public class NumPedidoTool {
    public String geraNumPedido() {
        Random random = new Random();
        int randomNumber = 10000000 + random.nextInt(90000000);
        return "#" + randomNumber;
    }
}
