package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class dc extends RelativeLayout {
    private fx a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private TextView e;
    private Context f;
    private h4 g;

    public static int b() {
        return r1.d().f().a("rvewt", 5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        r5 r5VarD = u2.a().d(this);
        if (r5VarD != null) {
            r5VarD.a(motionEvent, false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public dc(Context context, h4 h4Var) throws JSONException {
        super(context);
        setGravity(17);
        this.f = context;
        this.g = h4Var;
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.dc.a():void");
    }

    public static boolean a(int i) {
        return r1.d().f().a("rvnec", 1) == 1 && i != 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        u2.a().a(this, this.g);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u2.a().b(this);
    }
}
