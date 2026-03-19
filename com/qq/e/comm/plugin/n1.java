package com.qq.e.comm.plugin;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class n1 implements ADListener {
    private final iq a;
    private final ViewGroup b;
    private final ff c;
    private final ADListener d;
    private ADListener e;
    private Boolean f;

    public n1(ADListener aDListener, ViewGroup viewGroup, ff ffVar, iq iqVar) {
        this.d = aDListener;
        this.b = viewGroup;
        this.c = ffVar;
        this.a = iqVar;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        if (a(aDEvent)) {
            return;
        }
        b(aDEvent);
    }

    private void a(int i, Object... objArr) {
        a(this.d, i, objArr);
    }

    private void b(int i, Object... objArr) {
        a(this.e, i, objArr);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ ADListener a;
        final /* synthetic */ int b;
        final /* synthetic */ Object[] c;

        a(ADListener aDListener, int i, Object[] objArr) {
            this.a = aDListener;
            this.b = i;
            this.c = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            ADListener aDListener = this.a;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(this.b, this.c));
            }
        }
    }

    private boolean a(ADEvent aDEvent) {
        int type = aDEvent.getType();
        if (type == 103) {
            a(103, this.b);
        } else if (type == 303) {
            a(303, this.b);
        } else if (type == 105) {
            a(105, this.b);
        } else if (type == 106) {
            this.b.removeAllViews();
            a(106, this.b);
        } else if (type != 109) {
            if (type != 110) {
                return false;
            }
            if (this.f != null) {
                return true;
            }
            this.f = Boolean.FALSE;
            a(110, this.b);
        } else {
            if (this.f != null) {
                return true;
            }
            View viewJ = this.a.j();
            this.b.addView(viewJ, viewJ.getLayoutParams());
            this.f = Boolean.TRUE;
            a(109, this.b);
            mh mhVarB = this.a.b();
            this.c.a(new h40(mhVarB));
            if (mhVarB != null) {
                b(209, this.b);
            }
        }
        return true;
    }

    private boolean b(ADEvent aDEvent) {
        int type = aDEvent.getType();
        if (type == 210) {
            b(210, this.b, Integer.valueOf(this.a.getVideoDuration()));
        } else if (type == 301) {
            b(301, this.b);
        } else if (type != 302) {
            switch (type) {
                case 201:
                    b(201, this.b);
                    break;
                case 202:
                    b(202, this.b);
                    break;
                case 203:
                    b(202, this.b);
                    break;
                case 204:
                case 205:
                    b(204, this.b);
                    break;
                case 206:
                    b(206, this.b);
                    break;
                case 207:
                    b(207, this.b, 5002);
                    break;
                default:
                    switch (type) {
                        case 1001:
                            b(211, this.b);
                            break;
                        case 1002:
                            a(1002, this.b);
                            break;
                        case 1003:
                            a(1003, this.b);
                            break;
                        default:
                            b(aDEvent.getType(), new Object[0]);
                            break;
                    }
            }
        } else {
            b(302, this.b);
        }
        return true;
    }

    public void a(ADListener aDListener) {
        this.e = aDListener;
    }

    private void a(ADListener aDListener, int i, Object... objArr) {
        a aVar = new a(aDListener, i, objArr);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            xo.a((Runnable) aVar);
        } else {
            aVar.run();
        }
    }
}
