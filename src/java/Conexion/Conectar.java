/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hogar
 */
public class Conectar {

    private Statement stmt = null;
    private ResultSet resultado = null;

    public Connection conectar() {

        String url = "jdbc:mysql://localhost:3306/eren2019?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "";

        Connection conexion = null;

        try {
            Class.forName(driver);
            try {
                conexion = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

        return conexion;
    }

    public boolean ejecutarSQL(String sql) {
        //Método retorna true si la ejecución del SQL en la BD es exitosa.
        boolean resultado = true;

        try {
            stmt = conectar().createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia SQL");
            resultado = false;
        } finally {
            try {
                conectar().close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión");
            }
        }
        return resultado;
    }

    public ResultSet consultar(String sql) {

        try {
            stmt = conectar().createStatement();
            resultado = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta");
        }

        return resultado;
    }
}
