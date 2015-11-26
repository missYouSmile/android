package com.csw.radiobuttonandviewpager.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

public class HttpUtils {
	
	private static final String TAG = "HttpUtils";

	public static List<Bitmap> getBitmapList(String[] imageUrls) throws Exception{
		List<Bitmap> list = new ArrayList<Bitmap>();
		
		for (String imageUrl : imageUrls) {
			Log.i(TAG, "imageUrl"+imageUrl);
			list.add(getBitmap(imageUrl));
		}
		return list;
	}
	
	public static Bitmap getBitmap(String imageUrl) throws Exception{
		Bitmap bm = null;
		URL url = new URL(imageUrl);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		
		conn.setConnectTimeout(5000);
		
		if(conn.getResponseCode() == 200){
			Log.i(TAG, "contentLength="+conn.getContentLength());
			bm = BitmapFactory.decodeStream(conn.getInputStream());
		}else{
			Log.i(TAG, "responseCode="+conn.getResponseCode());
		}
		
		
		
		return bm;
	}
	
	public static void write(InputStream is) throws Exception{
		File file = Environment.getExternalStorageDirectory();
		FileOutputStream out = new FileOutputStream(file);
		int len = 0;
		byte[] buffer = new byte[1024];
		
		while((len = is.read(buffer)) != -1){
			out.write(buffer, 0, len);
			out.flush();
		}
		is.close();
		out.close();
	}
}
