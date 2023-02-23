package com.casestudy.repository;


import com.casestudy.dto.IContractDto;
import com.casestudy.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select\n" +
            "    ctr.id as id,\n" +
            "    f.name as facility,\n" +
            "   cus.name as customer,\n" +
            "    emp.name as employee,\n" +
            "    ctr.start_date as startDate,\n" +
            "    ctr.end_date as endDate,\n" +
            "    ctr.deposit as Deposit,\n" +
            "    (sum(ifnull(ctrdt.attach_facility_id, 0) * ifnull(af.cost, 0))) + f.cost as totalCost\n" +
            "from\n" +
            "    `contract` as ctr\n" +
            "        left join `contract_detail` ctrdt on ctrdt.contract_id = ctr.id\n" +
            "        left join `attach_facility` af on ctrdt.attach_facility_id = af.id\n" +
            "        left join `facility` f on ctr.facility_id = f.id and f.name like concat('%', '', '%')\n" +
            "        left join `customer` cus on ctr.customer_id = cus.id and cus.name like concat('%', '', '%')\n" +
            "        left join `employee` emp on ctr.employee_id = emp.id and emp.name like concat('%', '', '%')\n" +
            "group by ctr.id",nativeQuery = true)
    Page<IContractDto> getContractDtos(@Param("customerName") String customerName,
                                    @Param("employeeName") String employeeName,
                                    @Param("facilityName") String facilityName,
                                    Pageable pageable);
    @Query(value = "select *  from `contract` c where customer_id in (select ct.id from `customer_type` ct where ct.name like concat('%', :customerName, '%'))", nativeQuery = true
            , countQuery = "select * from contract")
    Page<Contract> findContractByCustomer(@Param("customerName") String customerName,
                                          Pageable pageable);

    @Query(value = "select * from `contract` c", countQuery = "select * from contract", nativeQuery = true)
    Page<Contract> findContract(Pageable pageable);

    @Query(value = "select\n" +
            "    ctr.id,\n" +
            "    ctr.facility_id,\n" +
            "   ctr.customer_id,\n" +
            "    ctr.employee_id,\n" +
            "    ctr.start_date,\n" +
            "    ctr.end_date,\n" +
            "    ctr.deposit\n" +
//            "    sum(ifnull(ctrdt.attach_facility_id, 0) * ifnull(af.cost, 0)) + f.cost as totalCost \n" +
            "from\n" +
            "    `contract` as ctr\n" +
            "        left join `contract_detail` ctrdt on ctrdt.contract_id = ctr.id\n" +
            "        left join `attach_facility` af on ctrdt.attach_facility_id = af.id\n" +
            "        left join `facility` f on ctr.facility_id = f.id and f.name like concat('%', '', '%')\n" +
            "        left join `customer` cus on ctr.customer_id = cus.id and cus.name like concat('%', '', '%')\n" +
            "        left join `employee` emp on ctr.employee_id = emp.id and emp.name like concat('%', '', '%')\n" +
            "group by ctr.id",nativeQuery = true)
    Page<Contract> findContractByCustomerEmployeeFacility(@Param("customerName") String customerName,
                                                          @Param("employeeName") String employeeName,
                                                          @Param("facilityName") String facilityName,
                                                          Pageable pageable);
}
