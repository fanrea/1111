package com.pandora.ttlicense2;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.pandora.ttlicense2.LicenseRetryTrigger;
import com.pandora.ttlicense2.LicenseSession;
import com.pandora.ttlicense2.loader.DiskCache;
import com.pandora.ttlicense2.loader.LicenseLoader;
import com.pandora.ttlicense2.loader.LicenseReader;
import com.pandora.ttlicense2.utils.Asserts;
import com.pandora.ttlicense2.utils.L;
import com.pandora.ttlicense2.utils.NetWorkUtils;
import com.pandora.ttlicense2.utils.Scheme;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class LicenseManager {
    private static LicenseManager sInstance;
    private final Context mContext;
    private final DiskCache mDiskCache;
    private final LicenseLoader mLoader;
    private final LicenseReader mReader;
    private final LicenseRetryTrigger mRetryDetector;
    private final List<LicenseSession> mSessions = new ArrayList();

    public interface Callback {
        void onLicenseLoadError(String licenseUri, Exception e, boolean retryAble);

        void onLicenseLoadRetry(String licenseUri);

        void onLicenseLoadSuccess(String licenseUri, String licenseId);

        void onLicenseUpdateError(String licenseUri, Exception e, boolean retryAble);

        void onLicenseUpdateRetry(String licenseUri);

        void onLicenseUpdateSuccess(String licenseUri, String licenseId);
    }

    public static synchronized void init(Context context) {
        if (sInstance == null) {
            sInstance = new LicenseManager(context.getApplicationContext());
        }
    }

    public static synchronized LicenseManager getInstance() {
        LicenseManager licenseManager;
        licenseManager = sInstance;
        if (licenseManager == null) {
            throw new NullPointerException("Call init first!");
        }
        return licenseManager;
    }

    public static void turnOnLogcat(boolean turnOn) {
        L.ENABLE_LOG = turnOn;
        LicenseManagerNative.openLog(turnOn);
    }

    private LicenseManager(Context context) {
        LicenseLogger.init(context);
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.pandora.ttlicense2.LicenseManager.1
            final AtomicInteger counter = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r) {
                return new Thread(r, "ttsdk-license#" + this.counter.getAndIncrement());
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        File file = new File(context.getFilesDir(), "ttsdk/licenses");
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mContext = context;
        DiskCache diskCache = new DiskCache(file);
        this.mDiskCache = diskCache;
        this.mLoader = new LicenseLoader(threadPoolExecutor, diskCache, context);
        this.mReader = new LicenseReader(threadPoolExecutor2, diskCache, context.getAssets());
        LicenseManagerNative.init(context.getPackageName());
        LicenseManagerNative.setAuthParams();
        LicenseRetryTrigger licenseRetryTrigger = new LicenseRetryTrigger(new LicenseRetryTrigger.LicenseRetryListener() { // from class: com.pandora.ttlicense2.LicenseManager.2
            @Override // com.pandora.ttlicense2.LicenseRetryTrigger.LicenseRetryListener
            public void onNetworkConnectionChanged(NetworkInfo networkInfo) {
                L.v(this, "onNetworkConnectionChanged", L.string(networkInfo));
                LicenseManager.this.scheduleRetry();
            }

            @Override // com.pandora.ttlicense2.LicenseRetryTrigger.LicenseRetryListener
            public void onActivityResumed() {
                L.v(this, "onActivityResumed", new Object[0]);
                LicenseManager.this.scheduleRetry();
            }
        });
        this.mRetryDetector = licenseRetryTrigger;
        licenseRetryTrigger.init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleRetry() {
        if (NetWorkUtils.isNetAvailableOptANR(this.mContext)) {
            synchronized (this.mSessions) {
                if (this.mSessions.isEmpty()) {
                    return;
                }
                for (LicenseSession licenseSession : new ArrayList(this.mSessions)) {
                    L.v(this, "scheduleRetry", licenseSession, L.string(licenseSession));
                    licenseSession.retry();
                }
            }
        }
    }

    public String getSDKEdition(String sdkName) {
        return LicenseManagerNative.getSDKEdition(sdkName);
    }

    public int checkSDKAuth(String sdkName) {
        return LicenseManagerNative.checkSDKAuth(sdkName);
    }

    public int checkFeatureAuth(String sdkName, String featureName) {
        return LicenseManagerNative.checkFeatureAuth(sdkName, featureName);
    }

    public void addLicense(final String licenseUri, final Callback callback) {
        L.d(this, "addLicense", licenseUri, callback);
        Asserts.checkNotNull(licenseUri);
        if (Scheme.ofUri(licenseUri) == Scheme.UNKNOWN) {
            throw new IllegalArgumentException("Unsupported uri type! " + licenseUri);
        }
        synchronized (this.mSessions) {
            if (find(licenseUri) != null) {
                L.d(this, "addLicense", "already added!", licenseUri, callback);
                return;
            }
            LicenseSession licenseSessionCreate = create(licenseUri, callback);
            this.mSessions.add(licenseSessionCreate);
            licenseSessionCreate.start();
        }
    }

    public License getLicense(String licenseId) {
        return LicenseManagerNative.getLicense(licenseId);
    }

    public List<String> getLoadedLicenseIds() {
        LicenseReader.Result result;
        LicenseFile licenseFile;
        ArrayList arrayList = new ArrayList();
        synchronized (this.mSessions) {
            for (LicenseSession licenseSession : this.mSessions) {
                if (licenseSession.mReadState == 2 && (result = licenseSession.mReadResult) != null && (licenseFile = result.licenseFile) != null) {
                    String id = licenseFile.getId();
                    if (!TextUtils.isEmpty(id)) {
                        arrayList.add(id);
                    }
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private LicenseSession create(final String licenseUri, final Callback callback) {
        Asserts.checkState(Thread.holdsLock(this.mSessions), "mSessions lock not hold!");
        return new LicenseSession(licenseUri, Scheme.ofUri(licenseUri), this.mLoader, this.mReader, new LicenseSession.LicenseSessionListener() { // from class: com.pandora.ttlicense2.LicenseManager.3
            @Override // com.pandora.ttlicense2.LicenseSession.LicenseSessionListener
            public void onLicenseSuccessSync(LicenseFile licenseFile) {
                LicenseManagerNative.addLicense(licenseFile);
            }

            @Override // com.pandora.ttlicense2.LicenseSession.LicenseSessionListener
            public void onLicenseSuccess(LicenseFile licenseFile) {
                L.d(LicenseManager.this, "onLicenseSuccess", licenseUri, licenseFile, L.string(licenseFile));
                Asserts.checkMainThread();
                LicenseLogger.getInstance().eventListener().onLicenseAddSuccess(licenseFile.getId());
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onLicenseLoadSuccess(licenseUri, licenseFile.getId());
                }
            }

            @Override // com.pandora.ttlicense2.LicenseSession.LicenseSessionListener
            public void onLicenseError(Exception e, boolean retryAble) {
                L.d(LicenseManager.this, "onLicenseError", e, licenseUri, "retryAble", Boolean.valueOf(retryAble));
                Asserts.checkMainThread();
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onLicenseLoadError(licenseUri, e, retryAble);
                }
            }

            @Override // com.pandora.ttlicense2.LicenseSession.LicenseSessionListener
            public void onLicenseRetry() {
                L.d(LicenseManager.this, "onLicenseRetry", new Object[0]);
                Asserts.checkMainThread();
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onLicenseLoadRetry(licenseUri);
                }
            }

            @Override // com.pandora.ttlicense2.LicenseSession.LicenseSessionListener
            public void onLicenseUpdateSuccessSync(LicenseFile licenseFile) {
                LicenseManagerNative.addLicense(licenseFile);
            }

            @Override // com.pandora.ttlicense2.LicenseSession.LicenseSessionListener
            public void onLicenseUpdateSuccess(LicenseFile licenseFile) {
                L.d(LicenseManager.this, "onLicenseUpdateSuccess", licenseUri, licenseFile, L.string(licenseFile));
                Asserts.checkMainThread();
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onLicenseUpdateSuccess(licenseUri, licenseFile.getId());
                }
            }

            @Override // com.pandora.ttlicense2.LicenseSession.LicenseSessionListener
            public void onLicenseUpdateError(Exception e, boolean retryAble) {
                L.d(LicenseManager.this, "onLicenseUpdateError", e, licenseUri, "retryAble", Boolean.valueOf(retryAble));
                Asserts.checkMainThread();
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onLicenseUpdateError(licenseUri, e, retryAble);
                }
            }

            @Override // com.pandora.ttlicense2.LicenseSession.LicenseSessionListener
            public void onLicenseUpdateRetry() {
                L.d(LicenseManager.this, "onLicenseUpdateRetry", new Object[0]);
                Asserts.checkMainThread();
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onLicenseUpdateRetry(licenseUri);
                }
            }
        });
    }

    private LicenseSession find(String licenseUri) {
        Asserts.checkState(Thread.holdsLock(this.mSessions), "mSessions lock not hold!");
        for (LicenseSession licenseSession : this.mSessions) {
            if (TextUtils.equals(licenseSession.mLicenseUri, licenseUri)) {
                return licenseSession;
            }
        }
        return null;
    }
}
