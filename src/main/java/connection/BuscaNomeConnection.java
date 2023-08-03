package connection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscaNomeConnection {
    private String sql;
    private Connection conexao;

    private String nome;
    public String getNome(int tabela, int id) { //Retorna o tamanho do cardápio apresentado

            if(tabela == 1) {//SQL dos lanches
                sql = "SELECT id, nomelanche FROM tb_lanche WHERE id='"+ id + "'";
            }else {//SQL das bebidas
                sql = "SELECT id, nomebebida FROM tb_bebida WHERE id='"+ id + "'";
            }

            //Abrindo conexão
            conexao = DbConnection.getConnection();

            try {
                if (conexao != null) {
                    Statement statement = conexao.createStatement();

                    ResultSet resultSet = statement.executeQuery(sql);

                    while (resultSet.next()) {
                        if(tabela == 1) {//SQL dos lanches
                            nome = resultSet.getString("nomelanche");
                        }else {//SQL das bebidas
                            nome = resultSet.getString("nomebebida");
                        }

                    }
                    resultSet.close();
                }

            } catch (SQLException e) {
                System.out.println("Não foi possível achar o nome. Veja o motivo a seguir:");

                e.printStackTrace();
            }

            return nome;



    }
}
