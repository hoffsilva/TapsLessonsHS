import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by hoffsilva on 27/04/17.
 */
public class AppAula15 {

    ArrayList<String> frases;

    public AppAula15() {
        frases = new ArrayList();
    }

    public void listaFrases() {
        StringBuffer sb = new StringBuffer();
        String resp;
        if (frases.isEmpty()) {
            resp = "Arraylist vazio";
        } else {
            for (String frase : frases) {
                sb.append(frase).append("\n");
            }
            resp = sb.toString();
        }
        JOptionPane.showMessageDialog(null, resp);
    }

    //metodo para inserir frases
    public void insereFrases() {
        String string = JOptionPane.showInputDialog("Digite a frase desejada");
        if (frases.contains(string)) {
            JOptionPane.showMessageDialog(null, "Frase já foi cadastrada");
        } else {
            frases.add(string);
        }
    }

    //metodo para apagar frase
    public void apagaFrase() {
        String string = JOptionPane.showInputDialog("Digite a frase desejada");
        if (frases.contains(string)) {
            int index = frases.indexOf(string);
            frases.remove(index);
            JOptionPane.showMessageDialog(null, "Frase removida");
        } else {
            JOptionPane.showMessageDialog(null, "Frase nao existe");
        }
    }

    //metodo para modificar a frase
    public void alteraFrase() {
        String string = JOptionPane.showInputDialog("Digite a frase desejada");
        if (frases.contains(string)) {
            int index = frases.indexOf(string);
            String newString = JOptionPane.showInputDialog("Altere a frase", string);
            while (frases.contains(newString)) {
                JOptionPane.showMessageDialog(null, "Frase já foi cadastrada");
                newString = JOptionPane.showInputDialog("Altere a frase", newString);
            }
            frases.set(index,newString);
            JOptionPane.showMessageDialog(null, "Frase atualizada");
        } else {
            JOptionPane.showMessageDialog(null, "Frase nao existe");
        }
    }

    // método para leitura de valores inteiros
    public int lerValor(String msg) {
        int vl = 0;
        while (true) {
            try {
                vl = Integer.parseInt(JOptionPane.showInputDialog(msg));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número Inválido", "Ler Valor",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return vl;
    }
    // método para a montagem do menu da aplicação

    public int montaMenu() {
        int opcao = 0;
        String menu = "   Menu\n\n"
                + "1 - Listar\n"
                + "2 - Inserir\n"
                + "3 - Apagar\n"
                + "4 - Modificar\n"
                + "5 - Encerrar o programa\n"
                + "informe sua opção";
        while (true) {
            opcao = lerValor(menu);
            if (opcao > 0 && opcao < 6) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
        return opcao;
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AppAula15 obj = new AppAula15();
        int opcao = obj.montaMenu();
        while (opcao != 5) {
            switch (opcao) {
                case 1: // listar
                    obj.listaFrases();
                    break;
                case 2: // inserir
                    obj.insereFrases();
                    break;
                case 3: // Apagar
                    obj.apagaFrase();
                    break;
                case 4: // modificar
                    obj.alteraFrase();
                    break;
            }
            opcao = obj.montaMenu();
        }
    }
}
