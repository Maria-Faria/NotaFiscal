package notafiscal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NotaFiscal {

    public static void armazenarDados(ArrayList<Produto> venda, String nome, double valor, int qtd, double total) {
        Produto p = new Produto(nome, valor, qtd, total);
        venda.add(p);
    }

    public static File criarArquivo() throws IOException{
        File f = new File("notafiscal.txt");

        return f;
    }

    public static void escreverArquivo(ArrayList<Produto> venda, double compra) {
        String espaco = "PRODUTO           ";
        int espaco2;
        String espaco3;

        try {
            FileWriter writer = new FileWriter("notafiscal.txt");
            PrintWriter printwriter = new PrintWriter(writer);

            printwriter.println("==================================================");
            printwriter.println("PRODUTO           QUANT          PREÇO \t\t TOTAL");

            for(int i = 0; i < venda.size(); i++) {
                espaco3 = " ";
                espaco2 = espaco.length() - venda.get(i).getNome().length();

                for(int j = 0; j < espaco2; j++) {
                    espaco3 += " ";
                }
            
                printwriter.println(venda.get(i).getNome() + espaco3 + venda.get(i).getQtd() + "   \t\t " + venda.get(i).getValor() + " \t\t " + venda.get(i).getTotal());

            }

            printwriter.println("==================================================");
            printwriter.println("\n\t\t\t Valor total da compra:     " + compra);
            printwriter.close();
        
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int op, qtd;
        String op2[] = {"Adicionar novo produto", "Sair"};
        String nome;
        double valor, total, compra = 0;
        
        ArrayList<Produto> venda = new ArrayList<Produto>();

        do{
            total = 0;
            op = JOptionPane.showOptionDialog(null, "Selecione uma opção", "O que você deseja fazer?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op2, 0);
            
            if(op == 0) {
                nome = JOptionPane.showInputDialog(null, "Digite o nome do produto: ");
                valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor unitário do produto: "));
                qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de produto comprada: "));

                total += valor * qtd;
                compra += total;

                armazenarDados(venda, nome, valor, qtd, total);
            
            }else{
                break;
            }

        }while(op != 1);    

        try {
            criarArquivo();
            escreverArquivo(venda, compra);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
