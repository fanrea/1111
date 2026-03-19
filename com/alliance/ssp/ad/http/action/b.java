package com.alliance.ssp.ad.http.action;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.deviceinfolib.DeviceInfoManager;
import com.alliance.ssp.ad.http.HttpException;
import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.manager.applist.InitConfigManager;
import com.alliance.ssp.ad.manager.applist.bean.InitConfigBean;
import com.alliance.ssp.ad.o0.i;
import com.alliance.ssp.ad.q.c;
import com.baidu.mobads.container.components.h.b.e;
import com.dhylive.app.utils.JumpParam;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SAAllianceEngineAction.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends BaseNetAction<SAAllianceEngineData> {
    public String f;
    public String g;
    public int h;

    public b(SAAllianceAdParams sAAllianceAdParams, String str, int i, int i2, com.alliance.ssp.ad.p.a<SAAllianceEngineData> aVar, BaseNetAction.Method method, int i3) throws JSONException, PackageManager.NameNotFoundException, IOException {
        super(aVar, method, i3);
        this.f = "https://de.ad.gameley.com/delivery/request/getad/adn";
        this.h = -1;
        this.g = str;
        sAAllianceAdParams.getPosId();
        this.h = i2;
        sAAllianceAdParams.getBidFloor();
        a((Map<String, Object>) a(sAAllianceAdParams));
        b(sAAllianceAdParams);
    }

    @Override // com.alliance.ssp.ad.q.b
    public void a(HttpException httpException) {
        com.alliance.ssp.ad.p.a<T> aVar = this.a;
        if (aVar != 0) {
            aVar.a(httpException.getErrorCode(), httpException.getMessage());
        }
        System.currentTimeMillis();
        if (httpException != null) {
            httpException.getErrorCode();
        }
    }

    @Override // com.alliance.ssp.ad.http.action.BaseNetAction
    public String b() {
        return this.f;
    }

    @Override // com.alliance.ssp.ad.http.action.BaseNetAction
    public void b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = this.g;
        Map<String, Long> map = com.alliance.ssp.ad.k.a.a;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (jCurrentTimeMillis <= 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        ((HashMap) com.alliance.ssp.ad.k.a.a).put(str2, Long.valueOf(jCurrentTimeMillis));
    }

    @Override // com.alliance.ssp.ad.q.b
    public void a(Object obj) {
        SAAllianceEngineData sAAllianceEngineData = (SAAllianceEngineData) obj;
        com.alliance.ssp.ad.p.a<T> aVar = this.a;
        if (aVar != 0) {
            aVar.a(sAAllianceEngineData);
        }
        System.currentTimeMillis();
    }

    public final void b(SAAllianceAdParams sAAllianceAdParams) throws JSONException, PackageManager.NameNotFoundException, IOException {
        String strA;
        SharedPreferences sharedPreferences;
        InitConfigBean initConfigBean;
        this.c.put("appid", i.a);
        this.c.put("crequestid", this.g);
        this.c.put("sposid", sAAllianceAdParams.getPosId());
        this.c.put("count", Integer.valueOf(sAAllianceAdParams.getAdCount()));
        String strA2 = "";
        this.c.put(e.a, "" + sAAllianceAdParams.getSid());
        this.c.put("sectionid", "" + sAAllianceAdParams.getSectionid());
        this.c.put("loadtype", Integer.valueOf(this.h));
        this.c.put("adHeight", "" + sAAllianceAdParams.getImageAcceptedHeight());
        this.c.put("adWidth", "" + sAAllianceAdParams.getImageAcceptedWidth());
        InitConfigManager initConfigManager = InitConfigManager.g;
        SharedPreferences sharedPreferences2 = initConfigManager.c.getSharedPreferences("adalliancesdk", 0);
        initConfigManager.a = sharedPreferences2;
        initConfigManager.b = sharedPreferences2.edit();
        try {
            if (i.a(initConfigManager.a.getLong("yt_sdk_2_last_get_list_time", 0L)) || (((initConfigBean = initConfigManager.d) != null || initConfigManager.e) && (initConfigBean == null || initConfigBean.getB() == null || initConfigManager.d.getB().intValue() != 1))) {
                strA = null;
            } else {
                initConfigManager.e = true;
                strA = DeviceInfoManager.b(initConfigManager.c);
                initConfigManager.b.putLong("yt_sdk_2_last_get_list_time", System.currentTimeMillis());
                initConfigManager.b.apply();
            }
            if (InitConfigManager.a(strA)) {
                initConfigManager.b.putString("yt_sdk_2_content_list", InitConfigManager.b(strA)).commit();
                initConfigManager.c(strA);
            } else {
                strA = InitConfigManager.a(initConfigManager.a.getString("yt_sdk_2_content_list", ""));
            }
        } catch (Exception e) {
            InitConfigManager.a("001", e);
            strA = "";
        }
        if (!InitConfigManager.a(strA) && (sharedPreferences = initConfigManager.a) != null) {
            strA2 = InitConfigManager.a(sharedPreferences.getString("yt_sdk_2_intersection_list", ""));
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                InitConfigBean initConfigBean2 = initConfigManager.d;
                List<String> a = (initConfigBean2 == null || !InitConfigManager.a((List<String>[]) new List[]{initConfigBean2.getA()})) ? InitConfigManager.f : initConfigManager.d.getA();
                if (InitConfigManager.a(strA) && InitConfigManager.a((List<String>[]) new List[]{a})) {
                    for (String str : a) {
                        if (strA.contains(str)) {
                            arrayList.add(str);
                        }
                    }
                    if (InitConfigManager.a((List<String>[]) new List[]{arrayList})) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < arrayList.size(); i++) {
                            sb.append((String) arrayList.get(i));
                            if (i != arrayList.size() - 1) {
                                sb.append(",");
                            }
                        }
                        String string = sb.toString();
                        initConfigManager.b.putString("yt_sdk_2_intersection_list", InitConfigManager.b(string));
                        initConfigManager.b.apply();
                        strA2 = string;
                    }
                } else {
                    strA2 = InitConfigManager.a(initConfigManager.a.getString("yt_sdk_2_intersection_list", ""));
                }
            } catch (Exception e2) {
                InitConfigManager.a("001", e2);
            }
        }
        this.c.put("appList", strA2);
        this.c.put("spostype", Integer.valueOf(sAAllianceAdParams.getSpostype()));
        this.c.put(JumpParam.USER_ID, (sAAllianceAdParams.getUserId() == null || sAAllianceAdParams.getUserId().isEmpty()) ? f.B : sAAllianceAdParams.getUserId());
    }

    @Override // com.alliance.ssp.ad.q.b
    public Object a(String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        String strA;
        SAAllianceEngineData sAAllianceEngineData;
        System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            strA = com.alliance.ssp.ad.o.e.a(jSONObject.getString("cipher"), jSONObject.getString("encryptParams"));
        } catch (Exception e) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("SAAllianceEngineAction 002: ")), e);
            strA = "";
        }
        try {
            sAAllianceEngineData = (SAAllianceEngineData) new Gson().fromJson(strA, new c(this).getType());
        } catch (Exception e2) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("SAAllianceEngineAction 001: ")), e2);
            sAAllianceEngineData = null;
        }
        System.currentTimeMillis();
        if (sAAllianceEngineData == null) {
            return null;
        }
        List<SAAllianceAdData> data = sAAllianceEngineData.getData();
        if (data != null) {
            data.isEmpty();
        }
        return sAAllianceEngineData;
    }

    public b(SAAllianceAdParams sAAllianceAdParams, String str, int i, int i2, com.alliance.ssp.ad.p.a<SAAllianceEngineData> aVar, BaseNetAction.Method method) throws JSONException, PackageManager.NameNotFoundException, IOException {
        super(aVar, method, 3000);
        this.f = "https://de.ad.gameley.com/delivery/request/getad/adn";
        this.h = -1;
        this.g = str;
        sAAllianceAdParams.getPosId();
        this.h = i2;
        sAAllianceAdParams.getBidFloor();
        a((Map<String, Object>) a(sAAllianceAdParams));
        b(sAAllianceAdParams);
    }
}
