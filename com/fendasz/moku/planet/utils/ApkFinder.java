package com.fendasz.moku.planet.utils;

import android.content.pm.PackageManager;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ApkFinder {
    private static final int THREAD_POOL_SIZE = 10;
    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    private final PackageManager packageManager;
    private DirectoryScanner scanner;

    public interface ApkFindListener {
        void onApkFilesFound(List<File> list);
    }

    public ApkFinder(PackageManager packageManager) {
        this.packageManager = packageManager;
    }

    private class DirectoryScanner implements Runnable {
        private boolean flag = true;

        @Override // java.lang.Runnable
        public void run() {
        }

        public DirectoryScanner() {
        }

        public void stop() {
            this.flag = false;
        }
    }
}
