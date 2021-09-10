package crud.crudProject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crud.crudProject.model.Emp;


@Repository
public class EmpDaoImpl implements EmpDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<Emp> empList(Emp Emp) {
		List<Emp> empList = null;
		System.out.println("EmpDaoImpl empList Start ...");
		try {
			empList = session.selectList("empList", empList);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl empList Exception->"+e.getMessage());
		}
	return empList;
	}

	@Override
	public Emp detail(int empno) {
		System.out.println("EmpDaoImpl detail Start ...");
		Emp emp = new Emp();
		try {					
			// 						 mapperID / Parameter
			emp = session.selectOne("detail", empno);
			System.out.println("EmpDaoImpl detail getEname ->" + emp.getEname());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl detail Exception->" + e.getMessage());
		}
		return emp;
	}

	@Override
	public int delete(int empno) {
		System.out.println("EmpDaoImpl delete Start ...");
		int result = 0;
		try {
			result = session.delete("delete", empno);
			System.out.println("EmpDaoImpl delete result ->" + result);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl delete Exception->" + e.getMessage());
		
		}
		return result;
	}

	@Override
	public int update(Emp emp) {
		System.out.println("EmpDaoImpl update Start ...");
		int result = 0;
		try {
			result = session.update("update", emp);
			System.out.println("empDaoImpl update result->" + result);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl update Exception " + e.getMessage());
		}		
		return result;
	}
}
