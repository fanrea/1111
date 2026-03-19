package lkxssdk.m;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
        System.getProperty("line.separator");
    }

    public static File a(String str) {
        if (d(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? b(file) : !file.exists() || (file.isFile() && file.delete());
    }

    public static String b(String str) {
        File fileA = a(str);
        if (fileA != null) {
            if (fileA.isDirectory()) {
                long jC = c(fileA);
                if (jC != -1) {
                    return a.a(jC);
                }
            } else {
                long length = !(fileA.exists() && fileA.isFile()) ? -1L : fileA.length();
                if (length != -1) {
                    return a.a(length);
                }
            }
        }
        return "";
    }

    public static boolean b(File file) {
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !b(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static long c(File file) {
        long jC = 0;
        if (!(file != null && file.exists() && file.isDirectory())) {
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                jC += file2.isDirectory() ? c(file2) : file2.length();
            }
        }
        return jC;
    }

    public static boolean d(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str) throws IOException {
        File fileA = a(str);
        if (fileA == null) {
            return false;
        }
        if (fileA.exists()) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = lkxssdk.a.a.d().getContentResolver().openAssetFileDescriptor(Uri.parse(str), t.k);
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                return false;
            }
            try {
                assetFileDescriptorOpenAssetFileDescriptor.close();
            } catch (IOException unused) {
            }
            return true;
        } catch (FileNotFoundException unused2) {
            return false;
        }
    }
}
