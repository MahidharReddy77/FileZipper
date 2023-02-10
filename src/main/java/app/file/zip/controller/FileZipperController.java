package app.file.zip.controller;
import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import app.file.zip.service.FileZipperService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class FileZipperController {
	
	@Autowired
	FileZipperService fileZipperService;
	
	@GetMapping(value = { "/", "/home" })
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

	@PostMapping("/file")
	public ResponseEntity<Object> getGeneralFile(@RequestParam("file") MultipartFile file) throws IOException{
		log.info("Api Called through html");
		File zipFile = fileZipperService.convertToZipFile(file);
		return fileZipperService.downLoadZipeFile(zipFile);
	}
}
