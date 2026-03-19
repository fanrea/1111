package com.tkruntime.v8.env;

import android.text.TextUtils;
import com.tkruntime.v8.V8;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class DynamicEnv {
    private static volatile DynamicEnv sInstance;

    public static DynamicEnv getInstance() {
        if (sInstance == null) {
            synchronized (DynamicEnv.class) {
                if (sInstance == null) {
                    sInstance = new DynamicEnv();
                }
            }
        }
        return sInstance;
    }

    public void update(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        V8._updateDynamicEnv(str, obj);
    }

    public void update(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        Object[] objArr = new Object[map.size() * 2];
        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            int i2 = i + 1;
            objArr[i] = entry.getKey();
            i = i2 + 1;
            objArr[i2] = entry.getValue();
        }
        V8._updateDynamicEnvs(objArr, objArr.length);
    }
}
