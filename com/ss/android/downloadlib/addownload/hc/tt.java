package com.ss.android.downloadlib.addownload.hc;

import android.content.SharedPreferences;
import com.ss.android.downloadlib.addownload.mq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tt {

    private static class d {
        private static tt d = new tt();
    }

    public static tt d() {
        return d.d;
    }

    private tt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences b() {
        return com.bytedance.sdk.openadsdk.ats.b.d(mq.getContext(), "sp_ad_download_event", 0);
    }

    ConcurrentHashMap<Long, com.ss.android.hc.d.hc.hc> hc() {
        ConcurrentHashMap<Long, com.ss.android.hc.d.hc.hc> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = b().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long jLongValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.hc.d.hc.hc hcVarHc = com.ss.android.hc.d.hc.hc.hc(new JSONObject(String.valueOf(entry.getValue())));
                    if (jLongValue > 0 && hcVarHc != null) {
                        concurrentHashMap.put(Long.valueOf(jLongValue), hcVarHc);
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
            }
        }
        return concurrentHashMap;
    }

    public void d(com.ss.android.hc.d.hc.hc hcVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hcVar);
        d((Collection<com.ss.android.hc.d.hc.hc>) arrayList);
    }

    public synchronized void d(final Collection<com.ss.android.hc.d.hc.hc> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hc.tt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor editorEdit = tt.this.b().edit();
                        for (com.ss.android.hc.d.hc.hc hcVar : collection) {
                            if (hcVar != null && hcVar.hc() != 0) {
                                editorEdit.putString(String.valueOf(hcVar.hc()), hcVar.ar().toString());
                            }
                        }
                        editorEdit.apply();
                    }
                }, true);
            }
        }
    }

    public void d(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hc.tt.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = tt.this.b().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            }
        }, true);
    }
}
