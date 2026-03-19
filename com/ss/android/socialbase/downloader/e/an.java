package com.ss.android.socialbase.downloader.e;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.mq;
import com.kuaishou.socket.nano.SocketMessages;
import com.ss.android.socialbase.downloader.c.hv;
import com.ss.android.socialbase.downloader.c.zw;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    private static final String d = "an";
    private static Boolean mk;
    private static Boolean tc;
    private static ConnectivityManager tt;
    private static final Pattern hc = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String b = null;
    private static volatile SparseArray<Boolean> c = new SparseArray<>();
    private static volatile SparseArray<List<hv>> u = new SparseArray<>();
    private static final char[] an = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern h = null;
    private static Pattern gb = null;

    public static boolean b(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static boolean c(int i) {
        return i == 206 || i == 200;
    }

    public static double d(long j) {
        return j / 1048576.0d;
    }

    public static boolean d(int i) {
        return i == 0 || i == 2;
    }

    public static boolean hc(long j) {
        return j == -1;
    }

    public static String d(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return d(bArr, 0, bArr.length);
    }

    public static String d(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & 255;
            int i7 = i4 + 1;
            char[] cArr2 = an;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            } catch (Exception e) {
                mq.d(e);
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            mq.d(e2);
            return str;
        }
    }

    public static long d(com.ss.android.socialbase.downloader.tt.h hVar) {
        if (hVar == null) {
            return -1L;
        }
        String strHc = hc(hVar, "Content-Length");
        if (TextUtils.isEmpty(strHc) && d.d(1)) {
            return hc(hVar);
        }
        try {
            return Long.parseLong(strHc);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long hc(com.ss.android.socialbase.downloader.tt.h hVar) throws NumberFormatException {
        if (hVar == null) {
            return -1L;
        }
        String strHc = hc(hVar, "Content-Range");
        if (TextUtils.isEmpty(strHc)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(strHc);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e) {
            com.ss.android.socialbase.downloader.an.d.c(d, "parse content-length from content-range failed " + e);
        }
        return -1L;
    }

    public static long hc(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.ss.android.socialbase.downloader.an.d.c(d, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    private static String tc(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (h == null) {
                h = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = h.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (gb == null) {
            gb = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = gb.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static String d(com.ss.android.socialbase.downloader.tt.h hVar, String str) {
        String strTc = tc(hVar.d("Content-Disposition"));
        return TextUtils.isEmpty(strTc) ? u(str) : strTc;
    }

    public static com.ss.android.socialbase.downloader.h.h d(com.ss.android.socialbase.downloader.h.b bVar, String str, String str2, int i) throws com.ss.android.socialbase.downloader.u.d, InterruptedException, IOException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new com.ss.android.socialbase.downloader.u.d(1021, new IOException("path must be not empty"));
        }
        File file = new File(str, str2);
        boolean zMkdirs = false;
        if (file.exists() && file.isDirectory()) {
            throw new com.ss.android.socialbase.downloader.u.d(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
        }
        if (!file.exists()) {
            try {
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    if (!file2.exists()) {
                        if (!file2.mkdirs() && !file2.exists()) {
                            if (com.ss.android.socialbase.downloader.uo.d.d(bVar).d("opt_mkdir_failed", 0) != 1) {
                                throw new com.ss.android.socialbase.downloader.u.d(1030, "download savePath directory can not created:" + str);
                            }
                            int i2 = 0;
                            while (!zMkdirs) {
                                int i3 = i2 + 1;
                                if (i2 >= 3) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                    zMkdirs = file2.mkdirs();
                                    i2 = i3;
                                } catch (InterruptedException unused) {
                                }
                            }
                            if (!zMkdirs) {
                                if (c(bVar.mk()) < 16384) {
                                    throw new com.ss.android.socialbase.downloader.u.d(1006, "download savePath directory can not created:" + str);
                                }
                                throw new com.ss.android.socialbase.downloader.u.d(1030, "download savePath directory can not created:" + str);
                            }
                        }
                    } else {
                        file2.delete();
                        if (!file2.mkdirs() && !file2.exists()) {
                            throw new com.ss.android.socialbase.downloader.u.d(1031, "download savePath is not directory:path=" + str);
                        }
                        throw new com.ss.android.socialbase.downloader.u.d(1031, "download savePath is not directory:" + str);
                    }
                }
                file.createNewFile();
            } catch (IOException e) {
                throw new com.ss.android.socialbase.downloader.u.d(1036, e);
            }
        }
        return new com.ss.android.socialbase.downloader.h.h(file, i);
    }

    public static List<com.ss.android.socialbase.downloader.h.hc> d(List<com.ss.android.socialbase.downloader.h.hc> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.h.hc hcVar : list) {
            if (hcVar != null) {
                if (hcVar.c()) {
                    sparseArray.put(hcVar.rf(), hcVar);
                    List<com.ss.android.socialbase.downloader.h.hc> list2 = (List) sparseArray2.get(hcVar.rf());
                    if (list2 != null) {
                        Iterator<com.ss.android.socialbase.downloader.h.hc> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().d(hcVar);
                        }
                        hcVar.d(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.h.hc hcVar2 = (com.ss.android.socialbase.downloader.h.hc) sparseArray.get(hcVar.hc());
                    if (hcVar2 != null) {
                        List<com.ss.android.socialbase.downloader.h.hc> listH = hcVar2.h();
                        if (listH == null) {
                            listH = new ArrayList<>();
                            hcVar2.d(listH);
                        }
                        hcVar.d(hcVar2);
                        listH.add(hcVar);
                    } else {
                        List arrayList = (List) sparseArray2.get(hcVar.hc());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            sparseArray2.put(hcVar.hc(), arrayList);
                        }
                        arrayList.add(hcVar);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList2.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList2.isEmpty() ? list : arrayList2;
    }

    public static String d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String hc(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static long hc(List<com.ss.android.socialbase.downloader.h.hc> list) {
        Iterator<com.ss.android.socialbase.downloader.h.hc> it = list.iterator();
        long jE = 0;
        while (it.hasNext()) {
            jE += it.next().e();
        }
        return jE;
    }

    public static void d(com.ss.android.socialbase.downloader.h.b bVar) {
        d(bVar, true);
    }

    public static void d(com.ss.android.socialbase.downloader.h.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        if (z) {
            try {
                b(bVar.mk(), bVar.gb());
            } catch (Throwable th) {
                mq.d(th);
                return;
            }
        }
        b(bVar.mq(), bVar.uo());
        if (bVar.nu()) {
            hc(bVar);
        }
        if (z) {
            String strU = u(bVar.tc());
            if (TextUtils.isEmpty(strU) || TextUtils.isEmpty(bVar.mk()) || !bVar.mk().contains(strU)) {
                return;
            }
            mk(bVar.mk());
        }
    }

    public static void hc(com.ss.android.socialbase.downloader.h.b bVar) {
        com.ss.android.socialbase.downloader.uo.d dVarD;
        JSONObject jSONObjectC;
        if (bVar == null || (jSONObjectC = (dVarD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h())).c("download_dir")) == null) {
            return;
        }
        String strOptString = jSONObjectC.optString("ins_desc");
        if (!TextUtils.isEmpty(strOptString)) {
            b(bVar.mk(), strOptString);
        }
        String strTt = bVar.tt();
        if (TextUtils.isEmpty(strTt)) {
            strTt = bVar.gb();
        }
        String strD = d(strTt, dVarD);
        String strMk = bVar.mk();
        if (TextUtils.isEmpty(strD) || TextUtils.isEmpty(strMk)) {
            return;
        }
        File file = new File(strD);
        for (File file2 = new File(strMk); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            mk(file2.getPath());
            file = file.getParentFile();
        }
    }

    private static boolean mk(String str) {
        String str2 = d;
        mq.hc(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                mq.hc(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            mq.c(d, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    public static boolean d(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean b(com.ss.android.socialbase.downloader.h.b bVar) {
        return d(bVar, bVar.fv(), bVar.fs());
    }

    public static boolean d(com.ss.android.socialbase.downloader.h.b bVar, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(bVar.mk()) && !TextUtils.isEmpty(bVar.gb())) {
            try {
                if (new File(bVar.mk(), bVar.gb()).exists()) {
                    if (hc(bVar.mk(), bVar.gb(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e) {
                mq.d(e);
            }
        }
        return false;
    }

    public static boolean c(com.ss.android.socialbase.downloader.h.b bVar) {
        boolean z = false;
        if (!bVar.gw() && TextUtils.isEmpty(bVar.nr())) {
            com.ss.android.socialbase.downloader.an.d.hc(d, "dcache::last modify is emtpy, so just return cache");
        } else {
            com.ss.android.socialbase.downloader.an.d.hc(d, "dcache::curt=" + System.currentTimeMillis() + " expired=" + bVar.nw());
            if (System.currentTimeMillis() > bVar.nw()) {
                z = true;
            }
        }
        com.ss.android.socialbase.downloader.an.d.hc(d, "cacheExpired::dcache::name=" + bVar.gb() + " expired=" + z);
        return z;
    }

    public static int d(String str, String str2, String str3) {
        return com.ss.android.b.b.d(str3, new File(str, str2));
    }

    public static boolean hc(String str, String str2, String str3) {
        return d(d(str, str2, str3));
    }

    public static int d(File file, String str) {
        return com.ss.android.b.b.d(str, file);
    }

    public static String hc(int i) {
        String str = "ttmd5 check code = " + i + ", ";
        if (i != 99) {
            switch (i) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        }
        return str + "unknown error";
    }

    public static long c(String str) throws com.ss.android.socialbase.downloader.u.d {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (IllegalArgumentException e) {
            throw new com.ss.android.socialbase.downloader.u.d(1050, e);
        } catch (Throwable th) {
            throw new com.ss.android.socialbase.downloader.u.d(1052, th);
        }
    }

    public static void d(com.ss.android.socialbase.downloader.h.b bVar, zw zwVar, hv hvVar) {
        boolean z;
        com.ss.android.socialbase.downloader.u.d dVar;
        boolean z2;
        String str = d;
        com.ss.android.socialbase.downloader.an.d.hc(str, "saveFileAsTargetName targetName is " + bVar.k());
        try {
            synchronized (c) {
                if (c.get(bVar.h()) == Boolean.TRUE) {
                    com.ss.android.socialbase.downloader.an.d.hc(str, "has another same task is saving temp file");
                    if (hvVar != null) {
                        List<hv> arrayList = u.get(bVar.h());
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            u.put(bVar.h(), arrayList);
                        }
                        arrayList.add(hvVar);
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.an.d.hc(str, "saveTempFileStatusMap put id:" + bVar.h());
                c.put(bVar.h(), Boolean.TRUE);
                File file = new File(bVar.mq(), bVar.uo());
                File file2 = new File(bVar.mk(), bVar.gb());
                boolean zGb = gb(bVar.mk());
                if (file2.exists()) {
                    com.ss.android.socialbase.downloader.an.d.hc(str, "targetFile exist");
                    int iD = d(file2, bVar.fs());
                    if (d(iD)) {
                        com.ss.android.socialbase.downloader.an.d.hc(str, "tempFile not exist , targetFile exists and md5 check valid");
                        bVar.d(iD);
                        if (hvVar != null) {
                            hvVar.d();
                        }
                        d(bVar.h(), true, (com.ss.android.socialbase.downloader.u.d) null);
                    } else {
                        if (file.exists()) {
                            z = true;
                        } else {
                            com.ss.android.socialbase.downloader.u.d dVar2 = new com.ss.android.socialbase.downloader.u.d(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", bVar.mq(), bVar.uo(), bVar.mk(), bVar.gb(), hc(iD)));
                            if (hvVar != null) {
                                hvVar.d(dVar2);
                            }
                            d(bVar.h(), false, dVar2);
                            z = false;
                        }
                        if (zGb && !file2.delete()) {
                            if (z) {
                                com.ss.android.socialbase.downloader.u.d dVar3 = new com.ss.android.socialbase.downloader.u.d(1037, "delete targetPath file existed with md5 check invalid status:" + hc(iD));
                                if (hvVar != null) {
                                    hvVar.d(dVar3);
                                }
                                d(bVar.h(), false, dVar3);
                            } else if (zwVar != null) {
                                com.ss.android.socialbase.downloader.gb.d.d(zwVar, bVar, new com.ss.android.socialbase.downloader.u.d(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), bVar.w());
                            }
                        }
                    }
                    z = false;
                } else if (file.exists()) {
                    z = true;
                } else {
                    com.ss.android.socialbase.downloader.u.d dVar4 = new com.ss.android.socialbase.downloader.u.d(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", bVar.mq(), bVar.uo(), bVar.mk(), bVar.gb()));
                    if (hvVar != null) {
                        hvVar.d(dVar4);
                    }
                    d(bVar.h(), false, dVar4);
                    z = false;
                }
                if (z) {
                    try {
                        int iD2 = com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("download_finish_check_ttmd5", 2);
                        if (iD2 > 0) {
                            int iD3 = d(file, bVar.fs());
                            bVar.d(iD3);
                            if (iD2 >= 2 && !d(iD3)) {
                                com.ss.android.socialbase.downloader.u.d dVar5 = new com.ss.android.socialbase.downloader.u.d(1034, hc(iD3));
                                if (hvVar != null) {
                                    hvVar.d(dVar5);
                                }
                                d(bVar.h(), false, dVar5);
                                d(bVar, zGb);
                                return;
                            }
                        }
                        z2 = !hc(file, file2);
                        dVar = null;
                    } catch (com.ss.android.socialbase.downloader.u.d e) {
                        if (com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("fix_file_rename_failed")) {
                            dVar = e;
                            z2 = true;
                        } else {
                            dVar = e;
                            z2 = false;
                        }
                    }
                    if (z2) {
                        if (dVar == null) {
                            dVar = new com.ss.android.socialbase.downloader.u.d(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", bVar.mq(), bVar.uo(), bVar.mk(), bVar.gb()));
                        }
                        if (hvVar != null) {
                            hvVar.d(dVar);
                        }
                        d(bVar.h(), false, dVar);
                        return;
                    }
                    if (hvVar != null) {
                        hvVar.d();
                    }
                    d(bVar.h(), true, (com.ss.android.socialbase.downloader.u.d) null);
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.an.d.hc(d, "saveFileAsTargetName throwable " + th.getMessage());
            if (hvVar != null) {
                hvVar.d(new com.ss.android.socialbase.downloader.u.d(1038, hc(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void d(int i, boolean z, com.ss.android.socialbase.downloader.u.d dVar) {
        synchronized (c) {
            List<hv> list = u.get(i);
            if (list != null) {
                for (hv hvVar : list) {
                    if (hvVar != null) {
                        if (z) {
                            hvVar.d();
                        } else {
                            hvVar.d(dVar);
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.an.d.hc(d, "handleTempSaveCallback id:" + i);
            c.remove(i);
        }
    }

    public static void d(com.ss.android.socialbase.downloader.h.b bVar, String str) throws com.ss.android.socialbase.downloader.u.d {
        if (bVar == null || TextUtils.isEmpty(str) || str.equals(bVar.gb())) {
            return;
        }
        File file = new File(bVar.mk(), str);
        File file2 = new File(bVar.mk(), bVar.gb());
        mq.c(d, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new com.ss.android.socialbase.downloader.u.d(1001, "targetPath file exists but read-only");
        }
        if (!d(file, file2)) {
            throw new com.ss.android.socialbase.downloader.u.d(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", bVar.mk(), str, bVar.mk(), bVar.gb()));
        }
    }

    public static boolean d(File file, File file2) throws com.ss.android.socialbase.downloader.u.d {
        return d(file, file2, true);
    }

    public static boolean d(File file, File file2, boolean z) throws com.ss.android.socialbase.downloader.u.d {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new com.ss.android.socialbase.downloader.u.d(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    mq.c(d, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    hc(file, file2, z);
                    return true;
                }
            } catch (com.ss.android.socialbase.downloader.u.d e) {
                throw e;
            } catch (Throwable th) {
                d(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    private static void hc(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            long jTransferFrom = channel2.transferFrom(channel, j, j2 > 31457280 ? 31457280L : j2);
                            if (jTransferFrom == 0) {
                                break;
                            } else {
                                j += jTransferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        if (channel != null) {
                            channel.close();
                        }
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length != length2) {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                        }
                        if (z) {
                            file2.setLastModified(file.lastModified());
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static boolean hc(File file, File file2) throws com.ss.android.socialbase.downloader.u.d {
        String str = d;
        mq.c(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            zRenameTo = d(file, file2);
            try {
                mq.c(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        return zRenameTo;
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean d(int i, String str) {
        if (d.d(16777216)) {
            return i == 206 || i == 1;
        }
        if (i >= 400) {
            return false;
        }
        return i == 206 || i == 1 || "bytes".equals(str);
    }

    public static boolean b(com.ss.android.socialbase.downloader.tt.h hVar) {
        if (hVar == null) {
            return false;
        }
        return d.d(8) ? "chunked".equals(hVar.d("Transfer-Encoding")) || d(hVar) == -1 : d(hVar) == -1;
    }

    public static List<com.ss.android.socialbase.downloader.h.u> d(List<com.ss.android.socialbase.downloader.h.u> list, String str, com.ss.android.socialbase.downloader.h.hc hcVar) {
        return d(list, str, hcVar.uo(), hcVar.cb());
    }

    public static List<com.ss.android.socialbase.downloader.h.u> d(List<com.ss.android.socialbase.downloader.h.u> list, String str, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.h.u uVar : list) {
                if (uVar != null) {
                    arrayList.add(uVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.h.u("If-Match", str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.h.u("Accept-Encoding", "identity"));
        String str2 = j2 <= 0 ? String.format("bytes=%s-", String.valueOf(j)) : String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        arrayList.add(new com.ss.android.socialbase.downloader.h.u("Range", str2));
        com.ss.android.socialbase.downloader.an.d.hc(d, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + str2);
        return arrayList;
    }

    public static boolean d(int i, String str, String str2) {
        return i == -3 && !c(str, str2);
    }

    public static ConnectivityManager d(Context context) {
        ConnectivityManager connectivityManager = tt;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        tt = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean hc(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerD = d(context);
            if (connectivityManagerD != null && (activeNetworkInfo = connectivityManagerD.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                if (1 == activeNetworkInfo.getType()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerD = d(context);
            if (connectivityManagerD == null || (activeNetworkInfo = connectivityManagerD.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String u(String str) throws NoSuchAlgorithmException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return d(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String c(Context context) {
        String str = b;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strTc = tc();
        b = strTc;
        if (!TextUtils.isEmpty(strTc)) {
            return b;
        }
        String strMk = mk();
        b = strMk;
        if (!TextUtils.isEmpty(strMk)) {
            return b;
        }
        String strU = u(context);
        b = strU;
        if (!TextUtils.isEmpty(strU)) {
            return b;
        }
        String strTt = tt();
        b = strTt;
        return strTt;
    }

    private static String tt() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i <= 0) {
                        break;
                    }
                    sb.append((char) i);
                }
                if (com.ss.android.socialbase.downloader.an.d.d()) {
                    com.ss.android.socialbase.downloader.an.d.hc("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                d(bufferedReader);
                return string;
            } catch (Throwable unused) {
                d(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    private static String tc() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.an.d.d()) {
                com.ss.android.socialbase.downloader.an.d.hc("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception e) {
            mq.d(e);
            return null;
        }
    }

    private static String mk() {
        String str;
        Throwable th;
        Object objInvoke;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            objInvoke = declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th2) {
            str = null;
            th = th2;
        }
        if (!(objInvoke instanceof String)) {
            return null;
        }
        str = (String) objInvoke;
        try {
            if (!TextUtils.isEmpty(str) && com.ss.android.socialbase.downloader.an.d.d()) {
                com.ss.android.socialbase.downloader.an.d.hc("Process", "processName = " + str);
            }
        } catch (Throwable th3) {
            th = th3;
            mq.d(th);
            return str;
        }
        return str;
    }

    private static String u(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (com.ss.android.socialbase.downloader.an.d.d()) {
                            com.ss.android.socialbase.downloader.an.d.hc("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e) {
            mq.d(e);
        }
        return null;
    }

    public static boolean d() {
        Boolean bool = tc;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strC = c(com.ss.android.socialbase.downloader.downloader.b.tr());
        Boolean boolValueOf = Boolean.valueOf((strC == null || !strC.contains(":")) && strC != null && strC.equals(com.ss.android.socialbase.downloader.downloader.b.tr().getPackageName()));
        tc = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static boolean hc() {
        return !b() && com.ss.android.socialbase.downloader.downloader.b.hc() && com.ss.android.socialbase.downloader.impls.mq.d(true).h();
    }

    public static boolean b() {
        Boolean bool = mk;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strC = c(com.ss.android.socialbase.downloader.downloader.b.tr());
        if (strC != null && strC.equals(com.ss.android.socialbase.downloader.downloader.b.tr().getPackageName() + ":downloader")) {
            mk = Boolean.TRUE;
        } else {
            mk = Boolean.FALSE;
        }
        return mk.booleanValue();
    }

    public static boolean an(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String strC = c(com.ss.android.socialbase.downloader.downloader.b.tr());
        return strC != null && strC.equals(str);
    }

    public static boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String h(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        String strTc = tc(th);
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        return !TextUtils.isEmpty(strTc) && (strTc.contains("time out") || strTc.contains("Time-out"));
    }

    public static boolean hc(Throwable th) {
        com.ss.android.socialbase.downloader.u.b bVar;
        if (th == null) {
            return false;
        }
        String strTc = tc(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.u.b) || (((bVar = (com.ss.android.socialbase.downloader.u.b) th) == null || bVar.c() != 403) && (TextUtils.isEmpty(strTc) || !strTc.contains("403")))) {
            return !TextUtils.isEmpty(strTc) && strTc.contains("Forbidden");
        }
        return true;
    }

    public static boolean b(Throwable th) {
        if (th == null) {
            return false;
        }
        String strTc = tc(th);
        return !TextUtils.isEmpty(strTc) && strTc.contains("network not available");
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        String strTc = tc(th);
        return !TextUtils.isEmpty(strTc) && strTc.contains("Exception in connect");
    }

    public static boolean u(Throwable th) {
        if (th == null) {
            return false;
        }
        String strTc = tc(th);
        return !TextUtils.isEmpty(strTc) && strTc.contains("Precondition Failed");
    }

    public static boolean an(Throwable th) {
        if (th == null) {
            return false;
        }
        String strTc = tc(th);
        return !TextUtils.isEmpty(strTc) && strTc.contains("Requested Range Not Satisfiable");
    }

    public static boolean h(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.b.dc().d(th);
    }

    public static boolean d(com.ss.android.socialbase.downloader.u.d dVar) {
        return dVar != null && dVar.d() == 1051;
    }

    public static boolean hc(com.ss.android.socialbase.downloader.u.d dVar) {
        if (!(dVar instanceof com.ss.android.socialbase.downloader.u.b)) {
            return false;
        }
        com.ss.android.socialbase.downloader.u.b bVar = (com.ss.android.socialbase.downloader.u.b) dVar;
        return bVar.c() == 412 || bVar.c() == 416;
    }

    public static boolean b(com.ss.android.socialbase.downloader.u.d dVar) {
        if (dVar == null) {
            return false;
        }
        if (dVar.d() != 1011) {
            return dVar.getCause() != null && (dVar.getCause() instanceof SSLHandshakeException);
        }
        return true;
    }

    public static void d(Throwable th, String str) throws com.ss.android.socialbase.downloader.u.d {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof com.ss.android.socialbase.downloader.u.d) {
            com.ss.android.socialbase.downloader.u.d dVar = (com.ss.android.socialbase.downloader.u.d) th;
            dVar.d(str2 + "-" + dVar.hc());
            throw dVar;
        }
        if (th instanceof SSLHandshakeException) {
            throw new com.ss.android.socialbase.downloader.u.d(1011, hc(th, str2));
        }
        if (d(th)) {
            throw new com.ss.android.socialbase.downloader.u.d(1048, hc(th, str2));
        }
        if (u(th)) {
            throw new com.ss.android.socialbase.downloader.u.b(1004, SocketMessages.PayloadType.SC_RIDE_CHANGED, hc(th, str2));
        }
        if (an(th)) {
            throw new com.ss.android.socialbase.downloader.u.b(1004, 416, hc(th, str2));
        }
        if (hc(th)) {
            throw new com.ss.android.socialbase.downloader.u.d(1047, hc(th, str2));
        }
        if (b(th)) {
            throw new com.ss.android.socialbase.downloader.u.d(1049, hc(th, str2));
        }
        if (c(th)) {
            throw new com.ss.android.socialbase.downloader.u.d(1041, hc(th, str2));
        }
        if (th instanceof IOException) {
            b(th, str);
            d((IOException) th, str);
            return;
        }
        throw new com.ss.android.socialbase.downloader.u.d(1000, hc(th, str2));
    }

    private static void b(Throwable th, String str) throws com.ss.android.socialbase.downloader.u.gb {
        com.ss.android.socialbase.downloader.u.gb gbVarD = com.ss.android.socialbase.downloader.downloader.b.dc().d(th, null);
        if (gbVarD == null) {
            gbVarD = com.ss.android.socialbase.downloader.downloader.b.dc().d(th.getCause(), null);
        }
        if (gbVarD == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.u.gb(gbVarD.d(), hc(gbVarD, str)).b(gbVarD.c());
    }

    public static void d(IOException iOException, String str) throws com.ss.android.socialbase.downloader.u.d {
        if (str == null) {
            str = "";
        }
        String strHc = hc(iOException, str);
        if (iOException instanceof ConnectException) {
            throw new com.ss.android.socialbase.downloader.u.d(1041, strHc);
        }
        if (iOException instanceof UnknownHostException) {
            throw new com.ss.android.socialbase.downloader.u.d(1055, strHc);
        }
        if (iOException instanceof NoRouteToHostException) {
            throw new com.ss.android.socialbase.downloader.u.d(1056, strHc);
        }
        if (iOException instanceof UnknownServiceException) {
            throw new com.ss.android.socialbase.downloader.u.d(1057, strHc);
        }
        if (iOException instanceof PortUnreachableException) {
            throw new com.ss.android.socialbase.downloader.u.d(1058, strHc);
        }
        if (iOException instanceof SocketTimeoutException) {
            throw new com.ss.android.socialbase.downloader.u.d(1048, strHc);
        }
        if (iOException instanceof SocketException) {
            throw new com.ss.android.socialbase.downloader.u.d(1059, strHc);
        }
        if (iOException instanceof HttpRetryException) {
            throw new com.ss.android.socialbase.downloader.u.d(1060, strHc);
        }
        if (iOException instanceof ProtocolException) {
            throw new com.ss.android.socialbase.downloader.u.d(1061, strHc);
        }
        if (iOException instanceof MalformedURLException) {
            throw new com.ss.android.socialbase.downloader.u.d(1062, strHc);
        }
        if (iOException instanceof FileNotFoundException) {
            throw new com.ss.android.socialbase.downloader.u.d(1063, strHc);
        }
        if (iOException instanceof InterruptedIOException) {
            throw new com.ss.android.socialbase.downloader.u.d(1064, strHc);
        }
        if (iOException instanceof UnsupportedEncodingException) {
            throw new com.ss.android.socialbase.downloader.u.d(1065, strHc);
        }
        if (iOException instanceof EOFException) {
            throw new com.ss.android.socialbase.downloader.u.d(1066, strHc);
        }
        if (iOException instanceof StreamResetException) {
            throw new com.ss.android.socialbase.downloader.u.d(1067, strHc);
        }
        if (iOException instanceof SSLException) {
            throw new com.ss.android.socialbase.downloader.u.d(1011, strHc);
        }
        if (gb(iOException)) {
            throw new com.ss.android.socialbase.downloader.u.d(1006, strHc);
        }
        throw new com.ss.android.socialbase.downloader.u.d(1023, strHc);
    }

    public static boolean gb(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof com.ss.android.socialbase.downloader.u.d) {
            com.ss.android.socialbase.downloader.u.d dVar = (com.ss.android.socialbase.downloader.u.d) th;
            int iD = dVar.d();
            if (iD == 1006) {
                return true;
            }
            if (iD == 1023 || iD == 1039 || iD == 1040 || iD == 1054 || iD == 1064) {
                String message = dVar.getMessage();
                return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
        } else if (th instanceof IOException) {
            String strTc = tc(th);
            if (!TextUtils.isEmpty(strTc) && strTc.contains("ENOSPC")) {
                return true;
            }
        }
        return false;
    }

    public static boolean tt(Throwable th) {
        if (!(th instanceof com.ss.android.socialbase.downloader.u.d)) {
            return false;
        }
        int iD = ((com.ss.android.socialbase.downloader.u.d) th).d();
        return iD == 1055 || iD == 1023 || iD == 1041 || iD == 1022 || iD == 1048 || iD == 1056 || iD == 1057 || iD == 1058 || iD == 1059 || iD == 1060 || iD == 1061 || iD == 1067 || iD == 1049 || iD == 1047 || iD == 1051 || iD == 1004 || iD == 1011 || iD == 1002 || iD == 1013;
    }

    public static boolean d(com.ss.android.socialbase.downloader.u.d dVar, com.ss.android.socialbase.downloader.h.b bVar) {
        if (dVar == null) {
            return false;
        }
        int iD = dVar.d();
        if (iD == 1000 || iD == 1032 || iD == 1033 || iD == 1034 || iD == 1008 || iD == 1026 || iD == 1027 || iD == 1044 || iD == 1020) {
            return true;
        }
        return (iD == 1049 || iD == 1055 || iD == 1006 || bVar == null || bVar.js() >= 8388608) ? false : true;
    }

    public static String hc(Throwable th, String str) {
        if (str == null) {
            return tc(th);
        }
        return str + "-" + tc(th);
    }

    public static String tc(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            mq.d(th2);
            return "throwable getMsg error";
        }
    }

    public static com.ss.android.socialbase.downloader.hc.gb u(int i) {
        com.ss.android.socialbase.downloader.hc.gb gbVar = com.ss.android.socialbase.downloader.hc.gb.MAIN;
        if (i == com.ss.android.socialbase.downloader.hc.gb.SUB.ordinal()) {
            return com.ss.android.socialbase.downloader.hc.gb.SUB;
        }
        return i == com.ss.android.socialbase.downloader.hc.gb.NOTIFICATION.ordinal() ? com.ss.android.socialbase.downloader.hc.gb.NOTIFICATION : gbVar;
    }

    public static <K> HashMap<Integer, K> d(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> map = new HashMap<>();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            map.put(Integer.valueOf(iKeyAt), sparseArray.valueAt(i));
        }
        return map;
    }

    public static <K> void d(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static long u(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.h.hc> listB = com.ss.android.socialbase.downloader.downloader.b.np().b(bVar.h());
        if (bVar.fj() == 1) {
            return bVar.js();
        }
        if (listB == null || listB.size() <= 1) {
            return 0L;
        }
        long jC = c(listB);
        if (jC >= 0) {
            return jC;
        }
        return 0L;
    }

    private static long c(List<com.ss.android.socialbase.downloader.h.hc> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long jK = -1;
        for (com.ss.android.socialbase.downloader.h.hc hcVar : list) {
            if (hcVar != null && (hcVar.k() <= hcVar.cb() || hcVar.cb() == 0)) {
                if (jK == -1 || jK > hcVar.k()) {
                    jK = hcVar.k();
                }
            }
        }
        return jK;
    }

    public static long an(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.h.hc> listB = com.ss.android.socialbase.downloader.downloader.b.np().b(bVar.h());
        int iFj = bVar.fj();
        boolean z = iFj > 1;
        if (!bVar.ij()) {
            return 0L;
        }
        if (z) {
            if (listB == null || iFj != listB.size()) {
                return 0L;
            }
            return hc(listB);
        }
        return bVar.js();
    }

    public static boolean d(List<com.ss.android.socialbase.downloader.h.u> list, List<com.ss.android.socialbase.downloader.h.u> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void d(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        }
    }

    public static void d(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        }
    }

    public static String d(String str, int i) {
        return i == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static String d(String str, com.ss.android.socialbase.downloader.uo.d dVar) {
        JSONObject jSONObjectC;
        String str2;
        if (dVar == null || (jSONObjectC = dVar.c("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectC.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    public static String u() {
        return d(com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).b(), true);
    }

    public static String an() {
        return d(com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).c(), false);
    }

    private static String d(File file, boolean z) {
        Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
        if (d(file)) {
            return file.getAbsolutePath();
        }
        int i = contextTr.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            if (com.ss.android.socialbase.downloader.uo.d.b().hc("fix_save_external_dir") <= 0) {
                File fileD = com.bytedance.sdk.openadsdk.api.plugin.hc.d(contextTr, Environment.DIRECTORY_DOWNLOADS);
                if (d(fileD)) {
                    return fileD.getAbsolutePath();
                }
            }
        } else {
            if (z) {
                File fileH = h();
                if (d(fileH)) {
                    return fileH.getAbsolutePath();
                }
            }
            if (com.ss.android.socialbase.downloader.uo.d.b().hc("fix_save_external_dir") <= 0) {
                File fileD2 = com.bytedance.sdk.openadsdk.api.plugin.hc.d(contextTr, Environment.DIRECTORY_DOWNLOADS);
                if (d(fileD2)) {
                    return fileD2.getAbsolutePath();
                }
            }
        }
        return com.bytedance.sdk.openadsdk.api.plugin.hc.d(contextTr).getAbsolutePath();
    }

    public static boolean gb(String str) {
        Context contextTr;
        return com.ss.android.socialbase.downloader.uo.d.b().hc("save_path_security") <= 0 || (contextTr = com.ss.android.socialbase.downloader.downloader.b.tr()) == null || TextUtils.isEmpty(str) || str.startsWith("/data") || str.contains(new StringBuilder("Android/data/").append(contextTr.getPackageName()).toString());
    }

    public static boolean d(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static File h() {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception unused) {
            externalStorageState = "";
        }
        if (com.component.c.c.a.equals(externalStorageState)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static void d(List<com.ss.android.socialbase.downloader.h.u> list, com.ss.android.socialbase.downloader.h.b bVar) {
        long jIi = bVar.ii();
        if (jIi > 0) {
            list.add(new com.ss.android.socialbase.downloader.h.u("extra_throttle_net_speed", String.valueOf(jIi)));
        }
    }

    public static void hc(List<com.ss.android.socialbase.downloader.h.u> list, com.ss.android.socialbase.downloader.h.b bVar) {
        long jNx = bVar.nx();
        if (jNx > 300) {
            list.add(new com.ss.android.socialbase.downloader.h.u("extra_ttnet_protect_timeout", String.valueOf(jNx)));
        }
    }

    public static long b(long j) {
        return System.currentTimeMillis() - j;
    }

    public static String hc(com.ss.android.socialbase.downloader.tt.h hVar, String str) {
        if (hVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strD = hVar.d(str);
        if (!com.ss.android.socialbase.downloader.uo.d.b().hc("fix_get_http_resp_head_ignore_case", true)) {
            return strD;
        }
        if (TextUtils.isEmpty(strD)) {
            strD = hVar.d(str.toLowerCase());
        }
        return TextUtils.isEmpty(strD) ? hVar.d(str.toUpperCase()) : strD;
    }

    public static int d(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i;
        }
    }

    public static String d(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean d(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }

    public static boolean hc(com.ss.android.socialbase.downloader.u.d dVar, com.ss.android.socialbase.downloader.h.b bVar) {
        return bVar != null && bVar.np() && b(com.ss.android.socialbase.downloader.downloader.b.tr());
    }

    public static boolean gb() {
        Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
        return (contextTr == null || hc(contextTr) || !b(contextTr)) ? false : true;
    }

    public static long tt(String str) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (!matcher.find()) {
                return 0L;
            }
            try {
                j = Long.parseLong(matcher.group(1));
                return j;
            } catch (Throwable th) {
                mq.d(th);
                return 0L;
            }
        } catch (Throwable th2) {
            mq.d(th2);
            return j;
        }
    }

    public static String u(String str, String str2) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strU = u(str2);
        return (TextUtils.isEmpty(strU) || str.contains(strU)) ? str : new File(str, strU).getAbsolutePath();
    }

    public static boolean b(List<com.ss.android.socialbase.downloader.h.u> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.h.u uVar : list) {
            if (uVar != null && !TextUtils.isEmpty(uVar.d()) && !TextUtils.isEmpty(uVar.hc()) && "download-tc21-1-15".equals(uVar.d()) && "download-tc21-1-15".equals(uVar.hc())) {
                return true;
            }
        }
        return false;
    }
}
