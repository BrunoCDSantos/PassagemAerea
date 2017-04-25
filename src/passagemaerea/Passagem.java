package passagemaerea;



public class Passagem {
    String Ids = IDsPassagem();
   public String IDsPassagem(){
       int idPassagem = 0;
       String PassagemIDs;
         idPassagem = idPassagem + 1;
         PassagemIDs = Integer.toString(idPassagem);

       return PassagemIDs;
   }
}
 