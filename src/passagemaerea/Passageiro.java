package passagemaerea;

public class Passageiro {
     private String nome, cpfCliente, telefone, tipodaPassagem, idPassagem, cpfPassageiro;

    
     private int idade, numeroDaPoltrona;
     private float preco;
   

    public Passageiro(String nome, String cpfCliente, String cpfPassageiro, String telefone, String tipodaPassagem, String idPassagem, int idade, int numeroDaPoltrona, float preco) {
        this.nome = nome;
        this.cpfCliente = cpfCliente;
        this.telefone = telefone;
        this.tipodaPassagem = tipodaPassagem;
        this.idPassagem = idPassagem;
        this.idade = idade;
        this.numeroDaPoltrona = numeroDaPoltrona;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpfCliente;
    }

    public void setCpf(String cpf) {
        this.cpfCliente = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipodaPassagem() {
        return tipodaPassagem;
    }

    public void setTipodaPassagem(String tipodaPassagem) {
        this.tipodaPassagem = tipodaPassagem;
    }

    public String getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(String idPassagem) {
        this.idPassagem = idPassagem;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getNumeroDaPoltrona() {
        return numeroDaPoltrona;
    }

    public void setNumeroDaPoltrona(int numeroDaPoltrona) {
        this.numeroDaPoltrona = numeroDaPoltrona;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
     public String getCpfPassageiro() {
        return cpfPassageiro;
    }

    public void setCpfPassageiro(String cpfPassageiro) {
        this.cpfPassageiro = cpfPassageiro;
    }
}
