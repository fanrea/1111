package com.ss.mediakit.downloader;

import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.net.AVMDLThreadPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLDownLoadTask {
    public static final int IsHttpOpen = 0;
    public static final int IsHttpRead = 1;
    public static final int IsInValidStep = -1;
    public static final int IsReponseHeader = 0;
    public static final int IsResponseComplete = 3;
    public static final int IsResponseData = 1;
    public static final int IsResponseDownloadInterruptEnd = 5;
    public static final int IsResponseError = 2;
    public static final int IsResponseInfo = 4;
    private static final String TAG = "AVMDLDownLoadTask";
    private File file;
    FileOutputStream fos;
    private Future mFuture;
    private AVMDLRequest mRequest;
    private AVMDLResponse mResponse;
    private long mHandle = 0;
    private boolean mIsRunning = false;
    private int mStep = -1;
    private Lock mHandleLock = new ReentrantLock();
    private Lock mResonseLock = new ReentrantLock();

    private static native void _notifyLoadInfo(long j, int i, long j2, long j3, String str);

    private static native int _onRecvData(long j, byte[] bArr, int i);

    public int open(long j, Object obj, Object obj2, int i, int i2, int i3) {
        if (j == 0 || obj == null) {
            AVMDLLog.e(TAG, "handle zero err");
            return -1;
        }
        AVMDLRequest aVMDLRequest = (AVMDLRequest) obj;
        if (aVMDLRequest.urls == null || aVMDLRequest.urls.length == 0) {
            AVMDLLog.e(TAG, "no url err");
            return -2;
        }
        this.mRequest = aVMDLRequest;
        setHandle(j);
        this.mStep = 0;
        this.mIsRunning = true;
        this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.mediakit.downloader.AVMDLDownLoadTask.1
            @Override // java.lang.Runnable
            public void run() throws Exception {
                AVMDLLog.d(AVMDLDownLoadTask.TAG, new StringBuilder().append("request start:").append(AVMDLDownLoadTask.this.mRequest.urls[0]).toString() != null ? AVMDLDownLoadTask.this.mRequest.urls[0] : "url is null");
                AVMDLResponse aVMDLResponse = new AVMDLResponse(AVMDLDownLoadTask.this.mRequest, null, null);
                byte[] bArr = new byte[32768];
                while (AVMDLDownLoadTask.this.mIsRunning) {
                    int i4 = AVMDLDownLoadTask.this.mStep;
                    if (i4 == 0) {
                        aVMDLResponse = AVMDLDownLoadTask.this.httOpen(aVMDLResponse.request);
                        if (aVMDLResponse != null && aVMDLResponse.isOpenSuccessful()) {
                            AVMDLDownLoadTask.this.mStep = 1;
                        } else {
                            AVMDLDownLoadTask.this.notifyToNative(2, -777L, 0L, null);
                            AVMDLLog.d(AVMDLDownLoadTask.TAG, "request is error http open fail");
                            return;
                        }
                    } else if (i4 != 1) {
                        continue;
                    } else {
                        aVMDLResponse = AVMDLDownLoadTask.this.httpRead(aVMDLResponse, bArr);
                        if (!aVMDLResponse.isReadSuccessful()) {
                            AVMDLLog.d(AVMDLDownLoadTask.TAG, "read fail try http open");
                            AVMDLDownLoadTask.this.mStep = 0;
                        } else if (aVMDLResponse.isFinish()) {
                            AVMDLDownLoadTask.this.notifyToNative(3, 0L, aVMDLResponse.contentlength, null);
                            AVMDLLog.d(AVMDLDownLoadTask.TAG, "request is finish");
                            return;
                        }
                    }
                }
                AVMDLLog.d(AVMDLDownLoadTask.TAG, "request is interrupt end url:" + AVMDLDownLoadTask.this.mRequest.urls[0]);
                AVMDLDownLoadTask.this.notifyToNative(5, 0L, 0L, null);
            }
        });
        return 0;
    }

    public void close() {
        setHandle(0L);
        this.mIsRunning = false;
        cancelResponse();
    }

    private void setHandle(long j) {
        try {
            this.mHandleLock.lock();
            this.mHandle = j;
            AVMDLLog.d(TAG, String.format(Locale.US, "set handle:%d", Long.valueOf(j)));
        } finally {
            this.mHandleLock.unlock();
        }
    }

    private void cancelResponse() {
        try {
            this.mResonseLock.lock();
            if (this.mResponse != null) {
                AVMDLLog.d(TAG, "start cancel response");
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.mResponse.cancel();
                AVMDLLog.d(TAG, String.format(Locale.US, "end cancel cost time:%d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
            }
        } finally {
            this.mResonseLock.unlock();
        }
    }

    private void setResponse(AVMDLResponse aVMDLResponse) {
        this.mResonseLock.lock();
        this.mResponse = aVMDLResponse;
        this.mResonseLock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AVMDLResponse httOpen(AVMDLRequest aVMDLRequest) throws Exception {
        AVMDLResponse aVMDLResponseExcute;
        AVMDLLog.d(TAG, "start http open, url:" + aVMDLRequest.urls[aVMDLRequest.mCurlUrlIndex] + "object:" + this + "handle:" + this.mHandle);
        int i = aVMDLRequest.mCurlUrlIndex;
        setResponse(null);
        int length = i;
        do {
            AVMDLLog.d(TAG, String.format(Locale.US, "http open index:%d state:%d trycount:%d maxTry:%d", Integer.valueOf(length), Integer.valueOf(aVMDLRequest.mUrlState[length]), Integer.valueOf(aVMDLRequest.mUrlErrCount[length]), Integer.valueOf(aVMDLRequest.mMaxTryCout)) + " url:" + aVMDLRequest.urls[length]);
            if (aVMDLRequest.mUrlState[length] == 0 && (aVMDLRequest.mMaxTryCout <= 0 || aVMDLRequest.mUrlErrCount[length] < aVMDLRequest.mMaxTryCout)) {
                try {
                    aVMDLResponseExcute = AVMDLHttpExcutor.excute(aVMDLRequest, length);
                } catch (IOException e) {
                    AVMDLLog.d(TAG, "io exception:" + e.getLocalizedMessage() + "for url:" + aVMDLRequest.urls[length]);
                    aVMDLResponseExcute = null;
                }
                if (aVMDLResponseExcute != null && aVMDLResponseExcute.isOpenSuccessful()) {
                    AVMDLLog.d(TAG, "http open suc");
                    setResponse(aVMDLResponseExcute);
                    notifyToNative(0, aVMDLResponseExcute.statusCode, aVMDLResponseExcute.contentlength, null);
                    AVMDLLog.d(TAG, "end http open");
                    aVMDLResponseExcute.request = aVMDLRequest;
                    return aVMDLResponseExcute;
                }
                int[] iArr = aVMDLRequest.mUrlErrCount;
                iArr[length] = iArr[length] + 1;
                if (aVMDLResponseExcute != null && aVMDLResponseExcute.statusCode >= 400 && aVMDLResponseExcute.statusCode < 600) {
                    aVMDLRequest.mUrlState[length] = 1;
                    AVMDLLog.d(TAG, String.format(Locale.US, "set url state forbidden index:%d", Integer.valueOf(length)));
                }
            }
            length = (length + 1) % aVMDLRequest.urls.length;
        } while (length != i);
        AVMDLLog.d(TAG, "end http open");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AVMDLResponse httpRead(AVMDLResponse aVMDLResponse, byte[] bArr) throws IOException {
        int data = aVMDLResponse.readData(bArr);
        if (data > 0) {
            try {
                this.mHandleLock.lock();
                long j = this.mHandle;
                if (j != 0) {
                    _onRecvData(j, bArr, data);
                }
            } finally {
                this.mHandleLock.unlock();
            }
        }
        return aVMDLResponse;
    }

    public void notifyToNative(int i, long j, long j2, String str) {
        AVMDLLog.d(TAG, String.format(Locale.US, "notify type:%d code:%d param:%d ", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)));
        try {
            this.mHandleLock.lock();
            long j3 = this.mHandle;
            if (j3 != 0) {
                _notifyLoadInfo(j3, i, j, j2, str);
            }
        } finally {
            this.mHandleLock.unlock();
        }
    }
}
