package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ApagaCarrinhoConnection {
    private String sql;
    private Connection conexao;
    public void Apaga(String numpedido,int id){
        sql = "UPDATE tb_carrinho SET estadopedido = 'false' WHERE id = '" + id + "'";

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
