package com.bykv.vk.openvk.component.video.d.d.hc;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.component.video.api.b.c;
import com.bykv.vk.openvk.component.video.api.u.d;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    public static final ConcurrentHashMap<String, hc> d = new ConcurrentHashMap<>();

    public static synchronized void d(Context context, c cVar, d.InterfaceC0159d interfaceC0159d) {
        if (cVar == null) {
            com.bykv.vk.openvk.component.video.api.an.b.d(" url、dir and hash is must property   in VideoInfoModel");
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ConcurrentHashMap<String, hc> concurrentHashMap = d;
            hc hcVar = concurrentHashMap.get(cVar.w());
            if (hcVar == null) {
                hcVar = new hc(context, cVar);
                concurrentHashMap.put(cVar.w(), hcVar);
                Object[] objArr = new Object[3];
                Integer.valueOf(cVar.an());
                cVar.w();
            }
            hcVar.d(interfaceC0159d);
        }
        Object[] objArr2 = new Object[3];
        Integer.valueOf(cVar.an());
        cVar.w();
    }

    public static synchronized void d(c cVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            hc hcVarRemove = d.remove(cVar.w());
            if (hcVarRemove != null) {
                hcVarRemove.d(true);
            }
            Object[] objArr = new Object[3];
            Integer.valueOf(cVar.an());
            cVar.w();
        }
    }
}
