package crud.crudProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.crudProject.dao.EmpDao;
import crud.crudProject.model.Emp;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDao ed;

	@Override
	public List<Emp> empList(Emp emp) {
		List<Emp> empList = null;
		System.out.println("EmpServiceImpl listEmp Start...");
		empList = ed.empList(emp);
		System.out.println("EmpServiceImpl listEmp empList.size()->" + empList.size());
		
		return empList;
	}

	@Override
	public Emp detail(int empno) {
		System.out.println("EmpServiceImpl detail Start...");
		Emp emp = null;
		emp = ed.detail(empno);
		
		return emp;
	}

	@Override
	public int delete(int empno) {
		System.out.println("EmpServiceImpl delete Start...");
		int result = 0;
		result = ed.delete(empno);
		
		return result;
	}

	@Override
	public int update(Emp emp) {
		System.out.println("EmpServiceImpl delete Start...");
		int result = 0;
		result = ed.update(emp);
		
		return result;
	}
}