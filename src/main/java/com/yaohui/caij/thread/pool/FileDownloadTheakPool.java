package com.yaohui.caij.thread.pool;

import com.yaohui.caij.thread.CaijTaskThread;
import com.yaohui.caij.thread.FileDownloadThread;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class FileDownloadTheakPool {

    private static final int FILE_DOWNLOAD_THREAD_SIZE = 3;

    public FileDownloadTheakPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(FILE_DOWNLOAD_THREAD_SIZE);
        for (int i = 0; i < FILE_DOWNLOAD_THREAD_SIZE; i++) {
            executorService.execute(new FileDownloadThread());
        }
    }
}
