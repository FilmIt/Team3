package com.example.fffmpegtest;

import static com.googlecode.javacv.cpp.avcodec.AV_CODEC_ID_H264;
import static com.googlecode.javacv.cpp.avutil.AV_PIX_FMT_YUV420P;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import android.graphics.Bitmap;
import android.util.Log;

import com.googlecode.javacv.FFmpegFrameGrabber;
import com.googlecode.javacv.FFmpegFrameRecorder;
import com.googlecode.javacv.Frame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.FrameRecorder.Exception;
import com.googlecode.javacv.cpp.avcodec;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.*;

public class Functions {

//function to increase or decrease the speed of video playback
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
	FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/storage/extSdCard/Media/test_same.mp4",videoGrabber1.getImageWidth(),videoGrabber1.getImageHeight(),videoGrabber1.getAudioChannels());
	
	try {
		
        //recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
		recorder.setVideoCodec(AV_CODEC_ID_H264);
		recorder.setFrameRate(videoGrabber1.getFrameRate()*multiplier);
		recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
		
		recorder.setSampleFormat(videoGrabber1.getSampleFormat());
        recorder.setSampleRate(videoGrabber1.getSampleRate());
        
		recorder.start();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	//int w=videoGrabber1.getImageWidth();
	//int h=videoGrabber1.getImageHeight();
	
	Frame vFrame = null;
	
	do {
		try {
			vFrame = videoGrabber1.grabFrame();
			if(vFrame != null) {
				
				Log.d("Recorder", "Recording loop...");
				
					recorder.record(vFrame);
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
		recorder.setFrameRate(videoGrabber1.getFrameRate());
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
					recorder.record(vFrame);
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
					recorder.record(vFrame);
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
		recorder.setFrameRate(videoGrabber1.getFrameRate());
		recorder.setPixelFormat(AV_PIX_FMT_YUV420P);
		recorder.start();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	Frame vFrame = null;
	
	float ha=0;
	for(int i=0;/*i<(start-end)*videoGrabber1.getFrameRate() &&*/;i++) {
		try {
			
			vFrame = videoGrabber1.grabFrame();
			
			if(vFrame != null && i>=(start-1)*videoGrabber1.getFrameRate() ) {				
				Log.d("Recorder", "Recording loop...");
				ha++;
					recorder.record(vFrame);
			}
			if(vFrame==null || i>(end-start)*videoGrabber1.getFrameRate())
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