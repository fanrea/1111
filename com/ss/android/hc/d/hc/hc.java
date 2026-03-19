package com.ss.android.hc.d.hc;

import com.ss.android.d.d.b.b;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.hc.d.d.b;
import com.ss.android.hc.d.d.d;
import com.ss.android.hc.d.d.hc;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements d {
    private long an;
    private boolean ar;
    public final AtomicBoolean b;
    private boolean ba;
    private boolean bc;
    public final AtomicBoolean c;
    private int cb;
    protected boolean d;
    private String dc;
    private long de;
    private long dz;
    private int e;
    private boolean ey;
    private String fs;
    private boolean fu;
    private String gb;
    private String gv;
    private long h;
    protected boolean hc;
    private int he;
    private boolean hv;
    private boolean i;
    private boolean ia;
    private long j;
    private String jh;
    private int k;
    private boolean l;
    private String mk;
    private String mq;
    private String mt;
    private int np;
    private transient boolean nr;
    private boolean nv;
    private boolean nw;
    private boolean ph;
    private int q;
    private boolean qr;
    private long qy;
    private boolean r;
    private String ra;
    private String rf;
    private long ru;
    private boolean rw;
    private long s;
    private boolean sy;
    private boolean t;
    private String tc;
    private long to;
    private String tr;
    private int tt;
    public final AtomicBoolean u;
    private String uo;
    private int us;
    private JSONObject v;
    private int vv;
    private int w;
    private int wl;
    private long xp;
    private boolean y;
    private boolean yi;
    private long yn;
    private String yo;
    private int z;
    private long zw;

    @Override // com.ss.android.hc.d.hc.d
    public JSONObject cb() {
        return null;
    }

    @Override // com.ss.android.hc.d.hc.d
    public Object e() {
        return null;
    }

    @Override // com.ss.android.hc.d.hc.d
    public int jh() {
        return -1;
    }

    @Override // com.ss.android.hc.d.hc.d
    public List<String> k() {
        return null;
    }

    @Override // com.ss.android.hc.d.hc.d
    public JSONObject mk() {
        return null;
    }

    @Override // com.ss.android.hc.d.hc.d
    public JSONObject yo() {
        return null;
    }

    private hc() {
        this.tt = 1;
        this.sy = true;
        this.yi = false;
        this.he = 0;
        this.vv = 0;
        this.ba = false;
        this.r = false;
        this.hv = true;
        this.bc = true;
        this.d = true;
        this.hc = true;
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.u = new AtomicBoolean(false);
        this.q = 1;
        this.l = true;
        this.dz = -1L;
    }

    public hc(b bVar, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar) {
        this(bVar, hcVar, dVar, 0);
    }

    public hc(b bVar, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar, int i) {
        this.tt = 1;
        this.sy = true;
        this.yi = false;
        this.he = 0;
        this.vv = 0;
        this.ba = false;
        this.r = false;
        this.hv = true;
        this.bc = true;
        this.d = true;
        this.hc = true;
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.u = new AtomicBoolean(false);
        this.q = 1;
        this.l = true;
        this.dz = -1L;
        this.an = bVar.c();
        this.h = bVar.h();
        this.gb = bVar.yi();
        this.tc = bVar.he();
        this.v = bVar.s();
        this.sy = bVar.np();
        this.w = bVar.de();
        this.yo = bVar.v();
        this.mk = bVar.d();
        if (bVar.zw() != null) {
            this.mq = bVar.zw().hc();
            this.uo = bVar.zw().d();
        }
        this.k = bVar.us();
        this.rf = bVar.gb();
        this.jh = bVar.vv();
        this.mt = bVar.tt();
        this.dc = hcVar.hc();
        this.tr = hcVar.d();
        this.nv = hcVar.uo();
        this.yi = dVar.b();
        this.e = dVar.d();
        this.cb = dVar.hc();
        this.l = dVar.mq();
        this.fu = dVar.uo();
        this.hv = dVar.k();
        this.d = dVar.e();
        this.hc = dVar.cb();
        this.np = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.de = jCurrentTimeMillis;
        this.zw = jCurrentTimeMillis;
        this.r = bVar.mt();
        if (bVar instanceof com.ss.android.hc.d.d.b) {
            this.gv = ((com.ss.android.hc.d.d.b) bVar).wl();
        }
    }

    public int np() {
        return this.he;
    }

    public void d(int i) {
        this.he = i;
    }

    public synchronized void yi() {
        this.he++;
    }

    public int he() {
        return this.vv;
    }

    public void hc(int i) {
        this.vv = i;
    }

    public synchronized void vv() {
        this.vv++;
    }

    public long zw() {
        long j = this.zw;
        return j == 0 ? this.de : j;
    }

    public void d(long j) {
        this.zw = j;
    }

    public long j() {
        return this.j;
    }

    public void hc(long j) {
        this.j = j;
    }

    public void b(long j) {
        this.s = j;
    }

    public int s() {
        return this.us;
    }

    public void b(int i) {
        this.us = i;
    }

    public int us() {
        return this.z;
    }

    public void c(int i) {
        this.z = i;
    }

    public String z() {
        return this.fs;
    }

    public void d(String str) {
        this.fs = str;
    }

    @Override // com.ss.android.hc.d.hc.d
    public long hc() {
        return this.an;
    }

    public void c(long j) {
        this.an = j;
    }

    @Override // com.ss.android.hc.d.hc.d
    public long mq() {
        return this.h;
    }

    public void u(long j) {
        this.h = j;
    }

    public int fs() {
        return this.tt;
    }

    public void u(int i) {
        this.tt = i;
    }

    @Override // com.ss.android.hc.d.hc.d
    public String u() {
        return this.tc;
    }

    public void hc(String str) {
        this.tc = str;
    }

    public long ba() {
        return this.de;
    }

    public void an(long j) {
        if (j > 0) {
            this.de = j;
        }
    }

    @Override // com.ss.android.hc.d.hc.d
    public String c() {
        return this.gb;
    }

    public void b(String str) {
        this.gb = str;
    }

    @Override // com.ss.android.hc.d.hc.d
    public boolean b() {
        return this.sy;
    }

    public void d(boolean z) {
        this.sy = z;
    }

    @Override // com.ss.android.hc.d.hc.d
    public JSONObject h() {
        return this.v;
    }

    public void d(JSONObject jSONObject) {
        this.v = jSONObject;
    }

    public void an(int i) {
        this.w = i;
    }

    public void c(String str) {
        this.yo = str;
    }

    public int mt() {
        return this.w;
    }

    public String r() {
        return this.yo;
    }

    public void h(int i) {
        this.np = i;
    }

    @Override // com.ss.android.hc.d.hc.d
    public int rf() {
        return this.np;
    }

    public void hc(boolean z) {
        this.nv = z;
    }

    @Override // com.ss.android.hc.d.hc.d
    public boolean uo() {
        return this.nv;
    }

    public void gb(int i) {
        this.wl = i;
    }

    public int hv() {
        return this.wl;
    }

    public void tt(int i) {
        this.q = i;
    }

    public void u(String str) {
        this.uo = str;
    }

    @Override // com.ss.android.hc.d.hc.d
    public int gb() {
        return this.q;
    }

    public void b(boolean z) {
        this.yi = z;
    }

    public boolean bc() {
        return this.yi;
    }

    public void an(String str) {
        this.dc = str;
    }

    @Override // com.ss.android.hc.d.hc.d
    public String tc() {
        return this.dc;
    }

    public void h(String str) {
        this.tr = str;
    }

    @Override // com.ss.android.hc.d.hc.d
    public String tt() {
        return this.tr;
    }

    public void gb(String str) {
        this.mk = str;
    }

    @Override // com.ss.android.hc.d.hc.d
    public String d() {
        return this.mk;
    }

    public void tt(String str) {
        this.mq = str;
    }

    @Override // com.ss.android.hc.d.hc.d
    public String an() {
        return this.mq;
    }

    public void h(long j) {
        this.dz = j;
    }

    public long dc() {
        return this.dz;
    }

    public void tc(String str) {
        this.rf = str;
    }

    public String tr() {
        return this.rf;
    }

    public void mk(String str) {
        this.jh = str;
    }

    public void tc(int i) {
        this.e = i;
    }

    public int nv() {
        return this.e;
    }

    public void mk(int i) {
        this.cb = i;
    }

    public void mq(int i) {
        this.k = i;
    }

    public void c(boolean z) {
        this.rw = z;
    }

    public String y() {
        return this.ra;
    }

    public void mq(String str) {
        this.ra = str;
    }

    public boolean wl() {
        return this.ia;
    }

    public void u(boolean z) {
        this.ia = z;
    }

    public boolean q() {
        return this.y;
    }

    public void an(boolean z) {
        this.y = z;
    }

    public boolean ru() {
        return this.nw;
    }

    public void h(boolean z) {
        this.nw = z;
    }

    public long yn() {
        return this.ru;
    }

    public void gb(long j) {
        this.ru = j;
    }

    public long l() {
        return this.yn;
    }

    public void tt(long j) {
        this.yn = j;
    }

    public boolean fu() {
        return this.ba;
    }

    public void gb(boolean z) {
        this.ba = z;
    }

    public String xp() {
        return this.mt;
    }

    public void uo(String str) {
        this.mt = str;
    }

    public boolean to() {
        return this.r;
    }

    public void tt(boolean z) {
        this.r = z;
    }

    public boolean ra() {
        return this.nr;
    }

    public void tc(boolean z) {
        this.nr = z;
    }

    public boolean rw() {
        return this.i;
    }

    public void mk(boolean z) {
        this.i = z;
    }

    public boolean ia() {
        return this.qr;
    }

    public void mq(boolean z) {
        this.qr = z;
    }

    public boolean nw() {
        return this.ey;
    }

    public void uo(boolean z) {
        this.ey = z;
    }

    public boolean dz() {
        return this.ar;
    }

    public void k(boolean z) {
        this.ar = z;
    }

    public boolean nr() {
        return this.t;
    }

    public void e(boolean z) {
        this.t = z;
    }

    public void cb(boolean z) {
        this.l = z;
    }

    public void w(boolean z) {
        this.fu = z;
    }

    @Override // com.ss.android.hc.d.hc.d
    public boolean w() {
        return this.hv;
    }

    public void yo(boolean z) {
        this.hv = z;
    }

    public void rf(boolean z) {
        this.bc = z;
    }

    public void jh(boolean z) {
        this.d = z;
    }

    public void sy(boolean z) {
        this.hc = z;
    }

    public boolean i() {
        return this.ph;
    }

    public void de(boolean z) {
        this.ph = z;
    }

    public String ey() {
        return this.gv;
    }

    public void k(String str) {
        this.gv = str;
    }

    public long qr() {
        return this.qy;
    }

    public void tc(long j) {
        this.qy = j;
    }

    public void mk(long j) {
        this.xp = j;
    }

    public void mq(long j) {
        this.to = j;
    }

    public JSONObject ar() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.an);
            jSONObject.put("mExtValue", this.h);
            jSONObject.put("mLogExtra", this.gb);
            jSONObject.put("mDownloadStatus", this.tt);
            jSONObject.put("mPackageName", this.tc);
            jSONObject.put("mIsAd", this.sy);
            jSONObject.put("mTimeStamp", this.de);
            jSONObject.put("mExtras", this.v);
            jSONObject.put("mVersionCode", this.w);
            jSONObject.put("mVersionName", this.yo);
            jSONObject.put("mDownloadId", this.np);
            jSONObject.put("mIsV3Event", this.nv);
            jSONObject.put("mScene", this.wl);
            jSONObject.put("mEventTag", this.dc);
            jSONObject.put("mEventRefer", this.tr);
            jSONObject.put("mDownloadUrl", this.mk);
            jSONObject.put("mEnableBackDialog", this.yi);
            jSONObject.put("hasSendInstallFinish", this.b.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.c.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.u.get());
            jSONObject.put("mLastFailedErrCode", this.z);
            jSONObject.put("mLastFailedErrMsg", this.fs);
            jSONObject.put("mOpenUrl", this.mq);
            jSONObject.put("mLinkMode", this.e);
            jSONObject.put("mDownloadMode", this.cb);
            jSONObject.put("mModelType", this.k);
            jSONObject.put("mAppName", this.rf);
            jSONObject.put("mAppIcon", this.jh);
            jSONObject.put("mDownloadFailedTimes", this.he);
            long j = this.zw;
            if (j == 0) {
                j = this.de;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.vv);
            jSONObject.put("mJumpInstallTime", this.j);
            jSONObject.put("mCancelInstallTime", this.s);
            jSONObject.put("mLastFailedResumeCount", this.us);
            jSONObject.put("mIsUpdateDownload", this.ba);
            jSONObject.put("mOriginMimeType", this.mt);
            jSONObject.put("mIsPatchApplyHandled", this.r);
            jSONObject.put("downloadFinishReason", this.ra);
            jSONObject.put("clickDownloadTime", this.ru);
            jSONObject.put("clickDownloadSize", this.yn);
            jSONObject.put("installAfterCleanSpace", this.y);
            jSONObject.put("funnelType", this.q);
            jSONObject.put("webUrl", this.uo);
            jSONObject.put("enableShowComplianceDialog", this.l);
            jSONObject.put("isAutoDownloadOnCardShow", this.fu);
            int i = 1;
            jSONObject.put("enable_new_activity", this.hv ? 1 : 0);
            jSONObject.put("enable_pause", this.bc ? 1 : 0);
            jSONObject.put("enable_ah", this.d ? 1 : 0);
            if (!this.hc) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.ph));
            jSONObject.put("task_key", this.gv);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.qy));
            jSONObject.putOpt("download_pause_timestamp", Long.valueOf(this.xp));
            jSONObject.putOpt("download_finish_timestamp", Long.valueOf(this.to));
        } catch (Exception e) {
            mq.jh().d(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public static hc hc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hc hcVar = new hc();
        try {
            hcVar.c(com.ss.android.d.d.an.hc.d(jSONObject, "mId"));
            hcVar.u(com.ss.android.d.d.an.hc.d(jSONObject, "mExtValue"));
            hcVar.b(jSONObject.optString("mLogExtra"));
            hcVar.u(jSONObject.optInt("mDownloadStatus"));
            hcVar.hc(jSONObject.optString("mPackageName"));
            boolean z = true;
            hcVar.d(jSONObject.optBoolean("mIsAd", true));
            hcVar.an(com.ss.android.d.d.an.hc.d(jSONObject, "mTimeStamp"));
            hcVar.an(jSONObject.optInt("mVersionCode"));
            hcVar.c(jSONObject.optString("mVersionName"));
            hcVar.h(jSONObject.optInt("mDownloadId"));
            hcVar.hc(jSONObject.optBoolean("mIsV3Event"));
            hcVar.gb(jSONObject.optInt("mScene"));
            hcVar.an(jSONObject.optString("mEventTag"));
            hcVar.h(jSONObject.optString("mEventRefer"));
            hcVar.gb(jSONObject.optString("mDownloadUrl"));
            hcVar.b(jSONObject.optBoolean("mEnableBackDialog"));
            hcVar.b.set(jSONObject.optBoolean("hasSendInstallFinish"));
            hcVar.c.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            hcVar.u.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            hcVar.c(jSONObject.optInt("mLastFailedErrCode"));
            hcVar.d(jSONObject.optString("mLastFailedErrMsg"));
            hcVar.tt(jSONObject.optString("mOpenUrl"));
            hcVar.tc(jSONObject.optInt("mLinkMode"));
            hcVar.mk(jSONObject.optInt("mDownloadMode"));
            hcVar.mq(jSONObject.optInt("mModelType"));
            hcVar.tc(jSONObject.optString("mAppName"));
            hcVar.mk(jSONObject.optString("mAppIcon"));
            hcVar.d(jSONObject.optInt("mDownloadFailedTimes", 0));
            hcVar.d(com.ss.android.d.d.an.hc.d(jSONObject, "mRecentDownloadResumeTime"));
            hcVar.hc(jSONObject.optInt("mClickPauseTimes"));
            hcVar.hc(com.ss.android.d.d.an.hc.d(jSONObject, "mJumpInstallTime"));
            hcVar.b(com.ss.android.d.d.an.hc.d(jSONObject, "mCancelInstallTime"));
            hcVar.b(jSONObject.optInt("mLastFailedResumeCount"));
            hcVar.mq(jSONObject.optString("downloadFinishReason"));
            hcVar.tt(jSONObject.optLong("clickDownloadSize"));
            hcVar.gb(jSONObject.optLong("clickDownloadTime"));
            hcVar.gb(jSONObject.optBoolean("mIsUpdateDownload"));
            hcVar.uo(jSONObject.optString("mOriginMimeType"));
            hcVar.tt(jSONObject.optBoolean("mIsPatchApplyHandled"));
            hcVar.an(jSONObject.optBoolean("installAfterCleanSpace"));
            hcVar.tt(jSONObject.optInt("funnelType", 1));
            hcVar.u(jSONObject.optString("webUrl"));
            hcVar.cb(jSONObject.optBoolean("enableShowComplianceDialog", true));
            hcVar.w(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            hcVar.yo(jSONObject.optInt("enable_new_activity", 1) == 1);
            hcVar.rf(jSONObject.optInt("enable_pause", 1) == 1);
            hcVar.jh(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            hcVar.sy(z);
            hcVar.d(jSONObject.optJSONObject("mExtras"));
            hcVar.de(jSONObject.optBoolean("intent_jump_browser_success"));
            hcVar.k(jSONObject.optString("task_key"));
            hcVar.tc(jSONObject.optLong("market_install_finish_check_start_timestamp"));
            hcVar.mk(jSONObject.optLong("download_pause_timestamp", 0L));
            hcVar.mq(jSONObject.optLong("download_finish_timestamp", 0L));
        } catch (Exception e) {
            mq.jh().d(e, "NativeDownloadModel fromJson");
        }
        return hcVar;
    }

    @Override // com.ss.android.hc.d.hc.d
    public b sy() {
        return t();
    }

    @Override // com.ss.android.hc.d.hc.d
    public com.ss.android.d.d.b.hc de() {
        return ph();
    }

    @Override // com.ss.android.hc.d.hc.d
    public com.ss.android.d.d.b.d v() {
        return gv();
    }

    public com.ss.android.hc.d.d.b t() {
        return new b.d().hc(this.an).c(this.h).hc(this.gb).b(this.tc).d(this.v).d(this.sy).hc(this.w).mk(this.yo).u(this.mk).d(this.k).gb(this.mt).h(this.rf).c(this.jh).k(this.gv).d(new com.ss.android.d.d.u.hc(this.mq, this.uo, null)).d();
    }

    public com.ss.android.hc.d.d.hc ph() {
        return new hc.d().d(this.dc).tc(this.tr).b(this.nv).d();
    }

    public com.ss.android.hc.d.d.d gv() {
        return new d.C0761d().d(this.yi).d(this.e).hc(this.cb).u(this.l).gb(this.d).tt(this.hc).d();
    }
}
