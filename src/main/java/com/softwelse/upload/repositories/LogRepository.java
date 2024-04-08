package com.softwelse.upload.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.softwelse.upload.config.Database;
import com.softwelse.upload.dto.UploadLogRequestResponse;
import com.softwelse.upload.model.Log;

@Service
public class LogRepository {

	public UploadLogRequestResponse inserirArquivoBanco(List<Log> logs) {
		UploadLogRequestResponse resposta = new UploadLogRequestResponse();
		String sql = "INSERT INTO tb_logs(data, ip, request, status, userAgent) VALUES(?, ?, ?, ?, ?)";
		try {
			Connection con = Database.connection();
			PreparedStatement pst = con.prepareStatement(sql);
			for (Log log : logs) {
				pst.setTimestamp(1, java.sql.Timestamp.valueOf(log.getData()));
				pst.setString(2, log.getIp());
				pst.setString(3, log.getRequest());
				pst.setLong(4, log.getStatus());
				pst.setString(5, log.getUserAgent());

				pst.addBatch();
			}
			int[] result = pst.executeBatch();
			resposta.setQtdSuccessLine(Arrays.stream(result).filter(num -> num >= 0).count());
			resposta.setQtdErrorsLine(logs.size() - resposta.getQtdSuccessLine());

			if (resposta.getQtdErrorsLine() > 0) {
				resposta.setMessage("Nem Todas as Linhas tiveram sucesso");
			} else {
				resposta.setMessage("Todas as Linhas tiveram sucesso");
			}

			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resposta;

	}

	public List<Log> buscarLog(Log logFiltros) {
		List<Log> logs = new ArrayList<>();
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * from tb_logs");
		if (logFiltros != null) {
			sql.append(" WHERE ");
		}
		if (logFiltros.getData() != null) {
			sql.append("to_char(data::timestamp, 'YYYY-MM-DD') = '" + logFiltros.getData() + "'");
			sql.append(" and ");
		}
		if (logFiltros.getIp() != null && logFiltros.getIp().trim() != null) {
			sql.append("ip = " + logFiltros.getIp());
			sql.append(" and ");
		}
		if (logFiltros.getRequest() != null && logFiltros.getRequest().trim() != null) {
			sql.append("request = " + logFiltros.getRequest());
			sql.append(" and ");
		}
		if (logFiltros.getStatus() != null) {
			sql.append("status = " + logFiltros.getStatus());
			sql.append(" and ");
		}
		if (logFiltros.getUserAgent() != null && logFiltros.getUserAgent().trim() != null) {
			sql.append("upper(useragent) like upper('%" + logFiltros.getUserAgent() + "%')");
		}
		if (sql.toString().endsWith(" and ")) {
			sql.delete(sql.length() - 5, sql.length());
		}

		try {
			Connection con = Database.connection();
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Log log = new Log();
				log.setData(rs.getTimestamp("data").toString());
				log.setIp(rs.getString("ip"));
				log.setRequest(rs.getString("request"));
				log.setStatus(rs.getLong("status"));
				log.setUserAgent(rs.getString("useragent"));
				logs.add(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logs;
	}
	
}