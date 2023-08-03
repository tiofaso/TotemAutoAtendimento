package connection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsereCarrinhoConnection {
    private String sql;
    private Connection conexao;
    public void Insere(String numpedido, int tipopedido, int escolhapedido, int quantidadepedido, BigDecimal valorpedido, String nomepedido) {
        sql = "INSERT INTO tb_carrinho (numpedido, tipopedido, escolhapedido, quantidadepedido, valorpedido, nomepedido, estadopedido) " +
                "VALUES ('" + numpedido + "','" + tipopedido + "','" + escolhapedido + "','" + quantidadepedido +
                "','" + valorpedido + "','" + nomepedido + "','" + "true" + "')";

        //Abrindo conexão
        conexao = DbConnection.getConnection();

        //Primeira inserção de dados
        try {
            if (conexao != null) {
                Statement statement = conexao.createStatement();

                statement.executeUpdate(sql);
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível inserir o pedido na base de dados. Veja o motivo a seguir:");

            e.printStackTrace();
        }
    }
}
