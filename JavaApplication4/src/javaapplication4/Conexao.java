package javaapplication4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {

    private static final String URL = "jdbc:mariadb://localhost:3306/bd_login";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public Connection conexao = null;
    public Statement stmt = null;
    public ResultSet resultset = null;

    public Connection conectar() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            stmt = conexao.createStatement();
            System.out.println("✅ Conexão realizada com sucesso!");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Driver JDBC do MariaDB não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Erro ao conectar ao banco de dados:");
            e.printStackTrace();
        }
        return conexao;
    }

    public static void desconectar(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("🔒 Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.err.println("❌ Erro ao fechar a conexão:");
                e.printStackTrace();
            }
        }
    }

    public void main(String[] args) {
        Connection conn = conectar();
        desconectar(conn);
    }

}
