package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Dao.RepoStudent;
import com.example.demo.Entity.Student;

@Service
public class StudentService {
	@Autowired
	RepoStudent repoStudent;

	public Student saveSt(Student s) {
		Student s2 = repoStudent.save(s);
		return s2;
	}

	public List<Student> getStuds() {
		List<Student> l = (List)repoStudent.findAll();
		return l;
	}

	public Student removeSt(int rno) {
		Student s = repoStudent.findById(rno).orElse(null);
		if(s==null) {
			return null;
		}
		else {
			repoStudent.delete(s);
		}
		return s;
	}

	public String updateNm(int rn, String nm) {
		// TODO Auto-generated method stub
		Student s = repoStudent.findById(rn).orElse(null);
		if(s==null) {
			return "Not Found";
		}
		else {
			s.setName(nm);
			repoStudent.save(s);
			return "Name Updated";
		}
	}
}
