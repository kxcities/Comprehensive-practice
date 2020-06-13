package com.example.demo.tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import com.alibaba.simpleimage.ImageRender;
import com.alibaba.simpleimage.SimpleImageException;
import com.alibaba.simpleimage.render.ReadRender;
import com.alibaba.simpleimage.render.ScaleParameter;
import com.alibaba.simpleimage.render.ScaleRender;
import com.alibaba.simpleimage.render.WriteRender;

public class PicTool {
	private static byte[] tranferToIcoByte(byte[] ori) throws SimpleImageException, IOException {
		ByteArrayInputStream inStream = new ByteArrayInputStream(ori);
		ScaleParameter scaleParam = new ScaleParameter(50, 50);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ImageRender rr = new ReadRender(inStream);  
        ImageRender sr = new ScaleRender(rr, scaleParam);   
        WriteRender wr = new WriteRender(sr, outStream);  
        wr.render();                            //触发图像处理
        byte[] ico = outStream.toByteArray();
        IOUtils.closeQuietly(inStream);         //图片文件输入输出流必须记得关闭
        IOUtils.closeQuietly(outStream);
        wr.dispose();      
        return ico;        
	}
	public static String base64Encode(byte[] src) {
		return Base64.getEncoder().encodeToString(src);
	}
	public static byte[] base64Decode(String src) {
		return Base64.getDecoder().decode(src);
	}
	public static byte[] produceIcoPicByte(String oriSrc) throws SimpleImageException, IOException {
		byte[] oriByte = base64Decode(oriSrc);
		byte[] icoByte = tranferToIcoByte(oriByte);
		return icoByte;
	}
	public static  String  readToString(String fileName) {
		String path = "/" + fileName;
        File file = new File(path); 
        Long filelength = file.length(); 
        byte[] filecontent = new byte[filelength.intValue()]; 
        try { 
            FileInputStream in = new FileInputStream(file); 
            in.read(filecontent); 
            in.close(); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        try {
			return new String(filecontent,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return null;
	}
	public static  byte[]  readToByte(String fileName) {
		String path = "/" + fileName;
        File file = new File(path); 
        Long filelength = file.length(); 
        byte[] filecontent = new byte[filelength.intValue()]; 
        try { 
            FileInputStream in = new FileInputStream(file); 
            in.read(filecontent); 
            in.close(); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return filecontent;
	}
	public static  void savaFile(byte[] src, String filename) throws IOException {
		File f = new File(filename);
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(src);
		fos.flush();
		fos.close();
	}
	public static void writeToFile(String str, String filename) throws IOException {
		FileWriter rs = new FileWriter(filename);
		rs.write(str);
		rs.flush();
		rs.close();
	}
	public static  void main(String[] args) throws IOException, SimpleImageException {
		String str = readToString("ico_p2.txt");
		savaFile(base64Decode(str),"ico2.jpg");
		
	}
}
