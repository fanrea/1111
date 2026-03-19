package com.component.c;

import android.os.Environment;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    public static final String a = "mounted";

    public static boolean a() {
        return b().equals(a);
    }

    public static String b() {
        return Environment.getExternalStorageState();
    }

    public static File c() {
        return Environment.getExternalStorageDirectory();
    }

    public static File d() {
        return Environment.getDataDirectory();
    }
}
