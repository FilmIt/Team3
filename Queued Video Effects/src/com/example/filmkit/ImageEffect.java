package com.example.filmkit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Color;

public class ImageEffect implements EffectsInterface{
	
	Pixel p1=new Pixel();
	
	@Override		//For Team1
	public Bitmap ApplyEffect(Bitmap image1,Effect temp)
	{		
		if(temp.getPrevEffect()==null)
			getpixels(image1, temp);
		else if(temp.getPrevEffect()!=null && (temp.getPrevEffect()!=temp.getEffectToApply()))
				getpixels(image1, temp);

		switch(temp.getEffectToApply())
		{
		case Flea:
			Flea();
			break;
		case Tint:
			Tint(p1.originalPixels, (int)temp.getIntensity());
			break;
		case Grayscale:
			GrayScale(p1.originalPixels);
			break;
		case Pixelate:
			Pixelate(image1, (int)temp.getIntensity());
			break;
		case Invert:
			Invert(p1.originalPixels);
			break;
		case changeBrightness:
			changeBrightness(p1.originalPixels, (int)temp.getIntensity());
			break;
		case changeContrast:
			changeContrast(p1.originalPixels, temp.getIntensity());
			break;
		case changeSaturation:
			changeSaturation(p1.originalPixels, (int)temp.getIntensity());
			break;
		case Rotate:
			Rotate(p1.originalPixels, (int)temp.getIntensity());
			break;
		case Flip:
			Flip(p1.originalPixels, (int)temp.getIntensity());
			break;
		case UniColor:
			UniColor(p1.originalPixels, (int)temp.getIntensity(),temp.getRed(),temp.getGreen(),temp.getBlue());
			break;
		case Twirl:
			Twirl(p1.originalPixels, temp.getIntensity());
			break;
		case Overlay: 
	        Overlay(p1.originalPixels, p1.width, p1.height, p1.RGB1, p1.RGB2 ,temp.getIntensity());
	        break;
		};
	Bitmap returnBitmap = Bitmap.createBitmap(p1.width, p1.height, Bitmap.Config.ARGB_8888);
	returnBitmap.setPixels(p1.pixels, 0, p1.width, 0, 0, p1.width, p1.height);
	return returnBitmap;
	}
	
	@Override		//For Team1
	public void getpixels(Bitmap image, Effect temp)
	{
		p1.width=image.getWidth();
		p1.height=image.getHeight();
		p1.pixels=new int[p1.width*p1.height];
		p1.originalPixels=new int[p1.width*p1.height];
		image.getPixels(p1.pixels, 0, p1.width, 0, 0, p1.width, p1.height);
		image.getPixels(p1.originalPixels, 0, p1.width, 0, 0, p1.width, p1.height);
		
		if(temp.getEffectToApply().equals(effectName.Overlay))
		{
			Bitmap a= Bitmap.createScaledBitmap(temp.getOverlayImage(),p1.width, p1.height, true);
	        int[] pixels2 = new int[p1.width*p1.height];
	        p1.RGB1 = new int[3][p1.width*p1.height];
	        p1.RGB2 = new int[3][p1.width*p1.height];
	        int index = 0;
	        a.getPixels(pixels2, 0, p1.width, 0, 0, p1.width, p1.height);
	        for (int x = 0; x < p1.width; x++) {
	            for (int y = 0; y < p1.height; y++) {
	            	p1.RGB1[0][index] = (p1.originalPixels[index] >> 16) & 0xFF;
	            	p1.RGB1[1][index] = (p1.originalPixels[index] >> 8) & 0xFF;
	            	p1.RGB1[2][index] = p1.originalPixels[index] & 0xFF;
	                
	            	p1.RGB2[0][index] = (pixels2[index] >> 16) & 0xFF;
	            	p1.RGB2[1][index] = (pixels2[index] >> 8) & 0xFF;
	            	p1.RGB2[2][index] = pixels2[index] & 0xFF;
	                
	                ++index;
	            }
	        }
		}
	}
	
