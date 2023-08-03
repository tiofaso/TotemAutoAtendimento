import connection.InserirBebidasConnection;
import connection.InserirLanchesConnection;
import menu.AdmMenu;
import tool.TecladoDecimalTool;
import tool.TecladoIntergerTool;
import tool.TecladoStringTool;

import java.math.BigDecimal;

public class MainAdmin { //Admin de funções admnistrativas do totem
    public static void main(String[] args) {
        System.out.println("ADMINISTRAÇÃO");

        new AdmMenu().mostraMenu();

        //Iniciando os teclados
        TecladoIntergerTool entrada = new TecladoIntergerTool();
        TecladoDecimalTool entradaValor = new TecladoDecimalTool();
        TecladoStringTool entradaTexto = new TecladoStringTool();

        int opcao = entrada.teclado();

        while (opcao != 3){
            switch (opcao){
                case 1: //Lanche
                    String nomeLanche;
                    BigDecimal valorLanche;
                    String ingredientesLanche;

                    System.out.println("> LANCHE");
                    System.out.println("Digite o nome de lanche:");
                    nomeLanche = entradaTexto.teclado();

                    System.out.println("Digite os ingredientes do lanche:");
                    ingredientesLanche = entradaTexto.teclado();

                    System.out.println("Digite o valor do lanche:");
                    valorLanche = entradaValor.teclado();

                    new InserirLanchesConnection().lancheDb(nomeLanche,ingredientesLanche,valorLanche);
                    opcao = 0;
                    break;
                case 2: //Bebida
                    String nomeBebida;
                    BigDecimal valorBebida;

                    System.out.println("> BEBIDA");
                    System.out.println("Digite o nome da bebida:");
                    nomeBebida = entradaTexto.teclado();

                    System.out.println("Digite o valor da bebida:");
                    valorBebida = entradaValor.teclado();

                    new InserirBebidasConnection().bebidaDb(nomeBebida,valorBebida);
                    opcao = 0;

                    break;
                default:
                    new AdmMenu().mostraMenu();
                    opcao = entrada.teclado();
            }

        }


    }

}
