package com.kwad.sdk.core.config;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.core.config.item.r;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    private static volatile SdkConfigData bAu;
    private static final AtomicBoolean bAt = new AtomicBoolean(false);
    private static final Object mLock = new Object();

    public static TemplateConfig Xw() {
        return bAu.templateConfigMap.couponOpenConfig;
    }

    public static TemplateConfig Xx() {
        return bAu.templateConfigMap.couponInfoConfig;
    }

    public static boolean Xy() {
        return c.bxc.getValue().intValue() == 1;
    }

    public static int Xz() {
        return c.bxd.getValue().intValue();
    }

    public static int XA() {
        return c.bxe.getValue().intValue();
    }

    public static boolean XB() {
        return c.bxg.getValue().intValue() > 0;
    }

    public static boolean XC() {
        return c.bxe.getValue().intValue() == 2;
    }

    public static int XD() {
        return c.bxf.getValue().intValue();
    }

    public static boolean XE() {
        return c.bxk.getValue().intValue() > 0;
    }

    public static boolean XF() {
        return c.bxl.getValue().intValue() == 1;
    }

    public static int XG() {
        return c.bxk.getValue().intValue();
    }

    public static int Uo() {
        if (bAu != null) {
            return bAu.goodIdcThresholdMs;
        }
        return 200;
    }

    public static synchronized void bF(Context context) {
        AtomicBoolean atomicBoolean = bAt;
        if (atomicBoolean.get()) {
            return;
        }
        com.kwad.sdk.core.d.c.d("SdkConfigManager", "loadCache");
        c.init();
        XH();
        b.bE(context);
        Yi();
        atomicBoolean.set(true);
    }

    public static boolean isLoaded() {
        return bAt.get();
    }

    @ForInvoker(methodId = "initConfigList")
    private static void XH() {
        com.kwad.components.ad.e.a.init();
        com.kwad.components.ad.feed.a.a.init();
        com.kwad.components.ad.fullscreen.a.a.init();
        com.kwad.components.ad.interstitial.b.a.init();
        com.kwad.components.ad.reward.a.a.init();
        com.kwad.components.ad.splashscreen.b.a.init();
        com.kwad.components.ct.a.a.init();
        com.kwad.components.ct.detail.a.a.init();
        com.kwad.components.ct.entry.a.a.init();
        com.kwad.components.ct.home.config.a.init();
        com.kwad.components.ct.horizontal.a.a.init();
        com.kwad.components.ct.wallpaper.a.a.init();
    }

    public static synchronized File P(Context context, String str) {
        return new File(bG(context), str);
    }

    private static synchronized File bG(Context context) {
        return new File(context.getCacheDir(), "template");
    }

    public static <T> T b(com.kwad.sdk.core.config.item.b<T> bVar) {
        if (!isLoaded()) {
            final Context contextAnu = ServiceProvider.anu();
            b.a(contextAnu, bVar);
            h.execute(new bh() { // from class: com.kwad.sdk.core.config.e.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    e.bF(contextAnu);
                }
            });
        }
        T value = bVar.getValue();
        return value != null ? value : bVar.Zh();
    }

    public static JSONObject a(com.kwad.sdk.core.config.item.e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        return jSONObject != null ? jSONObject : eVar.Zh();
    }

    public static int dz(String str) {
        Integer value = c.bxH.getValue(str);
        if (value != null) {
            return value.intValue();
        }
        return 0;
    }

    public static int a(k kVar) {
        Integer numZh = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        if (numZh == null) {
            numZh = kVar.Zh();
        }
        return numZh.intValue();
    }

    public static long a(o oVar) {
        Long lZh = (Long) b(oVar);
        if (lZh == null) {
            lZh = oVar.Zh();
        }
        return lZh.longValue();
    }

    public static double a(f fVar) {
        Double dZh = (Double) b(fVar);
        if (dZh == null) {
            dZh = fVar.Zh();
        }
        return dZh.doubleValue();
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean boolZh = (Boolean) b(dVar);
        if (boolZh == null) {
            boolZh = dVar.Zh();
        }
        return boolZh.booleanValue();
    }

    public static boolean b(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        return num != null ? num.intValue() > 0 : kVar.Zh().intValue() > 0;
    }

    public static String a(r rVar) {
        String str = (String) b(rVar);
        return str != null ? str : rVar.Zh();
    }

    public static List<String> Uh() {
        return c.bxA.getValue();
    }

    public static List<String> XI() {
        return c.bxC.getValue();
    }

    public static String XJ() {
        return c.bxz.getValue();
    }

    public static boolean TN() {
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        return c.bxs.getValue().booleanValue();
    }

    public static int TM() {
        return c.bwS.getValue().intValue();
    }

    public static List<String> XK() {
        return c.bxB.getValue();
    }

    public static boolean TP() {
        return c.bwV.getValue().intValue() == 0;
    }

    public static int XL() {
        return c.bzb.getValue().intValue();
    }

    public static int XM() {
        return c.bzc.getValue().intValue();
    }

    public static boolean XN() {
        return c.bwW.getValue().intValue() == 1;
    }

    public static boolean isShowTips() {
        TipsConfigItem.TipConfigData value = c.bxD.getValue();
        if (value != null) {
            return value.isShowTips();
        }
        return true;
    }

    public static String getTips(String str) {
        TipsConfigItem.TipConfigData value = c.bxD.getValue();
        return value != null ? value.getTips(str) : "";
    }

    public static String XO() {
        return c.bxw.getValue();
    }

    public static String XP() {
        return c.bxx.getValue();
    }

    public static boolean XQ() {
        return c.bwY.getValue().intValue() == 1;
    }

    public static int XR() {
        return c.bwZ.getValue().intValue();
    }

    public static boolean XS() {
        return c.bxa.getValue().intValue() == 1;
    }

    public static int XT() {
        return c.bxb.getValue().intValue();
    }

    public static boolean TO() {
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        return c.bwX.getValue().intValue() == 1;
    }

    public static int XU() {
        return c.bxK.getValue().intValue();
    }

    public static int XV() {
        return c.bxL.getValue().intValue();
    }

    public static int XW() {
        return c.bxM.getValue().intValue();
    }

    public static long XX() {
        return c.bxN.getValue().intValue() * 60000;
    }

    public static boolean Ue() {
        return c.bxR.getValue().intValue() == 1;
    }

    public static boolean Ub() {
        return c.bxS.getValue().intValue() == 1;
    }

    public static boolean Ud() {
        return c.bxT.getValue().intValue() == 1;
    }

    public static boolean aH(long j) {
        return (j & c.bxr.getValue().longValue()) != 0;
    }

    public static boolean XY() {
        return c.bxV.getValue().intValue() == 1;
    }

    public static boolean XZ() {
        return c.bxW.getValue().intValue() == 1;
    }

    public static String Uf() {
        return c.byf.getImei();
    }

    public static String Ug() {
        return c.byf.getOaid();
    }

    public static int Ya() {
        return c.byd.getValue().intValue();
    }

    public static boolean Yb() {
        return c.bye.getValue().booleanValue();
    }

    public static boolean Yc() {
        return com.kwad.sdk.core.h.a.acv();
    }

    public static boolean Yd() {
        return a(c.byk);
    }

    public static boolean Ye() {
        return !c.byl.getValue().booleanValue();
    }

    public static boolean Yf() {
        return a(c.byj);
    }

    public static boolean Yg() {
        return c.byn.getValue().intValue() == 1;
    }

    public static int Yh() {
        return c.byo.getValue().intValue();
    }

    public static SdkConfigData Yi() {
        if (bAu != null) {
            return bAu;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "getSdkConfigData is ui thread");
            bAu = Yj();
        } else {
            synchronized (mLock) {
                if (bAu == null) {
                    return Yj();
                }
            }
        }
        return bAu;
    }

    private static SdkConfigData Yj() {
        bAu = new SdkConfigData();
        String strDT = ag.dT(ServiceProvider.anu());
        if (!TextUtils.isEmpty(strDT)) {
            try {
                bAu.parseJson(new JSONObject(strDT));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        } else {
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "configCache is empty");
        }
        return bAu;
    }

    public static void g(SdkConfigData sdkConfigData) {
        synchronized (mLock) {
            bAu = sdkConfigData;
        }
    }

    public static boolean Yk() {
        return c.bxm.getValue().intValue() == 1;
    }

    public static boolean Yl() {
        return c.bxn.getValue().intValue() == 1;
    }

    @Deprecated
    public static int Uw() {
        return c.bxp.getValue().intValue();
    }

    public static boolean Ym() {
        return c.bxq.getValue().booleanValue();
    }

    public static boolean Yn() {
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        return c.bxZ.getValue().intValue() == 1;
    }

    public static String getUserAgent() {
        return c.byt.getValue();
    }

    public static boolean Ui() {
        return c.byr.getValue().intValue() == 1;
    }

    public static boolean Uj() {
        return c.bys.getValue().booleanValue();
    }

    public static boolean Yo() {
        return c.byQ.getValue().intValue() == 1;
    }

    public static boolean Uk() {
        return c.byu.getValue().intValue() == 1;
    }

    public static int Yp() {
        return c.bxo.getValue().intValue();
    }

    public static int Yq() {
        return c.byw.getValue().intValue();
    }

    public static int Yr() {
        return c.byv.getValue().intValue();
    }

    public static boolean Ys() {
        return c.byx.getValue().intValue() == 1;
    }

    public static double Uq() {
        return c.byC.getValue().floatValue();
    }

    public static boolean Yt() {
        return c.byy.getValue().booleanValue();
    }

    public static float Yu() {
        float fFloatValue = c.byz.getValue().floatValue();
        if (fFloatValue <= 0.0f || fFloatValue > 1.0f) {
            return 0.3f;
        }
        return fFloatValue;
    }

    public static float Yv() {
        return c.byB.getValue().floatValue();
    }

    public static float Yw() {
        return c.byA.getValue().floatValue();
    }

    public static boolean Yx() {
        return c.byD.getValue().booleanValue();
    }

    public static boolean hG() {
        return c.byG.getValue().booleanValue();
    }

    public static boolean Yy() {
        return c.byH.getValue().booleanValue();
    }

    public static boolean Yz() {
        return c.byI.getValue().intValue() > 0;
    }

    public static boolean YA() {
        return c.byP.getValue().intValue() == 1;
    }

    public static long YB() {
        return c.byN.getValue().longValue();
    }

    public static String getLogObiwanData() {
        return c.byM.getValue();
    }

    public static boolean Um() {
        return c.byR.getValue().booleanValue();
    }

    public static boolean Un() {
        return c.byS.getValue().booleanValue();
    }

    public static int Up() {
        return c.byU.getValue().intValue();
    }

    public static boolean YC() {
        return c.byT.Zs();
    }

    public static com.kwad.sdk.core.network.idc.a.b YD() {
        return c.byV.getValue();
    }

    public static int YE() {
        return c.byW.getValue().intValue();
    }

    public static long YF() {
        return c.byX.getValue().longValue();
    }

    public static int YG() {
        return c.byY.getValue().intValue();
    }

    public static boolean YH() {
        return c.byZ.getValue().floatValue() == 1.0f;
    }

    public static boolean YI() {
        return c.bza.Zs();
    }

    public static boolean YJ() {
        return c.bzd.Zs();
    }

    public static String YK() {
        return c.bze.getValue();
    }

    public static String YL() {
        return c.bzf.getValue();
    }

    public static String YM() {
        return c.bzg.getValue();
    }

    public static boolean OT() {
        return c.bzh.getValue().booleanValue();
    }

    public static boolean YN() {
        return c.bzi.getValue().booleanValue();
    }

    public static int YO() {
        return c.bzj.getValue().intValue();
    }

    public static int YP() {
        return c.bzl.getValue().intValue();
    }

    public static boolean Ur() {
        return c.bzo.getValue().booleanValue();
    }

    public static boolean YQ() {
        return c.bzq.getValue().booleanValue();
    }

    public static int YR() {
        return c.bzr.getValue().intValue();
    }

    public static boolean Uv() {
        return c.bzE.getValue().booleanValue();
    }

    public static boolean Ux() {
        return c.bzI.Zs();
    }

    public static boolean YS() {
        return c.bzQ.Zs();
    }

    public static List<String> getTKPreloadMemCacheTemplates() {
        return c.bzN.getValue();
    }

    public static int getTKErrorDetailCount() {
        return c.bzR.getValue().intValue();
    }

    public static boolean YT() {
        return c.bzS.Zs();
    }

    public static boolean UM() {
        return c.bzT.Zs();
    }

    public static int dy(String str) {
        return c.bzW.eP(str);
    }

    public static boolean YU() {
        return c.bzX.getValue().booleanValue();
    }

    public static int YV() {
        return c.bzZ.getValue().intValue();
    }

    public static int YW() {
        return c.bzY.getValue().intValue();
    }

    public static boolean UD() {
        return c.bAb.getValue().booleanValue();
    }

    public static int UE() {
        return c.bAc.getValue().intValue();
    }

    public static long YX() {
        return c.bxi.getValue().longValue();
    }

    public static long YY() {
        return c.bxj.getValue().longValue();
    }

    public static boolean YZ() {
        return c.bwQ.getValue().booleanValue();
    }

    public static Long Za() {
        return c.bwR.getValue();
    }

    public static boolean Zb() {
        int iIntValue = c.bAd.getValue().intValue();
        return iIntValue == 1 || iIntValue == 3;
    }

    public static boolean UF() {
        int iIntValue = c.bAd.getValue().intValue();
        return iIntValue == 2 || iIntValue == 3;
    }

    public static long Zc() {
        return c.bAe.getValue().longValue();
    }

    public static String Zd() {
        return c.bAh.getValue();
    }

    public static String Ze() {
        return c.bAk.getValue();
    }

    public static String Zf() {
        return c.bAl.getValue();
    }

    public static boolean Zg() {
        return c.bAm.Zs();
    }

    public static int UG() {
        return c.bAo.getValue().intValue();
    }
}
