package Pachetul2;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class GrayImg implements Processing {
	
	
	OriginalImg convertImg;
	double grayHeight, grayWidth;
	BufferedImage grayImage;
	
	public GrayImg() throws InterruptedException { //constructor fara parametri - apeleaza constructorul RealPicturemage

		convertImg = new OriginalImg();
	}
	GrayImg(String y) throws InterruptedException { //constructor fara parametri - apeleaza constructorul RealPicture

		convertImg = new OriginalImg(y);
	}
	
	public BufferedImage ProcessToGreyscale() throws InterruptedException {
	long startingTime = System.nanoTime();
		

	//se citeste numele fisierului prin intermediul metodei CitireFisier din clasa OriginalImg
		String filePath = convertImg.CitireFisier(); 
		
		//se citeste dn fisier imaginea in atributul de tip BUfferedImage al lui imgobj
		convertImg.CitireDinFisier(filePath); 
		//pixelii acesteia vo fi resetati prin metoda de conversie
		grayImage = convertImg.img; 
		//dimensiunile imaginii convertite vor fi aceleasi cu ale imaginii originale
		grayHeight = convertImg.height; 
		grayWidth = convertImg.width;
		
		for(int i = 0; i < grayHeight; i++){
	         
            for(int j = 0; j < grayWidth; j++){
            
            	//fiecare culoare a imaginii este descompusa in valorile RGB componente
               Color c = new Color(convertImg.img.getRGB(j, i)); 

               int red = (int)(c.getRed());
               int green = (int)(c.getGreen());
               int blue = (int)(c.getBlue());
               int avg = (red+green+blue)/3;
               
               //alta metoda de rezolvare
               
               //int p = image.getRGB(x,y);
               // int a = (p>>24) & 0xff;
               //int r = (p>>16) & 0xff;
               //int g = (p>>8) & 0xff;
               //int b = p & 0xff;
               // int avg = (r+g+b)/3;
               // p = (a<<24) | (avg<<16) | (avg<<8) | avg;
   	           //image.setRGB(x, y, p);		
               
               
               //iar noua culoare va fi cea obtinuta in urma conversiei fiecarei componente RGB.
               //metoda folosita pentru conversie este media aritmetica
               Color newColor = new Color(avg,  avg, avg); 
               
               grayImage.setRGB(j,i,newColor.getRGB()); //pixelul respectiv ia valoarea nou calculata
            }		
		}
		
		long endingTime   = System.nanoTime();
		double efectTime = endingTime - startingTime; //se calculeaza timpul de executie al metodei
		System.out.println("Tmp de executie: conversie alb-negru: " + efectTime/1000000000 + " secunde");
		
		return grayImage;	
	}
	
public BufferedImage ProcessToGreyscale(String y) throws InterruptedException //metoda ce va realiza conversia alb-negru
	
	{
		long startingTime = System.nanoTime();
		
		String filePath = convertImg.CitireFisier(y); 
		
		//se citeste dn fisier imaginea in atributul de tip BUfferedImage al lui imgobj
		convertImg.CitireDinFisier(filePath);
		
		//pixelii acesteia vo fi resetati prin metoda de conversie
		grayImage = convertImg.img; 
		
		//dimensiunile imaginii convertite vor fi aceleasi cu ale imaginii originale
		grayHeight = convertImg.height; 
		grayWidth = convertImg.width;
		System.out.println(grayHeight);
		for(int i = 0; i < grayHeight; i++){
	         
            for(int j = 0; j < grayWidth; j++){
            	
               //fiecare culoare a imaginii este descompusa in valorile RGB componente
               Color c = new Color(convertImg.img.getRGB(j, i)); 
               int red = (int)(c.getRed());
               int green = (int)(c.getGreen());
               int blue = (int)(c.getBlue());
               int avg = (red+green+blue)/3;
               
               //alta metoda de rezolvare
               
               //int p = image.getRGB(x,y);
               // int a = (p>>24) & 0xff;
               //int r = (p>>16) & 0xff;
               //int g = (p>>8) & 0xff;
               //int b = p & 0xff;
               // int avg = (r+g+b)/3;
               // p = (a<<24) | (avg<<16) | (avg<<8) | avg;
   	           //image.setRGB(x, y, p);		
               
               //iar noua culoare va fi cea obtinuta in urma conversiei fiecarei componente RGB.
               //metoda folosita pentru conversie este media aritmetica
               Color newColor = new Color(avg, avg, avg); 
               
               grayImage.setRGB(j,i,newColor.getRGB()); //pixelul respectiv ia valoarea nou calculata
            }		
		}
		
		long endingTime   = System.nanoTime();
		double efectTime = endingTime - startingTime; //se calculeaza timpul de executie al metodei
		System.out.println("Tmp de executie: conversie alb-negru: " + efectTime/1000000000 + " secunde");
		
		return grayImage;	
	}

}
