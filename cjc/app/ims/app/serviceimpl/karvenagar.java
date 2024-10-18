package com.cjc.ims.app.serviceimpl;

import java.util.*;
import com.cjc.ims.app.servicei.Cjc;

import Interfaceee.I;

import com.cjc.ims.app.customException.Create;
import com.cjc.ims.app.model.*;

public class karvenagar implements Cjc {

	List<Course> clist = new ArrayList<>();
	List<Faculty> flist = new ArrayList<>();
	List<Batch> blist = new ArrayList<>();
	List<Student> slist = new ArrayList<>();
	Course course;

	Faculty faculty;
	Batch batch;
	Student student;
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCourse() {

		course = new Course();
		System.out.println("enter the course id ");
		int coid = sc.nextInt();
		course.setCid(coid);
		System.out.println("enter course name");
		String coname = sc.next();
		course.setCname(coname);

		clist.add(course);

	}

	@Override
	public void viewCourse() {
		Iterator<Course> itrco = clist.iterator();

		while (itrco.hasNext()) {
			Course co = itrco.next();
			System.out.println("course id : " + co.getCid());
			System.out.println("course name : " + co.getCname());

		}

	}

	@Override
	public void addFaculty() {

		faculty = new Faculty();
		System.out.println("enter the faculty id");
		int faid = sc.nextInt();
		faculty.setFid(faid);
		System.out.println("enter faculty name");
		String fname = sc.next();
		faculty.setFname(fname);

		System.out.println("Assign course id to " + fname + " with fid" + fname);
		int cid1 = sc.nextInt();

		Course cc = new Course();
		for (Course cl : clist) {

			if (cl.getCid() == cid1) {
				cc = cl;
				faculty.setCourse(cc);
			}
		}

		flist.add(faculty);

	}

	@Override
	public void viewFaculty() {

		System.out.println("enter faculty id for view your details");
		int fid1 = sc.nextInt();
		Iterator<Faculty> itrfa = flist.iterator();
		while (itrfa.hasNext()) {
			Faculty fac = itrfa.next();
			if (fid1 == fac.getFid()) {
				System.out.println("faculty id : " + fac.getFid());
				System.out.println("faculty name : " + fac.getFname());
				System.out.println("course id : " + fac.getCourse().getCid());
				System.out.println("course name : " + fac.getCourse().getCname());

			}
		}
	}

	@Override
	public void addBatch() {

		batch = new Batch();
		System.out.println("enter the batch id");
		int bid = sc.nextInt();
		batch.setBid(bid);
		System.out.println("enter the batch name");
		String bname = sc.next();
		batch.setBname(bname);
		System.out.println("Enter faculty id for assigne batch ");
		int bid1 = sc.nextInt();

		Faculty ff = new Faculty();

		for (Faculty f1 : flist) {
			ff = f1;
			if (f1.getFid() == bid1) {
				batch.setFaculty(ff);
			}
		}

		blist.add(batch);

	}

	@Override
	public void viewBatch() {
		System.out.println("enter batch id  for view your details");
		int bt1 = sc.nextInt();

		Iterator<Batch> itrbc = blist.iterator();
		while (itrbc.hasNext()) {

			Batch bt = itrbc.next();
			if (bt1 == bt.getBid()) {
				System.out.println(bt.getBid());
				System.out.println(bt.getBname());
				System.out.println("faculty id : " + bt.getFaculty().getFid());
				System.out.println("faculty name : " + bt.getFaculty().getFname());
				System.out.println("course id : " + bt.getFaculty().getCourse().getCid());
				System.out.println("course name : " + bt.getFaculty().getCourse().getCname());
			}
		}

	}

	@Override
	public void addStudent() {
		student = new Student();
		System.out.println("enter student id");
		int sid = sc.nextInt();
		student.setSid(sid);

		System.out.println("enter student name ");
		String sname = sc.next();
		student.setSname(sname);

		System.out.println("Assign btach id to " + sname + " with fid " + sid);
		int cid1 = sc.nextInt();
		Batch bb = new Batch();
		for (Batch b1 : blist) {
			bb = b1;
			if (b1.getBid() == cid1) {

				student.setBatch(bb);
			}
		}

		slist.add(student);
	}

	@Override
	public void viewStudent() {
		System.out.println("enter student id for view your details");
		int std1 = sc.nextInt();

		Iterator<Student> itrst = slist.iterator();
		while (itrst.hasNext()) {
			Student st = itrst.next();

			if (std1 == st.getSid()) {
				System.out.println("student is : " + st.getSid());
				System.out.println("student name is : " + st.getSname());
				System.out.println("batch id of student : " + st.getBatch().getBid());
				System.out.println("batch name of student : " + st.getBatch().getBname());
				System.out.println("faculty id : " + st.getBatch().getFaculty().getFid());
				System.out.println("faculty name : " + st.getBatch().getFaculty().getFname());
				System.out.println("course id : " + st.getBatch().getFaculty().getCourse().getCid());
				System.out.println("course name : " + st.getBatch().getFaculty().getCourse().getCname());
			}
		}

	}

	@Override
	public void updateDteails() {
//		student = new Student();
//		course =new Course();
//		batch=new Batch();
//		faculty=new Faculty();
		
		System.out.println("enter Student id for update dteails");
		int uid = sc.nextInt();
		
		for(Student stu: slist) {
		
		if (uid == student.getSid()) {

			System.out.println("enter 1 for update Student name 2 for update batch 3 for update faculty");
			int u = sc.nextInt();

			switch (u) {

			case 1: {
				System.out.println("enter name for update");
				String sname = sc.next();
				student.setSname(sname);
				break;
			}
		
			

			case 2: {
				System.out.println("enter name for update batch");
				String Bname = sc.next();
				batch.setBname(Bname);
				break;
			}
			
			
			}
		}
		}
	}

}
