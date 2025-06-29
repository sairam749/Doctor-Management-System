package com.sr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.VO.DoctorVO;
import com.sr.entity.DoctorEntity;
import com.sr.repository.IDoctorRepository;
@Service
public class DoctorMangServiceImp implements IDoctorMangService 
{
	@Autowired
	private IDoctorRepository docrepo;

	@Override
	public List<DoctorVO> FindAllDoctors() 
	{
		List<DoctorEntity>listEntity=docrepo.findAll();
		
		List<DoctorVO>listvo=new ArrayList<DoctorVO>();
	     listEntity.forEach(entity->{
	    	 DoctorVO vo=new DoctorVO();
		  BeanUtils.copyProperties(entity,vo);
		  listvo.add(vo);
		});
	     return listvo;
	}

	@Override
	public String registerDoctor(DoctorVO vo)
	{
		DoctorEntity entity=new DoctorEntity();
		BeanUtils.copyProperties(vo, entity);
		entity.setCreatedBy(System.getProperty("user.name"));
		int idval=docrepo.save(entity).getDid();
		return "Doctor is Registerd with id value:"+idval;
	}

	@Override
	public DoctorVO showDoctorById(int id) 
	{
		//use repo
	 DoctorEntity entity=docrepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid Id"));
	  //convert entity obj to VO object
	 DoctorVO vo=new DoctorVO();
	 BeanUtils.copyProperties(entity, vo);
	 return vo;
	}

	@Override
	public String editDoctor(DoctorVO vo) 
	{
		DoctorEntity entity=docrepo.findById(vo.getDid()).orElseThrow(()->new IllegalArgumentException("invalid"));
		BeanUtils.copyProperties(vo, entity);
		entity.setUpdatedBy(System.getProperty("user.name"));
		docrepo.save(entity);
		return vo.getDid()+"DoctorEntity are updated";
	}

	@Override
	public String deleteDoctorById(int id) 
	{
		DoctorEntity entity=docrepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid"));
		docrepo.deleteById(id);
		return id+"is deleted";
	}
	

}
