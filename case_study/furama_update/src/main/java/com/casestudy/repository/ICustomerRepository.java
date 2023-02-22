package com.casestudy.repository;

import com.casestudy.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where name like %:name% and email like %:email% and customer_type in (select ct.id from customer_type ct where ct.name like %:customerTypeName% ) and is_expired = 0", nativeQuery = true)
    Page<Customer> findCustomerByNameEmail (@Param("name") String name,@Param("email") String email, @Param("customerTypeName") String customerTypeName, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update furama_db.customer c set c.is_expired = 1 where c.id = :id", nativeQuery = true)
    void setExpiredCustomer(@Param("id") int id);

    @Query(value = "select distinct c.id from customer c where c.id_Card = :idCard or c.email = :email or c.phone_Number = :phoneNumber", nativeQuery = true)
    Integer getCustomerIDByIdCardEmailPhoneNumber(@Param("idCard") String idCard, @Param("email") String email, @Param("phoneNumber") String phoneNumber);

}
