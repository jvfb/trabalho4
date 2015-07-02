package trab4;

import java.io.*;
import java.util.*;
import java.text.*;


//Classe que possui os menus do servidor e os métodos de leitura e escrita dos arquivos csv

public class Market {

  public List<Product> products;
  public List<User> users;

  Scanner input = new Scanner(System.in);


  public Market(){

  }


  public void productCsvReader(String arquivo) {
		this.products = new ArrayList<Product>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(arquivo));
			String csv;
			while((csv = in.readLine()) != null) {
				products.add(new Product(csv));
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Arquivo " + arquivo + " não foi encontrado");
		}
		catch(IOException e) {
			System.out.println("Erro ao ler o arquivo de produtos.");
		}
	}

  public void productCsvWriter(String arquivo){


    FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(arquivo);

            //Write a new student object list to the CSV file
            for (Product product : products) {
                fileWriter.append(product.getName());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(product.getCode()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(product.getPrice()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(product.getQuantity()));
                fileWriter.append("\n");
            }
            System.out.println("products.csv escrito com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro de escrita em products.csv.");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar products.csv.");
                e.printStackTrace();
            }

        }

  }


  public void userCsvReader(String arquivo) {
    this.users = new ArrayList<User>();
    try {
      BufferedReader in = new BufferedReader(new FileReader(arquivo));
      String csv;
      while((csv = in.readLine()) != null) {
        users.add(new User(csv));
      }
    }
    catch(FileNotFoundException e) {
      System.out.println("Arquivo " + arquivo + " não foi encontrado");
    }
    catch(IOException e) {
      System.out.println("Erro ao ler o arquivo de usuarios.");
    }
  }

  public void userCsvWriter(String arquivo){


    FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(arquivo);

            //Write a new student object list to the CSV file
            for (User user : users) {
                fileWriter.append(user.getName());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(user.getCode()));
                fileWriter.append(",");
                fileWriter.append(user.getPassword());
                fileWriter.append(",");
                fileWriter.append(user.getEmail());
                fileWriter.append("\n");
            }
            System.out.println("users.csv escrito com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro de escrita em users.csv.");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar users.csv.");
                e.printStackTrace();
            }

        }

  }



  public void mainMenu(){
    menu:while(true) {
       System.out.println("LOJA VIRTUAL: \n" +
       "  1) Cadastrar produto\n" +
       "  2) Listar produtos\n" +
       "  3) Atualizar produto\n"+
       "  4) Sair\n");

       int selection = input.nextInt();
       input.nextLine();

        switch (selection) {
          case 1:
            this.cadastrarMenu();
            break;
          case 2:
            this.listarMenu();
            break;
         case 3:
           this.atualizarMenu();
           break;
         case 4:
           System.out.println("Encerrando servidor...");
           break menu;
         default:
           System.out.println("Opção inválida.");
           break;
         }

   }

  }



  public void cadastrarMenu(){
        menu: while(true) {
              System.out.println("CADASTRAR: \n" +
              "  1) Novo produto\n" +
              "  2) Voltar\n");

            int selection = input.nextInt();
            input.nextLine();

             switch (selection) {
               case 1:
                 Product product = new Product();
                 System.out.println("Digite o nome do produto:");
                 product.setName(input.nextLine());
                 System.out.println("Codigo:");
                 product.setCode(input.nextInt());
                 input.nextLine();
                 System.out.println("Preço:");
                 product.setPrice(input.nextDouble());
                 input.nextLine();
                 System.out.println("Quantidade:");
                 product.setQuantity(input.nextInt());
                 input.nextLine();
                 System.out.println("Produto cadastrado.");
                 products.add(product);
                 break;
               case 2:
                break menu;
              default:
                System.out.println("Opção inválida.");
                break;
              }

        }
  }


  public void listarMenu(){
    menu:while(true) {
       System.out.println("LISTAR PRODUTOS: \n" +
       "  1) Em estoque\n" +
       "  2) Esgotados\n" +
       "  3) Sair\n");

       int selection = input.nextInt();
       input.nextLine();

        switch (selection) {
          case 1:
          System.out.println("EM ESTOQUE:");
            products.stream()
            .filter(a -> (a.getQuantity() > 0))
            .forEach(a -> {System.out.println(a);});
            break;
          case 2:
          System.out.println("ESGOTADOS:");
            products.stream()
            .filter(a -> (a.getQuantity() == 0))
            .forEach(a -> {System.out.println(a);});

            break;
         case 3:
           break menu;
         default:
           System.out.println("Opção inválida.");
           break;
         }

   }

  }

  public void atualizarMenu(){
    Integer code;
    Integer quantity;

    menu: while(true) {
          System.out.println("ATUALIZAR QUANTIDADE: \n" +
          "  1) Atualizar\n" +
          "  2) Voltar\n");

        int selection = input.nextInt();
        input.nextLine();

         switch (selection) {
           case 1:
             System.out.println("Digite o codigo do produto): ");
             code = input.nextInt();
             input.nextLine();
             System.out.println("Digite a nova quantidade:");
             quantity =  input.nextInt();
             input.nextLine();
             for(int i=0; i < products.size(); i++){
               if (products.get(i).getCode().equals(code)){
                 products.get(i).setQuantity(quantity);
                 System.out.println("Produto atualizado.");
                 break;
               } else{

                 System.out.println("Não foi possível encontrar o produto");
               }
             }
          case 2:
            break menu;
          default:
            System.out.println("Opção inválida.");
            break;
          }

    }



  }

}
