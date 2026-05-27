package com.flo.Main;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	boolean running = true;
	
	public void run() {
		int input = 0;
		String command = null;
		
		while (running) {
			Greeting();
			input = Input();
			
			switch (input) {
			case 1:
				command = Option1();
				break;
				
			case 2:
				command = Option2();
				break;
			case 3:
				running = false;
				break;
			}
			
			if (running) {
				Process process = InitiateProcess(command);
				OutputProcess(process);
				
			}
			
		}
		System.out.println("test");
	}
	
	public void Greeting() {
		System.out.println("SELECT OPTIONS YOU WANT BELOW:");
		System.out.println("1. DISM - RESTORE VIA ONLINE");
		System.out.println("2. SFC SCAN");
		System.out.println("");
		
		
	}
	
	public Process InitiateProcess(String command) {
		
		Process process = null;
		
		try {
			process = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return process;
	}
	
	public void OutputProcess(Process process) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		String line = "";
		
		try {
			while((line = reader.readLine()) != null) {
				System.out.println(line + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int Input() {
		Scanner scanline = new Scanner(System.in);
		
		int value = scanline.nextInt();
		return value;
	}
	
	
	public String Option1() {
		String command = "DISM /Online /Cleanup-Image /RestoreHealth";
		
		return command;
		
	}
	
	public String Option2() {
		String command = "sfc /scannow";
		
		return command;
	}
	
	public static void main(String[] args) {
		
		Main mCore = new Main();
		mCore.run();
		
		
	}

	
}
