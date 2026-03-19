package com.bytedance.sdk.djx.core.api.rsp;

import com.bytedance.sdk.djx.net.api.BaseDjxRsp;
import com.bytedance.sdk.djx.utils.JSON;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SearchWordsRsp extends BaseDjxRsp<JSONObject> {
    public List<String> getWords() {
        JSONArray jsonArray;
        ArrayList arrayList = new ArrayList();
        if (getData() != null && (jsonArray = JSON.getJsonArray(getData(), "words")) != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    arrayList.add(jsonArray.getString(i));
                } catch (JSONException unused) {
                }
            }
        }
        return arrayList;
    }

    public List<String> getUrls() {
        JSONArray jsonArray;
        ArrayList arrayList = new ArrayList();
        if (getData() != null && (jsonArray = JSON.getJsonArray(getData(), "urls")) != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    arrayList.add(jsonArray.getString(i));
                } catch (JSONException unused) {
                }
            }
        }
        return arrayList;
    }
}
