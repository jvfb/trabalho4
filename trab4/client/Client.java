package trab4.client;

import trab4.User;
import trab4.Product;
import trab4.Market;

import java.io.*;
import java.net.*;
import java.util.*;



// Classe que possui o método main que executa a versão do cliente
public class Client {

     static int PORT = 1234;
     Socket socket;
     BufferedReader in;
     PrintWriter out;
     Scanner input = new Scanner(System.in);

     public Client(){
       try{
       socket = new Socket("localhost", PORT);
       in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       out = new PrintWriter(socket.getOutputStream(), true);
     } catch (Exception e){}

     }

    public void mainMenu(){
          try {
          menu: while(true) {
                System.out.println("LOJA VIRTUAL  \n" +
                "  1) Login \n" +
                "  2) Registrar \n" +
                "  3) Sair \n");
                int selection = Integer.parseInt(input.nextLine());
                switch (selection) {
                case 1:
                  Integer code;
                  String password;
                  String response;
                  System.out.println("Codigo: ");
                  code = Integer.parseInt(input.nextLine());
                  System.out.println("Senha: ");
                  password = input.nextLine();
                  out.println("1," + code + "," + password);
                  response = in.readLine();
                  if (response.equals("true")){
                      userMenu();
                      break;
                  }else {
                      System.out.println("Usuário inexistente");
                      break;
                  }
                case 2:
                  User user = new User();
                  System.out.println("Nome: ");
                  user.setName(input.nextLine());
                  System.out.println("Código: ");
                  user.setCode(Integer.parseInt(input.nextLine()));
                  System.out.println("Senha: ");
                  user.setPassword(input.nextLine());
                  System.out.println("Email: ");
                  user.setEmail(input.nextLine());
                  out.println("2," + user.toFile());
                  System.out.println("Registro feito com sucesso.");
                  break;
                case 3:
                  break menu;
                default:
                  System.out.println("Opção inválida.");
                  break;
                }
              }
          }
          catch(Exception e){ }
    }



      public void userMenu() {
               menu:while(true){
                  System.out.println("LOJA VIRTUAL  \n" +
                  "  1) Listar todos os produtos \n" +
                  "  2) Efetuar uma compra \n" +
                  "  3) Sair \n");
                  int selection = Integer.parseInt(input.nextLine());

                  switch(selection){
                            case 1:
                                  try {
                                      String response;
                                      out.println("3");
                                      while ((response = in.readLine()).equals("end") != true) {
                                              System.out.println(response);
                                      }
                                    }catch(Exception e){}
                                    break;
                            case 2:
                                    break;
                            case 3:
                                  System.exit(0);
                                  break;
                            default:
                              System.out.println("Opção inválida.");
                              break;
                  }
                }
      }

      public static void main(String[] args) {

          try {
              Client client = new Client();
              client.mainMenu();
          } catch (Exception e){}

      }


}
