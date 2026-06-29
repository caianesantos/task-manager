package model;

public class Tarefa {
    private int idTarefa;
    private String nomeTarefa;
    private String descricaoTarefa;
    private boolean concluida;

    public Tarefa(String nome, String descricao) {
        this.nomeTarefa = nome;
        this.descricaoTarefa = descricao;
        this.concluida = false;
    }



    //GET E SET

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public boolean isStatusTarefa() {
        return concluida;
    }

    public void setStatusTarefa(boolean statusTarefa) {
        this.concluida = statusTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    @Override
    public String toString() {
        return "Tarefa" +
                "\n Id da tarefa = " + (idTarefa )  +
                "\n Nome da tarefa = " + nomeTarefa +
                "\n Descrição da tarefa = " + descricaoTarefa +
                "\n Status da tarefa = " + concluida +
                "\n";
    }

}
