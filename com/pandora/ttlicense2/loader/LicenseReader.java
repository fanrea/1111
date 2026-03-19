package com.pandora.ttlicense2.loader;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.pandora.ttlicense2.License;
import com.pandora.ttlicense2.LicenseFile;
import com.pandora.ttlicense2.LicenseLogger;
import com.pandora.ttlicense2.loader.Loader;
import com.pandora.ttlicense2.utils.Asserts;
import com.pandora.ttlicense2.utils.L;
import com.pandora.ttlicense2.utils.Scheme;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LicenseReader {
    private final AssetManager assetManager;
    private final DiskCache diskCache;
    private final Handler handler;
    private final Loader loader;
    private final Map<String, FileReadTask> taskMap;

    public interface Callback {
        void onReadCanceled(Request request);

        void onReadComplete(Request request, Result result);

        void onReadCompleteSync(Request request, Result result);

        void onReadError(Request request, IOException e);

        void onReadProgressChanged(Request request, float progress);

        void onReadStart(Request request);
    }

    public static class Request {
        public final boolean ignoreCache;
        public final Object tag;
        public final boolean uploadLog;
        public final String uri;

        public Request(String uri, boolean ignoreCache, Object tag, boolean uploadLog) {
            this.uri = uri;
            this.ignoreCache = ignoreCache;
            this.tag = tag;
            this.uploadLog = uploadLog;
        }

        public String toString() {
            return "Request{uri='" + this.uri + "', ignoreCache=" + this.ignoreCache + ", uploadLog=" + this.uploadLog + '}';
        }
    }

    public static class Result {
        public final boolean hintCache;
        public final LicenseFile licenseFile;
        public final Request request;

        public Result(Request request, LicenseFile licenseFile, boolean hintCache) {
            this.request = request;
            this.licenseFile = licenseFile;
            this.hintCache = hintCache;
        }

        public String toString() {
            return "Result{hintCache=" + this.hintCache + ", request=" + this.request + ", licenseFile=" + this.licenseFile + '}';
        }
    }

    public LicenseReader(ThreadPoolExecutor executor, DiskCache diskCache, AssetManager assetManager) {
        Looper mainLooper = Looper.getMainLooper();
        this.loader = new Loader(mainLooper, executor);
        this.handler = new Handler(mainLooper);
        this.diskCache = diskCache;
        this.assetManager = assetManager;
        this.taskMap = new LinkedHashMap();
    }

    public void startReadSync(final Request request, final Callback callback) throws JSONException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        final FileReadTask fileReadTask = new FileReadTask(request, this.diskCache, this.assetManager, callback);
        if (callback != null) {
            try {
                run(new Runnable() { // from class: com.pandora.ttlicense2.loader.LicenseReader$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.onReadStart(request);
                    }
                });
            } catch (IOException e) {
                if (callback != null) {
                    run(new Runnable() { // from class: com.pandora.ttlicense2.loader.LicenseReader$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            callback.onReadError(request, e);
                        }
                    });
                    return;
                }
                return;
            }
        }
        fileReadTask.load(null);
        if (callback != null) {
            Asserts.checkNotNull(fileReadTask.result);
            run(new Runnable() { // from class: com.pandora.ttlicense2.loader.LicenseReader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    callback.onReadComplete(request, fileReadTask.result);
                }
            });
        }
    }

    private void run(Runnable runnable) {
        if (this.handler.getLooper() != Looper.myLooper()) {
            this.handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void startReadAsync(Request request, final Callback callback) {
        Asserts.checkThread(this.handler.getLooper());
        FileReadTask fileReadTask = new FileReadTask(request, this.diskCache, this.assetManager, callback);
        this.taskMap.put(request.uri, fileReadTask);
        this.loader.startLoad(fileReadTask, new Loader.Callback<FileReadTask>() { // from class: com.pandora.ttlicense2.loader.LicenseReader.1
            @Override // com.pandora.ttlicense2.loader.Loader.Callback
            public void onLoadStart(FileReadTask loadable) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onReadStart(loadable.request);
                }
            }

            @Override // com.pandora.ttlicense2.loader.Loader.Callback
            public void onLoadProgressChanged(FileReadTask loadable, float progress) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onReadProgressChanged(loadable.request, progress);
                }
            }

            @Override // com.pandora.ttlicense2.loader.Loader.Callback
            public void onLoadComplete(FileReadTask loadable) {
                LicenseReader.this.taskMap.remove(loadable.request.uri);
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onReadComplete(loadable.request, loadable.result);
                }
            }

            @Override // com.pandora.ttlicense2.loader.Loader.Callback
            public void onLoadCanceled(FileReadTask loadable, String reason) {
                LicenseReader.this.taskMap.remove(loadable.request.uri);
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onReadCanceled(loadable.request);
                }
            }

            @Override // com.pandora.ttlicense2.loader.Loader.Callback
            public void onLoadError(FileReadTask loadable, IOException e) {
                LicenseReader.this.taskMap.remove(loadable.request.uri);
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onReadError(loadable.request, e);
                }
            }
        });
    }

    public void cancel(Request request) {
        Asserts.checkThread(this.handler.getLooper());
        cancel(request.uri);
    }

    public void cancel(String path) {
        Asserts.checkThread(this.handler.getLooper());
        FileReadTask fileReadTaskRemove = this.taskMap.remove(path);
        if (fileReadTaskRemove != null) {
            fileReadTaskRemove.cancel(true, true, null);
        }
    }

    public void cancelAll() {
        Asserts.checkThread(this.handler.getLooper());
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, FileReadTask>> it = this.taskMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        this.taskMap.clear();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((FileReadTask) it2.next()).cancel(true, true, null);
        }
    }

    public void release() {
        Asserts.checkThread(this.handler.getLooper());
        this.loader.cancel(true, true, null);
    }

    static class FileReadTask implements Loader.Loadable {
        private final AssetManager assetManager;
        private final Callback callback;
        private volatile boolean canceled;
        private final DiskCache diskCache;
        private final Request request;
        private Result result;

        public FileReadTask(Request request, DiskCache diskCache, AssetManager assetManager, Callback callback) {
            this.request = request;
            this.diskCache = diskCache;
            this.assetManager = assetManager;
            this.callback = callback;
        }

        @Override // com.pandora.ttlicense2.loader.Loader.Loadable
        public void load(Loader.ProgressNotifier notifier) throws JSONException, IllegalAccessException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
            long jNanoTime = System.nanoTime();
            LicenseFile licenseFile = readLicenseFile(this.request.uri);
            L.v(this, "load", Long.valueOf(System.nanoTime() - jNanoTime));
            if (this.request.uploadLog) {
                LicenseLogger.getInstance().upLoadLicenseLog(new License(licenseFile.getContent()));
            }
            LicenseFile cachedLicenseFile = null;
            if (!this.request.ignoreCache && licenseFile.isUpdateAble()) {
                cachedLicenseFile = readCachedLicenseFile(licenseFile.cacheKey());
            }
            if (cachedLicenseFile != null && cachedLicenseFile.getFileVersion() > licenseFile.getFileVersion()) {
                this.result = new Result(this.request, cachedLicenseFile, true);
            } else {
                this.result = new Result(this.request, licenseFile, false);
            }
            Callback callback = this.callback;
            if (callback != null) {
                callback.onReadCompleteSync(this.request, this.result);
            }
        }

        private LicenseFile readCachedLicenseFile(String cacheKey) {
            LicenseFile licenseFile = null;
            if (TextUtils.isEmpty(cacheKey)) {
                return null;
            }
            long jNanoTime = System.nanoTime();
            File file = this.diskCache.get(cacheKey);
            if (file != null && file.exists() && file.length() > 0) {
                String strValueOf = String.valueOf(Uri.fromFile(file));
                if (!TextUtils.isEmpty(strValueOf)) {
                    try {
                        licenseFile = readLicenseFile(strValueOf);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    L.v(this, "loadCache", Long.valueOf(System.nanoTime() - jNanoTime));
                }
            }
            return licenseFile;
        }

        private LicenseFile readLicenseFile(String licenseUri) throws IOException {
            try {
                return LicenseFile.parse(read(licenseUri));
            } catch (Exception e) {
                throw new IOException(e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
        private String read(String uri) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            try {
                try {
                    uri = inputStream(uri);
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = uri.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr, 0, i);
                            }
                            String string = byteArrayOutputStream2.toString("utf-8");
                            if (uri != 0) {
                                try {
                                    uri.close();
                                } catch (IOException unused) {
                                }
                            }
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException unused2) {
                            }
                            return string;
                        } catch (IOException e) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        th = th2;
                        if (uri != 0) {
                            try {
                                uri.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (IOException unused4) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                    uri = 0;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }

        private InputStream inputStream(String uri) throws IOException {
            int i = AnonymousClass2.$SwitchMap$com$pandora$ttlicense2$utils$Scheme[Scheme.ofUri(uri).ordinal()];
            if (i == 1) {
                return new FileInputStream(Uri.parse(uri).getPath());
            }
            if (i == 2) {
                String path = Uri.parse(uri).getPath();
                if (TextUtils.isEmpty(path)) {
                    throw new IOException("Can't parse license real assets path! " + uri);
                }
                if (path.indexOf("/") == 0) {
                    path = path.substring(1);
                }
                return this.assetManager.open(path);
            }
            throw new IllegalArgumentException("Unexpected scheme! " + uri);
        }

        @Override // com.pandora.ttlicense2.loader.Cancelable
        public void cancel(boolean notify, boolean interrupt, String reason) {
            this.canceled = true;
        }

        @Override // com.pandora.ttlicense2.loader.Cancelable
        public boolean isCanceled() {
            return this.canceled;
        }
    }

    /* renamed from: com.pandora.ttlicense2.loader.LicenseReader$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$pandora$ttlicense2$utils$Scheme;

        static {
            int[] iArr = new int[Scheme.values().length];
            $SwitchMap$com$pandora$ttlicense2$utils$Scheme = iArr;
            try {
                iArr[Scheme.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pandora$ttlicense2$utils$Scheme[Scheme.ASSETS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
