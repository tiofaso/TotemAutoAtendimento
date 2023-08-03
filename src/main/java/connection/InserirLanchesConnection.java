package connection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InserirLanchesConnection {
    private String sql;
    private Connection conexao;
    public void lancheDb(String nomelanche, String ingredientelanche, BigDecimal valor){
        sql = "INSERT INTO tb_lanche (nomelanche,ingredientelanche,valor) " +
                "VALUES ('" + nomelanche + "', '" + ingredientelanche + "', '" + valor + "')";

        //Abrindo conexão
        conexao= DbConnection.getConnection();

        //Primeira inserção de dados
        try{
            if(conexao != null) {
                Statement statement = conexao.createStatement();

                statement.executeUpdate(sql);

                System.out.println("Lanche inserido com sucesso na base de dados!");
            }

        }catch (SQLException e) {
            System.out.println("Não foi possível inserir o lanche na base de dados. Veja o motivo a seguir:");

            e.printStackTrace();
        }

    }
}
