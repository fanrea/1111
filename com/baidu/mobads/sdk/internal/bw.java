package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.ca;
import com.baidu.mobads.sdk.internal.cj;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class bw extends Thread {
    private static final String b = "ApkDownloadThread";
    private static final int c = 900000;
    private static volatile bw h;
    private volatile String d;
    private String e;
    private double f;
    private Handler g;
    private final Context i;
    private final by k;
    private cj j = null;
    private bu l = bu.a();
    cj.a a = new bx(this);

    public static bw a(Context context, by byVar, String str, Handler handler) {
        if (h == null) {
            h = new bw(context, byVar, str, handler);
        }
        return h;
    }

    private bw(Context context, by byVar, String str, Handler handler) {
        this.e = null;
        this.i = context;
        this.k = byVar;
        a(byVar.c());
        this.g = handler;
        this.e = str;
    }

    public void a(String str) {
        this.d = str;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.l.a(b, "download apk successfully, downloader exit");
                    h = null;
                } catch (IOException e) {
                    this.l.a(b, "create File or HTTP Get failed, exception: " + e.getMessage());
                }
                this.l.a(b, "no newer apk, downloader exit");
                h = null;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, by byVar, String str2) {
        if (str.equals(ca.k) || str.equals(ca.l)) {
            Message messageObtainMessage = this.g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ca.m, byVar);
            bundle.putString(ca.n, str);
            messageObtainMessage.setData(bundle);
            this.g.sendMessage(messageObtainMessage);
        }
    }

    private String a() throws IOException {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.e + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.j.a(this.e, str);
            return str2;
        } catch (IOException e) {
            file.delete();
            throw e;
        }
    }

    private boolean b() throws ca.a {
        double d;
        try {
            try {
                this.j = new cj(this.i, new URL(this.d), this.k, this.a);
            } catch (MalformedURLException unused) {
                this.j = new cj(this.i, this.d, this.k, this.a);
            }
            if (ca.q != null) {
                d = ca.q.b;
            } else if (ca.p == null) {
                d = 0.0d;
            } else if (ca.p.b > 0.0d) {
                d = ca.p.b;
            } else {
                d = ca.p.b;
            }
            this.l.a(b, "isNewApkAvailable: local apk version is: " + d + ", remote apk version: " + this.k.b());
            if (d > 0.0d) {
                if (this.k.b() > 0.0d) {
                    this.l.a(b, "remote not null, local apk version is null, force upgrade");
                    this.f = this.k.b();
                    return true;
                }
                this.l.a(b, "remote is null, local apk version is null, do not upgrade");
                return false;
            }
            if (this.k.b() <= 0.0d) {
                this.l.a(b, "remote apk version is: null, local apk version is: " + d + ", do not upgrade");
                return false;
            }
            if (this.k.b() <= d) {
                return false;
            }
            this.f = this.k.b();
            return true;
        } catch (Exception e) {
            String str = "parse apk failed, error:" + e.toString();
            this.l.a(b, str);
            throw new ca.a(str);
        }
    }
}
