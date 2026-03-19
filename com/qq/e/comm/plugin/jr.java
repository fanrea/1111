package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.rg;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jr {
    public static volatile boolean a;

    public static cl a(Context context, fr frVar, bl blVar, VideoOption videoOption, rg.d dVar, ah ahVar, com.qq.e.comm.plugin.nativeadunified.c cVar, View.OnTouchListener onTouchListener, MediaView mediaView, JSONObject jSONObject) {
        if (!frVar.C1()) {
            frVar.h(5);
            return new nr(context, frVar, cVar);
        }
        boolean z = (b.c().a(frVar.x0(), "nunrcfg", 3) & 1) == 1;
        a = xc.a("nuvudt", 0, frVar) == 1;
        if (z && (frVar.p0() != null || a)) {
            mr mrVar = new mr(context, blVar, frVar, videoOption, dVar, ahVar, cVar, onTouchListener, mediaView, jSONObject);
            if (mrVar.t()) {
                frVar.h(11);
                return mrVar;
            }
        }
        if (!z) {
            frVar.h(6);
        }
        return new lr(context, blVar, frVar, videoOption, dVar, ahVar, cVar, onTouchListener, mediaView, jSONObject);
    }
}
