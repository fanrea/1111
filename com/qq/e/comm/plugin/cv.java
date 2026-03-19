package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.tencent.qqlive.modules.vb.tquic.impl.TnetConfig;
import com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.http2.Header;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cv {
    private static volatile int l;
    private int a;
    private String b;
    private final TnetQuicRequest c;
    private final URL d;
    private fv e;
    private final CountDownLatch f = new CountDownLatch(1);
    private volatile boolean g = false;
    private final AtomicBoolean h;
    private final HttpURLConnection i;
    private String j;
    private final TnetQuicRequest.Callback k;

    public cv(HttpURLConnection httpURLConnection, int i, String str) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.h = atomicBoolean;
        a aVar = new a();
        this.k = aVar;
        this.i = httpURLConnection;
        this.a = i;
        this.b = str;
        URL url = httpURLConnection.getURL();
        this.d = url;
        url.getHost();
        this.c = new TnetQuicRequest(aVar, new TnetConfig.Builder().setConnectTimeoutMillis(5000).setTotalTimeoutMillis(10000).build(), 0);
        atomicBoolean.set(true);
        if (l == 0) {
            l = r1.d().f().a("utocctt", 30);
        }
    }

    public int b() throws InterruptedException {
        int i;
        try {
            InetAddress inetAddressA = a(this.d.getHost());
            boolean z = true;
            if (inetAddressA == null) {
                return 1;
            }
            inetAddressA.toString();
            this.c.connect(this.d.toString(), inetAddressA.getHostAddress());
            boolean zAwait = this.f.await(l, TimeUnit.SECONDS);
            if (i()) {
                i = 0;
            } else if (!zAwait) {
                i = 2;
            } else if (this.e == null) {
                i = 3;
            } else {
                i = !this.g ? 4 : 1;
            }
            if (i != 0) {
                z = false;
            }
            a(z);
            return i;
        } catch (UnknownHostException e) {
            this.a |= 65536;
            this.b = "ExceptionWhileMakeupPartitionConnection:" + e.getMessage();
            return 5;
        } catch (Exception e2) {
            this.a |= 4194304;
            this.b = "ExceptionWhileMakeupPartitionConnection:" + e2.getMessage();
            return 6;
        }
    }

    /* compiled from: A */
    class a extends TnetQuicRequest.Callback {
        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onHeaderRecv(String str) throws Exception {
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onNetworkLinked() throws Exception {
        }

        a() {
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onConnect(int i) throws Exception {
            cv.this.e = null;
            cv.this.k();
            if (cv.this.i.getRequestMethod().equalsIgnoreCase("HEAD")) {
                cv.this.c.addHeaders(Header.TARGET_METHOD_UTF8, "HEAD");
                cv.this.j = "HEAD";
            }
            cv.this.c.sendRequest(new byte[0], 0, true);
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onDataRecv(byte[] bArr) throws Exception {
            if (cv.this.e == null) {
                cv.this.e = new fv();
            }
            try {
                cv.this.e.a(bArr);
            } catch (Exception e) {
                e.toString();
                t20.b(9130016, 2);
                cv.this.j();
            }
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onComplete(int i) throws Exception {
            if (i == 0) {
                if (TextUtils.equals("HEAD", cv.this.j)) {
                    cv cvVar = cv.this;
                    cvVar.g = cvVar.e.f();
                } else {
                    cv cvVar2 = cv.this;
                    cvVar2.g = cvVar2.e.e();
                }
                if (!cv.this.g) {
                    t20.b(9130016, 3);
                }
            } else {
                t20.b(9130016, 4);
            }
            cv.this.j();
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onClose(int i, String str) throws Exception {
            cv.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        HttpURLConnection httpURLConnection;
        if (this.c == null || (httpURLConnection = this.i) == null || this.d == null) {
            return;
        }
        Map<String, List<String>> requestProperties = httpURLConnection.getRequestProperties();
        if (requestProperties != null) {
            for (String str : requestProperties.keySet()) {
                this.c.addHeaders(str, this.i.getRequestProperty(str));
            }
        }
        this.c.addHeaders("Accept-Encoding", "gzip");
        if (this.d.getPath() != null) {
            this.c.addHeaders(Header.TARGET_PATH_UTF8, this.d.getQuery() == null ? this.d.getPath() : this.d.getPath() + "?" + this.d.getQuery());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f.getCount() > 0) {
            this.f.countDown();
        }
    }

    public String l() {
        return i() ? this.e.a("Content-Range") : "";
    }

    public int h() {
        if (i()) {
            return this.e.a();
        }
        return 0;
    }

    public long c() {
        if (!i()) {
            return -1L;
        }
        String strA = this.e.a("Content-Length");
        if (TextUtils.isEmpty(strA)) {
            return -1L;
        }
        return Long.parseLong(strA);
    }

    private boolean i() {
        return (this.c == null || this.e == null || !this.g) ? false : true;
    }

    public String g() {
        if (!i()) {
            return "";
        }
        String strA = this.e.a(com.alipay.sdk.m.p.e.f);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public InputStream f() throws IllegalStateException, IOException {
        if (i()) {
            return this.e.b();
        }
        return null;
    }

    public int d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public void a() {
        a(false);
    }

    private void a(boolean z) {
        if (this.c == null || !this.h.compareAndSet(true, false)) {
            return;
        }
        if (r1.d().f().a("rdtcc", 0) > 0) {
            this.c.destroy();
        } else {
            if (!z || r1.d().f().a("irdtcc", 0) <= 0) {
                return;
            }
            this.c.destroy();
        }
    }

    private InetAddress a(String str) throws UnknownHostException {
        InetAddress inetAddress;
        InetAddress[] allByName = InetAddress.getAllByName(str);
        int length = allByName.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                inetAddress = null;
                break;
            }
            inetAddress = allByName[i];
            if (inetAddress instanceof Inet4Address) {
                break;
            }
            i++;
        }
        return (inetAddress != null || allByName.length <= 0) ? inetAddress : allByName[0];
    }
}
