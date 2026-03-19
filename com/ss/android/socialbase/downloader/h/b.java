package com.ss.android.socialbase.downloader.h;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.l.a;
import com.bytedance.sdk.component.utils.mq;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.ss.android.socialbase.downloader.hc.tt;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.socialbase.downloader.h.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    private String an;
    private long ar;
    private String b;
    private boolean ba;
    private boolean bc;
    private String c;
    private boolean cb;
    private String cj;
    private int d;
    private boolean dc;
    private boolean de;
    private long dz;
    private boolean e;
    private JSONObject ec;
    private int ed;
    private SoftReference<PackageInfo> el;
    private boolean ey;
    private volatile boolean f;
    private tt fs;
    private boolean fu;
    private List<String> fv;
    private boolean fy;
    private String gb;
    private String gu;
    private long gv;
    private int gw;
    private boolean h;
    private String hc;
    private AtomicLong he;
    private boolean hg;
    private com.ss.android.socialbase.downloader.u.d ho;
    private boolean hr;
    private boolean hv;
    private boolean i;
    private int ia;

    @Deprecated
    private int ic;
    private boolean j;
    private boolean jh;
    private JSONObject jm;
    private String js;
    private int k;
    private com.ss.android.socialbase.downloader.hc.h kb;
    private boolean l;
    private ConcurrentHashMap<String, Object> lv;
    private String mb;
    private String[] mk;
    private int[] mq;
    private com.ss.android.socialbase.downloader.hc.d mt;
    private StringBuffer nf;
    private long nk;
    private String np;
    private AtomicInteger nr;
    private String nv;
    private AtomicLong nw;
    private AtomicLong o;
    private boolean oc;
    private Boolean om;
    private boolean ox;
    private boolean p;
    private boolean ph;
    private com.ss.android.socialbase.downloader.hc.hc pq;
    private int[] q;
    private long qr;
    private long qy;
    private boolean r;
    private int ra;
    private List<String> rf;
    private int rs;
    private boolean ru;
    private int rw;
    private boolean s;
    private String sy;
    private boolean t;
    private int tc;
    private long tj;
    private String to;
    private String tr;
    private List<u> tt;
    private String u;
    private boolean um;
    private int uo;
    private String us;
    private String v;
    private boolean vv;
    private int w;
    private int wb;
    private String wl;
    private boolean xp;
    private boolean y;
    private String yi;
    private boolean yn;
    private int yo;
    private int z;
    private boolean zk;
    private boolean zv;
    private String zw;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean ho() {
        return false;
    }

    public b() {
        this.j = true;
        this.fs = tt.DELAY_RETRY_NONE;
        this.ba = false;
        this.mt = com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_NONE;
        this.dc = true;
        this.y = true;
        this.ru = false;
        this.yn = false;
        this.l = false;
        this.ia = 1;
        this.i = true;
        this.ey = true;
        this.pq = com.ss.android.socialbase.downloader.hc.hc.BYTE_INVALID_RETRY_STATUS_NONE;
        this.kb = com.ss.android.socialbase.downloader.hc.h.ENQUEUE_NONE;
        this.o = new AtomicLong(0L);
        this.om = null;
    }

    private b(d dVar) {
        this.j = true;
        this.fs = tt.DELAY_RETRY_NONE;
        this.ba = false;
        this.mt = com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_NONE;
        this.dc = true;
        this.y = true;
        this.ru = false;
        this.yn = false;
        this.l = false;
        this.ia = 1;
        this.i = true;
        this.ey = true;
        this.pq = com.ss.android.socialbase.downloader.hc.hc.BYTE_INVALID_RETRY_STATUS_NONE;
        this.kb = com.ss.android.socialbase.downloader.hc.h.ENQUEUE_NONE;
        this.o = new AtomicLong(0L);
        this.om = null;
        if (dVar == null) {
            return;
        }
        this.hc = dVar.d;
        this.b = dVar.hc;
        this.c = dVar.b;
        String strU = dVar.c;
        if (TextUtils.isEmpty(strU)) {
            try {
                strU = com.ss.android.socialbase.downloader.e.an.u();
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        this.u = strU;
        String str = dVar.u;
        this.an = str;
        if (TextUtils.isEmpty(str) && !com.ss.android.socialbase.downloader.e.an.gb(strU)) {
            this.an = com.ss.android.socialbase.downloader.e.an.an();
        }
        d("task_key", (Object) dVar.ra);
        if (dVar.to) {
            if (com.ss.android.socialbase.downloader.downloader.b.np().hc(h()) == null) {
                this.u = com.ss.android.socialbase.downloader.e.an.u(this.u, this.c);
                this.an = com.ss.android.socialbase.downloader.e.an.u(this.an, this.c);
            }
        } else {
            com.ss.android.socialbase.downloader.an.d.u("DownloadInfo", "The distinct directory option is not set, which may cause 1005 problems and file downloads being covered");
        }
        this.nr = new AtomicInteger(0);
        this.nw = new AtomicLong(0L);
        this.gb = dVar.h;
        this.h = dVar.an;
        this.tt = dVar.gb;
        this.tc = dVar.tt;
        this.uo = dVar.mq;
        this.k = dVar.uo;
        this.e = dVar.k;
        this.mk = dVar.tc;
        this.mq = dVar.mk;
        this.cb = dVar.e;
        this.w = dVar.cb;
        this.yo = dVar.w;
        this.rf = dVar.yo;
        this.jh = dVar.rf;
        this.sy = dVar.sy;
        this.de = dVar.de;
        this.vv = dVar.s;
        this.zw = dVar.us;
        this.fy = dVar.v;
        this.zv = dVar.np;
        this.j = dVar.yi;
        this.s = dVar.he;
        this.v = dVar.vv;
        this.yi = dVar.zw;
        this.ba = dVar.z;
        this.bc = dVar.fs;
        this.kb = dVar.ba;
        this.r = dVar.mt;
        this.hv = dVar.r;
        this.p = dVar.nv;
        this.hr = dVar.hv;
        this.tr = dVar.bc;
        this.tj = dVar.dc;
        this.ox = dVar.tr;
        JSONObject jSONObject = dVar.y;
        if (jSONObject != null) {
            d("download_setting", (Object) jSONObject.toString());
        }
        d("dbjson_key_expect_file_length", Long.valueOf(dVar.j));
        d("executor_group", Integer.valueOf(dVar.yn));
        d("auto_install", Integer.valueOf(dVar.jh ? 1 : 0));
        this.y = dVar.wl;
        this.wl = dVar.q;
        this.q = dVar.ru;
        this.ru = dVar.l;
        this.yn = dVar.fu;
        this.nk = dVar.xp;
        this.fu = dVar.to;
        if (this.ru && this.uo <= 0) {
            this.uo = 1;
        }
        pk();
    }

    public void d(boolean z) {
        this.p = z;
    }

    private void pk() {
        d("need_sdk_monitor", Boolean.valueOf(this.y));
        d("monitor_scene", this.wl);
        try {
            JSONArray jSONArray = new JSONArray();
            int[] iArr = this.q;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.q;
                    if (i >= iArr2.length) {
                        break;
                    }
                    jSONArray.put(iArr2[i]);
                    i++;
                }
            }
            d("extra_monitor_status", jSONArray);
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private void jw() {
        bk();
        this.y = this.jm.optBoolean("need_sdk_monitor", false);
        this.wl = this.jm.optString("monitor_scene", "");
        JSONArray jSONArrayOptJSONArray = this.jm.optJSONArray("extra_monitor_status");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        this.q = new int[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            this.q[i] = jSONArrayOptJSONArray.optInt(i);
        }
    }

    public void d(Parcel parcel) {
        this.d = parcel.readInt();
        this.hc = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.u = parcel.readString();
        this.an = parcel.readString();
        this.h = parcel.readByte() != 0;
        this.gb = parcel.readString();
        this.tt = parcel.createTypedArrayList(u.CREATOR);
        this.tc = parcel.readInt();
        this.mk = parcel.createStringArray();
        this.mq = parcel.createIntArray();
        this.uo = parcel.readInt();
        this.k = parcel.readInt();
        this.e = parcel.readByte() != 0;
        this.cb = parcel.readByte() != 0;
        this.w = parcel.readInt();
        this.yo = parcel.readInt();
        this.rf = parcel.createStringArrayList();
        this.jh = parcel.readByte() != 0;
        this.sy = parcel.readString();
        this.de = parcel.readByte() != 0;
        this.v = parcel.readString();
        this.yi = parcel.readString();
        this.vv = parcel.readByte() != 0;
        this.j = parcel.readByte() != 0;
        this.s = parcel.readByte() != 0;
        this.zw = parcel.readString();
        this.us = parcel.readString();
        this.z = parcel.readInt();
        rf(parcel.readInt());
        this.ba = parcel.readByte() != 0;
        this.xp = parcel.readByte() != 0;
        this.to = parcel.readString();
        this.ra = parcel.readInt();
        this.rw = parcel.readInt();
        this.ia = parcel.readInt();
        u(parcel.readLong());
        this.dz = parcel.readLong();
        c(parcel.readInt());
        this.qr = parcel.readLong();
        this.ar = parcel.readLong();
        this.t = parcel.readByte() != 0;
        this.ph = parcel.readByte() != 0;
        try {
            StringBuffer stringBuffer = this.nf;
            if (stringBuffer == null) {
                this.nf = new StringBuffer(parcel.readString());
            } else {
                stringBuffer.delete(0, stringBuffer.length()).append(parcel.readString());
            }
        } catch (Exception e) {
            mq.d(e);
        }
        this.fy = parcel.readByte() != 0;
        this.zv = parcel.readByte() != 0;
        this.um = parcel.readByte() != 0;
        this.fv = parcel.createStringArrayList();
        this.bc = parcel.readByte() != 0;
        yo(parcel.readInt());
        this.r = parcel.readByte() != 0;
        this.wb = parcel.readInt();
        this.mb = parcel.readString();
        this.f = parcel.readByte() != 0;
        this.oc = parcel.readByte() != 0;
        this.p = parcel.readByte() != 0;
        this.hr = parcel.readByte() != 0;
        this.hg = parcel.readByte() != 0;
        this.ho = (com.ss.android.socialbase.downloader.u.d) parcel.readParcelable(com.ss.android.socialbase.downloader.u.d.class.getClassLoader());
        this.ic = parcel.readInt();
        this.cj = parcel.readString();
        this.dc = parcel.readByte() != 0;
        this.tr = parcel.readString();
        this.rs = parcel.readInt();
        this.nv = parcel.readString();
        this.ru = parcel.readByte() != 0;
        this.yn = parcel.readByte() != 0;
        this.l = parcel.readByte() != 0;
        jw();
    }

    private String le() {
        List<String> list;
        if (this.gu == null && (list = this.rf) != null && !list.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.rf) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                this.gu = jSONArray.toString();
            } catch (Exception e) {
                mq.d(e);
            }
        }
        if (this.gu == null) {
            this.gu = "";
        }
        return this.gu;
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str) || w() == -3) {
            return;
        }
        this.gu = str;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String strOptString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(strOptString);
                    }
                }
                this.rf = arrayList;
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public boolean d() {
        long j = this.o.get();
        return j == 0 || SystemClock.uptimeMillis() - j > 20;
    }

    public void hc() {
        this.o.set(SystemClock.uptimeMillis());
    }

    public String b() {
        return this.js;
    }

    public void d(String str) {
        this.js = str;
    }

    protected b(Parcel parcel) {
        this.j = true;
        this.fs = tt.DELAY_RETRY_NONE;
        this.ba = false;
        this.mt = com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_NONE;
        this.dc = true;
        this.y = true;
        this.ru = false;
        this.yn = false;
        this.l = false;
        this.ia = 1;
        this.i = true;
        this.ey = true;
        this.pq = com.ss.android.socialbase.downloader.hc.hc.BYTE_INVALID_RETRY_STATUS_NONE;
        this.kb = com.ss.android.socialbase.downloader.hc.h.ENQUEUE_NONE;
        this.o = new AtomicLong(0L);
        this.om = null;
        d(parcel);
    }

    private void yo(int i) {
        if (i == com.ss.android.socialbase.downloader.hc.h.ENQUEUE_HEAD.ordinal()) {
            this.kb = com.ss.android.socialbase.downloader.hc.h.ENQUEUE_HEAD;
        } else if (i == com.ss.android.socialbase.downloader.hc.h.ENQUEUE_TAIL.ordinal()) {
            this.kb = com.ss.android.socialbase.downloader.hc.h.ENQUEUE_TAIL;
        } else {
            this.kb = com.ss.android.socialbase.downloader.hc.h.ENQUEUE_NONE;
        }
    }

    private void rf(int i) {
        if (i == tt.DELAY_RETRY_WAITING.ordinal()) {
            this.fs = tt.DELAY_RETRY_WAITING;
            return;
        }
        if (i == tt.DELAY_RETRY_DOWNLOADING.ordinal()) {
            this.fs = tt.DELAY_RETRY_DOWNLOADING;
        } else if (i == tt.DELAY_RETRY_DOWNLOADED.ordinal()) {
            this.fs = tt.DELAY_RETRY_DOWNLOADED;
        } else {
            this.fs = tt.DELAY_RETRY_NONE;
        }
    }

    public String c() {
        StringBuffer stringBuffer = this.nf;
        return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.nf.toString();
    }

    public b(Cursor cursor) {
        boolean z = true;
        this.j = true;
        this.fs = tt.DELAY_RETRY_NONE;
        this.ba = false;
        this.mt = com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_NONE;
        this.dc = true;
        this.y = true;
        this.ru = false;
        this.yn = false;
        this.l = false;
        this.ia = 1;
        this.i = true;
        this.ey = true;
        this.pq = com.ss.android.socialbase.downloader.hc.hc.BYTE_INVALID_RETRY_STATUS_NONE;
        this.kb = com.ss.android.socialbase.downloader.hc.h.ENQUEUE_NONE;
        this.o = new AtomicLong(0L);
        this.om = null;
        if (cursor == null) {
            return;
        }
        try {
            int columnIndex = cursor.getColumnIndex("_id");
            if (columnIndex != -1) {
                this.d = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("name");
            if (columnIndex2 != -1) {
                this.hc = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("title");
            if (columnIndex3 != -1) {
                this.b = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("url");
            if (columnIndex4 != -1) {
                this.c = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("savePath");
            if (columnIndex5 != -1) {
                this.u = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("tempPath");
            if (columnIndex6 != -1) {
                this.an = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("chunkCount");
            if (columnIndex7 != -1) {
                this.ia = cursor.getInt(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex("status");
            if (columnIndex8 != -1) {
                this.nr = new AtomicInteger(cursor.getInt(columnIndex8));
            } else {
                this.nr = new AtomicInteger(0);
            }
            int columnIndex9 = cursor.getColumnIndex("curBytes");
            if (columnIndex9 != -1) {
                this.nw = new AtomicLong(cursor.getLong(columnIndex9));
            } else {
                this.nw = new AtomicLong(0L);
            }
            int columnIndex10 = cursor.getColumnIndex("totalBytes");
            if (columnIndex10 != -1) {
                this.dz = cursor.getLong(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("eTag");
            if (columnIndex11 != -1) {
                this.us = cursor.getString(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("onlyWifi");
            if (columnIndex12 != -1) {
                this.h = cursor.getInt(columnIndex12) != 0;
            }
            int columnIndex13 = cursor.getColumnIndex("force");
            if (columnIndex13 != -1) {
                this.e = cursor.getInt(columnIndex13) != 0;
            }
            int columnIndex14 = cursor.getColumnIndex("retryCount");
            if (columnIndex14 != -1) {
                this.uo = cursor.getInt(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex("extra");
            if (columnIndex15 != -1) {
                this.gb = cursor.getString(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("mimeType");
            if (columnIndex16 != -1) {
                this.sy = cursor.getString(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex("notificationEnable");
            if (columnIndex17 != -1) {
                this.jh = cursor.getInt(columnIndex17) != 0;
            }
            int columnIndex18 = cursor.getColumnIndex("notificationVisibility");
            if (columnIndex18 != -1) {
                this.rw = cursor.getInt(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex("isFirstDownload");
            if (columnIndex19 != -1) {
                this.i = cursor.getInt(columnIndex19) == 1;
            }
            int columnIndex20 = cursor.getColumnIndex("isFirstSuccess");
            if (columnIndex20 != -1) {
                this.ey = cursor.getInt(columnIndex20) == 1;
            }
            int columnIndex21 = cursor.getColumnIndex("needHttpsToHttpRetry");
            if (columnIndex21 != -1) {
                this.de = cursor.getInt(columnIndex21) == 1;
            }
            int columnIndex22 = cursor.getColumnIndex("downloadTime");
            if (columnIndex22 != -1) {
                this.qr = cursor.getLong(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex("packageName");
            if (columnIndex23 != -1) {
                this.v = cursor.getString(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
            if (columnIndex24 != -1) {
                this.yi = cursor.getString(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex("retryDelay");
            if (columnIndex25 != -1) {
                this.vv = cursor.getInt(columnIndex25) == 1;
            }
            int columnIndex26 = cursor.getColumnIndex("curRetryTime");
            if (columnIndex26 != -1) {
                this.z = cursor.getInt(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex("retryDelayStatus");
            if (columnIndex27 != -1) {
                int i = cursor.getInt(columnIndex27);
                if (i == tt.DELAY_RETRY_WAITING.ordinal()) {
                    this.fs = tt.DELAY_RETRY_WAITING;
                } else if (i == tt.DELAY_RETRY_DOWNLOADING.ordinal()) {
                    this.fs = tt.DELAY_RETRY_DOWNLOADING;
                } else if (i == tt.DELAY_RETRY_DOWNLOADED.ordinal()) {
                    this.fs = tt.DELAY_RETRY_DOWNLOADED;
                } else {
                    this.fs = tt.DELAY_RETRY_NONE;
                }
            }
            int columnIndex28 = cursor.getColumnIndex("defaultHttpServiceBackUp");
            if (columnIndex28 != -1) {
                this.j = cursor.getInt(columnIndex28) == 1;
            }
            int columnIndex29 = cursor.getColumnIndex("chunkRunnableReuse");
            if (columnIndex29 != -1) {
                this.s = cursor.getInt(columnIndex29) == 1;
            }
            int columnIndex30 = cursor.getColumnIndex("retryDelayTimeArray");
            if (columnIndex30 != -1) {
                this.zw = cursor.getString(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex("chunkDowngradeRetry");
            if (columnIndex31 != -1) {
                this.hr = cursor.getInt(columnIndex31) == 1;
            }
            int columnIndex32 = cursor.getColumnIndex("backUpUrlsStr");
            if (columnIndex32 != -1) {
                e(cursor.getString(columnIndex32));
            }
            int columnIndex33 = cursor.getColumnIndex("backUpUrlRetryCount");
            if (columnIndex33 != -1) {
                this.k = cursor.getInt(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex("realDownloadTime");
            if (columnIndex34 != -1) {
                this.ar = cursor.getLong(columnIndex34);
            }
            int columnIndex35 = cursor.getColumnIndex("retryScheduleMinutes");
            if (columnIndex35 != -1) {
                this.ic = cursor.getInt(columnIndex35);
            }
            int columnIndex36 = cursor.getColumnIndex("independentProcess");
            if (columnIndex36 != -1) {
                if (cursor.getInt(columnIndex36) != 1) {
                    z = false;
                }
                this.bc = z;
            }
            int columnIndex37 = cursor.getColumnIndex("auxiliaryJsonobjectString");
            if (columnIndex37 != -1) {
                this.cj = cursor.getString(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex("iconUrl");
            if (columnIndex38 != -1) {
                this.tr = cursor.getString(columnIndex38);
            }
            int columnIndex39 = cursor.getColumnIndex("appVersionCode");
            if (columnIndex39 != -1) {
                this.rs = cursor.getInt(columnIndex39);
            }
            int columnIndex40 = cursor.getColumnIndex("taskId");
            if (columnIndex40 != -1) {
                this.nv = cursor.getString(columnIndex40);
            }
            jw();
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public ContentValues u() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.d));
        contentValues.put("url", this.c);
        contentValues.put("savePath", this.u);
        contentValues.put("tempPath", this.an);
        contentValues.put("name", this.hc);
        contentValues.put("chunkCount", Integer.valueOf(this.ia));
        contentValues.put("status", Integer.valueOf(w()));
        contentValues.put("curBytes", Long.valueOf(js()));
        contentValues.put("totalBytes", Long.valueOf(this.dz));
        contentValues.put("eTag", this.us);
        contentValues.put("onlyWifi", Integer.valueOf(this.h ? 1 : 0));
        contentValues.put("force", Integer.valueOf(this.e ? 1 : 0));
        contentValues.put("retryCount", Integer.valueOf(this.uo));
        contentValues.put("extra", this.gb);
        contentValues.put("mimeType", this.sy);
        contentValues.put("title", this.b);
        contentValues.put("notificationEnable", Integer.valueOf(this.jh ? 1 : 0));
        contentValues.put("notificationVisibility", Integer.valueOf(this.rw));
        contentValues.put("isFirstDownload", Integer.valueOf(this.i ? 1 : 0));
        contentValues.put("isFirstSuccess", Integer.valueOf(this.ey ? 1 : 0));
        contentValues.put("needHttpsToHttpRetry", Integer.valueOf(this.de ? 1 : 0));
        contentValues.put("downloadTime", Long.valueOf(this.qr));
        contentValues.put("packageName", this.v);
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, this.yi);
        contentValues.put("retryDelay", Integer.valueOf(this.vv ? 1 : 0));
        contentValues.put("curRetryTime", Integer.valueOf(this.z));
        contentValues.put("retryDelayStatus", Integer.valueOf(this.fs.ordinal()));
        contentValues.put("defaultHttpServiceBackUp", Integer.valueOf(this.j ? 1 : 0));
        contentValues.put("chunkRunnableReuse", Integer.valueOf(this.s ? 1 : 0));
        contentValues.put("retryDelayTimeArray", this.zw);
        contentValues.put("chunkDowngradeRetry", Integer.valueOf(this.hr ? 1 : 0));
        contentValues.put("backUpUrlsStr", le());
        contentValues.put("backUpUrlRetryCount", Integer.valueOf(this.k));
        contentValues.put("realDownloadTime", Long.valueOf(this.ar));
        contentValues.put("retryScheduleMinutes", Integer.valueOf(this.ic));
        contentValues.put("independentProcess", Integer.valueOf(this.bc ? 1 : 0));
        contentValues.put("auxiliaryJsonobjectString", re());
        contentValues.put("iconUrl", this.tr);
        contentValues.put("appVersionCode", Integer.valueOf(this.rs));
        contentValues.put("taskId", this.nv);
        return contentValues;
    }

    private String re() {
        String string;
        String str = this.cj;
        if (str != null) {
            return str;
        }
        bk();
        synchronized (this.jm) {
            string = this.jm.toString();
            this.cj = string;
        }
        return string;
    }

    public void d(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.gw = 0;
        sQLiteStatement.clearBindings();
        int i = this.gw + 1;
        this.gw = i;
        sQLiteStatement.bindLong(i, this.d);
        int i2 = this.gw + 1;
        this.gw = i2;
        String str = this.c;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(i2, str);
        int i3 = this.gw + 1;
        this.gw = i3;
        String str2 = this.u;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(i3, str2);
        int i4 = this.gw + 1;
        this.gw = i4;
        String str3 = this.an;
        if (str3 == null) {
            str3 = "";
        }
        sQLiteStatement.bindString(i4, str3);
        int i5 = this.gw + 1;
        this.gw = i5;
        String str4 = this.hc;
        if (str4 == null) {
            str4 = "";
        }
        sQLiteStatement.bindString(i5, str4);
        int i6 = this.gw + 1;
        this.gw = i6;
        sQLiteStatement.bindLong(i6, this.ia);
        int i7 = this.gw + 1;
        this.gw = i7;
        sQLiteStatement.bindLong(i7, w());
        int i8 = this.gw + 1;
        this.gw = i8;
        sQLiteStatement.bindLong(i8, js());
        int i9 = this.gw + 1;
        this.gw = i9;
        sQLiteStatement.bindLong(i9, this.dz);
        int i10 = this.gw + 1;
        this.gw = i10;
        String str5 = this.us;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(i10, str5);
        int i11 = this.gw + 1;
        this.gw = i11;
        sQLiteStatement.bindLong(i11, this.h ? 1L : 0L);
        int i12 = this.gw + 1;
        this.gw = i12;
        sQLiteStatement.bindLong(i12, this.e ? 1L : 0L);
        int i13 = this.gw + 1;
        this.gw = i13;
        sQLiteStatement.bindLong(i13, this.uo);
        int i14 = this.gw + 1;
        this.gw = i14;
        String str6 = this.gb;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement.bindString(i14, str6);
        int i15 = this.gw + 1;
        this.gw = i15;
        String str7 = this.sy;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement.bindString(i15, str7);
        int i16 = this.gw + 1;
        this.gw = i16;
        String str8 = this.b;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement.bindString(i16, str8);
        int i17 = this.gw + 1;
        this.gw = i17;
        sQLiteStatement.bindLong(i17, this.jh ? 1L : 0L);
        int i18 = this.gw + 1;
        this.gw = i18;
        sQLiteStatement.bindLong(i18, this.rw);
        int i19 = this.gw + 1;
        this.gw = i19;
        sQLiteStatement.bindLong(i19, this.i ? 1L : 0L);
        int i20 = this.gw + 1;
        this.gw = i20;
        sQLiteStatement.bindLong(i20, this.ey ? 1L : 0L);
        int i21 = this.gw + 1;
        this.gw = i21;
        sQLiteStatement.bindLong(i21, this.de ? 1L : 0L);
        int i22 = this.gw + 1;
        this.gw = i22;
        sQLiteStatement.bindLong(i22, this.qr);
        int i23 = this.gw + 1;
        this.gw = i23;
        String str9 = this.v;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement.bindString(i23, str9);
        int i24 = this.gw + 1;
        this.gw = i24;
        String str10 = this.yi;
        if (str10 == null) {
            str10 = "";
        }
        sQLiteStatement.bindString(i24, str10);
        int i25 = this.gw + 1;
        this.gw = i25;
        sQLiteStatement.bindLong(i25, this.vv ? 1L : 0L);
        int i26 = this.gw + 1;
        this.gw = i26;
        sQLiteStatement.bindLong(i26, this.z);
        int i27 = this.gw + 1;
        this.gw = i27;
        sQLiteStatement.bindLong(i27, this.fs.ordinal());
        int i28 = this.gw + 1;
        this.gw = i28;
        sQLiteStatement.bindLong(i28, this.j ? 1L : 0L);
        int i29 = this.gw + 1;
        this.gw = i29;
        sQLiteStatement.bindLong(i29, this.s ? 1L : 0L);
        int i30 = this.gw + 1;
        this.gw = i30;
        String str11 = this.zw;
        if (str11 == null) {
            str11 = "";
        }
        sQLiteStatement.bindString(i30, str11);
        int i31 = this.gw + 1;
        this.gw = i31;
        sQLiteStatement.bindLong(i31, this.hr ? 1L : 0L);
        int i32 = this.gw + 1;
        this.gw = i32;
        sQLiteStatement.bindString(i32, le());
        int i33 = this.gw + 1;
        this.gw = i33;
        sQLiteStatement.bindLong(i33, this.k);
        int i34 = this.gw + 1;
        this.gw = i34;
        sQLiteStatement.bindLong(i34, this.ar);
        int i35 = this.gw + 1;
        this.gw = i35;
        sQLiteStatement.bindLong(i35, this.ic);
        int i36 = this.gw + 1;
        this.gw = i36;
        sQLiteStatement.bindLong(i36, this.bc ? 1L : 0L);
        int i37 = this.gw + 1;
        this.gw = i37;
        sQLiteStatement.bindString(i37, re());
        int i38 = this.gw + 1;
        this.gw = i38;
        String str12 = this.tr;
        if (str12 == null) {
            str12 = "";
        }
        sQLiteStatement.bindString(i38, str12);
        int i39 = this.gw + 1;
        this.gw = i39;
        sQLiteStatement.bindLong(i39, this.rs);
        int i40 = this.gw + 1;
        this.gw = i40;
        String str13 = this.nv;
        sQLiteStatement.bindString(i40, str13 != null ? str13 : "");
    }

    public int an() {
        return this.gw;
    }

    public int h() {
        if (this.d == 0) {
            this.d = com.ss.android.socialbase.downloader.downloader.b.d(this);
        }
        return this.d;
    }

    public String gb() {
        return this.hc;
    }

    public String tt() {
        if (TextUtils.isEmpty(this.b)) {
            return this.hc;
        }
        return this.b;
    }

    public String tc() {
        return this.c;
    }

    public String mk() {
        return this.u;
    }

    public String mq() {
        return com.ss.android.socialbase.downloader.e.an.hc(this.u, this.an);
    }

    public String uo() {
        return com.ss.android.socialbase.downloader.e.an.b(this.hc);
    }

    public String k() {
        return com.ss.android.socialbase.downloader.e.an.d(this.u, this.hc);
    }

    public boolean e() {
        return this.j;
    }

    public boolean cb() {
        return this.s;
    }

    public int w() {
        AtomicInteger atomicInteger = this.nr;
        if (atomicInteger == null) {
            return 0;
        }
        int i = atomicInteger.get();
        if (i == -5) {
            return -2;
        }
        return i;
    }

    public com.ss.android.socialbase.downloader.hc.h yo() {
        return this.kb;
    }

    public int rf() {
        return this.ra;
    }

    public boolean jh() {
        return this.ph;
    }

    public boolean sy() {
        return this.fy;
    }

    public void hc(boolean z) {
        this.fy = z;
    }

    public boolean de() {
        return this.um;
    }

    public void b(boolean z) {
        this.um = z;
    }

    public int v() {
        AtomicInteger atomicInteger = this.nr;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public boolean np() {
        return this.h;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public long yi() {
        bk();
        return this.jm.optLong("dbjson_key_first_speed_time");
    }

    public void d(long j) {
        d("dbjson_key_first_speed_time", Long.valueOf(j));
    }

    public String he() {
        bk();
        return this.jm.optString("task_key");
    }

    public int vv() {
        bk();
        return this.jm.optInt("ttmd5_check_status", -1);
    }

    public void d(int i) {
        d("ttmd5_check_status", Integer.valueOf(i));
    }

    public long zw() {
        bk();
        if (this.he == null) {
            this.he = new AtomicLong(this.jm.optLong("dbjson_key_all_connect_time"));
        }
        return this.he.get();
    }

    public void hc(long j) {
        if (j > 0) {
            zw();
            d("dbjson_key_all_connect_time", Long.valueOf(this.he.addAndGet(j)));
        }
    }

    public long j() {
        bk();
        return this.jm.optLong("dbjson_key_download_prepare_time");
    }

    public void b(long j) {
        if (j > 0) {
            d("dbjson_key_download_prepare_time", Long.valueOf(j() + j));
        }
    }

    public String s() {
        return this.gb;
    }

    public String us() {
        return this.v;
    }

    public String z() {
        return this.np;
    }

    public void hc(String str) {
        this.np = str;
    }

    public String fs() {
        return this.yi;
    }

    public long ba() {
        bk();
        return this.jm.optLong("dbjson_key_expect_file_length");
    }

    public List<u> mt() {
        return this.tt;
    }

    public int r() {
        return this.tc;
    }

    public int hv() {
        return this.uo;
    }

    public int bc() {
        return this.k;
    }

    public int dc() {
        int i = this.uo;
        List<String> list = this.rf;
        return (list == null || list.isEmpty()) ? i : i + (this.k * this.rf.size());
    }

    public int tr() {
        int i = this.z;
        if (!this.t) {
            return i;
        }
        int i2 = i + this.uo;
        int i3 = this.ra;
        return i3 > 0 ? i2 + (i3 * this.k) : i2;
    }

    public List<String> nv() {
        return this.fv;
    }

    public void d(List<String> list, boolean z) {
        this.fv = list;
        cb(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void cb(boolean z) {
        List<String> list = this.fv;
        if (list == null || list.size() <= z) {
            return;
        }
        List<String> list2 = this.rf;
        if (list2 == null) {
            this.rf = new ArrayList();
        } else {
            list2.clear();
        }
        this.t = false;
        this.ra = 0;
        for (int i = z; i < this.fv.size(); i++) {
            this.rf.add(this.fv.get(i));
        }
    }

    public String y() {
        List<String> list;
        int i;
        List<String> list2;
        String str = this.c;
        if (w() == 8 && (list2 = this.fv) != null && !list2.isEmpty() && !this.t) {
            return this.fv.get(0);
        }
        if (!this.t || (list = this.rf) == null || list.size() <= 0 || (i = this.ra) < 0 || i >= this.rf.size()) {
            return (!TextUtils.isEmpty(this.c) && this.c.startsWith("https") && this.de && this.ph) ? this.c.replaceFirst("https", a.r) : str;
        }
        String str2 = this.rf.get(this.ra);
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public boolean wl() {
        return this.t;
    }

    public void q() {
        this.gv = SystemClock.uptimeMillis();
        d("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
    }

    public void d(String str, Object obj) {
        bk();
        synchronized (this.jm) {
            try {
                this.jm.put(str, obj);
            } catch (Exception unused) {
            }
            this.cj = null;
        }
    }

    public String ru() {
        bk();
        return this.jm.optString("download_setting");
    }

    public int yn() {
        bk();
        return this.jm.optInt("retry_schedule_count", 0);
    }

    public void hc(int i) {
        d("retry_schedule_count", Integer.valueOf(i));
    }

    public boolean l() {
        return this.zk;
    }

    public void u(boolean z) {
        this.zk = z;
    }

    public int fu() {
        bk();
        return this.jm.optInt("link_mode");
    }

    public void b(int i) {
        d("link_mode", Integer.valueOf(i));
    }

    public boolean xp() {
        return (cs() & 2) > 0;
    }

    public boolean to() {
        return (cs() & 1) > 0;
    }

    public boolean ra() {
        return v() == -2 || v() == -5;
    }

    private int cs() {
        ww();
        try {
            return this.ec.optInt("pause_reserve_on_wifi", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void rw() throws JSONException {
        ww();
        try {
            this.ec.put("pause_reserve_on_wifi", 3);
            ri();
        } catch (Exception unused) {
        }
    }

    public void ia() throws JSONException {
        ww();
        try {
            this.ec.put("pause_reserve_on_wifi", 1);
            ri();
        } catch (Exception unused) {
        }
    }

    public void c(long j) throws JSONException {
        ww();
        try {
            this.ec.put("cache-control/expired_time", j);
            ri();
        } catch (Exception unused) {
        }
    }

    public long nw() {
        ww();
        try {
            return this.ec.optLong("cache-control/expired_time", -1L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public void b(String str) throws JSONException {
        ww();
        try {
            this.ec.put("cache-control", str);
            ri();
        } catch (Exception unused) {
        }
    }

    public String dz() {
        ww();
        try {
            return this.ec.optString("cache-control", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public void c(String str) throws JSONException {
        ww();
        try {
            this.ec.put("last-modified", str);
            ri();
        } catch (Exception unused) {
        }
    }

    public String nr() {
        ww();
        try {
            return this.ec.optString("last-modified", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public void an(boolean z) {
        d("rw_concurrent", Integer.valueOf(z ? 1 : 0));
    }

    public boolean i() {
        bk();
        return this.jm.optInt("rw_concurrent", 0) == 1;
    }

    public boolean ey() {
        return this.y;
    }

    public String qr() {
        return this.wl;
    }

    public int[] ar() {
        return this.q;
    }

    public void t() {
        if (this.gv == 0) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.gv;
        if (this.qr < 0) {
            this.qr = 0L;
        }
        if (jUptimeMillis > 0) {
            this.qr = jUptimeMillis;
        }
    }

    public void ph() {
        if (this.qy == 0) {
            this.qy = System.nanoTime();
        }
    }

    public void gv() {
        this.qy = 0L;
    }

    public void h(boolean z) {
        long jNanoTime = System.nanoTime();
        long j = this.qy;
        if (j <= 0) {
            if (z) {
                this.qy = jNanoTime;
                return;
            }
            return;
        }
        long j2 = jNanoTime - j;
        if (z) {
            this.qy = jNanoTime;
        } else {
            this.qy = 0L;
        }
        if (j2 > 0) {
            this.ar += j2;
        }
    }

    public boolean qy() {
        return this.ba;
    }

    public boolean nf() {
        return this.bc;
    }

    public boolean gw() {
        return this.yn;
    }

    public boolean fy() {
        return this.r;
    }

    public boolean zv() {
        return this.hv;
    }

    public boolean um() {
        return this.p;
    }

    public boolean fv() {
        return this.e;
    }

    public boolean pq() {
        if (com.ss.android.socialbase.downloader.uo.d.b().d("force_close_download_cache_check", 0) == 1) {
            com.ss.android.socialbase.downloader.an.d.b("isExpiredRedownload force to false, reason(global setting) id=" + h() + " name=" + gb());
            return false;
        }
        return this.ru;
    }

    public boolean kb() {
        return this.l;
    }

    public void gb(boolean z) {
        this.l = z;
    }

    public long js() {
        AtomicLong atomicLong = this.nw;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public void u(long j) {
        AtomicLong atomicLong = this.nw;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.nw = new AtomicLong(j);
        }
    }

    public void d(long j, boolean z) {
        if (z) {
            u(j);
        } else if (j > js()) {
            u(j);
        }
    }

    public com.ss.android.socialbase.downloader.hc.hc wb() {
        return this.pq;
    }

    public void d(com.ss.android.socialbase.downloader.hc.hc hcVar) {
        this.pq = hcVar;
    }

    public void tt(boolean z) {
        this.i = z;
    }

    public void tc(boolean z) {
        this.ey = z;
    }

    public void an(long j) {
        this.nw.addAndGet(j);
    }

    public void u(String str) {
        this.us = str;
    }

    public void an(String str) {
        this.hc = str;
    }

    public void h(long j) {
        this.dz = j;
    }

    public void c(int i) {
        AtomicInteger atomicInteger = this.nr;
        if (atomicInteger != null) {
            atomicInteger.set(i);
        } else {
            this.nr = new AtomicInteger(i);
        }
    }

    public void mk(boolean z) {
        this.dc = z;
    }

    public void h(String str) {
        this.v = str;
    }

    public long mb() {
        return this.dz;
    }

    public String o() {
        return this.us;
    }

    public String f() {
        return this.to;
    }

    public void gb(String str) {
        this.to = str;
    }

    public void u(int i) {
        this.ia = i;
    }

    public int oc() {
        return this.rw;
    }

    public void an(int i) {
        this.rw = i;
    }

    public void mq(boolean z) {
        this.xp = z;
    }

    public int rs() {
        return this.wb;
    }

    public void h(int i) {
        this.wb = i;
    }

    public void tt(String str) {
        this.mb = str;
    }

    public boolean tj() {
        boolean z = this.fy;
        if (!z && this.jh) {
            return true;
        }
        if (z) {
            return this.zv || this.um;
        }
        return false;
    }

    public boolean ox() {
        return this.jh;
    }

    public boolean p() {
        if (this.om == null) {
            if (!TextUtils.isEmpty(this.gb)) {
                try {
                    this.om = Boolean.valueOf(new JSONObject(this.gb).optBoolean("auto_install_without_notification", false));
                } catch (JSONException unused) {
                }
            } else {
                this.om = Boolean.FALSE;
            }
        }
        return this.om.booleanValue();
    }

    public boolean hr() {
        bk();
        return this.jm.optInt("auto_install", 1) == 1;
    }

    public void tc(String str) {
        this.sy = str;
    }

    public String hg() {
        return this.sy;
    }

    public boolean gu() {
        return this.de;
    }

    public String ic() {
        return this.zw;
    }

    public int ec() {
        return this.z;
    }

    public boolean jm() {
        return this.oc;
    }

    public void cj() {
        this.oc = true;
    }

    public String lv() {
        return this.tr;
    }

    public void gb(int i) {
        this.rs = i;
    }

    public int ed() {
        return this.rs;
    }

    public String zk() {
        return this.nv;
    }

    public void el() {
        this.nv = UUID.randomUUID().toString();
    }

    public boolean nk() {
        return this.hr;
    }

    public boolean om() {
        return this.hg;
    }

    public tt eu() {
        return this.fs;
    }

    public com.ss.android.socialbase.downloader.hc.d qv() {
        return this.mt;
    }

    public boolean xi() {
        int iW = w();
        return iW == 7 || this.fs == tt.DELAY_RETRY_WAITING || iW == 8 || this.mt == com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_WAITING || this.mt == com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_RESTART || this.pq == com.ss.android.socialbase.downloader.hc.hc.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    public void yb() {
        int iW = w();
        if (iW == 7 || this.fs == tt.DELAY_RETRY_WAITING) {
            d(tt.DELAY_RETRY_DOWNLOADING);
        }
        if (iW == 8 || this.mt == com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_WAITING || this.mt == com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_RESTART) {
            d(com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.pq == com.ss.android.socialbase.downloader.hc.hc.BYTE_INVALID_RETRY_STATUS_RESTART) {
            d(com.ss.android.socialbase.downloader.hc.hc.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public boolean ai() {
        return ho() && w() != -3 && this.fs == tt.DELAY_RETRY_WAITING;
    }

    public void d(tt ttVar) {
        this.fs = ttVar;
    }

    public boolean mg() {
        return w() != -3 && this.mt == com.ss.android.socialbase.downloader.hc.d.ASYNC_HANDLE_WAITING;
    }

    public void d(com.ss.android.socialbase.downloader.hc.d dVar) {
        this.mt = dVar;
    }

    public void tt(int i) {
        int i2 = (this.t ? this.k : this.uo) - i;
        this.z = i2;
        if (i2 < 0) {
            this.z = 0;
        }
    }

    public long pa() {
        return this.qr;
    }

    public long cw() {
        return TimeUnit.NANOSECONDS.toMillis(this.ar);
    }

    public void d(b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        u(bVar.fj());
        h(bVar.mb());
        d(bVar.js(), true);
        this.ar = bVar.ar;
        if (!bVar.xi() && !xi()) {
            this.z = 0;
            this.oc = false;
            this.t = false;
            this.ra = 0;
            this.ph = false;
        } else {
            this.z = bVar.ec();
        }
        u(bVar.o());
        if (z) {
            c(bVar.w());
        }
        this.i = bVar.xn();
        this.ey = bVar.yw();
        this.fs = bVar.eu();
        d(bVar.jm);
    }

    public void d(b bVar) {
        if (bVar == null) {
            return;
        }
        this.nv = bVar.zk();
    }

    private void bk() {
        if (this.jm == null) {
            synchronized (this) {
                if (this.jm == null) {
                    try {
                        if (!TextUtils.isEmpty(this.cj)) {
                            this.jm = new JSONObject(this.cj);
                            this.cj = null;
                        } else {
                            this.jm = new JSONObject();
                        }
                    } catch (Throwable unused) {
                        this.jm = new JSONObject();
                    }
                }
            }
        }
    }

    public void mk(String str) {
        this.yi = str;
    }

    private void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bk();
        synchronized (this.jm) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObject.opt(next);
                    if (!this.jm.has(next) && objOpt != null) {
                        this.jm.put(next, objOpt);
                    }
                }
            } catch (Exception unused) {
            }
            this.cj = null;
        }
        jw();
    }

    public boolean xn() {
        return this.i;
    }

    public boolean yw() {
        return this.ey;
    }

    public boolean hc(b bVar) {
        String str;
        String str2;
        return (bVar == null || (str = this.c) == null || !str.equals(bVar.tc()) || (str2 = this.u) == null || !str2.equals(bVar.mk())) ? false : true;
    }

    public void tc(int i) {
        this.d = i;
    }

    public boolean wz() {
        return !np() || com.ss.android.socialbase.downloader.e.an.hc(com.ss.android.socialbase.downloader.downloader.b.tr());
    }

    public boolean vg() {
        if (this.zk) {
            return xp() && com.ss.android.socialbase.downloader.e.an.hc(com.ss.android.socialbase.downloader.downloader.b.tr());
        }
        return true;
    }

    public boolean bd() {
        return com.ss.android.socialbase.downloader.hc.an.d(w());
    }

    public List<String> uq() {
        return this.rf;
    }

    public boolean n() {
        return com.ss.android.socialbase.downloader.e.an.hc(this.dz);
    }

    public boolean m() {
        return this.cb;
    }

    public int dr() {
        return this.w;
    }

    public long gb(long j) {
        int i = this.w;
        if (i <= 0) {
            i = 100;
        }
        long j2 = j / (i + 1);
        if (j2 <= 0) {
            return 1048576L;
        }
        return j2;
    }

    public int vs() {
        int i = this.yo;
        if (i < 1000) {
            return 1000;
        }
        return i;
    }

    public boolean vo() {
        return TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.hc) || TextUtils.isEmpty(this.u);
    }

    public boolean g() {
        return com.ss.android.socialbase.downloader.e.an.b(this);
    }

    public boolean xq() {
        if (this.t) {
            this.ra++;
        }
        List<String> list = this.rf;
        if (list != null && list.size() != 0 && this.ra >= 0) {
            while (this.ra < this.rf.size()) {
                if (!TextUtils.isEmpty(this.rf.get(this.ra))) {
                    this.t = true;
                    return true;
                }
                this.ra++;
            }
        }
        return false;
    }

    public boolean yl() {
        int i;
        List<String> list = this.rf;
        if (list == null || list.size() <= 0) {
            return false;
        }
        return !this.t || ((i = this.ra) >= 0 && i < this.rf.size() - 1);
    }

    public boolean nz() {
        return !TextUtils.isEmpty(this.c) && this.c.startsWith("https") && this.de && !this.ph;
    }

    public void uo(boolean z) {
        this.ph = z;
    }

    public void mq(String str) {
        d(0L, true);
        h(0L);
        u(str);
        u(1);
        this.qr = 0L;
        this.qy = 0L;
        this.ar = 0L;
    }

    public void eh() {
        d(0L, true);
        this.dz = 0L;
        this.ia = 1;
        this.qr = 0L;
        this.qy = 0L;
        this.ar = 0L;
    }

    public void ua() {
        d(0L, true);
        this.dz = 0L;
        this.ia = 1;
        this.qr = 0L;
        this.qy = 0L;
        this.ar = 0L;
        this.z = 0;
        this.i = true;
        this.ey = true;
        this.t = false;
        this.ph = false;
        this.us = null;
        this.ho = null;
        this.lv = null;
        this.el = null;
    }

    public boolean sz() {
        if (vo()) {
            return false;
        }
        File file = new File(mq(), uo());
        boolean zExists = file.exists();
        boolean zIsDirectory = file.isDirectory();
        if (zExists && !zIsDirectory) {
            long length = file.length();
            long jJs = js();
            if (com.ss.android.socialbase.downloader.uo.d.b().d("fix_file_data_valid")) {
                if (jJs > 0) {
                    long j = this.dz;
                    if (j > 0 && this.ia > 0 && length >= jJs && length <= j) {
                        return true;
                    }
                }
                com.ss.android.socialbase.downloader.an.d.c("DownloadInfo", "isFileDataValid: cur = " + jJs + ",totalBytes =" + this.dz + ",fileLength=" + length);
                return false;
            }
            if (length > 0 && jJs > 0) {
                long j2 = this.dz;
                if (j2 > 0 && this.ia > 0 && length >= jJs && length <= j2 && jJs < j2) {
                    return true;
                }
            }
            com.ss.android.socialbase.downloader.an.d.c("DownloadInfo", "isFileDataValid: cur = " + jJs + ",totalBytes =" + this.dz + ",fileLength=" + length);
        }
        return false;
    }

    public boolean bq() {
        com.ss.android.socialbase.downloader.downloader.mq mqVarNp;
        if (this.ia > 1 && (mqVarNp = com.ss.android.socialbase.downloader.downloader.b.np()) != null) {
            List<hc> listB = mqVarNp.b(h());
            if (listB == null || listB.size() != this.ia) {
                return false;
            }
            long jE = 0;
            for (hc hcVar : listB) {
                if (hcVar != null) {
                    jE += hcVar.e();
                }
            }
            if (jE != js()) {
                u(jE);
            }
        }
        return true;
    }

    public void k(boolean z) {
        this.hg = z;
    }

    public boolean ij() {
        if (sz()) {
            return bq();
        }
        return false;
    }

    public boolean is() {
        return (!this.i || TextUtils.isEmpty(mq()) || TextUtils.isEmpty(uo()) || new File(mq(), uo()).exists()) ? false : true;
    }

    public int qo() {
        return com.ss.android.socialbase.downloader.e.an.d(mk(), gb(), this.yi);
    }

    public boolean bt() {
        int iW = w();
        return iW == 4 || iW == 3 || iW == -1 || iW == 5 || iW == 8 || ((iW == 1 || iW == 2) && js() > 0);
    }

    public boolean dd() {
        return w() == 0;
    }

    public int fj() {
        return this.ia;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.d);
        parcel.writeString(this.hc);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.u);
        parcel.writeString(this.an);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.gb);
        parcel.writeTypedList(this.tt);
        parcel.writeInt(this.tc);
        parcel.writeStringArray(this.mk);
        parcel.writeIntArray(this.mq);
        parcel.writeInt(this.uo);
        parcel.writeInt(this.k);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.cb ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.w);
        parcel.writeInt(this.yo);
        parcel.writeStringList(this.rf);
        parcel.writeByte(this.jh ? (byte) 1 : (byte) 0);
        parcel.writeString(this.sy);
        parcel.writeByte(this.de ? (byte) 1 : (byte) 0);
        parcel.writeString(this.v);
        parcel.writeString(this.yi);
        parcel.writeByte(this.vv ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.s ? (byte) 1 : (byte) 0);
        parcel.writeString(this.zw);
        parcel.writeString(this.us);
        parcel.writeInt(this.z);
        parcel.writeInt(this.fs.ordinal());
        parcel.writeByte(this.ba ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.xp ? (byte) 1 : (byte) 0);
        parcel.writeString(this.to);
        parcel.writeInt(this.ra);
        parcel.writeInt(this.rw);
        parcel.writeInt(this.ia);
        parcel.writeLong(js());
        parcel.writeLong(this.dz);
        parcel.writeInt(v());
        parcel.writeLong(this.qr);
        parcel.writeLong(this.ar);
        parcel.writeByte(this.t ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ph ? (byte) 1 : (byte) 0);
        StringBuffer stringBuffer = this.nf;
        parcel.writeString(stringBuffer != null ? stringBuffer.toString() : "");
        parcel.writeByte(this.fy ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.zv ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.um ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.fv);
        parcel.writeByte(this.bc ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.kb.ordinal());
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.wb);
        parcel.writeString(this.mb);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.oc ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.p ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hr ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hg ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.ho, i);
        parcel.writeInt(this.ic);
        parcel.writeString(re());
        parcel.writeByte(this.dc ? (byte) 1 : (byte) 0);
        parcel.writeString(this.tr);
        parcel.writeInt(this.rs);
        parcel.writeString(this.nv);
        parcel.writeByte(this.ru ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.yn ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
    }

    public com.ss.android.socialbase.downloader.u.d lt() {
        return this.ho;
    }

    public void d(com.ss.android.socialbase.downloader.u.d dVar) {
        this.ho = dVar;
    }

    private void ww() {
        if (this.ec == null) {
            Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
            if (contextTr != null) {
                String string = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(contextTr, "sp_download_info", 0).getString(Long.toString(h()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.ec = new JSONObject(string);
                    } catch (JSONException e) {
                        mq.d(e);
                    }
                }
            }
            if (this.ec == null) {
                this.ec = new JSONObject();
            }
        }
    }

    public void ri() {
        Context contextTr;
        if (this.ec == null || (contextTr = com.ss.android.socialbase.downloader.downloader.b.tr()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.hc.hc(contextTr, "sp_download_info", 0).edit().putString(Integer.toString(h()), this.ec.toString()).apply();
    }

    public int hu() {
        ww();
        return this.ec.optInt("failed_resume_count", 0);
    }

    public void mk(int i) throws JSONException {
        ww();
        try {
            this.ec.put("failed_resume_count", i);
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public long jg() {
        ww();
        return this.ec.optLong("last_failed_resume_time", 0L);
    }

    public void tt(long j) throws JSONException {
        ww();
        try {
            this.ec.put("last_failed_resume_time", j);
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public int tb() {
        ww();
        return this.ec.optInt("unins_resume_count", 0);
    }

    public void mq(int i) throws JSONException {
        ww();
        try {
            this.ec.put("unins_resume_count", i);
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public long x() {
        ww();
        return this.ec.optLong("last_unins_resume_time", 0L);
    }

    public void tc(long j) throws JSONException {
        ww();
        try {
            this.ec.put("last_unins_resume_time", j);
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public int uo(String str) {
        ww();
        return this.ec.optInt(str, 0);
    }

    public void d(String str, String str2) throws JSONException {
        ww();
        try {
            this.ec.put(str, str2);
            ri();
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public long ka() {
        bk();
        return this.jm.optLong("dbjson_last_start_download_time", 0L);
    }

    public int uo(int i) {
        bk();
        return this.jm.optInt("anti_hijack_error_code", i);
    }

    public void k(int i) {
        d("anti_hijack_error_code", Integer.valueOf(i));
    }

    public boolean nu() {
        bk();
        return this.jm.optBoolean("is_save_path_redirected", false);
    }

    public void e(boolean z) {
        d("is_save_path_redirected", Boolean.valueOf(z));
    }

    public String toString() {
        return "DownloadInfo{id=" + this.d + ", name='" + this.hc + "', title='" + this.b + "', url='" + this.c + "', savePath='" + this.u + "'}";
    }

    public int ss() {
        bk();
        return this.jm.optInt("dbjson_key_preconnect_level", 0);
    }

    public void e(int i) {
        bk();
        d("dbjson_key_preconnect_level", Integer.valueOf(i));
    }

    private void gl() {
        if (this.lv == null) {
            synchronized (this) {
                if (this.lv == null) {
                    this.lv = new ConcurrentHashMap<>();
                }
            }
        }
    }

    public ConcurrentHashMap<String, Object> a() {
        gl();
        return this.lv;
    }

    public int zg() {
        bk();
        return this.jm.optInt("executor_group", 2);
    }

    public String k(String str) {
        bk();
        return this.jm.optString(str);
    }

    public void mk(long j) {
        this.tj = j;
    }

    public boolean ol() {
        return this.ox;
    }

    public long ii() {
        return this.tj;
    }

    public int qi() {
        return this.ed;
    }

    public void cb(int i) {
        this.ed = i;
    }

    public void d(PackageInfo packageInfo) {
        this.el = new SoftReference<>(packageInfo);
    }

    public PackageInfo ji() {
        SoftReference<PackageInfo> softReference = this.el;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public double tl() {
        double dJs = js() / 1048576.0d;
        double dCw = cw() / 1000.0d;
        if (dJs <= 0.0d || dCw <= 0.0d) {
            return -1.0d;
        }
        return dJs / dCw;
    }

    public long nx() {
        return this.nk;
    }

    public int qa() {
        ww();
        return this.ec.optInt("paused_resume_count", 0);
    }

    public void w(int i) throws JSONException {
        ww();
        try {
            this.ec.put("paused_resume_count", i);
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public static class d {
        private boolean an;
        private String b;
        private String bc;
        private String c;
        private int cb;
        private String d;
        private long dc;
        private boolean de;
        private boolean fs;
        private boolean fu;
        private List<u> gb;
        private String h;
        private String hc;
        private boolean he;
        private boolean hv;
        private long j;
        private boolean k;
        private boolean l;
        private int[] mk;
        private int mq;
        private boolean mt;
        private boolean np;
        private boolean nv;
        private String q;
        private boolean r;
        private String ra;
        private boolean rf;
        private int[] ru;
        private boolean s;
        private String sy;
        private String[] tc;
        private boolean to;
        private boolean tr;
        private int tt;
        private String u;
        private int uo;
        private String us;
        private boolean v;
        private String vv;
        private int w;
        private long xp;
        private JSONObject y;
        private int yn;
        private List<String> yo;
        private boolean z;
        private String zw;
        private boolean e = true;
        private boolean jh = true;
        private boolean yi = true;
        private com.ss.android.socialbase.downloader.hc.h ba = com.ss.android.socialbase.downloader.hc.h.ENQUEUE_NONE;
        private boolean wl = true;

        public d() {
        }

        public d(String str) {
            this.b = str;
        }

        public d d(String str) {
            this.d = str;
            return this;
        }

        public d hc(String str) {
            this.hc = str;
            return this;
        }

        public d b(String str) {
            this.b = str;
            return this;
        }

        public d c(String str) {
            this.ra = str;
            return this;
        }

        public d u(String str) {
            this.c = str;
            return this;
        }

        public d an(String str) {
            this.h = str;
            return this;
        }

        public d d(boolean z) {
            this.an = z;
            return this;
        }

        public d d(List<u> list) {
            this.gb = list;
            return this;
        }

        public d d(int i) {
            this.mq = i;
            return this;
        }

        public d hc(int i) {
            this.uo = i;
            return this;
        }

        public d hc(boolean z) {
            this.k = z;
            return this;
        }

        public d b(int i) {
            this.cb = i;
            return this;
        }

        public d c(int i) {
            this.w = i;
            return this;
        }

        public d hc(List<String> list) {
            this.yo = list;
            return this;
        }

        public d h(String str) {
            this.sy = str;
            return this;
        }

        public d b(boolean z) {
            this.de = z;
            return this;
        }

        public d c(boolean z) {
            this.rf = z;
            return this;
        }

        public d u(boolean z) {
            this.v = z;
            return this;
        }

        public d an(boolean z) {
            this.np = z;
            return this;
        }

        public d h(boolean z) {
            this.yi = z;
            return this;
        }

        public d gb(boolean z) {
            this.he = z;
            return this;
        }

        public d gb(String str) {
            this.vv = str;
            return this;
        }

        public d tt(String str) {
            this.zw = str;
            return this;
        }

        public d d(long j) {
            this.j = j;
            return this;
        }

        public d tt(boolean z) {
            this.s = z;
            return this;
        }

        public d tc(String str) {
            this.us = str;
            return this;
        }

        public d tc(boolean z) {
            this.z = z;
            return this;
        }

        public d mk(boolean z) {
            this.fs = z;
            return this;
        }

        public d d(com.ss.android.socialbase.downloader.hc.h hVar) {
            this.ba = hVar;
            return this;
        }

        public d mq(boolean z) {
            this.mt = z;
            return this;
        }

        public d uo(boolean z) {
            this.hv = z;
            return this;
        }

        public d d(JSONObject jSONObject) {
            this.y = jSONObject;
            return this;
        }

        public d k(boolean z) {
            this.wl = z;
            return this;
        }

        public d mk(String str) {
            this.q = str;
            return this;
        }

        public d d(int[] iArr) {
            this.ru = iArr;
            return this;
        }

        public d mq(String str) {
            this.bc = str;
            return this;
        }

        public d u(int i) {
            this.yn = i;
            return this;
        }

        public d hc(long j) {
            this.dc = j;
            return this;
        }

        public d e(boolean z) {
            this.to = z;
            return this;
        }

        public d cb(boolean z) {
            this.jh = z;
            return this;
        }

        public b d() {
            return new b(this);
        }
    }
}
