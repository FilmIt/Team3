package com.example.fffmpegtest;

import android.os.Environment;
import android.util.Log;

import com.googlecode.javacv.FFmpegFrameGrabber;
import com.googlecode.javacv.FFmpegFrameRecorder;
import com.googlecode.javacv.Frame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.FrameRecorder.Exception;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.avcodec.AV_CODEC_ID_H264;
import static com.googlecode.javacv.cpp.avutil.*;

import static com.googlecode.javacv.cpp.opencv_core.cvReleaseImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvShowImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

public class Functions {

	public static void trim(String videoFilePath, int startTime, int endTime){
		FFmpegFrameGrabber videoGrabber1 = new FFmpegFrameGrabber(videoFilePath);
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/extSdCard/Media/new.mp4",200,150);
		try 
		{
		    videoGrabber1.setFormat("mp4");//mp4 for example
		    videoGrabber1.start();    
		    
		 //   recorder.setVideoCodec(AV_CODEC_ID_H264);
		 //
		   //    recorder.setFrameRate(videoGrabber1.getFrameRate());
		     //  recorder.setPixelFormat(videoGrabber1.getPixelFormat());
		       //recorder.start();
	
		       
		
		Frame vFrame = null;
		
		//bypassing initial frames
		for(int i=0;i<startTime*videoGrabber1.getFrameRate();i++){		    		
    		vFrame = videoGrabber1.grabFrame();			    	
    	}
		
		//for(int i=0;i<(endTime-startTime)*videoGrabber1.getFrameRate();i++)
		for(int i=0;i<10;i++)
		{
		        vFrame = videoGrabber1.grabFrame();	        
		        
		        
		        if(vFrame != null){		        	
		//		          recorder.record(vFrame.image);
		        	cvSaveImage("/storage/extSdCard/Media/frame "+i,vFrame.image);
		        }
		            
		
		}//endfor
		
		//recorder.stop();		
		videoGrabber1.stop();
		
		}catch (com.googlecode.javacv.FrameGrabber.Exception e) 
		{
		    //Log.e("javacv", "failed to stop video grabber", e);
		    //return -1;
		}
		
		
		
		//IplImage image = cvLoadImage("/sdcard/folder/img1.jpg");
		
	}
	
