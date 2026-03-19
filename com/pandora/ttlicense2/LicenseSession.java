package com.pandora.ttlicense2;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.pandora.ttlicense2.loader.LicenseLoader;
import com.pandora.ttlicense2.loader.LicenseReader;
import com.pandora.ttlicense2.utils.Asserts;
import com.pandora.ttlicense2.utils.L;
import com.pandora.ttlicense2.utils.Scheme;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class LicenseSession {
    static final int STATE_CANCELED = 4;
    static final int STATE_COMPLETED = 2;
    static final int STATE_ERROR = 3;
    static final int STATE_IDLE = 0;
    static final int STATE_STARTED = 1;
    final String mLicenseUri;
    LicenseSessionListener mListener;
    Exception mLoadException;
    LicenseLoader.Request mLoadRequest;
    LicenseLoader.Result mLoadResult;
    final LicenseLoader mLoader;
    Exception mReadException;
    LicenseReader.Request mReadRequest;
    LicenseReader.Result mReadResult;
    final LicenseReader mReader;
    int mRetryCount;
    final Scheme mScheme;
    int mSessionState;
    Exception mUpdateLoadException;
    LicenseLoader.Request mUpdateLoadRequest;
    LicenseLoader.Result mUpdateLoadResult;
    Exception mUpdateReadException;
    LicenseReader.Request mUpdateReadRequest;
    LicenseReader.Result mUpdateReadResult;
    int mLoadState = 0;
    int mReadState = 0;
    int mUpdateLoadState = 0;
    int mUpdateReadState = 0;
    final Handler mH = new Handler(Looper.getMainLooper());

    interface LicenseSessionListener {
        void onLicenseError(Exception e, boolean retryAble);

        void onLicenseRetry();

        void onLicenseSuccess(LicenseFile licenseFile);

        void onLicenseSuccessSync(LicenseFile licenseFile);

        void onLicenseUpdateError(Exception e, boolean retryAble);

        void onLicenseUpdateRetry();

        void onLicenseUpdateSuccess(LicenseFile licenseFile);

        void onLicenseUpdateSuccessSync(LicenseFile licenseFile);
    }

    static String mapState(int state) {
        if (state == 0) {
            return "idle";
        }
        if (state == 1) {
            return "started";
        }
        if (state == 2) {
            return "completed";
        }
        if (state == 3) {
            return "error";
        }
        if (state == 4) {
            return "canceled";
        }
        throw new IllegalArgumentException("Unsupported state: " + state);
    }

    LicenseSession(String licenseUri, Scheme scheme, LicenseLoader loader, LicenseReader reader, LicenseSessionListener listener) {
        this.mLicenseUri = (String) Asserts.checkNotNull(licenseUri);
        this.mScheme = (Scheme) Asserts.checkNotNull(scheme);
        this.mLoader = (LicenseLoader) Asserts.checkNotNull(loader);
        this.mReader = (LicenseReader) Asserts.checkNotNull(reader);
        this.mListener = (LicenseSessionListener) Asserts.checkNotNull(listener);
    }

    /* renamed from: com.pandora.ttlicense2.LicenseSession$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
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
            try {
                $SwitchMap$com$pandora$ttlicense2$utils$Scheme[Scheme.HTTP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pandora$ttlicense2$utils$Scheme[Scheme.HTTPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$pandora$ttlicense2$utils$Scheme[Scheme.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    void start() throws JSONException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i = AnonymousClass4.$SwitchMap$com$pandora$ttlicense2$utils$Scheme[this.mScheme.ordinal()];
        if (i == 1 || i == 2) {
            startReadOfflineLicense();
        } else if (i == 3 || i == 4) {
            startLoadOnLineLicense();
        } else if (i == 5) {
            throw new IllegalArgumentException("Unsupported uri type! " + this.mLicenseUri);
        }
    }

    void retry() {
        Asserts.checkMainThread();
        int i = AnonymousClass4.$SwitchMap$com$pandora$ttlicense2$utils$Scheme[this.mScheme.ordinal()];
        if (i == 1 || i == 2) {
            retryWithReadState();
        } else {
            if (i == 3 || i == 4) {
                retryWithLoadState();
                return;
            }
            throw new IllegalArgumentException("Unsupported scheme: " + this.mLicenseUri);
        }
    }

    public String toString() {
        return "LicenseSession{mScheme=" + this.mScheme + ", mLicenseUri='" + this.mLicenseUri + "', mLoadState=" + mapState(this.mLoadState) + ", mReadState=" + mapState(this.mReadState) + ", mUpdateLoadState=" + mapState(this.mUpdateLoadState) + ", mUpdateReadState=" + mapState(this.mUpdateReadState) + ", mRetryCount=" + this.mRetryCount + '}';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUpdateAble() {
        LicenseReader.Result result = this.mReadResult;
        if (result == null || result.licenseFile == null) {
            return false;
        }
        return this.mReadResult.licenseFile.isUpdateAble();
    }

    private void resetLoadResult() {
        this.mLoadResult = null;
        this.mLoadException = null;
        this.mLoadState = 0;
    }

    private void resetUpdateLoadResult() {
        this.mUpdateLoadResult = null;
        this.mUpdateLoadException = null;
        this.mUpdateLoadState = 0;
    }

    private void retryWithLoadState() {
        int i = this.mLoadState;
        if (i == 0 || i == 1) {
            return;
        }
        if (i == 2) {
            retryWithReadState();
            return;
        }
        if (i != 3) {
            if (i == 4) {
                throw new IllegalStateException(this.mScheme + " load " + mapState(this.mLoadState));
            }
            throw new IllegalArgumentException("Unsupported state");
        }
        int i2 = this.mRetryCount;
        if (i2 < 10) {
            resetLoadResult();
            this.mRetryCount++;
            LicenseSessionListener licenseSessionListener = this.mListener;
            if (licenseSessionListener != null) {
                licenseSessionListener.onLicenseRetry();
            }
            startLoad();
            return;
        }
        L.e(this, "retryWithLoadState", "error", "load max retry error!", Integer.valueOf(i2));
    }

    private void retryWithReadState() {
        int i = this.mReadState;
        if (i == 0 || i == 1) {
            return;
        }
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    throw new IllegalStateException(this.mScheme + " read " + mapState(this.mReadState));
                }
                throw new IllegalArgumentException("Unsupported state");
            }
            return;
        }
        if (this.mScheme == Scheme.FILE || this.mScheme == Scheme.ASSETS) {
            if (isUpdateAble()) {
                retryWithUpdateLoadState();
            }
        } else {
            if (this.mScheme == Scheme.HTTP || this.mScheme == Scheme.HTTPS) {
                Asserts.checkNotNull(this.mLoadResult);
                if (this.mLoadResult.hintCache) {
                    retryWithUpdateLoadState();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Unsupported scheme: " + this.mLicenseUri);
        }
    }

    private void retryWithUpdateLoadState() {
        int i = this.mUpdateLoadState;
        if (i == 0 || i == 1 || i == 2) {
            return;
        }
        if (i != 3) {
            if (i == 4) {
                throw new IllegalStateException(this.mScheme + " updateLoad " + mapState(this.mUpdateLoadState));
            }
            throw new IllegalArgumentException("Unsupported state");
        }
        int i2 = this.mRetryCount;
        if (i2 < 10) {
            resetUpdateLoadResult();
            this.mRetryCount++;
            LicenseSessionListener licenseSessionListener = this.mListener;
            if (licenseSessionListener != null) {
                licenseSessionListener.onLicenseUpdateRetry();
            }
            startUpdateLoad();
            return;
        }
        L.e(this, "retryWithUpdateLoadState", "error", "update max retry error!", Integer.valueOf(i2));
    }

    private void startLoadOnLineLicense() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            startLoad();
        } else {
            this.mH.post(new Runnable() { // from class: com.pandora.ttlicense2.LicenseSession$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.startLoad();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        Asserts.checkMainThread();
        LicenseLoader.RetryPolicy retryPolicy = new LicenseLoader.RetryPolicy(5, 1000L, 3, 1000L);
        String str = this.mLicenseUri;
        LicenseLoader.Request request = new LicenseLoader.Request(str, false, str, null, retryPolicy, this);
        this.mLoadRequest = request;
        this.mLoader.startLoad(request, new LicenseLoader.Callback() { // from class: com.pandora.ttlicense2.LicenseSession.1
            @Override // com.pandora.ttlicense2.loader.LicenseLoader.Callback
            public void onLoadProgressChanged(LicenseLoader.Request request2, float progress) {
            }

            @Override // com.pandora.ttlicense2.loader.LicenseLoader.Callback
            public void onLoadStart(LicenseLoader.Request request2) {
                L.v(LicenseSession.this, "startLoad", "onLoadStart", request2, request2.uri);
                Asserts.checkMainThread();
                LicenseSession.this.mLoadState = 1;
            }

            @Override // com.pandora.ttlicense2.loader.LicenseLoader.Callback
            public void onLoadComplete(LicenseLoader.Request request2, LicenseLoader.Result result) {
                L.v(LicenseSession.this, "startLoad", "onLoadComplete", request2, request2.uri, L.string(result));
                Asserts.checkMainThread();
                LicenseSession.this.mLoadResult = result;
                LicenseSession.this.mLoadState = 2;
                LicenseSession.this.mReadRequest = new LicenseReader.Request(Uri.fromFile(new File(result.path)).toString(), true, request2, false);
                LicenseSession.this.mReader.startReadAsync(LicenseSession.this.mReadRequest, new LicenseReader.Callback() { // from class: com.pandora.ttlicense2.LicenseSession.1.1
                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadProgressChanged(LicenseReader.Request request3, float progress) {
                    }

                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadStart(LicenseReader.Request request3) {
                        L.v(LicenseSession.this, "startRead", "onReadStart", request3, request3.uri);
                        Asserts.checkMainThread();
                        LicenseSession.this.mReadState = 1;
                    }

                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadCompleteSync(LicenseReader.Request request3, LicenseReader.Result result2) {
                        L.v(LicenseSession.this, "startRead", "onReadCompleteSync", request3, request3.uri);
                        LicenseSession.this.mListener.onLicenseSuccessSync(result2.licenseFile);
                    }

                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadComplete(LicenseReader.Request request3, LicenseReader.Result result2) {
                        L.v(LicenseSession.this, "startRead", "onReadComplete", request3, request3.uri, L.string(result2));
                        Asserts.checkMainThread();
                        LicenseSession.this.mReadResult = result2;
                        LicenseSession.this.mReadState = 2;
                        LicenseSession.this.mListener.onLicenseSuccess(result2.licenseFile);
                        if (LicenseSession.this.isUpdateAble()) {
                            if (LicenseSession.this.mScheme == Scheme.HTTP || LicenseSession.this.mScheme == Scheme.HTTPS) {
                                Asserts.checkNotNull(LicenseSession.this.mLoadResult);
                                if (LicenseSession.this.mLoadResult.hintCache) {
                                    LicenseSession.this.startUpdateLoad();
                                    return;
                                }
                                return;
                            }
                            throw new IllegalArgumentException("Unsupported scheme: " + LicenseSession.this.mLicenseUri);
                        }
                    }

                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadCanceled(LicenseReader.Request request3) {
                        L.v(LicenseSession.this, "startRead", "onReadCanceled", request3, request3.uri);
                        Asserts.checkMainThread();
                        LicenseSession.this.mReadState = 4;
                    }

                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadError(LicenseReader.Request request3, IOException e) {
                        L.v(LicenseSession.this, "startRead", e, "onReadError", request3, request3.uri);
                        Asserts.checkMainThread();
                        LicenseSession.this.mReadException = e;
                        LicenseSession.this.mReadState = 3;
                        if (LicenseSession.this.mListener != null) {
                            LicenseSession.this.mListener.onLicenseError(e, false);
                        }
                    }
                });
            }

            @Override // com.pandora.ttlicense2.loader.LicenseLoader.Callback
            public void onLoadCanceled(LicenseLoader.Request request2) {
                L.v(LicenseSession.this, "startLoad", "onLoadCanceled", request2, request2.uri);
                Asserts.checkMainThread();
                LicenseSession.this.mLoadState = 4;
            }

            @Override // com.pandora.ttlicense2.loader.LicenseLoader.Callback
            public void onLoadError(LicenseLoader.Request request2, IOException e) {
                L.v(LicenseSession.this, "startLoad", e, "onLoadError", request2, request2.uri);
                Asserts.checkMainThread();
                LicenseSession.this.mLoadException = e;
                LicenseSession.this.mLoadState = 3;
                if (LicenseSession.this.mListener != null) {
                    LicenseSession.this.mListener.onLicenseError(e, LicenseSession.this.mRetryCount < 10);
                }
            }
        });
    }

    private void startReadOfflineLicense() throws JSONException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        LicenseReader.Request request = new LicenseReader.Request(this.mLicenseUri, false, this, true);
        this.mReadRequest = request;
        this.mReader.startReadSync(request, new LicenseReader.Callback() { // from class: com.pandora.ttlicense2.LicenseSession.2
            @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
            public void onReadProgressChanged(LicenseReader.Request request2, float progress) {
            }

            @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
            public void onReadStart(LicenseReader.Request request2) {
                L.v(LicenseSession.this, "startRead", "onReadStart", request2, request2.uri);
                Asserts.checkMainThread();
                LicenseSession.this.mReadState = 1;
            }

            @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
            public void onReadCompleteSync(LicenseReader.Request request2, LicenseReader.Result result) {
                L.v(LicenseSession.this, "startRead", "onReadCompleteSync", request2, request2.uri);
                LicenseSession.this.mListener.onLicenseSuccessSync(result.licenseFile);
            }

            @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
            public void onReadComplete(LicenseReader.Request request2, LicenseReader.Result result) {
                L.v(LicenseSession.this, "startRead", "onReadComplete", request2, request2.uri, L.string(result));
                Asserts.checkMainThread();
                LicenseSession.this.mReadResult = result;
                LicenseSession.this.mReadState = 2;
                LicenseSession.this.mListener.onLicenseSuccess(result.licenseFile);
                if (LicenseSession.this.isUpdateAble()) {
                    if (LicenseSession.this.mScheme == Scheme.FILE || LicenseSession.this.mScheme == Scheme.ASSETS) {
                        LicenseSession.this.startUpdateLoad();
                        return;
                    }
                    throw new IllegalArgumentException("Unsupported scheme: " + LicenseSession.this.mLicenseUri);
                }
            }

            @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
            public void onReadCanceled(LicenseReader.Request request2) {
                L.v(LicenseSession.this, "startRead", "onReadCanceled", request2, request2.uri);
                Asserts.checkMainThread();
                LicenseSession.this.mReadState = 4;
            }

            @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
            public void onReadError(LicenseReader.Request request2, IOException e) {
                L.v(LicenseSession.this, "startRead", e, "onReadError", request2, request2.uri);
                Asserts.checkMainThread();
                LicenseSession.this.mReadException = e;
                LicenseSession.this.mReadState = 3;
                if (LicenseSession.this.mListener != null) {
                    LicenseSession.this.mListener.onLicenseError(e, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdateLoad() {
        Asserts.checkMainThread();
        Asserts.checkNotNull(this.mReadResult);
        Asserts.checkNotNull(this.mReadResult.licenseFile);
        LicenseLoader.Request request = new LicenseLoader.Request(this.mReadResult.licenseFile.cacheKey(), true, this.mReadResult.licenseFile.getMainUrl(), this.mReadResult.licenseFile.getBackupUrl(), new LicenseLoader.RetryPolicy(5, 1000L, 3, 1000L), this);
        this.mUpdateLoadRequest = request;
        this.mLoader.startLoad(request, new LicenseLoader.Callback() { // from class: com.pandora.ttlicense2.LicenseSession.3
            @Override // com.pandora.ttlicense2.loader.LicenseLoader.Callback
            public void onLoadProgressChanged(LicenseLoader.Request request2, float progress) {
            }

            @Override // com.pandora.ttlicense2.loader.LicenseLoader.Callback
            public void onLoadStart(LicenseLoader.Request request2) {
                L.v(LicenseSession.this, "startUpdateLoad", "onLoadStart", request2, request2.uri);
                Asserts.checkMainThread();
                LicenseSession.this.mUpdateLoadState = 1;
            }

            @Override // com.pandora.ttlicense2.loader.LicenseLoader.Callback
            public void onLoadComplete(LicenseLoader.Request request2, LicenseLoader.Result result) {
                L.v(LicenseSession.this, "startUpdateLoad", "onLoadComplete", request2, request2.uri, L.string(result));
                Asserts.checkMainThread();
                LicenseSession.this.mUpdateLoadResult = result;
                LicenseSession.this.mUpdateLoadState = 2;
                LicenseSession.this.mUpdateReadRequest = new LicenseReader.Request(Uri.fromFile(new File(result.path)).toString(), true, request2, false);
                LicenseSession.this.mReader.startReadAsync(LicenseSession.this.mUpdateReadRequest, new LicenseReader.Callback() { // from class: com.pandora.ttlicense2.LicenseSession.3.1
                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadProgressChanged(LicenseReader.Request request3, float progress) {
                    }

                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadStart(LicenseReader.Request request3) {
                        L.v(LicenseSession.this, "startUpdateRead", "onReadStart", request3, request3.uri);
                        Asserts.checkMainThread();
                        LicenseSession.this.mUpdateReadState = 1;
                    }

                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadCompleteSync(LicenseReader.Request request3, LicenseReader.Result result2) {
                        L.v(LicenseSession.this, "startUpdateRead", "onReadCompleteSync", request3, request3.uri, L.string(result2));
                        LicenseSession.this.mListener.onLicenseUpdateSuccessSync(result2.licenseFile);
                    }

                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadComplete(LicenseReader.Request request3, LicenseReader.Result result2) {
                        L.v(LicenseSession.this, "startUpdateRead", "onReadComplete", request3, request3.uri, L.string(result2));
                        Asserts.checkMainThread();
                        LicenseSession.this.mUpdateReadResult = result2;
                        LicenseSession.this.mUpdateReadState = 2;
                        if (LicenseSession.this.mListener != null) {
                            LicenseSession.this.mListener.onLicenseUpdateSuccess(result2.licenseFile);
                        }
                    }

                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadCanceled(LicenseReader.Request request3) {
                        L.v(LicenseSession.this, "startUpdateRead", "onReadCanceled", request3, request3.uri);
                        Asserts.checkMainThread();
                        LicenseSession.this.mUpdateReadState = 4;
                    }

                    @Override // com.pandora.ttlicense2.loader.LicenseReader.Callback
                    public void onReadError(LicenseReader.Request request3, IOException e) {
                        L.v(LicenseSession.this, "startUpdateRead", e, "onReadError", request3, request3.uri);
                        Asserts.checkMainThread();
                        LicenseSession.this.mUpdateReadException = e;
                        LicenseSession.this.mUpdateReadState = 3;
                        if (LicenseSession.this.mListener != null) {
                            LicenseSession.this.mListener.onLicenseUpdateError(e, false);
                        }
                    }
                });
            }

            @Override // com.pandora.ttlicense2.loader.LicenseLoader.Callback
            public void onLoadCanceled(LicenseLoader.Request request2) {
                L.v(LicenseSession.this, "startUpdateLoad", "onLoadCanceled", request2, request2.uri);
                Asserts.checkMainThread();
                LicenseSession.this.mUpdateLoadState = 4;
            }

            @Override // com.pandora.ttlicense2.loader.LicenseLoader.Callback
            public void onLoadError(LicenseLoader.Request request2, IOException e) {
                L.v(LicenseSession.this, "startUpdateLoad", e, "onLoadError", request2, request2.uri);
                Asserts.checkMainThread();
                LicenseSession.this.mUpdateLoadException = e;
                LicenseSession.this.mUpdateLoadState = 3;
                if (LicenseSession.this.mListener != null) {
                    LicenseSession.this.mListener.onLicenseUpdateError(e, LicenseSession.this.mRetryCount < 10);
                }
            }
        });
    }
}
