package com.baidu.mobads.container.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.container.adrequest.ProdAdRequestInfo;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.k;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.component.interfaces.RemoteReflectInterface;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d implements AbstractData {
    Class<?> a;
    Object b;
    Object c = null;

    public d(Object obj) {
        this.a = null;
        this.b = null;
        this.a = obj.getClass();
        this.b = obj;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void recordImpression(View view) {
        g.a(this.b, "recordImpression", (Class<?>[]) new Class[]{View.class}, new Object[]{view});
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void handleClick(View view) {
        try {
            g.a(this.b, "handleClick", (Class<?>[]) new Class[]{View.class}, new Object[]{view});
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void handleClick(View view, boolean z) {
        try {
            g.a(this.b, "handleClick", (Class<?>[]) new Class[]{View.class, Boolean.TYPE}, new Object[]{view, Boolean.valueOf(z)});
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void handleClick(View view, boolean z, int i) {
        try {
            g.a(this.b, "handleClick", (Class<?>[]) new Class[]{View.class, Boolean.TYPE, Integer.TYPE}, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i)});
        } catch (Exception e) {
        }
    }

    public void a(View view, int i) {
        try {
            g.a(this.b, "handleClick", (Class<?>[]) new Class[]{View.class, Integer.TYPE}, new Object[]{view, Integer.valueOf(i)});
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getTitle() {
        return b("getTitle", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getDesc() {
        return b("getDesc", new Object[0]);
    }

    public String a() {
        return b("getUniqueId", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getIconUrl() {
        return b("getIconUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getImageUrl() {
        return b("getImageUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getMainPicWidth() {
        return d("getMainPicWidth", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getMainPicHeight() {
        return d("getMainPicHeight", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getBrandName() {
        return b("getBrandName", new Object[0]);
    }

    public String b() {
        return b("getAdLogoUrl", new Object[0]);
    }

    public String c() {
        return b("getLogoUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public boolean isDownloadApp() {
        return ((Boolean) g.a(this.b, "isNeedDownloadApp", new Object[0])).booleanValue();
    }

    public boolean a(Context context) {
        try {
            return ((Boolean) g.a(this.b, "isAdAvailable", (Class<?>[]) new Class[]{Context.class}, new Object[]{context})).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public long d() {
        return c("getAppSize", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getAppPackage() {
        return b("getAppPackage", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public List<String> getMultiPicUrls() {
        try {
            return (List) g.a(this.b, "getMultiPicUrls", new Object[0]);
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public Map<String, String> getExtras() {
        try {
            return (Map) g.a(this.b, "getExtras", new Object[0]);
        } catch (Exception e) {
            return new HashMap();
        }
    }

    public void b(Context context) {
        g.a(this.b, "onStart", (Class<?>[]) new Class[]{Context.class}, new Object[]{context});
    }

    public void a(Context context, int i, int i2) {
        g.a(this.b, "onError", (Class<?>[]) new Class[]{Context.class}, new Object[]{context});
    }

    public void c(Context context) {
        g.a(this.b, "onComplete", (Class<?>[]) new Class[]{Context.class}, new Object[]{context});
    }

    public void a(Context context, int i) {
        g.a(this.b, "onClose", (Class<?>[]) new Class[]{Context.class, Integer.TYPE}, new Object[]{context, Integer.valueOf(i)});
    }

    public void d(Context context) {
        g.a(this.b, "onClickAd", (Class<?>[]) new Class[]{Context.class}, new Object[]{context});
    }

    public void b(Context context, int i) {
        g.a(this.b, "onFullScreen", (Class<?>[]) new Class[]{Context.class, Integer.TYPE}, new Object[]{context, Integer.valueOf(i)});
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getVideoUrl() {
        return b("getVideoUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public boolean isAutoPlay() {
        try {
            Object objA = g.a(this.b, "isAutoPlay", new Object[0]);
            if (objA != null) {
                return ((Boolean) objA).booleanValue();
            }
        } catch (Throwable th) {
        }
        return false;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public boolean isNonWifiAutoPlay() {
        try {
            if (this.c == null) {
                for (Field field : this.b.getClass().getDeclaredFields()) {
                    if (field.getType() == j.class) {
                        field.setAccessible(true);
                        this.c = field.get(this.b);
                    }
                }
            }
            if (this.c instanceof j) {
                return ((j) this.c).getOriginJsonObject().optInt("auto_play_non_wifi", 1) == 1;
            }
        } catch (Throwable th) {
        }
        return true;
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
    public String getActRefinedText() {
        return b("getActButtonString", new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
    
        r4.c = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.baidu.mobads.container.adrequest.j e() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.c     // Catch: java.lang.Throwable -> L47
            if (r0 != 0) goto L3b
            java.lang.String r0 = r4.a()     // Catch: java.lang.Throwable -> L37
            com.baidu.mobads.container.k r1 = r4.getBaseAdContainer()     // Catch: java.lang.Throwable -> L37
            com.baidu.mobads.container.adrequest.t r1 = r1.getAdContainerContext()     // Catch: java.lang.Throwable -> L37
            com.baidu.mobads.container.adrequest.l r1 = r1.r()     // Catch: java.lang.Throwable -> L37
            java.util.ArrayList r1 = r1.o()     // Catch: java.lang.Throwable -> L37
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L37
        L1c:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L36
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L37
            com.baidu.mobads.container.adrequest.j r2 = (com.baidu.mobads.container.adrequest.j) r2     // Catch: java.lang.Throwable -> L37
            java.lang.String r3 = r2.getUniqueId()     // Catch: java.lang.Throwable -> L37
            boolean r3 = r3.equals(r0)     // Catch: java.lang.Throwable -> L37
            if (r3 == 0) goto L35
            r4.c = r2     // Catch: java.lang.Throwable -> L37
            goto L36
        L35:
            goto L1c
        L36:
            goto L3b
        L37:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L47
        L3b:
            java.lang.Object r0 = r4.c     // Catch: java.lang.Throwable -> L47
            boolean r0 = r0 instanceof com.baidu.mobads.container.adrequest.j     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L46
            java.lang.Object r0 = r4.c     // Catch: java.lang.Throwable -> L47
            com.baidu.mobads.container.adrequest.j r0 = (com.baidu.mobads.container.adrequest.j) r0     // Catch: java.lang.Throwable -> L47
            return r0
        L46:
            goto L48
        L47:
            r0 = move-exception
        L48:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.a.d.e():com.baidu.mobads.container.adrequest.j");
    }

    public boolean f() {
        try {
            Object objA = g.a(this.b, "isVideoMuted", new Object[0]);
            if (objA != null) {
                return ((Boolean) objA).booleanValue();
            }
            return true;
        } catch (Throwable th) {
            return true;
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public boolean getMute() {
        String strB = b("getMute", new Object[0]);
        return TextUtils.isEmpty(strB) || "true".equalsIgnoreCase(strB);
    }

    public int g() {
        return d("getDuration", new Object[0]);
    }

    public String h() {
        return b("getHtmlSnippet", new Object[0]);
    }

    public WebView i() {
        try {
            return (WebView) g.a(this.b, "getWebView", new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getStyleType() {
        return d("getStyleType", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getActionType() {
        return d("getActionType", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getPublisher() {
        return b("getPublisher", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void unionLogoClick(Context context) {
        try {
            g.a(this.b, "unionLogoClick", (Class<?>[]) new Class[0], new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getVersion() {
        return b("getAppVersion", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getAdid() {
        j jVarE = e();
        if (jVarE != null) {
            return jVarE.getAdId();
        }
        return "";
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getQueryKey() {
        j jVarE = e();
        if (jVarE != null) {
            return jVarE.getQueryKey();
        }
        return "";
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getBuyer() {
        j jVarE = e();
        if (jVarE != null) {
            return jVarE.getBuyer();
        }
        return "";
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getPrivacyUrl() {
        return b("getAppPrivacyLink", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public String getPowerUrl() {
        return b("getAppPermissionLink", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getContainerWidth() {
        return d("getContainerWidth", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getContainerHeight() {
        return d("getContainerHeight", new Object[0]);
    }

    public int j() {
        return d("getContainerSizeType", new Object[0]);
    }

    private String b(String str, Object... objArr) {
        try {
            return (String) g.a(this.b, str, objArr);
        } catch (Exception e) {
            return "";
        }
    }

    private long c(String str, Object... objArr) {
        try {
            return ((Long) g.a(this.b, str, objArr)).longValue();
        } catch (Exception e) {
            return 0L;
        }
    }

    private int d(String str, Object... objArr) {
        try {
            return ((Integer) g.a(this.b, str, objArr)).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public Object a(String str, Object... objArr) {
        return g.a(this.b, str, objArr);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public AbstractData.a getMaterialType() {
        try {
            if (this.b == null) {
                return null;
            }
            return AbstractData.a.b((String) g.a(this.b, b.f, new Object[0]));
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public void onDislikeClick() {
        Object objA;
        if (this.b != null && (objA = g.a(this.b, "getAdDislikeListener", new Object[0])) != null) {
            g.a(objA, "onDislikeClick", new Object[0]);
        }
    }

    public String k() {
        return b("getMarketingICONUrl", new Object[0]);
    }

    public String l() {
        return b("getMarketingDesc", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int getBtnStyleType() {
        return d("getBtnStyleType", new Object[0]);
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public int[] getBtnStyleColors() {
        int[] iArr = new int[4];
        iArr[0] = -35564;
        iArr[1] = -648683;
        iArr[2] = -3602220;
        iArr[3] = -194648;
        try {
            List list = (List) g.a(this.b, "getBtnStyleColors", new Object[0]);
            if (list != null && list.size() == 4) {
                for (int i = 0; i < list.size(); i++) {
                    iArr[i] = Color.parseColor((String) list.get(i));
                }
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
        return iArr;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public boolean isButtonRespondMoreClicksInDownloadScene() {
        return true;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public k getBaseAdContainer() {
        IAdInterListener iAdInterListener;
        if (this.b == null || (iAdInterListener = (IAdInterListener) g.a(this.b, "getAdInterListener", new Object[0])) == null || !(iAdInterListener instanceof ProdAdRequestInfo)) {
            return null;
        }
        ProdAdRequestInfo prodAdRequestInfo = (ProdAdRequestInfo) iAdInterListener;
        if (prodAdRequestInfo.adProdTemplate != null) {
            return prodAdRequestInfo.adProdTemplate.F();
        }
        return null;
    }

    @Override // com.baidu.mobads.container.nativecpu.AbstractData
    public List<String> getThirdTrackers(String str) {
        try {
            return (List) g.a(this.b, "getThirdTrackers", (Class<?>[]) new Class[]{String.class}, new Object[]{str});
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    public int m() {
        return d("isRegionClick", new Object[0]);
    }

    public int n() {
        return d("isShowDialog", new Object[0]);
    }

    public String o() {
        return b("getProd", new Object[0]);
    }
}
