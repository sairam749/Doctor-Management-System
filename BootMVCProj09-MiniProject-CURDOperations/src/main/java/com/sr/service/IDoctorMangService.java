package com.sr.service;

import java.util.List;

import com.sr.VO.DoctorVO;

public interface IDoctorMangService 
{
 public List<DoctorVO>FindAllDoctors();
 
 public String registerDoctor(DoctorVO vo);
 
 public DoctorVO showDoctorById(int id);
 
 public String editDoctor(DoctorVO vo);
 
 public String deleteDoctorById(int id);
}
