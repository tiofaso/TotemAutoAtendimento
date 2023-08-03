package engine;

import connection.*;

import java.math.BigDecimal;

public class CarrinhoEngine {
    public void anotaPedido(String numpedido, int tipoPedido, int escolhaPedido, int quantidadePedido){

        BigDecimal valorProduto = new BuscaPrecoConnection().getPreco(tipoPedido,escolhaPedido);

        BigDecimal valorFinal = valorProduto.multiply(BigDecimal.valueOf(quantidadePedido));

        System.out.println("Item: " + new BuscaNomeConnection().getNome(tipoPedido,escolhaPedido) + " X " +
                quantidadePedido + " = R$" + valorFinal );

        //O join tá puxando o nome errado da base! D:
        String nomePedido = new BuscaNomeConnection().getNome(tipoPedido,escolhaPedido);

        new InsereCarrinhoConnection().Insere(numpedido, tipoPedido, escolhaPedido, quantidadePedido, valorFinal, nomePedido);
    }

    public void listaPedido(String numpedido){
        new BuscaCarrinhoConnection().Busca(numpedido);
    }

    public void apagaPedido(String numpedido, int id){
        new ApagaCarrinhoConnection().Apaga(numpedido, id);
    }

    public void atualizaPedido(String numpedido, int id, int quantidadePedido,int tabela, int idpedido){

        BigDecimal valorProduto = new BuscaPrecoConnection().getPreco(tabela, idpedido);

        BigDecimal valorPedido = valorProduto.multiply(BigDecimal.valueOf(quantidadePedido));

        new AtualizaCarrinhoConnection().Atualiza(numpedido,id,quantidadePedido,valorPedido);
    }

    public BigDecimal fecharPedido(String numpedido){
        return new TotalCarrinhoConnection().Total(numpedido);
    }

    public void pagarConta(String numpedido, String tipopagamento){
        new InserirPagamentoConnection().Pagar(numpedido,tipopagamento,fecharPedido(numpedido));
    }
}
