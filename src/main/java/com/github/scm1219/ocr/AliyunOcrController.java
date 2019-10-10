package com.github.scm1219.ocr;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(path = "/ocr")
public class AliyunOcrController {

	@Autowired
	private AliyunOcrConfig ocrConfig;

	@ResponseBody
	@RequestMapping(path = "/idcard")
	public String getIdendo(HttpServletRequest request) throws Exception {
		
		String result = "unkonw";
		try {
			Map<String, String[]> params = request.getParameterMap();
			if (params.get("imgbase64") != null) {
				String img = params.get("imgbase64")[0].substring(23);
				JSONObject configObj = new JSONObject();
				configObj.put("side", "face");
				String configStr = configObj.toString();
				result = AliyunOcrUtils.aliyunOcr(img, configStr, ocrConfig.getIdCardhost(), ocrConfig.getIdCardApiPath(),
						ocrConfig.getIdCardAppCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(path = "/passport")
	public String getPassport(HttpServletRequest request) throws Exception{
		String result = "unkonw";
		try {
			Map<String, String[]> params = request.getParameterMap();
			if (params.get("imgbase64") != null) {
				String img = params.get("imgbase64")[0].substring(23);
				JSONObject configObj = new JSONObject();
				String configStr = configObj.toString();
				result = AliyunOcrUtils.aliyunOcr(img, configStr, ocrConfig.getPassportHost(), ocrConfig.getPassportApiPath(),
						ocrConfig.getPassportAppCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		System.out.println(result);
		return result;
	}
}
