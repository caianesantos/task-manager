package contratos;

import model.Tarefa;

import java.util.ArrayList;

public interface TarefaInterface {
    public void adicionarTarefa(String nome, String descricao);
    public ArrayList<Tarefa> exibirTarefas();
    public Tarefa buscarPorId(int id);
    public Tarefa atualizarTarefa(int id, String nome, String descricao, boolean status);
    public Tarefa removerTarefa(int id);

}
