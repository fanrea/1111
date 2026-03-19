package com.kwad.components.ct.response.model;

import com.kwad.components.ct.response.model.a.a;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CtAdResultData extends AdResultData {
    private static final long serialVersionUID = 511087008941800595L;
    public a entryInfo;
    private List<CtAdTemplate> mCtAdTemplateList;
    public TubeInfo tubeInfo;

    public CtAdResultData() {
        this.mCtAdTemplateList = new ArrayList();
    }

    public CtAdResultData(SceneImpl sceneImpl) {
        super(sceneImpl);
        this.mCtAdTemplateList = new ArrayList();
    }

    public CtAdResultData(List<SceneImpl> list) {
        super(list);
        this.mCtAdTemplateList = new ArrayList();
    }

    @Override // com.kwad.sdk.core.response.model.AdResultData, com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        setCtAdTemplateListByAd(super.getAdTemplateList());
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("entryInfo");
            if (jSONObjectOptJSONObject == null) {
                String strOptString = jSONObject.optString("entryInfo");
                if (!bq.isNullString(strOptString)) {
                    d.g(DevelopMangerComponents.class);
                    String strReplaceAll = com.kwad.sdk.core.a.d.getResponseData(strOptString).replaceAll("\\\\", "");
                    jSONObjectOptJSONObject = new JSONObject(strReplaceAll.substring(1, strReplaceAll.length() - 1));
                }
            }
            if (jSONObjectOptJSONObject != null) {
                a aVar = new a();
                this.entryInfo = aVar;
                aVar.parseJson(jSONObjectOptJSONObject);
                this.entryInfo.aVj = getCtAdTemplateList();
            }
        } catch (Exception e) {
            c.printStackTrace(e);
        }
        try {
            String strOptString2 = jSONObject.optString("tubeInfo");
            if (bq.isNullString(strOptString2)) {
                return;
            }
            this.tubeInfo.parseJson(new JSONObject(com.kwad.sdk.core.a.d.getResponseData(strOptString2)));
        } catch (Exception e2) {
            c.d("json bug", e2.toString());
            c.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.model.AdResultData, com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.a(json, "entryInfo", this.entryInfo);
        aa.a(json, "tubeInfo", this.tubeInfo);
        return json;
    }

    @Override // com.kwad.sdk.core.response.model.AdResultData
    public String getResponseJson() {
        if (this.mOriginalJson != null) {
            return this.mOriginalJson;
        }
        return toJson().toString();
    }

    public List<CtAdTemplate> getCtAdTemplateList() {
        return this.mCtAdTemplateList;
    }

    public void setCtAdTemplateList(List<CtAdTemplate> list) {
        this.mCtAdTemplateList = list;
    }

    public void setCtAdTemplateListByAd(List<AdTemplate> list) {
        if (this.mCtAdTemplateList == null) {
            this.mCtAdTemplateList = new ArrayList();
        }
        this.mCtAdTemplateList.clear();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            this.mCtAdTemplateList.add(new CtAdTemplate(it.next()));
        }
    }

    @Override // com.kwad.sdk.core.response.model.AdResultData
    public List<AdTemplate> getAdTemplateList() {
        List<CtAdTemplate> ctAdTemplateList = getCtAdTemplateList();
        if (ctAdTemplateList == null || ctAdTemplateList.isEmpty()) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(ctAdTemplateList.size());
        arrayList.addAll(ctAdTemplateList);
        return arrayList;
    }

    @Override // com.kwad.sdk.core.response.model.AdResultData
    public void setAdTemplateList(List<AdTemplate> list) {
        super.setAdTemplateList(list);
        setCtAdTemplateListByAd(super.getAdTemplateList());
    }
}
