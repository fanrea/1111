package com.bytedance.sdk.component.panglearmor.d.hc;

import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.kuaishou.weapon.p0.t;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    @DungeonFlag
    private static String d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static void d(JSONObject jSONObject, String str, List<String> list, boolean z) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return;
        }
        if (z) {
            try {
                jSONObject.put(str + "Size", list.size());
            } catch (JSONException unused) {
                return;
            }
        }
        jSONObject.put(str, u.d(list));
    }

    private static JSONObject d(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : list) {
            if (str.endsWith(PictureMimeType.PNG)) {
                arrayList2.add(str.substring(0, str.lastIndexOf(PictureMimeType.PNG)));
            } else if (str.endsWith(".xml")) {
                arrayList.add(str.substring(0, str.lastIndexOf(".xml")));
            } else {
                arrayList3.add(str);
            }
        }
        d(jSONObject, "xml", arrayList, true);
        d(jSONObject, "png", arrayList2, true);
        d(jSONObject, "other", arrayList3, true);
        return jSONObject;
    }

    private static JSONObject hc(List<d> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        for (d dVar : list) {
            if (dVar != null) {
                arrayList.add(d(dVar.hc()));
                arrayList2.add(String.valueOf(dVar.d()));
            }
        }
        d(jSONObject, "sign", arrayList, false);
        d(jSONObject, "subject", arrayList2, false);
        return jSONObject;
    }

    public static long d(long j, InputStream inputStream) throws IOException {
        if (j != -1) {
            return j;
        }
        long j2 = 0;
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j2;
            }
            j2 += i;
        }
    }

    private static void d(File file, List<d> list) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, t.k);
            try {
                hc hcVarD = b.d(randomAccessFile, 0L, randomAccessFile.length());
                list.addAll(com.bytedance.sdk.component.panglearmor.d.d.hc.d.d.d.d(hcVarD, com.bytedance.sdk.component.panglearmor.d.d.d.d.d(hcVarD)));
                randomAccessFile.close();
            } finally {
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x026b A[EXC_TOP_SPLITTER, PHI: r8 r10
  0x026b: PHI (r8v2 org.json.JSONObject) = (r8v4 org.json.JSONObject), (r8v7 org.json.JSONObject), (r8v7 org.json.JSONObject) binds: [B:117:0x0276, B:110:0x0264, B:111:0x0266] A[DONT_GENERATE, DONT_INLINE]
  0x026b: PHI (r10v1 java.util.zip.ZipFile) = (r10v2 java.util.zip.ZipFile), (r10v3 java.util.zip.ZipFile), (r10v3 java.util.zip.ZipFile) binds: [B:117:0x0276, B:110:0x0264, B:111:0x0266] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @com.bytedance.component.sdk.annotation.DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject d(java.io.File r23) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.panglearmor.d.hc.an.d(java.io.File):org.json.JSONObject");
    }
}
