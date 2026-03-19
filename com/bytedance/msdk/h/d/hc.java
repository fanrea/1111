package com.bytedance.msdk.h.d;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.d.d.c;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import com.kwad.sdk.api.model.AdnName;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static volatile hc d;
    private Map<String, com.bytedance.msdk.core.tc.d> b = new ConcurrentHashMap();
    private zw hc = com.bytedance.msdk.h.d.c();

    private hc() {
    }

    public static hc d() {
        if (d == null) {
            synchronized (hc.class) {
                if (d == null) {
                    d = new hc();
                }
            }
        }
        return d;
    }

    private void hc(JSONObject jSONObject) {
        this.b.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            com.bytedance.msdk.core.tc.d dVarD = com.bytedance.msdk.core.tc.d.d(next, jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject != null && dVarD != null) {
                if (TextUtils.equals(next, "pangle") && com.bytedance.msdk.core.d.mk().mt()) {
                    this.b.put("pangle_custom", dVarD);
                } else {
                    this.b.put(next, dVarD);
                }
            }
        }
    }

    private void u() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String strHc = this.hc.hc("adn_init_config");
        if (TextUtils.isEmpty(strHc)) {
            return;
        }
        if (!strHc.startsWith("[") && !strHc.startsWith("{")) {
            strHc = com.bytedance.msdk.gb.d.hc(strHc, com.bytedance.msdk.gb.hc.d());
        }
        if (TextUtils.isEmpty(strHc)) {
            return;
        }
        try {
            hc(new JSONObject(strHc));
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            hc(jSONObject);
            String string = jSONObject.toString();
            if (!TextUtils.isEmpty(string)) {
                this.hc.d("adn_init_config", string);
            }
        }
        b(jSONObject);
    }

    private void b(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        an.c(new Runnable() { // from class: com.bytedance.msdk.h.d.hc.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.h.hc.hc.d().d(jSONObject);
            }
        });
    }

    public com.bytedance.msdk.core.tc.d d(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (this.b.size() == 0) {
            u();
        }
        return this.b.get(str);
    }

    public List<com.bytedance.msdk.core.tc.d> hc() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (this.b.size() == 0) {
            u();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.msdk.core.tc.d>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.tc.d value = it.next().getValue();
            if (value != null && value.c()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public boolean hc(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        com.bytedance.msdk.core.tc.d dVar;
        if (this.b.size() == 0) {
            u();
        }
        Map<String, com.bytedance.msdk.core.tc.d> map = this.b;
        return (map == null || (dVar = map.get(str)) == null || !dVar.c()) ? false : true;
    }

    public boolean b() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (this.b.size() == 0) {
            u();
        }
        return this.b.isEmpty();
    }

    private Set<String> an() {
        HashSet hashSet = new HashSet();
        if (this.b.size() != 0) {
            for (Map.Entry<String, com.bytedance.msdk.core.tc.d> entry : this.b.entrySet()) {
                com.bytedance.msdk.core.tc.d value = entry.getValue();
                if (value != null && !value.c()) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        return hashSet;
    }

    public synchronized void c() {
        List<String> listD;
        Context context = com.bytedance.msdk.core.hc.getContext();
        if (context == null) {
            return;
        }
        Set<String> setAn = an();
        if (setAn.size() == 0) {
            return;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "------------------ 聚合 接入信息 start ---------------------");
        com.bytedance.msdk.d.u.b.d("TTMediationSDK_SDK_Init", "当前接入的聚合 SDK版本是：" + com.bytedance.msdk.hc.hc.hc());
        if ((Build.VERSION.SDK_INT >= 24 || i >= 24) && (listD = d(context)) != null) {
            Iterator<String> it = setAn.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!"unity".equals(next) && !"pangle_custom".equals(next) && !"xiaomi".equals(next)) {
                    if ("pangle".equals(next) && com.bytedance.msdk.core.d.mk().mt()) {
                        next = "pangle_custom";
                    }
                    if (!listD.contains(next)) {
                        com.bytedance.msdk.d.u.b.c("TTMediationSDK_SDK_Init", "未按要求接入三方广告sdk【" + next + "】，请检查接入配置");
                    } else {
                        com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "已按要求接入三方广告sdk【" + next + "】");
                    }
                }
            }
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 end ---------------------");
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 start ---------------------");
        for (String str : setAn) {
            if (!TextUtils.equals(str, "pangle")) {
                c cVarD = com.bytedance.msdk.an.hc.hc.d().d(str);
                if (cVarD != null) {
                    cVarD.c();
                } else {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK_InitChecker", "没有引入" + str + "Adapter,请检查相关引入情况");
                }
            }
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 end ---------------------");
    }

    private List<String> d(Context context) {
        List<ProviderInfo> listQueryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (listQueryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        Iterator<ProviderInfo> it = listQueryContentProviders.iterator();
        while (it.hasNext()) {
            String str = it.next().name;
            str.hashCode();
            switch (str) {
                case "com.baidu.mobads.sdk.api.BdFileProvider":
                    arrayList.add(AdnName.BAIDU);
                    break;
                case "com.mbridge.msdk.foundation.tools.MBFileProvider":
                    arrayList.add("mintegral");
                    break;
                case "com.sigmob.sdk.SigmobFileProvider":
                case "com.sigmob.sdk.SigmobFileV4Provider":
                    arrayList.add("sigmob");
                    break;
                case "com.tencent.klevin.utils.FileProvider":
                    arrayList.add("klevin");
                    break;
                case "com.google.android.gms.ads.MobileAdsInitProvider":
                    arrayList.add("admob");
                    break;
                case "com.bykv.vk.openvk.TTFileProvider":
                    arrayList.add("pangle_custom");
                    break;
                case "com.kwad.sdk.api.proxy.app.AdSdkFileProvider":
                    arrayList.add("ks");
                    break;
                case "com.bytedance.sdk.openadsdk.TTFileProvider":
                    arrayList.add("pangle");
                    break;
                case "com.unity":
                    arrayList.add("unity");
                    break;
                case "com.qq.e.comm.GDTFileProvider":
                    arrayList.add("gdt");
                    break;
            }
        }
        return arrayList;
    }
}
