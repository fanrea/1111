package com.sigmob.sdk.base.common;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.p;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class o {
    private static final String a = "o";
    private static final Map<String, String> b = new Hashtable();
    private static final Set<a> c = new CopyOnWriteArraySet();

    private static class a {
        String a;
        String b;
        long c;

        public a(String filePath, String downloadUrl, long downloadId) {
            this.a = filePath;
            this.b = downloadUrl;
            this.c = downloadId;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }
    }

    public static DownloadManager a() {
        Context contextE = com.sigmob.sdk.b.e();
        if (contextE == null) {
            return null;
        }
        return (DownloadManager) contextE.getSystemService("download");
    }

    public static String a(File file) {
        String name = file.getName();
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(name.lastIndexOf(".") + 1).toLowerCase());
    }

    private static String a(List<String> nameList, String name) {
        String strSubstring;
        int iIndexOf;
        StringBuilder sb;
        if (!nameList.contains(name)) {
            return name;
        }
        int iLastIndexOf = name.lastIndexOf(".");
        String strSubstring2 = "";
        if (iLastIndexOf != -1) {
            strSubstring2 = name.substring(0, iLastIndexOf);
            strSubstring = name.substring(iLastIndexOf);
        } else {
            strSubstring = "";
        }
        int iLastIndexOf2 = strSubstring2.lastIndexOf("(");
        if (iLastIndexOf2 == -1 || (iIndexOf = strSubstring2.indexOf(")", iLastIndexOf2)) == -1 || iIndexOf < strSubstring2.length() - 1) {
            sb = new StringBuilder();
        } else {
            try {
                return a(nameList, strSubstring2.substring(0, iLastIndexOf2) + "(" + (Integer.parseInt(strSubstring2.substring(iLastIndexOf2 + 1, iIndexOf)) + 1) + ")" + strSubstring);
            } catch (Throwable unused) {
                sb = new StringBuilder();
            }
        }
        return a(nameList, sb.append(strSubstring2).append("(1)").append(strSubstring).toString());
    }

    public static Map<String, Object> a(long downloadID) {
        Cursor cursorQuery;
        try {
            DownloadManager downloadManagerA = a();
            if (downloadManagerA == null) {
                return null;
            }
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(downloadID);
            Uri uriForDownloadedFile = downloadManagerA.getUriForDownloadedFile(downloadID);
            cursorQuery = downloadManagerA.query(query);
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return null;
                }
                int i = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("status"));
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("reason"));
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("local_uri"));
                HashMap map = new HashMap();
                map.put("fileName", string);
                map.put("status", Integer.valueOf(i));
                map.put(ContentProviderManager.PROVIDER_URI, uriForDownloadedFile);
                map.put("reason", Integer.valueOf(i2));
                cursorQuery.close();
                return map;
            } catch (Throwable th) {
                th = th;
                try {
                    SigmobLog.e(th.getMessage());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    private static void a(Context context, BaseAdUnit adUnit, final String url, final File file) {
        if (adUnit.isRecord()) {
            ac.a("download_start", "1", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.o$$ExternalSyntheticLambda5
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    o.b(url, file, obj);
                }
            });
        }
        HashMap map = new HashMap();
        map.put("result", "1");
        map.put("downloadId", adUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, adUnit.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, File file, BaseAdUnit baseAdUnit) {
        a(context, file.getAbsolutePath(), baseAdUnit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r10, final java.lang.String r11, com.sigmob.sdk.base.models.BaseAdUnit r12) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.o.a(android.content.Context, java.lang.String, com.sigmob.sdk.base.models.BaseAdUnit):void");
    }

    public static void a(final String url, final BaseAdUnit adUnit) {
        String str;
        final Context contextE = com.sigmob.sdk.b.e();
        try {
            ac.a(PointCategory.APK_CLICK, "download", adUnit);
            SigmobLog.i("download apk:" + url);
            g.a(adUnit);
            String apkMd5 = adUnit.getApkMd5();
            if (TextUtils.isEmpty(apkMd5)) {
                str = Md5Util.md5(url) + ".apk";
            } else {
                str = apkMd5 + ".apk";
                final File file = new File(com.sigmob.sdk.base.utils.i.a(contextE), str);
                boolean zExists = file.exists();
                boolean zB = adUnit.getApkDownloadType() != 0 ? com.sigmob.sdk.downloader.l.b(url, com.sigmob.sdk.base.utils.i.a(contextE).getAbsolutePath(), str) : true;
                if (zExists && zB && adUnit.canUseDownloadApk() && b(file)) {
                    adUnit.setApkName(str);
                    if (adUnit.getDownloadId() == null) {
                        ac.b(PointCategory.EXIT_APK_INSTALL, "", adUnit);
                    }
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.o$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            o.a(contextE, file, adUnit);
                        }
                    });
                    return;
                }
            }
            adUnit.setApkName(str);
            adUnit.setDownloadUrl(url);
            int apkDownloadType = adUnit.getApkDownloadType();
            if (apkDownloadType == 0) {
                a(str, url, adUnit);
                return;
            }
            if (apkDownloadType == 1) {
                m.a(url, adUnit, false);
            } else if (apkDownloadType == 2) {
                m.a(url, adUnit, true);
            } else {
                SigmobLog.e("not support Download Type: " + apkDownloadType);
                throw new Exception("not support Download Type: " + apkDownloadType);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            if (adUnit.isRecord()) {
                ac.a("download_start", "0", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.o$$ExternalSyntheticLambda7
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        o.c(url, obj);
                    }
                });
                ac.a("download_start", 0, th.getMessage(), adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.o$$ExternalSyntheticLambda8
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        o.b(url, obj);
                    }
                });
            }
            try {
                ai.a(contextE, "下载失败", 1).show();
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, File file, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setFinal_url(str);
            Map options = pointEntitySigmob.getOptions();
            options.put("apkfile", file.getAbsolutePath());
            options.put("apkurl", str);
            pointEntitySigmob.setOptions(options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            ((PointEntitySigmobError) obj).setFile_name(str);
        }
    }

    private static void a(String apkName, final String url, BaseAdUnit adUnit) {
        String str;
        Context contextE = com.sigmob.sdk.b.e();
        try {
            String str2 = TextUtils.isEmpty(apkName) ? Md5Util.md5(adUnit.getLanding_page()) + ".apk" : apkName;
            final File file = new File(com.sigmob.sdk.base.utils.i.a(contextE), str2);
            Long lC = c(-1L, file.getAbsolutePath());
            if (lC != null && lC.longValue() > 0) {
                try {
                    ai.a(contextE, "正在下载", 1).show();
                    if (adUnit.getDownloadId() == null) {
                        adUnit.setDownloadId(lC);
                        File file2 = new File(com.sigmob.sdk.base.utils.i.g(), lC + ".log");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        FileUtil.writeToCache(adUnit, file2.getAbsolutePath());
                        a(contextE, adUnit, url, file);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            HashMap<String, Object> mapB = b();
            if (mapB != null) {
                for (String str3 : mapB.keySet()) {
                    if (!TextUtils.isEmpty(str3) && str3.equals(file.getAbsolutePath())) {
                        try {
                            ai.a(contextE, "正在下载", 1).show();
                        } catch (Throwable unused2) {
                        }
                        try {
                            Object obj = mapB.get(str3);
                            if (obj instanceof Long) {
                                adUnit.setDownloadId((Long) obj);
                                File file3 = new File(com.sigmob.sdk.base.utils.i.g(), lC + ".log");
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                FileUtil.writeToCache(adUnit, file3.getAbsolutePath());
                                a(contextE, adUnit, url, file);
                                return;
                            }
                            return;
                        } catch (Throwable unused3) {
                            return;
                        }
                    }
                }
            }
            Map<String, String> map = b;
            boolean zContainsKey = map.containsKey(adUnit.getUuid());
            if (file.exists() && !zContainsKey && !a(contextE, file.getAbsolutePath())) {
                SigmobLog.i("cacheFile deleteFile:" + FileUtil.deleteFile(file.getAbsolutePath()));
            }
            SigmobLog.i(str2 + " exists:" + file.exists() + " containsKey:" + zContainsKey);
            if (file.exists()) {
                if (zContainsKey) {
                    a(contextE, file.getAbsolutePath(), adUnit);
                    return;
                }
                long jLastModified = file.lastModified();
                int iZ = com.sigmob.sdk.base.o.a().Z();
                if (iZ == 0) {
                    str = "default deleteFile:" + FileUtil.deleteFile(file.getAbsolutePath());
                } else {
                    if (System.currentTimeMillis() - jLastModified <= iZ * 1000) {
                        a(contextE, file.getAbsolutePath(), adUnit);
                        return;
                    }
                    str = "timeOut deleteFile:" + FileUtil.deleteFile(file.getAbsolutePath());
                }
                SigmobLog.i(str);
            }
            map.put(adUnit.getUuid(), str2);
            String appName = adUnit.getAppName();
            if (TextUtils.isEmpty(appName)) {
                appName = file.getName();
            }
            long jB = b(url, file.getAbsolutePath(), appName);
            if (jB >= 0) {
                try {
                    ai.a(contextE, "已开始下载，可在通知栏尝试取消", 1).show();
                } catch (Throwable th) {
                    SigmobLog.e(th.getMessage());
                }
                a(jB, file.getAbsolutePath());
                File file4 = new File(com.sigmob.sdk.base.utils.i.g(), jB + ".log");
                adUnit.setDownloadId(Long.valueOf(jB));
                FileUtil.writeToCache(adUnit, file4.getAbsolutePath());
                a(contextE, adUnit, url, file);
            } else {
                if (adUnit.isRecord()) {
                    ac.a("download_start", "0", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.o$$ExternalSyntheticLambda0
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj2) {
                            o.a(url, file, obj2);
                        }
                    });
                    ac.a(PointCategory.DOWNLOAD_FAILED, (int) jB, "下载失败,错误码 " + jB, adUnit);
                }
                ai.a(contextE, "下载失败,错误码 " + jB, 0).show();
                HashMap map2 = new HashMap();
                map2.put("result", "0");
                map2.put("downloadId", -1);
                BaseBroadcastReceiver.a(contextE, adUnit.getUuid(), map2, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
            }
            if (adUnit.isRecord()) {
                com.sigmob.sdk.base.network.g.a(adUnit, "download_start");
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            if (adUnit.isRecord()) {
                ac.a("download_start", "0", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.o$$ExternalSyntheticLambda1
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj2) {
                        o.e(url, obj2);
                    }
                });
                ac.a("download_start", 0, th2.getMessage(), adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.o$$ExternalSyntheticLambda2
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj2) {
                        o.d(url, obj2);
                    }
                });
            }
            HashMap map3 = new HashMap();
            map3.put("result", "0");
            map3.put("downloadId", -1);
            BaseBroadcastReceiver.a(contextE, adUnit.getUuid(), map3, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
            try {
                ai.a(contextE, "请先给予应用权限", 1).show();
            } catch (Throwable unused4) {
            }
        }
    }

    public static void a(final String url, final String icon_url, final String product_name, final int downloadType) throws Exception {
        p.a(url, new p.a() { // from class: com.sigmob.sdk.base.common.o.1
            @Override // com.sigmob.sdk.base.common.p.a
            public void a(String fileName, String url2) {
                String str;
                String str2 = TextUtils.isEmpty(product_name) ? fileName : product_name;
                int i = downloadType;
                boolean z = true;
                if (i == 1) {
                    str = icon_url;
                    z = false;
                } else {
                    if (i != 2) {
                        o.c(fileName, url2, str2);
                        return;
                    }
                    str = icon_url;
                }
                m.a(fileName, url2, str, str2, z);
            }

            @Override // com.sigmob.sdk.base.common.p.a
            public void a(String message, Throwable throwable) {
                String str = Md5Util.md5(url) + ".apk";
                String str2 = TextUtils.isEmpty(product_name) ? str : product_name;
                int i = downloadType;
                if (i == 1) {
                    m.a(str, url, icon_url, str2, false);
                } else if (i != 2) {
                    o.c(str, url, str2);
                } else {
                    m.a(str, url, icon_url, str2, true);
                }
            }
        });
    }

    public static boolean a(long downloadId, String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        c.add(new a(filePath, null, downloadId));
        return true;
    }

    public static boolean a(Context context, String filePath) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(filePath, 1) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String downloadUrl) {
        if (TextUtils.isEmpty(downloadUrl)) {
            return false;
        }
        Cursor cursor = null;
        try {
            DownloadManager downloadManagerA = a();
            if (downloadManagerA == null) {
                return false;
            }
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterByStatus(3);
            Cursor cursorQuery = downloadManagerA.query(query);
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
            do {
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(ContentProviderManager.PROVIDER_URI));
                if (!TextUtils.isEmpty(string) && downloadUrl.equalsIgnoreCase(string)) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return true;
                }
            } while (cursorQuery.moveToNext());
            cursorQuery.close();
            return false;
        } catch (Throwable th) {
            try {
                SigmobLog.e(th.getMessage());
                return false;
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }

    public static long[] a(Context context, Long downloadId) {
        long[] jArr = {-1, -1, 0};
        if (downloadId == null || downloadId.longValue() < 0) {
            return jArr;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = ((DownloadManager) context.getSystemService("download")).query(new DownloadManager.Query().setFilterById(downloadId.longValue()));
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                jArr[0] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("bytes_so_far"));
                jArr[1] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("total_size"));
                jArr[2] = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("status"));
            }
            return jArr;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private static long b(String downLoadUrl, String apkName, String title) {
        if (downLoadUrl != null) {
            try {
                if (!downLoadUrl.isEmpty()) {
                    String strTrim = downLoadUrl.trim();
                    if (TextUtils.isEmpty(Uri.parse(strTrim).getScheme())) {
                        strTrim = "http://" + strTrim;
                    }
                    if (!strTrim.startsWith(com.alipay.sdk.m.l.a.r)) {
                        return -2L;
                    }
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(strTrim));
                    File file = new File(apkName);
                    request.setTitle(title);
                    request.setAllowedNetworkTypes(3);
                    request.setAllowedOverRoaming(true);
                    request.setVisibleInDownloadsUi(true);
                    request.setNotificationVisibility(1);
                    File parentFile = file.getParentFile();
                    if (parentFile == null) {
                        return -1L;
                    }
                    if (parentFile.exists()) {
                        if (!parentFile.isDirectory()) {
                            parentFile.delete();
                            if (!parentFile.mkdirs()) {
                                return -3L;
                            }
                        }
                    } else if (!parentFile.mkdirs()) {
                        return -4L;
                    }
                    request.addRequestHeader("User-Agent", Networking.getUserAgent());
                    request.setDestinationUri(Uri.fromFile(file));
                    DownloadManager downloadManagerA = a();
                    if (downloadManagerA == null) {
                        return -1L;
                    }
                    return downloadManagerA.enqueue(request);
                }
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
        }
        return -1L;
    }

    public static HashMap<String, Object> b() {
        Cursor cursorQuery;
        try {
            DownloadManager downloadManagerA = a();
            if (downloadManagerA == null) {
                return null;
            }
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterByStatus(3);
            cursorQuery = downloadManagerA.query(query);
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return null;
                }
                HashMap<String, Object> map = new HashMap<>();
                do {
                    Long lValueOf = Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id")));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("local_uri"));
                    if (!TextUtils.isEmpty(string)) {
                        map.put(string, lValueOf);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return map;
            } catch (Throwable th) {
                th = th;
                try {
                    SigmobLog.e(th.getMessage());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    public static void b(long downloadId, String filePath) {
        for (a aVar : c) {
            if (aVar.c == downloadId || aVar.a.equalsIgnoreCase(filePath)) {
                c.remove(aVar);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, File file, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setFinal_url(str);
            Map options = pointEntitySigmob.getOptions();
            options.put("apkfile", file.getAbsolutePath());
            options.put("apkurl", str);
            pointEntitySigmob.setOptions(options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            ((PointEntitySigmobError) obj).setFinal_url(str);
        }
    }

    public static boolean b(File file) {
        return (file == null || !file.exists() || ClientMetadata.getPackageInfoWithUri(com.sigmob.sdk.b.e(), file.getAbsolutePath()) == null) ? false : true;
    }

    public static Long c(long downloadId, String filePath) {
        for (a aVar : c) {
            if (aVar.c == downloadId || aVar.a.equalsIgnoreCase(filePath)) {
                return Long.valueOf(aVar.c);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setFinal_url(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String apkName, final String url, String title) {
        Long lValueOf;
        if (TextUtils.isEmpty(apkName)) {
            apkName = Md5Util.md5(url) + ".apk";
        }
        File fileA = com.sigmob.sdk.base.utils.i.a(com.sigmob.sdk.base.utils.i.a(com.sigmob.sdk.b.e()), apkName);
        if (fileA != null) {
            Long lC = c(-1L, fileA.getAbsolutePath());
            if (lC != null && lC.longValue() > 0) {
                try {
                    ai.a(com.sigmob.sdk.b.e(), "正在下载", 1).show();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            lValueOf = Long.valueOf(b(url, fileA.getAbsolutePath(), title));
            if (lValueOf.longValue() > 0) {
                ai.a(com.sigmob.sdk.b.e(), "开始下载", 1).show();
                File file = new File(com.sigmob.sdk.base.utils.i.g(), lValueOf + ".log");
                if (!file.exists()) {
                    file.delete();
                }
                FileUtil.writeToCache(apkName, file.getAbsolutePath());
            }
        } else {
            lValueOf = null;
        }
        ac.a("download_start", (lValueOf == null || lValueOf.longValue() <= 0) ? "0" : "1", (BaseAdUnit) null, new ac.a() { // from class: com.sigmob.sdk.base.common.o$$ExternalSyntheticLambda4
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                o.f(url, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(String str, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            ((PointEntitySigmobError) obj).setFinal_url(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setFinal_url(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).getOptions().put("url", str);
        }
    }
}
