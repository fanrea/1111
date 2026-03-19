package com.fendasz.moku.liulishuo.okdownload.core.download;

import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.OkDownload;
import com.fendasz.moku.liulishuo.okdownload.core.Util;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore;
import com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection;
import com.fendasz.moku.liulishuo.okdownload.core.dispatcher.CallbackDispatcher;
import com.fendasz.moku.liulishuo.okdownload.core.exception.InterruptException;
import com.fendasz.moku.liulishuo.okdownload.core.file.MultiPointOutputStream;
import com.fendasz.moku.liulishuo.okdownload.core.interceptor.BreakpointInterceptor;
import com.fendasz.moku.liulishuo.okdownload.core.interceptor.FetchDataInterceptor;
import com.fendasz.moku.liulishuo.okdownload.core.interceptor.Interceptor;
import com.fendasz.moku.liulishuo.okdownload.core.interceptor.RetryInterceptor;
import com.fendasz.moku.liulishuo.okdownload.core.interceptor.connect.CallServerInterceptor;
import com.fendasz.moku.liulishuo.okdownload.core.interceptor.connect.HeaderInterceptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DownloadChain implements Runnable {
    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload Cancel Block", false));
    private static final String TAG = "DownloadChain";
    private final int blockIndex;
    private final DownloadCache cache;
    private volatile DownloadConnection connection;
    volatile Thread currentThread;
    private final BreakpointInfo info;
    long noCallbackIncreaseBytes;
    private long responseContentLength;
    private final DownloadStore store;
    private final DownloadTask task;
    final List<Interceptor.Connect> connectInterceptorList = new ArrayList();
    final List<Interceptor.Fetch> fetchInterceptorList = new ArrayList();
    final AtomicBoolean finished = new AtomicBoolean(false);
    int connectIndex = 0;
    int fetchIndex = 0;
    private final Runnable releaseConnectionRunnable = new Runnable() { // from class: com.fendasz.moku.liulishuo.okdownload.core.download.DownloadChain.1
        @Override // java.lang.Runnable
        public void run() {
            DownloadChain.this.releaseConnection();
        }
    };
    private final CallbackDispatcher callbackDispatcher = OkDownload.with().callbackDispatcher();

    private DownloadChain(int i, DownloadTask downloadTask, BreakpointInfo breakpointInfo, DownloadCache downloadCache, DownloadStore downloadStore) {
        this.blockIndex = i;
        this.task = downloadTask;
        this.cache = downloadCache;
        this.info = breakpointInfo;
        this.store = downloadStore;
    }

    static DownloadChain createChain(int i, DownloadTask downloadTask, BreakpointInfo breakpointInfo, DownloadCache downloadCache, DownloadStore downloadStore) {
        return new DownloadChain(i, downloadTask, breakpointInfo, downloadCache, downloadStore);
    }

    public long getResponseContentLength() {
        return this.responseContentLength;
    }

    public void setResponseContentLength(long j) {
        this.responseContentLength = j;
    }

    public void cancel() {
        if (this.finished.get() || this.currentThread == null) {
            return;
        }
        this.currentThread.interrupt();
    }

    public DownloadTask getTask() {
        return this.task;
    }

    public BreakpointInfo getInfo() {
        return this.info;
    }

    public int getBlockIndex() {
        return this.blockIndex;
    }

    public DownloadCache getCache() {
        return this.cache;
    }

    public void setRedirectLocation(String str) {
        this.cache.setRedirectLocation(str);
    }

    public MultiPointOutputStream getOutputStream() {
        return this.cache.getOutputStream();
    }

    public synchronized DownloadConnection getConnection() {
        return this.connection;
    }

    public synchronized void setConnection(DownloadConnection downloadConnection) {
        this.connection = downloadConnection;
    }

    public synchronized DownloadConnection getConnectionOrCreate() throws IOException {
        if (this.cache.isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        if (this.connection == null) {
            String redirectLocation = this.cache.getRedirectLocation();
            if (redirectLocation == null) {
                redirectLocation = this.info.getUrl();
            }
            Util.d(TAG, "create connection on url: " + redirectLocation);
            this.connection = OkDownload.with().connectionFactory().create(redirectLocation);
        }
        return this.connection;
    }

    public void increaseCallbackBytes(long j) {
        this.noCallbackIncreaseBytes += j;
    }

    public void flushNoCallbackIncreaseBytes() {
        if (this.noCallbackIncreaseBytes == 0) {
            return;
        }
        this.callbackDispatcher.dispatch().fetchProgress(this.task, this.blockIndex, this.noCallbackIncreaseBytes);
        this.noCallbackIncreaseBytes = 0L;
    }

    void start() throws IOException {
        CallbackDispatcher callbackDispatcher = OkDownload.with().callbackDispatcher();
        RetryInterceptor retryInterceptor = new RetryInterceptor();
        BreakpointInterceptor breakpointInterceptor = new BreakpointInterceptor();
        this.connectInterceptorList.add(retryInterceptor);
        this.connectInterceptorList.add(breakpointInterceptor);
        this.connectInterceptorList.add(new HeaderInterceptor());
        this.connectInterceptorList.add(new CallServerInterceptor());
        this.connectIndex = 0;
        DownloadConnection.Connected connectedProcessConnect = processConnect();
        if (this.cache.isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        callbackDispatcher.dispatch().fetchStart(this.task, this.blockIndex, getResponseContentLength());
        FetchDataInterceptor fetchDataInterceptor = new FetchDataInterceptor(this.blockIndex, connectedProcessConnect.getInputStream(), getOutputStream(), this.task);
        this.fetchInterceptorList.add(retryInterceptor);
        this.fetchInterceptorList.add(breakpointInterceptor);
        this.fetchInterceptorList.add(fetchDataInterceptor);
        this.fetchIndex = 0;
        callbackDispatcher.dispatch().fetchEnd(this.task, this.blockIndex, processFetch());
    }

    public void resetConnectForRetry() {
        this.connectIndex = 1;
        releaseConnection();
    }

    public synchronized void releaseConnection() {
        if (this.connection != null) {
            this.connection.release();
            Util.d(TAG, "release connection " + this.connection + " task[" + this.task.getId() + "] block[" + this.blockIndex + "]");
        }
        this.connection = null;
    }

    public DownloadConnection.Connected processConnect() throws IOException {
        if (this.cache.isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        List<Interceptor.Connect> list = this.connectInterceptorList;
        int i = this.connectIndex;
        this.connectIndex = i + 1;
        return list.get(i).interceptConnect(this);
    }

    public long processFetch() throws IOException {
        if (this.cache.isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        List<Interceptor.Fetch> list = this.fetchInterceptorList;
        int i = this.fetchIndex;
        this.fetchIndex = i + 1;
        return list.get(i).interceptFetch(this);
    }

    public long loopFetch() throws IOException {
        if (this.fetchIndex == this.fetchInterceptorList.size()) {
            this.fetchIndex--;
        }
        return processFetch();
    }

    boolean isFinished() {
        return this.finished.get();
    }

    public DownloadStore getDownloadStore() {
        return this.store;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isFinished()) {
            throw new IllegalAccessError("The chain has been finished!");
        }
        this.currentThread = Thread.currentThread();
        try {
            start();
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.finished.set(true);
            releaseConnectionAsync();
            throw th;
        }
        this.finished.set(true);
        releaseConnectionAsync();
    }

    void releaseConnectionAsync() {
        EXECUTOR.execute(this.releaseConnectionRunnable);
    }
}
