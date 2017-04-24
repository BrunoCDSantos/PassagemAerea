package passagemaerea;

public class Venda {
 
    public String Nome() {
        String nome;
        do {
            nome = Util.pedeString("Digite o nome do passageiro diferente de nada");
        } while (nome.equals(""));
        return nome;
    }

    public void cadastroDePassageiro() {
        String nome = Nome();
        String telefone = Telefone();
        int idade = Idade();
    }

    private String Telefone() {
        String telefone;
        String maskTelefone = "\\([0-9]{2}?\\)[0-9]{4}?\\-[0-9]{4}";
        do {
            telefone = Util.pedeString("Informe o telefone do Passageiro(formato (xx)xxxx-xxxx não podendo conter letras):");
        } while (!telefone.matches(maskTelefone));
    return telefone ;
    }

    private int Idade() {
        int idadePassageiro = 0;
        do {
              idadePassageiro = Util.pedeInteiro("Informe a idade do passageiro(entre 5 à 100):");
        } while (idadePassageiro < 5 || idadePassageiro > 99);
     
        return idadePassageiro;
    }
}
