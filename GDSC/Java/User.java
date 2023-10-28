import java.util.Scanner;


public final class User extends TypeSpeed {
         private int id;
         private String name;
         private String email;
         private String password;
         private int points;
         private int pointsMult;
         private int vitorias;
         private int derrotas;
         private int empates;
         public static int quantUsers;
          Scanner entrada = new Scanner(System.in);
          
          public User() {
             points = 0;
             id = 0; 
             quantUsers = 0;
             vitorias = 0;
             derrotas = 0;
             empates =0;
          }
         
         public void setName() { this.name = entrada.next(); }
         public String getName() { return name; }
         
         public void setEmail() { this.email = entrada.next(); }
         public String getEmail() { return email; }
         
         public void setPassword() { this.password = entrada.next(); }
         public String getPassword() { return password; }
         
         public void setId(int id) { this.id = id; }
         public int getId() { return id; }
         
         void setPoints() { points++; }
         public int getPoints() { return points; }
         
         public void setPointsMult(int points) { pointsMult = points; }
         
         public int getPointsMult() { return pointsMult; }
         
         public void setVitorias() { this.vitorias ++; }
         public int getVitorias() { return vitorias; }
         
         public void setDerrotas() { this.derrotas ++; }
         public int getDerrotas() { return derrotas; }
         
         public void setEmpates() { this.empates ++; }
         public int getEmpates() { return empates; }
         
         
         public final void signin(int id) {
             System.out.print("Insira o username: ");
             setName();
             System.out.print("Insira o email: ");
             setEmail();
             System.out.print("Insira o password: ");
             setPassword();
             setId(id+1);
         }
         
         
         
         public final static int login(User usuarios[], int usuariosTotal) {
             Scanner scan = new Scanner(System.in);
             
              if (usuariosTotal != 0) {
                 System.out.print("Insira o email ou o username: ");
                 String emailLogin = scan.next();
                 System.out.print("Insira a password: ");
                 String passLogin = scan.next();
             
                 for(int i=0; i<usuariosTotal; i++) {
                     if ((emailLogin.equals(usuarios[i].getEmail())|| emailLogin.equals(usuarios[i].getName())) && passLogin.equals(usuarios[i].getPassword())) {
                         return i+1;
                     } 
                 }
             } else {
                 System.out.println("Nenhum usuario cadastrado, cadastre-se primeiro!");
             }
             
             return 0;
         }
         
         
         
        public final static String login2Users(User usuarios[], int usuariosTotal) {
                 Scanner scan = new Scanner(System.in);
                 
                 if (usuariosTotal == 0) {
                     System.out.println("Nenhum usuario cadastrado, cadastre-se primeiro!");
                     
                 } else {
                     int existente = 0;
                     System.out.println("=======JOGADOR 1===========");
                     System.out.print("Insira o email ou o username: ");
                     String emailLogin = scan.next();
                     System.out.print("Insira a password: ");
                     String passLogin = scan.next();
                     
                     for(int i=0; i<usuariosTotal; i++) {
                          if ((emailLogin.equals(usuarios[i].getEmail())|| emailLogin.equals(usuarios[i].getName())) && passLogin.equals(usuarios[i].getPassword())) {
                             existente = i;
                            
                         } 
                     }
                     
                     System.out.println("=======JOGADOR 2===========");
                     System.out.print("Insira o email ou o username: ");
                     emailLogin = scan.next();
                     System.out.print("Insira a password: ");
                     passLogin = scan.next();
                     
                     for(int j=0; j<usuariosTotal; j++) {
                         if ((emailLogin.equals(usuarios[j].getEmail())|| emailLogin.equals(usuarios[j].getName())) && passLogin.equals(usuarios[j].getPassword())) {
                             if(j != existente) {
                                 return existente + "-" + j;
                             } else {
                                 System.out.println("Nao pode informar os dados do mesmo jogador!");
                             }
                         } 
                     }
                 }
                 
                 return "0-0";
         }
    
}