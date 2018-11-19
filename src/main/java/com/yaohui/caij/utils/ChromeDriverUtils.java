package com.yaohui.caij.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ChromeDriverUtils {

    @Value("${chrome_driver_path}")
    private static String driverPath;
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
        System.setProperty("webdriver.chrome.driver", driverPath);

        return new ChromeDriver(options);
    }
}
