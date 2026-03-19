package com.android.gdt.qone.ae;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class c {
    public static boolean a(String str) throws IOException {
        File file;
        File parentFile;
        if (TextUtils.isEmpty(str) || (parentFile = (file = new File(new File(com.android.gdt.qone.w.a.b(), str).getAbsolutePath())).getParentFile()) == null) {
            return false;
        }
        if (!parentFile.exists()) {
            parentFile.mkdir();
        }
        if (file.exists()) {
            return true;
        }
        try {
            file.createNewFile();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
