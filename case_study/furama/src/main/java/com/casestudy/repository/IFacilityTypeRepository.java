package com.casestudy.repository;

import com.casestudy.entity.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
    @Query(value = "select ft.id from facility_type ft where ft.name like %:name%", nativeQuery = true)
    List<Integer> findFacilityTypeByName(@Param("name") String name);
}
