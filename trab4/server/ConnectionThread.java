package trab4.server;

import trab4.User;
import trab4.Product;
import trab4.Market;
import java.util.*;
import java.net.*;
import java.io.*;

// Classe que faz o tratamento dos dados da comunicação entre servidor e cliente
public class ConnectionThread implements Runnable{

	Socket s;
	BufferedReader in;
	PrintWriter out;
	List<Product> products;
	List<User> users;

	public ConnectionThread(Socket s,List<Product> products, List<User> users){
				this.s = s;
				this.products = products;
				this.users = users;
	}

	@Override
	public void run() {
      try {
          in = new BufferedReader(new InputStreamReader(s.getInputStream()));
          String response;
					System.out.println("Conexão feita!");
          while((response = in.readLine()) != null){
            action(response);
          }
          s.close();
          } catch (Exception e) {}
	}


	private void action(String response) {
			String[] values = response.split(",");
			Integer op = Integer.parseInt(values[0]);
			boolean result;
					switch(op){
					 		case 1:
							result = login(Integer.parseInt(values[1]), values[2]);
							try {
								out = new PrintWriter(s.getOutputStream(), true);
								if(result){
									out.println("true");
								}else{
									out.println("false");
								}
							} catch (Exception e) {	}
					case 2:
							users.add(new User(values[1], Integer.parseInt(values[2]), values[3], values[4]));
							try {
								out = new PrintWriter(s.getOutputStream(), true);
								out.println("true");
							} catch (Exception e) {	}
					case 3:
							try {
								out = new PrintWriter(s.getOutputStream(), true);
								for(Product p : products){
									out.println(p);
								}
								out.println("end");
							} catch (Exception e) {}

						}

			}

	 public boolean login(int code, String password){
				try {
						for(User user : users){
							System.out.println(code + ","+ password);
							if(user.getCode() == code && user.getPassword().equals(password)) {
								return true;
							}
						}
						return false;
					}
					catch(Exception e){
						return false;
					}
			}





}