	@Override		//For Team3
	public Bitmap ApplyEffect(Bitmap image1,ArrayList<Effect> e2)
	{
		Iterator<Effect> it;
		Effect temp=new Effect();
		it=e2.iterator();
		
		getpixels(image1);

		while(it.hasNext())
		{
			temp=it.next();
			switch(temp.getEffectToApply())
			{
			case Flea:
				Flea();
				break;
			case Tint:
				Tint(p1.pixels, (int)temp.getIntensity());
				break;
			case Grayscale:
				GrayScale(p1.pixels);
				break;
			case Pixelate:
				Pixelate(image1, (int)temp.getIntensity());
				break;
			case Invert:
				Invert(p1.pixels);
				break;
			case changeBrightness:
				changeBrightness(p1.pixels, (int)temp.getIntensity());
				break;
			case changeContrast:
				changeContrast(p1.pixels, temp.getIntensity());
				break;
			case changeSaturation:
				changeSaturation(p1.pixels, (int)temp.getIntensity());
				break;
			case Rotate:
				Rotate(p1.pixels, (int)temp.getIntensity());
				break;
			case Flip:
				Flip(p1.pixels, (int)temp.getIntensity());
				break;
			case UniColor:
				UniColor(p1.pixels, (int)temp.getIntensity(),temp.getRed(),temp.getGreen(),temp.getBlue());
				break;
			case Twirl:
				Twirl(p1.pixels, temp.getIntensity());
				break;
			case Overlay: 
				Bitmap a= Bitmap.createScaledBitmap(temp.getOverlayImage(),p1.width, p1.height, true);
		        int[] pixels2 = new int[p1.width*p1.height];
		        p1.RGB1 = new int[3][p1.width*p1.height];
		        p1.RGB2 = new int[3][p1.width*p1.height];
		        int index = 0;
		        a.getPixels(pixels2, 0, p1.width, 0, 0, p1.width, p1.height);
		        for (int x = 0; x < p1.width; x++) {
		            for (int y = 0; y < p1.height; y++) {
		            	p1.RGB1[0][index] = (p1.pixels[index] >> 16) & 0xFF;
		            	p1.RGB1[1][index] = (p1.pixels[index] >> 8) & 0xFF;
		            	p1.RGB1[2][index] = p1.pixels[index] & 0xFF;
		                
		            	p1.RGB2[0][index] = (pixels2[index] >> 16) & 0xFF;
		            	p1.RGB2[1][index] = (pixels2[index] >> 8) & 0xFF;
		            	p1.RGB2[2][index] = pixels2[index] & 0xFF;
		                
		                ++index;
		            }
		        }
		        Overlay(p1.pixels, p1.width, p1.height, p1.RGB1, p1.RGB2 ,temp.getIntensity());
		        break;
			};
		}
		
		Bitmap returnBitmap = Bitmap.createBitmap(p1.width, p1.height, Bitmap.Config.ARGB_8888);
		returnBitmap.setPixels(p1.pixels, 0, p1.width, 0, 0, p1.width, p1.height);
		return returnBitmap;
	}
		
	@Override		//For Team3
	public void getpixels(Bitmap image)
	{
		p1.width=image.getWidth();
		p1.height=image.getHeight();
		p1.pixels=new int[p1.width*p1.height];
		image.getPixels(p1.pixels, 0, p1.width, 0, 0, p1.width, p1.height);
	}
	
	public void Flea() {
	    Random random = new Random();
	    int index = 0;
	    for(int y = 0; y < p1.height; ++y) {
	        for(int x = 0; x < p1.width; ++x) {
	            // get random color
	            p1.pixels[index] |=  0xff000000 |random.nextInt(0xFF)<<16 |
	                    random.nextInt(0xFF) <<8 | random.nextInt(0xFF);
	            index++;
	        }
	    }
	}
	
	public void Tint(int[] pixels, int intensity)
	{
		int RY, BY, RYY, GYY, BYY, R, G, B, Y;
        double angle = (3.14 * (double)intensity) / 180;
        int index=0;
        int S = (int)(256 * Math.sin(angle));
        int C = (int)(256 * Math.cos(angle));
        int r,g,b;
        for (int y = 0; y < p1.height; y++)
            for (int x = 0; x < p1.width; x++) {
                r = ( pixels[index] >> 16 ) & 0xff;
                g = ( pixels[index] >> 8 ) & 0xff;
                b = pixels[index] & 0xff;
                RY = ( 70 * r - 59 * g - 11 * b ) / 100;
                //GY = (-30 * r + 41 * g - 11 * b ) / 100;
                BY = (-30 * r - 59 * g + 89 * b ) / 100;
                Y  = ( 30 * r + 59 * g + 11 * b ) / 100;
                RYY = ( S * BY + C * RY ) / 256;
                BYY = ( C * BY - S * RY ) / 256;
                GYY = (-51 * RYY - 19 * BYY ) / 100;
                R = Y + RYY;
                R = ( R < 0 ) ? 0 : (( R > 255 ) ? 255 : R );
                G = Y + GYY;
                G = ( G < 0 ) ? 0 : (( G > 255 ) ? 255 : G );
                B = Y + BYY;
                B = ( B < 0 ) ? 0 : (( B > 255 ) ? 255 : B );
                p1.pixels[index] = 0xff000000 | (R << 16) | (G << 8 ) | B;
                index++;
            }
         
        
	}
	
