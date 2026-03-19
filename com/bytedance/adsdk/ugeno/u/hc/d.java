package com.bytedance.adsdk.ugeno.u.hc;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.u.an;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d {
    public static final HashSet<String> d = new HashSet<>(Arrays.asList("convert", "dislike", "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", "close", "skip", "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    protected Map<String, String> an;
    protected com.bytedance.adsdk.ugeno.hc.b b;
    protected String c;
    protected String gb;
    protected String h;
    protected an.d hc;
    protected String u;

    public abstract void d();

    public d(com.bytedance.adsdk.ugeno.hc.b bVar, String str, an.d dVar) {
        this.b = bVar;
        this.hc = dVar;
        this.h = str;
        u();
    }

    private void u() {
        an.d dVar = this.hc;
        if (dVar == null) {
            return;
        }
        this.c = dVar.d();
        this.u = this.hc.hc();
        Map<String, String> mapB = this.hc.b();
        this.an = mapB;
        if (mapB == null || mapB.isEmpty() || !this.an.containsKey("emitCustomEvent")) {
            return;
        }
        this.gb = this.an.get("emitCustomEvent");
    }

    public void hc() {
        b();
    }

    public void b() {
        if (c()) {
            an.d dVar = new an.d();
            dVar.d(SchedulerSupport.CUSTOM);
            dVar.hc("emit");
            HashMap map = new HashMap();
            map.put("name", this.gb);
            dVar.d(map);
            new hc(this.b, this.u, dVar).d();
        }
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.gb);
    }

    /* renamed from: com.bytedance.adsdk.ugeno.u.hc.d$d, reason: collision with other inner class name */
    public static class C0177d {
        public static d d(com.bytedance.adsdk.ugeno.hc.b bVar, String str, an.d dVar) {
            if (dVar == null) {
                return null;
            }
            com.bytedance.adsdk.ugeno.u.hc hcVarD = com.bytedance.adsdk.ugeno.u.c.d(dVar.hc());
            if (hcVarD == null) {
                return new b(bVar, str, dVar);
            }
            d dVarD = hcVarD.d(bVar, str, dVar);
            return dVarD == null ? new b(bVar, str, dVar) : dVarD;
        }
    }
}
