package com.ats.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.entity.TagDetailsEntity;

@Repository
public interface TagRepository extends JpaRepository<TagDetailsEntity, Serializable> {
	
	@Query(value="SELECT tde FROM TagDetailsEntity tde WHERE tde.vchlRegNo=:vhclreg")
	TagDetailsEntity vehicleSearchByRegNo(@Param("vhclreg")String vchlRegNo);

}
