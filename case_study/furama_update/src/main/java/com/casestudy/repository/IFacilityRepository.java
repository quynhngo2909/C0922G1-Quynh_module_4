package com.casestudy.repository;

import com.casestudy.entity.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where name like %:name% and facility_type_id in (select ft.id from facility_type ft where ft.name like %:facilityName%) and is_expired = 0", nativeQuery = true)
    Page<Facility> findFacilityByNameType(@Param("name") String name, @Param("facilityName") String facilityName, Pageable pageable);
    @Query(value = "select distinct f.id from facility f where f.name = :name", nativeQuery = true)
    Integer findFacilityIdByName(@Param("name")String name);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update furama_db.facility t set t.is_expired = 1 where t.id = :id", nativeQuery = true)
    void setExpired(@Param("id") int id);
}
