package aegon.chrome.net.impl;

import aegon.chrome.net.ExperimentalUrlRequest;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UrlRequest;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class UrlRequestBuilderImpl extends ExperimentalUrlRequest.Builder {
    private static final String ACCEPT_ENCODING = "Accept-Encoding";
    private static final String TAG = "UrlRequestBuilderImpl";
    private boolean mAllowDirectExecutor;
    private final UrlRequest.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private boolean mDisableCache;
    private boolean mDisableConnectionMigration;
    private final Executor mExecutor;
    private String mMethod;
    private Collection<Object> mRequestAnnotations;
    private RequestFinishedInfo.Listener mRequestFinishedListener;
    private int mTrafficStatsTag;
    private boolean mTrafficStatsTagSet;
    private int mTrafficStatsUid;
    private boolean mTrafficStatsUidSet;
    private UploadDataProvider mUploadDataProvider;
    private Executor mUploadDataProviderExecutor;
    private final String mUrl;
    private final ArrayList<Pair<String, String>> mRequestHeaders = new ArrayList<>();
    private int mPriority = 3;

    UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor, CronetEngineBase cronetEngineBase) {
        if (str == null) {
            throw new NullPointerException("URL is required.");
        }
        if (callback == null) {
            throw new NullPointerException("Callback is required.");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required.");
        }
        if (cronetEngineBase == null) {
            throw new NullPointerException("CronetEngine is required.");
        }
        this.mUrl = str;
        this.mCallback = callback;
        this.mExecutor = executor;
        this.mCronetEngine = cronetEngineBase;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder, aegon.chrome.net.UrlRequest.Builder
    public ExperimentalUrlRequest.Builder setHttpMethod(String str) {
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.mMethod = str;
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder, aegon.chrome.net.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        if (ACCEPT_ENCODING.equalsIgnoreCase(str)) {
            Log.w(TAG, "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            return this;
        }
        this.mRequestHeaders.add(Pair.create(str, str2));
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder, aegon.chrome.net.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.mDisableCache = true;
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl disableConnectionMigration() {
        this.mDisableConnectionMigration = true;
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder, aegon.chrome.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int i) {
        this.mPriority = i;
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder, aegon.chrome.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (executor == null) {
            throw new NullPointerException("Invalid UploadDataProvider Executor.");
        }
        if (this.mMethod == null) {
            this.mMethod = "POST";
        }
        this.mUploadDataProvider = uploadDataProvider;
        this.mUploadDataProviderExecutor = executor;
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder, aegon.chrome.net.UrlRequest.Builder
    public UrlRequestBuilderImpl allowDirectExecutor() {
        this.mAllowDirectExecutor = true;
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl addRequestAnnotation(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Invalid metrics annotation.");
        }
        if (this.mRequestAnnotations == null) {
            this.mRequestAnnotations = new ArrayList();
        }
        this.mRequestAnnotations.add(obj);
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setTrafficStatsTag(int i) {
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = i;
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setTrafficStatsUid(int i) {
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = i;
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setRequestFinishedListener(RequestFinishedInfo.Listener listener) {
        this.mRequestFinishedListener = listener;
        return this;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder, aegon.chrome.net.UrlRequest.Builder
    public UrlRequestBase build() {
        UrlRequestBase urlRequestBaseCreateRequest = this.mCronetEngine.createRequest(this.mUrl, this.mCallback, this.mExecutor, this.mPriority, this.mRequestAnnotations, this.mDisableCache, this.mDisableConnectionMigration, this.mAllowDirectExecutor, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mRequestFinishedListener);
        String str = this.mMethod;
        if (str != null) {
            urlRequestBaseCreateRequest.setHttpMethod(str);
        }
        Iterator<Pair<String, String>> it = this.mRequestHeaders.iterator();
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            urlRequestBaseCreateRequest.addHeader((String) next.first, (String) next.second);
        }
        UploadDataProvider uploadDataProvider = this.mUploadDataProvider;
        if (uploadDataProvider != null) {
            urlRequestBaseCreateRequest.setUploadDataProvider(uploadDataProvider, this.mUploadDataProviderExecutor);
        }
        return urlRequestBaseCreateRequest;
    }
}
