package trab4;

//Classe que possui a definição de um usuário

public class User{
  String name;
  Integer code;
  String password;
  String email;


  public User(){}

  public User(String name, Integer code, String password, String email){
    this.name = name;
    this.code = code;
    this.password = password;
    this.email = email;
  }


  public User(String csv){
    String[] values = csv.split(",");
    name = values[0];
    code = Integer.valueOf(values[1]);
    password = values[2];
    email = values[3];
  }


  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public Integer getCode(){
    return code;
  }
  public void setCode(Integer code){
    this.code = code;
  }
  public String getPassword(){
    return password;
  }
  public void setPassword(String password){
    this.password = password;
  }
  public String getEmail(){
    return email;
  }
  public void setEmail(String email){
    this.email = email;
  }

  public String toString() {
    return "Nome:"+ name + " Codigo:" + code + " email:" + email;
  }

   public String toFile(){
     return name + "," + code + "," + password + "," + email;
   }

}
