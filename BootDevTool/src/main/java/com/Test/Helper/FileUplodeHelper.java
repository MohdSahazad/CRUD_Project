package com.Test.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUplodeHelper {
//public final String UPLOAD_DIR="E:\\JavaPractical\\BootDevTool\\src\\main\\resources\\static//image";
	
	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUplodeHelper () throws IOException
	{
		
	}

public boolean uploadFile(MultipartFile mf)
{
	boolean f=false;
	try {
		
//		//read
//		InputStream is = mf.getInputStream();
//		byte data[]=new byte[is.available()];
//		is.read(data);
//		
//		
//		//write
//		FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+mf.getOriginalFilename());
//		fos.write(data);
//		fos.close();
		
		Files.copy(mf.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+mf.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		f=true;
		
		
	} catch (Exception e) {
e.printStackTrace();

	}
	return f;
}
}
