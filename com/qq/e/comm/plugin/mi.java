package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mi extends lq implements ApkDownloadComplianceInterface, DialogInterface.OnDismissListener {
    protected final Object h;
    protected dd i;
    protected boolean j;
    protected boolean m;
    protected boolean n;
    protected Dialog o;
    protected int p;
    protected int q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    private String u;
    protected gt v;
    private int w;
    private int x;

    protected boolean i() {
        return r1.d().c().A();
    }

    mi(Context context, String str, String str2, mb mbVar, ADListener aDListener) {
        super(context, str, str2, mbVar, aDListener);
        this.h = new Object();
        this.v = new gt();
    }

    public void show(Activity activity) {
        Dialog dialog;
        dd ddVar = this.i;
        if (ddVar == null || ddVar.j() == null) {
            GDTLogger.w("广告展示失败，请在广告加载成功之后调用");
            return;
        }
        if (activity == null) {
            GDTLogger.e("广告展示失败，activity参数为空");
            return;
        }
        if (activity.getWindow() == null) {
            GDTLogger.e("广告展示失败，Activity的Window为空");
            return;
        }
        hn.a(this.g);
        if (!this.n && (((dialog = this.o) == null || !dialog.isShowing()) && this.i.j().getParent() == null)) {
            if (this.i.i()) {
                hn.a(this.g, ErrorCode.AD_DATA_EXPIRE);
                return;
            } else {
                a(this.i, activity);
                return;
            }
        }
        GDTLogger.e("广告展示失败，同一条广告不允许多次展示，请再次拉取后展示");
        hn.a(this.g, 4015);
    }

    /* compiled from: A */
    class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4 && keyEvent.getAction() == 0;
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            hn.b(mi.this.g);
        }
    }

    public mi(Context context, String str, String str2, String str3, ADListener aDListener) {
        this(context, str, str2, mb.DEFAULT, aDListener);
        this.u = str3;
    }

    /* compiled from: A */
    class c implements ADListener {
        c() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 103) {
                mi.this.d.onADEvent(new ADEvent(103, new Object[0]));
                b10.a(1411000, mi.this.g);
            }
            if (type == 210) {
                mi.this.d.onADEvent(new ADEvent(210, Integer.valueOf(mi.this.getVideoDuration())));
                return;
            }
            if (type == 1005) {
                if (mi.this.i == null) {
                    return;
                }
                Point point = new Point(mi.this.i.d().w0(), mi.this.i.d().v0());
                mi miVar = mi.this;
                miVar.a(point, miVar.i);
                mi miVar2 = mi.this;
                miVar2.m = true;
                Dialog dialog = miVar2.o;
                if (dialog == null || !dialog.isShowing()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = mi.this.i.j().getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                }
                Window window = mi.this.o.getWindow();
                if (window != null) {
                    window.getAttributes().width = -2;
                    window.getAttributes().height = -2;
                    return;
                }
                return;
            }
            if (type == 105) {
                mi.this.d.onADEvent(new ADEvent(105, new Object[0]));
                return;
            }
            if (type == 106) {
                mi.this.close();
                return;
            }
            if (type == 109) {
                mi miVar3 = mi.this;
                miVar3.n = false;
                miVar3.b(109);
                mi miVar4 = mi.this;
                miVar4.s = true;
                if (miVar4.k()) {
                    mi.this.b(209);
                }
                mi.this.d();
                return;
            }
            if (type == 110) {
                if (mi.this.hasShown()) {
                    mi.this.close();
                }
                mi.this.b(110);
                return;
            }
            if (type == 301) {
                mi.this.d.onADEvent(new ADEvent(301, new Object[0]));
                return;
            }
            if (type == 302) {
                mi.this.d.onADEvent(new ADEvent(302, new Object[0]));
                return;
            }
            switch (type) {
                case 201:
                    mi miVar5 = mi.this;
                    miVar5.t = true;
                    miVar5.d();
                    break;
                case 202:
                case 203:
                    mi.this.d.onADEvent(new ADEvent(202, new Object[0]));
                    break;
                case 204:
                case 205:
                    mi.this.d.onADEvent(new ADEvent(204, new Object[0]));
                    break;
                case 206:
                    mi.this.d.onADEvent(new ADEvent(206, new Object[0]));
                    break;
                case 207:
                    mi.this.d.onADEvent(new ADEvent(207, 5002));
                    break;
                default:
                    mi.this.d.onADEvent(aDEvent);
                    break;
            }
        }
    }

    private Point g() {
        Display defaultDisplay;
        Point point = new Point();
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getSize(point);
        }
        return point;
    }

    public void close() {
        Dialog dialog = this.o;
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public void destroy() {
        close();
        c();
        this.j = true;
    }

    protected boolean m() {
        ed edVarD = this.i.d();
        if (edVarD == null) {
            a(5004);
            return false;
        }
        if (!a(new Point(edVarD.Q0(), edVarD.N0()), this.i)) {
            return false;
        }
        boolean zI = i();
        this.r = zI;
        a(edVarD, zI, true);
        this.i.s();
        return true;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        c();
        this.v.b();
        b(106);
    }

    /* compiled from: A */
    class d extends xx {
        final /* synthetic */ int b;
        final /* synthetic */ Object[] c;

        d(int i, Object[] objArr) {
            this.b = i;
            this.c = objArr;
        }

        @Override // com.qq.e.comm.plugin.xx
        public void b() {
            if (mi.this.d != null) {
                mi.this.d.onADEvent(new ADEvent(this.b, this.c));
            }
        }
    }

    protected void a(int i) {
        a(107, new Object[]{Integer.valueOf(i)});
    }

    protected boolean hasShown() {
        return this.n;
    }

    protected void d() {
        if (this.s && this.t) {
            this.d.onADEvent(new ADEvent(201, new Object[0]));
        }
    }

    public int getVideoDuration() {
        dd ddVar = this.i;
        if (ddVar != null) {
            return ddVar.getVideoDuration();
        }
        return 0;
    }

    protected void c() {
        synchronized (this.h) {
            dd ddVar = this.i;
            if (ddVar != null) {
                ddVar.setAdListener(null);
                this.i.destroy();
                this.i = null;
                this.s = false;
                this.t = false;
            }
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        dd ddVar = this.i;
        if (ddVar != null) {
            return ddVar.getApkInfoUrl();
        }
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        dd ddVar = this.i;
        if (ddVar != null) {
            ddVar.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    protected void b(int i) {
        a(i, (Object[]) null);
    }

    public int getAdPatternType() {
        return k() ? 2 : 0;
    }

    public boolean h() {
        dd ddVar = this.i;
        if (ddVar != null) {
            return ddVar.i();
        }
        return false;
    }

    protected boolean k() {
        dd ddVar = this.i;
        if (ddVar != null) {
            return ddVar.k();
        }
        return false;
    }

    public String[] f() {
        dd ddVar = this.i;
        return ddVar != null ? ddVar.f() : new String[0];
    }

    public String[] e() {
        dd ddVar = this.i;
        return ddVar != null ? ddVar.e() : new String[0];
    }

    public boolean a(dd ddVar) {
        if (this.j) {
            return false;
        }
        this.i = ddVar;
        ddVar.setAdListener(new c());
        return m();
    }

    protected boolean a(Point point, dd ddVar) {
        double dA;
        int i;
        int i2;
        Point pointG = g();
        if (pointG.x <= 0 && pointG.y <= 0) {
            return false;
        }
        if (ddVar.k()) {
            dA = gn.b();
        } else {
            dA = gn.a();
        }
        int i3 = pointG.x;
        int i4 = pointG.y;
        if (i3 >= i4) {
            this.w = i4;
            this.x = i3;
        } else {
            this.w = i3;
            this.x = i4;
        }
        double d2 = this.w;
        Double.isNaN(d2);
        int i5 = (int) (d2 * dA);
        this.p = i5;
        if (i3 <= 0 || i4 <= 0 || (i = point.x) <= 0 || (i2 = point.y) <= 0) {
            return true;
        }
        double d3 = i;
        Double.isNaN(d3);
        Double.isNaN(d2);
        double d4 = i2;
        Double.isNaN(d4);
        this.q = (int) (((dA * d3) * d2) / d4);
        double d5 = this.x;
        Double.isNaN(d5);
        Double.isNaN(d3);
        Double.isNaN(d4);
        this.p = Math.min(i5, (int) (((dA * d5) * d3) / d4));
        return true;
    }

    private void a(dd ddVar, boolean z, Activity activity) {
        boolean zI = i();
        ed edVarD = ddVar.d();
        if (edVarD == null) {
            return;
        }
        a(edVarD, zI, z);
        ddVar.a(activity);
    }

    private void a(ed edVar, boolean z, boolean z2) {
        int i = z ? this.x : this.w;
        int iF = z ? this.w : this.x;
        if (!z2) {
            iF -= ua.f();
        }
        edVar.a(yu.b(this.a, i), yu.b(this.a, iF));
    }

    protected void a(dd ddVar, Activity activity) {
        Window window;
        View decorView;
        if (c1.a(activity) && (window = activity.getWindow()) != null) {
            boolean z = (window.getAttributes().flags & 1024) == 1024;
            Dialog dialog = new Dialog(activity);
            this.o = dialog;
            dialog.setOwnerActivity(activity);
            a(ddVar, z, activity);
            this.o.setOnDismissListener(this);
            this.o.setCanceledOnTouchOutside(false);
            if (this.o.requestWindowFeature(0)) {
                this.o.setFeatureDrawableAlpha(0, 0);
            }
            this.o.setOnKeyListener(new a());
            this.o.requestWindowFeature(1);
            Window window2 = this.o.getWindow();
            if (window2 == null) {
                GDTLogger.e("显示Dialog失败，Window为空");
                hn.a(this.g, ErrorCode.PrivateError.PARAM_ERROR);
                return;
            }
            window2.addFlags(2);
            window2.clearFlags(32);
            window2.setBackgroundDrawable(new ColorDrawable(0));
            if (ddVar.k() && gn.c()) {
                window2.addFlags(16777216);
            }
            a(window2, ddVar.d());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.o.setContentView(ddVar.j(), layoutParams);
            window2.getAttributes().width = -1;
            window2.getAttributes().height = -1;
            window2.getAttributes().gravity = 17;
            this.v.a(activity);
            window2.setLayout(-1, -1);
            boolean zI = i();
            if (!z && !zI) {
                window2.clearFlags(1024);
            } else {
                window2.addFlags(1024);
            }
            if (Build.VERSION.SDK_INT > 19 && (decorView = window2.getDecorView()) != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (zI) {
                    systemUiVisibility |= 4;
                }
                decorView.setSystemUiVisibility(systemUiVisibility | InputDeviceCompat.SOURCE_TOUCHSCREEN);
                decorView.post(new b());
            }
            try {
                this.o.show();
                this.n = true;
                b(102);
                hn.a(this.g, ddVar.d() != null ? ddVar.d().s1() : false, !TextUtils.isEmpty(this.u));
                return;
            } catch (Exception unused) {
                hn.a(this.g, ErrorCode.PrivateError.AD_DATA_DESTROYED);
                return;
            }
        }
        GDTLogger.w("Activity已经被系统回收");
        hn.a(this.g, ErrorCode.PrivateError.AD_DATA_DESTROYED);
    }

    private void a(Window window, h4 h4Var) {
        yq yqVarP0;
        if (window == null || h4Var == null || (yqVarP0 = h4Var.p0()) == null || yqVarP0.d() < 0.0f) {
            return;
        }
        window.setDimAmount(yqVarP0.d());
    }

    @Override // com.qq.e.comm.plugin.lq
    protected e2 a() {
        return e2.UNIFIED_INTERSTITIAL;
    }

    private void a(int i, Object[] objArr) {
        xo.a((Runnable) new d(i, objArr));
    }
}
