package candidatura;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        selecaoDeCandidatos();
        System.out.println("Processo Seletivo 2024");
        System.out.println("------------------------");
    }

    static void selecaoDeCandidatos() {
        // Array de Lista de Candidatos
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        // Lista para armazenar os candidatos selecionados
        ArrayList<String> candidatosAprovados = new ArrayList<>();

        // Loop para seleção de candidatos
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];            
            double salarioPretendido = valorPretendido();
            
            System.out.println("O Candidato: " + candidato + " solicitou este valor de salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
                candidatosAprovados.add(candidato);  // Adiciona o candidato à lista de aprovados
            } else {
                System.out.println("O Candidato " + candidato + " não foi selecionado para a vaga.");
            }
            
            // Avança para o próximo candidato
            candidatoAtual++;
        }
        
        // Exibe a lista de candidatos selecionados
        System.out.println("\nCandidatos selecionados:");
        for (int i = 0; i < candidatosAprovados.size(); i++) {
            System.out.println("Candidato de nº " + (i + 1) + ": " + candidatosAprovados.get(i));
        }


        // Faz a ligação para os candidatos selecionados
        System.out.println("\nIniciando ligação para candidatos selecionados:");
        for (String aprovado : candidatosAprovados) {
            ligarParaCandidato(aprovado, 3); // Até 3 tentativas de ligação
        }
    }
    
    static double valorPretendido() {
        // Gera um valor aleatório entre 1800 e 2200
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // Simula a ligação para o candidato com até 3 tentativas
    static void ligarParaCandidato(String candidato, int tentativasMaximas) {
        int tentativas = 0;
        boolean contatoRealizado = false;
        
        while (tentativas < tentativasMaximas && !contatoRealizado) {
            System.out.println("Ligando para " + candidato + "... Tentativa " + (tentativas + 1));
            
            // Simula a tentativa de contato (50% de sucesso)
            contatoRealizado = ThreadLocalRandom.current().nextBoolean();
            
            if (contatoRealizado) {
                System.out.println("Contato realizado com " + candidato + " com sucesso!\n");
            } else {
                System.out.println("Tentativa de contato com " + candidato + " falhou.");
                tentativas++;
                
                if (tentativas == tentativasMaximas) {
                    System.out.println("Falha ao contatar " + candidato + " após " + tentativasMaximas + " tentativas.\n");
                } else {
                    System.out.println("Tentando novamente...\n");
                }

                // Simula um pequeno atraso entre tentativas
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    static void analisaCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
