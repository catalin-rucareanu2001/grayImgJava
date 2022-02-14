package Pachetul2;

import java.awt.image.BufferedImage;

public class Consumer extends Thread{
	 private ImgStocata storedImage;
	    private BufferedImage outputImage;
	    
	    public Consumer(final ImgStocata storedImage, final BufferedImage img) {
	        this.storedImage = storedImage;
	        this.outputImage = img;
	    }
	    
	    @Override
	    public void run() {
	        System.out.println("Running " + this.getName());
	        final int W =  this.storedImage.getWidth();
	        try {
	            for (int i = 0; i < 4; ++i) {
	                this.outputImage = this.storedImage.getData(this.outputImage, i * W / 4, (i + 1) * W / 4);
	                System.out.println("Starea: RUN  " + this.getName() + "  Consumer recieved:\t" + (i + 1) + "/4 from original image ,step: " + (i + 1));
	                Thread.sleep(1000L);
	            }
	        }
	        catch (InterruptedException ex) {}
	        System.out.println("Going dead " + this.getName());
	    }
	    
	    public BufferedImage getResult() {
	        return this.outputImage;
	    }
}
