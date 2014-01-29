package com.example.filmkit;

import java.util.ArrayList;

import android.graphics.Bitmap;

public interface EffectsInterface {
	
	//---------------------------------------Team 1---------------------------------------//
	public Bitmap ApplyEffect(Bitmap image1,Effect e2);
	public void getpixels(Bitmap image, Effect temp);
	
	//---------------------------------------Team 3---------------------------------------//
	public Bitmap ApplyEffect(Bitmap image1,ArrayList<Effect> e2);
	public void getpixels(Bitmap image);
	
	//-----------------------------------EffectsInterface-----------------------------------//
	public void Flea();
	
	public void Tint(int[] pixels, int intensity);
	
	public void GrayScale(int[] pixels);
	
	public void Pixelate(Bitmap photo,  int intensity);//range from 0 to 100
	
	public void Invert(int[] pixels) ;
	
	public void changeContrast(int[] pixels, float intensity);//range -255 to 255
	
	public void changeBrightness(int[] pixels, int intensity);//range -255 to 255
	
	public void changeSaturation(int[] pixels, int level) ; //range 0 to 100
	
	public void Rotate(int[] pixels, int direction); //greater than 0 " > 0" ->rotate right, less than or equal to 0 "<= 0" ->rotate left
	
	public void Flip(int[] pixels, int direction); //greater than 0 " > 0" ->flip horizontally, less than or equal to 0 "<= 0" ->flip vertically
	
	public void UniColor(int[] pixels, int depth, double red, double green, double blue);//need 3 seekbars

	public void Overlay(int[] pixels, int w, int h, int[][] RGB1, int[][] RGB2, float intensity);//seekbar range: 0-6
	
	public void Twirl(int[] pixels, float angle) ; // range 0-10
}
