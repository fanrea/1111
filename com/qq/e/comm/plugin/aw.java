package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.s20;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface aw {

    /* compiled from: A */
    public enum a {
        GET,
        POST
    }

    hw a(HttpURLConnection httpURLConnection) throws IOException;

    void a(int i);

    void a(s20.h hVar);

    void a(String str, String str2);

    void a(Map<String, String> map);

    void a(boolean z);

    boolean a();

    int b();

    void b(String str, String str2);

    void b(boolean z);

    void c(boolean z);

    byte[] c() throws Exception;

    void d(boolean z);

    boolean d();

    String e();

    void e(boolean z);

    String f();

    int g();

    String h();

    Map<String, String> i();

    boolean j();

    boolean k();

    int l();

    s20.h m();

    boolean n();

    a o();

    Map<String, String> p();

    Map<String, String> q();
}
