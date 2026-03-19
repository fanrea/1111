package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.plugin.hc;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pblm {
    private static final String d;

    static {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c20335", new byte[]{73, 108, 2, 25, com.sigmob.sdk.archives.tar.e.I});
        d = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fdcd86", new byte[]{99, 114, 47, 30, 3});
    }

    public static synchronized String d(Context context) {
        String strD;
        String str;
        String string;
        String strD2;
        try {
            StringBuilder sbAppend = new StringBuilder().append(hc.d(context).getAbsolutePath()).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a92395", new byte[]{Utf8.REPLACEMENT_BYTE}));
            str = d;
            string = sbAppend.append(str).toString();
        } catch (Throwable unused) {
            strD = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f7511c", new byte[]{39, 14, 26, 4, 80, 73, 64, 46, 71, 68, 71, 1, 111, 106, 32, 79, 57, 87, 58, 92});
        }
        if (new File(string).exists() && (strD2 = d(string)) != null && strD2.length() > 0) {
            return strD2;
        }
        InputStream inputStreamOpen = context.getResources().getAssets().open(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStreamOpen.read(bArr, 0, 4096);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(string);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.close();
        d(((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "11bcdb", new byte[]{35, 59, 28, 24, 95, com.sigmob.sdk.archives.tar.e.M, 101, 71, 100, 115})) + string);
        strD = d(string);
        if (strD != null && strD.length() != 0) {
            if (strD != null) {
            }
            strD = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "64e5b8", new byte[]{119, 13, 74, 0, 3, 18, 16, 39, 6, 74, 21, 13, 74, 0, 3, 18});
            return strD;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(string, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "929bda", new byte[]{58, 39}));
        randomAccessFile.seek(16L);
        randomAccessFile.write(new byte[]{2});
        randomAccessFile.close();
        strD = d(string);
        if (strD != null || strD.length() == 0) {
            strD = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "64e5b8", new byte[]{119, 13, 74, 0, 3, 18, 16, 39, 6, 74, 21, 13, 74, 0, 3, 18});
        }
        return strD;
    }

    private static String d(BufferedInputStream bufferedInputStream) throws IOException {
        int i;
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i = bufferedInputStream.read(bArr);
                if (i > 0) {
                    sb.append(new String(bArr, 0, i));
                }
            } catch (Exception unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "89a04e", new byte[]{44, com.sigmob.sdk.archives.tar.e.J, 17});
            }
        } while (i >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3 A[PHI: r3 r5
  0x00e3: PHI (r3v6 java.lang.String) = (r3v8 java.lang.String), (r3v7 java.lang.String) binds: [B:35:0x00e0, B:13:0x007a] A[DONT_GENERATE, DONT_INLINE]
  0x00e3: PHI (r5v7 java.lang.Process) = (r5v6 java.lang.Process), (r5v9 java.lang.Process) binds: [B:35:0x00e0, B:13:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String d(java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblm.d(java.lang.String):java.lang.String");
    }
}
