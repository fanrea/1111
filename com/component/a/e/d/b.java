package com.component.a.e.d;

import com.baidu.mobads.annotation.remote.template.RewardVideoJson;
import com.component.a.g.g;
import com.component.a.i.n;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b implements g.a {
    private final boolean a;

    public b(boolean z) {
        this.a = z;
    }

    @Override // com.component.a.g.g.a
    public String a(String str) {
        RewardVideoJson rewardVideoJson = new RewardVideoJson();
        if ("rvideo_draw".equals(str)) {
            return rewardVideoJson.getDrawVideo();
        }
        if ("rvideo_top".equals(str)) {
            return rewardVideoJson.getTopVideo();
        }
        if ("rvideo_big_card".equals(str)) {
            return rewardVideoJson.getBigCardVideo();
        }
        if ("rvideo_center".equals(str)) {
            return rewardVideoJson.getCenterVideo();
        }
        if ("rvideo_super_card".equals(str)) {
            return rewardVideoJson.getSuperCardVideo();
        }
        if ("rvideo_atlas".equals(str)) {
            return rewardVideoJson.getDrawPicture();
        }
        if ("rvideo_hor_small_card".equals(str)) {
            return rewardVideoJson.getHorSmallCardVideo();
        }
        if ("rvideo_hor_left_video".equals(str)) {
            return rewardVideoJson.getHorLeftVideo();
        }
        if ("rvideo_hor_atlas".equals(str)) {
            return rewardVideoJson.getHorDrawPicture();
        }
        return rewardVideoJson.getSmallCardVideo();
    }

    @Override // com.component.a.g.g.a
    public JSONObject a() {
        String strA;
        if (this.a) {
            strA = a("rvideo_atlas");
        } else {
            strA = a("rvideo_small_card");
        }
        return n.b(strA);
    }
}
