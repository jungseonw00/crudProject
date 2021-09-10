package crud.crudProject.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import crud.crudProject.model.Emp;
import crud.crudProject.service.EmpService;

@Controller
public class EmpController {
	@InitBinder
    protected void initBinder(WebDataBinder binder){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
    }

	@Autowired
	private EmpService es;
	
	//Index 화면
	@RequestMapping("/")
	public String home(Model model, Emp emp) {
		System.out.println("EmpController Start...");
		List<Emp> empList = es.empList(emp);
		model.addAttribute("empList", empList);
		System.out.println("EmpController list empList.size() => " + empList.size());
		
		return "index";
	}
	
	//사원번호 상세보기
	@GetMapping(value="detail")
	public String detail(HttpServletRequest request, int empno, Model model) {
		System.out.println("EmpController detail Start..." );
		Emp emp = es.detail(empno);
		model.addAttribute("emp",emp);
		
		return "EmpDetail";
	}
	
	//사원 삭제
	@GetMapping("delete")
	public String delete(Model model, int empno) {
		System.out.println("EmpController delete Start...");
		int result = es.delete(empno);
		model.addAttribute("result", result);
		return "EmpDetail";
	}
	
	//사원수정 페이지
	@GetMapping("updateForm")
	public String updateForm(Model model, int empno) {
		System.out.println("EmpController update Start...");
		Emp emp = es.detail(empno);
		model.addAttribute("emp",emp);
		return "updateForm";
	}
	
	//사원수정
	@PostMapping("update")
	public String update(Model model, Emp emp) {
		System.out.println("EmpController update Start...");
		int result = es.update(emp);
		model.addAttribute("result", result);
		return "updateForm";
	}
}
