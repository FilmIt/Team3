package com.example.filmkit;

import android.graphics.Bitmap;

import com.googlecode.javacv.FFmpegFrameRecorder;
import com.googlecode.javacv.FFmpegFrameGrabber;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.*;

import static com.googlecode.javacv.cpp.avcodec.*;
//import static com.googlecode.javacv.cpp.avformat.*;
import static com.googlecode.javacv.cpp.avutil.*;
import static com.googlecode.javacv.cpp.opencv_core.*;
//import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
//import static com.googlecode.javacv.cpp.swresample.*;
//import static com.googlecode.javacv.cpp.swscale.*;

public class Video {

	public static void flea(String srcPath,String desPath) {
		//FrameGrabber videoGrabber = new FFmpegFrameGrabber("/storage/sdcard0/Download/H264_test2_Talkinghead_mp4_480x320.mp4");
		FrameGrabber videoGrabber = new FFmpegFrameGrabber(srcPath);
		try {
			videoGrabber.setFormat("mp4");//mp4 for example
			videoGrabber.start();    
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
//			Log.e("javacv", "Failed to start grabber" + e);     
//			return -1;  
		}
		
		int w = videoGrabber.getImageWidth();
		int h = videoGrabber.getImageHeight();
		//FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/sdcard0/Download/new_video.mp4",w,h);
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(desPath,w,h);
		try {
			recorder.setVideoCodec(AV_CODEC_ID_H264);
			recorder.setFrameRate(videoGrabber.getFrameRate());
			recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
			recorder.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		IplImage vFrame = null;
		do {
			try {
				vFrame = videoGrabber.grab();
				if(vFrame != null) {
					try {
						IplImage temp1 = IplImage.create(w,h,IPL_DEPTH_8U,4);
						cvCvtColor(vFrame,temp1,CV_BGR2RGBA);
						
						Bitmap temp2 = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
						temp2.copyPixelsFromBuffer(temp1.getByteBuffer());
						
						temp2 = new ImageEffects().Flea(temp2);
						
						temp2.copyPixelsToBuffer(temp1.getByteBuffer());
						
						recorder.record(temp1);
						
						temp1.release();
						temp2.recycle();
					}
					catch(com.googlecode.javacv.FrameRecorder.Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//				Log.e("javacv", "video grabFrame failed: "+ e);
			}
		} while(vFrame != null);
		
		try {
			recorder.stop();
		}
		catch(com.googlecode.javacv.FrameRecorder.Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			videoGrabber.stop();
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//			Log.e("javacv", "failed to stop video grabber", e);
//			return -1;
		}
	}

	public static void tint(String srcPath,String desPath,int intensity) {
		//FrameGrabber videoGrabber = new FFmpegFrameGrabber("/storage/sdcard0/Download/H264_test2_Talkinghead_mp4_480x320.mp4");
		FrameGrabber videoGrabber = new FFmpegFrameGrabber(srcPath);
		try {
			videoGrabber.setFormat("mp4");//mp4 for example
			videoGrabber.start();    
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
//			Log.e("javacv", "Failed to start grabber" + e);     
//			return -1;  
		}
		
		int w = videoGrabber.getImageWidth();
		int h = videoGrabber.getImageHeight();
		//FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/sdcard0/Download/new_video.mp4",w,h);
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(desPath,w,h);
		try {
			recorder.setVideoCodec(AV_CODEC_ID_H264);
			recorder.setFrameRate(videoGrabber.getFrameRate());
			recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
			recorder.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		IplImage vFrame = null;
		do {
			try {
				vFrame = videoGrabber.grab();
				if(vFrame != null) {
					try {
						IplImage temp1 = IplImage.create(w,h,IPL_DEPTH_8U,4);
						cvCvtColor(vFrame,temp1,CV_BGR2RGBA);
						
						Bitmap temp2 = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
						temp2.copyPixelsFromBuffer(temp1.getByteBuffer());
						
						temp2 = new ImageEffects().Tint(temp2,intensity);
						
						temp2.copyPixelsToBuffer(temp1.getByteBuffer());
						
						recorder.record(temp1);
						
						temp1.release();
						temp2.recycle();
					}
					catch(com.googlecode.javacv.FrameRecorder.Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//				Log.e("javacv", "video grabFrame failed: "+ e);
			}
		} while(vFrame != null);
		
		try {
			recorder.stop();
		}
		catch(com.googlecode.javacv.FrameRecorder.Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			videoGrabber.stop();
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//			Log.e("javacv", "failed to stop video grabber", e);
//			return -1;
		}
	}
	
	public static void grayScale(String srcPath,String desPath) {
		//FrameGrabber videoGrabber = new FFmpegFrameGrabber("/storage/sdcard0/Download/H264_test2_Talkinghead_mp4_480x320.mp4");
		FrameGrabber videoGrabber = new FFmpegFrameGrabber(srcPath);
		try {
			videoGrabber.setFormat("mp4");//mp4 for example
			videoGrabber.start();    
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
//			Log.e("javacv", "Failed to start grabber" + e);     
//			return -1;  
		}
		
		int w = videoGrabber.getImageWidth();
		int h = videoGrabber.getImageHeight();
		//FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/sdcard0/Download/new_video.mp4",w,h);
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(desPath,w,h);
		try {
			recorder.setVideoCodec(AV_CODEC_ID_H264);
			recorder.setFrameRate(videoGrabber.getFrameRate());
			recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
			recorder.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		IplImage vFrame = null;
		do {
			try {
				vFrame = videoGrabber.grab();
				if(vFrame != null) {
					try {
						IplImage temp1 = IplImage.create(w,h,IPL_DEPTH_8U,4);
						cvCvtColor(vFrame,temp1,CV_BGR2RGBA);
						
						Bitmap temp2 = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
						temp2.copyPixelsFromBuffer(temp1.getByteBuffer());
						
						temp2 = new ImageEffects().GrayScale(temp2);
						
						temp2.copyPixelsToBuffer(temp1.getByteBuffer());
						
						recorder.record(temp1);
						
						temp1.release();
						temp2.recycle();
					}
					catch(com.googlecode.javacv.FrameRecorder.Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//				Log.e("javacv", "video grabFrame failed: "+ e);
			}
		} while(vFrame != null);
		
		try {
			recorder.stop();
		}
		catch(com.googlecode.javacv.FrameRecorder.Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			videoGrabber.stop();
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//			Log.e("javacv", "failed to stop video grabber", e);
//			return -1;
		}
	}
	
	public static void pixelate(String srcPath,String desPath,int intensity) {
		//FrameGrabber videoGrabber = new FFmpegFrameGrabber("/storage/sdcard0/Download/H264_test2_Talkinghead_mp4_480x320.mp4");
		FrameGrabber videoGrabber = new FFmpegFrameGrabber(srcPath);
		try {
			videoGrabber.setFormat("mp4");//mp4 for example
			videoGrabber.start();    
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
//			Log.e("javacv", "Failed to start grabber" + e);     
//			return -1;  
		}
		
		int w = videoGrabber.getImageWidth();
		int h = videoGrabber.getImageHeight();
		//FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/sdcard0/Download/new_video.mp4",w,h);
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(desPath,w,h);
		try {
			recorder.setVideoCodec(AV_CODEC_ID_H264);
			recorder.setFrameRate(videoGrabber.getFrameRate());
			recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
			recorder.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		IplImage vFrame = null;
		do {
			try {
				vFrame = videoGrabber.grab();
				if(vFrame != null) {
					try {
						IplImage temp1 = IplImage.create(w,h,IPL_DEPTH_8U,4);
						cvCvtColor(vFrame,temp1,CV_BGR2RGBA);
						
						Bitmap temp2 = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
						temp2.copyPixelsFromBuffer(temp1.getByteBuffer());
						
						temp2 = new ImageEffects().Pixelate(temp2,intensity);
						
						temp2.copyPixelsToBuffer(temp1.getByteBuffer());
						
						recorder.record(temp1);
						
						temp1.release();
						temp2.recycle();
					}
					catch(com.googlecode.javacv.FrameRecorder.Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//				Log.e("javacv", "video grabFrame failed: "+ e);
			}
		} while(vFrame != null);
		
		try {
			recorder.stop();
		}
		catch(com.googlecode.javacv.FrameRecorder.Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			videoGrabber.stop();
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//			Log.e("javacv", "failed to stop video grabber", e);
//			return -1;
		}
	}
	
	public static void invert(String srcPath,String desPath) {
		//FrameGrabber videoGrabber = new FFmpegFrameGrabber("/storage/sdcard0/Download/H264_test2_Talkinghead_mp4_480x320.mp4");
		FrameGrabber videoGrabber = new FFmpegFrameGrabber(srcPath);
		try {
			videoGrabber.setFormat("mp4");//mp4 for example
			videoGrabber.start();    
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
//			Log.e("javacv", "Failed to start grabber" + e);     
//			return -1;  
		}
		
		int w = videoGrabber.getImageWidth();
		int h = videoGrabber.getImageHeight();
		//FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/sdcard0/Download/new_video.mp4",w,h);
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(desPath,w,h);
		try {
			recorder.setVideoCodec(AV_CODEC_ID_H264);
			recorder.setFrameRate(videoGrabber.getFrameRate());
			recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
			recorder.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		IplImage vFrame = null;
		do {
			try {
				vFrame = videoGrabber.grab();
				if(vFrame != null) {
					try {
						IplImage temp1 = IplImage.create(w,h,IPL_DEPTH_8U,4);
						cvCvtColor(vFrame,temp1,CV_BGR2RGBA);
						
						Bitmap temp2 = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
						temp2.copyPixelsFromBuffer(temp1.getByteBuffer());
						
						temp2 = new ImageEffects().Invert(temp2);
						
						temp2.copyPixelsToBuffer(temp1.getByteBuffer());
						
						recorder.record(temp1);
						
						temp1.release();
						temp2.recycle();
					}
					catch(com.googlecode.javacv.FrameRecorder.Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//				Log.e("javacv", "video grabFrame failed: "+ e);
			}
		} while(vFrame != null);
		
		try {
			recorder.stop();
		}
		catch(com.googlecode.javacv.FrameRecorder.Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			videoGrabber.stop();
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//			Log.e("javacv", "failed to stop video grabber", e);
//			return -1;
		}
	}
	
	public static void changeContrast(String srcPath,String desPath,float intensityF) {
		//FrameGrabber videoGrabber = new FFmpegFrameGrabber("/storage/sdcard0/Download/H264_test2_Talkinghead_mp4_480x320.mp4");
		FrameGrabber videoGrabber = new FFmpegFrameGrabber(srcPath);
		try {
			videoGrabber.setFormat("mp4");//mp4 for example
			videoGrabber.start();    
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
//			Log.e("javacv", "Failed to start grabber" + e);     
//			return -1;  
		}
		
		int w = videoGrabber.getImageWidth();
		int h = videoGrabber.getImageHeight();
		//FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/sdcard0/Download/new_video.mp4",w,h);
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(desPath,w,h);
		try {
			recorder.setVideoCodec(AV_CODEC_ID_H264);
			recorder.setFrameRate(videoGrabber.getFrameRate());
			recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
			recorder.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		IplImage vFrame = null;
		do {
			try {
				vFrame = videoGrabber.grab();
				if(vFrame != null) {
					try {
						IplImage temp1 = IplImage.create(w,h,IPL_DEPTH_8U,4);
						cvCvtColor(vFrame,temp1,CV_BGR2RGBA);
						
						Bitmap temp2 = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
						temp2.copyPixelsFromBuffer(temp1.getByteBuffer());
						
						temp2 = new ImageEffects().changeContrast(temp2,intensityF);
						
						temp2.copyPixelsToBuffer(temp1.getByteBuffer());
						
						recorder.record(temp1);
						
						temp1.release();
						temp2.recycle();
					}
					catch(com.googlecode.javacv.FrameRecorder.Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//				Log.e("javacv", "video grabFrame failed: "+ e);
			}
		} while(vFrame != null);
		
		try {
			recorder.stop();
		}
		catch(com.googlecode.javacv.FrameRecorder.Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			videoGrabber.stop();
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//			Log.e("javacv", "failed to stop video grabber", e);
//			return -1;
		}
	}
	
	public static void changeBrightness(String srcPath,String desPath,int intensity) {
		//FrameGrabber videoGrabber = new FFmpegFrameGrabber("/storage/sdcard0/Download/H264_test2_Talkinghead_mp4_480x320.mp4");
		FrameGrabber videoGrabber = new FFmpegFrameGrabber(srcPath);
		try {
			videoGrabber.setFormat("mp4");//mp4 for example
			videoGrabber.start();    
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
//			Log.e("javacv", "Failed to start grabber" + e);     
//			return -1;  
		}
		
		int w = videoGrabber.getImageWidth();
		int h = videoGrabber.getImageHeight();
		//FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/sdcard0/Download/new_video.mp4",w,h);
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(desPath,w,h);
		try {
			recorder.setVideoCodec(AV_CODEC_ID_H264);
			recorder.setFrameRate(videoGrabber.getFrameRate());
			recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
			recorder.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		IplImage vFrame = null;
		do {
			try {
				vFrame = videoGrabber.grab();
				if(vFrame != null) {
					try {
						IplImage temp1 = IplImage.create(w,h,IPL_DEPTH_8U,4);
						cvCvtColor(vFrame,temp1,CV_BGR2RGBA);
						
						Bitmap temp2 = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
						temp2.copyPixelsFromBuffer(temp1.getByteBuffer());
						
						temp2 = new ImageEffects().changeBrightness(temp2,intensity);
						
						temp2.copyPixelsToBuffer(temp1.getByteBuffer());
						
						recorder.record(temp1);
						
						temp1.release();
						temp2.recycle();
					}
					catch(com.googlecode.javacv.FrameRecorder.Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//				Log.e("javacv", "video grabFrame failed: "+ e);
			}
		} while(vFrame != null);
		
		try {
			recorder.stop();
		}
		catch(com.googlecode.javacv.FrameRecorder.Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			videoGrabber.stop();
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//			Log.e("javacv", "failed to stop video grabber", e);
//			return -1;
		}
	}
	
	public static void changeOpacity(String srcPath,String desPath,int intensity) {
		//FrameGrabber videoGrabber = new FFmpegFrameGrabber("/storage/sdcard0/Download/H264_test2_Talkinghead_mp4_480x320.mp4");
		FrameGrabber videoGrabber = new FFmpegFrameGrabber(srcPath);
		try {
			videoGrabber.setFormat("mp4");//mp4 for example
			videoGrabber.start();    
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
//			Log.e("javacv", "Failed to start grabber" + e);     
//			return -1;  
		}
		
		int w = videoGrabber.getImageWidth();
		int h = videoGrabber.getImageHeight();
		//FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/sdcard0/Download/new_video.mp4",w,h);
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(desPath,w,h);
		try {
			recorder.setVideoCodec(AV_CODEC_ID_H264);
			recorder.setFrameRate(videoGrabber.getFrameRate());
			recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
			recorder.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		IplImage vFrame = null;
		do {
			try {
				vFrame = videoGrabber.grab();
				if(vFrame != null) {
					try {
						IplImage temp1 = IplImage.create(w,h,IPL_DEPTH_8U,4);
						cvCvtColor(vFrame,temp1,CV_BGR2RGBA);
						
						Bitmap temp2 = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
						temp2.copyPixelsFromBuffer(temp1.getByteBuffer());
						
						temp2 = new ImageEffects().changeOpacity(temp2,intensity);
						
						temp2.copyPixelsToBuffer(temp1.getByteBuffer());
						
						recorder.record(temp1);
						
						temp1.release();
						temp2.recycle();
					}
					catch(com.googlecode.javacv.FrameRecorder.Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//				Log.e("javacv", "video grabFrame failed: "+ e);
			}
		} while(vFrame != null);
		
		try {
			recorder.stop();
		}
		catch(com.googlecode.javacv.FrameRecorder.Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			videoGrabber.stop();
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
//			Log.e("javacv", "failed to stop video grabber", e);
//			return -1;
		}
	}
	
}
