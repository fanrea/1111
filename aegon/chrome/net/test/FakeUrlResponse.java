package aegon.chrome.net.test;

import aegon.chrome.net.UrlResponseInfo;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class FakeUrlResponse {
    private final List<Map.Entry<String, String>> mAllHeadersList;
    private final int mHttpStatusCode;
    private final String mNegotiatedProtocol;
    private final String mProxyServer;
    private final String mResponseBody;
    private final boolean mWasCached;

    private static <T> T getNullableOrDefault(T t, T t2) {
        return t != null ? t : t2;
    }

    private FakeUrlResponse(Builder builder) {
        this.mHttpStatusCode = builder.mHttpStatusCode;
        this.mAllHeadersList = Collections.unmodifiableList(new ArrayList(builder.mAllHeadersList));
        this.mWasCached = builder.mWasCached;
        this.mNegotiatedProtocol = builder.mNegotiatedProtocol;
        this.mProxyServer = builder.mProxyServer;
        this.mResponseBody = builder.mResponseBody;
    }

    public FakeUrlResponse(UrlResponseInfo urlResponseInfo) {
        this.mHttpStatusCode = urlResponseInfo.getHttpStatusCode();
        this.mAllHeadersList = Collections.unmodifiableList(new ArrayList(urlResponseInfo.getAllHeadersAsList()));
        this.mWasCached = urlResponseInfo.wasCached();
        this.mNegotiatedProtocol = (String) getNullableOrDefault(urlResponseInfo.getNegotiatedProtocol(), "");
        this.mProxyServer = (String) getNullableOrDefault(urlResponseInfo.getProxyServer(), "");
        this.mResponseBody = "";
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class Builder {
        private static final int DEFAULT_HTTP_STATUS_CODE = 200;
        private static final String DEFAULT_NEGOTIATED_PROTOCOL = "";
        private static final String DEFAULT_PROXY_SERVER = "";
        private static final String DEFAULT_RESPONSE_BODY = "";
        private static final boolean DEFAULT_WAS_CACHED = false;
        private static final List<Map.Entry<String, String>> INTERNAL_INITIAL_HEADERS_LIST = new ArrayList();
        private List<Map.Entry<String, String>> mAllHeadersList;
        private int mHttpStatusCode;
        private String mNegotiatedProtocol;
        private String mProxyServer;
        private String mResponseBody;
        private boolean mWasCached;

        public Builder() {
            this.mHttpStatusCode = 200;
            this.mAllHeadersList = new ArrayList(INTERNAL_INITIAL_HEADERS_LIST);
            this.mWasCached = false;
            this.mNegotiatedProtocol = "";
            this.mProxyServer = "";
            this.mResponseBody = "";
        }

        private Builder(FakeUrlResponse fakeUrlResponse) {
            this.mHttpStatusCode = 200;
            this.mAllHeadersList = new ArrayList(INTERNAL_INITIAL_HEADERS_LIST);
            this.mWasCached = false;
            this.mNegotiatedProtocol = "";
            this.mProxyServer = "";
            this.mResponseBody = "";
            this.mHttpStatusCode = fakeUrlResponse.getHttpStatusCode();
            this.mAllHeadersList = new ArrayList(fakeUrlResponse.getAllHeadersList());
            this.mWasCached = fakeUrlResponse.getWasCached();
            this.mNegotiatedProtocol = fakeUrlResponse.getNegotiatedProtocol();
            this.mProxyServer = fakeUrlResponse.getProxyServer();
            this.mResponseBody = fakeUrlResponse.getResponseBody();
        }

        public Builder setHttpStatusCode(int i) {
            this.mHttpStatusCode = i;
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.mAllHeadersList.add(new AbstractMap.SimpleEntry(str, str2));
            return this;
        }

        public Builder setWasCached(boolean z) {
            this.mWasCached = z;
            return this;
        }

        public Builder setNegotiatedProtocol(String str) {
            this.mNegotiatedProtocol = str;
            return this;
        }

        public Builder setProxyServer(String str) {
            this.mProxyServer = str;
            return this;
        }

        public Builder setResponseBody(String str) {
            this.mResponseBody = str;
            return this;
        }

        public FakeUrlResponse build() {
            return new FakeUrlResponse(this);
        }
    }

    int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    List<Map.Entry<String, String>> getAllHeadersList() {
        return this.mAllHeadersList;
    }

    boolean getWasCached() {
        return this.mWasCached;
    }

    String getNegotiatedProtocol() {
        return this.mNegotiatedProtocol;
    }

    String getProxyServer() {
        return this.mProxyServer;
    }

    String getResponseBody() {
        return this.mResponseBody;
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FakeUrlResponse)) {
            return false;
        }
        FakeUrlResponse fakeUrlResponse = (FakeUrlResponse) obj;
        return this.mHttpStatusCode == fakeUrlResponse.mHttpStatusCode && this.mAllHeadersList.equals(fakeUrlResponse.mAllHeadersList) && this.mWasCached == fakeUrlResponse.mWasCached && this.mNegotiatedProtocol.equals(fakeUrlResponse.mNegotiatedProtocol) && this.mProxyServer.equals(fakeUrlResponse.mProxyServer) && this.mResponseBody.equals(fakeUrlResponse.mResponseBody);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mHttpStatusCode), this.mAllHeadersList, Boolean.valueOf(this.mWasCached), this.mNegotiatedProtocol, this.mProxyServer, this.mResponseBody);
    }

    public String toString() {
        return "HTTP Status Code: " + this.mHttpStatusCode + " Headers: " + this.mAllHeadersList.toString() + " Was Cached: " + this.mWasCached + " Negotiated Protocol: " + this.mNegotiatedProtocol + " Proxy Server: " + this.mProxyServer + " Response Body: " + this.mResponseBody;
    }
}
