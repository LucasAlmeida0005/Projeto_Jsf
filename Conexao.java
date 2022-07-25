/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class Conexao {
    private Connection conexao= null;
    private final String bd = "loja";
    private final String usuario = "root";
    private final String senha = "";
    
    public Connection conectar(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao= DriverManager.getConnection("jdbc:mysql://localhost/" + this.bd,
                    this.usuario, this.senha);
        } catch(ClassNotFoundException e1){
            
            System.out.println("Erro com driver: "+ e1.getMessage());
            
        } catch(SQLException e2){
            
            System.out.println("Erro na tentativa de conexão: "+ e2.getMessage());   
        }
        return conexao;
    }
    
}
