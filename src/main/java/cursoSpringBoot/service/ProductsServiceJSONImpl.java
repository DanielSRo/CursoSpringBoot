package cursoSpringBoot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cursoSpringBoot.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Primary
@Service
public class ProductsServiceJSONImpl implements ProductService{


    @Override
    public List<Product> getProducts() {
         List<Product> products;

         try{
             products = new ObjectMapper() //Biblioteca JSON
                     .readValue(this.getClass().getResourceAsStream("/products.json"),
                             new TypeReference<List<Product>>() {});
             //Deserialización del archivo (nombre del archivo, donde se van a depositar los datos)

             return products;

         }catch(IOException e){
             throw new RuntimeException(e);
        }
    }
}
