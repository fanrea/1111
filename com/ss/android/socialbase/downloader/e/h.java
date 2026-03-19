package com.ss.android.socialbase.downloader.e;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.c.an;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.c.bc;
import com.ss.android.socialbase.downloader.c.cb;
import com.ss.android.socialbase.downloader.c.dc;
import com.ss.android.socialbase.downloader.c.de;
import com.ss.android.socialbase.downloader.c.e;
import com.ss.android.socialbase.downloader.c.fs;
import com.ss.android.socialbase.downloader.c.gb;
import com.ss.android.socialbase.downloader.c.h;
import com.ss.android.socialbase.downloader.c.he;
import com.ss.android.socialbase.downloader.c.j;
import com.ss.android.socialbase.downloader.c.jh;
import com.ss.android.socialbase.downloader.c.k;
import com.ss.android.socialbase.downloader.c.mk;
import com.ss.android.socialbase.downloader.c.np;
import com.ss.android.socialbase.downloader.c.r;
import com.ss.android.socialbase.downloader.c.rf;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.c.sy;
import com.ss.android.socialbase.downloader.c.tc;
import com.ss.android.socialbase.downloader.c.tt;
import com.ss.android.socialbase.downloader.c.uo;
import com.ss.android.socialbase.downloader.c.v;
import com.ss.android.socialbase.downloader.c.vv;
import com.ss.android.socialbase.downloader.c.w;
import com.ss.android.socialbase.downloader.c.yi;
import com.ss.android.socialbase.downloader.c.yo;
import com.ss.android.socialbase.downloader.c.zw;
import com.ss.android.socialbase.downloader.h.d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h {
    private static Handler d = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.h.d d(final com.ss.android.socialbase.downloader.h.c cVar) {
        if (cVar == null) {
            return null;
        }
        return new d.AbstractBinderC0789d() { // from class: com.ss.android.socialbase.downloader.e.h.1
            @Override // com.ss.android.socialbase.downloader.h.d
            public com.ss.android.socialbase.downloader.h.b d() throws RemoteException {
                return cVar.d();
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public com.ss.android.socialbase.downloader.c.an hc() throws RemoteException {
                return h.d(cVar.an());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public com.ss.android.socialbase.downloader.c.tc hc(int i) throws RemoteException {
                return h.d(cVar.b(an.u(i)), i != com.ss.android.socialbase.downloader.hc.gb.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public int d(int i) throws RemoteException {
                return cVar.hc(an.u(i));
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public com.ss.android.socialbase.downloader.c.tc d(int i, int i2) throws RemoteException {
                return h.d(cVar.d(an.u(i), i2), i != com.ss.android.socialbase.downloader.hc.gb.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public j b() throws RemoteException {
                return h.d(cVar.tc());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public fs c() throws RemoteException {
                return h.d(cVar.mk());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public com.ss.android.socialbase.downloader.c.tt u() throws RemoteException {
                return h.d(cVar.b());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public com.ss.android.socialbase.downloader.c.h an() throws RemoteException {
                return h.d(cVar.c());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public mk tc() throws RemoteException {
                return h.d(cVar.u());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public v h() throws RemoteException {
                return h.d(cVar.gb());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public r gb() throws RemoteException {
                return h.d(cVar.h());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public w tt() throws RemoteException {
                return h.d(cVar.tt());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public com.ss.android.socialbase.downloader.c.gb mk() throws RemoteException {
                return h.d(cVar.k());
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public int mq() throws RemoteException {
                return cVar.sy().size();
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public uo b(int i) throws RemoteException {
                return h.d(cVar.an(i));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.c.tc d(final vv vvVar, final boolean z) {
        if (vvVar == null) {
            return null;
        }
        return new tc.d() { // from class: com.ss.android.socialbase.downloader.e.h.12
            @Override // com.ss.android.socialbase.downloader.c.tc
            public int d() throws RemoteException {
                return vvVar.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void d(final com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.d(bVar);
                        }
                    });
                } else {
                    vvVar.d(bVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void hc(final com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.hc(bVar);
                        }
                    });
                } else {
                    vvVar.hc(bVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void b(final com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.b(bVar);
                        }
                    });
                } else {
                    vvVar.b(bVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void c(final com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.c(bVar);
                        }
                    });
                } else {
                    vvVar.c(bVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void u(final com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.u(bVar);
                        }
                    });
                } else {
                    vvVar.u(bVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void d(final com.ss.android.socialbase.downloader.h.b bVar, final com.ss.android.socialbase.downloader.u.d dVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.d(bVar, dVar);
                        }
                    });
                } else {
                    vvVar.d(bVar, dVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void an(final com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.an(bVar);
                        }
                    });
                } else {
                    vvVar.an(bVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void h(final com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.gb(bVar);
                        }
                    });
                } else {
                    vvVar.gb(bVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void gb(final com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.tt(bVar);
                        }
                    });
                } else {
                    vvVar.tt(bVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void hc(final com.ss.android.socialbase.downloader.h.b bVar, final com.ss.android.socialbase.downloader.u.d dVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.hc(bVar, dVar);
                        }
                    });
                } else {
                    vvVar.hc(bVar, dVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void b(final com.ss.android.socialbase.downloader.h.b bVar, final com.ss.android.socialbase.downloader.u.d dVar) throws RemoteException {
                if (z) {
                    h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            vvVar.b(bVar, dVar);
                        }
                    });
                } else {
                    vvVar.b(bVar, dVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.tc
            public void tt(final com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                vv vvVar2 = vvVar;
                if (vvVar2 instanceof jh) {
                    if (z) {
                        h.d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.e.h.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((jh) vvVar).h(bVar);
                            }
                        });
                    } else {
                        ((jh) vvVar2).h(bVar);
                    }
                }
            }
        };
    }

    public static j d(final s sVar) {
        if (sVar == null) {
            return null;
        }
        return new j.d() { // from class: com.ss.android.socialbase.downloader.e.h.23
            @Override // com.ss.android.socialbase.downloader.c.j
            public void d(int i, com.ss.android.socialbase.downloader.h.b bVar, String str, String str2) throws RemoteException {
                sVar.d(i, bVar, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.c.j
            public boolean d(boolean z) throws RemoteException {
                return sVar.d(z);
            }

            @Override // com.ss.android.socialbase.downloader.c.j
            public String d() throws RemoteException {
                return sVar.d();
            }
        };
    }

    public static fs d(final ba baVar) {
        if (baVar == null) {
            return null;
        }
        return new fs.d() { // from class: com.ss.android.socialbase.downloader.e.h.26
            @Override // com.ss.android.socialbase.downloader.c.fs
            public boolean d(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                return baVar.d(bVar);
            }

            @Override // com.ss.android.socialbase.downloader.c.fs
            public boolean hc(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                return baVar.hc(bVar);
            }

            @Override // com.ss.android.socialbase.downloader.c.fs
            public boolean b(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                return baVar.b(bVar);
            }
        };
    }

    public static r d(final com.ss.android.socialbase.downloader.downloader.jh jhVar) {
        if (jhVar == null) {
            return null;
        }
        return new r.d() { // from class: com.ss.android.socialbase.downloader.e.h.27
            @Override // com.ss.android.socialbase.downloader.c.r
            public long d(int i, int i2) throws RemoteException {
                return jhVar.d(i, i2);
            }
        };
    }

    public static v d(final yi yiVar) {
        if (yiVar == null) {
            return null;
        }
        return new v.d() { // from class: com.ss.android.socialbase.downloader.e.h.28
            @Override // com.ss.android.socialbase.downloader.c.v
            public boolean d(de deVar) throws RemoteException {
                return yiVar.d(h.d(deVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.c.gb d(final sy syVar) {
        if (syVar == null) {
            return null;
        }
        return new gb.d() { // from class: com.ss.android.socialbase.downloader.e.h.29
            @Override // com.ss.android.socialbase.downloader.c.gb
            public Uri d(String str, String str2) throws RemoteException {
                return syVar.d(str, str2);
            }
        };
    }

    public static np d(final de deVar) {
        if (deVar == null) {
            return null;
        }
        return new np() { // from class: com.ss.android.socialbase.downloader.e.h.30
            @Override // com.ss.android.socialbase.downloader.c.np
            public void d(List<String> list) {
                try {
                    deVar.d(list);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.np
            public boolean d() {
                try {
                    return deVar.d();
                } catch (RemoteException e) {
                    mq.d(e);
                    return false;
                }
            }
        };
    }

    public static w d(final rf rfVar) {
        if (rfVar == null) {
            return null;
        }
        return new w.d() { // from class: com.ss.android.socialbase.downloader.e.h.31
            @Override // com.ss.android.socialbase.downloader.c.w
            public boolean d(long j, long j2, cb cbVar) throws RemoteException {
                return rfVar.d(j, j2, h.d(cbVar));
            }
        };
    }

    public static yo d(final cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        return new yo() { // from class: com.ss.android.socialbase.downloader.e.h.2
            @Override // com.ss.android.socialbase.downloader.c.yo
            public void d() {
                try {
                    cbVar.d();
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.c.h d(final e eVar) {
        if (eVar == null) {
            return null;
        }
        return new h.d() { // from class: com.ss.android.socialbase.downloader.e.h.3
            @Override // com.ss.android.socialbase.downloader.c.h
            public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar, int i) throws RemoteException {
                eVar.d(bVar, dVar, i);
            }
        };
    }

    public static mk d(final zw zwVar) {
        if (zwVar == null) {
            return null;
        }
        return new mk.d() { // from class: com.ss.android.socialbase.downloader.e.h.4
            @Override // com.ss.android.socialbase.downloader.c.mk
            public void d(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    zwVar.d(new JSONObject(str));
                } catch (JSONException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.mk
            public String d() throws RemoteException {
                return zwVar.hc();
            }

            @Override // com.ss.android.socialbase.downloader.c.mk
            public int[] hc() throws RemoteException {
                zw zwVar2 = zwVar;
                if (zwVar2 instanceof com.ss.android.socialbase.downloader.c.c) {
                    return ((com.ss.android.socialbase.downloader.c.c) zwVar2).d();
                }
                return null;
            }
        };
    }

    public static com.ss.android.socialbase.downloader.c.an d(final com.ss.android.socialbase.downloader.downloader.tc tcVar) {
        if (tcVar == null) {
            return null;
        }
        return new an.d() { // from class: com.ss.android.socialbase.downloader.e.h.5
            @Override // com.ss.android.socialbase.downloader.c.an
            public int d(long j) throws RemoteException {
                return tcVar.d(j);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.c.tt d(final he heVar) {
        if (heVar == null) {
            return null;
        }
        return new tt.d() { // from class: com.ss.android.socialbase.downloader.e.h.6
            @Override // com.ss.android.socialbase.downloader.c.tt
            public boolean d() throws RemoteException {
                return heVar.d();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.h.c d(com.ss.android.socialbase.downloader.h.d dVar) {
        if (dVar == null) {
            return null;
        }
        try {
            com.ss.android.socialbase.downloader.h.c cVar = new com.ss.android.socialbase.downloader.h.c(dVar.d());
            cVar.d(d(dVar.hc())).d(d(dVar.b())).d(d(dVar.u())).d(d(dVar.an())).d(d(dVar.tc())).d(d(dVar.h())).d(d(dVar.tt())).d(d(dVar.mk())).d(d(dVar.c())).d(d(dVar.gb()));
            com.ss.android.socialbase.downloader.c.tc tcVarHc = dVar.hc(com.ss.android.socialbase.downloader.hc.gb.MAIN.ordinal());
            if (tcVarHc != null) {
                cVar.d(tcVarHc.hashCode(), d(tcVarHc));
            }
            com.ss.android.socialbase.downloader.c.tc tcVarHc2 = dVar.hc(com.ss.android.socialbase.downloader.hc.gb.SUB.ordinal());
            if (tcVarHc2 != null) {
                cVar.hc(tcVarHc2.hashCode(), d(tcVarHc2));
            }
            com.ss.android.socialbase.downloader.c.tc tcVarHc3 = dVar.hc(com.ss.android.socialbase.downloader.hc.gb.NOTIFICATION.ordinal());
            if (tcVarHc3 != null) {
                cVar.b(tcVarHc3.hashCode(), d(tcVarHc3));
            }
            d(cVar, dVar, com.ss.android.socialbase.downloader.hc.gb.MAIN);
            d(cVar, dVar, com.ss.android.socialbase.downloader.hc.gb.SUB);
            d(cVar, dVar, com.ss.android.socialbase.downloader.hc.gb.NOTIFICATION);
            d(cVar, dVar);
            return cVar;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    private static void d(com.ss.android.socialbase.downloader.h.c cVar, com.ss.android.socialbase.downloader.h.d dVar, com.ss.android.socialbase.downloader.hc.gb gbVar) throws RemoteException {
        SparseArray<vv> sparseArray = new SparseArray<>();
        for (int i = 0; i < dVar.d(gbVar.ordinal()); i++) {
            com.ss.android.socialbase.downloader.c.tc tcVarD = dVar.d(gbVar.ordinal(), i);
            if (tcVarD != null) {
                sparseArray.put(tcVarD.d(), d(tcVarD));
            }
        }
        cVar.d(sparseArray, gbVar);
    }

    private static void d(com.ss.android.socialbase.downloader.h.c cVar, com.ss.android.socialbase.downloader.h.d dVar) throws RemoteException {
        for (int i = 0; i < dVar.mq(); i++) {
            uo uoVarB = dVar.b(i);
            if (uoVarB != null) {
                cVar.d(d(uoVarB));
            }
        }
    }

    public static s d(final j jVar) {
        if (jVar == null) {
            return null;
        }
        return new s() { // from class: com.ss.android.socialbase.downloader.e.h.7
            @Override // com.ss.android.socialbase.downloader.c.s
            public void d(int i, com.ss.android.socialbase.downloader.h.b bVar, String str, String str2) {
                try {
                    jVar.d(i, bVar, str, str2);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.s
            public boolean d(boolean z) {
                try {
                    return jVar.d(z);
                } catch (RemoteException e) {
                    mq.d(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.s
            public String d() {
                try {
                    return jVar.d();
                } catch (RemoteException e) {
                    mq.d(e);
                    return null;
                }
            }
        };
    }

    public static k d(final uo uoVar) {
        if (uoVar == null) {
            return null;
        }
        return new k() { // from class: com.ss.android.socialbase.downloader.e.h.8
            @Override // com.ss.android.socialbase.downloader.c.k
            public void d(com.ss.android.socialbase.downloader.h.b bVar) throws com.ss.android.socialbase.downloader.u.d {
                try {
                    uoVar.d(bVar);
                } catch (RemoteException e) {
                    throw new com.ss.android.socialbase.downloader.u.d(1008, e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.k
            public boolean hc(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    return uoVar.hc(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                    return false;
                }
            }
        };
    }

    public static uo d(final k kVar) {
        if (kVar == null) {
            return null;
        }
        return new uo.d() { // from class: com.ss.android.socialbase.downloader.e.h.9
            @Override // com.ss.android.socialbase.downloader.c.uo
            public void d(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                try {
                    kVar.d(bVar);
                } catch (com.ss.android.socialbase.downloader.u.d e) {
                    throw new IllegalArgumentException(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.uo
            public boolean hc(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                return kVar.hc(bVar);
            }
        };
    }

    public static ba d(final fs fsVar) {
        if (fsVar == null) {
            return null;
        }
        return new ba() { // from class: com.ss.android.socialbase.downloader.e.h.10
            @Override // com.ss.android.socialbase.downloader.c.ba
            public boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    return fsVar.d(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.ba
            public boolean hc(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    return fsVar.hc(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.ba
            public boolean b(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    return fsVar.b(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.tc d(final com.ss.android.socialbase.downloader.c.an anVar) {
        if (anVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.tc() { // from class: com.ss.android.socialbase.downloader.e.h.11
            @Override // com.ss.android.socialbase.downloader.downloader.tc
            public int d(long j) {
                try {
                    return anVar.d(j);
                } catch (RemoteException e) {
                    mq.d(e);
                    return 0;
                }
            }
        };
    }

    public static e d(final com.ss.android.socialbase.downloader.c.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new e() { // from class: com.ss.android.socialbase.downloader.e.h.13
            @Override // com.ss.android.socialbase.downloader.c.e
            public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar, int i) {
                if (bVar == null) {
                    return;
                }
                try {
                    hVar.d(bVar, dVar, i);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }
        };
    }

    public static zw d(final mk mkVar) {
        if (mkVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.c.c() { // from class: com.ss.android.socialbase.downloader.e.h.14
            @Override // com.ss.android.socialbase.downloader.c.zw
            public void d(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    mkVar.d(jSONObject.toString());
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.zw
            public String hc() {
                try {
                    return mkVar.d();
                } catch (RemoteException e) {
                    mq.d(e);
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.c
            public int[] d() {
                try {
                    return mkVar.hc();
                } catch (RemoteException e) {
                    mq.d(e);
                    return null;
                }
            }
        };
    }

    public static yi d(final v vVar) {
        if (vVar == null) {
            return null;
        }
        return new yi() { // from class: com.ss.android.socialbase.downloader.e.h.15
            @Override // com.ss.android.socialbase.downloader.c.yi
            public boolean d(np npVar) {
                try {
                    return vVar.d(h.d(npVar));
                } catch (RemoteException e) {
                    mq.d(e);
                    return false;
                }
            }
        };
    }

    public static de d(final np npVar) {
        if (npVar == null) {
            return null;
        }
        return new de.d() { // from class: com.ss.android.socialbase.downloader.e.h.16
            @Override // com.ss.android.socialbase.downloader.c.de
            public void d(List<String> list) {
                npVar.d(list);
            }

            @Override // com.ss.android.socialbase.downloader.c.de
            public boolean d() {
                return npVar.d();
            }
        };
    }

    public static bc d(final dc dcVar) {
        if (dcVar == null) {
            return null;
        }
        return new bc.d() { // from class: com.ss.android.socialbase.downloader.e.h.17
            @Override // com.ss.android.socialbase.downloader.c.bc
            public void d(int i, int i2) {
                dcVar.d(i, i2);
            }
        };
    }

    public static dc d(final bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return new dc() { // from class: com.ss.android.socialbase.downloader.e.h.18
            @Override // com.ss.android.socialbase.downloader.c.dc
            public void d(int i, int i2) {
                try {
                    bcVar.d(i, i2);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }
        };
    }

    public static rf d(final w wVar) {
        if (wVar == null) {
            return null;
        }
        return new rf() { // from class: com.ss.android.socialbase.downloader.e.h.19
            @Override // com.ss.android.socialbase.downloader.c.rf
            public boolean d(long j, long j2, yo yoVar) {
                try {
                    return wVar.d(j, j2, h.d(yoVar));
                } catch (RemoteException e) {
                    mq.d(e);
                    return false;
                }
            }
        };
    }

    public static cb d(final yo yoVar) {
        if (yoVar == null) {
            return null;
        }
        return new cb.d() { // from class: com.ss.android.socialbase.downloader.e.h.20
            @Override // com.ss.android.socialbase.downloader.c.cb
            public void d() throws RemoteException {
                yoVar.d();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.jh d(final r rVar) {
        if (rVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.jh() { // from class: com.ss.android.socialbase.downloader.e.h.21
            @Override // com.ss.android.socialbase.downloader.downloader.jh
            public long d(int i, int i2) {
                try {
                    return rVar.d(i, i2);
                } catch (RemoteException e) {
                    mq.d(e);
                    return 0L;
                }
            }
        };
    }

    public static he d(final com.ss.android.socialbase.downloader.c.tt ttVar) {
        if (ttVar == null) {
            return null;
        }
        return new he() { // from class: com.ss.android.socialbase.downloader.e.h.22
            @Override // com.ss.android.socialbase.downloader.c.he
            public boolean d() {
                try {
                    return ttVar.d();
                } catch (RemoteException e) {
                    mq.d(e);
                    return false;
                }
            }
        };
    }

    public static sy d(final com.ss.android.socialbase.downloader.c.gb gbVar) {
        if (gbVar == null) {
            return null;
        }
        return new sy() { // from class: com.ss.android.socialbase.downloader.e.h.24
            @Override // com.ss.android.socialbase.downloader.c.sy
            public Uri d(String str, String str2) {
                try {
                    return gbVar.d(str, str2);
                } catch (RemoteException e) {
                    mq.d(e);
                    return null;
                }
            }
        };
    }

    public static vv d(final com.ss.android.socialbase.downloader.c.tc tcVar) {
        if (tcVar == null) {
            return null;
        }
        return new jh() { // from class: com.ss.android.socialbase.downloader.e.h.25
            @Override // com.ss.android.socialbase.downloader.c.jh
            public void h(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    tcVar.tt(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void d(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    tcVar.d(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    tcVar.hc(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void b(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    tcVar.b(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void c(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    tcVar.c(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void u(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    tcVar.u(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
                try {
                    tcVar.d(bVar, dVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void an(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    tcVar.an(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void gb(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    tcVar.h(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void tt(com.ss.android.socialbase.downloader.h.b bVar) {
                try {
                    tcVar.gb(bVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void hc(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
                try {
                    tcVar.hc(bVar, dVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.vv
            public void b(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
                try {
                    tcVar.b(bVar, dVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            }
        };
    }
}
