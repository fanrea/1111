package com.fendasz.moku.liulishuo.okdownload;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.core.Util;
import com.fendasz.moku.liulishuo.okdownload.core.cause.EndCause;
import com.fendasz.moku.liulishuo.okdownload.core.listener.DownloadListener2;
import com.fendasz.moku.liulishuo.okdownload.core.listener.DownloadListenerBunch;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DownloadContext {
    private static final Executor SERIAL_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload Serial", false));
    private static final String TAG = "DownloadContext";
    final DownloadContextListener contextListener;
    private final QueueSet set;
    volatile boolean started;
    private final DownloadTask[] tasks;
    private Handler uiHandler;

    DownloadContext(DownloadTask[] downloadTaskArr, DownloadContextListener downloadContextListener, QueueSet queueSet, Handler handler) {
        this(downloadTaskArr, downloadContextListener, queueSet);
        this.uiHandler = handler;
    }

    DownloadContext(DownloadTask[] downloadTaskArr, DownloadContextListener downloadContextListener, QueueSet queueSet) {
        this.started = false;
        this.tasks = downloadTaskArr;
        this.contextListener = downloadContextListener;
        this.set = queueSet;
    }

    public boolean isStarted() {
        return this.started;
    }

    public DownloadTask[] getTasks() {
        return this.tasks;
    }

    public void startOnSerial(DownloadListener downloadListener) {
        start(downloadListener, true);
    }

    public void startOnParallel(DownloadListener downloadListener) {
        start(downloadListener, false);
    }

    public void start(final DownloadListener downloadListener, boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        Util.d(TAG, "start " + z);
        this.started = true;
        if (this.contextListener != null) {
            downloadListener = new DownloadListenerBunch.Builder().append(downloadListener).append(new QueueAttachListener(this, this.contextListener, this.tasks.length)).build();
        }
        if (z) {
            final ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.tasks);
            Collections.sort(arrayList);
            executeOnSerialExecutor(new Runnable() { // from class: com.fendasz.moku.liulishuo.okdownload.DownloadContext.1
                @Override // java.lang.Runnable
                public void run() {
                    for (DownloadTask downloadTask : arrayList) {
                        if (!DownloadContext.this.isStarted()) {
                            DownloadContext.this.callbackQueueEndOnSerialLoop(downloadTask.isAutoCallbackToUIThread());
                            return;
                        }
                        downloadTask.execute(downloadListener);
                    }
                }
            });
        } else {
            DownloadTask.enqueue(this.tasks, downloadListener);
        }
        Util.d(TAG, "start finish " + z + " " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
    }

    public AlterContext alter() {
        return new AlterContext(this);
    }

    public void stop() {
        if (this.started) {
            OkDownload.with().downloadDispatcher().cancel(this.tasks);
        }
        this.started = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackQueueEndOnSerialLoop(boolean z) {
        DownloadContextListener downloadContextListener = this.contextListener;
        if (downloadContextListener == null) {
            return;
        }
        if (z) {
            if (this.uiHandler == null) {
                this.uiHandler = new Handler(Looper.getMainLooper());
            }
            this.uiHandler.post(new Runnable() { // from class: com.fendasz.moku.liulishuo.okdownload.DownloadContext.2
                @Override // java.lang.Runnable
                public void run() {
                    DownloadContext.this.contextListener.queueEnd(DownloadContext.this);
                }
            });
            return;
        }
        downloadContextListener.queueEnd(this);
    }

    void executeOnSerialExecutor(Runnable runnable) {
        SERIAL_EXECUTOR.execute(runnable);
    }

    public Builder toBuilder() {
        return new Builder(this.set, new ArrayList(Arrays.asList(this.tasks))).setListener(this.contextListener);
    }

    public static class Builder {
        final ArrayList<DownloadTask> boundTaskList;
        private DownloadContextListener listener;
        private final QueueSet set;

        public Builder() {
            this(new QueueSet());
        }

        public Builder(QueueSet queueSet) {
            this(queueSet, new ArrayList());
        }

        public Builder(QueueSet queueSet, ArrayList<DownloadTask> arrayList) {
            this.set = queueSet;
            this.boundTaskList = arrayList;
        }

        public Builder setListener(DownloadContextListener downloadContextListener) {
            this.listener = downloadContextListener;
            return this;
        }

        public Builder bindSetTask(DownloadTask downloadTask) {
            int iIndexOf = this.boundTaskList.indexOf(downloadTask);
            if (iIndexOf >= 0) {
                this.boundTaskList.set(iIndexOf, downloadTask);
            } else {
                this.boundTaskList.add(downloadTask);
            }
            return this;
        }

        public DownloadTask bind(String str) {
            if (this.set.uri == null) {
                throw new IllegalArgumentException("If you want to bind only with url, you have to provide parentPath on QueueSet!");
            }
            return bind(new DownloadTask.Builder(str, this.set.uri).setFilenameFromResponse(true));
        }

        public DownloadTask bind(DownloadTask.Builder builder) {
            if (this.set.headerMapFields != null) {
                builder.setHeaderMapFields(this.set.headerMapFields);
            }
            if (this.set.readBufferSize != null) {
                builder.setReadBufferSize(this.set.readBufferSize.intValue());
            }
            if (this.set.flushBufferSize != null) {
                builder.setFlushBufferSize(this.set.flushBufferSize.intValue());
            }
            if (this.set.syncBufferSize != null) {
                builder.setSyncBufferSize(this.set.syncBufferSize.intValue());
            }
            if (this.set.wifiRequired != null) {
                builder.setWifiRequired(this.set.wifiRequired.booleanValue());
            }
            if (this.set.syncBufferIntervalMillis != null) {
                builder.setSyncBufferIntervalMillis(this.set.syncBufferIntervalMillis.intValue());
            }
            if (this.set.autoCallbackToUIThread != null) {
                builder.setAutoCallbackToUIThread(this.set.autoCallbackToUIThread.booleanValue());
            }
            if (this.set.minIntervalMillisCallbackProcess != null) {
                builder.setMinIntervalMillisCallbackProcess(this.set.minIntervalMillisCallbackProcess.intValue());
            }
            if (this.set.passIfAlreadyCompleted != null) {
                builder.setPassIfAlreadyCompleted(this.set.passIfAlreadyCompleted.booleanValue());
            }
            DownloadTask downloadTaskBuild = builder.build();
            if (this.set.tag != null) {
                downloadTaskBuild.setTag(this.set.tag);
            }
            this.boundTaskList.add(downloadTaskBuild);
            return downloadTaskBuild;
        }

        public void unbind(DownloadTask downloadTask) {
            this.boundTaskList.remove(downloadTask);
        }

        public void unbind(int i) {
            for (DownloadTask downloadTask : (List) this.boundTaskList.clone()) {
                if (downloadTask.getId() == i) {
                    this.boundTaskList.remove(downloadTask);
                }
            }
        }

        public DownloadContext build() {
            return new DownloadContext((DownloadTask[]) this.boundTaskList.toArray(new DownloadTask[this.boundTaskList.size()]), this.listener, this.set);
        }
    }

    public static class QueueSet {
        private Boolean autoCallbackToUIThread;
        private Integer flushBufferSize;
        private Map<String, List<String>> headerMapFields;
        private Integer minIntervalMillisCallbackProcess;
        private Boolean passIfAlreadyCompleted;
        private Integer readBufferSize;
        private Integer syncBufferIntervalMillis;
        private Integer syncBufferSize;
        private Object tag;
        private Uri uri;
        private Boolean wifiRequired;

        public Map<String, List<String>> getHeaderMapFields() {
            return this.headerMapFields;
        }

        public void setHeaderMapFields(Map<String, List<String>> map) {
            this.headerMapFields = map;
        }

        public Uri getDirUri() {
            return this.uri;
        }

        public QueueSet setParentPathUri(Uri uri) {
            this.uri = uri;
            return this;
        }

        public QueueSet setParentPathFile(File file) {
            if (file.isFile()) {
                throw new IllegalArgumentException("parent path only accept directory path");
            }
            this.uri = Uri.fromFile(file);
            return this;
        }

        public QueueSet setParentPath(String str) {
            return setParentPathFile(new File(str));
        }

        public int getReadBufferSize() {
            Integer num = this.readBufferSize;
            if (num == null) {
                return 4096;
            }
            return num.intValue();
        }

        public QueueSet setReadBufferSize(int i) {
            this.readBufferSize = Integer.valueOf(i);
            return this;
        }

        public boolean isWifiRequired() {
            Boolean bool = this.wifiRequired;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public QueueSet setWifiRequired(Boolean bool) {
            this.wifiRequired = bool;
            return this;
        }

        public int getFlushBufferSize() {
            Integer num = this.flushBufferSize;
            if (num == null) {
                return 16384;
            }
            return num.intValue();
        }

        public QueueSet setFlushBufferSize(int i) {
            this.flushBufferSize = Integer.valueOf(i);
            return this;
        }

        public int getSyncBufferSize() {
            Integer num = this.syncBufferSize;
            if (num == null) {
                return 65536;
            }
            return num.intValue();
        }

        public QueueSet setSyncBufferSize(int i) {
            this.syncBufferSize = Integer.valueOf(i);
            return this;
        }

        public int getSyncBufferIntervalMillis() {
            Integer num = this.syncBufferIntervalMillis;
            if (num == null) {
                return 2000;
            }
            return num.intValue();
        }

        public QueueSet setSyncBufferIntervalMillis(int i) {
            this.syncBufferIntervalMillis = Integer.valueOf(i);
            return this;
        }

        public boolean isAutoCallbackToUIThread() {
            Boolean bool = this.autoCallbackToUIThread;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public QueueSet setAutoCallbackToUIThread(Boolean bool) {
            this.autoCallbackToUIThread = bool;
            return this;
        }

        public int getMinIntervalMillisCallbackProcess() {
            Integer num = this.minIntervalMillisCallbackProcess;
            if (num == null) {
                return 3000;
            }
            return num.intValue();
        }

        public QueueSet setMinIntervalMillisCallbackProcess(Integer num) {
            this.minIntervalMillisCallbackProcess = num;
            return this;
        }

        public Object getTag() {
            return this.tag;
        }

        public QueueSet setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public boolean isPassIfAlreadyCompleted() {
            Boolean bool = this.passIfAlreadyCompleted;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public QueueSet setPassIfAlreadyCompleted(boolean z) {
            this.passIfAlreadyCompleted = Boolean.valueOf(z);
            return this;
        }

        public Builder commit() {
            return new Builder(this);
        }
    }

    static class QueueAttachListener extends DownloadListener2 {
        private final DownloadContextListener contextListener;
        private final DownloadContext hostContext;
        private final AtomicInteger remainCount;

        @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
        public void taskStart(DownloadTask downloadTask) {
        }

        QueueAttachListener(DownloadContext downloadContext, DownloadContextListener downloadContextListener, int i) {
            this.remainCount = new AtomicInteger(i);
            this.contextListener = downloadContextListener;
            this.hostContext = downloadContext;
        }

        @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
        public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
            int iDecrementAndGet = this.remainCount.decrementAndGet();
            this.contextListener.taskEnd(this.hostContext, downloadTask, endCause, exc, iDecrementAndGet);
            if (iDecrementAndGet <= 0) {
                this.contextListener.queueEnd(this.hostContext);
                Util.d(DownloadContext.TAG, "taskEnd and remainCount " + iDecrementAndGet);
            }
        }
    }

    public static class AlterContext {
        private final DownloadContext context;

        AlterContext(DownloadContext downloadContext) {
            this.context = downloadContext;
        }

        public AlterContext replaceTask(DownloadTask downloadTask, DownloadTask downloadTask2) {
            DownloadTask[] downloadTaskArr = this.context.tasks;
            for (int i = 0; i < downloadTaskArr.length; i++) {
                if (downloadTaskArr[i] == downloadTask) {
                    downloadTaskArr[i] = downloadTask2;
                }
            }
            return this;
        }
    }
}
