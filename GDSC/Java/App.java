import java.util.Scanner;
import java.util.Arrays;

public class App {

         static int menuEntrada() {
              Scanner scan = new Scanner(System.in);
             System.out.print("1.Signin\n2.Login\n3.Multiplayer\n4.Ajuda\n0.Sair\n::: ");
             int opc = scan.nextInt();
             
             return opc;
         }
         
         
         static int menuPrincipal() {
             Scanner scan = new Scanner(System.in);
             System.out.print("1.Testar o TypeSpeed\n2.Ver Historico\n3.Ver Ranking\n0.Sair\n:::");
             int opc = scan.nextInt();
             
             return opc;
         }
         
         
         static int menuMultiplayer() {
             Scanner scan = new Scanner(System.in);
             System.out.print("1.Testar o TypeSpeed\n2.Ver Ranking\n0.Sair\n:::");
             int opc = scan.nextInt();
             
             return opc;
         }
  
         
         
         public static void main(String [] args) {
          
                 User[] usuarios = new User[3];
                 int usersTotal = 0;
                 int posHistorico = 0;
                 int opc;
                 int opc1;
                
                  do {  
                     opc = menuEntrada();
                     switch(opc) {
                         case 1:
                             usuarios[usersTotal] = new User();
                             usuarios[usersTotal].signin(usersTotal);
                             usersTotal++;
                             break; 
                             
                         case 2:
                                 int userId = User.login(usuarios, usersTotal);
                                 if (userId != 0) {
                                        do {
                                             opc1 = menuPrincipal();
                                             switch(opc1) {
                                                  case 1:
                                                            usuarios[userId] = new User();
                                                            float velocidade = usuarios[userId].testTypeSpeed(posHistorico);
                                                            posHistorico++;
                                                            System.out.println("Numero de palavras por segundo: "+ velocidade+"wps");
                                                       break;
                                                       
                                                  case 2:
                                                            usuarios[userId] = new User();
                                                            usuarios[userId].verHistorico(posHistorico);
                                                       break;
                                                       
                                                  case 3: 
                                                            User.showRanking(usuarios, usersTotal);
                                                       break;
                                                       
                                                  default:
                                                             if (opc1 != 0) {
                                                                 System.out.println("Opcao invalida!");
                                                            }
                                                       break;
                                             }
                                        } while (opc1 != 0);  
                              }
                            
                             break;
                             
                         case 3:
                             if (usersTotal >= 2) {
                                   String[] ids = User.login2Users(usuarios, usersTotal).split("-");
                                   int[] values = new int[2];
                                   values = Arrays.stream(ids).mapToInt(Integer::parseInt).toArray();
                                   
                                   if (values[0] != values[1]) {
                                        do {
                                             opc1 = menuMultiplayer();
                                             switch(opc1) {
                                                  case 1:
                                                            User.testMultiplayerTypeSpeed(usuarios, values);
                                                        break;
                                                        
                                                  case 2:
                                                            User.showRankingMultiplayer(usuarios, usersTotal);
                                                       break;
                                                       
                                                  default:
                                                            if (opc1 != 0) {
                                                                 System.out.println("Opcao invalida!");
                                                            }
                                                       break;
                                        
                                             }
                                        } while(opc1 != 0);
                                          
                                  }  
                              } else if(usersTotal == 1) {
                                   System.out.println("Impossivel efectuar operacao!E necessario cadastrar pelo menos 2 usuarios.");
                             } else {
                                   System.out.println("Sem usuarios cadatrados! Tente cadastrar.");
                             }  
                             break;
                             
                        case 4:
                                   User.ajuda();
                              break;
                              
                         default:
                                  if (opc != 0) {
                                        System.out.println("Opcao invalida!");
                                   }
                             break;
                     }
                     
                  }while(opc!=0);       
         }
}