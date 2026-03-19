package com.kwad.library.solder.lib.a;

import android.text.TextUtils;
import com.kwad.library.solder.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class e<P extends a> {
    protected String bhP;
    protected int biA;
    protected String biC;
    protected String biD;
    protected boolean biE;
    protected P biF;
    protected com.kwad.library.solder.lib.ext.b biG;
    protected Throwable biH;
    protected String biI;
    protected boolean biJ;
    protected long biK;
    protected String biL;
    protected List<com.kwad.library.solder.lib.c.a> biM;
    protected com.kwad.library.solder.lib.c.b biN;
    protected d bif;
    protected String mDownloadUrl;
    protected String mVersion;
    protected int mState = -1;
    protected int biy = 0;
    private final byte[] biv = new byte[0];
    protected StringBuffer biB = new StringBuffer(String.valueOf(this.mState));

    public abstract P da(String str);

    public e(com.kwad.library.solder.lib.c.b bVar) {
        this.biN = bVar;
        this.bhP = bVar.bjd;
        this.mVersion = bVar.version;
        this.biL = bVar.bjg;
        this.biJ = bVar.biJ;
        this.biI = bVar.biI;
        this.biK = bVar.bjf;
        this.mDownloadUrl = bVar.bje;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final void cU(String str) {
        this.mVersion = str;
    }

    public final e a(d dVar) {
        this.bif = dVar;
        return this;
    }

    public final d Pv() {
        return this.bif;
    }

    public final int getState() {
        int i;
        synchronized (this.biv) {
            i = this.mState;
        }
        return i;
    }

    public final String Pw() {
        return this.biB.toString();
    }

    public final e dQ(int i) {
        synchronized (this.biv) {
            this.mState = i;
        }
        return cX(String.valueOf(i));
    }

    public final void cancel() {
        synchronized (this.biv) {
            dQ(0);
        }
    }

    public final boolean isCanceled() {
        return this.mState == 0;
    }

    public final e cX(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.biB.append(" --> ").append(str);
        }
        return this;
    }

    public final Throwable Px() {
        return this.biH;
    }

    public final e m(Throwable th) {
        this.biH = th;
        return cX(th.getLocalizedMessage());
    }

    public final boolean Py() {
        dQ(-1);
        this.biM = null;
        int i = this.biy + 1;
        this.biy = i;
        return i <= this.biA;
    }

    public final void dR(int i) {
        if (i > 0) {
            this.biA = i;
        }
    }

    public final String Pz() {
        return this.bhP;
    }

    public final boolean PA() {
        return this.biE;
    }

    public final int PB() {
        return this.biy;
    }

    public final String PC() {
        if (!TextUtils.isEmpty(this.biC)) {
            return this.biC;
        }
        return this.biD;
    }

    public final void cY(String str) {
        this.biC = str;
    }

    public final void cZ(String str) {
        this.biD = str;
    }

    public final void c(P p) {
        this.biF = p;
    }

    public final com.kwad.library.solder.lib.ext.b PD() {
        return this.biG;
    }

    public final void a(com.kwad.library.solder.lib.ext.b bVar) {
        this.biG = bVar;
    }

    public final boolean PE() {
        return this.biJ;
    }

    public final String PF() {
        return this.biI;
    }

    public final String PG() {
        return this.biL;
    }

    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public final com.kwad.library.solder.lib.c.b PH() {
        return this.biN;
    }

    public final List<com.kwad.library.solder.lib.c.a> PI() {
        String strPz = Pz();
        if (!TextUtils.isEmpty(strPz) && this.biM == null) {
            this.biM = b(strPz, getVersion(), PG());
        }
        return this.biM;
    }

    private List<com.kwad.library.solder.lib.c.a> b(String str, String str2, String str3) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(this.bif.Pl().cQ(str));
            if (file.exists() && (list = file.list()) != null && list.length != 0) {
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        if (this.bif.Pl().a(str, str4, str3)) {
                            com.kwad.library.solder.lib.c.a aVar = new com.kwad.library.solder.lib.c.a();
                            aVar.bjd = str;
                            aVar.version = str4;
                            aVar.vf = true;
                            arrayList.add(aVar);
                        } else {
                            this.bif.Pl().J(str, str4);
                        }
                    } else {
                        this.bif.Pl().J(str, str4);
                    }
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "PluginRequest{mId='" + this.bhP + "'}";
    }
}
