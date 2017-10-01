package com.rishiqing.AliyunCRM.service;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.URL;
import java.net.HttpURLConnection;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by 117_John on 7/25/2017.
 */
public class AliyunAPIService {
    private static String[] REQUESTACTION = new String[]{"DescribeLicense","ActivateLicense"};

    //No DB query action
    public static void main(String[] args)throws IOException{
        int res = verifyCode("W671Y10PTBB3DMCQBMKFW-90VOVNWKNZGGV8AYOG19EPT_EL5XM3R1_MDJIPDS8A");
        System.out.println(res);
    }

    private static String genAPIRequestURL(String verificationCode,int requestAction) throws IOException{
        String apiRequest=null;
        try{
            apiRequest = genQueryString(verificationCode,requestAction);

        }catch(Exception e){
            e.printStackTrace();
        }
        return "https://market.aliyuncs.com/?"+apiRequest;
    }

    public static int verifyCode(String vcode){
        BufferedReader in;
        try{
            String url = genAPIRequestURL(vcode,0);//requestAction == "DescribeLicense"
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            if (responseCode != 200 && responseCode!=201) {
                return -2;//connection problem or request too frequent
            }
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                //System.out.println(inputLine);
            }
            in.close();
            String result = response.toString();
            Map<String,Object> mp = JSONObject.parseObject(result);
            String productName = (String)((Map)mp.get("License")).get("ProductName");
            String licenseStatus = (String)((Map)mp.get("License")).get("LicenseStatus");
            //System.out.println(productName);
            if(licenseStatus.equals("INACTIVATED")){
                //System.out.println(1);
                return 1;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    private static String genSignature(String stringToSign)throws NoSuchAlgorithmException,UnsupportedEncodingException,
            InvalidKeyException{
        final String ALGORITHM = "HmacSHA1";
        final String ENCODING = "UTF-8";
        final String secretKey = "bHR5KUJvZwoxizeF81gmgZvoppcQmD&";

        Mac mac = Mac.getInstance(ALGORITHM);
        mac.init(new SecretKeySpec(secretKey.getBytes(ENCODING), ALGORITHM));
        byte[] signData = mac.doFinal(stringToSign.getBytes(ENCODING));
        return new String(Base64.encodeBase64(signData));
    }

    private static String genQueryString(String licenseCode,int requestAction)throws UnsupportedEncodingException,InvalidKeyException,NoSuchAlgorithmException{
        final String HTTP_METHOD = "GET";
        final String accessKey = "LTAITWY6G7JwLeB6";
        final String requestActionParam = REQUESTACTION[requestAction];
        final String version = "2015-11-01";
        //final String version = "2014-05-26";
        final String signatureVersion = "1.0";
        final String signatureMethod = "HMAC-SHA1";
        final String format = "JSON";
        //final String licenseCode = "abcdefbasdce";
        //Date timeStamp = new Date();
        Map<String, String> parameters = new HashMap<String, String>();
        // 加入请求参数
        parameters.put("Action", requestActionParam);
        //parameters.put("Action", "DescribeRegions");
        parameters.put("Version", version);
        parameters.put("AccessKeyId", accessKey);
        parameters.put("Timestamp", formatIso8601Date(new Date()));
        parameters.put("SignatureMethod", signatureMethod);
        parameters.put("SignatureVersion", signatureVersion);
        parameters.put("SignatureNonce", UUID.randomUUID().toString());
        parameters.put("Format", format);
        parameters.put("LicenseCode",licenseCode);

        // 对参数进行排序
        String[] sortedKeys = parameters.keySet().toArray(new String[]{});
        Arrays.sort(sortedKeys);

        final String SEPARATOR = "&";

        // 生成stringToSign字符串
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append(HTTP_METHOD).append(SEPARATOR);
        stringToSign.append(percentEncode("/")).append(SEPARATOR);

        StringBuilder canonicalizedQueryString = new StringBuilder();
        for(String key : sortedKeys) {
            // 这里注意对key和value进行编码
            canonicalizedQueryString.append("&")
                    .append(percentEncode(key)).append("=")
                    .append(percentEncode(parameters.get(key)));
        }

        // 这里注意对canonicalizedQueryString进行编码
        stringToSign.append(percentEncode(
                canonicalizedQueryString.toString().substring(1)));

        String signature = genSignature(stringToSign.toString());
        //System.out.println("signature: "+signature);
        parameters.put("Signature",signature);
        return urlEncode(parameters);

    }

    private static String urlEncode(Map<String,String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    entry.getKey(),
                    entry.getValue()
            ));
        }
        return sb.toString();
    }

    private static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static String formatIso8601Date(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT);
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return df.format(date);
    }

    private static final String ENCODING = "UTF-8";

    private static String percentEncode(String value) throws UnsupportedEncodingException {
        return value != null ? URLEncoder.encode(value, ENCODING).replace("+", "%20").replace("*", "%2A").replace("%7E", "~") : null;
    }
}
