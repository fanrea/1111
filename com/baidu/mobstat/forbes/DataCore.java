package com.baidu.mobstat.forbes;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.StatService;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class DataCore {
    private static JSONObject a = new JSONObject();
    private static String b = "";
    private static DataCore c = new DataCore();
    private StatService.WearListener i;
    private JSONObject j;
    private JSONArray d = new JSONArray();
    private JSONArray e = new JSONArray();
    private JSONArray f = new JSONArray();
    private boolean g = false;
    private volatile int h = 0;
    private Object k = new Object();
    private boolean l = false;
    private HashMap<String, String> m = new HashMap<>();
    private List<String> n = Collections.synchronizedList(new ArrayList());
    private JSONObject o = new JSONObject();

    public static DataCore instance() {
        return c;
    }

    private DataCore() {
    }

    public void init(Context context) {
        instance().loadWifiData(context);
        instance().loadStatData(context);
        instance().loadLastSession(context);
        instance().installHeader(context);
    }

    public void updatePyd(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            b = str;
            q.a().a(str);
        } catch (Exception e) {
        }
    }

    public void loadProperty(Context context) {
        String strS = al.a().s(context);
        if (!TextUtils.isEmpty(strS)) {
            HashMap map = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(strS);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArray = (JSONArray) jSONObject.get(next);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        map.put(next, jSONArray.optString(0));
                    }
                }
            } catch (Exception e) {
            }
            if (map.size() > 0) {
                setPydProperty(context, as.a(map), "1", "1");
            }
        }
        String strO = al.a().o(context);
        if (!TextUtils.isEmpty(strO)) {
            HashMap map2 = new HashMap();
            map2.put("uid_", strO);
            setPydProperty(context, as.a(map2), "1", "0");
        }
    }

    public int getCacheFileSzie() {
        return this.h;
    }

    public JSONObject getLogData() {
        return this.j;
    }

    public void putSession(Session session) {
        putSession(session.constructJSONObject());
    }

    public void putSession(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (a(jSONObject.toString())) {
            v.c().b("[WARNING] data to put exceed limit, ignored");
            return;
        }
        synchronized (this.d) {
            try {
                this.d.put(this.d.length(), jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void putSession(String str) {
        if (TextUtils.isEmpty(str) || str.equals(new JSONObject().toString())) {
            return;
        }
        try {
            putSession(new JSONObject(str));
        } catch (JSONException e) {
        }
    }

    private boolean a(String str) {
        return (str.getBytes().length + BDStatCore.instance().getSessionSize()) + this.h > 184320;
    }

    public void putEvent(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (a(jSONObject.toString())) {
            v.c().b("[WARNING] data to put exceed limit, ignored");
            return;
        }
        synchronized (this.e) {
            EventAnalysis.doEventMerge(this.e, jSONObject);
        }
    }

    public void installHeader(Context context) {
        synchronized (a) {
            CooperService.instance().getHeadObject().installHeader(context, a);
        }
    }

    public void flush(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            synchronized (this.d) {
                jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.d.toString()));
            }
            synchronized (this.e) {
                jSONObject.put(Config.EVENT_PART, new JSONArray(this.e.toString()));
            }
            synchronized (a) {
                jSONObject.put(Config.HEADER_PART, new JSONObject(a.toString()));
            }
            jSONObject.put(Config.PYD, b);
        } catch (Exception e) {
        }
        String string = jSONObject.toString();
        if (a()) {
            v.c().a("[WARNING] stat cache exceed 184320 Bytes, ignored");
            return;
        }
        int length = string.getBytes().length;
        if (length >= 184320) {
            a(true);
            return;
        }
        this.h = length;
        aj.a(context, ar.l(context) + Config.STAT_CACHE_FILE_NAME, string, false);
        synchronized (this.f) {
            aj.a(context, Config.LAST_AP_INFO_FILE_NAME, this.f.toString(), false);
        }
    }

    private void a(boolean z) {
        this.g = z;
    }

    private boolean a() {
        return this.g;
    }

    public void loadLastSession(Context context) {
        if (context == null) {
            return;
        }
        String str = ar.l(context) + Config.LAST_SESSION_FILE_NAME;
        if (!aj.c(context, str)) {
            return;
        }
        String strA = aj.a(context, str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        aj.a(context, str, new JSONObject().toString(), false);
        putSession(strA);
        flush(context);
    }

    public void loadWifiData(Context context) {
        if (context == null || !aj.c(context, Config.LAST_AP_INFO_FILE_NAME)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(aj.a(context, Config.LAST_AP_INFO_FILE_NAME));
            int length = jSONArray.length();
            if (length >= 10) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i = length - 10; i < length; i++) {
                    jSONArray2.put(jSONArray.get(i));
                }
                jSONArray = jSONArray2;
            }
            String strL = ar.l(2, context);
            if (!TextUtils.isEmpty(strL)) {
                jSONArray.put(strL);
            }
            synchronized (this.f) {
                this.f = jSONArray;
            }
        } catch (JSONException e) {
        }
    }

    public void loadStatData(Context context) throws JSONException {
        JSONObject jSONObject;
        if (context == null) {
            return;
        }
        String str = ar.l(context) + Config.STAT_CACHE_FILE_NAME;
        if (!aj.c(context, str)) {
            return;
        }
        String strA = aj.a(context, str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            jSONObject = new JSONObject(strA);
        } catch (Exception e) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jCurrentTimeMillis - jSONObject2.getLong("s") <= 604800000) {
                        putSession(jSONObject2);
                    }
                }
            }
        } catch (Exception e2) {
        }
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray(Config.EVENT_PART);
            if (jSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    if (jCurrentTimeMillis - jSONObject3.getLong("t") <= 604800000) {
                        putEvent(context, jSONObject3);
                    }
                }
            }
        } catch (Exception e3) {
        }
        try {
            JSONObject jSONObject4 = jSONObject.getJSONObject(Config.HEADER_PART);
            if (jSONObject4 != null) {
                synchronized (a) {
                    a = jSONObject4;
                }
            }
        } catch (Exception e4) {
        }
        try {
            String strOptString = jSONObject.optString(Config.PYD);
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = "";
            }
            b = strOptString;
        } catch (Exception e5) {
        }
    }

    public String constructLogWithEmptyBody(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        HeadObject headObject = CooperService.instance().getHeadObject();
        if (TextUtils.isEmpty(headObject.e)) {
            headObject.installHeader(context, jSONObject2);
        } else {
            headObject.updateHeader(context, jSONObject2);
        }
        JSONArray jSONArray = new JSONArray();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject2.put("t", jCurrentTimeMillis);
            jSONObject2.put("ss", jCurrentTimeMillis);
            jSONObject2.put(Config.WIFI_LOCATION, jSONArray);
            jSONObject2.put(Config.SEQUENCE_INDEX, 0);
            jSONObject2.put("sign", CooperService.instance().getUUID());
            jSONObject2.put("k", str);
            jSONObject.put(Config.HEADER_PART, jSONObject2);
            try {
                jSONObject.put(Config.PRINCIPAL_PART, jSONArray);
                try {
                    jSONObject.put(Config.EVENT_PART, jSONArray);
                    try {
                        jSONObject.put(Config.EXCEPTION_PART, jSONArray);
                        return jSONObject.toString();
                    } catch (JSONException e) {
                        return null;
                    }
                } catch (JSONException e2) {
                    return null;
                }
            } catch (JSONException e3) {
                return null;
            }
        } catch (Exception e4) {
            return null;
        }
    }

    private void a(Context context, JSONObject jSONObject, boolean z) {
    }

    public void saveLogDataAndSendForRaven(Context context) {
        synchronized (this.k) {
        }
    }

    public void sendDataForDueros(Context context) {
        if (this.d.length() > 0 || this.e.length() > 0) {
            saveLogData(context, false, false, BDStatCore.instance().getSessionStartTime(), false);
        }
        p.a(context, false);
        LogSender.instance().onSend(context);
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3) {
        saveLogData(context, z, z2, j, z3, null);
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3, JSONObject jSONObject) {
        HeadObject headObject = CooperService.instance().getHeadObject();
        if (headObject != null) {
            synchronized (a) {
                if (TextUtils.isEmpty(headObject.e)) {
                    headObject.installHeader(context, a);
                } else {
                    headObject.updateHeader(context, a);
                }
            }
            if (TextUtils.isEmpty(headObject.e)) {
                v.c().c("[WARNING] 无法找到有效APP Key, 请参考文档配置");
                return;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        synchronized (a) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                String strOptString = a.optString("at");
                String strOptString2 = a.optString(Config.CUSTOM_USER_ID);
                if (!TextUtils.isEmpty(strOptString) && strOptString.equals("0")) {
                    if (!strOptString2.equals(CooperService.instance().getLastUserId(context))) {
                        a.put(Config.UID_CHANGE, strOptString2);
                    } else {
                        a.put(Config.UID_CHANGE, "");
                    }
                    CooperService.instance().setLastUserId(context, strOptString2);
                }
                a.put("t", jCurrentTimeMillis);
                a.put(Config.SEQUENCE_INDEX, z ? 0 : 1);
                a.put("ss", j);
                synchronized (this.f) {
                    a.put(Config.WIFI_LOCATION, this.f);
                }
                a.put("sign", CooperService.instance().getUUID());
                a(context, a, jSONObject);
                jSONObject2.put(Config.HEADER_PART, a);
                synchronized (this.d) {
                    try {
                        try {
                            jSONObject2.put(Config.PRINCIPAL_PART, this.d);
                            synchronized (this.e) {
                                try {
                                    jSONObject2.put(Config.EVENT_PART, this.e);
                                    try {
                                        jSONObject2.put(Config.EXCEPTION_PART, new JSONArray());
                                        try {
                                            jSONObject2.put(Config.PYD, b);
                                            a(context, jSONObject2, z2);
                                            a(jSONObject2);
                                            a(context, jSONObject2);
                                            a(context, jSONObject2.toString(), z, z3);
                                            this.j = jSONObject2;
                                            clearCache(context);
                                            if (!this.l) {
                                                this.l = true;
                                                updatePyd("");
                                                loadProperty(context);
                                                updatePyd(getTempPyd());
                                            }
                                        } catch (JSONException e) {
                                        }
                                    } catch (JSONException e2) {
                                    }
                                } catch (JSONException e3) {
                                }
                            }
                        } catch (JSONException e4) {
                        }
                    } finally {
                    }
                }
            } catch (Exception e5) {
            }
        }
    }

    private void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject.length() == 0 || jSONObject2 == null || jSONObject2.length() == 0) {
            return;
        }
        try {
            jSONObject.put(Config.LAUNCH, jSONObject2);
        } catch (Exception e) {
        }
    }

    private void a(JSONObject jSONObject) {
    }

    private void a(Context context, JSONObject jSONObject) {
    }

    private void a(Context context, String str, boolean z, boolean z2) throws JSONException {
        if (this.i != null && this.i.onSendLogData(str)) {
            v.c().a("Log has been passed to app level, log: " + str);
            return;
        }
        boolean z3 = false;
        LogSender.instance().saveLogData(context, str, false);
        v.c().a("Save log: " + str);
        if (z) {
            p.a(context);
            return;
        }
        if (q.a().b() == 0 && q.a().c()) {
            z3 = true;
        }
        p.a(context, z3);
    }

    public void clearCache(Context context) throws JSONException {
        a(false);
        String strOptString = "";
        if (a != null) {
            strOptString = a.optString(Config.DEVICE_ID_SEC);
        }
        if (!TextUtils.isEmpty(strOptString)) {
            al.a().i(context, strOptString);
        }
        synchronized (a) {
            a = new JSONObject();
        }
        installHeader(context);
        try {
            a.put(Config.CUID_SEC, "");
            a.put(Config.OTHER_ID, "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(context);
    }

    private void a(Context context) {
        synchronized (this.e) {
            this.e = new JSONArray();
        }
        synchronized (this.d) {
            this.d = new JSONArray();
        }
        synchronized (this.f) {
            this.f = new JSONArray();
        }
        flush(context);
    }

    void a(StatService.WearListener wearListener) {
        this.i = wearListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setPydProperty(android.content.Context r27, java.util.Map<java.lang.String, java.lang.String> r28, java.lang.String r29, java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 647
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.DataCore.setPydProperty(android.content.Context, java.util.Map, java.lang.String, java.lang.String):void");
    }

    public void clearProperty(String str) {
        if (str.equals("0")) {
            this.m.put(Config.UID_PY, "");
            return;
        }
        if (str.equals("1")) {
            this.m.put(Config.USER_PY, "");
            return;
        }
        if (str.equals("2")) {
            this.m.put(Config.SESSION_PY, "");
            this.m.put(Config.SESSION_JSON_PY, "");
        } else if (str.equals("3")) {
            this.m.put(Config.EVENT_PY, "");
        } else if (str.equals("4")) {
            this.m.put(Config.PAGE_PY, "");
        }
    }

    public void updatePropertyKey(String str, StringBuffer stringBuffer, String str2, int i) {
        if (i >= 0 && str.equals(str2)) {
            if (!TextUtils.isEmpty(stringBuffer)) {
                stringBuffer.append(Config.replace);
            }
            stringBuffer.append(i);
        }
    }

    public String getTempPyd() {
        return (this.o == null || this.o.length() <= 0) ? "" : this.o.toString();
    }

    public String getHeadSessionPy() {
        String str = this.m.get(Config.SESSION_JSON_PY);
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public String getSessionPy() {
        String str = this.m.get(Config.SESSION_PY);
        String str2 = this.m.get(Config.USER_PY);
        String str3 = this.m.get(Config.UID_PY);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return replace(replace(str + Config.replace + str3, Config.replace) + Config.replace + str2, Config.replace);
    }

    public String getPagePy() {
        String str = this.m.get(Config.PAGE_PY);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return replace(getSessionPy() + Config.replace + str, Config.replace);
    }

    public String getEventPy() {
        String str = this.m.get(Config.EVENT_PY);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return replace(getSessionPy() + Config.replace + str, Config.replace);
    }

    public String replace(String str, String str2) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(str2)) {
            str = str.replaceFirst(str2, "");
        }
        if (str.endsWith(str2)) {
            str = str.substring(0, str.length() - 1);
        }
        str = str.replace(ILogConst.CACHE_PLAY_REASON_NULL, "");
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
