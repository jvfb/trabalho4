package trab4;
//Classe que possui a definição de um produto

public class Product{
  String name;
  Integer code;
  Double price;
  Integer quantity;

  public Product(){};

  public Product(String csv) {
    String[] values = csv.split(",");
    name = values[0];
    code = Integer.valueOf(values[1]);
    price = Double.valueOf(values[2]);
    quantity = Integer.valueOf(values[3]);
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
  public Double getPrice(){
    return price;
  }
  public void setPrice(Double price){
    this.price = price;
  }
  public Integer getQuantity(){
    return quantity;
  }
  public void setQuantity(Integer quantity){
    this.quantity = quantity;
  }
  public String toString() {
    return "Produto:"+ name + " Código:" + code + " Preço:" + price + " Quantidade:" + quantity;
  }

}
