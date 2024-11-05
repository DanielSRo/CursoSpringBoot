package cursoSpringBoot.domain;

//clase POJO
public class Customer {

    //atributos
    private int ID;
    private String name;
    private String userName;
    private String password;

    //Constructor
    public Customer(int ID, String name, String userName, String password) {
        this.ID = ID;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    //Getter y Setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
