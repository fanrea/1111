package com.bytedance.bdtracker;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class l4 {
    public final ArrayList<String> a = new ArrayList<>();

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(a.a(str).append(File.separator).append(str2).append(".dat").toString());
        if (file.exists()) {
            file.delete();
        }
    }
}
