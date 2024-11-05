package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Product;
import cursoSpringBoot.service.ProductService;
import cursoSpringBoot.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    // *** *** *** *** Instancia de clase de forma manual

    //ProductsServiceImpl productsService = new ProductsServiceImpl();
    //ProductService productsService =new ProductsServiceImpl(); // Polimorfismo dinámico

    // *** *** *** *** Instancia por inyección de dependencias
    @Autowired
    private ProductService productsService; //Composición


    @GetMapping
    public ResponseEntity<?> getProducts() {
        List<Product> products = productsService.getProducts();

        return ResponseEntity.ok(products);
    }
}
