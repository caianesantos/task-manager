import contratos.TarefaInterface;
import model.Tarefa;
import service.TarefaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TarefaInterface tarefa = new TarefaService();

        int opcao = 0;
        int idTarefa;

        do {
            System.out.println("-------- MENU --------" +
                    "\n 1- Cadastrar tarefa;" +
                    "\n 2- Exibir tarefas;" +
                    "\n 3- Buscar por id;" +
                    "\n 4- Atualizar tarefa;" +
                    "\n 5- Remover tarefa;" +
                    "\n 0- Sair;" +
                    "\n Digite a opção desejada: ");
            try {
                opcao = sc.nextInt();
                sc.nextLine();



                switch (opcao) {
                    case 1 -> {
                        log.info("O usuário solicitou a criação de uma nova tarefa.");
                        System.out.println("--- CADASTRAR TAREFA ---");
                        System.out.println("Digite um nome para a tarefa: ");
                        String nomeTarefa = sc.nextLine();
                        log.info("O usuário informou um nome para a tarefa: {}", nomeTarefa);

                        System.out.println("Digite uma descrição para a tarefa: ");
                        String descricao = sc.nextLine();
                        log.info("O usuário informou uma descrição para a tarefa: {}", descricao);

                        log.info("Tarefa cadastrada com sucesso!  Nome: {}", nomeTarefa);
                        tarefa.adicionarTarefa(nomeTarefa, descricao);
                    }
                    case 2 -> {
                        log.info("O usuário solicitou a lista de tarefas");
                        System.out.println("--- SUAS TAREFAS ---");
                        var lista = tarefa.exibirTarefas();
                        if (lista.isEmpty()) {
                            log.warn("Nenhuma tarefa encontrada.");
                            System.out.println("Nenhuma tarefa cadastrada.");
                        } else {
                            log.info("As tarefas foram listadas com sucesso!");
                            lista.forEach(System.out::println);
                        }
                    }
                    case 3 -> {
                        log.info("O usuário solicitou a busca da tarefa.");
                        System.out.println("--- TAREFA POR ID ---");
                        System.out.println("Digite o id da tarefa que deseja encontrar: ");
                        idTarefa = sc.nextInt();
                        sc.nextLine();
                        log.info("O usuário solicitou a busca da tarefa com id: {}", idTarefa);

                        if (tarefa.buscarPorId(idTarefa) != null) {
                            System.out.println("Tarefa encontrada: ");
                            System.out.println(tarefa.buscarPorId(idTarefa));
                            log.info("Tarefa encontrada com sucesso! Id n°: {}", idTarefa );
                        } else {
                            System.out.println("Nenhuma tarefa encontrada");
                            log.warn("Nenhuma tarefa encontrada com o id: {}", idTarefa);
                        }
                    }

                    case 4 -> {
                        log.info("O usuário solicitou a atualização da tarefa.");
                        System.out.println("--- ATUALIZAR TAREFA ---");

                        System.out.println("Digite o id da tarefa que deseja atualizar: ");
                        idTarefa = sc.nextInt();
                        sc.nextLine();
                        log.info("O usuário deseja atualizar a tarefa: {}", idTarefa);

                        System.out.println("Digite o novo nome da tarefa: ");
                        String nomeTarefa = sc.nextLine();
                        log.info("O usuário informou o nome da tarefa: {}", nomeTarefa);

                        System.out.println("Digite a nova descrição da tarefa: ");
                        String descricao = sc.nextLine();
                        log.info("O usuário informou uma nova descrição para a tarefa: {}", descricao);

                        System.out.println("Conclua a tarefa atualizando para true: ");
                        boolean conclusao = sc.nextBoolean();
                        if (conclusao) {
                            log.info("O usuário concluiu a tarefa com sucesso.");
                        }

                        tarefa.atualizarTarefa(idTarefa, nomeTarefa, descricao, conclusao);
                        log.info("Tarefa atualizada com sucesso!");
                    }
                    case 5 -> {
                        log.info("O usuário  solicitou a remoção da tarefa.");
                        System.out.println("--- REMOVER TAREFA ---");

                        System.out.println("Digite o id da tarefa que deseja remover: ");
                        idTarefa = sc.nextInt();
                        sc.nextLine();
                        log.info("O usuário deseja remover a tarefa: {}", idTarefa);

                        if (tarefa.removerTarefa(idTarefa) != null) {
                            System.out.println("Tarefa removida com sucesso.");
                            log.info("Tarefa removida com sucesso!");
                        } else {
                            System.out.println("Nenhuma tarefa removida");
                            log.warn("Não foi encontrada tarefa para remover.");
                        }
                    }
                    case 0 -> {
                        log.info("O usuário solicitou o encerramento do programa");
                        System.out.println("--- ENCERRANDO PROGRAMA ---");
                        log.info("O programa foi encerrado.");
                    }

                    default -> {
                        log.warn("O usuário selecionou uma opção inexistente no menu: {}", opcao);
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                }

            }catch (InputMismatchException e) {
                log.error("Erro interno no processamento do menu principal.", e);
                log.info("Foi atribuído o valor '-1' a variável opcao");
                System.out.println("Entrada inválida! Por favor, digite apenas números.");
                sc.nextLine();
                opcao = -1;
            }

        }while(opcao != 0);
        sc.close();
    }
}
