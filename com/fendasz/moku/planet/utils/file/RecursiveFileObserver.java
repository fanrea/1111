package com.fendasz.moku.planet.utils.file;

import android.os.FileObserver;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RecursiveFileObserver implements Runnable {
    private static final String TAG = "RecursiveFileObserver=>";
    private OnFileObserverListener onFileObserverListener;
    private String rootPath;
    private ArrayList<SingleFileObserver> mSingleObservers = new ArrayList<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors());
    private boolean isShutdown = false;

    public interface OnFileObserverListener {
        void onEvent(int i, String str);
    }

    public RecursiveFileObserver(String str) {
        this.rootPath = str;
    }

    public void startWatcher() {
        this.executorService.execute(this);
    }

    private void parsePath() {
        Stack stack = new Stack();
        stack.push(this.rootPath);
        while (!stack.isEmpty()) {
            String str = (String) stack.pop();
            if (this.mSingleObservers.add(new SingleFileObserver(this, str))) {
                Log.d(TAG, "add observer success" + str);
            }
            File file = new File(str);
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                for (File file2 : fileArrListFiles) {
                    if (!file2.isDirectory() || (!file2.getName().equals(".") && !file2.getName().equals(".."))) {
                        stack.push(file2.toString());
                        Log.d(TAG, "file list:" + file2.toString());
                    }
                }
            }
        }
    }

    public void stopWatching() {
        this.executorService.shutdown();
        this.executorService = null;
        this.isShutdown = true;
        for (int i = 0; i < this.mSingleObservers.size(); i++) {
            SingleFileObserver singleFileObserver = this.mSingleObservers.get(i);
            if (singleFileObserver != null) {
                singleFileObserver.stopWatching();
            }
        }
        this.mSingleObservers.clear();
        this.mSingleObservers = null;
        this.onFileObserverListener = null;
    }

    public OnFileObserverListener getOnFileObserverListener() {
        return this.onFileObserverListener;
    }

    public void setOnFileObserverListener(OnFileObserverListener onFileObserverListener) {
        this.onFileObserverListener = onFileObserverListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        parsePath();
        for (int i = 0; i < this.mSingleObservers.size(); i++) {
            this.mSingleObservers.get(i).startWatching();
        }
    }

    private class SingleFileObserver extends FileObserver {
        public static final int DEFAULT_MASK = 770;
        protected int mMask;
        protected String mPath;

        public SingleFileObserver(RecursiveFileObserver recursiveFileObserver, String str) {
            this(str, 770);
        }

        public SingleFileObserver(String str, int i) {
            super(str, i);
            this.mPath = str;
            this.mMask = i;
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            int i2 = i & 4095;
            if (RecursiveFileObserver.this.onFileObserverListener == null || RecursiveFileObserver.this.isShutdown) {
                return;
            }
            RecursiveFileObserver.this.onFileObserverListener.onEvent(i2, str);
        }
    }

    private static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
}
