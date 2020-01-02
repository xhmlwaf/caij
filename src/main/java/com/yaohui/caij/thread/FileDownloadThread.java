package com.yaohui.caij.thread;

import com.google.common.collect.Lists;

import com.yaohui.caij.cache.FileUrlQueue;
import com.yaohui.caij.utils.DownLoadUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class FileDownloadThread implements Runnable {

  public static final Logger logger = LoggerFactory.getLogger(FileDownloadThread.class);
  private static final String SAVE_PATH = "d://1111//";

  public static String getUUID32() {
    String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
    return uuid;
  }

  @Override
  public void run() {

    try {
      while (true) {
        String url = FileUrlQueue.take();
        if (Objects.nonNull(url)) {
          logger.info("开始下载：" + url);
          String stuff = getStuff(url);

          DownLoadUtil.downloadFileFromUrl(url, getUUID32() + stuff, SAVE_PATH);
          logger.info("下载完成：" + url);
        }
      }

    } catch (Exception e) {
      logger.error("抓取数据异常.", e);
    }

  }

  private static String getStuff(String url) {
    List<String> imageStuff = Lists.newArrayList(".jpg", ".png", ".gif", ".bmp");
    for (String image : imageStuff) {
      if (url.contains(image)) {
        return image;
      }
    }
    return "";
  }

  public static void main(String[] args) {
    System.out.println("www.sfsdfsdf.com/43434/r.jpg?fsdfsdf".contains(".jpg"));
  }


}
