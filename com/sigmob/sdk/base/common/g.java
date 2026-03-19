package com.sigmob.sdk.base.common;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.models.AdCache;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.czhj.volley.toolbox.FileDownloader;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.ResponseAsset;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.videocache.h;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g {
    public static final String a = "g";
    private static com.sigmob.sdk.videocache.h i;
    private static volatile ImageManager k;
    private static BaseAdUnit l;
    private static BaseAdUnit m;
    private static z o;
    private String v;
    private String w;
    private static final Integer c = 0;
    private static final Integer d = 1;
    private static final Integer e = 2;
    private static final Integer f = 3;
    private static g g = null;
    private static final Map<String, BaseAdUnit> h = new HashMap();
    private static final HashMap<String, Integer> j = new HashMap<>();
    private static final HashMap<String, List<BaseAdUnit>> n = new HashMap<>();
    private static final HashMap<String, BidResponse> q = new HashMap<>();
    private static final HashMap<String, Integer> s = new HashMap<>();
    private static final Map<String, List<BaseAdUnit>> A = new HashMap();
    private final Map<String, String> p = new HashMap();
    private final HashSet<a> r = new HashSet<>();
    final FileDownloadRequest.FileDownloadListener b = new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.g.1
        public void downloadProgress(DownloadItem item, long totalSize, long readSize) {
        }

        public void onCancel(DownloadItem item) {
            g.j.put(Md5Util.md5(item.url), g.f);
            Iterator it = g.this.r.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BaseAdUnit baseAdUnitA = aVar.a();
                if (baseAdUnitA != null && item.type == DownloadItem.FileType.FILE && baseAdUnitA.getEndCardZipPath().equals(item.filePath)) {
                    aVar.b(baseAdUnitA);
                }
            }
        }

        public void onErrorResponse(DownloadItem item) {
            SigmobLog.e("onErrorResponse: ", item.error);
            g.j.put(Md5Util.md5(item.url), g.f);
            Iterator it = g.this.r.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BaseAdUnit baseAdUnitA = aVar.a();
                if (baseAdUnitA != null && baseAdUnitA.getEndCardZipPath().equals(item.filePath) && item.type == DownloadItem.FileType.FILE) {
                    aVar.b(baseAdUnitA);
                }
            }
            g.this.new c(item).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        }

        public void onSuccess(DownloadItem item) {
            g.j.put(Md5Util.md5(item.url), g.f);
            Iterator it = g.this.r.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BaseAdUnit baseAdUnitA = aVar.a();
                if (baseAdUnitA != null && item.type == DownloadItem.FileType.FILE && baseAdUnitA.getEndCardZipPath().equals(item.filePath)) {
                    aVar.a(baseAdUnitA);
                }
            }
            g.this.new c(item).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        }
    };
    private final ArrayList<BaseAdUnit> t = new ArrayList<>();
    private final HashMap<String, AdCache> u = new HashMap<>();
    private final HashMap<String, b> x = new HashMap<>();
    private final HashMap<String, AdCache> y = new HashMap<>();
    private final Map<String, AdCache> z = new HashMap();

    public interface a {
        BaseAdUnit a();

        void a(BaseAdUnit adUnit);

        void b(BaseAdUnit adUnit);
    }

    public interface b {
        void a(BaseAdUnit adUnit);

        void a(BaseAdUnit adUnit, String message);
    }

    class c extends AsyncTask<Object, Void, String> {
        private DownloadItem b;

        c(DownloadItem downloadItem) {
            this.b = downloadItem;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Object... objects) {
            DownloadItem downloadItem = this.b;
            if (downloadItem == null) {
                SigmobLog.e("Download Item is null");
                return WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD.toString();
            }
            if (downloadItem.error != null) {
                return this.b.error.toString();
            }
            String str = this.b.filePath;
            String extensionName = FileUtil.getExtensionName(str);
            String strFileMd5 = Md5Util.fileMd5(str);
            if (!TextUtils.isEmpty(this.b.md5) && !this.b.md5.equalsIgnoreCase(strFileMd5)) {
                this.b.status = 0;
                return WindAdError.ERROR_SIGMOB_FILE_MD5.toString();
            }
            if (this.b.type == DownloadItem.FileType.VIDEO) {
                g.this.p.put(str, strFileMd5);
                this.b.status = 1;
            } else {
                if (TextUtils.isEmpty(extensionName) || !extensionName.equalsIgnoreCase("tgz")) {
                    if (this.b.type == DownloadItem.FileType.MRAID_VIDEO) {
                        return null;
                    }
                    this.b.status = 0;
                    return WindAdError.ERROR_SIGMOB_INFORMATION_LOSE.toString();
                }
                try {
                    com.sigmob.sdk.base.utils.f.a(new File(str), new File(str.replace(".tgz", "/")));
                    this.b.status = 1;
                } catch (Throwable th) {
                    this.b.status = 0;
                    SigmobLog.e(th.getMessage());
                    return WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD.toString();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(final String error) {
            super.onPostExecute(error);
            if (!TextUtils.isEmpty(error)) {
                FileUtil.deleteFile(this.b.filePath);
            }
            Iterator it = new CopyOnWriteArrayList(g.this.t).iterator();
            while (it.hasNext()) {
                BaseAdUnit baseAdUnit = (BaseAdUnit) it.next();
                b bVar = (b) g.this.x.get(baseAdUnit.getUuid());
                if (this.b.type != DownloadItem.FileType.VIDEO || !baseAdUnit.getVideoPath().equals(this.b.filePath)) {
                    if ((this.b.type == DownloadItem.FileType.FILE && baseAdUnit.getEndCardZipPath().equals(this.b.filePath)) || this.b.type == DownloadItem.FileType.ZIP_FILE) {
                        g.this.a(baseAdUnit, error, bVar);
                    } else if (this.b.type == DownloadItem.FileType.MRAID_VIDEO) {
                    }
                }
                ac.a(this.b, baseAdUnit, error, false);
                g.this.a(baseAdUnit, error, bVar);
            }
        }
    }

    private class d extends AsyncTask<Object, Void, ArrayList<DownloadItem>> {
        BaseAdUnit a;

        d(BaseAdUnit adUnit) {
            this.a = adUnit;
        }

        private DownloadItem a(Template template) {
            if (!TextUtils.isEmpty(template.context.utf8())) {
                File file = new File(com.sigmob.sdk.base.utils.i.f(com.sigmob.sdk.base.utils.i.c), Md5Util.md5(template.context.utf8()) + ".tgz");
                if (!file.exists()) {
                    DownloadItem downloadItem = new DownloadItem();
                    downloadItem.url = template.context.utf8();
                    downloadItem.filePath = file.getAbsolutePath();
                    downloadItem.type = DownloadItem.FileType.ZIP_FILE;
                    return downloadItem;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<DownloadItem> doInBackground(Object... objects) {
            DownloadItem downloadItemA;
            DownloadItem downloadItemA2;
            DownloadItem downloadItemA3;
            String strFileMd5;
            ArrayList<DownloadItem> arrayList = new ArrayList<>();
            BaseAdUnit baseAdUnit = this.a;
            if (baseAdUnit != null && baseAdUnit.getMaterial() != null) {
                try {
                    MaterialMeta material = this.a.getMaterial();
                    long length = 0;
                    if (!TextUtils.isEmpty(this.a.getVideo_url())) {
                        if (this.a.isVideoExist()) {
                            strFileMd5 = Md5Util.fileMd5(this.a.getVideoPath());
                            if (TextUtils.isEmpty(this.a.getVideo_OriginMD5()) || this.a.getVideo_OriginMD5().equalsIgnoreCase(strFileMd5)) {
                                g.this.p.put(this.a.getVideoPath(), strFileMd5);
                                length = new File(this.a.getVideoPath()).length();
                            } else {
                                FileUtil.deleteFile(this.a.getVideoPath());
                            }
                        } else {
                            strFileMd5 = null;
                        }
                        boolean zCheckVideoValid = this.a.checkVideoValid();
                        DownloadItem downloadItem = new DownloadItem();
                        if (zCheckVideoValid && this.a.isVideoExist()) {
                            downloadItem.url = this.a.getVideo_url();
                            downloadItem.filePath = this.a.getVideoPath();
                            downloadItem.type = DownloadItem.FileType.VIDEO;
                            downloadItem.md5 = strFileMd5;
                            downloadItem.size = length;
                            downloadItem.status = 1;
                            ac.a(downloadItem, this.a, (String) null, true);
                        } else if (this.a.getPlayMode() != 2) {
                            downloadItem.url = this.a.getVideo_url();
                            downloadItem.filePath = this.a.getVideoPath();
                            downloadItem.type = DownloadItem.FileType.VIDEO;
                            downloadItem.md5 = this.a.getVideo_OriginMD5();
                            g.this.a(downloadItem, this.a);
                            arrayList.add(downloadItem);
                        }
                    }
                    if (material.creative_type.intValue() == l.CreativeTypeVideo_Tar.a()) {
                        DownloadItem downloadItem2 = new DownloadItem();
                        downloadItem2.url = this.a.getEndcard_url();
                        downloadItem2.filePath = this.a.getEndCardZipPath();
                        downloadItem2.type = DownloadItem.FileType.FILE;
                        downloadItem2.md5 = this.a.getEndCard_OriginMD5();
                        arrayList.add(downloadItem2);
                    }
                    if (this.a.scene != null && this.a.scene.type.intValue() == 3 && (downloadItemA3 = a(this.a.scene)) != null) {
                        arrayList.add(downloadItemA3);
                    }
                    if (material.main_template != null && material.main_template.type.intValue() == 3 && (downloadItemA2 = a(material.main_template)) != null) {
                        arrayList.add(downloadItemA2);
                    }
                    if (material.sub_template != null && material.sub_template.type.intValue() == 3 && (downloadItemA = a(material.sub_template)) != null) {
                        arrayList.add(downloadItemA);
                    }
                    if (this.a.isCatchVideo() && com.sigmob.sdk.base.utils.e.b(material.asset)) {
                        for (int i = 0; i < material.asset.size(); i++) {
                            ResponseAsset responseAsset = material.asset.get(i);
                            if (responseAsset != null && responseAsset.video != null) {
                                String str = responseAsset.video.url;
                                if (!TextUtils.isEmpty(str)) {
                                    File fileC = g.d().c(str);
                                    if (!fileC.exists()) {
                                        DownloadItem downloadItem3 = new DownloadItem();
                                        downloadItem3.url = str;
                                        downloadItem3.filePath = fileC.getAbsolutePath();
                                        downloadItem3.type = DownloadItem.FileType.MRAID_VIDEO;
                                        g.this.a(downloadItem3, this.a);
                                        arrayList.add(downloadItem3);
                                    }
                                }
                            }
                        }
                    }
                    SigmobLog.d("cache() adUnit = [" + this.a.getCrid() + "] videoUrl = [" + this.a.getVideo_url() + "] endcardUrl = [" + this.a.getEndcard_url() + "]");
                    return arrayList;
                } catch (Throwable th) {
                    SigmobLog.e("AdUnitCheckCacheTask error: " + th.getMessage());
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ArrayList<DownloadItem> downloadItems) {
            boolean z;
            Integer num;
            File[] fileArrListFiles;
            super.onPostExecute(downloadItems);
            BaseAdUnit baseAdUnit = this.a;
            if (baseAdUnit == null) {
                return;
            }
            MaterialMeta material = baseAdUnit.getMaterial();
            b bVar = (b) g.this.x.get(this.a.getUuid());
            if (downloadItems == null) {
                downloadItems = new ArrayList<>();
            }
            if (downloadItems.isEmpty()) {
                if (bVar != null) {
                    bVar.a(this.a, null);
                }
                g.this.g(this.a);
            } else {
                FileDownloader fileDownloaderA = q.a();
                Iterator it = g.this.t.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((BaseAdUnit) it.next()).getUuid().equals(this.a.getUuid())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z && bVar != null) {
                    g.this.t.add(this.a);
                }
                Iterator<DownloadItem> it2 = downloadItems.iterator();
                while (it2.hasNext()) {
                    DownloadItem next = it2.next();
                    String strMd5 = Md5Util.md5(next.url);
                    SigmobLog.d("downloader add  item " + next.url);
                    if (next.type != DownloadItem.FileType.VIDEO && ((num = (Integer) g.j.get(strMd5)) == null || num.equals(g.f))) {
                        g.j.put(strMd5, g.d);
                        fileDownloaderA.add(next, g.this.b);
                    }
                }
            }
            if (material == null || material.ad_privacy == null) {
                return;
            }
            String str = material.ad_privacy.privacy_template_url;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strMd52 = Md5Util.md5(str);
            File fileD = com.sigmob.sdk.base.utils.i.d(com.sigmob.sdk.base.utils.i.b);
            File fileA = com.sigmob.sdk.base.utils.i.a(fileD, strMd52 + ".html");
            if (fileA == null || fileA.exists()) {
                SigmobLog.i("privacy_template_url:" + strMd52 + " is exists");
                return;
            }
            try {
                if (fileD.exists() && fileD.isDirectory() && (fileArrListFiles = fileD.listFiles()) != null) {
                    for (File file : fileArrListFiles) {
                        if (file.exists() && file.isFile() && file.delete()) {
                            SigmobLog.d("删除单个文件" + file.getAbsolutePath() + "成功");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            DownloadItem downloadItem = new DownloadItem();
            downloadItem.url = str;
            downloadItem.filePath = fileA.getAbsolutePath();
            downloadItem.type = DownloadItem.FileType.OTHER;
            downloadItems.add(downloadItem);
            q.a().add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.g.d.1
                public void downloadProgress(DownloadItem item, long totalSize, long readSize) {
                }

                public void onCancel(DownloadItem item) {
                    SigmobLog.i("onPostExecute onCancel:" + item.url);
                }

                public void onErrorResponse(DownloadItem item) {
                    SigmobLog.i("onPostExecute onErrorResponse:" + item.url);
                }

                public void onSuccess(DownloadItem item) {
                    SigmobLog.i("onPostExecute onSuccess:" + item.url);
                }
            });
        }
    }

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(BaseAdUnit baseAdUnit, BaseAdUnit baseAdUnit2) {
        return -com.sigmob.sdk.base.utils.d.a(baseAdUnit.getBidEcpm() > 0 ? baseAdUnit.getBidEcpm() : baseAdUnit.getBP(), baseAdUnit2.getBidEcpm() > 0 ? baseAdUnit2.getBidEcpm() : baseAdUnit2.getBP());
    }

    public static synchronized ImageManager a() {
        if (k == null) {
            File file = new File(com.sigmob.sdk.base.utils.i.f());
            synchronized (ImageManager.class) {
                if (k == null) {
                    k = new ImageManager(com.sigmob.sdk.b.e()).customCachePath(file);
                }
            }
        }
        return k;
    }

    public static BidResponse a(String request_id) {
        return q.get(request_id);
    }

    public static List<BaseAdUnit> a(String placementId, int bid_floor, int ad_count) {
        ArrayList arrayList = new ArrayList();
        List<BaseAdUnit> listD = d(placementId);
        if (listD != null) {
            Iterator it = new CopyOnWriteArrayList(listD).iterator();
            while (it.hasNext()) {
                BaseAdUnit baseAdUnit = (BaseAdUnit) it.next();
                int bidEcpm = baseAdUnit.getBidEcpm();
                if (bidEcpm == 0) {
                    bidEcpm = baseAdUnit.getBP();
                }
                if (bidEcpm >= bid_floor || bid_floor == 0) {
                    arrayList.add(baseAdUnit);
                    listD.remove(baseAdUnit);
                }
                if (baseAdUnit.bidding_response != null || arrayList.size() >= ad_count) {
                    break;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DownloadItem item, BaseAdUnit adUnit) {
        if (i == null) {
            return;
        }
        String str = item.url;
        if (TextUtils.isEmpty(str) || i.b(str)) {
            return;
        }
        String strA = i.a(str);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        i.a(new com.sigmob.sdk.videocache.d() { // from class: com.sigmob.sdk.base.common.g.2
            @Override // com.sigmob.sdk.videocache.d
            public void a(File cacheFile, String url, int percentsAvailable) {
                SigmobLog.d(cacheFile + " onCacheAvailable " + percentsAvailable);
                if (percentsAvailable != 100 || cacheFile == null || cacheFile.getAbsolutePath().endsWith("download")) {
                    return;
                }
                g.i.a(this);
                item.networkMs = System.currentTimeMillis() - jCurrentTimeMillis;
                g.this.new c(item).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
            }

            @Override // com.sigmob.sdk.videocache.d
            public void a(String url, Throwable throwable) {
                g.i.a(this);
                item.error = new VolleyError(WindAdError.ERROR_SIGMOB_VIDEO_FILE.getMessage());
                item.networkMs = System.currentTimeMillis() - jCurrentTimeMillis;
                g.this.new c(item).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
                SigmobLog.e(url + " onCacheUnavailable ", throwable);
            }
        }, str);
        com.sigmob.sdk.videocache.x.a(com.sigmob.sdk.b.e()).a(strA);
    }

    public static void a(BaseAdUnit adUnit) {
        if (adUnit == null) {
            return;
        }
        String uuid = adUnit.getUuid();
        if (TextUtils.isEmpty(uuid)) {
            return;
        }
        h.put(uuid, adUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseAdUnit adUnit, String error, b adStackStatusListener) {
        if (error == null) {
            if (!adUnit.isVideoExist() || !adUnit.isEndCardIndexExist()) {
                return;
            }
            if (adStackStatusListener != null) {
                error = null;
                adStackStatusListener.a(adUnit, error);
            }
        } else if (adStackStatusListener != null) {
            adStackStatusListener.a(adUnit, error);
        }
        g(adUnit);
    }

    public static void a(String requestId, BidResponse bidResponse) {
        if (TextUtils.isEmpty(requestId) || bidResponse == null) {
            return;
        }
        q.put(requestId, bidResponse);
    }

    public static void a(String placementId, List<BaseAdUnit> list, int maxLimit) {
        if (TextUtils.isEmpty(placementId) || list == null || list.isEmpty()) {
            return;
        }
        List<BaseAdUnit> listD = d(placementId);
        if (listD != null && !listD.isEmpty() && maxLimit != 0) {
            listD.addAll(list);
            list = listD;
        }
        Collections.sort(list, new Comparator() { // from class: com.sigmob.sdk.base.common.g$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return g.a((BaseAdUnit) obj, (BaseAdUnit) obj2);
            }
        });
        if (maxLimit <= 0) {
            n.remove(placementId);
            return;
        }
        if (list.size() > maxLimit) {
            list = new LinkedList(list.subList(0, maxLimit));
        }
        n.put(placementId, list);
    }

    public static void a(List<BaseAdUnit> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        A.put(list.get(0).getUuid(), list);
    }

    public static File[] a(File[] files, long currentTime, long time) {
        if (files == null || files.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(files));
        for (File file : files) {
            long j2 = currentTime - time;
            if (file.exists() && j2 > file.lastModified()) {
                file.delete();
                arrayList.remove(file);
                SigmobLog.d("file delete " + file.getName());
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }

    public static void b() {
        try {
            File fileD = com.sigmob.sdk.base.utils.i.d(com.sigmob.sdk.base.utils.i.a);
            if (fileD == null) {
                return;
            }
            FileUtil.deleteDirectory(fileD.getAbsolutePath());
            t();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public static void b(BaseAdUnit adUnit) {
        if (adUnit == null) {
            return;
        }
        String uuid = adUnit.getUuid();
        if (TextUtils.isEmpty(uuid)) {
            return;
        }
        h.remove(uuid);
        A.remove(uuid);
    }

    private void b(final BaseAdUnit adUnit, final b adStackStatusListener) {
        if (adUnit == null) {
            return;
        }
        File adPrivacyTemplateFile = adUnit.getAdPrivacyTemplateFile();
        if (adPrivacyTemplateFile != null && !adPrivacyTemplateFile.exists()) {
            DownloadItem downloadItem = new DownloadItem();
            downloadItem.url = adUnit.getadPrivacy().privacy_template_url;
            downloadItem.filePath = adPrivacyTemplateFile.getAbsolutePath();
            downloadItem.type = DownloadItem.FileType.OTHER;
            FileDownloader fileDownloaderA = q.a();
            if (fileDownloaderA != null) {
                fileDownloaderA.add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.g.3
                    public void downloadProgress(DownloadItem item, long totalSize, long readSize) {
                    }

                    public void onCancel(DownloadItem item) {
                    }

                    public void onErrorResponse(DownloadItem item) {
                    }

                    public void onSuccess(DownloadItem item) {
                    }
                });
            }
        }
        File file = new File(adUnit.getSplashFilePath());
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
            if (adStackStatusListener != null) {
                adStackStatusListener.a(adUnit, null);
                return;
            }
            return;
        }
        FileDownloader fileDownloaderA2 = q.a();
        DownloadItem downloadItem2 = new DownloadItem();
        downloadItem2.filePath = adUnit.getSplashFilePath();
        downloadItem2.url = adUnit.getSplashURL();
        downloadItem2.type = DownloadItem.FileType.OTHER;
        downloadItem2.userRange = false;
        fileDownloaderA2.add(downloadItem2, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.g.4
            public void downloadProgress(DownloadItem item, long totalSize, long readSize) {
            }

            public void onCancel(DownloadItem item) {
            }

            public void onErrorResponse(DownloadItem item) {
                String message = item.error.getMessage();
                if (item.error.networkResponse != null) {
                    message = message + " status code " + item.error.networkResponse.statusCode;
                }
                b bVar = adStackStatusListener;
                if (bVar != null) {
                    bVar.a(adUnit, message);
                }
                SigmobLog.e("onErrorResponse: " + message);
            }

            public void onSuccess(DownloadItem item) {
                b bVar = adStackStatusListener;
                if (bVar != null) {
                    bVar.a(adUnit, null);
                }
            }
        });
    }

    public static void b(String requestId) {
        if (TextUtils.isEmpty(requestId)) {
            return;
        }
        q.remove(requestId);
    }

    public static BaseAdUnit c(String uuid) {
        return h.get(uuid);
    }

    public static void c() {
        try {
            for (File file : FileUtil.orderByDate(com.sigmob.sdk.base.utils.i.c())) {
                long jCurrentTimeMillis = System.currentTimeMillis() - ((com.sigmob.sdk.base.o.a().ai() * 3600) * 1000);
                if (file.exists() && jCurrentTimeMillis > file.lastModified()) {
                    if (file.isFile()) {
                        if (!FileUtil.deleteFile(file.getAbsolutePath())) {
                            return;
                        }
                    } else if (file.isDirectory() && !FileUtil.deleteDirectory(file.getAbsolutePath())) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(BaseAdUnit adUnit) {
        l = adUnit;
    }

    public static synchronized com.sigmob.sdk.videocache.h d() {
        if (i == null) {
            e();
        }
        return i;
    }

    public static List<BaseAdUnit> d(String placementId) {
        List<BaseAdUnit> list;
        if (TextUtils.isEmpty(placementId) || (list = n.get(placementId)) == null || list.isEmpty()) {
            return null;
        }
        Iterator it = new CopyOnWriteArrayList(list).iterator();
        while (it.hasNext()) {
            BaseAdUnit baseAdUnit = (BaseAdUnit) it.next();
            if (baseAdUnit.isExpiredAd()) {
                list.remove(baseAdUnit);
            }
        }
        return list;
    }

    public static void d(BaseAdUnit deeplinkAdUnit) {
        m = deeplinkAdUnit;
    }

    public static List<BaseAdUnit> e(String uuid) {
        return A.get(uuid);
    }

    public static synchronized void e() {
        h.a aVar = new h.a(com.sigmob.sdk.b.e());
        try {
            aVar.a(new File(com.sigmob.sdk.base.utils.i.b()));
        } catch (Throwable th) {
            SigmobLog.e("initHttpProxyCacheServer fail ", th);
        }
        i = aVar.a();
    }

    public static BaseAdUnit f() {
        return l;
    }

    public static void f(String placementId) {
        if (TextUtils.isEmpty(placementId)) {
            return;
        }
        HashMap<String, Integer> map = s;
        Integer num = map.get(placementId);
        map.put(placementId, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
    }

    public static synchronized g g() {
        if (g == null) {
            g = new g();
        }
        return g;
    }

    public static void g(String placementId) {
        if (TextUtils.isEmpty(placementId)) {
            return;
        }
        s.remove(placementId);
    }

    public static Integer h(String placementId) {
        if (!TextUtils.isEmpty(placementId)) {
            HashMap<String, Integer> map = s;
            if (map.containsKey(placementId)) {
                return map.get(placementId);
            }
        }
        return 1;
    }

    public static void h() {
        try {
            File[] fileArrClearCacheFileByCount = FileUtil.clearCacheFileByCount(a(FileUtil.orderByDate(com.sigmob.sdk.base.utils.i.e()), System.currentTimeMillis(), com.sigmob.sdk.base.o.a().A()), com.sigmob.sdk.base.o.a().z());
            SigmobLog.i(fileArrClearCacheFileByCount == null ? "splash ad file list is null" : "splash ad file remain num: " + fileArrClearCacheFileByCount.length);
        } catch (Throwable th) {
            SigmobLog.e("clean splash ad file error", th);
        }
    }

    public static void i() {
        try {
            File[] fileArrClearCacheFileByCount = FileUtil.clearCacheFileByCount(FileUtil.orderByDate(com.sigmob.sdk.base.utils.i.b()), com.sigmob.sdk.base.o.a().w() + com.sigmob.sdk.base.o.a().B());
            SigmobLog.i(fileArrClearCacheFileByCount == null ? "splash ad file list is null" : "splash ad file remain num: " + fileArrClearCacheFileByCount.length);
        } catch (Throwable th) {
            SigmobLog.e("clean splash ad file error", th);
        }
    }

    public static void j() {
        try {
            File[] fileArrClearCacheFileByCount = FileUtil.clearCacheFileByCount(FileUtil.orderByDate(com.sigmob.sdk.base.utils.i.f()), com.sigmob.sdk.base.o.a().B());
            SigmobLog.i(fileArrClearCacheFileByCount == null ? "native ad file list is null" : "native ad file remain num: " + fileArrClearCacheFileByCount.length);
        } catch (Throwable th) {
            SigmobLog.e("clean native ad file error", th);
        }
    }

    public static void k() {
        try {
            File[] fileArrOrderByDate = FileUtil.orderByDate(com.sigmob.sdk.base.utils.i.a(com.sigmob.sdk.b.e()).getAbsolutePath());
            if (fileArrOrderByDate != null && fileArrOrderByDate.length != 0) {
                for (File file : fileArrOrderByDate) {
                    if (file != null && System.currentTimeMillis() - file.lastModified() > 604800000) {
                        SigmobLog.d("clearDownloadAPK: file = " + file.getName() + ", result = " + file.delete());
                    }
                }
                return;
            }
            SigmobLog.d("clearDownloadAPK: files = " + Arrays.toString(fileArrOrderByDate));
        } catch (Exception e2) {
            SigmobLog.e("clearDownloadAPK: error = " + e2.getMessage());
        }
    }

    private String l(String url) {
        File fileC;
        if (TextUtils.isEmpty(url) || (fileC = d().c(url)) == null || !fileC.exists()) {
            return null;
        }
        return fileC.getAbsolutePath();
    }

    public static void l() {
        try {
            File[] fileArrOrderByDate = FileUtil.orderByDate(com.sigmob.sdk.base.utils.i.a());
            ArrayList arrayList = new ArrayList(Arrays.asList(fileArrOrderByDate));
            for (File file : fileArrOrderByDate) {
                if (!file.getPath().endsWith(".mp4") && !file.getPath().endsWith(".mp4.tmp") && !file.getPath().endsWith(".tgz") && !file.getPath().endsWith(".html")) {
                    arrayList.remove(file);
                }
            }
            File[] fileArrClearCacheFileByCount = FileUtil.clearCacheFileByCount((File[]) arrayList.toArray(new File[0]), 5);
            SigmobLog.i(fileArrClearCacheFileByCount == null ? "splash ad file list is null" : "splash ad file remain num: " + fileArrClearCacheFileByCount.length);
        } catch (Throwable th) {
            SigmobLog.e("clean splash ad file error", th);
        }
    }

    public static BaseAdUnit m() {
        return m;
    }

    private static void t() {
        try {
            File fileF = com.sigmob.sdk.base.utils.i.f(com.sigmob.sdk.base.utils.i.c);
            if (fileF == null) {
                return;
            }
            for (File file : FileUtil.orderByDate(fileF.getAbsolutePath())) {
                long jCurrentTimeMillis = System.currentTimeMillis() - com.sigmob.sdk.base.o.a().A();
                if (file.exists() && jCurrentTimeMillis > file.lastModified()) {
                    if (file.isFile()) {
                        if (!FileUtil.deleteFile(file.getAbsolutePath())) {
                            return;
                        }
                    } else if (file.isDirectory() && !FileUtil.deleteDirectory(file.getAbsolutePath())) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Map<String, AdCache> a(int adType) {
        if (adType == 1 || adType == 4) {
            return this.u;
        }
        if (adType == 5) {
            return this.y;
        }
        if (adType != 6) {
            return null;
        }
        return this.z;
    }

    public void a(a adCacheVideoListener) {
        if (adCacheVideoListener == null || this.r.contains(adCacheVideoListener)) {
            return;
        }
        this.r.add(adCacheVideoListener);
    }

    public void a(BaseAdUnit adUnit, b adStackStatusListener) {
        if (adStackStatusListener != null) {
            adStackStatusListener.a(adUnit);
        }
        if (adUnit == null) {
            SigmobLog.e("adUnit is null");
            if (adStackStatusListener != null) {
                adStackStatusListener.a(adUnit, "adUnit is null");
                return;
            }
            return;
        }
        if (adUnit.getAd_type() == 2) {
            b(adUnit, adStackStatusListener);
            return;
        }
        if (adStackStatusListener != null) {
            this.x.put(adUnit.getUuid(), adStackStatusListener);
        }
        try {
            new d(adUnit).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        } catch (Throwable th) {
            SigmobLog.e("AdUnitCheckCacheTask execute error", th);
        }
    }

    public void a(String placementId, int adtype) {
        Map<String, AdCache> mapA;
        if (TextUtils.isEmpty(placementId) || (mapA = a(adtype)) == null) {
            return;
        }
        mapA.remove(placementId);
    }

    public void b(a adCacheVideoListener) {
        if (adCacheVideoListener == null || !this.r.contains(adCacheVideoListener)) {
            return;
        }
        this.r.remove(adCacheVideoListener);
    }

    public void e(BaseAdUnit adUnit) {
        Map<String, AdCache> mapA;
        AdCache adCache;
        if (adUnit == null || TextUtils.isEmpty(adUnit.getAdslot_id()) || (mapA = a(adUnit.getAd_type())) == null || (adCache = mapA.get(adUnit.getAdslot_id())) == null || adCache.crids == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(adCache.crids);
        String crid = adUnit.getCrid();
        if (arrayList.contains(crid)) {
            arrayList.remove(crid);
        }
        mapA.put(adUnit.getAdslot_id(), new AdCache(Integer.valueOf(adUnit.getAd_type()), arrayList));
    }

    public void f(BaseAdUnit adUnit) {
        if (adUnit == null || TextUtils.isEmpty(adUnit.getCrid()) || TextUtils.isEmpty(adUnit.getAdslot_id())) {
            return;
        }
        Map<String, AdCache> mapA = a(adUnit.getAd_type());
        if ((mapA == null || mapA.size() <= 29) && mapA != null) {
            AdCache adCache = mapA.get(adUnit.getAdslot_id());
            ArrayList arrayList = new ArrayList();
            arrayList.add(adUnit.getCrid());
            if (adCache != null) {
                arrayList.addAll(adCache.crids);
            }
            mapA.put(adUnit.getAdslot_id(), new AdCache(Integer.valueOf(adUnit.getAd_type()), arrayList));
        }
    }

    public void g(BaseAdUnit adUnit) {
        this.t.remove(adUnit);
        this.x.remove(adUnit.getUuid());
    }

    public void i(String last_crid) {
        this.v = last_crid;
    }

    public void j(String last_campid) {
        this.w = last_campid;
    }

    public String k(String videoPath) {
        return this.p.get(videoPath);
    }

    public String n() {
        return this.v;
    }

    public String o() {
        return this.w;
    }
}
