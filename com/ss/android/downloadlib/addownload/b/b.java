package com.ss.android.downloadlib.addownload.b;

import android.content.Context;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.downloader.downloader.h;
import java.io.File;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    public static void d() throws Throwable {
        List<com.ss.android.socialbase.downloader.h.b> listD = com.ss.android.socialbase.appdownloader.c.mk().d(mq.getContext());
        if (listD == null || listD.size() <= 0) {
            return;
        }
        for (int i = 0; i < listD.size(); i++) {
            com.ss.android.socialbase.downloader.h.b bVar = listD.get(i);
            File file = new File(bVar.mq(), bVar.uo());
            long jLastModified = file.lastModified();
            long jD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("download_file_expire_hours", 0) * 3600000;
            if (jD <= 0) {
                jD = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - jLastModified >= jD) {
                d(file);
                h.hc(mq.getContext()).tc(bVar.h());
            }
        }
    }

    public static void hc() throws Throwable {
        List listHc = h.hc(mq.getContext()).hc("application/vnd.android.package-archive");
        if (listHc == null || listHc.isEmpty()) {
            return;
        }
        for (int i = 0; i < listHc.size(); i++) {
            com.ss.android.socialbase.downloader.h.b bVar = (com.ss.android.socialbase.downloader.h.b) listHc.get(i);
            if (bVar != null) {
                String str = bVar.mk() + File.separator + bVar.gb();
                File file = new File(str);
                if (file.exists()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long jD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("download_complete_file_expire_hours", 0) * 3600000;
                    if (jD <= 0) {
                        jD = 604800000;
                    }
                    boolean z = true;
                    if (jCurrentTimeMillis < jD && !uo.an(mq.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        d(file);
                    }
                }
            }
        }
    }

    public static void d(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            d(externalCacheDir.getPath());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(java.io.File r3) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            java.lang.String r0 = "1"
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            r1.write(r0)     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            r1.close()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            goto L28
        L13:
            r0 = move-exception
            goto L1b
        L15:
            r3 = move-exception
            goto L2e
        L17:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L1b:
            com.bytedance.sdk.component.utils.mq.d(r0)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L28
            r1.close()     // Catch: java.lang.Exception -> L24
            goto L28
        L24:
            r0 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r0)
        L28:
            r3.delete()
            return
        L2c:
            r3 = move-exception
            r0 = r1
        L2e:
            if (r0 == 0) goto L38
            r0.close()     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r0 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r0)
        L38:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.b.b.d(java.io.File):void");
    }

    private static void d(String str) {
        String str2;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str3 : list) {
                if (str3 != null) {
                    if (str.endsWith(File.separator)) {
                        str2 = str + str3;
                    } else {
                        str2 = str + File.separator + str3;
                    }
                    File file2 = new File(str2);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        d(str2);
                    }
                }
            }
            file.delete();
        }
    }
}
