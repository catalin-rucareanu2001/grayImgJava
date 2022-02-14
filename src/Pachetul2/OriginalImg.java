package Pachetul2;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class OriginalImg extends Imagine{
	double width, height;
	BufferedImage img;
	
	OriginalImg() throws InterruptedException {
		//mostenirea clasei parinte se va realiza prin implementrea 
		//acestui constructor fara parametrii al clasei acestea (originalImage)
		//unde clasa parinte este Imagine
		super();
	}
	OriginalImg(String y) throws InterruptedException { 
		//similar constructorului fara parametru, in constructorul cu
		//parametru vom apela constructorul clasei parinte denumita Imagine
		//pentru a realiza mostenirea
		super();
	}
	//implementam un conastructor suplimentare cu parametrii
	OriginalImg(double w, double h, BufferedImage i) throws InterruptedException
	{
		//timpul de initiere pentru executia metodei
		long startingTime = System.nanoTime();
		width = w;
		height = h;
		img = i;
		
		long endingTime = System.nanoTime();
		double efectTime = endingTime - startingTime;
		//efectTime este o variablila 
		//care contine timpul de efectuare a operatiei
		System.out.println("Timp de executie: Image - constructor cu parametri: " + efectTime/1000000000 + " secunde");
		//1 secunda = 10^-9 nanosecunde
	}
//polimorfismul este realizat prin supra-scrierea (override) metodelor
	//de afisare modificare si aflare a parametrilor clasei parinte
	@Override
	public void showWidth() {
		System.out.println("Lungimea imaginii este: "+ width);
		
	}

	@Override
	public void showHeight() {
		System.out.println("Inaltimea imaginii este: "+ height);
		
	}

	@Override
	public double getWidth() {
		
		return width;
	}

	@Override
	public double getHeight() {
		
		return height;
	}

	@Override
	public void setWidth(double w) {
		width=w;
		
	}

	@Override
	public void setHeight(double h) {
		height=h;
		
	}

	void CitireDinFisier(String s) throws InterruptedException
	{
		//citirea imaginii din fisier
		long startingTime = System.nanoTime();

		try
		{
			
			//se creeaza un obiect de tip File care va fi prelucrat, 
			//cu numele preluat din variabila string s
			 File input = new File(s); 
			 System.out.println(input);
			//pentru citirea din fisier se foloseste o metoda din clasa ImageIO
	         img = ImageIO.read(input); 
	         
	         //initierea dimensiunilor imaginii
	         width = img.getWidth(); 
	         height = img.getHeight();			
		}
		
		catch (IOException e) 
		{
			//tratarea exceptiilor - precum:
			//nu exista un fisier cu numele din variabila s
			System.out.println(e);
			System.exit(0);
		}	
		
		long endingTime   = System.nanoTime();
		double efectTime = endingTime - startingTime; //calculul timpului de executie a metodei
		System.out.println("Timp de executie: Image - constructor fara parametri: " + efectTime/1000000000 + " secunde");
		
	}
	
	String CitireFisier() 
	{
		//metoda folosita pentru citirea de la tastatura
		//a numelui fisierului
		
		long startingTime = System.nanoTime();
		
		String inputFilePath = null; //numele fisierului de intrare
		
		try {		
			//se pregateste citirea numelui fisierului de la tastatura
			InputStreamReader isr = new InputStreamReader(System.in); 
			//numele fisierului este preluat din buffer 
			//printr-un obiect de tip BufferedReader
		    BufferedReader br = new BufferedReader(isr); 
		    //Fisierul de tipul imagine
		    //trebuie sa aiba extensia .bmp
		    System.out.println("Introduceti numele/adresa imaginii dorite (extensie .bmp) debug 1"); 
		    //numele fisierului este preluat in buffer
		    //si convertit in tip de date String.
			inputFilePath = (br.readLine()).toString(); 
			
			while (!inputFilePath.endsWith(".bmp")) 
			{
				//se verifica extensia numelui fisierului.
				// daca nu are extensia dorita, 
				//se repeta citirea pana cand numele introdus este corect
				System.out.println("File is not of type .bmp."
						+ " Insert a file with .bmp extension."); 
				inputFilePath =  (br.readLine()).toString();
			}	
		}
							
		catch (IOException e) //exceptie: nu se poate realiza citirea in mod corect
		{
			System.out.println("Citirea nu a fost realizata intr-un mod corespunzator");
		}

		long endingTime   = System.nanoTime();
		double efectTime = endingTime - startingTime; //calculul timpului de executie a metodei
		System.out.println("Timp de executie: citire adresa fisier intrare: " + efectTime/1000000000 + " secunde");
		//1 secunda = 10^-9 nanosecunde
		
		return inputFilePath;	//metoda va returna numele fisierului 
	}
	
	String CitireFisier(String y) 
	{
		//metoda folosita pentru citirea din args
		
		long startingTime = System.nanoTime();
		//numele fisierului de intrare
		String inputFilePath = y; 
		
		

		long endingTime   = System.nanoTime();
		double efectTime = endingTime - startingTime; //calculul timpului de executie a metodei
		System.out.println("Timp de executie: citire adresa fisier intrare: " + efectTime/1000000000 + " secunde");
		//1 secunda = 10^-9 nanosecunde
		
		return inputFilePath;	//metoda va returna numele fisierului 
	}

}
