package okhttp3.internal.a;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class c {
    public final Response cacheResponse;
    public final Request zN;

    c(Request request, Response response) {
        this.zN = request;
        this.cacheResponse = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.cacheControl().getIsPrivate() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(okhttp3.Response r3, okhttp3.Request r4) {
        /*
            int r0 = r3.code()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L59
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L59
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L59
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L59
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L59
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L59
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L59
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L59
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L59
            switch(r0) {
                case 300: goto L59;
                case 301: goto L59;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L58
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.header(r0)
            if (r0 != 0) goto L59
            okhttp3.CacheControl r0 = r3.cacheControl()
            int r0 = r0.maxAgeSeconds()
            r1 = -1
            if (r0 != r1) goto L59
            okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.getIsPublic()
            if (r0 != 0) goto L59
            okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.getIsPrivate()
            if (r0 != 0) goto L59
        L58:
            return r2
        L59:
            okhttp3.CacheControl r3 = r3.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L6f
            okhttp3.CacheControl r3 = r4.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L6f
            r3 = 1
            return r3
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.a.c.a(okhttp3.Response, okhttp3.Request):boolean");
    }

    public static class a {
        final Response cacheResponse;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        final long zO;
        private Date zP;
        private String zQ;
        private Date zR;
        private String zS;
        private Date zT;
        private String zU;
        private int zV;

        public a(long j, Request request, Response response) {
            this.zV = -1;
            this.zO = j;
            this.request = request;
            this.cacheResponse = response;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String strName = headers.name(i);
                    String strValue = headers.value(i);
                    if ("Date".equalsIgnoreCase(strName)) {
                        this.zP = okhttp3.internal.b.d.parse(strValue);
                        this.zQ = strValue;
                    } else if ("Expires".equalsIgnoreCase(strName)) {
                        this.zT = okhttp3.internal.b.d.parse(strValue);
                    } else if ("Last-Modified".equalsIgnoreCase(strName)) {
                        this.zR = okhttp3.internal.b.d.parse(strValue);
                        this.zS = strValue;
                    } else if ("ETag".equalsIgnoreCase(strName)) {
                        this.zU = strValue;
                    } else if ("Age".equalsIgnoreCase(strName)) {
                        this.zV = okhttp3.internal.b.e.d(strValue, -1);
                    }
                }
            }
        }

        public final c fX() throws NumberFormatException {
            c cVarFY = fY();
            return (cVarFY.zN == null || !this.request.cacheControl().onlyIfCached()) ? cVarFY : new c(null, null);
        }

        private c fY() throws NumberFormatException {
            if (this.cacheResponse == null) {
                return new c(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new c(this.request, null);
            }
            if (!c.a(this.cacheResponse, this.request)) {
                return new c(this.request, null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || a(this.request)) {
                return new c(this.request, null);
            }
            long jGa = ga();
            long jFZ = fZ();
            if (cacheControl.maxAgeSeconds() != -1) {
                jFZ = Math.min(jFZ, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j = millis2 + jGa;
                if (j < millis + jFZ) {
                    Response.Builder builderNewBuilder = this.cacheResponse.newBuilder();
                    if (j >= jFZ) {
                        builderNewBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jGa > 86400000 && gb()) {
                        builderNewBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, builderNewBuilder.build());
                }
            }
            String str = this.zU;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.zR != null) {
                str = this.zS;
            } else if (this.zP != null) {
                str = this.zQ;
            } else {
                return new c(this.request, null);
            }
            Headers.Builder builderNewBuilder2 = this.request.headers().newBuilder();
            okhttp3.internal.a.instance.addLenient(builderNewBuilder2, str2, str);
            return new c(this.request.newBuilder().headers(builderNewBuilder2.build()).build(), this.cacheResponse);
        }

        private long fZ() throws NumberFormatException {
            if (this.cacheResponse.cacheControl().maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
            }
            if (this.zT != null) {
                Date date = this.zP;
                long time = this.zT.getTime() - (date != null ? date.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.zR != null && this.cacheResponse.request().url().query() == null) {
                Date date2 = this.zP;
                long time2 = (date2 != null ? date2.getTime() : this.sentRequestMillis) - this.zR.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private long ga() {
            Date date = this.zP;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            if (this.zV != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.zV));
            }
            long j = this.receivedResponseMillis;
            return jMax + (j - this.sentRequestMillis) + (this.zO - j);
        }

        private boolean gb() {
            return this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.zT == null;
        }

        private static boolean a(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }
    }
}
