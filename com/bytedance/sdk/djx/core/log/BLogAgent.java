package com.bytedance.sdk.djx.core.log;

import android.text.TextUtils;
import com.bytedance.sdk.djx.net.log.ILogReplace;
import com.bytedance.sdk.djx.net.log.Upload4AppLog;
import com.bytedance.sdk.djx.utils.JSON;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class BLogAgent {
    public static final String MODE_MINI_STORY = "mini_story";
    public static final String MODE_PLAYLET = "playlet";
    public static final String PARAM_END_TYPE = "end_type";
    public static final String VALUE_END_TYPE_INSIDE = "inside";
    public static final String VALUE_END_TYPE_OUTSIDE = "outside";
    private final String mCategory;
    private final Map<String, Object> mCommonParams;
    private final String mEventName;
    private List<ILogReplace> mLogReplaces;
    private String mMode;
    private final JSONObject mParams;

    public static BLogAgent build(String str, String str2, Map<String, Object> map) {
        return new BLogAgent(str, str2, map);
    }

    public static BLogAgent build(String str, String str2, Map<String, Object> map, String str3) {
        return new BLogAgent(str, str2, map, str3);
    }

    private BLogAgent(String str, String str2, Map<String, Object> map, String str3) {
        this.mParams = new JSONObject();
        this.mCategory = str;
        this.mEventName = str2;
        this.mCommonParams = map;
        this.mMode = str3;
    }

    private BLogAgent(String str, String str2, Map<String, Object> map) {
        this.mParams = new JSONObject();
        this.mMode = "";
        this.mCategory = str;
        this.mEventName = str2;
        this.mCommonParams = map;
    }

    public BLogAgent addReplace(ILogReplace... iLogReplaceArr) {
        if (iLogReplaceArr != null) {
            try {
                if (iLogReplaceArr.length > 0) {
                    if (this.mLogReplaces == null) {
                        this.mLogReplaces = new ArrayList();
                    }
                    Collections.addAll(this.mLogReplaces, iLogReplaceArr);
                }
            } catch (Throwable unused) {
            }
        }
        return this;
    }

    public BLogAgent putString(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSON.putObject(this.mParams, str, str2);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public BLogAgent putLong(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSON.putLong(this.mParams, str, j);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public BLogAgent putInt(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSON.putInt(this.mParams, str, i);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public BLogAgent putObject(String str, Object obj) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSON.putObject(this.mParams, str, obj);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public BLogAgent putAll(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        putObject(next, JSON.getObject(jSONObject, next));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return this;
    }

    public void send() {
        injectCommonParams();
        Upload4AppLog.DEFAULT.send(this.mEventName, this.mCategory, this.mParams, this.mLogReplaces);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void injectCommonParams() {
        /*
            r3 = this;
            java.lang.String r0 = "sdk_version"
            java.lang.String r1 = "2.9.0.2"
            r3.putString(r0, r1)
            java.lang.String r0 = r3.mCategory
            java.lang.String r1 = "category"
            r3.putString(r1, r0)
            java.lang.String r0 = com.bytedance.sdk.djx.core.DevInfo.sSiteId
            java.lang.String r1 = "site_id"
            r3.putString(r1, r0)
            java.lang.String r0 = r3.mMode
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L24
            java.lang.String r0 = r3.mMode
            java.lang.String r1 = "mode"
            r3.putString(r1, r0)
        L24:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r3.mCommonParams
            r3.parseCommonParams(r0)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r3.mCommonParams
            java.lang.String r1 = "end_type"
            if (r0 == 0) goto L3a
            java.lang.Object r0 = r0.get(r1)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L3a
            java.lang.String r0 = (java.lang.String) r0
            goto L3c
        L3a:
            java.lang.String r0 = "inside"
        L3c:
            r3.putString(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.log.BLogAgent.injectCommonParams():void");
    }

    private void parseCommonParams(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj != null) {
                try {
                    if (obj instanceof Integer) {
                        putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        putString(str, (String) obj);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
