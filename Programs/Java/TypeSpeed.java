import java.util.Scanner;
import java.util.Random;
import java.util.StringTokenizer;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
//import static java.time.Temporal;


public class TypeSpeed {

         public String [] textos = new String [3];
         private float time;
         private float speed;
         private float historico[] = new float[10];
         private float nrPalavras;
         private static int pos;
         Scanner entrada = new Scanner(System.in);
         Random gerador = new Random();
         
         public TypeSpeed() {
             pos = 0;
             time = 0;
             speed = 0;
             nrPalavras = 0;
              textos[0] = "Este e o primeiro texto";
              textos[1] = "Este e o segundo texto";
              textos[2] = "Este e o terceiro texto";
         }
         
         public void setTime(float time) {
               this.time = time;
         }
         public float getTime() {
             return time;
         }
         
         
         public void setSpeed(float speed) {
               this.speed = speed;
         }
         public float getSpeed() {
             return speed;
         }
         
         public void setNrPalavras(float nrPalavras) {
               this.nrPalavras = nrPalavras;
         }
         public float getNrPalavras() {
             return nrPalavras;
         } 
         
         
         public float testTypeSpeed (int posHistorico) {
         
             int posTexto = gerador.nextInt(3);
             StringTokenizer contarPalavras = new StringTokenizer(textos[posTexto]);
             setNrPalavras(contarPalavras.countTokens());               
             System.out.println("Digite a seguinte frase usando underscore(_) no lugar de espacos: \n"+textos[posTexto]);
             Instant start = Instant.now();
             String text = entrada.next();                    
             Instant end = Instant.now();
             Duration intervalo = Duration.between(start, end);
             setTime(intervalo.getSeconds());
             setSpeed((time)/(nrPalavras));
             if(!(text.equals(textos[posTexto]))){
                      System.out.println("Voce cabulou !!!");
             }
         else{
                  System.out.println("Voce precisou de "+ getTime()+ "segundos para igitar o texto.");
         }
             historico[posHistorico] = getSpeed();
             
             return speed;     
         }
         
         
         public final float testTypeSpeed1vs1 () {
         
              int posTexto = gerador.nextInt(3);
             StringTokenizer contarPalavras = new StringTokenizer(textos[posTexto]);
             nrPalavras = contarPalavras.countTokens();               
             System.out.println("Digite a seguinte frase usando underscore(_) no lugar de espacos: \n"+textos[posTexto]);
             Instant start = Instant.now();
             String text = entrada.nextLine();                    
             Instant end = Instant.now();
             Duration intervalo = Duration.between(start, end);
             setTime(intervalo.getSeconds());
             setSpeed((time)/(nrPalavras));
             System.out.println("Voce precisou de "+ getTime()+ "segundos para igitar o texto."); 
             
             return speed;
         }
         
         
         public final static void testMultiplayerTypeSpeed(User[] usuarios, int [] values) {
             
             System.out.println("=======Jogador 1=========");
             float velocidade1 = usuarios[values[0]].testTypeSpeed1vs1();
             System.out.println("=======Jogador 2=========");
             float velocidade2 = usuarios[values[1]].testTypeSpeed1vs1();
             if (velocidade1 < velocidade2) {
                 System.out.println("O ususario "+usuarios[values[0]].getName()+" venceu com"+ velocidade1+ "wps.");
                 usuarios[values[0]].setPointsMult(3);
                 usuarios[values[0]].setVitorias();
                 usuarios[values[1]].setDerrotas();
            } else if (velocidade1 > velocidade2) {
                 System.out.println("O ususario "+usuarios[values[1]].getName()+" venceu com"+ velocidade2+ "wps.");
                 usuarios[values[1]].setPointsMult(3);
                 usuarios[values[1]].setVitorias();
                 usuarios[values[0]].setDerrotas();
             } else {
                 System.out.println("Empate! Foram os dois muito rapidos, com"+ velocidade1+ "wps.");
                 usuarios[values[0]].setPointsMult(1);
                 usuarios[values[1]].setPointsMult(1);
                 usuarios[values[0]].setEmpates();
                 usuarios[values[1]].setEmpates();

             }
         }
         
         
      public final void verHistorico(int posHistorico) {
             if(posHistorico == 0) {
                 System.out.println("Historico vazio! Teste o seu typespeed antes.");
             } else {
                 System.out.println(" \t velocidade\tUnidade");
                 for(int i=0; i<posHistorico; i++) {
                     System.out.println(i+"\t."+ historico[i]+ "\twps");
                 }
             }
         
         }
         
         
         public final static void showRanking(User[] usuarios, int usersTotal) {
             User aux;
             for(int k=0; k<usersTotal; k++) {
                 for(int n=1; n<usersTotal; n++) {
                      if(usuarios[k].getPoints() < usuarios[n].getPoints()) {
                         aux = usuarios[k];
                         usuarios[k] = usuarios[n];
                         usuarios[n] = aux;
                      }
                 }
             }
             
             System.out.println("Posicao\t Nome\t Pontos");
             for(int m=1; m<usersTotal; m++) {
                 System.out.println(m +"\t" + usuarios[m-1].getName() + "\t" + usuarios[m-1].getPoints());
             } 
         }
         
         
         
         public final static void showRankingMultiplayer(User[] usuarios, int usersTotal) {
             User aux;
             for(int k=0; k<usersTotal; k++) {
                 for(int n=1; n<usersTotal; n++) {
                      if(usuarios[k].getPointsMult() < usuarios[n].getPointsMult()) {
                         aux = usuarios[k];
                         usuarios[k] = usuarios[n];
                         usuarios[n] = aux;
                      }
                 }
             }
             
             System.out.println("Posicao\t Nome\t Vitorias\t Derrotas\t Empates\t Pontos");
             for(int m=1; m<(usersTotal+1); m++) {
                 System.out.println(m +"\t" + usuarios[m-1].getName() + "\t"+ usuarios[m-1].getVitorias() + "\t" + usuarios[m-1].getDerrotas()+"\t" +usuarios[m-1].getEmpates()+"\t" + usuarios[m-1].getPointsMult());
             } 
         }
         
         
         
         public final static void ajuda() {
               System.out.println("===ABOUT SIGNUP===");
               System.out.println("Para fazer o signup no nosso sistema,voce precisa apenas de um email e a password. Basicamente voce informar um username que voce gostaria que os outros usuarios vissem como seu identificador, informar o email e a password. Depois de dar todas as informacoes, o cadastro e feito.\n");
               
               System.out.println("===ABOUT LOGIN's===");
               System.out.println("Temos basicamente duas abas de login. Uma e para um unico usuario, onde ele podera fazer o teste de type speed(velocidade de digitacao), ver o seu historico de testes e o ranking com informacoes de todos os usuarios cadastrados. A outra aba e para dois usuarios(multiplayer) onde dois usuarios cadastradosvao competir entre eles quem leva menos tempo para digitar um mesmo texto e quem ganha tem pontos, e tambem e possivel ver o ranking dos usuarios que ja fizaram o multiplayer.");
               
               System.out.println("===OBS===");
               System.out.println("- Nao e possivel fazer o login se nao tiver nenhum usuario cadastrado no sistema.");
               System.out.println("- Nao e possivel fazer o login no multiplayer se nao tiver pelo menos dois usuarios cadastrados no sistema.");
               System.out.println("");
         }
         
}
