package com.github.scm1219.ocr;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class AliyunOcrUtils {

	public static String aliyunOcr(String imgBase64,String configStr,String host,String apiPath,String appCode) {
        String result="";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appCode);
        Map<String, String> querys = new HashMap<String, String>();
        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("image", imgBase64);
            if(configStr.length() > 0) {
            	requestObj.put("configure", configStr);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String bodys = requestObj.toString();
        try {
            HttpResponse response = HttpUtils.doPost(host, apiPath, "POST", headers, querys, bodys);
            int stat = response.getStatusLine().getStatusCode();
            if(stat != 200){
                System.out.println("Http code: " + stat);
                System.out.println("http header error msg: "+ response.getFirstHeader("X-Ca-Error-Message"));
                System.out.println("Http body error msg:" + EntityUtils.toString(response.getEntity()));
                return "";
            }
            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSON.parseObject(res);
            result = JSON.toJSONString(res_obj,SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, 
                    SerializerFeature.WriteDateUseDateFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
   }
}
