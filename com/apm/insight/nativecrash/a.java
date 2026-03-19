package com.apm.insight.nativecrash;

import android.text.TextUtils;
import com.apm.insight.o.p;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.pangle.provider.ContentProviderManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    private Map<String, String> a;

    public a(File file) {
        String strA;
        File fileC = p.c(file);
        if (!fileC.exists() || fileC.length() == 0 || (strA = NativeImpl.a(fileC.getAbsolutePath())) == null) {
            return;
        }
        String[] strArrSplit = strA.split("\n");
        this.a = new HashMap();
        for (String str : strArrSplit) {
            String[] strArrSplit2 = str.split("=");
            if (strArrSplit2.length == 2) {
                this.a.put(strArrSplit2[0], strArrSplit2[1]);
            }
        }
    }

    public boolean a() {
        Map<String, String> map = this.a;
        return (map == null || map.isEmpty() || TextUtils.isEmpty(this.a.get(ContentProviderManager.PLUGIN_PROCESS_NAME)) || TextUtils.isEmpty(this.a.get("crash_thread_name")) || TextUtils.isEmpty(this.a.get("pid")) || TextUtils.isEmpty(this.a.get("tid")) || TextUtils.isEmpty(this.a.get(MetricsSQLiteCacheKt.METRICS_START_TIME)) || TextUtils.isEmpty(this.a.get("crash_time")) || TextUtils.isEmpty(this.a.get("signal_line"))) ? false : true;
    }

    public String b() {
        return this.a.get("signal_line");
    }

    public Map<String, String> c() {
        return this.a;
    }
}
