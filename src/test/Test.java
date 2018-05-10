package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url;
		try {
			url = new URL("http://pcs.baidu.com/rest/2.0/pcs/file?method=download&app_id=250528&path=%2FZBW%2F%E5%8A%A8%E6%BC%AB%2F%E7%89%A9%E8%AF%AD%2F%E3%80%8C%E5%88%86%E4%BA%AB%E3%80%8DBDRip%201080p.Part%201%2F01%20%5BVCB-S%5DBakemonogatari%5B1080p%5D%5B%E5%8C%96%E7%89%A9%E8%AF%AD%5D%2F12.mkv");
			HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setConnectTimeout(10000);
			int code = httpConnection.getResponseCode();
			if(code == 200) {
				int contentLength = httpConnection.getContentLength();
				int num = 15;
				int blockSize = contentLength / num;
				for(int i = 0,startIn = 0; i < num; i++, startIn += blockSize) {
					URL urlTemp = new URL("http://pcs.baidu.com/rest/2.0/pcs/file?method=download&app_id=250528&path=%2FZBW%2F%E5%8A%A8%E6%BC%AB%2F%E7%89%A9%E8%AF%AD%2F%E3%80%8C%E5%88%86%E4%BA%AB%E3%80%8DBDRip%201080p.Part%201%2F01%20%5BVCB-S%5DBakemonogatari%5B1080p%5D%5B%E5%8C%96%E7%89%A9%E8%AF%AD%5D%2F12.mkv");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(10000);
					connection.setRequestProperty("Range", "bytes="+ startIn + "-" + (startIn + blockSize -1));
					System.out.println("request" + i + "\t" + connection.getResponseCode());
				}
			}else {
				System.out.println(code);
			}
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
