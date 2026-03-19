package com.apm.insight.runtime;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class l {
    private static k a;

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x004b */
    public static JSONArray a(String str) throws Throwable {
        Closeable closeable;
        BufferedReader bufferedReader;
        JSONArray jSONArray;
        Closeable closeable2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                jSONArray = new JSONArray();
                bufferedReader = new BufferedReader(new FileReader(str));
            } catch (IOException e) {
                e = e;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                com.apm.insight.o.l.a(closeable2);
                throw th;
            }
            try {
                File file = new File(str);
                if (file.length() > 512000) {
                    bufferedReader.skip(file.length() - 512000);
                }
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        com.apm.insight.o.l.a(bufferedReader);
                        return jSONArray;
                    }
                    jSONArray.put(line);
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                com.apm.insight.o.l.a(bufferedReader);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    public static JSONArray a(String str, long j) {
        if (a != null && com.apm.insight.g.e().equals(str)) {
            try {
                return a(a.a());
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
        try {
            String absolutePath = com.apm.insight.o.g.a(str, com.apm.insight.g.h().getLogcatDumpCount(), com.apm.insight.g.h().getLogcatLevel()).getAbsolutePath();
            if (j > 0) {
                SystemClock.sleep(j);
            }
            return a(absolutePath);
        } catch (Throwable th2) {
            com.apm.insight.b.a().a("NPTH_CATCH", th2);
            return null;
        }
    }

    public static void a(k kVar) {
        a = kVar;
    }

    public static JSONArray b(String str) {
        return a(str, 0L);
    }
}
