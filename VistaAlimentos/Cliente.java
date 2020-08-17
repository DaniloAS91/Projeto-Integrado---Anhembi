/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaAlimentos;

/**
 *
 * @author Danilo
 */
public class Cliente{
    
    private String nome;
    private int cpf;
    private String end;

    public Cliente(String vNome, int vCpf, String vEnd){
        nome = vNome;
        cpf = vCpf;
        end = vEnd;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    
    
    public String imprimir(){
        return  "\nNome: "+nome+
                "\nCPF: "+cpf+
                "\nEnd.:"+end;
    }
}
