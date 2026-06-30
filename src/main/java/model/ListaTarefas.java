package model;


import java.util.ArrayList;

public class ListaTarefas {
    private ArrayList<Tarefa> tarefas;

    public ListaTarefas(){
        this.tarefas = new ArrayList<Tarefa>();
    }

    //GET E SET
    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

}
