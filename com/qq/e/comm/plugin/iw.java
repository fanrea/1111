package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.constants.ErrorCode;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class iw {
    private static volatile HashSet<Integer> a;

    public static b a(JSONObject jSONObject, String str, f5 f5Var, boolean z) {
        int length;
        int iOptInt = jSONObject.optInt("ret");
        if (iOptInt != 0) {
            go.a(f5Var, iOptInt, z);
            return new b(a(iOptInt), 2001);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        int i = 5004;
        if (jSONObjectOptJSONObject == null) {
            go.a(f5Var, 5004, z);
            return new b(i, 2002);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject2 == null) {
            go.a(f5Var, 5004, z);
            return new b(i, 2003);
        }
        int iOptInt2 = jSONObjectOptJSONObject2.optInt("ret");
        if (iOptInt2 != 0) {
            go.a(f5Var, iOptInt2, z);
            return new b(a(iOptInt2), 2004);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("list");
        if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
            go.a(f5Var, length);
            int i2 = 2000;
            return new b(jSONArrayOptJSONArray, i2, i2);
        }
        go.a(f5Var, ErrorCode.NO_AD_FILL_FOR_LIST_EMPTY, z);
        return new b(i, 2005);
    }

    public static int a(int i) {
        if (a == null) {
            synchronized (iw.class) {
                if (a == null) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    String strB = r1.d().f().b("errcodel", "100001,100004,100005,100133,102006,107009,107011,107030,107035,107041,107047,107050,109502,109512,132005,132007,132008");
                    if (!TextUtils.isEmpty(strB)) {
                        String[] strArrSplit = strB.split(",");
                        if (strArrSplit != null) {
                            for (String str : strArrSplit) {
                                try {
                                    hashSet.add(Integer.valueOf(Integer.parseInt(str)));
                                } catch (Exception unused) {
                                }
                            }
                        }
                        a = hashSet;
                    }
                }
            }
        }
        if (a.contains(Integer.valueOf(i))) {
            return i;
        }
        return 5004;
    }

    /* compiled from: A */
    public static class b {
        public final JSONArray a;
        public final int b;
        public final int c;

        private b(int i, int i2) {
            this((JSONArray) null, i, i2);
        }

        private b(JSONArray jSONArray, int i, int i2) {
            this.a = jSONArray;
            this.b = i;
            this.c = i2;
        }
    }
}
