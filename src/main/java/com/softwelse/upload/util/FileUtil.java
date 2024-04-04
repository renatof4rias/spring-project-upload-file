package com.softwelse.upload.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.softwelse.upload.model.Log;

public class FileUtil {

	public static List<Log> parseToLogFromFile(MultipartFile file) {
		List<Log> logs = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Log log = new Log();
				String[] split = line.split("\\|");

				log.setData(split[0]);
				log.setIp(split[1]);
				log.setRequest(split[2]);
				log.setStatus(Long.parseLong(split[3]));
				log.setUserAgent(split[4]);

				logs.add(log);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return logs;
	}
}