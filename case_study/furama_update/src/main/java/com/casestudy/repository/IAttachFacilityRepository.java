package com.casestudy.repository;

import com.casestudy.dto.IAttachFacilityDto;
import com.casestudy.entity.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {

    @Query(value = "select\n" +
            "    ctrd.id as contractDetailId,\n" +
            "    c.id as contractId,\n" +
            "    af.name as attachFacilityName,\n" +
            "    af.status      as status,\n" +
            "    af.unit as unit,\n" +
            "    ctrd.quantity as quantity,\n" +
            "    af.cost as cost\n" +
            "from\n" +
            "    `contract_detail` as ctrd\n" +
            "        left join `attach_facility` as af on ctrd.attach_facility_id = af.id\n" +
            "        left join contract c on ctrd.contract_id = c.id\n" +
            "where\n" +
            "    ctrd.contract_id = :idContract", nativeQuery = true)
    List<IAttachFacilityDto> getAttachFacilityDto(@Param("idContract") int idContracts);

}
