package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.Cache;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.aj;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.windad.WindAdRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends SigmobRequest<NetworkResponse> {
    private final a a;

    public interface a extends Response.ErrorListener {
        void a(NetworkResponse response);
    }

    public b(String url, int ConnectTimeoutMs, a listener) {
        super(url, 0, listener);
        this.a = listener;
        setShouldRetryServerErrors(true);
        setRetryPolicy(new DefaultRetryPolicy(ConnectTimeoutMs, 5000, 0, 0.0f));
        setShouldCache(false);
    }

    public b(String url, a mListener) {
        this(url, 5000, mListener);
    }

    public static void a(final String trackingUrl, final String tracking_type, WindAdRequest adRequest, final NetworkResponse response, final String request_id) {
        aj.a(PointCategory.HB_TRACKING).a(adRequest).a(new ac.a() { // from class: com.sigmob.sdk.base.network.b$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                b.a(trackingUrl, tracking_type, request_id, response, obj);
            }
        }).a();
    }

    public static void a(final String trackingUrl, final String trackingType, final WindAdRequest adRequest, final String requestId) {
        if (TextUtils.isEmpty(trackingUrl)) {
            return;
        }
        b bVar = new b(trackingUrl, new a() { // from class: com.sigmob.sdk.base.network.b.1
            @Override // com.sigmob.sdk.base.network.b.a
            public void a(NetworkResponse response) {
                b.a(trackingUrl, trackingType, adRequest, response, requestId);
            }

            public void onErrorResponse(VolleyError error) {
                b.a(trackingUrl, trackingType, adRequest, error != null ? error.networkResponse : null, requestId);
            }
        });
        if (Networking.getSigRequestQueue() != null) {
            Networking.getSigRequestQueue().add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, String str3, NetworkResponse networkResponse, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setUrl(str);
            pointEntitySigmob.setTracking_type(str2);
            pointEntitySigmob.setRequest_id(str3);
            if (networkResponse == null) {
                return;
            }
            pointEntitySigmob.setResponse(networkResponse.data == null ? null : Base64.encodeToString(networkResponse.data, 2));
            pointEntitySigmob.setHttp_code(String.valueOf(networkResponse.statusCode));
            pointEntitySigmob.setTime_spend(String.valueOf(networkResponse.networkTimeMs));
            pointEntitySigmob.setContent_type((String) networkResponse.headers.get("Content-Type"));
            pointEntitySigmob.setContent_length((String) networkResponse.headers.get("Content-Length"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deliverResponse(NetworkResponse response) {
        a aVar;
        synchronized (this.mLock) {
            aVar = this.a;
        }
        SigmobLog.i("send tracking: " + getUrl() + " success");
        if (aVar != null) {
            aVar.a(response);
        }
    }

    public void deliverError(VolleyError error) {
        SigmobLog.e("send tracking: " + getUrl() + " fail");
        super.deliverError(error);
    }

    public int getMaxLength() {
        return 100;
    }

    protected Response<NetworkResponse> parseNetworkResponse(NetworkResponse response) {
        return Response.success(response, (Cache.Entry) null);
    }
}
