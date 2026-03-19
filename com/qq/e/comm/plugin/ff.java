package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.qq.e.comm.pi.AdData;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ff implements AdData {
    private final gh a;
    private AdData.VideoPlayer b;
    private Map<String, Object> c;

    public ff(h4 h4Var) {
        hf hfVar = new hf();
        this.a = hfVar;
        hfVar.a(IDJXAd.AD_CODE_ID, h4Var.g());
        hfVar.a("ad_desc", h4Var.H());
        hfVar.a("ad_title", h4Var.R0());
        hfVar.a("ad_ecpm", h4Var.M());
        hfVar.a("ad_ecpm_level", h4Var.g1());
        hfVar.a("negative_feedback_url", h4Var.q0());
        if (!TextUtils.isEmpty(h4Var.V0())) {
            hfVar.a("ad_pattern_type", 2);
        }
        hfVar.a("ad_video_duration", h4Var.W0() * 1000);
        hfVar.a("ad_rt_priority", h4Var.z0());
        hfVar.a("ad_contract_ad", h4Var.l1());
        hfVar.a("ad_mp", h4Var.o0());
        this.c = h4Var.V();
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getTitle() {
        return this.a.c("ad_title");
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getDesc() {
        return this.a.c("ad_desc");
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getAdPatternType() {
        return this.a.b("ad_pattern_type");
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getECPM() {
        return this.a.b("ad_ecpm");
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getECPMLevel() {
        return this.a.c("ad_ecpm_level");
    }

    @Override // com.qq.e.comm.pi.AdData
    public void setECPMLevel(String str) {
        this.a.a("ad_ecpm_level", str);
    }

    @Override // com.qq.e.comm.pi.AdData
    public Map<String, Object> getExtraInfo() {
        return this.c;
    }

    @Override // com.qq.e.comm.pi.AdData
    public <T> T getProperty(Class<T> cls) {
        if (cls == AdData.VideoPlayer.class) {
            return (T) this.b;
        }
        if (cls == gh.class) {
            return (T) this.a;
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.AdData
    public boolean equalsAdData(AdData adData) {
        if (this == adData) {
            return true;
        }
        if (adData == null) {
            return false;
        }
        String property = getProperty(IDJXAd.AD_CODE_ID);
        String property2 = adData.getProperty(IDJXAd.AD_CODE_ID);
        if (property != null) {
            return property.equals(property2);
        }
        return property2 == null;
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getVideoDuration() {
        return this.a.b("ad_video_duration");
    }

    public int a() {
        return this.a.b("ad_mp");
    }

    public boolean b() {
        return this.a.a("ad_contract_ad");
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getProperty(String str) {
        return this.a.c(str);
    }

    public void a(AdData.VideoPlayer videoPlayer) {
        this.b = videoPlayer;
    }
}