	public void merge(){
		 try {
	            FrameGrabber grabber1 = new FFmpegFrameGrabber("/storage/extSdCard/Media/test.mp4"); 
	            FrameGrabber grabber2 = new FFmpegFrameGrabber("/sdcard/Video/tempAudio.mp3"); 
	grabber1.start();
	
	        grabber2.start(); 
	        //Log.e("WIDTH",grabber2.getSampleRate()+"");
	        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/extSdCard/Media/new.mp4", 
	                grabber1.getImageWidth(), grabber1.getImageHeight(), 
	                2); 
	        recorder.setFormat("mp4");
	        recorder.setFrameRate(grabber1.getFrameRate()); 
	        //recorder.setSampleFormat(grabber2.getSampleFormat()); 
	        recorder.setSampleRate(grabber2.getSampleRate()); 
	        //recorder.setAudioCodec(avcodec.AV_CODEC_ID_AC3);
	//recorder.setVideoCodec(avcodec.AV_CODEC_ID_MPEG4);
	        recorder.start(); 
	        Frame frame1, frame2 = null; 
	        while ((frame1 = grabber1.grabFrame()) != null || 
	              (frame2 = grabber2.grabFrame()) != null) { 
	            recorder.record(frame1); 
	            //recorder.record(frame2); 
	        } 
	        recorder.stop(); 
	        grabber1.stop(); 
	        grabber2.stop(); 
	       // Log.e(LOG_TAG, "recorder initialize success");
	} catch (com.googlecode.javacv.FrameGrabber.Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch(Exception e1){
	e1.printStackTrace();
	}
	}
	
	
public void fun_grabber(){
		FrameGrabber videoGrabber1 = new FFmpegFrameGrabber("/storage/extSdCard/Media/test.mp4");
		try {
			videoGrabber1.setFormat("mp4");//mp4 for example
			videoGrabber1.start();    
		} 
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
			//Log.e("javacv", "Failed to start grabber" + e);     
			//return -1;  
		}
		FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/extSdCard/Media/test_duplicate.mp4",200,150);
		try {
			recorder.setVideoCodec(AV_CODEC_ID_H264);
			recorder.setFrameRate(3);
			recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
			recorder.start();
		//	for(int i=1;i<=9;i++) {
	//			recorder.record(cvLoadImage("/storage/sdcard0/setups/pics/frame (" + i + ").jpg"));
		//	}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Frame vFrame = null;
		int i=1;
		do {
			try {
				vFrame = videoGrabber1.grabFrame();
				if(vFrame != null) {
					//if(i<10){
					Log.d("Recorder", "Recording loop...");
						recorder.record(vFrame.image);
		//			cvSaveImage("/storage/extSdCard/Media/" + i++ + ".jpg",vFrame.image);
					//}
				}
			}
			catch(com.googlecode.javacv.FrameGrabber.Exception e) {
				//Log.e("javacv", "video grabFrame failed: "+ e);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while(vFrame != null);
		try {
			recorder.stop();
			videoGrabber1.stop();
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
		//Log.e("javacv", "failed to stop video grabber", e);
		//return -1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//IplImage[] faceImgArr = new IplImage[30];
		//IplImage img = cvLoadImage("/sdcard/setups/pics/img1.jpg");
		
		
}
	
void speed(String filepath, float multiplier){
	FrameGrabber videoGrabber1 = new FFmpegFrameGrabber(filepath);
	try {
		videoGrabber1.setFormat("mp4");//mp4 for example
		videoGrabber1.start();    
	} 
	catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
		Log.e("javacv", "Failed to start grabber" + e);     
		//return -1;  
	}
	FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/extSdCard/Media/test_slow.mp4",200,150);
	try {
		recorder.setVideoCodec(AV_CODEC_ID_H264);
		recorder.setFrameRate(3*multiplier);
		recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
		recorder.start();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	Frame vFrame = null;
	int i=1;
	do {
		try {
			vFrame = videoGrabber1.grabFrame();
			if(vFrame != null) {
				//if(i<10){
				Log.d("Recorder", "Recording loop...");
					recorder.record(vFrame.image);
	//			cvSaveImage("/storage/extSdCard/Media/" + i++ + ".jpg",vFrame.image);
				//}
			}
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
			//Log.e("javacv", "video grabFrame failed: "+ e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} while(vFrame != null);
	try {
		recorder.stop();
		videoGrabber1.stop();
	}
	catch(com.googlecode.javacv.FrameGrabber.Exception e) {
	//Log.e("javacv", "failed to stop video grabber", e);
	//return -1;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

void merge_vid(String filepath1, String filepath2){
	FrameGrabber videoGrabber1 = new FFmpegFrameGrabber(filepath1);
	FrameGrabber videoGrabber2 = new FFmpegFrameGrabber(filepath2);
	try {
		videoGrabber1.setFormat("mp4");
		videoGrabber1.start();
		
		videoGrabber2.setFormat("mp4");
		videoGrabber2.start();
	} 
	catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
		Log.e("javacv", "Failed to start grabber" + e);   
	}
	FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/extSdCard/Media/test_merge.mp4",200,150);
	try {
		recorder.setVideoCodec(AV_CODEC_ID_H264);
		recorder.setFrameRate(3);
		recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
		recorder.start();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	Frame vFrame = null;
	
	do {
		try {
			vFrame = videoGrabber1.grabFrame();
			if(vFrame != null) {				
				Log.d("Recorder", "Recording loop...");
					recorder.record(vFrame.image);
			}
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
			//Log.e("javacv", "video grabFrame failed: "+ e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} while(vFrame != null);
	
	do {
		try {
			vFrame = videoGrabber2.grabFrame();
			if(vFrame != null) {				
				Log.d("Recorder", "Recording loop2...");
					recorder.record(vFrame.image);
			}
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
			Log.e("javacv", "video grabFrame failed: "+ e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} while(vFrame != null);
	try {
		recorder.stop();
		videoGrabber1.stop();
		videoGrabber2.stop();
	}
	catch(com.googlecode.javacv.FrameGrabber.Exception e) {
		Log.e("javacv", "failed to stop video grabber", e);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}

float trim_vid(String filepath, int start, int end){
	
	FrameGrabber videoGrabber1 = new FFmpegFrameGrabber(filepath);	
	
	try {
		videoGrabber1.setFormat("mp4");
		videoGrabber1.start();
		
		
	} 	
	catch(com.googlecode.javacv.FrameGrabber.Exception e) {           
		Log.e("javacv", "Failed to start grabber" + e);   
	}
	FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/extSdCard/Media/test_trim.mp4",200,150);
	try {
		recorder.setVideoCodec(AV_CODEC_ID_H264);
		recorder.setFrameRate(3);
		recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
		recorder.start();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	Frame vFrame = null;
	/*for(int i=0;i<(start-1)*videoGrabber1.getFrameRate();i++)
		try {
			vFrame = videoGrabber1.grabFrame();
		} catch (com.googlecode.javacv.FrameGrabber.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	float ha=0;
	for(int i=0;/*i<(start-end)*videoGrabber1.getFrameRate() &&*/;i++) {
		try {
			
			vFrame = videoGrabber1.grabFrame();
			
			if(vFrame != null && i>=(start-1)*videoGrabber1.getFrameRate() && i<(end-start)*videoGrabber1.getFrameRate()) {				
				Log.d("Recorder", "Recording loop...");
				ha++;
					recorder.record(vFrame.image);
			}
			if(vFrame==null)
				break;
		}
		catch(com.googlecode.javacv.FrameGrabber.Exception e) {
			Log.e("javacv", "video grabFrame failed: "+ e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//float ha= (float) ((end-start)*videoGrabber1.getFrameRate());
	try {
		recorder.stop();
		videoGrabber1.stop();		
	}
	catch(com.googlecode.javacv.FrameGrabber.Exception e) {
		Log.e("javacv", "failed to stop video grabber", e);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return ha;
}

}
