package com.kwad.sdk.resourceCache;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.p.m;
import com.kwad.sdk.resourceCache.model.WarmUpResponse;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private static volatile SharedPreferences Hg;
    private static int cku;
    private static int ckv;
    private static int ckw;
    public static WarmUpResponse.WarmupVideos warmupVideos = new WarmUpResponse.WarmupVideos();
    public static WarmUpResponse.WarmupImages warmupImages = new WarmUpResponse.WarmupImages();
    public static WarmUpResponse.WarmupZips warmupZips = new WarmUpResponse.WarmupZips();
    private static final Object mLock = new Object();
    private static ConcurrentHashMap<String, WarmUpResponse.ResourceItem> ckt = new ConcurrentHashMap<>();
    private static boolean ckx = false;

    public interface a {
    }

    public static void cL(Context context) {
        Hg = context.getSharedPreferences("ksadsdk_warmup_resource", 0);
        initData();
        new l<com.kwad.sdk.resourceCache.a, WarmUpResponse>() { // from class: com.kwad.sdk.resourceCache.b.1
            @Override // com.kwad.sdk.core.network.a
            public final /* synthetic */ f createRequest() {
                return ano();
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return ie(str);
            }

            private static WarmUpResponse ie(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WarmUpResponse warmUpResponse = new WarmUpResponse();
                warmUpResponse.parseJson(jSONObject);
                return warmUpResponse;
            }

            private static com.kwad.sdk.resourceCache.a ano() {
                return new com.kwad.sdk.resourceCache.a();
            }
        }.request(new o<com.kwad.sdk.resourceCache.a, WarmUpResponse>() { // from class: com.kwad.sdk.resourceCache.b.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                m461if(str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                a((WarmUpResponse) baseResultData);
            }

            /* renamed from: if, reason: not valid java name */
            private static void m461if(String str) {
                com.kwad.sdk.core.d.c.d("WarmUpManager", "onError: " + str);
            }

            private void a(final WarmUpResponse warmUpResponse) {
                try {
                    if (warmUpResponse.cleanResourceWarmup) {
                        b.Hg.edit().clear().apply();
                        b.ckt.clear();
                        b.X(new File(m.arl().getExternalCacheDir() + "/com.ksad.warmup/"));
                    }
                    int unused = b.cku = warmUpResponse.minWarmupDiskSize;
                    int unused2 = b.ckv = (int) (b.m(new File(m.arl().getExternalCacheDir() + "/com.ksad.warmup/")) / 1048576.0d);
                    int unused3 = b.ckw = b.cku - b.ckv;
                    com.kwad.sdk.core.d.c.d("WarmUpManager", "剩余空间: " + b.ckw + "MB本地空间: " + b.ckv + "MB可用空间: " + b.cku + "MB");
                    b(warmUpResponse);
                    h.execute(new bh() { // from class: com.kwad.sdk.resourceCache.b.2.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() throws IOException {
                            if (!warmUpResponse.disableZipWarmup) {
                                WarmUpResponse.WarmupZips warmupZips2 = warmUpResponse.warmupZips;
                                b.warmupZips = warmupZips2;
                                b.a(b.b(warmupZips2.zips), true, 3, null);
                            }
                            if (!warmUpResponse.disableImageWarmup) {
                                WarmUpResponse.WarmupImages warmupImages2 = warmUpResponse.warmupImages;
                                b.warmupImages = warmupImages2;
                                b.a(b.b(warmupImages2.images), true, 2, null);
                            }
                            if (!warmUpResponse.disableVideoWarmup) {
                                WarmUpResponse.WarmupVideos warmupVideos2 = warmUpResponse.warmupVideos;
                                b.warmupVideos = warmupVideos2;
                                b.a(b.b(warmupVideos2.videos), !b.warmupVideos.wifiOnly, 1, null);
                            }
                            com.kwad.sdk.core.d.c.d("WarmUpManager", "checklist: " + b.ckt.size() + b.warmupZips.zips.size() + b.warmupImages.images.size() + b.warmupVideos.videos.size());
                        }
                    });
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            private static void b(WarmUpResponse warmUpResponse) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(warmUpResponse.warmupZips.zips);
                arrayList.addAll(warmUpResponse.warmupImages.images);
                arrayList.addAll(warmUpResponse.warmupVideos.videos);
                b.ckt.values();
                c.a(arrayList, new ArrayList(b.ckt.values()), b.ckw);
                arrayList.clear();
            }
        });
    }

    private static void ic(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.delete()) {
                com.kwad.sdk.core.d.c.d("WarmUpManager", "Cache file deleted: " + str);
                return;
            } else {
                com.kwad.sdk.core.d.c.e("WarmUpManager", "Failed to delete cache file: " + str);
                return;
            }
        }
        com.kwad.sdk.core.d.c.d("WarmUpManager", "Cache file does not exist: " + str);
    }

    private static void initData() {
        File file;
        Map<String, ?> all = Hg.getAll();
        ArrayList arrayList = new ArrayList();
        if (all == null || all.isEmpty()) {
            return;
        }
        for (String str : all.keySet()) {
            WarmUpResponse.ResourceItem resourceItem = new WarmUpResponse.ResourceItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        resourceItem.parseJson(new JSONObject(str2));
                        if (!TextUtils.isEmpty(resourceItem.resourceKey) && !TextUtils.isEmpty(resourceItem.cachePath)) {
                            if (resourceItem.isZip) {
                                file = new File(resourceItem.zipDir);
                            } else {
                                file = new File(resourceItem.cachePath);
                            }
                            if (file.exists()) {
                                synchronized (mLock) {
                                    ckt.put(str, resourceItem);
                                }
                            } else {
                                arrayList.add(resourceItem.resourceKey);
                                com.kwad.sdk.core.d.c.d("WarmUpManager", "Remove null file list " + resourceItem.resourceKey);
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        SharedPreferences.Editor editorEdit = Hg.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }

    public static ArrayList<WarmUpResponse.ResourceItem> b(ArrayList<WarmUpResponse.ResourceItem> arrayList) {
        WarmUpResponse.ResourceItem resourceItem;
        ArrayList<WarmUpResponse.ResourceItem> arrayList2 = new ArrayList<>(arrayList);
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (mLock) {
            Iterator<WarmUpResponse.ResourceItem> it = arrayList2.iterator();
            while (it.hasNext()) {
                WarmUpResponse.ResourceItem next = it.next();
                if (next != null && ckt.containsKey(next.resourceKey) && (resourceItem = ckt.get(next.resourceKey)) != null && resourceItem.isCached) {
                    if (resourceItem.endTime < jCurrentTimeMillis || resourceItem.endTime == 0) {
                        if (resourceItem.cachePath != null) {
                            if (resourceItem.isZip) {
                                W(new File(resourceItem.zipDir));
                            } else {
                                ic(resourceItem.cachePath);
                            }
                            ckt.remove(next.resourceKey);
                        }
                        it.remove();
                    } else {
                        it.remove();
                    }
                }
            }
        }
        Collections.sort(arrayList2, new Comparator<WarmUpResponse.ResourceItem>() { // from class: com.kwad.sdk.resourceCache.b.3
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(WarmUpResponse.ResourceItem resourceItem2, WarmUpResponse.ResourceItem resourceItem3) {
                return a(resourceItem2, resourceItem3);
            }

            private static int a(WarmUpResponse.ResourceItem resourceItem2, WarmUpResponse.ResourceItem resourceItem3) {
                return Integer.compare(resourceItem3.priority, resourceItem2.priority);
            }
        });
        return arrayList2;
    }

    private static void W(File file) {
        if (file == null || !file.exists()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的文件夹不存在: " + file);
            return;
        }
        if (!file.isDirectory()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的路径不是一个文件夹: " + file);
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    W(file2);
                } else if (file2.delete()) {
                    com.kwad.sdk.core.d.c.d("WarmUpManager", "文件已删除: " + file2.getAbsolutePath());
                } else {
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件失败: " + file2.getAbsolutePath());
                }
            }
        }
        if (file.delete()) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "文件夹已删除: " + file.getAbsolutePath());
        } else {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件夹失败: " + file.getAbsolutePath());
        }
    }

    public static void X(File file) {
        if (file == null || !file.exists()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的文件夹不存在: " + file);
            return;
        }
        if (!file.isDirectory()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的路径不是一个文件夹: " + file);
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    X(file2);
                } else if (file2.delete()) {
                    com.kwad.sdk.core.d.c.d("WarmUpManager", "文件已删除: " + file2.getAbsolutePath());
                } else {
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件失败: " + file2.getAbsolutePath());
                }
            }
        }
        if (file.delete()) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "文件夹已删除: " + file.getAbsolutePath());
        } else {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件夹失败: " + file.getAbsolutePath());
        }
    }

    public static int a(List<WarmUpResponse.ResourceItem> list, boolean z, int i, a aVar) throws IOException {
        if (list == null || ckx) {
            return -1;
        }
        Iterator<WarmUpResponse.ResourceItem> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WarmUpResponse.ResourceItem next = it.next();
            if (next != null) {
                String str = next.url;
                boolean z2 = true;
                if (ckw < next.downloadSize) {
                    X(new File(m.arl().getExternalCacheDir() + "/com.ksad.warmup/"));
                    ckx = true;
                    break;
                }
                if (!TextUtils.isEmpty(next.md5) && !TextUtils.isEmpty(str)) {
                    if (i == 1 && (!ao.isWifiConnected(ServiceProvider.getContext()) || !z)) {
                        z2 = false;
                    }
                    if (z2) {
                        File fileA = a(i, next);
                        try {
                            com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件开始 " + fileA);
                            c.a(next, i);
                            com.kwad.sdk.core.download.a.a(str, fileA, null, false);
                            com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件已下载 " + fileA);
                        } catch (IOException e) {
                            com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件失败 ");
                            c.a(next, i, 0, e.getMessage());
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                        }
                        if (!TextUtils.equals(al.getFileMD5Digest(fileA), next.md5)) {
                            com.kwad.sdk.core.d.c.d("WarmUpManager", "save: md5校验失败 " + fileA);
                            c.b(next, i);
                            ic(fileA.getAbsolutePath());
                        } else {
                            c.c(next, i);
                            b(next);
                            i2++;
                        }
                    }
                }
            }
        }
        if (i == 3) {
            try {
                Iterator<WarmUpResponse.ResourceItem> it2 = warmupZips.zips.iterator();
                while (it2.hasNext()) {
                    WarmUpResponse.ResourceItem next2 = it2.next();
                    id(next2.resourceKey);
                    ic(next2.cachePath);
                }
            } catch (IOException e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
        }
        return i2;
    }

    private static File a(int i, WarmUpResponse.ResourceItem resourceItem) throws IOException {
        File file = new File(m.arl().getExternalCacheDir(), "/com.ksad.warmup/");
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = i != 1 ? i != 2 ? i != 3 ? "" : "zip/" : "image/" : "video/";
        String strA = a(resourceItem);
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, resourceItem.resourceKey + strA);
        if (!file3.exists()) {
            try {
                if (!((File) Objects.requireNonNull(file3.getParentFile())).exists()) {
                    file3.getParentFile().mkdirs();
                }
                file3.createNewFile();
            } catch (IOException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (i == 3) {
            resourceItem.isZip = true;
            resourceItem.zipDir = file2.getAbsolutePath() + "/" + resourceItem.resourceKey;
        }
        resourceItem.cachePath = file3.getAbsolutePath();
        return file3;
    }

    private static String a(WarmUpResponse.ResourceItem resourceItem) {
        if (resourceItem == null || TextUtils.isEmpty(resourceItem.url)) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "warmupItem or url is null");
            return null;
        }
        String str = resourceItem.url;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1 && iLastIndexOf < str.length() - 1) {
            return str.substring(iLastIndexOf);
        }
        com.kwad.sdk.core.d.c.d("WarmUpManager", "No file extension found in URL: " + str);
        return null;
    }

    private static void b(WarmUpResponse.ResourceItem resourceItem) {
        new WarmUpResponse.ResourceItem();
        resourceItem.isCached = true;
        synchronized (mLock) {
            ckt.put(resourceItem.resourceKey, resourceItem);
        }
        if (Hg != null) {
            SharedPreferences.Editor editorEdit = Hg.edit();
            editorEdit.putString(resourceItem.resourceKey, resourceItem.toJson().toString());
            editorEdit.apply();
        }
    }

    private static void id(String str) throws IOException {
        if (!str.matches("[a-zA-Z0-9_-]+")) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "Invalid zipname: " + str);
            return;
        }
        String str2 = m.arl().getExternalCacheDir() + "/com.ksad.warmup/zip/" + str + ".zip";
        String str3 = m.arl().getExternalCacheDir() + "/com.ksad.warmup/zip/" + str;
        if (!new File(str2).exists()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "File does not exist: " + str2);
            return;
        }
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str2));
                try {
                    for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                        if (nextEntry.getName().startsWith("__MACOSX/") || nextEntry.getName().startsWith("._")) {
                            break;
                        }
                        String str4 = str3 + File.separator + nextEntry.getName();
                        if (!nextEntry.isDirectory()) {
                            c(zipInputStream, str4);
                        } else {
                            new File(str4).mkdir();
                        }
                        zipInputStream.closeEntry();
                        com.kwad.sdk.core.d.c.d("WarmUpManager", "unzip: 文件已解压 " + str4);
                    }
                    zipInputStream.close();
                } finally {
                }
            } catch (FileNotFoundException e) {
                com.kwad.sdk.core.d.c.e("WarmUpManager", "unzip: FileNotFoundException: " + e.getMessage());
            } catch (IOException e2) {
                com.kwad.sdk.core.d.c.e("WarmUpManager", "unzip: IOException: " + e2.getMessage());
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
        }
    }

    private static void c(ZipInputStream zipInputStream, String str) throws Throwable {
        StringBuilder sb;
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = zipInputStream.read(bArr);
                        if (i == -1) {
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (IOException e) {
                                e = e;
                                com.kwad.sdk.core.d.c.printStackTrace(e);
                                sb = new StringBuilder("extractFile: FileOutputStream close error: ");
                                com.kwad.sdk.core.d.c.e("WarmUpManager", sb.append(e.getMessage()).toString());
                            }
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                } catch (EOFException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "extractFile: EOFException: " + e.getMessage());
                    if (file.exists()) {
                        file.delete();
                    }
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e = e3;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            sb = new StringBuilder("extractFile: FileOutputStream close error: ");
                            com.kwad.sdk.core.d.c.e("WarmUpManager", sb.append(e.getMessage()).toString());
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "extractFile: IOException: " + e.getMessage());
                    if (file.exists()) {
                        file.delete();
                    }
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e = e5;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            sb = new StringBuilder("extractFile: FileOutputStream close error: ");
                            com.kwad.sdk.core.d.c.e("WarmUpManager", sb.append(e.getMessage()).toString());
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            com.kwad.sdk.core.d.c.printStackTrace(e6);
                            com.kwad.sdk.core.d.c.e("WarmUpManager", "extractFile: FileOutputStream close error: " + e6.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (EOFException e7) {
                e = e7;
            } catch (IOException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long m(File file) {
        long jM;
        long j = 0;
        if (file == null) {
            return 0L;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return 0L;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    jM = file2.length();
                } else if (file2.isDirectory()) {
                    jM = m(file2);
                }
                j += jM;
            }
            return j;
        }
        if (file.isFile()) {
            return file.length();
        }
        return 0L;
    }
}
