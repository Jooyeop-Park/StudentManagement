package kosta.student.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//import kosta.collection.list.Car;
import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

public class AddScore implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub

		
		LinkedList<Student> list = StudentManager.getList("1");

		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("점수 : ");
		int score = scan.nextInt();
		
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
			if(num == s.getNum()) {
				s.setScore(score);
				System.out.println(num + "번 학생의 성적이 등록되었습니다. \n");
				SearchStudent searchs = new SearchStudent();
				searchs.printStudentWithHeader(s);
			}
		} // end of while
		
		



	} // end of execute()

} // end of class
