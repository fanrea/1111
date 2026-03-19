package com.pandora.ttlicense2.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.pandora.ttlicense2.loader.DiskCache;
import com.pandora.ttlicense2.loader.Loader;
import com.pandora.ttlicense2.utils.Asserts;
import com.pandora.ttlicense2.utils.NetWorkUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LicenseLoader {
    private final Context context;
    private final DiskCache diskCache;
    private final Handler handler;
    private final Loader loader;
    private final Map<String, FileLoadTask> taskMap;

    public interface Callback {
        void onLoadCanceled(Request request);

        void onLoadComplete(Request request, Result result);

        void onLoadError(Request request, IOException e);

        void onLoadProgressChanged(Request request, float progress);

        void onLoadStart(Request request);
    }

    public static class Request {
        public final String backupUri;
        public final String cacheKey;
        public final boolean ignoreCache;
        public final RetryPolicy retryPolicy;
        public final Object tag;
        public final String uri;

        public Request(String cacheKey, boolean ignoreCache, String uri, String backupUri, RetryPolicy retryPolicy, Object tag) {
            this.cacheKey = cacheKey;
            this.ignoreCache = ignoreCache;
            this.uri = uri;
            this.backupUri = backupUri;
            this.retryPolicy = retryPolicy;
            this.tag = tag;
        }

        public String toString() {
            return "Request{cacheKey='" + this.cacheKey + "', url='" + this.uri + "', backupUri='" + this.backupUri + "'}";
        }
    }

    public static class RetryPolicy {
        public final int backupRetryCount;
        public final long backupRetryWaitTime;
        public final int mainRetryCount;
        public final long mainRetryWaitTime;

        public RetryPolicy(int mainRetryCount, long mainRetryWaitTime, int backupRetryCount, long backupRetryWaitTime) {
            this.mainRetryCount = mainRetryCount;
            this.mainRetryWaitTime = mainRetryWaitTime;
            this.backupRetryCount = backupRetryCount;
            this.backupRetryWaitTime = backupRetryWaitTime;
        }
    }

    public static class Result {
        public final boolean hintCache;
        public final String path;
        public final Request request;

        protected Result(String path, Request request, boolean hintCache) {
            this.path = path;
            this.request = request;
            this.hintCache = hintCache;
        }

        public String toString() {
            return "Result{path='" + this.path + "', request=" + this.request + ", hintCache=" + this.hintCache + '}';
        }
    }

    public LicenseLoader(ThreadPoolExecutor netExecutor, DiskCache diskCache, Context context) {
        Looper mainLooper = Looper.getMainLooper();
        this.diskCache = diskCache;
        this.loader = new Loader(mainLooper, netExecutor);
        this.handler = new Handler(mainLooper);
        this.taskMap = new LinkedHashMap();
        this.context = context;
    }

    public boolean isFree() {
        Asserts.checkThread(this.handler.getLooper());
        return this.loader.isFree();
    }

    public void startLoad(Request request, final Callback callback) {
        File file;
        Asserts.checkThread(this.handler.getLooper());
        if (!request.ignoreCache && (file = this.diskCache.get(request.cacheKey)) != null && file.exists()) {
            callback.onLoadStart(request);
            callback.onLoadComplete(request, new Result(file.getAbsolutePath(), request, true));
        } else {
            FileLoadTask fileLoadTask = new FileLoadTask(request, this.diskCache, this.context);
            this.taskMap.put(request.cacheKey, fileLoadTask);
            this.loader.startLoad(fileLoadTask, new Loader.Callback<FileLoadTask>() { // from class: com.pandora.ttlicense2.loader.LicenseLoader.1
                @Override // com.pandora.ttlicense2.loader.Loader.Callback
                public void onLoadStart(FileLoadTask loadable) {
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onLoadStart(loadable.request);
                    }
                }

                @Override // com.pandora.ttlicense2.loader.Loader.Callback
                public void onLoadProgressChanged(FileLoadTask loadable, float progress) {
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onLoadProgressChanged(loadable.request, progress);
                    }
                }

                @Override // com.pandora.ttlicense2.loader.Loader.Callback
                public void onLoadComplete(FileLoadTask loadable) {
                    LicenseLoader.this.taskMap.remove(loadable.request.cacheKey);
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onLoadComplete(loadable.request, loadable.result);
                    }
                }

                @Override // com.pandora.ttlicense2.loader.Loader.Callback
                public void onLoadCanceled(FileLoadTask loadable, String reason) {
                    LicenseLoader.this.taskMap.remove(loadable.request.cacheKey);
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onLoadCanceled(loadable.request);
                    }
                }

                @Override // com.pandora.ttlicense2.loader.Loader.Callback
                public void onLoadError(FileLoadTask loadable, IOException e) {
                    LicenseLoader.this.taskMap.remove(loadable.request.cacheKey);
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onLoadError(loadable.request, e);
                    }
                }
            });
        }
    }

    public void cancel(Request request) {
        Asserts.checkThread(this.handler.getLooper());
        cancel(request.cacheKey);
    }

    public void cancel(String cacheKey) {
        Asserts.checkThread(this.handler.getLooper());
        FileLoadTask fileLoadTaskRemove = this.taskMap.remove(cacheKey);
        if (fileLoadTaskRemove != null) {
            fileLoadTaskRemove.cancel(true, true, null);
        }
    }

    public void cancelAll() {
        Asserts.checkThread(this.handler.getLooper());
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, FileLoadTask>> it = this.taskMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        this.taskMap.clear();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((FileLoadTask) it2.next()).cancel(true, true, null);
        }
    }

    public void release() {
        Asserts.checkThread(this.handler.getLooper());
        this.loader.cancel(true, true, null);
    }

    private static class FileLoadTask implements Loader.Loadable {
        private volatile boolean canceled;
        private final Context context;
        private final DiskCache diskCache;
        private DiskCache.HttpWriter httpWriter;
        private final Request request;
        private Result result;

        public FileLoadTask(Request request, DiskCache diskCache, Context context) {
            this.request = request;
            this.diskCache = diskCache;
            this.context = context;
        }

        @Override // com.pandora.ttlicense2.loader.Loader.Loadable
        public void load(final Loader.ProgressNotifier notifier) throws InterruptedException, IOException {
            File file = this.request.ignoreCache ? null : this.diskCache.get(this.request.cacheKey);
            if (file != null && file.exists()) {
                notifier.notifyProgressChanged(1.0f);
                this.result = new Result(file.getAbsolutePath(), this.request, true);
                return;
            }
            loadWithRetryPolicy(notifier);
            File file2 = this.diskCache.get(this.request.cacheKey);
            if (file2 == null || !file2.exists()) {
                throw new FileNotFoundException("cacheKey = " + this.request.cacheKey);
            }
            this.result = new Result(file2.getAbsolutePath(), this.request, false);
        }

        private void loadWithRetryPolicy(final Loader.ProgressNotifier notifier) throws InterruptedException, IOException {
            DiskCache.HttpWriter httpWriter;
            String str = this.request.uri;
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    synchronized (this) {
                        httpWriter = new DiskCache.HttpWriter(str, new DiskCache.Writer.ProgressListener() { // from class: com.pandora.ttlicense2.loader.LicenseLoader.FileLoadTask.1
                            @Override // com.pandora.ttlicense2.loader.DiskCache.Writer.ProgressListener
                            public void update(long bytesRead, long contentLength, boolean done) {
                                Loader.ProgressNotifier progressNotifier = notifier;
                                if (progressNotifier != null) {
                                    progressNotifier.notifyProgressChanged(bytesRead / contentLength);
                                }
                            }
                        });
                        this.httpWriter = httpWriter;
                    }
                    this.diskCache.put(this.request.cacheKey, httpWriter);
                    return;
                } catch (IOException e) {
                    if (isCanceled()) {
                        throw e;
                    }
                    RetryPolicy retryPolicy = this.request.retryPolicy;
                    if (retryPolicy == null) {
                        throw e;
                    }
                    if (i < retryPolicy.mainRetryCount) {
                        str = this.request.uri;
                        i++;
                        if (!NetWorkUtils.isNetAvailable(this.context)) {
                            Thread.sleep(retryPolicy.mainRetryWaitTime);
                        }
                    } else if (i2 < retryPolicy.backupRetryCount && this.request.backupUri != null) {
                        str = this.request.backupUri;
                        i2++;
                        if (!NetWorkUtils.isNetAvailable(this.context)) {
                            Thread.sleep(retryPolicy.backupRetryWaitTime);
                        }
                    } else {
                        throw e;
                    }
                }
            }
            throw e;
        }

        @Override // com.pandora.ttlicense2.loader.Cancelable
        public void cancel(boolean notify, boolean interrupt, String reason) {
            DiskCache.HttpWriter httpWriter;
            this.canceled = true;
            synchronized (this) {
                httpWriter = this.httpWriter;
            }
            if (httpWriter != null) {
                httpWriter.cancel();
                synchronized (this) {
                    this.httpWriter = null;
                }
            }
        }

        @Override // com.pandora.ttlicense2.loader.Cancelable
        public boolean isCanceled() {
            return this.canceled;
        }
    }
}
