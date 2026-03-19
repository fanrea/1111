package com.kwad.framework.filedownloader.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface b {
    Map<String, List<String>> Nm();

    Map<String, List<String>> Nn();

    void No();

    void addHeader(String str, String str2);

    String cp(String str);

    void execute();

    InputStream getInputStream();

    int getResponseCode();
}
