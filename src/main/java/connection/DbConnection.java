package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
        public static Connection getConnection(){//Conexão com a DB
            try{
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fastfood",
                        "postgres", "1248Mani!");
                return connection;
            }catch (SQLException e){
                System.out.println("Deu ruim aqui na conexão! :/");
                e.printStackTrace();
                return null;
            }
        }

}
