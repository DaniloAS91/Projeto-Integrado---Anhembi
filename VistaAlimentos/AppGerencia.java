/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaAlimentos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.lang.StringBuilder;
/**
 *
 * @author Danilo
 */
public class AppGerencia {
    
    public static void main (String []args){
    
        StringBuilder sb = new StringBuilder();

        int op;
        
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(
                                            "O que deseja fazer: "+
                                            "\n1 - Efetuar Cadatro de Cliente" +
                                            "\n2 - Editar Cadastro de Cliente" +
                                            "\n3 - Consultar Clientes" +
                                            "\n4 - Deletar Cadastro de Cliente"+
                                            "\n5 - Consultar Produto" +
                                            "\n6 - Efetuar Cadastro de Produto"+
                                            "\n7 - Deletar Cadastro de Produto"+
                                            "\n8 - Comprar Produto" +
                                            "\n9 - Sair" ));
        
        switch(op){
            case 1:
                Cliente c = new Cliente(
                JOptionPane.showInputDialog("Digite o Nome do Cliente: "),
                Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF do Cliente: ")),
                JOptionPane.showInputDialog("Digite o Endereço do Cliente: ")
                );
                
                GerenciaProduto.CadastrarCliente(c);
                                                                            
                break;
                
            case 2:
                
                GerenciaProduto.EditarCliente();
                
                break;
           
            case 3:
                
                GerenciaProduto.ConsutaCliente();
                                
                break;               
                
            case 4:
                
                int buscacpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF do Cliente: "));
                GerenciaProduto.DeletaCliente(buscacpf);
                
                break;
                
            case 5:
                
                GerenciaProduto.ConsutaProduto();
                
                break;
                
            case 6:
                
                Produto p = new Produto(JOptionPane.showInputDialog("Digite o Nome do Produto: "),
                       Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do Produto: ")),
                       Integer.parseInt(JOptionPane.showInputDialog("Digite a Quantidade de Produtos: ")),
                       Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor do Produto: ")));
                
                GerenciaProduto.CadastrarProduto(p);

                break;
                
            case 7:
                
                int buscacod = Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do Produto: "));
                GerenciaProduto.DeletaProduto(buscacod);
                                
                break;
                
            case 8:
                
                int busca = Integer.parseInt(JOptionPane.showInputDialog("Digite seu CPF:"));
                GerenciaProduto.ComprarProduto(busca);
                
                
                
                break;
                                
            case 9:
                System.exit(0);
                break;
            }
        }while(op>=1 && op<=8);
    }
}
