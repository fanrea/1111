package com.bytedance.sdk.component.mq.hc.d;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.openvk.component.video.api.b.c;
import com.bykv.vk.openvk.component.video.api.d.hc;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements hc {
    private long d;
    private String hc = "tt_video_reward_full";
    private String b = "tt_video_brand";
    private String c = "tt_video_splash";
    private String u = "tt_video_default";
    private String an = null;
    private String h = null;
    private String gb = null;
    private String tt = null;
    private String tc = null;
    private String mk = null;

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public void u() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public void d(String str) {
        if (!TextUtils.isEmpty(this.mk) && !this.mk.equals(str)) {
            this.an = null;
            this.h = null;
            this.gb = null;
            this.tt = null;
            this.tc = null;
        }
        this.mk = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public String c() {
        if (this.tc == null) {
            this.tc = this.mk + File.separator + this.u;
            File file = new File(this.tc);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.tc;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public String d() {
        if (this.h == null) {
            this.h = this.mk + File.separator + this.hc;
            File file = new File(this.h);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.h;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public String hc() {
        if (this.gb == null) {
            this.gb = this.mk + File.separator + this.b;
            File file = new File(this.gb);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.gb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public String b() {
        if (this.tt == null) {
            this.tt = this.mk + File.separator + this.c;
            File file = new File(this.tt);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.tt;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public boolean d(c cVar) {
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(cVar.w(), cVar.u());
        if (cacheInfoByFilePath != null) {
            boolean zUo = cVar.uo();
            this.d = cacheInfoByFilePath.mCacheSizeFromZero;
            int iHc = cVar.hc() > 0 ? cVar.hc() : cVar.an();
            if (zUo) {
                iHc = (int) cVar.mq();
            }
            if (cacheInfoByFilePath.mCacheSizeFromZero >= iHc) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.hc
    public long hc(c cVar) {
        return this.d;
    }
}
