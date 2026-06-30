package service;

import contratos.TarefaInterface;
import model.ListaTarefas;
import model.Tarefa;

import java.util.ArrayList;

public class TarefaService implements TarefaInterface{

    private ListaTarefas tarefas = new ListaTarefas();

    private int contadorId = 0;

    @Override
    public void adicionarTarefa(String nome, String descricao) {
        Tarefa novaTarefa = new Tarefa(nome, descricao);

        contadorId++;
        novaTarefa.setIdTarefa(contadorId);
        tarefas.getTarefas().add(novaTarefa);

        System.out.println("Tarefa cadastrada. ID: " + novaTarefa.getIdTarefa());
    }

    @Override
    public ArrayList<Tarefa> exibirTarefas() {
        return tarefas.getTarefas();
    }

    @Override
    public Tarefa buscarPorId(int id) {
        var lista = exibirTarefas();
        for(Tarefa t : lista){
            if(t.getIdTarefa() == id){
                return t;
            }
        }
        return null;
    }

    @Override
    public Tarefa atualizarTarefa(int id, String nome, String descricao, boolean status) {
        Tarefa tarefaASerAtualizada = buscarPorId(id);
        tarefaASerAtualizada.setNomeTarefa(nome);
        tarefaASerAtualizada.setDescricaoTarefa(descricao);
        tarefaASerAtualizada.setStatusTarefa(status);

        return tarefaASerAtualizada;
    }

    @Override
    public Tarefa removerTarefa(int id) {
        Tarefa tarefaASerRemovida = buscarPorId(id);
        if(tarefaASerRemovida != null){
            tarefas.getTarefas().remove( tarefaASerRemovida);
            return tarefaASerRemovida;
        }
        else{
            return null;
        }
    }
}
