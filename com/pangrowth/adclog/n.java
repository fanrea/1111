package com.pangrowth.adclog;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class n implements k {
    @Override // com.pangrowth.adclog.k
    public String a(Object obj) {
        String str = (String) obj;
        if (str == null || str.trim().length() == 0) {
            throw new j("JSON empty.");
        }
        try {
            if (str.startsWith("{")) {
                return new JSONObject(str).toString(4);
            }
            if (str.startsWith("[")) {
                return new JSONArray(str).toString(4);
            }
            throw new j("JSON should start with { or [, but found " + str);
        } catch (Exception e) {
            throw new j("Parse JSON error. JSON string:" + str, e);
        }
    }
}
