package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class uc {
    private boolean a;
    private final Set<Integer> b = new HashSet();
    private final Set<Integer> c = new HashSet();
    private final Set<Integer> d = new HashSet();

    public uc(JSONObject jSONObject) {
        try {
            boolean z = true;
            if (jSONObject.optInt("ea", 0) != 1) {
                z = false;
            }
            this.a = z;
            for (String str : jSONObject.optString("ei", "").split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    this.b.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
            for (String str2 : jSONObject.optString("ek", "").split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    this.c.add(Integer.valueOf(Integer.parseInt(str2)));
                }
            }
            for (String str3 : jSONObject.optString(com.baidu.mobads.container.landingpage.aq.b, "").split(",")) {
                if (!TextUtils.isEmpty(str3)) {
                    this.d.add(Integer.valueOf(Integer.parseInt(str3)));
                }
            }
        } catch (Exception unused) {
        }
    }

    boolean a(int i, Integer num) {
        if (this.a) {
            return true;
        }
        if (num != null && num.intValue() != 0 && !this.d.isEmpty() && !this.d.contains(num)) {
            return false;
        }
        if (this.b.contains(Integer.valueOf(i))) {
            return true;
        }
        return this.c.contains(Integer.valueOf(i / 1000));
    }
}
