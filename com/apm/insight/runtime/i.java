package com.apm.insight.runtime;

import android.content.Context;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.fendasz.moku.planet.constants.MokuConstants;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i {
    private Context a;
    private HashMap<String, Long> b;
    private int c = 50;
    private int d = 100;

    public i(Context context) {
        this.b = null;
        this.a = context;
        this.b = c();
        b();
    }

    private void a(File file) {
        File fileG = com.apm.insight.o.p.g(this.a);
        file.renameTo(new File(fileG, String.valueOf(System.currentTimeMillis())));
        String[] list = fileG.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            new File(fileG, list[0]).delete();
        }
    }

    private void b() {
        this.c = a.a(this.c, "custom_event_settings", "npth_simple_setting", "crash_limit_issue");
        this.d = a.a(this.d, "custom_event_settings", "npth_simple_setting", "crash_limit_all");
    }

    private HashMap<String, Long> c() {
        JSONArray jSONArrayB;
        File fileH = com.apm.insight.o.p.h(this.a);
        HashMap<String, Long> map = new HashMap<>();
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        try {
            jSONArrayB = com.apm.insight.o.j.b(fileH.getAbsolutePath());
        } catch (IOException unused) {
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
        }
        if (com.apm.insight.o.m.a(jSONArrayB)) {
            return map;
        }
        Long lDecode = Long.decode(jSONArrayB.optString(0, null));
        if (System.currentTimeMillis() - lDecode.longValue() > 86400000) {
            a(fileH);
            return map;
        }
        map.put("time", lDecode);
        for (int i = 1; i < jSONArrayB.length(); i++) {
            String[] strArrSplit = jSONArrayB.optString(i, "").split(" ");
            if (strArrSplit.length == 2) {
                map.put(strArrSplit[0], Long.decode(strArrSplit[1]));
            }
        }
        return map;
    }

    public void a() throws Throwable {
        HashMap<String, Long> map = this.b;
        Long lRemove = map.remove("time");
        if (lRemove == null) {
            com.apm.insight.b.a().a("NPTH_CATCH", new RuntimeException("err times, no time"));
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append(lRemove).append('\n');
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            sbAppend.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
        }
        try {
            com.apm.insight.o.j.a(com.apm.insight.o.p.h(this.a), sbAppend.toString(), false);
        } catch (IOException unused) {
        }
    }

    public boolean a(String str) {
        if (str == null) {
            str = ILogConst.PLAY_SOURCE_DEFAULT;
        }
        return com.apm.insight.o.r.a(this.b, str, 1L).longValue() < ((long) this.c) && com.apm.insight.o.r.a(this.b, MokuConstants.TASK_TAG_ALL, 1L).longValue() < ((long) this.d);
    }
}
