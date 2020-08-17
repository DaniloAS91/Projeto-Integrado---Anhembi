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
public class Produto {

    private String nomeP;
    private int codP;
    private int qtde;
    private double preco;
    
    public Produto(String vNomeP, int vCodP, int vQtde, double vPreco){
        nomeP = vNomeP;
        codP = vCodP;
        qtde = vQtde;
        preco = vPreco;
        
    }

    public int getCodP() {
        return codP;
    }
    public void setCodP(int codP) {
        this.codP = codP;
    }

    
    public String getNomeP() {
        return nomeP;
    }
    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    
    public int getQtde() {
        return qtde;
    }
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String Imprimir(){
        return  "Nome do Produto: "+nomeP+
                "\nCodigo do Produto: "+codP+
                "\nQuantidade: "+qtde+
                "\nPreço: "+preco;
    }
}
