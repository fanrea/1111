package com.sigmob.sdk.downloader.core.connection;

import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface a {
    public static final int a = 0;

    /* renamed from: com.sigmob.sdk.downloader.core.connection.a$a, reason: collision with other inner class name */
    public interface InterfaceC0732a {
        String c(String name);

        int d() throws IOException;

        InputStream e() throws IOException;

        Map<String, List<String>> f();

        String g();
    }

    public interface b {
        a a(String url) throws IOException;
    }

    InterfaceC0732a a() throws IOException;

    void a(String name, String value);

    boolean a(String method) throws ProtocolException;

    String b(String key);

    void b();

    Map<String, List<String>> c();
}
