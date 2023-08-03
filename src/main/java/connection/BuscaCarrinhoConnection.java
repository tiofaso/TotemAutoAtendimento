package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscaCarrinhoConnection {
    private String sql;
    private Connection conexao;
    public void Busca(String numpedido){

        sql = "SELECT * FROM tb_carrinho " +
                "INNER JOIN tb_bebida ON tb_carrinho.tipopedido = tb_bebida.id " +
                "INNER JOIN tb_lanche ON tb_carrinho.tipopedido = tb_lanche.id " +
                "WHERE tb_carrinho.numpedido LIKE '" + numpedido + "' AND estadopedido = 'true'";


        //Abrindo conexão
        conexao = DbConnection.getConnection();

            try {
            if (conexao != null) {
                Statement statement = conexao.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    if(resultSet.getInt("tipopedido") == 1) {//Lanche
                        System.out.println(resultSet.getInt("id") + " Item: " +
                        resultSet.getString("nomepedido") + " x " +
                        resultSet.getInt("quantidadepedido") +
                       " = R$" + resultSet.getDouble("valorpedido"));
                    }else {//Bebida
                        System.out.println(resultSet.getInt("id") + " Item: " +
                                resultSet.getString("nomepedido") + " x " +
                                resultSet.getInt("quantidadepedido") +
                                " = R$" + resultSet.getDouble("valorpedido"));
                    }


                }
                resultSet.close();
            }

        } catch (
        SQLException e) {
            System.out.println("Não foi possível achar o nome. Veja o motivo a seguir:");

            e.printStackTrace();
        }

    }
}
