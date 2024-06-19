package com.practiceproject.P1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//combination of Controller and ResponseBody (this class works as a controller class)
//allows to handle all REST APIs
@RestController
public class Controller {

    @Autowired
    private Services service;

    //to get all the details
    @GetMapping("/customer_details")
    public ResponseEntity<List<Customer>> getdetails() {
        List<Customer> list = service.getAlldetails();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    //GET SINGLE BOOK BASED ON ID
    @GetMapping("/customer_details/{id}")
    public ResponseEntity<Customer> getdetail(@PathVariable("id") int id) {
        Customer c = service.getdetailById(id);
        if(c == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(c));
    }

    //CREATE A NEW BOOK
    @PostMapping("/customer_details")
    public ResponseEntity<Customer> adddetails(@RequestBody Customer customer){
        Customer c = null;
        try {
            c = this.service.adddetail(customer);
            System.out.println(customer);
            return ResponseEntity.of(Optional.of(c));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //DELETE BOOK
    @DeleteMapping("/customer_details/{customer_details_Id}")
    public ResponseEntity<Void> deletedetails(@PathVariable("customer_details_Id") int cid){
        try {
            this.service.deletedetail(cid);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //UPDATE DETAILS
    @PutMapping("/customer_details/{customer_details_Id}")
    public ResponseEntity<Customer> updatedetails(@RequestBody Customer customer, @PathVariable("customer_details_Id") int cid){
        try {
            this.service.updatedetail(customer, cid);
            return  ResponseEntity.ok().body(customer);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
