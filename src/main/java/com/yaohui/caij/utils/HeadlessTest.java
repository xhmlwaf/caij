package com.yaohui.caij.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.HashMap;

public class HeadlessTest {


// args = ["--window-size=1280,1696", "--no-sandbox", "--headless", "--disable-gpu", "--disable-infobars", "--disable-notifications"]

    /**
     * @desc get chrome driver
     */
    public static ChromeDriver getDriver() {

        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_settings", 2);
        prefs.put("profile.default_content_setting_values", 2);
        prefs.put("profile.managed_default_content_settings.images", 2);

        String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
        ChromeOptions options = new ChromeOptions();
        //options.setBinary("D:\\BaiduNetdiskDownload\\60.0.3081.0_chrome64_canary_windows_installer.exe");
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--user-agent");
//    options.addArguments("--user-agent=" + userAgent,"--no-sandbox", "--test-type");
//    options.addArguments("--disable-infobars", "--headless", "--disable-gpu","--enable-strict-powerful-feature-restrictions");
//    options.addArguments("--disable-plugins", "--disable-images","--window-size=0,0");
        //options.addArguments("--disable-plugins", "--disable-images", "--start-maximized");
        options.setHeadless(true);

//    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//    capabilities.setJavascriptEnabled(true);

        return new ChromeDriver(options);
    }

    /**
     * @param args
     * @throws IOException
     * @desc main method
     */
    public static void main(String[] args) throws IOException {

        String driverPath = "D:\\软件\\chromedriver_win32\\chromedriver.exe";
        String targetURL = "https://try.taobao.com/";

        System.setProperty("webdriver.chrome.driver", driverPath);

//    //###################这一段代码可以用
//    ChromeOptions chromeOptions = new ChromeOptions();
////        设置为 headless 模式 （必须）
//    chromeOptions.addArguments("--headless");
//    WebDriver driver = new ChromeDriver(chromeOptions);
//    driver.get("https://try.taobao.com/");
//    String title = driver.getPageSource();
//    System.out.println(title);
//    //###################这一段代码可以用

        ChromeDriver driver = getDriver();

        // 对网页内容作处理
        driver.navigate().to(targetURL);
        String source = driver.getPageSource();

        System.out.println(source);

        driver.get("about:blank");
        driver.get("http://doc.yunsom.cn/user/notifications");
        source = driver.getPageSource();

        System.out.println("第二次：" + source);

        try {
            driver.quit();
            driver.close();
        } catch (Exception e) {
        }
        // 如果对网页做操作，直接使用Driver
        // 执行JS：滚动效果
        //driver.executeScript("scrollTo(0,10000)");

        // 等待加载示例
        // 1. 超时加载等待
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // 2. 等待加载组件
        //WebDriverWait wait = new WebDriverWait(driver, 20);

    }

//  /**
//   * @desc crawler html content
//   * @param url
//   */
//  public static Document getDocument(String url) {
//
//    ChromeDriver driver = getDriver();
//    Document doc = null;
//    try {
//      driver.get(url);
//      doc = Jsoup.parse(driver.getPageSource());
//    } catch (Exception e) {
//    } finally {
//      try {
//        driver.quit();
//        driver.close();
//      } catch (Exception e) {
//      }
//    }
//
//    return doc;
//  }
}
