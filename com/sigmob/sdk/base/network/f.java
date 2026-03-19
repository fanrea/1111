package com.sigmob.sdk.base.network;

import android.util.Base64;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.ModelBuilderCreator;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Response;
import com.czhj.volley.toolbox.HttpHeaderParser;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigRequest;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigResponse;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f extends SigmobRequest<SigmobSdkConfigResponse> {
    private final a a;
    private final SigmobSdkConfigRequest.Builder b;
    private byte[] c;

    public interface a extends Response.ErrorListener {
        void a(SigmobSdkConfigResponse sigmobSdkConfigResponse);
    }

    public f(String url, a listener) {
        super(url, 1, listener);
        this.a = listener;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, 0.0f));
        setShouldCache(false);
        this.b = a();
    }

    public static SigmobSdkConfigRequest.Builder a() {
        SigmobSdkConfigRequest.Builder builder = new SigmobSdkConfigRequest.Builder();
        ClientMetadata clientMetadata = ClientMetadata.getInstance();
        if (clientMetadata != null && clientMetadata.getDeviceLocale() != null) {
            builder.app(com.sigmob.sdk.base.network.a.b().build());
            builder.user(com.sigmob.sdk.base.network.a.c().build());
            builder.privacy(com.sigmob.sdk.base.network.a.d().build());
            DeviceContext deviceContextB = com.sigmob.sdk.b.b();
            builder.network(ModelBuilderCreator.createNetwork(deviceContextB).build());
            builder.device(ModelBuilderCreator.createDevice(deviceContextB).did(ModelBuilderCreator.createDeviceId(deviceContextB).build()).build());
        }
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deliverResponse(SigmobSdkConfigResponse sigmobSdkConfigResponse) {
        this.a.a(sigmobSdkConfigResponse);
    }

    public a b() {
        return this.a;
    }

    public byte[] getBody() {
        return this.c;
    }

    public String getBodyContentType() {
        return MediaTypeUtils.APPLICATION_OCTET_STREAM;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        try {
            headers.put("agn", Base64.encodeToString(AESUtil.generateNonce(), 2));
        } catch (NoSuchMethodError unused) {
            headers.put("e", "1");
        }
        SigmobSdkConfigRequest sigmobSdkConfigRequestBuild = this.b.build();
        try {
            byte[] bArrEncode = sigmobSdkConfigRequestBuild.encode();
            this.c = bArrEncode;
            this.c = c.b(bArrEncode);
            headers.put(com.alipay.sdk.m.k.b.m, "1");
        } catch (Throwable unused2) {
            headers.remove(com.alipay.sdk.m.k.b.m);
            this.c = sigmobSdkConfigRequestBuild.encode();
        }
        try {
            this.c = AESUtil.Encrypt(this.c, "KGpfzbYsn4T9Jyuq");
        } catch (Exception e) {
            e.printStackTrace();
            headers.remove("e");
            headers.remove("agn");
        }
        return headers;
    }

    protected Response<SigmobSdkConfigResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            if (networkResponse.data == null) {
                return Response.error(new ParseError(networkResponse));
            }
            return Response.success((SigmobSdkConfigResponse) SigmobSdkConfigResponse.ADAPTER.decode((networkResponse.headers.containsKey(com.alipay.sdk.m.k.b.m) && "1".equals(networkResponse.headers.get(com.alipay.sdk.m.k.b.m))) ? c.a(networkResponse.data) : networkResponse.data), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return Response.error(new ParseError(th));
        }
    }
}
