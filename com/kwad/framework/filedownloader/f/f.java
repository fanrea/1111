package com.kwad.framework.filedownloader.f;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.sdk.utils.ay;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f {
    private static int bhs = 65536;
    private static long bht = 2000;
    private static String bhu;
    private static Boolean bhv;
    private static Boolean bhw;
    private static final Pattern bhx = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static void dO(int i) throws IllegalAccessException {
        if (aU(c.OV())) {
            bhs = i;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    public static void aA(long j) throws IllegalAccessException {
        if (aU(c.OV())) {
            bht = j;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    private static int OZ() {
        return bhs;
    }

    private static long Pa() {
        return bht;
    }

    private static String Pb() {
        if (!TextUtils.isEmpty(bhu)) {
            return bhu;
        }
        if (c.OV().getExternalCacheDir() == null) {
            return Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        return c.OV().getExternalCacheDir().getAbsolutePath();
    }

    public static String cD(String str) {
        return F(Pb(), cE(str));
    }

    private static String cE(String str) {
        return md5(str);
    }

    private static String F(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str != null) {
            return c("%s%s%s", str, File.separator, str2);
        }
        throw new IllegalStateException("can't generate real path, the directory is null");
    }

    public static String cF(String str) {
        return c("%s.temp", str);
    }

    public static int G(String str, String str2) {
        return com.kwad.framework.filedownloader.download.b.Ny().Nz().i(str, str2, false);
    }

    public static int i(String str, String str2, boolean z) {
        return com.kwad.framework.filedownloader.download.b.Ny().Nz().i(str, str2, z);
    }

    public static String md5(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Huh, MD5 should be supported?", e2);
        }
    }

    public static boolean aU(Context context) {
        boolean zEndsWith;
        Boolean bool = bhv;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (e.OX().bhn) {
            zEndsWith = true;
        } else {
            if (((ActivityManager) context.getSystemService("activity")) == null) {
                d.d(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
            zEndsWith = ay.getProcessName(context).endsWith(":filedownloader");
        }
        Boolean boolValueOf = Boolean.valueOf(zEndsWith);
        bhv = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static String c(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception unused) {
            return str;
        }
    }

    public static void aV(Context context) throws IOException {
        File fileAW = aW(context);
        try {
            fileAW.getParentFile().mkdirs();
            fileAW.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File aW(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String cG(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = bhx.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static String a(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (!z) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return F(str, str2);
    }

    public static String cH(String str) {
        int length = str.length();
        int i = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int iLastIndexOf = str.lastIndexOf(File.separatorChar);
        int i2 = (iLastIndexOf != -1 || i <= 0) ? iLastIndexOf : 2;
        if (i2 == -1 || str.charAt(length - 1) == File.separatorChar) {
            return null;
        }
        if (str.indexOf(File.separatorChar) == i2 && str.charAt(i) == File.separatorChar) {
            return str.substring(0, i2 + 1);
        }
        return str.substring(0, i2);
    }

    public static String cI(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean Pc() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.OV().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.d(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static boolean cJ(String str) {
        return c.OV().checkCallingOrSelfPermission(str) == 0;
    }

    private static long cK(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static String a(int i, com.kwad.framework.filedownloader.a.b bVar) {
        if (bVar == null) {
            throw new RuntimeException("connection is null when findEtag");
        }
        String strCp = bVar.cp("Etag");
        if (d.bhj) {
            d.c(f.class, "etag find %s for task(%d)", strCp, Integer.valueOf(i));
        }
        return strCp;
    }

    public static long b(int i, com.kwad.framework.filedownloader.a.b bVar) {
        long jCK = cK(bVar.cp("Content-Length"));
        String strCp = bVar.cp("Transfer-Encoding");
        if (jCK >= 0) {
            return jCK;
        }
        if (!(strCp != null && strCp.equals("chunked"))) {
            if (e.OX().bhm) {
                if (d.bhj) {
                    d.c(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i));
                }
            } else {
                throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
            }
        }
        return -1L;
    }

    public static String a(com.kwad.framework.filedownloader.a.b bVar, String str) {
        String strCG = cG(bVar.cp("Content-Disposition"));
        if (TextUtils.isEmpty(strCG)) {
            strCG = cE(str);
        }
        return strCG.replaceAll("\\/", Config.replace);
    }

    public static com.kwad.framework.filedownloader.e.a cL(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            file.delete();
            if (!file.createNewFile()) {
                throw new RuntimeException(c("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
            }
        }
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException(c("create new file error  %s", file.getAbsolutePath()));
        }
        return com.kwad.framework.filedownloader.download.b.Ny().b(file);
    }

    public static boolean b(int i, com.kwad.framework.filedownloader.d.c cVar) {
        return a(i, cVar, (Boolean) null);
    }

    private static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.bhj) {
                d.c(f.class, "can't continue %d model == null", Integer.valueOf(i));
            }
            return false;
        }
        if (cVar.NN() == null) {
            if (d.bhj) {
                d.c(f.class, "can't continue %d temp path == null", Integer.valueOf(i));
            }
            return false;
        }
        return a(i, cVar, cVar.NN(), null);
    }

    public static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (!d.bhj) {
                return false;
            }
            d.c(f.class, "can't continue %d path = null", Integer.valueOf(i));
            return false;
        }
        File file = new File(str);
        boolean zExists = file.exists();
        boolean zIsDirectory = file.isDirectory();
        if (!zExists || zIsDirectory) {
            if (!d.bhj) {
                return false;
            }
            d.c(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i), Boolean.valueOf(zExists), Boolean.valueOf(zIsDirectory));
            return false;
        }
        long length = file.length();
        long jOv = cVar.Ov();
        if (cVar.Oy() <= 1 && jOv == 0) {
            if (!d.bhj) {
                return false;
            }
            d.c(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i));
            return false;
        }
        long total = cVar.getTotal();
        if (length < jOv || (total != -1 && (length > total || jOv >= total))) {
            if (!d.bhj) {
                return false;
            }
            d.c(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i), Long.valueOf(length), Long.valueOf(jOv), Long.valueOf(total));
            return false;
        }
        if (bool == null || bool.booleanValue() || total != length) {
            return true;
        }
        if (!d.bhj) {
            return false;
        }
        d.c(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i));
        return false;
    }

    public static void H(String str, String str2) {
        cM(str2);
        cN(str);
    }

    private static void cM(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void cN(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static boolean r(long j, long j2) {
        return j > ((long) OZ()) && j2 > Pa();
    }

    public static String Pd() {
        return c("FileDownloader/%s", BuildConfig.VERSION_NAME);
    }
}
