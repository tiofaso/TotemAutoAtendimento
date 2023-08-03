package connection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InserirPagamentoConnection {
    private String sql;
    private Connection conexao;
    public void Pagar(String numpedido, String tipopagamento, BigDecimal valorconta){
        sql = "INSERT INTO tb_pedido (numpedido,tipopagamento, valorconta) " +
                "VALUES ('" + numpedido + "', '" + tipopagamento + "', '" + valorconta + "')";

        //Abrindo conexão
        conexao= DbConnection.getConnection();

        //Primeira inserção de dados
        try{
            if(conexao != null) {
                Statement statement = conexao.createStatement();

                statement.executeUpdate(sql);

            }

        }catch (SQLException e) {
            System.out.println("Não foi possível inserir o lanche na base de dados. Veja o motivo a seguir:");

            e.printStackTrace();
        }

    }
}
