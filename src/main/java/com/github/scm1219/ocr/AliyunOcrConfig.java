package com.github.scm1219.ocr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AliyunOcrConfig {

	@Value("${aliyun.ocr.idcard.host}")
	private String idCardhost;
	
	@Value("${aliyun.ocr.idcard.api}")
	private String idCardApiPath;
	
	@Value("${aliyun.ocr.idcard.appcode}")
	private String idCardAppCode;
	
	@Value("${aliyun.ocr.passport.host}")
	private String passportHost;
	
	@Value("${aliyun.ocr.passport.api}")
	private String passportApiPath;
	
	@Value("${aliyun.ocr.passport.appcode}")
	private String passportAppCode;
}
