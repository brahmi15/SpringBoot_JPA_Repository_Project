package com.practiceproject.P1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Services {

    @Autowired
    private Repository repository;

    //to get all details
    public List<Customer> getAlldetails() {
        List<Customer> list = (List<Customer>) this.repository.findAll();
        return list;
    }

    //get details by id
    public  Customer getdetailById(int id){
        Customer customer = null;
        try {
            customer = this.repository.findById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }

    //adding the customer detail
    public  Customer adddetail(Customer b){
        Customer result = repository.save(b);
        return result;
    }

    //deleting details
    public void deletedetail(int cid) {
        repository.deleteById(cid);
    }

    //update customer details
    public void updatedetail(Customer customer, int cid) {
        customer.setId(cid);
        repository.save(customer);
    }
}
