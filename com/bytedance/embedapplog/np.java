package com.bytedance.embedapplog;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class np extends jh {
    private static final long[] hc = {60000};
    private long b;
    private boolean c;

    @Override // com.bytedance.embedapplog.jh
    String c() {
        return "s";
    }

    public void d(boolean z) {
        this.c = z;
    }

    np(de deVar) {
        super(deVar);
        this.c = true;
    }

    @Override // com.bytedance.embedapplog.jh
    long d() {
        long jNp = this.d.c().np();
        if (jNp > 60000 || jNp <= 0) {
            jNp = 60000;
        }
        hc[0] = jNp;
        return this.b + jNp;
    }

    @Override // com.bytedance.embedapplog.jh
    long[] hc() {
        return hc;
    }

    @Override // com.bytedance.embedapplog.jh
    public boolean b() throws JSONException {
        Bundle bundleD;
        long jCurrentTimeMillis = System.currentTimeMillis();
        yi yiVarH = this.d.h();
        if (yiVarH != null && (bundleD = yiVarH.d(jCurrentTimeMillis, 50000L)) != null) {
            d.d("play_session", bundleD, 1);
            d.hc();
        }
        ra raVarB = this.d.b();
        ba baVarU = this.d.u();
        if (baVarU.mk() != 0) {
            JSONObject jSONObjectHc = fv.hc(baVarU.d());
            if (jSONObjectHc != null) {
                d(raVarB.d(jSONObjectHc));
                this.b = System.currentTimeMillis();
                return true;
            }
            um.hc((Throwable) null);
        }
        return false;
    }

    private void d(ArrayList<nr> arrayList) {
        ra raVarB = this.d.b();
        ArrayList<nr> arrayList2 = new ArrayList<>();
        ArrayList<nr> arrayList3 = new ArrayList<>();
        fs fsVarC = this.d.c();
        ArrayList arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.addAll(arrayList);
        }
        ArrayList<nr> arrayListD = raVarB.d();
        if (!arrayListD.isEmpty()) {
            arrayList4.addAll(arrayListD);
        }
        if (arrayList4.size() > 0) {
            Iterator it = arrayList4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                nr nrVar = (nr) it.next();
                if (nrVar.mq == null || nrVar.mq.length <= 0) {
                    arrayList2.add(nrVar);
                } else {
                    int iD = this.c ? fu.d(xp.d(this.d, this.d.hc(), this.d.u().d()), nrVar.mq, fsVarC) : 200;
                    if (fu.d(iD)) {
                        if (arrayList.contains(nrVar)) {
                            nrVar.k = iD;
                            arrayList3.add(nrVar);
                        }
                    } else if (iD == 200) {
                        arrayList2.add(nrVar);
                    } else {
                        nrVar.k = iD;
                        arrayList3.add(nrVar);
                    }
                }
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                raVarB.d(arrayList2, arrayList3, arrayList);
            }
            um.c(c() + " " + arrayList2.size() + " " + arrayList4.size(), null);
        }
    }
}
