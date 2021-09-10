package crud.crudProject.service;

import java.util.List;

import crud.crudProject.model.Emp;


public interface EmpService {
	List<Emp> 	   empList(Emp emp);
	Emp			   detail(int empno);
	int			   delete(int empno);
	int			   update(Emp emp);
	
	}