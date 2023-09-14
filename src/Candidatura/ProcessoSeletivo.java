package Candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.*;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Felipe", "Marcela", "Paulo", "Julia", "Augusto"};
        for(String candidato: candidatos) {
            entrarContato(candidato);
        }
    }

    // Entrar em contato
    static void entrarContato(String candidato) {
            int tentativas = 1;
            boolean continuaTentar = true;
            boolean atendeu = false;
            do {
                atendeu = atender();
                continuaTentar = !atendeu;

                if(continuaTentar)
                    tentativas++;
                else
                    out.println("Contato realizado com sucesso");

            } while (continuaTentar && tentativas < 3);

            if(atendeu) {
                String msgAtendeu = String.format("Conseguimos entrar em contato com %s na " + tentativas + " tentativa", candidato);
                out.println(msgAtendeu);
            }
            else
                out.println("Não conseguimos contato com " + candidato + ", numero maximo de tentativas " + tentativas + " realizada");
    }

    // Metodo auziliar
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    // Imprime os candidatos selecionados
    static void imprimirSelecionados() {
        String [] candidatos = {"Felipe", "Marcela", "Paulo", "Julia", "Augusto"};
        out.println("Imprimindo a lista de candidatos informando o indice de elemonto");

        for(int indice = 0; indice < candidatos.length; indice++) {
            out.println("O candidato numero " + (indice+1) + " é o " + candidatos[indice]);
        }
    }

    // Area de selecao dos candidatos
    static void selecaoCandidatos() {
        String [] candidatos = {"Felipe", "Marcela", "Paulo", "Julia", "Augusto",
                                "Monica", "Fabricio", "Marcia", "Mirelia", "Henrique" };

    // Selecao por salario dos candidatos
        int CandidatosSelecionados = 0;
        int CandidatosAtuais = 0;
        double salarioBase = 2000.0;
        while (CandidatosSelecionados < 5) {
            String candidato = candidatos[CandidatosAtuais];
            double SalarioPretendido = valorPretendido();

            String mensagem = String.format("O candidato %s solicitou este valor de salário: %s", candidato, SalarioPretendido);
            out.println(mensagem);

            if(salarioBase >= SalarioPretendido) {
                String mensagem2 = String.format("O candidato %s foi selecionado para a vaga", candidato);
                out.println(mensagem2);
                CandidatosSelecionados++;
            }
            CandidatosAtuais++;
        }
    }

    // Valor pretendido do salario
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            out.println("Ligar para o candidato");

        } else if(salarioBase == salarioPretendido) {
            out.println("Ligar para o candidato com contra proposta");
        } else {
            out.println("Aguardando o resultado demais candidatos");
        }
    }
}
