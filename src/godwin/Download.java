/* NOTICE:
 * 	YOU CAN USE THE FILE ,BUT YOU CAN.T USE IT FOR ANY COMMERCIAL ACTIVITIES,
 * IF YOU DON'T WANT TO ACCEPT IT, PLEASE DON'T USE IT.
 * 																	TAHNKS!
 * DATA:	2015-12-12 23:13
 * Author��	guohui
 * FUNCTION: YOU CAN USE THE FILE TO DOWNLOAD MANY IMAGE THAT URL IN A TXT FILE,
 * 			 THOSE CODE CAN READ URL FORM THE FILE BY ITSELFS, BUT YOU SHOULDN'T
 * 			 USE IT TO ANY COMMERCIAL ACTIVITIES WITHOUT MAIL TO ME.
 */

package godwin;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Download {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//the url just is a example. 
		String ImageUrl = "http://www.bz55.com/uploads/allimg/150309/139-150309101A8.jpg";
		URL url = GetURL(ImageUrl);
		Integer FileNum;
		Random random = new Random(47);
		FileNum = random.nextInt();//get a name random, convenience to save it to disk
		ImageDownload(url, FileNum.toString()+".jpg", "G:\\ImageDownlaod");
	}
	
	public static URL GetURL(String ImageUrl) throws MalformedURLException{
//		String ImageURL = "http";
		URL url = new URL(ImageUrl);
		return url;
	}
	
	public static void ImageDownload(URL url, String SaveName, String SavePath) 
			throws Exception{
		URLConnection URLcon = url.openConnection();
		URLcon.setConnectTimeout(5*1000);
		InputStream is = URLcon.getInputStream();
		byte[] bs = new byte[1024];  
        // ��ȡ�������ݳ���  
        int len;  
        // ������ļ���  
        File SaveFile = new File(SavePath);
        if(!SaveFile.exists()){  
    	    SaveFile.mkdirs();  
        }  
        OutputStream os = new FileOutputStream(SaveFile.getPath()+"\\"+SaveName);  
        // ��ʼ��ȡ  
        while ((len = is.read(bs)) != -1) {  
            os.write(bs, 0, len);  
        }  
        // ��ϣ��ر���������  
        os.close();  
        is.close(); 
	}
}
