package com.kwad.framework.filedownloader.download;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ConnectTask {
    final int beF;
    final com.kwad.framework.filedownloader.d.b beG;
    private com.kwad.framework.filedownloader.download.a beH;
    private String beI;
    private Map<String, List<String>> beJ;
    private List<String> beK;
    final String url;

    /* synthetic */ ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i, String str, String str2, com.kwad.framework.filedownloader.d.b bVar, byte b) {
        this(aVar, i, str, str2, bVar);
    }

    private ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i, String str, String str2, com.kwad.framework.filedownloader.d.b bVar) {
        this.beF = i;
        this.url = str;
        this.beI = str2;
        this.beG = bVar;
        this.beH = aVar;
    }

    final com.kwad.framework.filedownloader.a.b Nt() {
        com.kwad.framework.filedownloader.a.b bVarCt = b.Ny().ct(this.url);
        a(bVarCt);
        b(bVarCt);
        c(bVarCt);
        this.beJ = bVarCt.Nm();
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.beF), this.beJ);
        }
        bVarCt.execute();
        ArrayList arrayList = new ArrayList();
        this.beK = arrayList;
        return com.kwad.framework.filedownloader.a.d.a(this.beJ, bVarCt, arrayList);
    }

    private void a(com.kwad.framework.filedownloader.a.b bVar) {
        HashMap<String, List<String>> mapOu;
        com.kwad.framework.filedownloader.d.b bVar2 = this.beG;
        if (bVar2 == null || (mapOu = bVar2.Ou()) == null) {
            return;
        }
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.beF), mapOu);
        }
        for (Map.Entry<String, List<String>> entry : mapOu.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVar.addHeader(key, it.next());
                }
            }
        }
    }

    private void b(com.kwad.framework.filedownloader.a.b bVar) {
        if (!TextUtils.isEmpty(this.beI)) {
            bVar.addHeader("If-Match", this.beI);
        }
        bVar.addHeader("Range", this.beH.beP == 0 ? com.kwad.framework.filedownloader.f.f.c("bytes=%d-", Long.valueOf(this.beH.beO)) : com.kwad.framework.filedownloader.f.f.c("bytes=%d-%d", Long.valueOf(this.beH.beO), Long.valueOf(this.beH.beP)));
    }

    private void c(com.kwad.framework.filedownloader.a.b bVar) {
        com.kwad.framework.filedownloader.d.b bVar2 = this.beG;
        if (bVar2 == null || bVar2.Ou().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwad.framework.filedownloader.f.f.Pd());
        }
    }

    final boolean Nu() {
        return this.beH.beO > 0;
    }

    final String Nv() {
        List<String> list = this.beK;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.beK.get(r0.size() - 1);
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.beJ;
    }

    public final com.kwad.framework.filedownloader.download.a Nw() {
        return this.beH;
    }

    class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        Reconnect() {
        }
    }

    static class a {
        private com.kwad.framework.filedownloader.d.b beG;
        private String beI;
        private Integer beL;
        private com.kwad.framework.filedownloader.download.a beM;
        private String url;

        a() {
        }

        public final a du(int i) {
            this.beL = Integer.valueOf(i);
            return this;
        }

        public final a cr(String str) {
            this.url = str;
            return this;
        }

        public final a cs(String str) {
            this.beI = str;
            return this;
        }

        public final a a(com.kwad.framework.filedownloader.d.b bVar) {
            this.beG = bVar;
            return this;
        }

        public final a a(com.kwad.framework.filedownloader.download.a aVar) {
            this.beM = aVar;
            return this;
        }

        final ConnectTask Nx() {
            if (this.beL == null || this.beM == null || this.url == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(this.beM, this.beL.intValue(), this.url, this.beI, this.beG, (byte) 0);
        }
    }
}
