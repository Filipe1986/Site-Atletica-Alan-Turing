package br.com.atleticaAlanTuring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadImagem {
	
	
    @PostMapping("/fileUpload")
    public String importParse(@RequestParam("myFile") MultipartFile file) throws IllegalStateException, IOException { 
    	
    	System.out.println(file.getOriginalFilename());

    	File arg0 = new File("teste//" + file.getOriginalFilename());

    	arg0.createNewFile(); 
        FileOutputStream fos = new FileOutputStream(arg0); 
        fos.write(file.getBytes());
        fos.close(); 
         
         return "redirect:/"; 
    }    
    
	/* @RequestMapping(value = "images/{imageName}")
	@ResponseBody
	public byte[] getImage(@PathVariable(value = "imageName") String imageName, Diretor diretor) throws IOException {

		File serverFile = new File("/resources/static/images" + imageName);

	    return Files.readAllBytes(serverFile.toPath())
	};*/


}
