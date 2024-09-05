package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studService;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student s) {
		Student s2 = studService.saveSt(s);
		return s2;
	}
	
	@GetMapping("/getStudent")
	public List<Student> getStudents(){
		List<Student> users = studService.getStuds();
		return users;
	}
	
	@DeleteMapping("/removeStudent/{rno}")
	public Student removeStud(@PathVariable int rno) {
		Student s = studService.removeSt(rno);
		return s;
	}
	
	@PutMapping("/updateName/{rn}/{nm}")
	public String updateName(@PathVariable int rn, @PathVariable String nm) {
		String r = studService.updateNm(rn,nm);
		return r;
	}
}
