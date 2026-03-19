package com.baidu.mobads.container.adrequest;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.rewardvideo.NativeRewardActivity;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobads.container.rewardvideo.dp;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bo;
import com.baidu.mobads.container.util.ce;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.d.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class y extends o {
    private static final long y = 1740000;
    private static final String z = "com.baidu.mobads.sdk.api.MobRewardVideoActivity";
    private boolean A;
    private boolean B;
    private Context C;
    private boolean D;
    private String E;
    private String F;
    private List<j> G;

    public y(Context context, ProdAdRequestInfo prodAdRequestInfo) {
        super(context, prodAdRequestInfo);
        this.B = false;
        this.D = false;
        this.C = context;
        this.G = new CopyOnWriteArrayList();
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void a() {
        super.a();
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void x() {
        String videoUrl;
        this.G = new CopyOnWriteArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        ArrayList<j> arrayListO = this.f.o();
        Iterator<j> it = arrayListO.iterator();
        while (it.hasNext()) {
            j next = it.next();
            n.a(next, "load_time", this.w);
            n.a(next, n.d, this.v);
            n.a(next, n.e, this.x);
            n.c(next, n.A, b(next));
            String materialType = next.getMaterialType();
            String mainPictureUrl = next.getMainPictureUrl();
            if ("image".equals(materialType) && !TextUtils.isEmpty(mainPictureUrl)) {
                copyOnWriteArrayList.add(next);
            }
            if (!TextUtils.isEmpty(next.getVideoUrl())) {
                this.G.add(next);
            }
        }
        boolean z2 = false;
        boolean z3 = "rvideo".equals(k()) && !copyOnWriteArrayList.isEmpty();
        if (z3) {
            this.G = copyOnWriteArrayList;
        }
        com.baidu.mobads.container.l.g.b().c("激励视频返回广告数：" + this.G.size());
        com.baidu.mobads.container.l.g.c("激励视频原始返回广告数：" + arrayListO.size());
        dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.s, this.f.p()));
        this.A = false;
        this.B = false;
        if (this.g != null && O()) {
            n.c(this.g, n.A, this.g.getOriginJsonObject().optString("page_url", ""));
            e("html");
            return;
        }
        if (this.G.isEmpty()) {
            b(com.baidu.mobads.container.c.a.REWARD_VIDEO_URL_EMPTY.b(), "物料资源为空");
            this.B = true;
            return;
        }
        Map<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        String str = z3 ? "im" : "vd";
        for (j jVar : this.G) {
            a(jVar, -1, (String) null);
            n.a(jVar, n.f);
            n.a(jVar, n.g, -2L);
            if (z3) {
                videoUrl = jVar.getMainPictureUrl();
            } else {
                videoUrl = jVar.getVideoUrl();
            }
            String uniqueId = jVar.getUniqueId();
            boolean zD = d(videoUrl);
            concurrentHashMap.put(videoUrl, Boolean.valueOf(zD));
            concurrentHashMap2.put(uniqueId, videoUrl);
            if (zD) {
                n.a(jVar, n.g, 0L);
                this.p.a(uniqueId, com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_EXIST);
                int iH = com.baidu.mobads.container.util.d.d.a(this.b).h(videoUrl);
                a(q(), videoUrl);
                this.p.a(uniqueId, com.baidu.mobads.container.components.h.b.a.h, String.valueOf(iH));
            } else {
                this.p.a(uniqueId, com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_START);
                z2 = true;
            }
            this.p.a(uniqueId, "ty", str);
        }
        if (!a(concurrentHashMap, z3) || z2) {
            for (String str2 : concurrentHashMap.keySet()) {
                Boolean bool = concurrentHashMap.get(str2);
                if (bool == null || !bool.booleanValue()) {
                    try {
                        com.baidu.mobads.container.util.d.d.a(this.b).a(str2, (d.InterfaceC0136d<?>) new z(this, concurrentHashMap2, str2, concurrentHashMap, z3));
                    } catch (Throwable th) {
                        if (z3) {
                            f("image");
                        } else {
                            f("video");
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void p() {
        n.a(q(), n.G);
        if (this.g != null) {
            com.baidu.mobads.container.components.h.c.f.a(this.b).a(this.g.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_START);
            if (O()) {
                boolean zI = i();
                boolean zK = K();
                if (!zI && zK) {
                    Q();
                    return;
                } else {
                    a(true, zI, zK);
                    return;
                }
            }
        }
        if ("rvideo".equals(k())) {
            I();
        } else {
            J();
        }
        ce.b(this.g, null);
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void b(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject != null) {
            this.D = jSONObject.optBoolean("showDialogOnSkip", this.D);
            if ("setContext".equals(jSONObject.optString("msg"))) {
                Object obj = map.get("context");
                if (obj instanceof Context) {
                    this.C = (Context) obj;
                    if (obj instanceof Activity) {
                        a((Activity) obj);
                    }
                }
            }
        }
    }

    private void I() {
        if (NativeRewardActivity.mVideoPlaying) {
            com.baidu.mobads.container.l.g.b().e("展现异常，已有广告正在展示");
            return;
        }
        boolean zL = L();
        boolean zI = i();
        boolean zK = K();
        if (zL && !zI && zK) {
            NativeRewardActivity.mVideoPlaying = true;
            P();
        } else {
            a(zL, zI, zK);
        }
    }

    private void J() {
        if (RemoteRewardActivity.mVideoPlaying) {
            return;
        }
        boolean zM = M();
        boolean zI = i();
        boolean zK = K();
        if (zM && !zI && zK) {
            RemoteRewardActivity.mVideoPlaying = true;
            P();
        } else {
            a(zM, zI, zK);
        }
    }

    private boolean K() {
        return !this.A;
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public boolean i() {
        if (this.g == null) {
            return true;
        }
        long expiration = this.g.getExpiration() * 1000;
        if (expiration == 0) {
            expiration = y;
        }
        boolean z2 = System.currentTimeMillis() - this.g.getCreateTime() >= expiration;
        if (z2) {
            dp.f(this.g, this);
        }
        return z2;
    }

    private boolean L() {
        if (this.g != null) {
            if ("image".equals(this.g.getMaterialType())) {
                return !TextUtils.isEmpty(this.g.getMainPictureUrl());
            }
            return !TextUtils.isEmpty(this.g.getVideoUrl());
        }
        return false;
    }

    private boolean M() {
        if (this.g != null && !TextUtils.isEmpty(this.g.getVideoUrl())) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public boolean h() {
        String str;
        boolean zK = K();
        boolean zI = i();
        boolean z2 = S() || O();
        if (zK && !zI && z2) {
            return true;
        }
        if (!z2) {
            str = "资源未缓存";
        } else if (zI) {
            str = "广告已过期";
        } else {
            str = "广告已被展示过";
        }
        com.baidu.mobads.container.l.g.b().c("广告未就绪，原因: " + str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N() {
        if (this.G.isEmpty() || !"image".equals(this.G.get(0).getMaterialType())) {
            return false;
        }
        return "rvideo".equals(k());
    }

    private boolean O() {
        if (this.g == null) {
            return false;
        }
        return !TextUtils.isEmpty(this.g.getOriginJsonObject().optString("page_url", ""));
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.E = jSONObject.optString("userid");
            this.F = jSONObject.optString("extra");
        }
    }

    private void P() {
        this.A = true;
        com.baidu.mobads.container.util.h.a(new aa(this));
    }

    private void Q() {
        this.A = true;
        com.baidu.mobads.container.util.h.a(new ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String R() {
        if (this.C == null) {
            return NativeRewardActivity.SCREEN_PORTRAIT;
        }
        int i = this.C.getResources().getConfiguration().orientation;
        if (i == 2) {
            return NativeRewardActivity.SCREEN_LANDSCAPE;
        }
        if (i == 1) {
        }
        return NativeRewardActivity.SCREEN_PORTRAIT;
    }

    public Class<?> H() {
        return bo.a("com.baidu.mobads.sdk.api.MobRewardVideoActivity");
    }

    private boolean S() {
        if (this.g == null) {
            return false;
        }
        if ("image".equals(this.g.getMaterialType())) {
            Iterator<j> it = this.G.iterator();
            while (it.hasNext()) {
                if (!d(it.next().getMainPictureUrl())) {
                    return false;
                }
            }
            return true;
        }
        return d(this.g.getVideoUrl());
    }

    private boolean d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return com.baidu.mobads.container.util.d.d.a(this.b).g(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Map<String, Boolean> map, boolean z2) {
        if (this.B) {
            return true;
        }
        if (this.G.isEmpty() || map.isEmpty()) {
            if (z2) {
                f("image");
            } else {
                f("video");
            }
            return true;
        }
        if (z2) {
            Iterator<j> it = this.G.iterator();
            while (it.hasNext()) {
                Boolean bool = map.get(it.next().getMainPictureUrl());
                if (bool == null || !bool.booleanValue()) {
                    return false;
                }
            }
            e("image");
            return true;
        }
        Boolean bool2 = map.get(this.G.get(0).getVideoUrl());
        if (bool2 == null || !bool2.booleanValue()) {
            return false;
        }
        e("video");
        return true;
    }

    private boolean d(Map<String, Boolean> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            Boolean bool = map.get(it.next());
            if (bool == null || !bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private void a(boolean z2, boolean z3, boolean z4) {
        String str;
        if (!z2) {
            str = "广告物料异常";
        } else if (z3) {
            str = "广告已过期";
        } else if (z4) {
            str = "";
        } else {
            str = "广告已被展示过";
        }
        com.baidu.mobads.container.c.a aVar = com.baidu.mobads.container.c.a.SHOW_PROCESS_FAILED;
        b(aVar.b(), aVar.c() + ", " + str);
    }

    private void e(String str) {
        this.B = true;
        dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.J));
        dp.d(this.g, this);
    }

    private void f(String str) {
        this.B = true;
        this.G.clear();
        dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.f728K));
        dp.e(this.g, this);
        bk.a(this, 4, str);
    }
}
