package com.apm.insight.runtime;

import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class s {
    private static File a;
    private static String b;

    public static class a {
        public String a;
        public String b;
        public long c;

        a(String str) {
            String[] strArrSplit = str.split("\\s+");
            if (strArrSplit.length != 3) {
                com.apm.insight.b.a().a("NPTH_CATCH", new RuntimeException("err ProcessTrack line:" + str));
                return;
            }
            this.a = strArrSplit[0];
            this.b = strArrSplit[1];
            try {
                this.c = Long.parseLong(strArrSplit[2]);
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", new RuntimeException("err ProcessTrack line:" + str, th));
            }
        }
    }

    public static long a(int i, long j, String str) {
        BufferedReader bufferedReader;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(a(str, j)));
        } catch (Throwable unused) {
        }
        try {
            String str2 = i + " afterNpthInitAsync";
            do {
                line = bufferedReader.readLine();
                if (line == null) {
                    com.apm.insight.o.l.a(bufferedReader);
                    return -1L;
                }
            } while (!line.startsWith(str2));
            long j2 = Long.parseLong(line.substring(line.lastIndexOf(" ") + 1));
            com.apm.insight.o.l.a(bufferedReader);
            return j2;
        } catch (Throwable unused2) {
            bufferedReader2 = bufferedReader;
            com.apm.insight.o.l.a(bufferedReader2);
            return -1L;
        }
    }

    public static File a(long j) {
        return new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
    }

    public static File a(String str, long j) {
        if (str == null) {
            return null;
        }
        return new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/ProcessTrack/" + (j / 86400000) + '/' + str.replace(':', '_') + ".txt");
    }

    public static HashMap<String, a> a(long j, String str) throws Throwable {
        File file = new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
        String[] list = file.list();
        HashMap<String, a> map = new HashMap<>();
        if (list != null) {
            for (String str2 : list) {
                File file2 = new File(file, str2);
                long length = file2.length();
                try {
                    JSONArray jSONArrayA = com.apm.insight.o.j.a(file2, length > 1048576 ? length - PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : 0L);
                    int length2 = jSONArrayA.length() - 1;
                    while (true) {
                        if (length2 >= 0) {
                            String strOptString = jSONArrayA.optString(length2);
                            if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith(str)) {
                                map.put(str2.replace('_', ':').replace(".txt", ""), new a(strOptString));
                                break;
                            }
                            length2--;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
        return map;
    }

    public static void a() {
        File file;
        String[] list;
        if (com.apm.insight.o.a.b(com.apm.insight.g.f()) && (list = (file = new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/ProcessTrack/")).list()) != null && list.length > 25) {
            Arrays.sort(list);
            for (int i = 0; i < list.length - 25; i++) {
                com.apm.insight.o.j.a(new File(file, list[i]));
            }
        }
    }

    public static void a(String str, String str2) {
        try {
            File fileB = b();
            if (fileB != null) {
                com.apm.insight.o.j.a(fileB, b + ' ' + str + ' ' + str2 + ' ' + System.currentTimeMillis() + '\n', true);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3, long j) {
        if (com.apm.insight.g.u() == 0) {
            return;
        }
        try {
            File fileB = b();
            if (fileB != null) {
                com.apm.insight.o.j.a(fileB, b + ' ' + str + ' ' + com.apm.insight.o.b.a().format(new Date(j)) + " : " + str2 + ' ' + str3 + '\n', true);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.apm.insight.entity.a r11, int r12, long r13, java.lang.String r15) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r2 = 0
            r3 = 1
            r4 = 0
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lc2
            java.io.FileReader r6 = new java.io.FileReader     // Catch: java.lang.Throwable -> Lc2
            java.io.File r13 = a(r15, r13)     // Catch: java.lang.Throwable -> Lc2
            r6.<init>(r13)     // Catch: java.lang.Throwable -> Lc2
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lc2
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r13.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r12 = r13.append(r12)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r13 = " activityLifeCycle "
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> Lbf
            int r13 = r12.length()     // Catch: java.lang.Throwable -> Lbf
            r14 = r2
        L33:
            java.lang.String r15 = r5.readLine()     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r4 = "onResume"
            if (r15 == 0) goto L5c
            boolean r6 = r15.startsWith(r12)     // Catch: java.lang.Throwable -> Lc0
            if (r6 == 0) goto L33
            java.lang.String r15 = r15.substring(r13)     // Catch: java.lang.Throwable -> Lc0
            r0.put(r15)     // Catch: java.lang.Throwable -> Lc0
            boolean r4 = r15.contains(r4)     // Catch: java.lang.Throwable -> Lc0
            if (r4 == 0) goto L51
            int r14 = r14 + 1
            goto L33
        L51:
            java.lang.String r4 = "onPause"
            boolean r15 = r15.contains(r4)     // Catch: java.lang.Throwable -> Lc0
            if (r15 == 0) goto L33
            int r14 = r14 + (-1)
            goto L33
        L5c:
            java.lang.String r12 = "activity_track"
            r11.a(r12, r0)     // Catch: java.lang.Throwable -> Lc0
            int r12 = r0.length()     // Catch: java.lang.Throwable -> Lc0
            int r12 = r12 - r3
            r13 = r2
            r15 = r13
        L68:
            if (r12 < 0) goto Lb6
            java.lang.String r6 = r0.optString(r12)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r7 = "onCreate"
            boolean r7 = r6.contains(r7)     // Catch: java.lang.Throwable -> Lc0
            r8 = 3
            java.lang.String r9 = "name"
            java.lang.String r10 = " "
            if (r7 == 0) goto L92
            if (r13 != 0) goto L92
            java.lang.String[] r13 = r6.split(r10)     // Catch: java.lang.Throwable -> Lc0
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lc0
            r6.<init>()     // Catch: java.lang.Throwable -> Lc0
            r13 = r13[r8]     // Catch: java.lang.Throwable -> Lc0
            r6.put(r9, r13)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r13 = "last_create_activity"
            r1.put(r13, r6)     // Catch: java.lang.Throwable -> Lc0
            r13 = r3
            goto Lae
        L92:
            boolean r7 = r6.contains(r4)     // Catch: java.lang.Throwable -> Lc0
            if (r7 == 0) goto Lae
            if (r15 != 0) goto Lae
            java.lang.String[] r15 = r6.split(r10)     // Catch: java.lang.Throwable -> Lc0
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lc0
            r6.<init>()     // Catch: java.lang.Throwable -> Lc0
            r15 = r15[r8]     // Catch: java.lang.Throwable -> Lc0
            r6.put(r9, r15)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r15 = "last_resume_activity"
            r1.put(r15, r6)     // Catch: java.lang.Throwable -> Lc0
            r15 = r3
        Lae:
            if (r13 == 0) goto Lb3
            if (r15 == 0) goto Lb3
            goto Lb6
        Lb3:
            int r12 = r12 + (-1)
            goto L68
        Lb6:
            java.lang.String r12 = "activity_trace"
            r11.a(r12, r1)     // Catch: java.lang.Throwable -> Lc0
            com.apm.insight.o.l.a(r5)
            goto Lc6
        Lbf:
            r14 = r2
        Lc0:
            r4 = r5
            goto Lc3
        Lc2:
            r14 = r2
        Lc3:
            com.apm.insight.o.l.a(r4)
        Lc6:
            if (r14 <= 0) goto Lc9
            r2 = r3
        Lc9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.s.a(com.apm.insight.entity.a, int, long, java.lang.String):boolean");
    }

    private static File b() {
        if (a == null) {
            String strC = com.apm.insight.o.a.c(com.apm.insight.g.f());
            if (strC == null) {
                return null;
            }
            b = String.valueOf(Process.myPid());
            long jCurrentTimeMillis = System.currentTimeMillis();
            a = new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/ProcessTrack/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % 86400000)) / 86400000) + '/' + strC.replace(':', '_') + ".txt");
            q.b().a(new Runnable() { // from class: com.apm.insight.runtime.s.1
                @Override // java.lang.Runnable
                public void run() {
                    s.a();
                }
            }, 15000L);
        }
        return a;
    }
}
