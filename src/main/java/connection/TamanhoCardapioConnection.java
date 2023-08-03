package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TamanhoCardapioConnection {
    private String sql;
    private Connection conexao;

    private int totalRegistros = 0;
    public int getTamanho(int tabela) { //Retorna o tamanho do cardápio apresentado

            if(tabela == 1) {//SQL dos lanches
                sql = "SELECT id FROM tb_lanche ORDER BY id";
            }else {//SQL das bebidas
                sql = "SELECT id FROM tb_bebida ORDER BY id";
            }

            //Abrindo conexão
            conexao = DbConnection.getConnection();

            try {
                if (conexao != null) {
                    Statement statement = conexao.createStatement();

                    ResultSet resultSet = statement.executeQuery(sql);

                    while (resultSet.next()) {
                        totalRegistros++;
                    }
                    resultSet.close();
                }

            } catch (SQLException e) {
                System.out.println("Não foi possível listar as bebidas. Veja o motivo a seguir:");

                e.printStackTrace();
            }

            return totalRegistros;



    }
}
