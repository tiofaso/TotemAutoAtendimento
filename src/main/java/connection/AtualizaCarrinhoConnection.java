package connection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AtualizaCarrinhoConnection {
    private String sql;
    private Connection conexao;
    public void Atualiza(String numpedido, int id, int quantidadepedido, BigDecimal valorpedido){
        sql = "UPDATE tb_carrinho SET quantidadepedido = '" + quantidadepedido +
                "' , valorpedido = '" + valorpedido + "' WHERE id = '" + id + "'";

        //Abrindo conexão
        conexao = DbConnection.getConnection();

        //Primeira inserção de dados
        try {
            if (conexao != null) {
                Statement statement = conexao.createStatement();

                statement.executeUpdate(sql);
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível atualizar o pedido na base de dados. Veja o motivo a seguir:");

            e.printStackTrace();
        }

    }
}
