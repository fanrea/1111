package com.kwad.sdk.core.f;

import android.content.Context;
import android.util.Log;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    public static String doSign(Context context, String str) {
        return b.doSign(context, str);
    }

    public static void handlePolicy(JSONObject jSONObject) {
        b.handlePolicy(jSONObject);
    }

    public static void a(Context context, final a aVar) {
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.sdk.core.f.c.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.aw(str2);
                }
                Log.d("KsSecSDKWrapper", "initGId onSuccessdeviceInfo：" + str2);
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i, String str) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onFailed(i, str);
                }
                Log.e("KsSecSDKWrapper", "initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }
        });
    }

    public static boolean setEgid(Context context, String str) {
        return KWEGIDDFP.instance().setEgid(context, str);
    }
}
