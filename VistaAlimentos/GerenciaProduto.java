/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaAlimentos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo
 */
public class GerenciaProduto {

    private static ArrayList<Produto> listaProduto = new ArrayList();
    private static ArrayList<Cliente> listaCliente = new ArrayList();
    private static ArrayList listaCompra = new ArrayList();

    public static void CadastrarCliente(Cliente c) {
        if (listaCliente.isEmpty()) {
            listaCliente.add(c);

            String Nome = ("C:\\DadosCliente.doc");
            File f = new File(Nome);
            f.delete();

            File arquivo = new File("C:\\vazio.doc");;

            arquivo = new File("C:\\DadosCliente.doc");
            try (FileWriter fw = new FileWriter(arquivo, true)) {
                fw.write("\n " + "\nDados dos Clientes" + "\n");

                fw.append(String.format(c.imprimir()));

                fw.write(" ");
                fw.flush();
                fw.close();
                JOptionPane.showMessageDialog(null, "Cadastro Efetuado Com Sucesso!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } else {
            listaCliente.add(c);

            File arquivo = new File("C:\\vazio.doc");;

            arquivo = new File("C:\\DadosCliente.doc");
            try (FileWriter fw = new FileWriter(arquivo, true)) {
                fw.write("\n " + "\nDados dos Clientes" + "\n");

                fw.append(String.format(c.imprimir()));

                fw.write(" ");
                fw.flush();
                fw.close();
                JOptionPane.showMessageDialog(null, "Cadastro Efetuado Com Sucesso!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void EditarCliente() {
        int busca = Integer.parseInt(JOptionPane.showInputDialog("Digite seu CPF: "));

        if (listaCliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Cliente Cadastrado!");
        } else {

            for (Cliente c : listaCliente) {
                if (c.getCpf() == busca) {
                    c.setNome(JOptionPane.showInputDialog("Digite o Nome: " + c.getNome()));
                    c.setCpf(Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF: " + c.getCpf())));
                    c.setEnd(JOptionPane.showInputDialog("Digite o Endereço: " + c.getEnd()));
                    

                    String Nome = ("C:\\DadosCliente.doc");
                    File f = new File(Nome);
                    f.delete();

                    File arquivo = new File("C:\\vazio.doc");;

                    arquivo = new File("C:\\DadosCliente.doc");
                    try (FileWriter fw = new FileWriter(arquivo, true)) {
                        fw.write("\n " + "\nDados dos Clientes" + "\n");

                        fw.append(String.format(c.imprimir()));

                        fw.write(" ");
                        fw.flush();
                        fw.close();
                        JOptionPane.showMessageDialog(null, "Cadastro Efetuado Com Sucesso!");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    
                    break;
                }
            }
        }
    }

    public static void CadastrarProduto(Produto p) {
        if (listaProduto.isEmpty()) {
            listaProduto.add(p);

            String Nome = ("C:\\DadosProduto.doc");
            File f = new File(Nome);
            f.delete();

            File arquivo = new File("C:\\vazio.doc");;

            arquivo = new File("C:\\DadosCliente.doc");
            try (FileWriter fw = new FileWriter(arquivo, true)) {
                fw.write("\n " + "\nDados dos Produtos" + "\n");

                fw.append(String.format(p.Imprimir()));

                fw.write(" ");
                fw.flush();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado Com Sucesso!");            

        } else {
            listaProduto.add(p);

            File arquivo = new File("C:\\vazio.doc");;

            arquivo = new File("C:\\DadosProduto.doc");
            try (FileWriter fw = new FileWriter(arquivo, true)) {
                fw.write("\n " + "\nDados dos Produtos" + "\n");

                fw.append(String.format(p.Imprimir()));

                fw.write(" ");
                fw.flush();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado Com Sucesso!");
            
        }
    }

    public static void ConsutaProduto() {
        if (listaProduto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Produto Cadastrado!");
        } else {
            for (Produto p : listaProduto) {
                JOptionPane.showMessageDialog(null, p.Imprimir());

            }
        }
    }

    public static void ConsutaCliente() {
        if (listaCliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Cliente Cadastrado!");
        } else {
            for (Cliente c : listaCliente) {
                JOptionPane.showMessageDialog(null, c.imprimir());

            }
        }
    }

    public static void ComprarProduto(int busca) {

        for (Cliente c : listaCliente) {
            if (c.getCpf() == busca) {
                int buscaP = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto:"));

                for (Produto p : listaProduto) {
                    if (listaProduto.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum Produto Cadastrado!!");
                    } else if (p.getCodP() == buscaP) {
                        String Recibo;
                        double valor;
                        if (p.getQtde() == 0) {
                            JOptionPane.showMessageDialog(null, "Não há Produto em estoque!!!");
                        } else {
                            int qtdeP = Integer.parseInt(JOptionPane.showInputDialog("Digite a Qtde para Comprar: " + p.getQtde() + " Em Estoque"));
                            valor = qtdeP * p.getPreco();
                            qtdeP = p.getQtde() - qtdeP;

                            p.setQtde(qtdeP);

                            Recibo = "Nome Comprador: " + c.getNome()
                                    + "\nEndereço: " + c.getEnd()
                                    + "\nNome Produto: " + p.getNomeP()
                                    + "\nCodigo Produto: " + p.getCodP()
                                    + "\nQuantidade: " + qtdeP
                                    + "\nValor Total: " + valor;
                            listaCompra.add(Recibo);

                            String nome = "C:\\DadosCompra.doc";
                            File f = new File(nome);
                            f.delete();

                            File arquivo = new File("C:\\vazio.doc");;

                            arquivo = new File("C:\\DadosCompra.doc");
                            try (FileWriter fw = new FileWriter(arquivo, true)) {

                                fw.write("\n " + "\nDados das Compras" + "\n");

                                fw.append(Recibo);

                                fw.write(" ");
                                fw.flush();
                                fw.close();

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void DeletaCliente(int buscacpf) {

        for (Cliente c : listaCliente) {
            if (listaCliente.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum Cliente Cadastrado!!");
            } else if (c.getCpf() == buscacpf) {
                listaCliente.remove(c);
                String nome = "C:\\DadosCliente.doc";
                File f = new File(nome);
                f.delete();

                File arquivo = new File("C:\\vazio.doc");;

                arquivo = new File("C:\\DadosCliente.doc");
                try (FileWriter fw = new FileWriter(arquivo, true)) {

                    for (Cliente y : listaCliente) {
                        fw.write("\n " + "\nDados dos Clientes" + "\n");

                        fw.append(String.format((y.imprimir())));

                        fw.write(" ");
                        fw.flush();
                        fw.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Cliente Excluido Com Sucesso!!");

                break;
            }
        }
    }

    public static void DeletaProduto(int buscacod) {

        for (Produto p : listaProduto) {
            if (listaProduto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum Produto Cadastrado!!");
            } else if (p.getCodP() == buscacod) {
                listaProduto.remove(p);
                String nome = "C:\\DadosProduto.doc";
                File f = new File(nome);
                f.delete();

                File arquivo = new File("C:\\vazio.doc");;

                arquivo = new File("C:\\DadosProduto.doc");
                try (FileWriter fw = new FileWriter(arquivo, true)) {

                    for (Produto x : listaProduto) {
                        fw.write("\n " + "\nDados Produtos" + "\n");

                        fw.append(String.format((x.Imprimir())));

                        fw.write(" ");
                        fw.flush();
                        fw.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Produto Excluido Com Sucesso!!");

                break;
            }
        }
    }

}
