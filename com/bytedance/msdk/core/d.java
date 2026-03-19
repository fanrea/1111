package com.bytedance.msdk.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.an.hc.u;
import com.bytedance.msdk.api.c.an;
import com.bytedance.msdk.api.c.k;
import com.bytedance.msdk.gb.fs;
import com.bytedance.msdk.gb.sy;
import com.bytedance.msdk.gb.yi;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.openadsdk.w.c;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static final d nv = new d();
    private String b;
    private PluginValueSet ba;
    private long bc;
    private String c;
    private final Map<String, Integer> dc;
    private boolean fs;
    private String gb;
    private String[] hc;
    private JSONObject he;
    private Object hv;
    private boolean j;
    private Map<String, String> mk;
    private String mq;
    private boolean np;
    private com.bytedance.msdk.d.b.b r;
    private an rf;
    private boolean s;
    private String tc;
    private final Map<String, Float> tr;
    private boolean tt;
    private String uo;
    private String us;
    private List<String> v;
    private boolean vv;
    private k wl;
    private int[] y;
    private boolean yi;
    private com.bytedance.msdk.api.c.d.tt.d z;
    private String zw;
    private int d = 0;
    private boolean u = true;
    private boolean an = false;
    private boolean h = false;
    private Set<String> k = new HashSet();
    private Map<String, Map<String, String>> e = new HashMap();
    private Map<String, Map<String, String>> cb = new HashMap();
    private boolean w = false;
    private final Map<String, Object> yo = new sy();
    private long jh = -1;
    private Map<String, Object> sy = new ConcurrentHashMap();
    private Map<String, Object> de = new ConcurrentHashMap();
    private int mt = -1;

    public void d(boolean z) {
        this.w = z;
    }

    public boolean d() {
        return this.w;
    }

    public com.bytedance.msdk.d.b.b hc() {
        if (this.r == null) {
            c cVarD = c.d();
            u.d(cVarD);
            this.r = com.bytedance.msdk.d.b.b.d((SparseArray<Object>) cVarD.hc());
        }
        return this.r;
    }

    public void d(String str, float f) {
        this.tr.put(str, Float.valueOf(f));
    }

    public float d(String str) {
        return this.tr.get(str).floatValue();
    }

    public void d(long j) {
        com.bytedance.msdk.h.hc.d.d().d(j);
    }

    public long b() {
        long j = this.jh;
        if (j != -1) {
            return j;
        }
        long jHc = com.bytedance.msdk.h.hc.d.d().hc();
        this.jh = jHc;
        return jHc;
    }

    private d() {
        HashMap map = new HashMap();
        this.dc = map;
        this.tr = new ConcurrentHashMap();
        if (hc.hc().r()) {
            map.put("adGap", 1);
            map.put("adLoad", 1);
            map.put("sectionId", 1);
            map.put("pageId", 1);
            map.put(SchedulerSupport.CUSTOM, 1);
        }
    }

    public Map<String, Integer> c() {
        return this.dc;
    }

    public long u() {
        return this.bc;
    }

    public void hc(long j) {
        this.bc = j;
    }

    public String an() {
        return this.us;
    }

    public void hc(String str) {
        this.us = str;
    }

    public boolean h() {
        return this.tt;
    }

    public void hc(boolean z) {
        this.tt = z;
    }

    public String gb() {
        if (("com.union_test.toutiao".equals(hc.getContext().getPackageName()) && "5001121".equals(this.b)) || ("com.bytedance.mediation_demo".equals(hc.getContext().getPackageName()) && "5001121".equals(this.b))) {
            try {
                return zw.d("tt_mediation_ppe_info", hc.getContext()).hc("tt_ppe_content");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean tt() {
        return "com.bytedance.mediation_demo_csj".equals(hc.getContext().getPackageName()) && tc();
    }

    public boolean tc() {
        String path = com.bytedance.sdk.openadsdk.api.plugin.hc.b(hc.getContext()).getPath();
        if (this.mt < 0) {
            if (new File(path + "/e2e.text").exists()) {
                this.mt = 1;
            } else {
                this.mt = 0;
            }
        }
        return this.mt > 0;
    }

    public static d mk() {
        return nv;
    }

    public String mq() {
        return this.b;
    }

    public void b(String str) {
        tt(str);
        this.b = str;
    }

    public void b(boolean z) {
        this.fs = z;
    }

    public boolean uo() {
        return this.fs;
    }

    public boolean k() {
        return this.u;
    }

    public boolean e() {
        return this.h;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public void c(String str) {
        this.gb = str;
    }

    public String cb() {
        return this.tc;
    }

    public void u(String str) {
        this.tc = str;
    }

    public Map<String, String> w() {
        return this.mk;
    }

    public void d(Map<String, String> map) {
        this.mk = map;
    }

    public String yo() {
        return this.gb;
    }

    public void u(boolean z) {
        this.u = z;
    }

    public void d(int... iArr) {
        this.y = iArr;
    }

    public int[] rf() {
        return this.y;
    }

    public void an(boolean z) {
        this.an = z;
    }

    public boolean jh() {
        return this.an;
    }

    public String sy() {
        return this.c;
    }

    public static String d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            String str = (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
            return str;
        } catch (Throwable th) {
            mq.d(th);
            return "";
        }
    }

    public void an(String str) {
        if (TextUtils.isEmpty(str)) {
            str = d(hc.getContext());
        }
        this.c = str;
    }

    public void d(int i) {
        this.d = i;
    }

    public int de() {
        return this.d;
    }

    public void d(String[] strArr) {
        this.hc = strArr;
    }

    public String[] v() {
        return this.hc;
    }

    private static void tt(String str) {
        yi.d(str, "appid不能为空");
    }

    public String np() {
        if (!TextUtils.isEmpty(this.uo)) {
            return this.uo;
        }
        String strD = zw.d((String) null, hc.getContext()).d();
        this.uo = strD;
        if (!TextUtils.isEmpty(strD)) {
            return this.uo;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        zw.d((String) null, hc.getContext()).d(strValueOf);
        this.uo = strValueOf;
        return strValueOf;
    }

    public boolean yi() {
        try {
            if ("com.union_test.toutiao".equals(hc.getContext().getPackageName()) && "5001121".equals(this.b)) {
                return true;
            }
            if ("com.pangolin_demo.toutiao".equals(hc.getContext().getPackageName()) && "5001121".equals(this.b)) {
                return true;
            }
            if ("com.bytedance.mediation_demo".equals(hc.getContext().getPackageName()) && "5001121".equals(this.b)) {
                return true;
            }
            if ("com.msdk.qa.monkey".equals(hc.getContext().getPackageName()) && "5001121".equals(this.b)) {
                return true;
            }
            if (hc.getContext().getPackageName().contains("com.bytedance.mediation_demo_csj")) {
                return "5001121".equals(this.b);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean he() {
        String strD = fs.d();
        return "com.union_test.toutiao".equals(strD) || "com.bytedance.mediation_demo".equals(strD) || "com.msdk.qa.monkey".equals(strD);
    }

    public void h(String str) {
        this.mq = str;
    }

    public String vv() {
        return this.mq;
    }

    public an zw() {
        return this.rf;
    }

    public void d(an anVar, boolean z) {
        boolean zEquals;
        if (!z) {
            an anVar2 = this.rf;
            if (anVar2 == null && anVar == null) {
                zEquals = true;
            } else {
                zEquals = (anVar2 == null || anVar == null) ? false : anVar2.equals(anVar);
            }
            this.rf = anVar;
            if (zEquals) {
                return;
            }
            com.bytedance.msdk.core.k.hc.d(hc.hc()).d().d(3);
            return;
        }
        this.rf = anVar;
    }

    public k j() {
        if (this.wl == null) {
            this.wl = k.d(mk().hc());
        }
        return this.wl;
    }

    public void s() {
        this.wl = k.d(mk().hc());
    }

    public Map<String, Object> us() {
        return this.sy;
    }

    public void hc(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.sy.putAll(map);
    }

    public Map<String, Object> z() {
        return this.de;
    }

    public void b(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.de.putAll(map);
    }

    public List<String> fs() {
        return this.v;
    }

    public void d(List<String> list) {
        this.v = list;
    }

    public boolean ba() {
        return this.np;
    }

    public void h(boolean z) {
        this.np = z;
    }

    public boolean mt() {
        return this.yi;
    }

    public void gb(boolean z) throws ClassNotFoundException {
        this.yi = z;
        if (z) {
            try {
                Class.forName("com.bykv.vk.openvk.TTVfSdk");
            } catch (ClassNotFoundException e) {
                this.yi = false;
                mq.d(e);
            }
        }
    }

    public JSONObject r() {
        return this.he;
    }

    public void d(JSONObject jSONObject) {
        this.he = jSONObject;
    }

    public boolean hv() {
        return this.vv;
    }

    public void tt(boolean z) {
        this.vv = z;
    }

    public String bc() {
        return this.zw;
    }

    public void gb(String str) {
        this.zw = str;
    }

    public boolean dc() {
        return this.j;
    }

    public void tc(boolean z) {
        this.j = z;
    }

    public boolean tr() {
        return this.s;
    }

    public void mk(boolean z) {
        this.s = z;
    }

    public Map<String, Object> nv() {
        this.yo.put("gm_usb", com.bytedance.msdk.core.tt.u.u());
        return this.yo;
    }

    public PluginValueSet y() {
        PluginValueSet pluginValueSet = this.ba;
        return pluginValueSet != null ? pluginValueSet : com.bykv.d.d.d.d.d.d().hc();
    }

    public void d(PluginValueSet pluginValueSet) {
        this.ba = pluginValueSet;
    }

    public com.bytedance.msdk.api.c.d.tt.d wl() {
        return this.z;
    }

    public void d(com.bytedance.msdk.api.c.d.tt.d dVar) {
        this.z = dVar;
    }

    public Object q() {
        return this.hv;
    }

    public void d(Object obj) {
        this.hv = obj;
    }
}
