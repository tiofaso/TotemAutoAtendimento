package connection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InserirBebidasConnection {
    private String sql;
    private Connection conexao;
    public void bebidaDb(String nomebebida, BigDecimal valor){
        sql = "INSERT INTO tb_bebida (nomebebida,valor) " +
                "VALUES ('" + nomebebida + "', '" + valor + "')";

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
