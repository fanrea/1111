package com.bytedance.sdk.djx.core.log.replaceimpl;

import android.text.TextUtils;
import com.bytedance.sdk.djx.net.log.ILogReplace;
import com.bytedance.sdk.djx.utils.JSON;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ApiUserReplace implements ILogReplace {
    private final String mFromUID;
    private int mFromUT;

    public static ApiUserReplace obtain(String str, int i) {
        return new ApiUserReplace(str, i);
    }

    private ApiUserReplace(String str, int i) {
        this.mFromUID = str;
        this.mFromUT = i;
    }

    @Override // com.bytedance.sdk.djx.net.log.ILogReplace
    public JSONObject onReplace(JSONObject jSONObject) {
        if (jSONObject != null && !TextUtils.isEmpty(this.mFromUID) && this.mFromUT >= 0) {
            String string = JSON.getString(jSONObject, "user_id");
            JSON.getInt(jSONObject, "user_type");
            JSON.getString(jSONObject, "user_unique_id");
            String str = String.format(Locale.getDefault(), "%s_%s", Integer.valueOf(this.mFromUT), this.mFromUID);
            JSON.putObject(jSONObject, "user_id", this.mFromUID);
            JSON.putInt(jSONObject, "user_type", this.mFromUT);
            JSON.putObject(jSONObject, "user_unique_id", str);
            JSON.putObject(jSONObject, "sdk_user_id", string);
        }
        return jSONObject;
    }
}
