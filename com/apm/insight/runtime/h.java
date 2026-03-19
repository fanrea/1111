package com.apm.insight.runtime;

import android.text.TextUtils;
import com.apm.insight.CrashInfoCallback;
import com.apm.insight.CrashType;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h {
    public static void a(File file, CrashType crashType, String str) {
        try {
            if (a.k()) {
                File file2 = crashType == CrashType.ANR ? null : new File(file, "external_files");
                if (file2 == null || !file2.exists()) {
                    file.mkdirs();
                    ArrayList arrayList = new ArrayList();
                    List<CrashInfoCallback> listF = p.a().f();
                    Iterator<CrashInfoCallback> it = listF.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        File[] fileArrCrashFileList = it.next().crashFileList(crashType);
                        if (fileArrCrashFileList != null) {
                            long j = 0;
                            for (File file3 : fileArrCrashFileList) {
                                if (file3.exists() && !file3.isDirectory()) {
                                    if (crashType == CrashType.ANR) {
                                        long length = file3.length();
                                        if (length <= 1048576) {
                                            long j2 = length + j;
                                            if (j2 <= 20971520) {
                                                arrayList.add(file3);
                                                j = j2;
                                            }
                                        }
                                    } else {
                                        com.apm.insight.o.j.a(file2, file3.getAbsolutePath() + "\n", true);
                                    }
                                }
                            }
                        }
                    }
                    if (crashType != CrashType.ANR || arrayList.isEmpty()) {
                        return;
                    }
                    com.apm.insight.n.f.c(com.apm.insight.g.h().getFileUploadUrl(), str, (File[]) arrayList.toArray(new File[0]));
                    for (CrashInfoCallback crashInfoCallback : listF) {
                        if (crashInfoCallback != null) {
                            crashInfoCallback.onFileUpload(arrayList);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(File file, String str) {
        if (a.k()) {
            File file2 = new File(file, "external_files");
            if (file2.exists()) {
                try {
                    JSONArray jSONArrayB = com.apm.insight.o.j.b(file2.getAbsolutePath());
                    if (jSONArrayB == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    long j = 0;
                    for (int i = 0; i < jSONArrayB.length(); i++) {
                        String strOptString = jSONArrayB.optString(i);
                        if (!TextUtils.isEmpty(strOptString)) {
                            File file3 = new File(strOptString);
                            if (file3.exists()) {
                                long length = file3.length() + j;
                                if (length <= 20971520) {
                                    arrayList.add(file3);
                                    j = length;
                                }
                            }
                        }
                    }
                    com.apm.insight.n.f.c(com.apm.insight.g.h().getFileUploadUrl(), str, (File[]) arrayList.toArray(new File[0]));
                    for (CrashInfoCallback crashInfoCallback : p.a().f()) {
                        if (crashInfoCallback != null) {
                            crashInfoCallback.onFileUpload(arrayList);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
