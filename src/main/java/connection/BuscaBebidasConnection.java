package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuscaBebidasConnection {
    private String sql;
    private Connection conexao;

    private List<String> bebidas = new ArrayList<>();
    public List<String> buscaBebidas() {
        sql = "SELECT id, nomebebida FROM tb_bebida ORDER BY id";

        //Abrindo conexão
        conexao = DbConnection.getConnection();

        try {
            if (conexao != null) {
                Statement statement = conexao.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    bebidas.add(resultSet.getString("nomebebida"));
                }
                resultSet.close();
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível listar as bebidas. Veja o motivo a seguir:");

            e.printStackTrace();
        }

        return bebidas;

    }
}
