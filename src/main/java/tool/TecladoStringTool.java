package tool;

import java.util.Scanner;

public class TecladoStringTool {
    private String valorDigitado;

    public String teclado() {
        Scanner entrada = new Scanner(System.in);

        valorDigitado = entrada.nextLine();
        return valorDigitado;
    }
}
