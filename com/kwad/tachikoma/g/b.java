package com.kwad.tachikoma.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.tachikoma.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class b {
    private static volatile b Cu;
    private Map<String, Boolean> Co = new ConcurrentHashMap();
    private Map<String, List<a>> Cq = new ConcurrentHashMap();

    public interface a {
        void im();

        void onSuccess(String str);
    }

    public static b il() {
        if (Cu == null) {
            synchronized (b.class) {
                if (Cu == null) {
                    Cu = new b();
                }
            }
        }
        return Cu;
    }

    public final void a(Context context, String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, aVar);
        if (this.Co.containsKey(str)) {
            return;
        }
        File file = new File(e.hP().hQ().getTkJsRootDir(context) + File.separator + "common-resource");
        if (!file.exists() && !file.mkdirs()) {
            f(str, "root dir create failed");
            return;
        }
        File file2 = new File(file, r(str));
        if (file2.exists()) {
            c(str, file2.getAbsolutePath());
            return;
        }
        this.Co.put(str, Boolean.TRUE);
        boolean zDownloadSync = OfflineHostProvider.getApi().downloader().downloadSync(file2, str);
        this.Co.remove(str);
        if (!zDownloadSync) {
            f(str, "download failed");
        } else {
            c(str, file2.getAbsolutePath());
        }
    }

    private static String r(String str) {
        return OfflineHostProvider.getApi().encrypt().getMD5(str) + Uri.parse(str).getLastPathSegment();
    }

    private void a(String str, a aVar) {
        List<a> arrayList = this.Cq.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.Cq.put(str, arrayList);
        }
        arrayList.add(aVar);
    }

    private List<a> s(String str) {
        return this.Cq.get(str);
    }

    private void c(String str, String str2) {
        List<a> listS = s(str);
        if (listS == null) {
            return;
        }
        Iterator<a> it = listS.iterator();
        while (it.hasNext()) {
            it.next().onSuccess(str2);
        }
        listS.clear();
    }

    private void f(String str, String str2) {
        List<a> listS = s(str);
        if (listS == null) {
            return;
        }
        Iterator<a> it = listS.iterator();
        while (it.hasNext()) {
            it.next().im();
        }
        listS.clear();
    }
}
