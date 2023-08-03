package engine;

import connection.BuscaCarrinhoConnection;
import connection.BuscaNomeConnection;
import connection.BuscaPrecoConnection;
import connection.TamanhoCardapioConnection;
import menu.*;
import tool.NumPedidoTool;
import tool.TecladoIntergerTool;
import tool.ValidaTecladoTool;

import java.math.BigDecimal;

public class MainEngine {
    Integer opcao;
    public void showMain(){//Motor principal do aplicativo
        System.out.println("-----------------------------------");
        System.out.println("SEJA BEM VINDE AO CATALISA LANCHES!");
        System.out.println("-----------------------------------");
        int sair = 0; //Flag para sair do looping de montar pedido

        //Gerando número do pedido
        String numPedido = new NumPedidoTool().geraNumPedido();

        while (sair == 0) {

            new PrincipalMenu().mostraMenu();

            TecladoIntergerTool entrada = new TecladoIntergerTool();

            do{//Validação do menu inicial
                opcao = entrada.teclado();
            } while (new ValidaTecladoTool().tecladoValidoPrincipal(opcao) != true);

             //=======

            new SegundoMenu().mostraMenu(opcao);
            int pedido = entrada.teclado();

            System.out.println("Qual é a quantidade?");
            int quantidadePedido = entrada.teclado();

            new CarrinhoEngine().anotaPedido(numPedido, opcao, pedido, quantidadePedido);

            System.out.println("------");
            new CarrinhoEngine().listaPedido(numPedido);

            System.out.println("\n--\nDeseja alterar algum item? (1 - SIM | 0 - NÃO)");
            int alterar = entrada.teclado();

            if(alterar == 0) {
                System.out.println("\n--\nDeseja finalizar o pedido? (1 - SIM | 0 - NÃO)");
                sair = entrada.teclado();
            }else{//Alterando pedido
                System.out.println("> ALTERAR PEDIDO");
                new CarrinhoEngine().listaPedido(numPedido);

                System.out.println("Qual o número o item que você quer alterar?");
                int itemAlterar = entrada.teclado();
                System.out.println("\nO que você deseja fazer? (1 - EDITAR | 2 - REMOVER)");
                int itemMexePedido = entrada.teclado();

                if(itemMexePedido == 1){//Editar pedido
                    System.out.println("Qual a nova quantidade?");
                    int itemQuantidade = entrada.teclado();
                    new CarrinhoEngine().atualizaPedido(numPedido,itemAlterar,itemQuantidade,opcao,pedido);

                }else {//Apagar pedido
                    new CarrinhoEngine().apagaPedido(numPedido,itemAlterar);

                    System.out.println("Seus pedidos atualizados:");
                    new CarrinhoEngine().listaPedido(numPedido);
                    System.out.println("-----\n");

                    System.out.println("\n--Deseja finalizar o pedido? (1 - SIM | 0 - NÃO)");
                    sair = entrada.teclado();

                }


            }

            if(sair == 1) {//Pagando o pedido
                System.out.println("> PAGAMENTO");
                System.out.println("Esse é o seu pedido:");
                new CarrinhoEngine().listaPedido(numPedido);
                System.out.println("-----");
                System.out.println("Total a pagar: R$" + new CarrinhoEngine().fecharPedido(numPedido));
                System.out.println("\n");
                new PagamentoMenu().mostraMenu();
                int pagamentoEscolhido = entrada.teclado();

                System.out.println("Compra finalizada com sucesso! Boa refeição!");
            }

        }


    }
}
