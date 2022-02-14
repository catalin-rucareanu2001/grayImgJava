package Pachetul2;
import java.awt.image.BufferedImage;
// aceasta este o clasa abstracta denumita imagine 
// care contine toate definirile de variabile corespunzatoare
// dimensiunilor imaginii precum si stocarea imaginii 
// intr-un obiect BufferedImage

public abstract class Imagine {

	double width; //latimea imaginii
	double height; //inaltimea imaginii
	BufferedImage img; //obiectul imagine in sine
	
	 //metode publice de afisare
	
	public abstract void showWidth();
	public abstract void showHeight();
	
	// metode publice de accesare (getters)
	
	public abstract double getWidth();
	public abstract double getHeight();
	
	// metode publice de modificare (setters)
	
	public abstract void setWidth(double w);
	public abstract void setHeight(double h);

	Imagine(){ };//constructor fara parametri cu ajutorul caruia 
							//se vor construi obiecte de tipul claselor derivate	
	
	Imagine(String y){ };//constructor cu parametu cale catre imagine cu ajutorul caruia
							//se vor construi obiecte de tipul claselor derivate	
	
}
