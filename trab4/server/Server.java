package trab4.server;

import trab4.User;
import trab4.Product;
import trab4.Market;
import java.util.*;
import java.net.*;
import java.io.*;

// Classe que possui o método main para executar o servidor
public class Server{


    public static void main(String args[]) throws Exception{

      Scanner in = new Scanner(System.in);
      Market market = new Market();
      market.productCsvReader("products.csv");
      market.userCsvReader("users.csv");
      Thread lt = new Thread(new ListenerThread(1234, market.products, market.users));
      lt.start();
      System.out.println("Server's up");
      market.mainMenu();
      market.productCsvWriter("products.csv");
      market.userCsvWriter("users.csv");
    }

}
