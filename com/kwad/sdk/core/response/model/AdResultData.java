package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bq;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final String TAG = "AdResultData";
    private static final long serialVersionUID = -818939163644825380L;
    public AdGlobalConfigInfo adGlobalConfigInfo;
    public boolean hasMore;
    public int mAdCacheId;
    private String mAdSource;
    private List<AdTemplate> mAdTemplateList;
    protected String mOriginalJson;
    private Map<Long, SceneImpl> mRequestAdSceneMap;
    private SceneImpl mScene;
    public PageInfo pageInfo;
    public String pcursor;

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    public static AdResultData createFromResponseJson(String str, SceneImpl sceneImpl) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(sceneImpl);
        adResultData.parseJson(jSONObject);
        adResultData.mOriginalJson = str;
        return adResultData;
    }

    public AdResultData() {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
    }

    public AdResultData(SceneImpl sceneImpl) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        this.mScene = sceneImpl;
        if (sceneImpl != null) {
            HashMap map = new HashMap(1);
            this.mRequestAdSceneMap = map;
            map.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
        }
    }

    public AdResultData(BaseResultData baseResultData, SceneImpl sceneImpl, List<AdTemplate> list) {
        this(sceneImpl);
        if (baseResultData == null) {
            return;
        }
        super.parseJson(baseResultData.baseToJson());
        if (list != null) {
            getAdTemplateList().addAll(list);
        }
    }

    public AdResultData(List<SceneImpl> list) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        setRequestAdSceneList(list);
    }

    public void setRequestAdSceneList(List<SceneImpl> list) {
        if (list != null) {
            this.mRequestAdSceneMap = new HashMap(list.size());
            for (SceneImpl sceneImpl : list) {
                this.mRequestAdSceneMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
            }
        }
    }

    public List<AdTemplate> getProceedTemplateList() {
        ArrayList arrayList = new ArrayList();
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList == null) {
            return arrayList;
        }
        int size = adTemplateList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(adTemplateList.get(i));
        }
        return arrayList;
    }

    public AdTemplate getFirstAdTemplate() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList == null || adTemplateList.size() == 0) {
            return null;
        }
        return adTemplateList.get(0);
    }

    public boolean isBidding() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        return proceedTemplateList.size() != 0 && e.eZ(proceedTemplateList.get(0)) > 0;
    }

    public SceneImpl getDefaultAdScene() {
        return getAdScene(getPosId());
    }

    public long getPosId() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        if (proceedTemplateList.size() == 0) {
            return 0L;
        }
        return proceedTemplateList.get(0).posId;
    }

    public SceneImpl getAdScene(long j) {
        Map<Long, SceneImpl> map = this.mRequestAdSceneMap;
        SceneImpl sceneImpl = map != null ? map.get(Long.valueOf(j)) : null;
        return sceneImpl == null ? new SceneImpl(j) : sceneImpl;
    }

    public String getAdSource() {
        String str = this.mAdSource;
        return str != null ? str : PointCategory.NETWORK;
    }

    public void setAdSource(String str) {
        this.mAdSource = str;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.pcursor = jSONObject.optString("pcursor");
            this.hasMore = jSONObject.optBoolean("hasMore");
            String strOptString = jSONObject.optString("adGlobalConfigInfo");
            com.kwad.sdk.core.a.e eVar = (com.kwad.sdk.core.a.e) d.g(com.kwad.sdk.core.a.e.class);
            if (!bq.isNullString(strOptString)) {
                String responseData = eVar.getResponseData(strOptString);
                AdGlobalConfigInfo adGlobalConfigInfo = new AdGlobalConfigInfo();
                this.adGlobalConfigInfo = adGlobalConfigInfo;
                adGlobalConfigInfo.parseJson(new JSONObject(responseData));
                ag.c(ServiceProvider.getContext(), this.adGlobalConfigInfo.uaidEnable);
            }
            try {
                String strOptString2 = jSONObject.optString("pageInfo");
                if (!bq.isNullString(strOptString2)) {
                    this.pageInfo.parseJson(new JSONObject(eVar.getResponseData(strOptString2)));
                }
            } catch (Exception e) {
                c.d("json bug", e.toString());
                c.printStackTrace(e);
            }
            String strOptString3 = jSONObject.optString("impAdInfo");
            if (TextUtils.isEmpty(strOptString3)) {
                return;
            }
            String responseData2 = eVar.getResponseData(strOptString3);
            if (bq.isNullString(responseData2)) {
                return;
            }
            JSONArray jSONArray = null;
            try {
                try {
                    jSONArray = new JSONArray(responseData2);
                } catch (Throwable unused) {
                    com.kwad.sdk.commercial.e.a.a(this.mScene, this.llsid, strOptString3, responseData2);
                }
                if (jSONArray == null || jSONArray.length() <= 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        AdTemplate adTemplate = new AdTemplate();
                        adTemplate.parseJson(jSONObjectOptJSONObject);
                        adTemplate.llsid = this.llsid;
                        adTemplate.extra = this.extra;
                        adTemplate.mAdScene = getAdScene(adTemplate.posId);
                        adTemplate.mPageInfo = this.pageInfo;
                        this.mAdTemplateList.add(adTemplate);
                        com.kwad.sdk.commercial.e.a.cb(adTemplate);
                        SceneImpl sceneImpl = this.mScene;
                        if (sceneImpl != null && !styleMatch(sceneImpl, adTemplate)) {
                            int i2 = adTemplate.adStyle;
                            adTemplate.adStyle = this.mScene.adStyle;
                            com.kwad.sdk.commercial.e.a.c(adTemplate, "ad_style", String.valueOf(i2));
                        }
                    }
                }
            } catch (Throwable unused2) {
                com.kwad.sdk.commercial.e.a.a(this.mScene, this.llsid, strOptString3);
            }
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private static boolean styleMatch(SceneImpl sceneImpl, AdTemplate adTemplate) {
        int i = sceneImpl.adStyle;
        int i2 = adTemplate.adStyle;
        return i == 13 ? i2 == 13 || i2 == 23 : i == i2;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, "pcursor", this.pcursor);
        aa.putValue(json, "hasMore", this.hasMore);
        aa.a(json, "pageInfo", this.pageInfo);
        aa.putValue(json, "impAdInfo", getAdTemplateList());
        aa.a(json, "adGlobalConfigInfo", this.adGlobalConfigInfo);
        int i = this.mAdCacheId;
        if (i != 0) {
            aa.putValue(json, "adCacheId", i);
        }
        return json;
    }

    public boolean isAdResultDataEmpty() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList.isEmpty()) {
            c.w(TAG, "adTemplateList is empty");
            return true;
        }
        c.d(TAG, "adTemplateList size = " + adTemplateList.size());
        List<AdInfo> list = adTemplateList.get(0).adInfoList;
        if (list.isEmpty()) {
            c.w(TAG, "adInfoList is empty");
            return true;
        }
        if (list.get(0) != null) {
            return false;
        }
        c.w(TAG, "adInfo is null");
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AdResultData m458clone() {
        AdResultData adResultData = new AdResultData();
        try {
            adResultData.parseJson(toJson());
            return adResultData;
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            return adResultData;
        }
    }

    public String getResponseJson() {
        String str = this.mOriginalJson;
        if (str != null) {
            return str;
        }
        JSONObject json = super.toJson();
        aa.putValue(json, "pcursor", this.pcursor);
        aa.a(json, "pageInfo", this.pageInfo);
        aa.putValue(json, "impAdInfo", ((com.kwad.sdk.core.a.e) d.g(com.kwad.sdk.core.a.e.class)).ax(aa.aL(getAdTemplateList()).toString()));
        return json.toString();
    }

    public List<AdTemplate> getAdTemplateList() {
        return this.mAdTemplateList;
    }

    public void setAdTemplateList(List<AdTemplate> list) {
        this.mAdTemplateList = list;
    }

    public static AdVideoPreCacheConfig obtainVideoPreCacheConfig(AdResultData adResultData, int i) {
        if (adResultData == null) {
            return null;
        }
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.adVideoPreCacheConfig != null) {
            return adResultData.adGlobalConfigInfo.adVideoPreCacheConfig;
        }
        return new AdVideoPreCacheConfig(i, false);
    }
}