	public void GrayScale(int[] pixels)
	{
		// constant factors
	    final double GS_RED = 0.299;
	    final double GS_GREEN = 0.587;
	    final double GS_BLUE = 0.114;
	 
	   // pixel information
	    int R, G, B;
	 
	    // get image size
	    
        int index = 0;
	    // scan through every single pixel
	    for(int x = 0; x < p1.width; ++x) {
	        for(int y = 0; y < p1.height; ++y) {
	            // get one pixel color
                R = (pixels[index] >> 16) & 0xFF;
                G = (pixels[index] >> 8) & 0xFF;
                B = pixels[index] & 0xFF;
	            // take conversion up to one single value
	            R = G = B = (int)(GS_RED * R + GS_GREEN * G + GS_BLUE * B);
	            // set new pixel color to output bitmap
	            p1.pixels[index] = 0xff000000 | (R << 16) | (G << 8) | B;
                ++index;
	        }
	    }
	 
	    
	}
	
	@Override
	public void Pixelate(Bitmap photo, int intensity)//range from 0 to 100
	{
        int max;
        
        if(p1.height>p1.width)
        	max=p1.height;
        else
        	max=p1.width;
		intensity=100-intensity;
        
        if(intensity>max)
        	intensity=max;
        
        if(intensity<6)
        	intensity=6;   

         Bitmap temp=Bitmap.createScaledBitmap(photo, intensity, intensity, true);
         Bitmap temp2=Bitmap.createScaledBitmap(temp, p1.width, p1.height, true);
         temp2.getPixels(p1.pixels, 0, p1.width, 0, 0, p1.width, p1.height);
	}

	@Override
	public void Invert(int[] pixels) {
		 
        int index = 0;
        int R,G,B;
        for (int x = 0; x < p1.width; x++) {
            for (int y = 0; y < p1.height; y++) {
                R = (pixels[index] >> 16) & 0xFF;
                G = (pixels[index] >> 8) & 0xFF;
                B = pixels[index] & 0xFF;

                B=255-B;
                G=255-G;
                R=255-R;
                if(R > 255) { R = 255; }
                else if(R < 0) { R = 0; }

                if(G > 255) { G = 255; }
                else if(G < 0) { G = 0; }

                if(B > 255) { B = 255; }
                else if(B < 0) { B = 0; }
                
                p1.pixels[index] = 0xff000000 | (R << 16) | (G << 8) | B;
                                ++index;
                 }
        }
	}

