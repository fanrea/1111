package com.baidu.mobads.container.components.e;

import com.baidu.mobads.container.components.e.b;
import com.just.agentweb.AgentWebPermissions;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends Observable implements b, Runnable {
    protected static final int h = 10240;
    protected static final int i = 10240;
    public static final String j = ".tmp";
    private static final String m = "OAdSimpleFileDownloader";
    protected URL a;
    protected String b;
    protected String c;
    protected int d;
    protected b.a e;
    protected int f;
    protected int g;
    protected byte[] k;
    private boolean n;

    public byte[] a() {
        return this.k;
    }

    public a(URL url, String str, String str2, boolean z) {
        this.n = false;
        this.a = url;
        this.b = str;
        this.n = z;
        if (str2 != null && str2.trim().length() > 0) {
            this.c = str2;
        } else {
            String file = url.getFile();
            this.c = file.substring(file.lastIndexOf(47) + 1);
        }
        this.d = -1;
        this.e = b.a.DOWNLOADING;
        this.f = 0;
        this.g = 0;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.container.components.e.b
    @Deprecated
    public void a(int i2) {
    }

    @Override // com.baidu.mobads.container.components.e.b
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.container.components.e.b
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void d() {
        a(b.a.DOWNLOADING);
        j();
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String e() {
        return this.a.toString();
    }

    @Override // com.baidu.mobads.container.components.e.b
    public int f() {
        return this.d;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public long g() {
        return this.d;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public float h() {
        return Math.abs((this.f / this.d) * 100.0f);
    }

    @Override // com.baidu.mobads.container.components.e.b
    public b.a i() {
        return this.e;
    }

    protected void a(b.a aVar) {
        this.e = aVar;
        k();
    }

    protected void j() {
        com.baidu.mobads.container.d.b.a().a(this, 2);
    }

    protected void a(int i2, float f) {
        this.f += i2;
        k();
    }

    protected void k() {
        setChanged();
        notifyObservers();
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String l() {
        return this.b + this.c;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String m() {
        return this.b;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String n() {
        return this.c;
    }

    private void w() {
        a(b.a.ERROR);
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x014b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.components.e.a.run():void");
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String o() {
        return "";
    }

    @Override // com.baidu.mobads.container.components.e.b
    public int p() {
        return 0;
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) throws IOException {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                this.a = new URL(httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION));
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) this.a.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception e) {
                    return httpURLConnection2;
                }
            } catch (Exception e2) {
                return httpURLConnection;
            }
        }
    }

    protected void q() {
        a(this.b + this.c + ".tmp", this.b + this.c);
    }

    private boolean a(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (!file.exists()) {
                return false;
            }
            return file.renameTo(file2);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.mobads.container.components.e.b
    @Deprecated
    public String r() {
        return null;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void s() {
    }

    @Override // com.baidu.mobads.container.components.e.b
    @Deprecated
    public String t() {
        return null;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public boolean u() {
        return false;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void b(boolean z) {
    }

    @Override // com.baidu.mobads.container.components.e.b
    public boolean v() {
        return false;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void c(boolean z) {
    }
}
