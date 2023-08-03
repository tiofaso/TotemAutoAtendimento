package menu;

import connection.TamanhoCardapioConnection;

public class SegundoMenu {
    public void mostraMenu(int opcao){
        //Exibindo opções
        int totalItens = 0; //Informa a quantidade de itens
        int tipoIten; //Informa em qual parte do menu a pessoa está escolhendo

        if(opcao == 1) { //Lanches
            new LancheMenu().mostraLanche();

            tipoIten = 1; //lanche

            //Tamanho total do cardápio
            TamanhoCardapioConnection tamanho = new TamanhoCardapioConnection();
            totalItens = tamanho.getTamanho(1) + 1;
        }else if(opcao == 2) { //Bebidas
            new BebidaMenu().mostraBebida();

            tipoIten = 2; //Bebida

            //Tamanho total do cardápio
            TamanhoCardapioConnection tamanho = new TamanhoCardapioConnection();
            totalItens = tamanho.getTamanho(1) + 1;
        }
    }
}