	@Override
	public void changeContrast(int[] pixels, float intensity) {
		
        double contrast = Math.pow((100 + intensity) / 100, 2);
        int index = 0;
        int R,G,B;
        for (int x = 0; x < p1.width; x++) {
            for (int y = 0; y < p1.height; y++) {
                //A = (pixels[index] >> 24) & 0xFF;
                R = (pixels[index] >> 16) & 0xFF;
                G = (pixels[index] >> 8) & 0xFF;
                B = pixels[index] & 0xFF;

                //A+=intensity;
                B = (int)(((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                G = (int)(((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                R = (int)(((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if(R > 255) { R = 255; }
                else if(R < 0) { R = 0; }

                if(G > 255) { G = 255; }
                else if(G < 0) { G = 0; }

                if(B > 255) { B = 255; }
                else if(B < 0) { B = 0; }
                
                p1.pixels[index] = 0xff000000 | (R << 16) | (G << 8) | B;
                                ++index;
                 }
        }
	}

	@Override
	public void changeBrightness(int[] pixels, int intensity) {
        int index = 0;
        int R,G,B;
        for (int x = 0; x < p1.width; x++) {
            for (int y = 0; y < p1.height; y++) {
                //A = (pixels[index] >> 24) & 0xFF;
                R = (pixels[index] >> 16) & 0xFF;
                G = (pixels[index] >> 8) & 0xFF;
                B = pixels[index] & 0xFF;

                //A+=intensity;
                B+=intensity;
                G+=intensity;
                R+=intensity;
                if(R > 255) { R = 255; }
                else if(R < 0) { R = 0; }

                if(G > 255) { G = 255; }
                else if(G < 0) { G = 0; }

                if(B > 255) { B = 255; }
                else if(B < 0) { B = 0; }
                
                p1.pixels[index] = 0xff000000 | (R << 16) | (G << 8) | B;
                                ++index;
                 }
        }
	}
	
	@Override
	public void changeSaturation(int[] pixels, int level) {
       
        float[] HSV = new float[3];
        int index = 0;
        // iteration through pixels
        for(int y = 0; y < p1.height; ++y) {
            for(int x = 0; x < p1.width; ++x) {
                // get current index in 2D-matrix
                index = y * p1.width + x;
                // convert to HSV
                Color.colorToHSV(pixels[index], HSV);
                // increase Saturation level
                HSV[1] *= level;
                HSV[1] = (float) Math.max(0.0, Math.min(HSV[1], 1.0));
                // take color back
                p1.pixels[index] |= Color.HSVToColor(HSV);
            }
        }
    }
	
	@Override
	public void UniColor(int[] pixels, int depth, double red, double green, double blue) {
	    
	    // constant grayscale
	    final double GS_RED = 0.3;
	    final double GS_GREEN = 0.59;
	    final double GS_BLUE = 0.11;
	    // color information
	    int R, G, B;
	    int index=0;
	    // scan through all pixels
	    for(int x = 0; x < p1.width; ++x) {
	        for(int y = 0; y < p1.height; ++y) {
	            // get color on each channel
	            R = (pixels[index] >> 16) & 0xFF;
                G = (pixels[index] >> 8) & 0xFF;
                B = pixels[index] & 0xFF;
	            // apply grayscale sample
	            B = G = R = (int)(GS_RED * R  + GS_GREEN * G + GS_BLUE * B);
	 
	            // apply intensity level for sepid-toning on each channel
	            R += (depth * red);
	            if(R > 255) { R = 255; }
	 
	            G += (depth * green);
	            if(G > 255) { G = 255; }
	 
	            B += (depth * blue);
	            if(B > 255) { B = 255; }
	 
	            // set new pixel color to output image
	            p1.pixels[index] = 0xff000000 | (R << 16) | (G << 8) | B;
                ++index;
	        }
	    }
	}
	
	@Override
	public void Rotate(int[] pixels, int direction)
	{  
		p1.pixels=new int[p1.height*p1.width];
		int temp=p1.height;
		p1.height=p1.width;
		p1.width=temp;
        for (int i = 0; i < p1.width; i++) { 
            for (int j = 0; j < p1.height; j++) {  
            	if(direction >0 )
            		p1.pixels[i+(p1.width*j)] = pixels[(p1.height-j-1)+(p1.height*(p1.width-i-1))];
            	else if(direction <= 0 )
            		p1.pixels[i+(p1.width*j)] = pixels[j+(p1.height*i)];
            }
        }
	}
	
	@Override
	public void Flip(int[] pixels, int direction)
	{
        for (int i = 0; i < p1.width; i++) { 
            for (int j = 0; j < p1.height; j++) {  
            	if(direction > 0 )
            		p1.pixels[(p1.width-i-1)+(p1.width*j)] = pixels[i+(p1.width*j)];
            	else
            		p1.pixels[i+(p1.width*(p1.height-j-1))] = pixels[i+(p1.width*j)];
            }
        }
	}

	@Override
	public void Overlay(int[] pixels, int w, int h, int[][] RGB1, int[][] RGB2, float intensity)//seekbar range: 0-6
	{		
		intensity+=3;
		double v2=intensity/10;
		double v1=1-v2;
        int index = 0;
        int R,G,B;
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                
		        R=(int)((RGB1[0][index]*v1)+(RGB2[0][index]*v2));
		        G=(int)((RGB1[1][index]*v1)+(RGB2[1][index]*v2));
		        B=(int)((RGB1[2][index]*v1)+(RGB2[2][index]*v2));
		        
		        if(R > 255) { R = 255; }
                else if(R < 0) { R = 0; }

                if(G > 255) { G = 255; }
                else if(G < 0) { G = 0; }

                if(B > 255) { B = 255; }
                else if(B < 0) { B = 0; }
                p1.pixels[index] = 0xff000000 | (R << 16) | (G << 8) | B;
                ++index;
           }
        }
	}	
	
	@Override
	public void Twirl(int[] pixels, float angle) {

		int u, v;
		float radius;
        float hw=p1.width/2;
        float hh=p1.height/2;
        double cX = (float)p1.width * 0.5;
		double cY =  (float)p1.height * 0.5;
		if(hw<hh)
			radius=hw;
		else
			radius=hh;
		int R,G,B;
		float radius2 = radius*radius;
		int index=0;
		for (int x = 0; x < p1.width; x++) {
            for (int y = 0; y < p1.height; y++) {
            	float dx = (float) (x-cX);
        		float dy = (float) (y-cY);
        		float distance = dx*dx + dy*dy;
        		if (distance > radius2) {
        			u = x;
        			v = y;
        		} else {
        			distance = (float)Math.sqrt(distance);
        			float a = (float) ((float)Math.atan2(dy, dx) + angle * (radius-distance) / radius);
        			u = (int) (cX + distance*(float)Math.cos(a));
        			v = (int) (cY + distance*(float)Math.sin(a));
        		}
        		index=x+(p1.width*y);
        		R = (pixels[index] >> 16) & 0xFF;
                G = (pixels[index] >> 8) & 0xFF;
                B = pixels[index] & 0xFF;
                index=u+(p1.width*v);
                p1.pixels[index] = 0xff000000 | (R << 16) | (G << 8) | B;
             }
        }
	}
	
	//end of class
}
