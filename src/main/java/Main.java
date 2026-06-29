import contratos.TarefaInterface;
import model.Tarefa;
import service.TarefaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TarefaInterface tarefa = new TarefaService();

        int opcao = 0;
        int idTarefa;

        do{
            System.out.println("-------- MENU --------" +
                    "\n 1- Cadastrar tarefa;" +
                    "\n 2- Exibir tarefas;" +
                    "\n 3- Buscar por id;" +
                    "\n 4- Atualizar tarefa;" +
                    "\n 0- Sair;" +
                    "\n Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if(opcao == 1){
                System.out.println("--- CADASTRAR TAREFA ---");
                System.out.println("Digite um nome para a tarefa: ");
                String nomeTarefa = sc.nextLine();
                System.out.println("Digite uma descrição para a tarefa: ");
                String descricao = sc.nextLine();
                tarefa.adicionarTarefa(nomeTarefa, descricao);
            }
            else if(opcao == 2){
                System.out.println("--- SUAS TAREFAS ---");
                var lista = tarefa.exibirTarefas();
                if(lista.isEmpty()){
                    System.out.println("Nenhuma tarefa cadastrada.");
                }else{
                    for(Tarefa tarefas : lista){
                        System.out.println(tarefas);
                    }
                }
            }
            else if(opcao == 3){
                System.out.println("--- TAREFA POR ID ---");
                System.out.println("Digite o id da tarefa que deseja encontrar: ");
                idTarefa = sc.nextInt();
                sc.nextLine();
                if(tarefa.buscarPorId(idTarefa) != null){
                    System.out.println("Tarefa encontrada: ");
                    System.out.println(tarefa.buscarPorId(idTarefa));
                }else{
                    System.out.println("Nenhuma tarefa encontrada");
                }
            }

            else if(opcao == 4){
                System.out.println("--- ATUALIZAR TAREFA ---");

                System.out.println("Digite o id da tarefa que deseja atualizar: ");
                idTarefa = sc.nextInt();
                sc.nextLine();

                System.out.println("Digite o novo nome da tarefa: ");
                String nomeTarefa = sc.nextLine();

                System.out.println("Digite a nova descrição da tarefa: ");
                String descricao = sc.nextLine();

                System.out.println("Conclua a tarefa atualizando para true: ");
                boolean conclusao = sc.nextBoolean();

                tarefa.atualizarTarefa(idTarefa, nomeTarefa, descricao, conclusao);
            }

        }while(opcao != 0);
        sc.close();
    }
}
