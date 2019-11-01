package com.sdl.swagger.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.sdl.swagger.config.PropertiesConfig;
import com.sdl.swagger.controller.LoginController;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import javax.rmi.CORBA.Util;

/**
 * @author sundonglin
 * @date 2019/10/24 10:09
 */
public class HttpClientUtils {
    public static final String UTF8 = "utf-8";

    /**
     * 发起Get请求
     */
    public static String doGet(String url) throws IOException {
        return doGet(url, UTF8);
    }

    /**
     * 发起Get请求
     */
    public static String doGet(String url, String encoding) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        return readResponse(response, encoding);
    }

    /**
     *  发起Get请求(待header)
     * @param url
     * @param param
     * @param header
     * @return
     * @throws IOException
     */
    public static String doGet(String url, Map<String,  String> param, String header) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        String params = "?";
        for(String key:param.keySet()){
            params += key + param.get(key).toString() + "&";
        }
        params = params.substring(0, params.length() - 1);
        url+=params;
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Cookie", header);
        HttpResponse response = httpClient.execute(httpGet);
        return readResponse(response, UTF8);
    }

    /**
     * 发起Delete请求
     */
    public static String doDelete(String url) throws IOException {
        return doDelete(url, UTF8);
    }

    /**
     * 发起Delete请求
     */
    public static String doDelete(String url, String encoding) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpDelete httpDelete = new HttpDelete(url);
        HttpResponse response = httpClient.execute(httpDelete);
        return readResponse(response, encoding);
    }

    /**
     * 发起Put请求
     */
    public static String doPut(String url, Map<String, String> params) throws IOException {
        List<BasicNameValuePair> paramList = new ArrayList<BasicNameValuePair>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            paramList.add(new BasicNameValuePair(param.getKey(), param.getValue()));
        }
        return doPut(url, UTF8, paramList);
    }

    /**
     * 发起Put请求
     */
    public static String doPut(String url, String encoding, List<BasicNameValuePair> params) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPut httpPut = new HttpPut(url);
        HttpEntity httpEntity = new UrlEncodedFormEntity(params, encoding);
        httpPut.setEntity(httpEntity);
        HttpResponse response = httpClient.execute(httpPut);
        return readResponse(response, encoding);
    }

    /**
     * 发起Post请求
     */
    public static String doPost(String url, String param) throws IOException {
        return doPost(url, UTF8, param);
    }

    /**
     * 发起Post请求
     */
    public static String doPost(String url, String encoding, String param) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        StringEntity reqEntity = new StringEntity(param,UTF8);
        httpPost.setEntity(reqEntity);
        HttpResponse response = httpClient.execute(httpPost);
        return readResponse(response, encoding);
    }

    public static String login(String url, Map<String, String> params, String userId) throws IOException {
        List<BasicNameValuePair> paramList = new ArrayList<BasicNameValuePair>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            paramList.add(new BasicNameValuePair(param.getKey(), param.getValue()));
        }
        return login(url, UTF8, paramList,userId);
    }

    /**
     * 发起Post请求，多个参数（Form表单参数）
     */
    public static String login(String url, String encoding, List<BasicNameValuePair> params, String userId) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        HttpEntity httpEntity = new UrlEncodedFormEntity(params, encoding);
        httpPost.setEntity(httpEntity);
        HttpResponse response = httpClient.execute(httpPost);
        int statuscode = response.getStatusLine().getStatusCode();
        if ((statuscode == HttpStatus.SC_MOVED_TEMPORARILY) || (statuscode == HttpStatus.SC_MOVED_PERMANENTLY)
                || (statuscode == HttpStatus.SC_SEE_OTHER) || (statuscode == HttpStatus.SC_TEMPORARY_REDIRECT)) {
            // 读取新的 URL 地址
            Header header = response.getFirstHeader("location");
            if (header != null) {
                String newuri = header.getValue();
                if ((newuri == null) || (newuri.equals(""))) {
                    newuri = "/";
                }
                HttpGet httpget = new HttpGet(newuri);
                httpClient = new DefaultHttpClient();
                response = httpClient.execute(httpget);
            }
        }
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity het = response.getEntity();
            String sessionId = "";

            sessionId = response.getFirstHeader("Set-Cookie") != null ? response.getFirstHeader("Set-Cookie")
                    .getValue().toString() : "";
            //ProxyUtil.amsSessionMap.put(sessionUser, sessionId);

            sessionId = response.getLastHeader("Set-Cookie") != null ? response.getLastHeader("Set-Cookie")
                    .getValue().toString() : "";

            PropertiesConfig.userCookieMap.put(userId, sessionId);
            //ProxyUtil.weiboSessionMap.put(sessionUser, sessionId);
        }
        return readResponse(response, encoding);
    }

    /**
     * 发起Post请求，多个参数（Form表单参数）
     */
    public static String doPost(String url, Map<String, String> params) throws IOException {
        List<BasicNameValuePair> paramList = new ArrayList<BasicNameValuePair>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            paramList.add(new BasicNameValuePair(param.getKey(), param.getValue()));
        }
        return doPost(url, UTF8, paramList);
    }

    /**
     * 发起Post请求，多个参数（Form表单参数）
     */
    public static String doPost(String url, BasicNameValuePair... params) throws IOException {
        return doPost(url, UTF8, Arrays.asList(params));
    }

    /**
     * 发起Post请求，多个参数（Form表单参数）
     */
    public static String doPost(String url, List<BasicNameValuePair> params) throws IOException {
        return doPost(url, UTF8, params);
    }

    /**
     * 发起Post请求，多个参数（Form表单参数）
     */
    public static String doPost(String url, String encoding, List<BasicNameValuePair> params) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        HttpEntity httpEntity = new UrlEncodedFormEntity(params, encoding);
        httpPost.setEntity(httpEntity);
        HttpResponse response = httpClient.execute(httpPost);
        return readResponse(response, encoding);
    }

    /**
     * 发起Post请求，多个参数（Form表单参数）
     */
    public static String doPost(String url, Map<String, String> params, String header) throws IOException {
        List<BasicNameValuePair> paramList = new ArrayList<BasicNameValuePair>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            paramList.add(new BasicNameValuePair(param.getKey(), param.getValue()));
        }
        return doPost(url, UTF8, paramList, header);
    }

    /**
     * 发起Post请求，多个参数（Form表单参数）
     */
    private static String doPost(String url, String encoding, List<BasicNameValuePair> params, String header) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Cookie", header);
        HttpEntity httpEntity = new UrlEncodedFormEntity(params, encoding);
        httpPost.setEntity(httpEntity);
        HttpResponse response = httpClient.execute(httpPost);
        return readResponse(response, encoding);
    }

    /**
     * 读取相应值，非200状态返回null
     */
    private static String readResponse(HttpResponse response, String encoding) throws IOException {
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            StringBuffer result = new StringBuffer();
            HttpEntity httpEntity = response.getEntity();
            InputStream inputStream = httpEntity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, encoding));
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                result.append(readLine);
            }
            inputStream.close();
            bufferedReader.close();
            return result.toString();
        } else {
            System.err.println("非200，状态值=" + response.getStatusLine().getStatusCode());
            return null;
        }
    }
}
