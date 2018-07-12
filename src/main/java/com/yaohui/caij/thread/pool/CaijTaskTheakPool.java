package com.yaohui.caij.thread.pool;

import com.yaohui.caij.thread.CaijTaskThread;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CaijTaskTheakPool {

  private static final int CAIJ_TASK_THREAD_SIZE = 5;

  public CaijTaskTheakPool() {
    ExecutorService executorService = Executors.newFixedThreadPool(CAIJ_TASK_THREAD_SIZE);
    for (int i = 0; i < CAIJ_TASK_THREAD_SIZE; i++) {
      executorService.execute(new CaijTaskThread());
    }
  }
}
