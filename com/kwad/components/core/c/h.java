package com.kwad.components.core.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h implements i, Comparable<h> {
    private final String PD;
    private final String PE;
    private final String PF;
    private final long PG;
    private final String Pu;
    private final long createTime;
    private final int ecpm;

    private h(String str, String str2, String str3, int i, String str4, long j, long j2) {
        this.PD = str;
        this.Pu = str2;
        this.PE = str3;
        this.ecpm = i;
        this.PF = str4;
        this.createTime = j;
        this.PG = j2;
    }

    public static List<h> a(e eVar, AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jOr = (jCurrentTimeMillis / 1000) + eVar.or();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            arrayList.add(new h(String.valueOf(com.kwad.sdk.core.response.b.e.eV(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.b.e.eZ(next), adResultData.getDefaultAdScene().toJson().toString(), jCurrentTimeMillis + size, jOr));
            size--;
            it = it;
            defaultAdScene = defaultAdScene;
        }
        return arrayList;
    }

    public static List<h> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return arrayList;
    }

    private static synchronized h c(Cursor cursor) {
        return new h(cursor.getString(cursor.getColumnIndex("creativeId")), cursor.getString(cursor.getColumnIndex("posId")), cursor.getString(cursor.getColumnIndex("adJson")), cursor.getInt(cursor.getColumnIndex(SplashAd.KEY_BIDFAIL_ECPM)), cursor.getString(cursor.getColumnIndex("adSenseJson")), cursor.getLong(cursor.getColumnIndex("createTime")), cursor.getLong(cursor.getColumnIndex("expireTime")));
    }

    public static AdResultData m(List<h> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultDataC = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<h> it = list.iterator();
        SceneImpl defaultAdScene = null;
        while (it.hasNext()) {
            adResultDataC = c(it.next());
            if (adResultDataC != null) {
                if (defaultAdScene == null) {
                    defaultAdScene = adResultDataC.getDefaultAdScene();
                }
                arrayList.addAll(adResultDataC.getProceedTemplateList());
            }
        }
        AdResultData adResultData = new AdResultData(adResultDataC, defaultAdScene, arrayList);
        adResultData.setAdSource("cache");
        return adResultData;
    }

    private static AdResultData c(h hVar) {
        if (hVar == null) {
            return null;
        }
        if (hVar.ov() == null || hVar.oz() == null) {
            com.kwad.sdk.core.d.c.w("CachedAd", "createAdResultData cachedAd data illegal");
            return null;
        }
        try {
            String strOz = hVar.oz();
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(strOz));
            AdResultData adResultDataCreateFromResponseJson = AdResultData.createFromResponseJson(hVar.ov(), sceneImpl);
            Iterator<AdTemplate> it = adResultDataCreateFromResponseJson.getProceedTemplateList().iterator();
            while (it.hasNext()) {
                it.next().fromCache = true;
            }
            return adResultDataCreateFromResponseJson;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public final String oo() {
        return this.Pu;
    }

    private String ov() {
        return this.PE;
    }

    private int ow() {
        return this.ecpm;
    }

    private long ox() {
        return this.createTime;
    }

    public final long oy() {
        return this.PG;
    }

    private String oz() {
        return this.PF;
    }

    public final String oA() {
        return this.PD;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues os() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.PD);
        contentValues.put("posId", this.Pu);
        contentValues.put("adJson", this.PE);
        contentValues.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.PF);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.PG));
        contentValues.put("playAgainJson", (String) null);
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        if (hVar.ow() == ow()) {
            return (int) (hVar.ox() - ox());
        }
        return hVar.ow() - ow();
    }
}
