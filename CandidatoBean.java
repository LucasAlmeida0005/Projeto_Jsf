/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */

@ManagedBean(name = "candidato")
@SessionScoped

public class CandidatoBean {
    
    private Candidato can;
    
    public CandidatoBean(){
        can = new Candidato();
    }

    public Candidato getCan() {
        return can;
    }

    public void setCan(Candidato can) {
        this.can = can;
    }
    
    private String nome;
    private String sobrenome;
    private String tiposanguineo;
    private String msg;
    private String peso;

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

  
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobre) {
        this.sobrenome = sobre;
    }

    public String getTiposanguineo() {
        return tiposanguineo;
    }

    public void setTiposanguineo(String tipo) {
        this.tiposanguineo = tipo;
    }
    
    public String mensagem(){
        
        switch(tiposanguineo){
            case "O+":
                switch(peso){
                    case "N":
                      msg= "Você pode receber sangue dos tipos: O+ e O-. E não pode doar devido ao peso abaixo de 50";
                      break;
                    case "S":
                      msg= "Você pode receber sangue dos tipos: O+ e O-. E doar para A+, B+, O+, AB+";
                      break;
                }
                break;
                
            case "O-":
                switch(peso){
                    case "N":
                      msg= "Você pode receber sangue do tipo: O-. E não pode doar devido ao peso abaixo de 50";
                      break;
                    case "S":
                      msg= "Você pode receber sangue do tipo: O-. E doar para TODOS";
                      break;
                }
                break;
                
            case "A+":
                
                switch(peso){
                    case "N":
                      msg= "Você pode receber sangue do tipo: A+, A-, O+, O-. E não pode doar devido ao peso abaixo de 50";
                      break;
                    case "S":
                      msg= "Você pode receber sangue do tipo: A+, A-, O+, O-. E doar para AB+, A+";
                      break;
                }
                break;
                
            case "A-":
                switch(peso){
                    case "N":
                      msg= "Você pode receber sangue do tipo: A-, O-. E não pode doar devido ao peso abaixo de 50";
                      break;
                    case "S":
                      msg= "Você pode receber sangue do tipo: A-, O-. E doar para A+, A-, AB+, AB-";
                      break;
                } 
                break;
                
            case "B+":
                switch(peso){
                    case "N":
                      msg= "Você pode receber sangue do tipo: B+, B-, O+, O-. E não pode doar devido ao peso abaixo de 50";
                      break;
                    case "S":
                      msg= "Você pode receber sangue do tipo: B+, B-, O+, O-. E doar para B+, AB+";
                      break;
                } 
                break;
                
            case "B-":
                switch(peso){
                    case "N":
                      msg= "Você pode receber sangue do tipo: B-, O-. E não pode doar devido ao peso abaixo de 50";
                      break;
                    case "S":
                      msg= "Você pode receber sangue do tipo: B-, O-. E doar para B+, B-, AB+, AB-";
                      break;
                } 
                break;
                
            case "AB+":
                switch(peso){
                    case "N":
                      msg= "Você pode receber sangue de TODOS OS TIPOS. E não pode doar devido ao peso abaixo de 50";
                      break;
                    case "S":
                      msg= "Você pode receber sangue de TODOS OS TIPOS. E doar para AB+";
                      break;
                } 
                break;
                
            case "AB-":
                switch(peso){
                    case "N":
                      msg= "Você pode receber sangue do tipo: A-, B-, AB- ,O-. E não pode doar devido ao peso abaixo de 50";
                      break;
                    case "S":
                     msg="Você pode receber sangue do tipo: A-, B-, AB- ,O-. E doar para AB+, AB-";
                      break;
                } 
                break;
        }
       return msg;
        
    }
    
    
    public boolean gravarevento(){
           try{
            Connection conexao = new Conexao().conectar();
            
            if(conexao != null){
                PreparedStatement ps;
                String sql = "insert into vagas(nome, sobrenome, tiposangue)values(?,?,?)";
                ps = conexao.prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2, sobrenome);
                ps.setString(3, tiposanguineo);
                 
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
