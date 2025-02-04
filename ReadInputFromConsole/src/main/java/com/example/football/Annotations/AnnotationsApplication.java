package com.example.football.Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Scanner;

@SpringBootApplication
public class AnnotationsApplication {
	public static void main(String[] args) throws Exception {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String s = bufferedReader.readLine();//Used to read contents line by line

		System.out.println(s);


		Scanner sc = new Scanner(System.in);
		String insc = sc.next();
		char insc1 = sc.next().charAt(0);
		int xint = sc.nextInt();
		Long xlong = sc.nextLong();
	}
}
