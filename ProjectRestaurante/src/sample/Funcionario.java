package sample;

public class Funcionario extends Pessoa{

    private Prato prato;
    public Funcionario(String nome, Integer idade, String contato) {
        super(nome, idade, contato);
    }


    @Override
    public String toString(){

        return this.getNome().toString();
    }
}
