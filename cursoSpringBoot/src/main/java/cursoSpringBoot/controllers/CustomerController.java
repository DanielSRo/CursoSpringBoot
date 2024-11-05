package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Paco Rocha","rochita","(-_-)_123"),
            new Customer(456, "Alejandra García", "alegarci","(@-@)_456"),
            new Customer(789, "Laura Sanchéz", "lauras", "('-')_789"),
            new Customer(159,"Carlos Martínez", "matica", "(*-*)_159")
    ));

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(){

        return ResponseEntity.ok(customers);
        //return customers;
    }

    //@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    @GetMapping("/{userName}")
    public ResponseEntity<?> getCliente(@PathVariable String userName){

        for(Customer c: customers){
            if(c.getUserName().equals(userName)){
                return ResponseEntity.ok(c);
                //return c;
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username: " + userName);
        //return null; // pésima practíca.
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Customer customer) {
        customers.add(customer);

        /*Cuando se trabaja con una API RESTfull, en el caso de hacer una solicitud de POST, una buena práctica es
        * que esta también devuelva la URI (Identificado de Recuso Uniforme), con el fin de poder localizarlo e
        * identificarlo de acuerdo a esta dirección URI o URL.*/

        URI location = ServletUriComponentsBuilder //Indicamos la construcción de la URI de forma programática
                .fromCurrentRequest() //Metodo para tener la información de la URI de la solicitud actual
                .path("/{userName}") //Agrega un segmento de ruta a la ruta base
                .buildAndExpand(customer.getUserName()) //Toma el valor proporcionado e inserta en el segmento de ruta
                .toUri(); //finalizar la construcción y convierte la ruta construida en un objeto URI

        return  ResponseEntity.created(location).body(customer);
        
        //return ResponseEntity.created(location).build();
        //return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente: " + customer.getUserName());

        // return customer;
    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Customer customer){

        for(Customer c: customers){
            if(c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUserName(customer.getUserName());
                c.setPassword(customer.getPassword());

                /*En el caso del put y delete, no es necesario que este retorne un mensaje de confirmación, ya
                * que el código dé respuesta http más ádecuado es el 204. Este código se puede generar deforma
                * simplificada usando el metodo, '.noContent' usando el metodo, status. Al ser un código de respuesta
                * 204 (NO_CONTENT), el cuerpo del body no será enviado a la hora de hacer la solicitud.*/

                return ResponseEntity.noContent().build();
                //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente modificado satisfactoriamente: " + customer.getID());

                //return ResponseEntity.ok("Cliente modificado satisfactoriamente: " + customer.getID());
                //return c;
            }
        }

        /*Del mismo modo que se puede simplificar las respuestas de código 204, se puede simplificar las de 404
        * (NOT_FOUND), esto tras el metodo, '.notFound'*/

        return ResponseEntity.noContent().build();
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + customer.getID());

        //return  null; // mala practica
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id){

        for(Customer c: customers) {
            if(c.getID() == id){
                customers.remove(c);

                return ResponseEntity.noContent().build();
                //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente eliminado satisfactoriamente: " + id);

                //return c;
            }
        }
        return ResponseEntity.notFound().build();
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + id);

        //return null; // mala practica
    }

    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Customer customer){
        for(Customer c: customers){
            if(c.getID() == customer.getID()){
                if(customer.getName() != null){
                    c.setName(customer.getName());
                }
                if(customer.getUserName() != null){
                    c.setUserName(customer.getUserName());
                }
                if(customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }

                return ResponseEntity.ok("Cliente modificado satisfactoriamente: " + customer.getID());
                //return c;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con el ID: " + customer.getID());
        //return null; // pésima practica
    }
    
}




























