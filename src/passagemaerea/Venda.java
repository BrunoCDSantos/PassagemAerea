package passagemaerea;

public class Venda {
      String nome;
      String telefone;
   int idadePassageiro = 0;
    public String Nome() {
        String nome1;
        do {
            nome1 = Util.pedeString("Digite o nome do passageiro diferente de nada");
        } while (nome1.equals(""));
        return nome1;
    }

    public void cadastroDePassageiro() {
         nome = Nome();
         telefone = Telefone();
         Idade();
    }

    public String Telefone() {
        
        String telefone1;
        String maskTelefone = "\\([0-9]{2}?\\)[0-9]{4}?\\-[0-9]{4}";
        do {
            telefone1 = Util.pedeString("Informe o telefone do Passageiro(formato (xx)xxxx-xxxx não \n"
                    + "podendo conter letras):");
        } while (!telefone1.matches(maskTelefone));
    return telefone1 ;
    }

    public int Idade() {
       
        do {
              idadePassageiro = Util.pedeInteiro("Informe a idade do passageiro(entre 5 à 100):");
        } while (idadePassageiro < 5 || idadePassageiro > 99);
     
        return idadePassageiro;
    }
}
