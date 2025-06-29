package com.sr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sr.entity.DoctorEntity;

public interface IDoctorRepository extends JpaRepository<DoctorEntity,Integer> {

}
