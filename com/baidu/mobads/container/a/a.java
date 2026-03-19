package com.baidu.mobads.container.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.adrequest.h;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.k;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.nativecpu.be;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.component.interfaces.RemoteReflectInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a implements AbstractData {
    private j a;
    private k b;

    public a(k kVar, j jVar) {
        this.b = kVar;
        this.a = jVar;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getBrandName() {
        if (this.a != null) {
            return this.a.getAppName();
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getTitle() {
        if (this.a != null) {
            return this.a.getTitle();
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getStyleType() {
        if (this.a != null) {
            return this.a.getBtnStyleType();
        }
        return 0;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getMainPicWidth() {
        if (this.a != null) {
            return this.a.getMainMaterialWidth();
        }
        return 0;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getMainPicHeight() {
        if (this.a != null) {
            return this.a.getMainMaterialHeight();
        }
        return 0;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getContainerHeight() {
        if (this.b != null && this.a != null) {
            return this.a.getAdContainerHeight();
        }
        return 0;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getContainerWidth() {
        if (this.b != null && this.a != null) {
            return this.a.getAdContainerWidth();
        }
        return 0;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getImageUrl() {
        if (this.a != null) {
            return this.a.getMainPictureUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getActionText(Context context) {
        String appPackage = getAppPackage();
        String actRefinedText = getActRefinedText();
        int actionType = getActionType();
        if (actionType == 2) {
            if (com.baidu.mobads.container.util.j.b(context, appPackage)) {
                return "去看看";
            }
            if (!TextUtils.isEmpty(appPackage) && RemoteReflectInterface.getDownloadStatus(appPackage) == 101) {
                return "点击安装";
            }
            if (!TextUtils.isEmpty(actRefinedText)) {
                return actRefinedText;
            }
            return "立即下载";
        }
        if (actionType == 512) {
            return !TextUtils.isEmpty(actRefinedText) ? actRefinedText : "去看看";
        }
        if (!TextUtils.isEmpty(actRefinedText)) {
            return actRefinedText;
        }
        return "查看详情";
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public boolean isDownloadApp() {
        return b();
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getAppPackage() {
        if (this.a != null) {
            return this.a.getAppPackageName();
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getPowerUrl() {
        if (this.a != null && this.a.getOriginJsonObject() != null) {
            return this.a.getOriginJsonObject().optString(com.baidu.mobads.container.components.command.j.L);
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getPrivacyUrl() {
        if (this.a != null && this.a.getOriginJsonObject() != null) {
            return this.a.getOriginJsonObject().optString("privacy_link");
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public List<String> getMultiPicUrls() {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            if (this.a != null && this.a.getOriginJsonObject() != null && (jSONArrayOptJSONArray = this.a.getOriginJsonObject().optJSONArray("morepics")) != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getPublisher() {
        if (this.a != null && this.a.getOriginJsonObject() != null) {
            return this.a.getOriginJsonObject().optString(com.baidu.mobads.container.components.command.j.I);
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void unionLogoClick(Context context) {
        Intent intent = new Intent();
        intent.putExtra("privacy_link", h.g);
        com.baidu.mobads.container.util.h.a(context, intent);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getActionType() {
        if (this.a != null) {
            return this.a.getActionType();
        }
        return 0;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getIconUrl() {
        if (this.a != null) {
            return this.a.getIconUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getVersion() {
        if (this.a != null && this.a.getOriginJsonObject() != null) {
            return this.a.getOriginJsonObject().optString("app_version");
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public boolean isAutoPlay() {
        return (this.a == null || this.a.getOriginJsonObject() == null || this.a.getOriginJsonObject().optInt("auto_play", 0) != 1) ? false : true;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public boolean isNonWifiAutoPlay() {
        return this.a == null || this.a.getOriginJsonObject() == null || this.a.getOriginJsonObject().optInt("auto_play_non_wifi", 1) == 1;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void handleClick(View view) {
        handleClick(view, false);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void handleClick(View view, boolean z) {
        if (((this.b instanceof com.baidu.mobads.container.f.b) || (this.b instanceof be)) && this.a != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uniqueId", this.a.getUniqueId());
                jSONObject.put("tit", this.a.getTitle());
                jSONObject.put(RemoteRewardActivity.JSON_BANNER_DESC_ID, this.a.getDescription());
                jSONObject.put("pk", this.a.getAppPackageName());
                jSONObject.put("appname", this.a.getAppName());
                jSONObject.put("act", this.a.getActionType());
                jSONObject.put("progress", -1);
                jSONObject.put("use_dialog_frame", z);
                jSONObject.put("isDownloadApp", b());
                if (this.b instanceof com.baidu.mobads.container.f.b) {
                    ((com.baidu.mobads.container.f.b) this.b).b(view, jSONObject);
                } else if (this.b instanceof be) {
                    ((be) this.b).a(view, jSONObject, this.a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void handleClick(View view, boolean z, int i) {
        if (((this.b instanceof com.baidu.mobads.container.f.b) || (this.b instanceof be)) && this.a != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uniqueId", this.a.getUniqueId());
                jSONObject.put("tit", this.a.getTitle());
                jSONObject.put(RemoteRewardActivity.JSON_BANNER_DESC_ID, this.a.getDescription());
                jSONObject.put("pk", this.a.getAppPackageName());
                jSONObject.put("appname", this.a.getAppName());
                jSONObject.put("act", this.a.getActionType());
                jSONObject.put("progress", -1);
                jSONObject.put("use_dialog_frame", z);
                jSONObject.put("isDownloadApp", b());
                jSONObject.put("click_type", i);
                if (this.b instanceof com.baidu.mobads.container.f.b) {
                    ((com.baidu.mobads.container.f.b) this.b).b(view, jSONObject);
                } else if (this.b instanceof be) {
                    ((be) this.b).a(view, jSONObject, this.a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b() {
        /*
            r9 = this;
            com.baidu.mobads.container.adrequest.j r0 = r9.a
            r1 = 0
            if (r0 == 0) goto Lab
            com.baidu.mobads.container.k r0 = r9.b
            if (r0 == 0) goto Lab
            com.baidu.mobads.container.k r0 = r9.b
            com.baidu.mobads.container.adrequest.t r0 = r0.getAdContainerContext()
            if (r0 == 0) goto Lab
            com.baidu.mobads.container.k r0 = r9.b
            com.baidu.mobads.container.adrequest.t r0 = r0.getAdContainerContext()
            android.content.Context r0 = r0.t()
            if (r0 != 0) goto L20
            goto Lab
        L20:
            com.baidu.mobads.container.adrequest.j r0 = r9.a
            int r0 = r0.getActionType()
            com.baidu.mobads.container.adrequest.j r2 = r9.a
            java.lang.String r2 = r2.getAppPackageName()
            r3 = 2
            r4 = 1
            if (r0 != r4) goto L35
            r5 = 1
            goto La7
        L35:
            r5 = 3
            if (r0 != r3) goto L4b
            com.baidu.mobads.container.k r0 = r9.b
            com.baidu.mobads.container.adrequest.t r0 = r0.getAdContainerContext()
            android.content.Context r0 = r0.t()
            boolean r0 = com.baidu.mobads.container.util.j.b(r0, r2)
            if (r0 == 0) goto L49
            goto La7
        L49:
            r5 = 2
            goto La7
        L4b:
            r6 = 512(0x200, float:7.17E-43)
            if (r0 != r6) goto La6
        L51:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> La0
            com.baidu.mobads.container.adrequest.j r6 = r9.a     // Catch: org.json.JSONException -> La0
            java.lang.String r6 = r6.getAppOpenStrs()     // Catch: org.json.JSONException -> La0
            r0.<init>(r6)     // Catch: org.json.JSONException -> La0
            java.lang.String r6 = "fb_act"
            int r6 = r0.optInt(r6, r1)     // Catch: org.json.JSONException -> La0
            java.lang.String r7 = "page"
            java.lang.String r8 = ""
            java.lang.String r0 = r0.optString(r7, r8)     // Catch: org.json.JSONException -> La0
            com.baidu.mobads.container.k r7 = r9.b     // Catch: org.json.JSONException -> La0
            com.baidu.mobads.container.adrequest.t r7 = r7.getAdContainerContext()     // Catch: org.json.JSONException -> La0
            android.content.Context r7 = r7.t()     // Catch: org.json.JSONException -> La0
            boolean r0 = com.baidu.mobads.container.util.bk.b(r7, r0)     // Catch: org.json.JSONException -> La0
            if (r0 == 0) goto L7b
            goto L9f
        L7b:
            if (r6 != r4) goto L7f
            r5 = 1
            goto L9f
        L7f:
            if (r6 != r3) goto L9e
        L82:
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: org.json.JSONException -> L9b
            if (r0 != 0) goto L99
            com.baidu.mobads.container.k r0 = r9.b     // Catch: org.json.JSONException -> L9b
            com.baidu.mobads.container.adrequest.t r0 = r0.getAdContainerContext()     // Catch: org.json.JSONException -> L9b
            android.content.Context r0 = r0.t()     // Catch: org.json.JSONException -> L9b
            boolean r0 = com.baidu.mobads.container.util.j.b(r0, r2)     // Catch: org.json.JSONException -> L9b
            if (r0 == 0) goto L99
            goto L9f
        L99:
            r5 = 2
            goto L9f
        L9b:
            r0 = move-exception
            r5 = 2
            goto La2
        L9e:
            r5 = 1
        L9f:
            goto La7
        La0:
            r0 = move-exception
            r5 = 1
        La2:
            r0.printStackTrace()
            goto La7
        La6:
            r5 = 1
        La7:
            if (r5 != r3) goto Laa
            r1 = 1
        Laa:
            return r1
        Lab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.a.a.b():boolean");
    }

    public j a() {
        return this.a;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getAdid() {
        if (this.a != null) {
            return this.a.getAdId();
        }
        return "";
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getQueryKey() {
        if (this.a != null) {
            return this.a.getQueryKey();
        }
        return "";
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getBuyer() {
        if (this.a != null) {
            return this.a.getBuyer();
        }
        return "";
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public boolean getMute() {
        if (this.a == null) {
            return true;
        }
        String mute = this.a.getMute();
        return TextUtils.isEmpty(mute) || "true".equalsIgnoreCase(mute);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public AbstractData.a getMaterialType() {
        if (this.a != null) {
            return AbstractData.a.b(this.a.getMaterialType());
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void recordImpression(View view) {
        if ((this.b instanceof com.baidu.mobads.container.f.b) && this.a != null) {
            ((com.baidu.mobads.container.f.b) this.b).a(view, this.a, ((com.baidu.mobads.container.f.b) this.b).a(-1, this.a.getThirdImpressionTrackingUrls()), "0");
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getDesc() {
        if (this.a != null) {
            return this.a.getDescription();
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public k getBaseAdContainer() {
        return this.b;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void onDislikeClick() {
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getVideoUrl() {
        if (this.a != null) {
            return this.a.getVideoUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public List<String> getThirdTrackers(String str) {
        if (!TextUtils.isEmpty(str) && this.a != null && this.a.getOriginJsonObject() != null) {
            JSONObject jSONObjectOptJSONObject = this.a.getOriginJsonObject().optJSONObject("monitors");
            ArrayList arrayList = new ArrayList();
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next.equals(str)) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(next);
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i));
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public Map<String, String> getExtras() {
        if (this.b != null && this.b.getAdContainerContext() != null) {
            String strZ = this.b.getAdContainerContext().z();
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(strZ)) {
                map.put("appsid", strZ);
            }
            return map;
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getActRefinedText() {
        if (this.a != null) {
            return this.a.getActRefinedText();
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getBtnStyleType() {
        return 0;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int[] getBtnStyleColors() {
        return new int[0];
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public boolean isButtonRespondMoreClicksInDownloadScene() {
        return true;
    }
}
