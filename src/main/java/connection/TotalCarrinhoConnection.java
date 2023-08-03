package connection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TotalCarrinhoConnection {
    private String sql;
    private Connection conexao;
    private Double totalPagar;
    public BigDecimal Total(String numpedido){

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

                totalPagar = (double) 0;

                while (resultSet.next()) {

                    totalPagar = totalPagar + resultSet.getDouble("valorpedido");

                }

                resultSet.close();
            }

        } catch (
        SQLException e) {
            System.out.println("Não foi possível achar o nome. Veja o motivo a seguir:");

            e.printStackTrace();
        }
        return BigDecimal.valueOf(totalPagar);
    }
}
