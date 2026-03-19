package com.bytedance.adsdk.d.d.d;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {

    static class d extends IOException {
        d() {
            super("APNG Format error");
        }
    }

    public static List<u> d(com.bytedance.adsdk.d.d.hc.d dVar) throws IOException {
        if (!dVar.d("\u0089PNG") || !dVar.d("\r\n\u001a\n")) {
            throw new d();
        }
        ArrayList arrayList = new ArrayList();
        while (dVar.c() > 0) {
            arrayList.add(hc(dVar));
        }
        return arrayList;
    }

    private static u hc(com.bytedance.adsdk.d.d.hc.d dVar) throws IOException {
        u uVar;
        int iB = dVar.b();
        int iHc = dVar.hc();
        int iB_ = dVar.b_();
        if (iB_ == com.bytedance.adsdk.d.d.d.d.d) {
            uVar = new com.bytedance.adsdk.d.d.d.d();
        } else if (iB_ == an.d) {
            uVar = new an();
        } else if (iB_ == h.d) {
            uVar = new h();
        } else if (iB_ == tc.d) {
            uVar = new tc();
        } else if (iB_ == mk.d) {
            uVar = new mk();
        } else if (iB_ == mq.d) {
            uVar = new mq();
        } else {
            uVar = new u();
        }
        uVar.h = iB;
        uVar.u = iB_;
        uVar.c = iHc;
        uVar.hc(dVar);
        uVar.an = dVar.hc();
        return uVar;
    }
}
