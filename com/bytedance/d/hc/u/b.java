package com.bytedance.d.hc.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.d.hc.gb.tc;
import com.bytedance.sdk.component.utils.mq;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b {
    private Context d;

    public b(Context context) {
        this.d = context;
    }

    public void d(boolean z) throws JSONException {
        d();
        if (z) {
            hc();
        }
    }

    private void d() {
        try {
            SharedPreferences sharedPreferencesHc = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(this.d, "npth", 0);
            long j = sharedPreferencesHc.getLong("history_time", -1L);
            if (j < 0) {
                sharedPreferencesHc.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                com.bytedance.d.hc.gb.c.d(com.bytedance.d.hc.gb.gb.hc(this.d));
                sharedPreferencesHc.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    private void hc() throws JSONException {
        File[] fileArrD = d(com.bytedance.d.hc.gb.gb.d(this.d), ".npth");
        if (fileArrD == null) {
            return;
        }
        Arrays.sort(fileArrD, Collections.reverseOrder());
        for (int i = 0; i < fileArrD.length && i < 50; i++) {
            File file = fileArrD[i];
            try {
                if (com.bytedance.d.hc.hc.d.d().d(file.getAbsolutePath())) {
                    com.bytedance.d.hc.gb.c.d(file);
                } else {
                    com.bytedance.d.hc.b.b bVarB = com.bytedance.d.hc.gb.c.b(file.getAbsolutePath());
                    if (bVarB != null && bVarB.hc() != null) {
                        JSONObject jSONObjectHc = bVarB.hc();
                        d(file.getName(), jSONObjectHc);
                        bVarB.hc().put("upload_scene", "launch_scan");
                        if (com.bytedance.d.hc.h.hc.d(bVarB.d(), jSONObjectHc.toString(), bVarB.b()).d() && !com.bytedance.d.hc.gb.c.d(file)) {
                            com.bytedance.d.hc.hc.d.d().d(com.bytedance.d.hc.hc.d.d.d(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e) {
                tc.hc(e);
            }
        }
    }

    private com.bytedance.d.hc.b d(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return com.bytedance.d.hc.b.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return com.bytedance.d.hc.b.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return com.bytedance.d.hc.b.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return com.bytedance.d.hc.b.JAVA;
            }
        }
        return null;
    }

    private File[] d(File file, String str) {
        if (!file.exists()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return file.listFiles();
        }
        return file.listFiles(new FilenameFilter() { // from class: com.bytedance.d.hc.u.b.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2 != null && str2.endsWith(".npth");
            }
        });
    }
}
