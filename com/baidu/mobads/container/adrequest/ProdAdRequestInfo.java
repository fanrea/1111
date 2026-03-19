package com.baidu.mobads.container.adrequest;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.adrequest.b;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.ah;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ProdAdRequestInfo extends d implements IAdInterListener {
    public static final String AD_SCHEMA = "bdsdk";
    public o adProdTemplate;
    private JSONObject mAllParam;
    private RelativeLayout mRl;

    public ProdAdRequestInfo(Context context) {
        super(context);
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void setAdContainer(RelativeLayout relativeLayout) {
        this.mRl = relativeLayout;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void createProdHandler(JSONObject jSONObject) {
        String str = (String) ah.a(jSONObject, "prod");
        if ("feed".equals(str)) {
            this.mPrefixOfV = "androidfeed";
        }
        if ("jssdk".equals(str)) {
            this.adProdTemplate = new x(this.mCxt, this);
            return;
        }
        if ("rvideo".equals(str) || "fvideo".equals(str)) {
            this.adProdTemplate = new y(this.mCxt, this);
            return;
        }
        if ("cpu".equals(str)) {
            this.adProdTemplate = new com.baidu.mobads.container.nativecpu.j(this.mCxt, this);
            return;
        }
        if (b.e.c.equals(str)) {
            this.adProdTemplate = new e(this.mCxt, this);
        } else if (b.e.b.equals(str)) {
            this.adProdTemplate = new com.baidu.mobads.container.n.f(this.mCxt, this);
        } else {
            this.adProdTemplate = new o(this.mCxt, this);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        if (this.adProdTemplate != null) {
            this.adProdTemplate.addEventListener(str, iOAdEventListener);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void removeAllListeners() {
        if (this.adProdTemplate != null) {
            this.adProdTemplate.removeAllListeners();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void loadAd(JSONObject jSONObject, JSONObject jSONObject2) {
        setRequestParameter(jSONObject, jSONObject2);
        if (this.adProdTemplate != null) {
            this.adProdTemplate.a();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void showAd() {
        if (this.adProdTemplate != null) {
            this.adProdTemplate.p();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public boolean isAdReady() {
        if (this.adProdTemplate == null) {
            return false;
        }
        return this.adProdTemplate.h();
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAttachedToWindow() {
        if (this.adProdTemplate != null) {
            this.adProdTemplate.D();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onDetachedFromWindow() {
        if (this.adProdTemplate != null) {
            this.adProdTemplate.E();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onWindowVisibilityChanged(int i) {
        if (this.adProdTemplate != null) {
            this.adProdTemplate.a(i);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onWindowFocusChanged(boolean z) {
        if (this.adProdTemplate != null) {
            this.adProdTemplate.a(z);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.adProdTemplate != null && this.adProdTemplate.h != null) {
            return this.adProdTemplate.h.processKeyEvent(i, keyEvent).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void destroyAd() {
        if (this.adProdTemplate != null) {
            this.adProdTemplate.C();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAdTaskProcess(View view, String str) {
        onAdTaskProcess(view, str, null);
    }

    public void onAdTaskProcess(View view, String str, Map<String, Object> map) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            JSONObject jSONObject = new JSONObject(uri.getQueryParameter("jsonObj"));
            c cVarB = c.b(host);
            if (!"bdsdk".equals(scheme)) {
                return;
            }
            switch (m.a[cVarB.ordinal()]) {
                case 1:
                    if (this.adProdTemplate != null) {
                        this.adProdTemplate.b(view, jSONObject);
                        break;
                    }
                    break;
                case 2:
                    if (this.adProdTemplate != null) {
                        this.adProdTemplate.a(view, jSONObject);
                        break;
                    }
                    break;
                case 3:
                    if ("server_bidding".equals(jSONObject.optString(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE))) {
                        handleServerBidding(jSONObject, map);
                        break;
                    } else if (this.adProdTemplate != null) {
                        this.adProdTemplate.b(jSONObject, map);
                        break;
                    }
                    break;
                case 4:
                    if (this.adProdTemplate != null) {
                        this.adProdTemplate.a(jSONObject, map);
                        break;
                    }
                    break;
                case 5:
                    if (this.adProdTemplate != null) {
                        this.adProdTemplate.a(map);
                        break;
                    }
                    break;
                case 6:
                    if (this.adProdTemplate != null) {
                        this.adProdTemplate.c(jSONObject, map);
                        break;
                    }
                    break;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAdTaskProcess(String str) {
        onAdTaskProcess((View) null, str);
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAdTaskProcess(String str, Map<String, Object> map) {
        onAdTaskProcess(null, str, map);
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public View getAdContainerView() {
        if (this.adProdTemplate != null) {
            return this.adProdTemplate.B();
        }
        return null;
    }

    public RelativeLayout getAdContainer() {
        return this.mRl;
    }

    public JSONObject getAllAdParam() {
        return this.mAllParam;
    }

    public void setRequestParameter(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.adProdTemplate == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        HashMap<String, String> mapA = ah.a(jSONObject);
        String strOptString = jSONObject.optString("apid");
        String strOptString2 = jSONObject.optString("w");
        String strOptString3 = jSONObject.optString("h");
        String strOptString4 = jSONObject.optString(g.k);
        mapA.put(g.o, DeviceUtils.getInstance().a(this.mCxt, strOptString));
        if (!TextUtils.isEmpty(strOptString2)) {
            mapA.put("lw", "" + ((int) (Integer.parseInt(strOptString2) / bv.e(this.mCxt))));
        }
        if (!TextUtils.isEmpty(strOptString3)) {
            mapA.put("lh", "" + ((int) (Integer.parseInt(strOptString3) / bv.e(this.mCxt))));
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            mapA.put(g.k, strOptString4);
        }
        this.mAdditionalParameters = mapA;
        try {
            this.mAllParam = ah.a(jSONObject, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.adProdTemplate instanceof com.baidu.mobads.container.nativecpu.j) {
            ((com.baidu.mobads.container.nativecpu.j) this.adProdTemplate).a(jSONObject2);
        }
        if (this.adProdTemplate instanceof e) {
            ((e) this.adProdTemplate).a(jSONObject2);
        }
        if (this.adProdTemplate instanceof y) {
            ((y) this.adProdTemplate).a(jSONObject2);
        }
    }

    private JSONObject getJsonParam(Map<String, Object> map, String str) {
        if (map != null) {
            Object obj = map.get(str);
            if (obj instanceof JSONObject) {
                return (JSONObject) obj;
            }
            return null;
        }
        return null;
    }

    private void handleServerBidding(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject != null && map != null) {
            String strOptString = jSONObject.optString("msg");
            if ("get_request_token".equals(strOptString)) {
                setRequestParameter(getJsonParam(map, "param_info"), getJsonParam(map, "ad_buss_param"));
                map.put("request_token", getRequestToken());
                return;
            }
            if ("load_bidding_data".equals(strOptString)) {
                String biddingData = parseBiddingData(map.get("bidding_data"));
                if (this.adProdTemplate != null) {
                    setAdSource(1);
                    this.adProdTemplate.b();
                    String str = this.adProdTemplate.l() + "" + System.currentTimeMillis();
                    this.adProdTemplate.b(str);
                    com.baidu.mobads.container.components.h.c.f.a(this.adProdTemplate.t()).a(str, this.adProdTemplate.d);
                    this.adProdTemplate.b(biddingData, "bidSuccess");
                    return;
                }
                return;
            }
            if ("load_bidding_ad".equals(strOptString)) {
                Object obj = map.get("bid_id");
                StringBuilder sb = new StringBuilder(com.baidu.mobads.container.util.o.e(h.e));
                sb.append("?adid=").append(obj);
                if (this.adProdTemplate != null) {
                    setAdSource(2);
                    this.adProdTemplate.b();
                    this.adProdTemplate.a(sb.toString());
                }
            }
        }
    }

    private void setAdSource(int i) {
        try {
            if (this.mAllParam != null) {
                this.mAllParam.put("adSrc", i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String parseBiddingData(Object obj) {
        if (obj != null) {
            try {
                String str = (String) obj;
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("admList");
                if (jSONArrayOptJSONArray != null) {
                    int length = jSONArrayOptJSONArray.length();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < length; i++) {
                        try {
                            String string = jSONArrayOptJSONArray.getString(i);
                            if (jSONObject.optInt("enc", 0) == 1) {
                                string = com.baidu.mobads.container.util.u.b(string);
                                if (TextUtils.isEmpty(string)) {
                                    string = jSONArrayOptJSONArray.getString(i);
                                }
                            }
                            jSONArray.put(new JSONObject(string));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    jSONObject2.put("ad", jSONArray);
                    jSONObject2.put("n", length);
                    jSONObject2.put("error_code", 0);
                    return jSONObject2.toString();
                }
                if (jSONObject.optJSONArray("ad") != null || !TextUtils.isEmpty(jSONObject.optString("ad"))) {
                    return str;
                }
                return "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return "";
    }
}
