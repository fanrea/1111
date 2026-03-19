package com.kwad.sdk.live.audience.net;

import android.text.TextUtils;
import com.kwad.sdk.live.audience.KSLiveInitModule;
import com.kwad.sdk.live.audience.api.KSLiveRequest;
import com.kwad.sdk.live.audience.api.KSLiveResponse;
import com.kwad.sdk.live.audience.listener.KSLiveHttpDelegate;
import com.kwad.sdk.live.audience.test.KSLiveLogger;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveHttpTask<T> implements Runnable {
    private KSLiveJsonParser<T> mJsonParser;
    private Listener<T> mListener;
    private final KSLiveRequest mLiveRequest;

    public interface Listener<T> {
        void onTaskFinished(T t, Throwable th);
    }

    public KSLiveHttpTask(KSLiveRequest kSLiveRequest) {
        this(kSLiveRequest, null);
    }

    public KSLiveHttpTask(KSLiveRequest kSLiveRequest, KSLiveJsonParser<T> kSLiveJsonParser) {
        this.mLiveRequest = kSLiveRequest;
        this.mJsonParser = kSLiveJsonParser;
    }

    public KSLiveHttpTask<T> setListener(Listener<T> listener) {
        this.mListener = listener;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        KSLiveHttpDelegate liveHttpDelegate = KSLiveInitModule.getInstance().getLiveHttpDelegate();
        if (liveHttpDelegate == null) {
            onTaskError("http delegate is null, can't do request");
            return;
        }
        String strSyncHttpRequest = liveHttpDelegate.syncHttpRequest(this.mLiveRequest);
        if (TextUtils.isEmpty(strSyncHttpRequest)) {
            onTaskError("response is empty, unknown error occur during request");
        } else {
            if (this.mListener == null) {
                return;
            }
            try {
                handRequestSuccess(strSyncHttpRequest);
            } catch (JSONException e) {
                onTaskError(e);
            }
        }
    }

    private void handRequestSuccess(String str) {
        KSLiveLogger.i("http task success", "url", this.mLiveRequest.mUrl);
        Listener<T> listener = this.mListener;
        if (listener == null) {
            return;
        }
        if (this.mJsonParser == null) {
            listener.onTaskFinished(null, null);
            return;
        }
        KSLiveResponse<String> fromJson = KSLiveResponse.parseFromJson(str);
        if (fromJson.success()) {
            this.mListener.onTaskFinished(this.mJsonParser.parse(fromJson.body()), null);
        } else {
            this.mListener.onTaskFinished(null, new KSLiveException(fromJson));
        }
    }

    private void onTaskError(String str) {
        onTaskError(new Exception(str));
    }

    private void onTaskError(Throwable th) {
        KSLiveLogger.e("http task fail", "url", this.mLiveRequest.mUrl, th);
        Listener<T> listener = this.mListener;
        if (listener != null) {
            listener.onTaskFinished(null, th);
        }
    }
}
