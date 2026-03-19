package com.baidu.mobstat.forbes;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Session;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class SessionAnalysis {
    private boolean a = false;
    private Map<String, a> b = new HashMap();
    private a c = new a();
    private a d = new a();
    private boolean e = false;
    private long f = 0;
    private Session g = new Session();
    private int h = 0;
    private int i = 0;
    private long j = 0;
    private boolean k = true;
    private LaunchInfo l;
    private LaunchInfo m;
    public Callback mCallback;

    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public SessionAnalysis() {
    }

    public SessionAnalysis(Callback callback) {
        this.mCallback = callback;
    }

    public void setSessionTimeOut(int i) {
        if (i < 1) {
            v.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[30] is used");
            i = 30;
        } else if (i > 600) {
            v.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[600] is used");
            i = 600;
        }
        this.h = i * 1000;
    }

    public int getSessionTimeOut() {
        if (this.h <= 0) {
            this.h = 30000;
        }
        return this.h;
    }

    public long getSessionStartTime() {
        return this.g.getStartTime();
    }

    public JSONObject getPageSessionHead() {
        return this.g.getPageSessionHead();
    }

    public int getSessionSize() {
        return this.i;
    }

    public void doSendLogCheck(Context context, long j) {
        long j2 = this.f;
        if (j2 > 0 && j - j2 > getSessionTimeOut()) {
            a(context, -1L, false, false, 0);
        }
    }

    public void doSendNewSessionLog(Context context) {
    }

    public void setAutoSend(boolean z) {
        this.k = z;
    }

    public void autoTrackLaunchInfo(LaunchInfo launchInfo, boolean z) {
        if (z) {
            this.l = launchInfo;
        } else {
            this.m = launchInfo;
        }
    }

    public void autoTrackSessionStartTime(Context context, long j) {
        if (context == null) {
            return;
        }
        this.g.setTrackStartTime(j);
        this.j = j;
    }

    public void autoTrackSessionEndTime(Context context, long j) {
        if (context == null) {
            return;
        }
        this.g.setTrackEndTime(j);
        a(context);
    }

    public void onSessionStart(Context context, long j, boolean z) {
        if (this.a) {
            return;
        }
        DataCore.instance().init(context);
        a(context, j, z, true, this.l != null ? this.l.getLaunchType(context) : 0);
        this.a = true;
    }

    public void onPageStart(Context context, String str, int i, long j) {
        a aVarA;
        onSessionStart(context, j, false);
        if (TextUtils.isEmpty(str) || (aVarA = a(str)) == null) {
            return;
        }
        if (aVarA.c) {
            v.c().c("[WARNING] 遗漏StatService.onPageEnd(), 请检查邻近页面埋点: " + str);
        }
        if (!this.e) {
            a(context, this.f, j, i, 3);
            this.e = true;
        }
        aVarA.c = true;
        aVarA.b = j;
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j, ExtraInfo extraInfo, boolean z) {
        a aVarA;
        this.e = false;
        if (TextUtils.isEmpty(str) || (aVarA = a(str)) == null) {
            return;
        }
        if (!aVarA.c) {
            v.c().c("[WARNING] 遗漏StatService.onPageStart(), 请检查邻近页面埋点: " + str);
            return;
        }
        a(context, aVarA.a, str, aVarA.b, j, str2, "", str3, false, extraInfo, z);
        b(str);
        this.f = j;
    }

    public void onPageStartAct(Context context, String str, long j, boolean z) {
        onSessionStart(context, j, false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = z ? this.d : this.c;
        if (aVar.c && !z) {
            v.c().c("[WARNING] 遗漏StatService.onPause(Activity), 请检查邻近页面埋点: " + str);
        }
        if (!this.e) {
            a(context, this.f, j, 1, 1);
            this.e = true;
        }
        aVar.c = true;
        aVar.a = str;
        aVar.b = j;
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j, boolean z, ExtraInfo extraInfo) {
        this.e = false;
        a aVar = z ? this.d : this.c;
        if (!aVar.c) {
            if (!z) {
                v.c().c("[WARNING] 遗漏StatService.onResume(Activity), 请检查邻近页面埋点: " + str);
            }
        } else {
            a(context, aVar.a, str, aVar.b, j, str2, str3, str, z, extraInfo, false);
            aVar.c = false;
            this.f = j;
        }
    }

    public void onPageStartFrag(Context context, String str, long j) {
        onSessionStart(context, j, false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVarA = a(str);
        if (aVarA.c) {
            v.c().c("[WARNING] 遗漏StatService.onPause(Fragment), 请检查邻近页面埋点: " + str);
        }
        a(context, this.f, j, 2, 2);
        aVarA.c = true;
        aVarA.a = str;
        aVarA.b = j;
    }

    public void onPageEndFrag(Context context, String str, String str2, String str3, long j) {
        a aVarA;
        if (TextUtils.isEmpty(str) || (aVarA = a(str)) == null) {
            return;
        }
        if (!aVarA.c) {
            v.c().c("[WARNING] 遗漏StatService.onResume(Fragment), 请检查邻近页面埋点: " + str);
            return;
        }
        a(context, aVarA.a, str, aVarA.b, j, str2, str3, null, false, null, false);
        b(str);
        this.f = j;
    }

    private void a(Context context, long j, long j2, int i, int i2) {
        int launchType = 0;
        if (j2 - j > ((long) getSessionTimeOut())) {
            if (j > 0) {
                if (2 == i2) {
                    this.g.setEndTime(j);
                }
                if (this.m != null) {
                    launchType = this.m.getLaunchType(context);
                }
                a(context, j2, false, false, launchType);
            }
            this.g.setTrackStartTime(this.j);
            this.g.setInvokeType(i);
        }
    }

    private void a(Context context, String str, String str2, long j, long j2, String str3, String str4, String str5, boolean z, ExtraInfo extraInfo, boolean z2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) {
            return;
        }
        Session.a aVar = new Session.a(str3, str4, str5, j2 - j, j, z, extraInfo, z2, DataCore.instance().getPagePy());
        if (this.i > 102400) {
            return;
        }
        this.g.addPageView(aVar);
        this.g.setEndTime(j2);
        a(context);
        if (!TextUtils.isEmpty(DataCore.instance().getTempPyd())) {
            DataCore.instance().flush(context);
        }
    }

    private a a(String str) {
        if (!this.b.containsKey(str)) {
            this.b.put(str, new a(str));
        }
        return this.b.get(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r13, long r14, boolean r16, boolean r17, int r18) {
        /*
            r12 = this;
            r0 = r12
            r9 = r13
            r1 = r14
            r3 = r18
            com.baidu.mobstat.forbes.Session r4 = r0.g
            boolean r4 = r4.hasEnd()
            r5 = 0
            if (r4 == 0) goto L2d
            com.baidu.mobstat.forbes.DataCore r4 = com.baidu.mobstat.forbes.DataCore.instance()
            com.baidu.mobstat.forbes.Session r7 = r0.g
            r4.putSession(r7)
            com.baidu.mobstat.forbes.DataCore r4 = com.baidu.mobstat.forbes.DataCore.instance()
            r4.flush(r13)
            com.baidu.mobstat.forbes.Session r4 = r0.g
            org.json.JSONObject r4 = r4.getPageSessionHead()
            com.baidu.mobstat.forbes.p.a(r4)
            com.baidu.mobstat.forbes.Session r4 = r0.g
            r4.setEndTime(r5)
        L2d:
            int r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r4 <= 0) goto L34
            r4 = 1
            r10 = 1
            goto L36
        L34:
            r4 = 0
            r10 = 0
        L36:
            if (r10 == 0) goto L3a
            r5 = r1
            goto L41
        L3a:
            com.baidu.mobstat.forbes.Session r4 = r0.g
            long r4 = r4.getStartTime()
            r5 = r4
        L41:
            java.lang.String r4 = ""
            if (r3 == 0) goto L74
            if (r17 == 0) goto L5e
            com.baidu.mobstat.forbes.LaunchInfo r7 = r0.l
            if (r7 == 0) goto L72
            com.baidu.mobstat.forbes.LaunchInfo r4 = r0.l
            java.lang.String r4 = r4.getPushContent()
            com.baidu.mobstat.forbes.LaunchInfo r7 = r0.l
            java.lang.String r7 = r7.getRefererPkgName()
            r11 = r7
            r7 = r4
            r4 = r11
            goto L7b
        L5e:
            com.baidu.mobstat.forbes.LaunchInfo r7 = r0.m
            if (r7 == 0) goto L72
            com.baidu.mobstat.forbes.LaunchInfo r4 = r0.m
            java.lang.String r4 = r4.getPushContent()
            com.baidu.mobstat.forbes.LaunchInfo r7 = r0.m
            java.lang.String r7 = r7.getRefererPkgName()
            r11 = r7
            r7 = r4
            r4 = r11
            goto L7b
        L72:
            r7 = r4
            goto L7b
        L74:
            java.lang.String r7 = com.baidu.mobstat.forbes.LaunchInfo.getLauncherHomePkgName(r13)
            r11 = r7
            r7 = r4
            r4 = r11
        L7b:
            com.baidu.mobstat.forbes.ap r8 = com.baidu.mobstat.forbes.ap.a()
            boolean r8 = r8.f()
            if (r8 == 0) goto L8a
            org.json.JSONObject r3 = com.baidu.mobstat.forbes.LaunchInfo.getConvertedJson(r3, r4, r7)
            goto L8b
        L8a:
            r3 = 0
        L8b:
            r8 = r3
            if (r10 == 0) goto L9f
            com.baidu.mobstat.forbes.Session r3 = r0.g
            r3.reset()
            com.baidu.mobstat.forbes.Session r3 = r0.g
            r3.setStartTime(r14)
            if (r8 == 0) goto L9f
            com.baidu.mobstat.forbes.Session r1 = r0.g
            r1.setLaunchInfo(r8)
        L9f:
            com.baidu.mobstat.forbes.DataCore r1 = com.baidu.mobstat.forbes.DataCore.instance()
            r2 = r13
            r3 = r10
            r4 = r16
            r7 = r17
            r1.saveLogData(r2, r3, r4, r5, r7, r8)
            com.baidu.mobstat.forbes.SessionAnalysis$Callback r1 = r0.mCallback
            if (r1 == 0) goto Lbd
            com.baidu.mobstat.forbes.SessionAnalysis$Callback r1 = r0.mCallback
            com.baidu.mobstat.forbes.DataCore r2 = com.baidu.mobstat.forbes.DataCore.instance()
            org.json.JSONObject r2 = r2.getLogData()
            r1.onCallback(r2)
        Lbd:
            if (r10 != 0) goto Lc3
            boolean r1 = r0.k
            if (r1 == 0) goto Lca
        Lc3:
            com.baidu.mobstat.forbes.LogSender r1 = com.baidu.mobstat.forbes.LogSender.instance()
            r1.onSend(r13)
        Lca:
            r12.clearLastSessionCache(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.SessionAnalysis.a(android.content.Context, long, boolean, boolean, int):void");
    }

    private void a(Context context) {
        if (!this.g.hasStart() || this.i > 102400) {
            return;
        }
        String string = this.g.constructJSONObject().toString();
        this.i = string.getBytes().length;
        aj.a(context, ar.l(context) + Config.LAST_SESSION_FILE_NAME, string, false);
    }

    public void clearLastSessionCache(Context context) {
        if (context == null) {
            return;
        }
        aj.a(context, ar.l(context) + Config.LAST_SESSION_FILE_NAME, new JSONObject().toString(), false);
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str) && this.b.containsKey(str)) {
            this.b.remove(str);
        }
    }

    public boolean isSessionStart() {
        return this.g.getStartTime() > 0;
    }

    static class a {
        String a;
        long b;
        boolean c = false;

        public a() {
        }

        public a(String str) {
            this.a = str;
        }
    }
}
