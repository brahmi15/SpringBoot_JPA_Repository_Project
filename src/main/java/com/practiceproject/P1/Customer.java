package com.practiceproject.P1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="customer_details")

public class Customer {

    //to uniquely identify the database
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String first_name;
    private String last_name;
    private String email;
    private String address;

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", ID=" + Id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
