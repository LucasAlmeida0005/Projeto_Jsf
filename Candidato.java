/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class Candidato {
    private String nome;
    private boolean analista;
    private boolean programador;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAnalista() {
        return analista;
    }

    public void setAnalista(boolean analista) {
        this.analista = analista;
    }

    public boolean isProgramador() {
        return programador;
    }

    public void setProgramador(boolean programador) {
        this.programador = programador;
    }
    
    
    public boolean gravar(){
        
     try{
            Connection conexao = new Conexao().conectar();
            
            if(conexao != null){
                PreparedStatement ps;
                String sql = "insert into vagas(nome)values(?)";
                ps = conexao.prepareStatement(sql);
                ps.setString(1, nome);
               
                
                System.out.println(ps);
                JOptionPane.showMessageDialog(null,ps);
                ps.executeUpdate();
                conexao.close();
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
                    System.err.println(e.getMessage());
                    return false;
         }
    }
        
}
