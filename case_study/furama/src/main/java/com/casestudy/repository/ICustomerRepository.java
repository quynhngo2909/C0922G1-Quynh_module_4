package com.casestudy.repository;

import com.casestudy.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where name like %:name% and email like %:email%", nativeQuery = true)
    Page<Customer> findCustomerByNameEmail (@Param("name") String name,@Param("email") String email, Pageable pageable);

}
