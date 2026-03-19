package com.netease.htprotect.p020oO.p021O8oO888;

import android.content.Context;
import android.util.Log;
import com.netease.htprotect.p020oO.p021O8oO888.O8;
import com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888.Oo0;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.netease.htprotect.〇oO.O8〇oO8〇88.〇o0〇o0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0o0 {

    /* renamed from: 〇O, reason: contains not printable characters */
    private static final String f570O = "lib";

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    protected final Set f571O8oO888;
    protected O8.o0o0 Oo0;

    /* renamed from: 〇O8, reason: contains not printable characters */
    protected final O8.O8oO888 f572O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    protected final O8.Ooo f573Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    protected boolean f574o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    protected boolean f575oO;

    protected o0o0() {
        this(new O(), new O8oO888());
    }

    private o0o0(O8.Ooo ooo, O8.O8oO888 o8oO888) {
        this.f571O8oO888 = new HashSet();
        this.f573Ooo = ooo;
        this.f572O8 = o8oO888;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static File m1126O8oO888(Context context) {
        return context.getDir(f570O, 0);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m1127O8oO888(Context context, String str) throws Throwable {
        m1138O8oO888(context, str, (String) null, (O8.InterfaceC0685O8) null);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m1128O8oO888(Context context, String str, O8.InterfaceC0685O8 interfaceC0685O8) throws Throwable {
        m1138O8oO888(context, str, (String) null, interfaceC0685O8);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m1129O8oO888(Context context, String str, String str2) throws Throwable {
        m1138O8oO888(context, str, str2, (O8.InterfaceC0685O8) null);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static void m1131O8oO888(String str, Object... objArr) {
        String.format(Locale.US, str, objArr);
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private File m1132O8(Context context, String str, String str2) {
        String strMo1113O8 = this.f573Ooo.mo1113O8(str);
        return o0O0O.m1140O8oO888(str2) ? new File(context.getDir(f570O, 0), strMo1113O8) : new File(context.getDir(f570O, 0), strMo1113O8 + "." + str2);
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static void m1133O8() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public void m1134Ooo(Context context, String str, String str2) throws Throwable {
        Oo0 oo0;
        if (this.f571O8oO888.contains(str) && !this.f574o0o0) {
            m1131O8oO888("%s already loaded previously!", str);
            return;
        }
        try {
            this.f573Ooo.mo1111O8oO888(str);
            this.f571O8oO888.add(str);
            m1131O8oO888("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            m1131O8oO888("Loading the library normally failed: %s", Log.getStackTraceString(e));
            m1131O8oO888("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileM1132O8 = m1132O8(context, str, str2);
            if (!fileM1132O8.exists() || this.f574o0o0) {
                if (this.f574o0o0) {
                    m1131O8oO888("Forcing a re-link of %s (%s)...", str, str2);
                }
                File dir = context.getDir(f570O, 0);
                File fileM1132O82 = m1132O8(context, str, str2);
                File[] fileArrListFiles = dir.listFiles(new Oo0(this, this.f573Ooo.mo1113O8(str)));
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        if (this.f574o0o0 || !file.getAbsolutePath().equals(fileM1132O82.getAbsolutePath())) {
                            file.delete();
                        }
                    }
                }
                this.f572O8.mo1098O8oO888(context, this.f573Ooo.mo1112O8oO888(), this.f573Ooo.mo1113O8(str), fileM1132O8);
            }
            try {
                if (this.f575oO) {
                    Oo0 oo02 = null;
                    try {
                        oo0 = new Oo0(fileM1132O8);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        List listM1105O8oO888 = oo0.m1105O8oO888();
                        oo0.close();
                        Iterator it = listM1105O8oO888.iterator();
                        while (it.hasNext()) {
                            m1138O8oO888(context, this.f573Ooo.mo1115o0o0((String) it.next()), (String) null, (O8.InterfaceC0685O8) null);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        oo02 = oo0;
                        oo02.close();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.f573Ooo.mo1114Ooo(fileM1132O8.getAbsolutePath());
            this.f571O8oO888.add(str);
            m1131O8oO888("%s (%s) was re-linked!", str, str2);
        }
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private void m1135o0o0(Context context, String str, String str2) {
        File dir = context.getDir(f570O, 0);
        File fileM1132O8 = m1132O8(context, str, str2);
        File[] fileArrListFiles = dir.listFiles(new Oo0(this, this.f573Ooo.mo1113O8(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f574o0o0 || !file.getAbsolutePath().equals(fileM1132O8.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final o0o0 m1136O8oO888() {
        this.f574o0o0 = true;
        return this;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final o0o0 m1137O8oO888(O8.o0o0 o0o0Var) {
        this.Oo0 = o0o0Var;
        return this;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m1138O8oO888(Context context, String str, String str2, O8.InterfaceC0685O8 interfaceC0685O8) throws Throwable {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (o0O0O.m1140O8oO888(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        m1131O8oO888("Beginning load of %s...", str);
        if (interfaceC0685O8 == null) {
            m1134Ooo(context, str, str2);
        } else {
            new Thread(new oO(this, context, str, str2, interfaceC0685O8)).start();
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final o0o0 m1139Ooo() {
        this.f575oO = true;
        return this;
    }
}
