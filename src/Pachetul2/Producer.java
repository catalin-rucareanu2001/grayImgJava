package Pachetul2;

import java.awt.image.BufferedImage;

public class Producer extends Thread{

	private ImgStocata storedImage;
    private BufferedImage inputImage;
    
    public Producer(final ImgStocata storedImage, final BufferedImage inputImage) {
        this.storedImage = storedImage;
        this.inputImage = inputImage;
       
    }
    
    @Override
    public void run() {
        System.out.println("Running " + this.getName());
        final int W = this.inputImage.getWidth();
        try {
            for (int i = 0; i < 4; ++i) {
                this.storedImage.setData(this.inputImage, i * W / 4, (i + 1) * W / 4);
                System.out.println("Starea: RUN  " + this.getName() + "  Producer has processed:\t" + (i + 1) + "/4 from original image ,step: " + (i + 1));
                Thread.sleep(1000L);
            }
        }
        catch (InterruptedException ex) {}
        System.out.println("Has died" + this.getName());
    }
    
}
