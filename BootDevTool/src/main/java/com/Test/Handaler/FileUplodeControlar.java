package com.Test.Handaler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Test.Helper.FileUplodeHelper;



@RestController
public class FileUplodeControlar {
	
	@Autowired 
	private FileUplodeHelper fuh;
	
	
	@PostMapping("uplode_file")
	public ResponseEntity<String> uplodeFile(@RequestParam("file") MultipartFile file)
	{
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
		
		try
		{
//		
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			
		}
		
		if(!file.getContentType().equals("image/jpeg"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only JPG content type are allowed");
		}
		
		// file uplode code..
		
		boolean f=fuh.uploadFile(file);
		if(f)
			
		{
//			return ResponseEntity.ok("File is Successfully Uploaded..");
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
		}
		
		//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went Wrong !! Please try Agen Latter!!");
		

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went Wrong !! Please try Agen Latter!!");
		
		
	}

	
}
