package connection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscaPrecoConnection {
    private String sql;
    private Connection conexao;

    private BigDecimal valor;
    public BigDecimal getPreco(int tabela, int id) { //Retorna o tamanho do cardápio apresentado

            if(tabela == 1) {//SQL dos lanches
                sql = "SELECT id, valor FROM tb_lanche WHERE id='"+ id + "'";
            }else {//SQL das bebidas
                sql = "SELECT id, valor FROM tb_bebida WHERE id='"+ id + "'";
            }

            //Abrindo conexão
            conexao = DbConnection.getConnection();

            try {
                if (conexao != null) {
                    Statement statement = conexao.createStatement();

                    ResultSet resultSet = statement.executeQuery(sql);

                    while (resultSet.next()) {
                        valor = resultSet.getBigDecimal("valor");
                    }
                    resultSet.close();
                }

            } catch (SQLException e) {
                System.out.println("Não foi possível achar o preço. Veja o motivo a seguir:");

                e.printStackTrace();
            }

            return valor;



    }
}
