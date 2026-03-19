package com.fendasz.moku.planet.utils;

import com.sigmob.sdk.base.mta.PointCategory;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ApkScanTask {
    private static final String TAG = "ApkScanTask=>";
    private ExecutorService executor;
    private ScanCallBack scanCallBack;
    private int scanFlag;
    private ScanRunable scanRunable;

    public interface ScanCallBack {
        void callBack(List<String> list);
    }

    public ApkScanTask() {
        LogUtils.logD(TAG, PointCategory.INIT);
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        createScanTask();
    }

    private void createScanTask() {
        LogUtils.logD(TAG, "createScanTask");
        this.scanRunable = new ScanRunable();
        this.scanFlag = 0;
    }

    public void executeScan() {
        LogUtils.logD(TAG, "executeScan");
        this.scanFlag = 1;
        this.executor.execute(this.scanRunable);
    }

    public void reStart() {
        LogUtils.logD(TAG, "reStart");
        createScanTask();
    }

    public int getScanFlag() {
        return this.scanFlag;
    }

    public ScanCallBack getScanCallBack() {
        return this.scanCallBack;
    }

    public void setScanCallBack(ScanCallBack scanCallBack) {
        this.scanCallBack = scanCallBack;
    }

    public void stopScan() {
        LogUtils.logD(TAG, "stopScan");
        ScanRunable scanRunable = this.scanRunable;
        if (scanRunable != null) {
            scanRunable.recycle();
        }
        this.scanFlag = -1;
        this.executor.shutdown();
        this.scanRunable = null;
    }

    private class ScanRunable implements Runnable {
        protected boolean flag = true;

        public ScanRunable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtils.logD(ApkScanTask.TAG, "ScanRunable_start find apk files");
            List<String> listFindApkFiles = ApkUtil.findApkFiles(ApkUtil.getApkRootDirectory());
            LogUtils.logD(ApkScanTask.TAG, "ScanRunable_find apk files finished,invoke callback method");
            ApkScanTask.this.scanFlag = 2;
            if (this.flag) {
                ApkScanTask.this.scanCallBack.callBack(listFindApkFiles);
            }
        }

        public void recycle() {
            LogUtils.logD(ApkScanTask.TAG, "ScanRunable_recycle");
            this.flag = false;
        }
    }
}
