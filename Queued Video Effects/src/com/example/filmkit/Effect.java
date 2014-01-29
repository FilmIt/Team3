package com.example.filmkit;

import java.io.Serializable;

import android.graphics.Bitmap;

enum effectName{Flea,Tint,Grayscale,Pixelate,changeBrightness,changeContrast,Invert,changeSaturation,Rotate, Flip, UniColor, Overlay, Twirl};

public class Effect implements Serializable{

	private effectName EffectToApply;
	private effectName prevEffect;
	private float Intensity;
	private Bitmap SourceImage;
	private Bitmap OverlayImage;	//fir overlay effects like bokeh, vignette
	private double Red,Green,Blue;	//for UniColor
	
	public Effect()
	{
		EffectToApply=null;
		prevEffect=null;
		Intensity=0;
		SourceImage=null;
		OverlayImage=null;
		Red=0;
		Green=0;
		Blue=0;
	}
	
	public Effect(Effect arg)
	{
		EffectToApply=arg.EffectToApply;
		prevEffect=arg.prevEffect;
		Intensity=arg.Intensity;
		SourceImage=arg.SourceImage;
		OverlayImage=arg.OverlayImage;
		Red=arg.Red;
		Green=arg.Green;
		Blue=arg.Blue;
	}

	public effectName getPrevEffect() {
		return prevEffect;
	}

	public void setPrevEffect(effectName prevEffect) {
		this.prevEffect = prevEffect;
	}

	public double getRed() {
		return Red;
	}

	public void setRed(double red) {
		Red = red;
	}

	public double getGreen() {
		return Green;
	}

	public void setGreen(double green) {
		Green = green;
	}

	public double getBlue() {
		return Blue;
	}

	public void setBlue(double blue) {
		Blue = blue;
	}

	public effectName getEffectToApply() {
		return EffectToApply;
	}

	public void setEffectToApply(effectName effectToApply) {
		EffectToApply = effectToApply;
	}

	public float getIntensity() {
		return Intensity;
	}

	public void setIntensity(float intensity) {
		Intensity = intensity;
	}

	public Bitmap getSourceImage() {
		return SourceImage;
	}

	public void setSourceImage(Bitmap sourceImage) {
		SourceImage = sourceImage;
	}

	public Bitmap getOverlayImage() {
		return OverlayImage;
	}

	public void setOverlayImage(Bitmap overlayImage) {
		OverlayImage = overlayImage;
	}
	
	
}
