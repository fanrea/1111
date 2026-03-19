package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pt {
    private static final Pattern h = Pattern.compile("bytes\\W+(\\d+)-(\\d+)/(\\d+)");
    private static final AtomicInteger i = new AtomicInteger(0);
    private static volatile int j = -1;
    private static volatile String[] k = null;
    private HttpURLConnection a;
    private int b;
    private String c;
    private cv e;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private int f = 0;
    private final int g = k();

    private void d() {
        if (i.incrementAndGet() >= j) {
            t20.a(9130018);
        }
    }

    private boolean m() {
        if (j < 0) {
            j = r1.d().f().a("tcdt", 2);
        }
        return i.get() >= j;
    }

    private boolean n() {
        return r1.d().f().a("utocct", 1) > 0;
    }

    private boolean r() {
        return s20.a().c() && this.g > 1 && !m() && b(this.a.getURL().getHost());
    }

    public pt(HttpURLConnection httpURLConnection, int i2, String str) {
        this.a = httpURLConnection;
        this.b = i2;
        this.c = str;
        if (r()) {
            this.e = new cv(httpURLConnection, i2, str);
        }
        l();
    }

    private int k() {
        return s20.a().d(this.a.getURL().toString());
    }

    private void l() {
        if (this.g > 0 && n() && b(this.a.getURL().getHost())) {
            boolean zC = s20.a().c();
            boolean zM = m();
            int iA = a(this.a.getURL().toString());
            if (iA >= 0) {
                this.f = ((zC ? 1 : 0) * 10000) + (this.g * 1000) + ((zM ? 1 : 0) * 100) + (iA * 10);
            }
        }
    }

    private int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.contains("https://pgdt.ugdtimg.com")) {
            return 0;
        }
        return str.contains("https://adsmind.ugdtimg.com") ? 1 : -1;
    }

    public boolean o() {
        return this.b == 0;
    }

    public int g() {
        return this.b;
    }

    public boolean p() {
        String headerField;
        cv cvVar = this.e;
        if (cvVar != null) {
            headerField = cvVar.l();
        } else {
            HttpURLConnection httpURLConnection = this.a;
            headerField = httpURLConnection != null ? httpURLConnection.getHeaderField("Content-Range") : "";
        }
        return !TextUtils.isEmpty(headerField) && h.matcher(headerField).matches() && f() >= 0;
    }

    public long e() {
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection == null) {
            return -1L;
        }
        String headerField = httpURLConnection.getHeaderField("X-Cos-Meta-Edgepack-Offset");
        if (TextUtils.isEmpty(headerField)) {
            return -1L;
        }
        try {
            return Long.parseLong(headerField);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public long f() {
        cv cvVar = this.e;
        if (cvVar != null) {
            return cvVar.c();
        }
        if (this.a != null) {
            return r0.getContentLength();
        }
        return -1L;
    }

    public String j() {
        cv cvVar = this.e;
        if (cvVar != null) {
            return cvVar.g();
        }
        HttpURLConnection httpURLConnection = this.a;
        return httpURLConnection != null ? httpURLConnection.getContentType() : "";
    }

    public InputStream i() throws IllegalStateException, IOException {
        cv cvVar = this.e;
        if (cvVar != null) {
            return cvVar.f();
        }
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            return httpURLConnection.getInputStream();
        }
        return null;
    }

    public void b() {
        cv cvVar = this.e;
        if (cvVar != null) {
            cvVar.a();
        }
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
        }
    }

    public String h() {
        return this.c;
    }

    public boolean c() throws JSONException, InterruptedException, IOException {
        int responseCode;
        int iH = 0;
        if (this.d.compareAndSet(false, true)) {
            q();
            long jCurrentTimeMillis = System.currentTimeMillis();
            cv cvVar = this.e;
            if (cvVar != null) {
                int iB = cvVar.b();
                int i2 = iB != 0 ? 0 : 1;
                if (i2 != 0) {
                    iH = this.e.h();
                    a();
                    c(jCurrentTimeMillis);
                } else {
                    a(jCurrentTimeMillis, iB);
                }
                this.b |= this.e.d();
                this.c = this.e.e();
                responseCode = iH;
                iH = i2;
            } else {
                responseCode = 0;
            }
            if (this.e == null || iH == 0) {
                try {
                    HttpURLConnection httpURLConnectionA = as.a(this.a);
                    this.a = httpURLConnectionA;
                    responseCode = httpURLConnectionA.getResponseCode();
                } catch (SocketTimeoutException e) {
                    this.b |= 131072;
                    this.c = "ExceptionWhileMakeupPartitionConnection:" + e.getMessage();
                } catch (UnknownHostException e2) {
                    this.b |= 65536;
                    this.c = "ExceptionWhileMakeupPartitionConnection:" + as.i() + " " + e2.getMessage();
                } catch (IOException e3) {
                    this.b |= 4194304;
                    this.c = "ExceptionWhileMakeupPartitionConnection:" + e3.getMessage();
                }
            }
            if (responseCode != 0 && responseCode != 200 && responseCode != 206) {
                int i3 = this.b;
                this.b = 2097152 | i3;
                if (responseCode == 416) {
                    this.b = i3 | 3145728;
                }
                this.c = "HttpStatusErrWhileMakeupPartitionConnection:" + responseCode;
            }
            a(jCurrentTimeMillis);
            if (this.e != null && iH == 0) {
                o();
                if (o()) {
                    d();
                    b(jCurrentTimeMillis);
                }
                this.e.a();
                this.e = null;
            }
        }
        return o();
    }

    private void q() {
        int i2 = this.f;
        if (i2 > 0) {
            t20.a(9130050, i2);
        }
    }

    private void a(long j2) throws JSONException {
        if (this.f <= 0 || this.g != 1) {
            return;
        }
        if (o()) {
            t20.a(9130051, this.f, 0);
            return;
        }
        ja jaVar = new ja();
        jaVar.a("data", this.a.getURL().toString());
        t20.a(9130052, this.f, 0, jaVar);
    }

    private boolean b(String str) {
        if (k == null) {
            String strB = r1.d().f().b("utocch", "https://pgdt.ugdtimg.com,https://adsmind.ugdtimg.com");
            if (!TextUtils.isEmpty(strB)) {
                k = strB.split(",");
            } else {
                k = new String[0];
            }
        }
        for (String str2 : k) {
            if (str2.contains(str)) {
                return true;
            }
        }
        return false;
    }

    private void c(long j2) {
        int i2 = this.f;
        if (i2 > 0) {
            t20.a(9130051, i2, 0);
        }
    }

    private void a(long j2, int i2) throws JSONException {
        if (this.f > 0) {
            ja jaVar = new ja();
            jaVar.a("data", this.a.getURL().toString());
            int i3 = this.f + i2;
            this.f = i3;
            t20.a(9130052, i3, 0, jaVar);
        }
    }

    private void a() {
        i.set(0);
    }

    private void b(long j2) throws JSONException {
        if (this.f > 0) {
            ja jaVar = new ja();
            jaVar.a("data", this.a.getURL().toString());
            t20.a(9130053, this.f, 0, jaVar);
        }
    }
}
