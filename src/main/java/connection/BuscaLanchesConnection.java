package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuscaLanchesConnection {
    private String sql;
    private Connection conexao;

    private List<String> lanches = new ArrayList<>();
    public List<String> buscaLanches() {
        sql = "SELECT id, nomelanche FROM tb_lanche ORDER BY id";

        //Abrindo conexão
        conexao = DbConnection.getConnection();

        try {
            if (conexao != null) {
                Statement statement = conexao.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    lanches.add(resultSet.getString("nomelanche"));
                }
                resultSet.close();
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível listar os lanches. Veja o motivo a seguir:");

            e.printStackTrace();
        }

        return lanches;

    }
}
