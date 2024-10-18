package com.cjc.ims.app.client;
import java.util.*;


import com.cjc.ims.app.serviceimpl.karvenagar;

public class Test {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 karvenagar k=new karvenagar();
		 try {
		 while(true) {
		System.out.println("enter 1 of add course 2 for view course 3 for add faculty 4 for view faculty 5 for add batch 6 for view batch 7 for add student 8 for view student 9 for update ");
		int no=sc.nextInt();
		switch(no) {
		case 1:{
			k.addCourse();
			break;
		}case 2:{
			
			k.viewCourse();
			
			
			break;
		}
		case 3:{
			
			k.addFaculty();
			break;
		}case 4:{
			k.viewFaculty();
			break;
		}case 5:{
			k.addBatch();
			break;
		}case 6:{
			k.viewBatch();
			break;
		}
		case 7:{
			k.addStudent();
			break;
		}case 8:
		{
			k.viewStudent();
			break;
		}case 9 :{
			k.updateDteails();
			break;
		}
		
		}
		 }}catch(InputMismatchException e) {
			 System.out.println("please input integer value only");
		 }
	}

}
