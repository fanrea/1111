package com.baidu.mobstat.forbes;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    public static boolean a(View view) {
        Object tag;
        try {
            tag = view.getTag(-5000);
        } catch (Exception e) {
            tag = null;
        }
        if (tag != null && (tag instanceof String) && ((String) tag).equals("baidu_mtj_edit_txtview")) {
            return true;
        }
        return false;
    }
}
