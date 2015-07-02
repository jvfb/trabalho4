package trab4.server;

import trab4.User;
import trab4.Product;
import trab4.Market;
import java.util.*;
import java.net.*;
import java.io.*;


//Classe que gera o listener a espera de conexões de usuario
public class ListenerThread implements Runnable {

  Integer port;
  List<Product> products;
  List<User> users;

  public ListenerThread(Integer port, List<Product> products, List<User> users ){
    this.port = port;
    this.products = products;
    this.users = users;
  }

  @Override
  public void run() {
    try {
      ServerSocket listener = new ServerSocket(port);
      Socket socket;
      while (true) {
         socket = listener.accept();
         System.out.println("Servidor ouvindo...");
         Thread ct = new Thread(new ConnectionThread(socket, products, users));
         ct.start();
       }
     }
     catch (Exception e) {}
  }



}
