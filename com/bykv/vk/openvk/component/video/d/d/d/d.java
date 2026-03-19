package com.bykv.vk.openvk.component.video.d.d.d;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.b.c;
import com.bytedance.sdk.component.utils.mq;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bykv.vk.openvk.component.video.api.d.hc {
    private String d = "video_reward_full";
    private String hc = "video_brand";
    private String b = "video_splash";
    private String c = "video_default";
    private String u = null;
    private String an = null;
    private String h = null;
    private String gb = null;
    private String tt = null;

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public void d(String str) {
        this.u = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public String c() {
        if (this.tt == null) {
            this.tt = this.u + File.separator + this.c;
            File file = new File(this.tt);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.tt;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public String d() {
        if (this.an == null) {
            this.an = this.u + File.separator + this.d;
            File file = new File(this.an);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.an;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public String hc() {
        if (this.h == null) {
            this.h = this.u + File.separator + this.hc;
            File file = new File(this.h);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.h;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public String b() {
        if (this.gb == null) {
            this.gb = this.u + File.separator + this.b;
            File file = new File(this.gb);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.gb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public synchronized void u() {
        com.bykv.vk.openvk.component.video.api.an.b.d("Exec clear video cache ");
        com.bykv.vk.openvk.component.video.api.an.b.d(this.u);
        List<com.bykv.vk.openvk.component.video.api.d.d> listAn = an();
        if (Build.VERSION.SDK_INT >= 23) {
            Set<String> setH = null;
            for (com.bykv.vk.openvk.component.video.api.d.d dVar : listAn) {
                File[] fileArrD = dVar.d();
                if (fileArrD != null && fileArrD.length >= dVar.hc()) {
                    if (setH == null) {
                        setH = h();
                    }
                    int iHc = dVar.hc() - 2;
                    if (iHc < 0) {
                        iHc = 0;
                    }
                    d(dVar.d(), iHc, setH);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public boolean d(c cVar) {
        if (TextUtils.isEmpty(cVar.u()) || TextUtils.isEmpty(cVar.w())) {
            return false;
        }
        return new File(cVar.u(), cVar.w()).exists();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public long hc(c cVar) {
        if (TextUtils.isEmpty(cVar.u()) || TextUtils.isEmpty(cVar.w())) {
            return 0L;
        }
        return com.bykv.vk.openvk.component.video.d.u.b.d(cVar.u(), cVar.w());
    }

    private static void d(File[] fileArr, int i, Set<String> set) {
        if (i >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i) {
                    List listAsList = Arrays.asList(fileArr);
                    Collections.sort(listAsList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.d.d.d.d.1
                        @Override // java.util.Comparator
                        /* renamed from: d, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long jLastModified = file2.lastModified() - file.lastModified();
                            if (jLastModified == 0) {
                                return 0;
                            }
                            return jLastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i < listAsList.size()) {
                        File file = (File) listAsList.get(i);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) listAsList.get(i)).delete();
                        }
                        i++;
                    }
                }
            } catch (Throwable th) {
                mq.d(th);
            }
        }
    }

    private List<com.bykv.vk.openvk.component.video.api.d.d> an() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bykv.vk.openvk.component.video.api.d.d(new File(d()).listFiles(), com.bykv.vk.openvk.component.video.d.d.b()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.d.d(new File(b()).listFiles(), com.bykv.vk.openvk.component.video.d.d.hc()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.d.d(new File(hc()).listFiles(), com.bykv.vk.openvk.component.video.d.d.c()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.d.d(new File(c()).listFiles(), com.bykv.vk.openvk.component.video.d.d.u()));
        return arrayList;
    }

    private Set<String> h() {
        HashSet hashSet = new HashSet();
        for (com.bykv.vk.openvk.component.video.d.d.d dVar : com.bykv.vk.openvk.component.video.d.d.d.d.values()) {
            if (dVar != null && dVar.d() != null) {
                c cVarD = dVar.d();
                hashSet.add(com.bykv.vk.openvk.component.video.d.u.b.hc(cVarD.u(), cVarD.w()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.d.u.b.b(cVarD.u(), cVarD.w()).getAbsolutePath());
            }
        }
        for (com.bykv.vk.openvk.component.video.d.d.hc.hc hcVar : com.bykv.vk.openvk.component.video.d.d.hc.b.d.values()) {
            if (hcVar != null && hcVar.d() != null) {
                c cVarD2 = hcVar.d();
                hashSet.add(com.bykv.vk.openvk.component.video.d.u.b.hc(cVarD2.u(), cVarD2.w()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.d.u.b.b(cVarD2.u(), cVarD2.w()).getAbsolutePath());
            }
        }
        return hashSet;
    }
}
