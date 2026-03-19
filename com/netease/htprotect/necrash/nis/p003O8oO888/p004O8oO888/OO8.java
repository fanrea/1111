package com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888;

import android.text.TextUtils;
import com.netease.htprotect.necrash.nis.p003O8oO888.o8o0;
import java.io.File;
import java.io.IOException;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.O8〇oO8〇88.OO〇8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class OO8 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final OO8 f89O8oO888 = new OO8();

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final String f90Ooo = "JavaCrashFileManager";

    /* renamed from: 〇O8, reason: contains not printable characters */
    private String f91O8;

    private OO8() {
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static OO8 m557O8oO888() {
        return f89O8oO888;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static boolean m558O8oO888(File file) {
        if (!file.exists()) {
            return false;
        }
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private boolean m559Ooo() {
        File file = new File(this.f91O8);
        try {
            if (file.exists()) {
                return file.isDirectory();
            }
            file.mkdirs();
            return file.exists() && file.isDirectory();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m560O8oO888(String str) {
        this.f91O8 = str;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final File m561Ooo(String str) {
        if (TextUtils.isEmpty(this.f91O8) || !m559Ooo()) {
            return null;
        }
        File file = new File(str);
        try {
            if (file.createNewFile()) {
                return file;
            }
            o8o0.m582Ooo(f90Ooo, "FileManager createLogFile by createNewFile failed,file already exists");
            return null;
        } catch (IOException unused) {
            o8o0.m582Ooo(f90Ooo, "FileManager createLogFile by createNewFile failed");
            return null;
        }
    }
}
