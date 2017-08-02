package kosta.student.service;

import java.util.Scanner;

import kosta.student.vo.Student;
import kosta.student.manage.*;

public class AddStudent implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("주소 : ");
		String address = scan.next();
		System.out.print("성별 : ");
		String gender = scan.next();
		System.out.print("반 : ");
		String clss = scan.next();
		System.out.print("키 : ");
		double height = scan.nextDouble();
		System.out.print("나이 : ");
		int age = scan.nextInt();
		System.out.print("점수 : ");
		int score = scan.nextInt();
		System.out.print("학년 : ");
		int year = scan.nextInt();
		
		boolean res = false;
		Student s = new Student(num, name, address, gender, clss, height, age, score, year);
		if (StudentManager.add(s)){
			System.out.println("\n"+ num + "번 학생이 추가되었습니다.");
			SearchStudent searchs = new SearchStudent();
			searchs.printStudentWithHeader(s);
		}
		
	}

}
