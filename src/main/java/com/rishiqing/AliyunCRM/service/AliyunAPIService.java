package com.rishiqing.AliyunCRM.service;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 117_John on 7/25/2017.
 */
public class AliyunAPIService {

    public static void main(String[] args)throws IOException{
        System.out.println(genAPIRequestURL("abcde"));
    }

    public static String genAPIRequestURL(String verificationCode) throws IOException{
        String apiRequest=null;
        try{
            apiRequest = genQueryString(verificationCode);

        }catch(Exception e){
            e.printStackTrace();
        }
        return "https://market.aliyuncs.com/?"+apiRequest;
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

    private static String genQueryString(String licenseCode)throws UnsupportedEncodingException,InvalidKeyException,NoSuchAlgorithmException{
        final String HTTP_METHOD = "GET";
        final String accessKey = "LTAITWY6G7JwLeB6";
        final String requestActionParam = "DescribeLicense";
        final String version = "2015-11-01";
        //final String version = "2014-05-26";
        final String signatureVersion = "1.0";
        final String signatureMethod = "HMAC-SHA1";
        final String format = "XML";
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
        System.out.println("signature: "+signature);
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
