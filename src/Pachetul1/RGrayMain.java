package Pachetul1;

import java.io.BufferedReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Pachetul2.*;

public class RGrayMain {
	
	static void afisare(int t,String... args) {
		System.out.println("In aceasta functie se folosesc var args\n");
		
		if(t==0)
		{
			System.out.println("filepath: "+args[0]);
		}
		else
		{
			System.out.println("The Image has been converted to Grayscale.");
		}
	}
	
	public static void main(String[] args)throws InterruptedException, IOException
	{
		// TODO Auto-generated method stub
		if(args.length!=0) 
		{
			
		afisare(0,args[0]);
		
		
		long startingTime = System.nanoTime();
		
		//numele fisierului, este declarat initial null
		String outputFilePath = null; 
		
		//se creeaza un nou obiect de tip GrayImg
		Pachetul2.GrayImg obj=new GrayImg();
		
		outputFilePath = args[0];
		
		 File output = new File(outputFilePath);
		 
		 //se apeleaza metoda de conversie 
		 ImageIO.write(obj.ProcessToGreyscale(args[1]), "bmp", output);
		 
		 afisare(1,args[0]);
		
		 long endingTime   = System.nanoTime();
		 double efectTime = endingTime - startingTime; //timpul de executie al metodei main
		 System.out.println("Timp de executie: Main: " + efectTime/1000000000 + " secunde");	
	}
	
	
	if(args.length==0) {
		long startingTime = System.nanoTime();
		String outputFilePath = null; //numele fisierului, declarat initial nul
		
		Pachetul2.GrayImg obj = new GrayImg();//se creeaza nou obiect de tip GrayImg
	   
	   
	   try {
		   //numele fisierului de iesire 
		   //(in care este pastrata imaginea alb-negru) 
		   //se citeste de la tastatura in acelasi mod ca fisierul de intrare
			InputStreamReader isr = new InputStreamReader(System.in);
		    BufferedReader br = new BufferedReader(isr);
		    System.out.println("Introduceti numele/adresa fisierului in care se va salva noua imagine (extensie .bmp) debug 2");
			outputFilePath = (br.readLine()).toString();
			System.out.println(outputFilePath);
			
			while (!outputFilePath.endsWith(".bmp"))
			{
				System.out.println("Fisierul nu are extensia potrivita."
						+ " Introduceti un nume de fisier cu extensia .bmp.");
				outputFilePath =  (br.readLine()).toString();
			}	
		}
							
		catch (IOException e)
		{
			System.out.println(e);
		}
	   
	   File output = new File(outputFilePath);
	   
	   ImageIO.write(obj.ProcessToGreyscale(), "bmp", output); //se apeleaza metoda de conversie 
	   
	    System.out.println("The Image has been converted to Grayscale.");
	   
	   	long endingTime   = System.nanoTime();
		double efectTime = endingTime - startingTime; //timpul de executie al metodei main
		System.out.println("Timp de executie: Main: " + efectTime/1000000000 + " secunde");	
	


		}
	}

}


