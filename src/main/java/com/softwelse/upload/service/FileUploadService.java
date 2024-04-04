package com.softwelse.upload.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.softwelse.upload.config.PropertiesConfig;
import com.softwelse.upload.dto.UploadLogRequestResponse;
import com.softwelse.upload.exceptions.EmptyFileException;
import com.softwelse.upload.exceptions.EmptyLogException;
import com.softwelse.upload.exceptions.IllegalExtensionFileException;
import com.softwelse.upload.model.Log;
import com.softwelse.upload.repositories.LogRepository;
import com.softwelse.upload.util.FileUtil;

@Service
public class FileUploadService {

	@Autowired
	private LogRepository logRepository;

	public UploadLogRequestResponse leituraArquivo(MultipartFile file)
			throws IOException, EmptyFileException, IllegalExtensionFileException {
		validarArquivo(file);
		List<Log> logsToSave = FileUtil.parseToLogFromFile(file);

		return logRepository.inserirArquivoBanco(logsToSave);
	}

	private void validarArquivo(MultipartFile file) throws EmptyFileException, IllegalExtensionFileException {
		if (file == null || file.isEmpty()) {
			throw new EmptyFileException("Arquivo nao pode ser Nulo ou Vazio");
		}
		if (!PropertiesConfig.getAllowedExtension().contains(file.getOriginalFilename().split("\\.")[1])) {
			throw new IllegalExtensionFileException("Extensao do Arquivo Incompativel");
		}
	}

	public List<Log> buscarLog(Log logFiltros) {
		return logRepository.buscarLog(logFiltros);
	}

	public UploadLogRequestResponse insertLog(Log log) {
		validarLog(log);
		return logRepository.inserirArquivoBanco(Arrays.asList(log));
	}

	private void validarLog(Log log) {
//		if (log.getData() == null && log.getData().isEmpty()) {
		if (StringUtils.hasText(log.getData())) {
			throw new EmptyLogException("Preencha a Data");
		}
		if (log.getIp() == null && log.getIp().isEmpty()) {
			throw new EmptyLogException("Preencha o IP");
		}
		if (log.getRequest() == null && log.getRequest().isEmpty()) {
			throw new EmptyLogException("Preencha a Request");
		}
		if (log.getStatus() == null && log.getStatus() == 0) {
			throw new EmptyLogException("Preencha a Status");
		}
		if (log.getUserAgent() == null && log.getUserAgent().isEmpty()) {
			throw new EmptyLogException("Preencha a User Agent");
		}
	}
}