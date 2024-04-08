package com.softwelse.upload.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.softwelse.upload.dto.UploadLogRequestResponse;
import com.softwelse.upload.exceptions.EmptyFileException;
import com.softwelse.upload.exceptions.IllegalExtensionFileException;
import com.softwelse.upload.model.Log;
import com.softwelse.upload.service.FileUploadService;

@RestController
@RequestMapping("/upload")
public class FileStorageController {

	@Autowired
	private FileUploadService fileUploadService;

	@GetMapping
	public ResponseEntity<List<Log>> buscarLog(@RequestParam(value = "data", required = false) String data,
			@RequestParam(value = "ip", required = false) String ip,
			@RequestParam(value = "request", required = false) String request,
			@RequestParam(value = "status", required = false) Long status,
			@RequestParam(value = "userAgent", required = false) String userAgent) {

		Log logFiltros = new Log(data, ip, request, status, userAgent);
		return ResponseEntity.ok(fileUploadService.buscarLog(logFiltros));
	}

	@PostMapping
	public ResponseEntity<UploadLogRequestResponse> insertLog(
			@RequestParam(value = "data", required = false) String data,
			@RequestParam(value = "ip", required = false) String ip,
			@RequestParam(value = "request", required = false) String request,
			@RequestParam(value = "status", required = false) Long status,
			@RequestParam(value = "userAgent", required = false) String userAgent,
			@RequestParam(value = "file", required = false) MultipartFile multipartFile)
			throws EmptyFileException, IllegalExtensionFileException, IOException {

		if (multipartFile != null) {
			return ResponseEntity.ok(fileUploadService.leituraArquivo(multipartFile));
		} else {
			Log log = new Log(data, ip, request, status, userAgent);
			return ResponseEntity.ok(fileUploadService.insertLog(log));
		}
	}
	
}