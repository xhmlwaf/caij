package com.yaohui.caij.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadUtil {

  public static void downloadFileFromUrl(String fileUrl, String fileName, String savePath) throws Exception {
    //获取连接
    URL url = new URL(fileUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setConnectTimeout(3 * 1000);
    //设置请求头
    connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
    //获取输入流
    InputStream in = connection.getInputStream();

    File saveDir = new File(savePath);
    if (!saveDir.exists()) {
      saveDir.mkdirs();
    }
    File file = new File(savePath + fileName);

    OutputStream out = new FileOutputStream(file);

    byte[] bytes = new byte[1024];
    int len = 0;
    while ((len = in.read(bytes)) != -1) {
      out.write(bytes, 0, len);
    }
    out.close();
    in.close();
  }

  public static void main(String[] args) {
    try {
      downloadFileFromUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png", "baidu.png", "E:\\");
    } catch (Exception e) {

    }
  }
}