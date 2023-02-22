package com.casestudy.repository;

import com.casestudy.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface IContractRepository extends JpaRepository<Contract, Integer> {
//    @Query(value = "select c.id, c.facility_id, c.customer_id, c.start_date, c.end_date, c.deposit, null as 'Total'  from `contract` c where c.customer_id in (select cus.id from `customer` cus where cus.name like concat('%', :customerName, '%'))", nativeQuery = true)
//    Page<Contract> findContractByCustomerFacilityEmployeeFacility(@Param("customerName") String customerName,
//                                                         String employeeName,
//                                                          String facilityName,
//                                                          Pageable pageable);


    @Query(value = "select\n" +
            "    c.id,\n" +
            "    c.facility_id,\n" +
            "    c.customer_id,\n" +
            "    c.start_date,\n" +
            "    c.end_date,\n" +
            "    c.deposit,\n" +
            "    null as 'total'\n" +
            "from\n" +
            "    `contract` as c\n" +
            "INNER JOIN `customer` as cus on cus.id = c.customer_id and cus.name like concat('%', :customerName, '%')\n" +
            "INNER JOIN `employee` as e on e.id = c.employee_id and e.name like concat('%', :employeeName, '%')\n" +
            "INNER JOIN  `facility` as f on f.id = c.facility_id and f.name like concat('%', :facilityName, '%')",
            nativeQuery = true)
    Page<Contract> findContractByCustomerEmployeeFacility(@Param("customerName") String customerName,
                                                                  @Param("employeeName") String employeeName,
                                                                  @Param("facilityName") String facilityName,

                                                                  Pageable pageable);

    @Query(value = "select c.id, c.facility_id, c.customer_id, c.start_date, c.end_date, c.deposit, null as 'Total'  from `contract` c where customer_id in (select ct.id from `customer_type` ct where ct.name like concat('%', :customerName, '%'))", nativeQuery = true
            ,countQuery = "select * from contract")
    Page<Contract> findContractByCustomer(@Param("customerName") String customerName,
                                                          Pageable pageable);

    @Query(value = "select c.id, c.facility_id, null as 'Total'  from `contract` c" ,countQuery = "select * from contract", nativeQuery = true)
    Page<Contract> findContract(Pageable pageable);
}