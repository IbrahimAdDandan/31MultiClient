/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiscoreserver;

import java.sql.*;

/**
 *
 * @author ibrahim
 */
public class DBConnector {

    private Connection connection;

    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmiscores", "root", "");
    }

    public void connectSQLServer() throws SQLException {
        String connectionUrl = "jdbc:sqlserver://IBRA\\SQLEXPRESS:1433; databaseName=rmiscores;" + 
                "username=sa;password=Nanoibrahim67;ApplicationIntent=ReadWrite;MultiSubnetFailover=False";
        this.connection = DriverManager.getConnection(connectionUrl);
    }

    public void incLose(int clientIndex) throws SQLException {
        Statement st = this.connection.createStatement();
        st.executeUpdate("UPDATE client_scores SET lose_counter = lose_counter + 1, total_counter = total_counter - 1 WHERE client_id =" + (clientIndex - 1) + ";");
    }

    public void incWin(int length, int clientIndex) throws SQLException {
        Statement st = this.connection.createStatement();
        st.executeUpdate("UPDATE client_scores SET win_counter = win_counter + 1, total_counter = total_counter + 1 WHERE client_id != " + (clientIndex - 1) + " AND client_id < " + length + ";");
    }

    public ResultSet results() throws SQLException {
        Statement st = this.connection.createStatement();
        ResultSet result;
        result = st.executeQuery("SELECT * FROM client_scores ORDER BY total_counter desc;");
        return result;
    }
    
    public void initDB() throws SQLException {
        Statement st = this.connection.createStatement();
        st.execute("create table client_scores (client_id int, client_name varchar(25), win_counter int, lose_counter int, total_counter int);");
    }
    public void addData() throws SQLException {
        Statement st = this.connection.createStatement();
        st.execute("insert into client_scores values (0, 'client1', 0, 0, 0),(1, 'client2', 0, 0, 0),(2, 'client3', 0, 0, 0), (3, 'client4', 0, 0, 0),(4, 'client5', 0, 0, 0);");
    }
}
