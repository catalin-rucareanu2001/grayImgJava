package Pachetul2;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ImgStocata extends Imagine {
	
	 private boolean available;
	 
	 public ImgStocata(final int w, final int h, final BufferedImage i) {
	       height=h;
	       width=w;
	       img=i;
	        this.available = false;
	    }
	    
	    public ImgStocata() {
	        this.available = false;
	    }
	    
	    public synchronized void setData(final BufferedImage pix,final int i,final int j) {
	    	 while (this.available) {
	             try {
	                 this.wait();
	             }
	             catch (InterruptedException e) {
	                 e.printStackTrace();
	             }
	         }
	    	 this.available = true;
	    	for (int y = 0; y < height; ++y) {
	    		for (int x = i; x < j; ++x) {
	    			//setarea culorii in nuante de gri, pentru o vizibilitate mai buna consultati GrayImg liniile 36-66 / 92-120
	    			 int avg=((int)(new Color(img.getRGB(x, y)).getRed())+(int)(new Color(img.getRGB(x, y)).getRed())+(int)(new Color(img.getRGB(x, y)).getRed()))/3;
					this.img.setRGB(x, y, new Color(avg,avg,avg).getRGB());
				}
			}
	    	 this.notifyAll();
	    }
	    
	    public synchronized BufferedImage getData(final BufferedImage pix, final int d, final int f) {
	        while (!this.available) {
	            try {
	                this.wait();
	            }
	            catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        this.available = false;
	        
	        //setarea valorilor pixelilor si extragerea acestora
	        for (int y = 0; y < this.height; ++y) {
	            for (int x = d; x < f; ++x) {
	                pix.setRGB(x, y, this.img.getRGB(x, y));
	            }
	        }
	        this.notifyAll();
			return pix;
	    }

		@Override
		public void showWidth() {
			
			
		}

		@Override
		public void showHeight() {
			
			
		}

		@Override
		public int getWidth() {
			
			return this.width;
		}

		@Override
		public int getHeight() {
			
			return this.height;
		}

		@Override
		public void setWidth(int w) {
			
			
		}

		@Override
		public void setHeight(int h) {
			
			
		}

		public BufferedImage getImage() {
	        return this.img;
	    }

}
