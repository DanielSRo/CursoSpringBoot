package cursoSpringBoot.domain;

//Clase de tipo POJO (Plain Old Java Object)
public class Product {

    /*Cuando se maneja framework no se aconseja manejar tipos de datos primitivos, sino referenciales
    * esto, ya que de esta forma podremos manejar de manera correcta los valores nulos.
    * Int -> Integer
    * double -> Double */

    //Atributos
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;

    //Constructor
    public Product(Integer id, String name, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    //Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
