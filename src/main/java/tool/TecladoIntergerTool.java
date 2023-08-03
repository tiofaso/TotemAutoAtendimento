package tool;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TecladoIntergerTool {
    private Integer valorDigitado;

    public Integer teclado() {
        Scanner entrada = new Scanner(System.in);

        valorDigitado = entrada.hasNextInt() ? entrada.nextInt() : null;

        return valorDigitado;
    }
}
