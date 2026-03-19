package com.baidu.mobads.container.x;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.mobads.container.util.ah;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.x;
import com.baidu.mobads.container.x.h;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.component.player.AdVideoViewListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener, i {
    public static final String a = "iVBORw0KGgoAAAANSUhEUgAAAB4AAAA2CAYAAADQzyn5AAADG0lEQVRYhb3ZW4hVVRgH8N+cc5hQBkVEhhARwRBB6AoFIqVpaBYVXex+wSIosIciRIoiHwR9UCgo0OhedqUipETLIhSKCiJMBrqJlVZEmZaVM/WwvtNZyYwzZ2avs97+i7X3b9/O2t/ap2ug/6gOtBo24GZsqtUbK7o6ANfxKG6IfLhWb/Q0OoA+gWuyvrVQEm7gaSzL+u7DAyXhbjyDy7K+VViTH1UJ9HlcnPXdjXX5oKrhbryMCyL/gzux/tiBVcLj8AoWZ+gKPDTY4Krg8XgVizL0Njwy1AZVwOPxBuZHHsCt2HS8jcYK92AL5kXul2anx4fbcCzwhEDnZuiN0m932DZaeCLexFkZei02j3QHo4EnYSvOiPyXNCW+1M5O2oUnB3pahi6Tnui2WjvwlEBPydBLpSe67TZSuBfbMCfyEVwi3edRtZHAJ2I7Zkf+PdCto0VHAk8NdFaGXoi3x4IOB08LYGbkQ1iK98aKHg+ejncwI/LBQN+vAh0KnhHo9Mi/Ygl2VYUOBs+ULu+0yL/gPHxYJUoqO5ttFnZk6M84twSaw7Olyzs18o+BflwCJV3qOdLk0Bt9PwT6WSkUugb6j/bhpMj7sQCfl0Rr9YaaVKb8dyD+f9/L4dL0tz9yr3SvT+4EvFuql76LvinSNHlqaRj2BL4v8uTATy8NQx/OxjeRJwV+ZmkYvsQ5+CryROn1N1fFbbAn+OvAv4g8QXrhzxtkbKUw7JUue1/knsDnDzG+Mhi+lc58T+TmimHRUBtUBcP3ge/O8Ne0FmbFYDgQ+KeRx0nl7NLSMK231SeRT5CWpBeVhuEnLMRHkbvxglRbF4VJxcFCfJDhm3FFaZhWObQzcgPP4urSMKkAXKxVddbxJK4vDcNvgb+b4Y9heWkYDuN86WXS3N9G6VNEUZjWsuatyF14GLeXhuEP6Te9JcMfxB2lYfhTKqNez/ANuKs0TFqsXy7Nas22DitLw038SryY9a3BPaVh+BtX4bmsb7X4ZFwSJn2Cug5PZX334n7SSqKgjTSxbMRNkTvy1wDpzJdL0+wt4hvnv8WzpKvW767AAAAAAElFTkSuQmCC";
    public static final String b = "iVBORw0KGgoAAAANSUhEUgAAACMAAAAjCAQAAAC00HvSAAAAIGNIUk0AAHomAACAhAAA+gAAAIDoAAB1MAAA6mAAADqYAAAXcJy6UTwAAAACYktHRAD/h4/MvwAAAAd0SU1FB+kGEQgrCOzCAVMAAAL0SURBVEjHnZbNThNRGIafbw5CtbGdEivCUDrGny5MEyRVNy5caDRGuQtvRC9BEyUmXoW46tIE/yAxGiKgAlZiArTpVEVh2jkuBmhnmKGN3/L8PHnfN+ec7wiBygOCRlLksBkmTQJFi784/GCFim4IGlgN7JNOhAA5KlmKFBikHwDdsW6HGgt8yG1UAN2BkqAOkpSYwNzfHi4B6szxjt+dmnYxp/1do1zHRmIQbZRmhTLfQVgGQO0p8ZACk1hdEHs1iE3dqwppHB/j25ECdzDjIC3dQnXkiOYYealRBRMHAwSBUW6RioO4+sbQvbOGBAY1KW4xKgig8n6wd+PtuPrm0IPJ6xOtzdebIVSSDEu4aQxNEUrYePGQ+5MjVrP5p3lg0sOmlANUhvUsNzl6GMSyGs7D6adLSg4sEDKNL7JlaCjGRet6bciTxQgIaEyKGkNSFGKVnGpD+oS4KkjKIMdglJZOO1OHQTSD5Azs3btzCETFQwD6sQ2G/yuTYA0bpP87k3al+0gEk2npayfuT1qWU3/0Yqo3iCZh+JezXU19+4xlwcv3jxeNXiAASplXgyBhZ/uKlUoNmbr2rtojqKnMyyQ6Rwz5ulVZK41kT46PtWpvegEJv5V5IRyyksWflbXSSDY7Pub1AhLWlTmMdcCqLP5qg952AwkLyuznXDjmIKjVDeTySpnbnON4RPgB0CHWhA1eqvS2pLCj5nvMSJjVn1QGfnE++r3pISOhTlm2VJqxrcZAtJ5O0MX89sZsLQI0k5t3UCYN2MSKfi72QJdGksm5pTfht9hgmXLDBeVggssmNsfiFX1b+/j12eeQFKHGNFVYRfbbboE78S2mpT2OSAjS4DkLfgtW4GAieFWpYZGMBhmiwnZqvPAWBL+PKwCHDAJV1shg0v3wwzLTLAvCim/cn6mTBqTBEjtkOEr8YRPqzFCmqmEXQvsa+NZwi6vrX/hDggH6/L68v11w2WCWcnF+3QWi/jd+5dEYXX9bHhL6bf0D7qxVaWLIhKoAAABEZVhJZk1NACoAAAAIAAGHaQAEAAAAAQAAABoAAAAAAAOgAQADAAAAAQABAACgAgAEAAAAAQAAAISgAwAEAAAAAQAAAIQAAAAAzgaFeAAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAyNS0wNi0xN1QwODo0Mjo1NiswMDowMGWJ4psAAAAldEVYdGRhdGU6bW9kaWZ5ADIwMjUtMDYtMTdUMDg6NDI6NTYrMDA6MDAU1FonAAAAKHRFWHRkYXRlOnRpbWVzdGFtcAAyMDI1LTA2LTE3VDA4OjQzOjA4KzAwOjAwtNxl/wAAABF0RVh0ZXhpZjpDb2xvclNwYWNlADEPmwJJAAAAEnRFWHRleGlmOkV4aWZPZmZzZXQAMjZTG6JlAAAAGHRFWHRleGlmOlBpeGVsWERpbWVuc2lvbgAxMzKDEXKCAAAAGHRFWHRleGlmOlBpeGVsWURpbWVuc2lvbgAxMzIeHpP0AAAAAElFTkSuQmCC";
    private static final String d = k.class.getSimpleName();
    private static final int l = 10000;
    private static final int m = 30;
    private static final int n = 15;
    protected Runnable c;
    private j e;
    private SeekBar f;
    private ImageView g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private View.OnTouchListener k;
    private boolean o;
    private Context p;
    private Activity q;
    private h.a r;
    private RelativeLayout.LayoutParams s;
    private com.component.player.c t;
    private ViewGroup u;
    private ImageView v;
    private int w;
    private AdVideoViewListener x;
    private Handler y;

    public k(Context context, int i) {
        super(context);
        this.u = null;
        this.v = null;
        this.c = new l(this);
        this.x = new n(this);
        this.y = new Handler(new o(this));
        this.p = context;
        this.w = i;
        m();
        n();
    }

    private void m() {
        this.t = new com.component.player.c(this.p);
        a(this.t);
        this.t.e();
        this.t.i();
        this.t.a(true);
    }

    private void n() {
        this.e = new j(this.p);
        this.e.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.e, layoutParams);
        this.f = this.e.a;
        this.h = this.e.c;
        this.g = this.e.b;
        this.i = this.e.d;
        this.j = this.e.e;
        super.setOnTouchListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.f.setOnSeekBarChangeListener(this);
        this.e.setVisibility(4);
        a(this.p);
    }

    void a(Context context) {
        int iB;
        int iB2;
        ImageView imageView = new ImageView(context);
        int iB3 = bv.b(context, 7);
        imageView.setPadding(iB3, iB3, iB3, iB3);
        if (this.w == 1) {
            imageView.setImageBitmap(ah.a(b));
            iB = bv.b(context, 35);
            iB2 = bv.b(context, 35);
        } else {
            imageView.setImageBitmap(ah.a(a));
            iB = bv.b(context, 30);
            iB2 = bv.b(context, 30);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB, iB2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.leftMargin = bv.b(context, 15);
        layoutParams.topMargin = bv.b(context, 15);
        imageView.setOnClickListener(new m(this));
        addView(imageView, layoutParams);
    }

    private void o() {
        postDelayed(this.c, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        removeCallbacks(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        int iG;
        if (this.t != null && (iG = this.t.g()) > 0 && iG < this.t.h()) {
            this.f.setProgress(iG);
            int iRound = Math.round(iG / 1000.0f);
            long j = iRound % 60;
            long j2 = (iRound / 60) % 60;
            long j3 = (iRound / 3600) % 24;
            if (j3 > 0) {
                this.j.setText(String.format("%d:%02d:%02d", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)));
            } else {
                this.j.setText(String.format("%02d:%02d", Long.valueOf(j2), Long.valueOf(j)));
            }
        }
    }

    public Bitmap a() {
        if (this.v != null && this.v.getParent() != null) {
            Drawable drawable = this.v.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
        }
        if (this.t != null) {
            return this.t.a();
        }
        return null;
    }

    public void a(Bitmap bitmap) {
        if (this.t != null) {
            if (this.v == null) {
                this.v = new ImageView(this.p);
            }
            if (bitmap != null) {
                this.v.setImageBitmap(bitmap);
            }
            if (this.v.getParent() == null) {
                addView(this.v, 1, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    public void b() {
        if (this.v != null) {
            removeView(this.v);
        }
    }

    @Override // com.baidu.mobads.container.x.i
    public void a(com.component.player.c cVar) {
        if (cVar != null) {
            this.t = cVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(cVar, 0, layoutParams);
            cVar.a(this.x);
            a(cVar.f());
        }
    }

    @Override // com.baidu.mobads.container.x.i
    public com.component.player.c c(boolean z) {
        if (this.t == null) {
            return null;
        }
        this.t.a((AdVideoViewListener) null);
        this.t.e = z;
        removeView(this.t);
        p();
        com.component.player.c cVar = this.t;
        this.t = null;
        return cVar;
    }

    @Override // com.baidu.mobads.container.x.i
    public boolean c() {
        if (this.t != null) {
            return this.t.f();
        }
        return false;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.k = onTouchListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.o) {
            p();
        }
    }

    @Override // com.baidu.mobads.container.x.i
    public void h() {
        if (this.t != null) {
            b();
            this.o = false;
            this.t.d();
            o();
            a(false);
        }
    }

    public boolean d() {
        return this.o;
    }

    @Override // com.baidu.mobads.container.x.i
    public void a(h.a aVar) {
        this.r = aVar;
    }

    @Override // com.baidu.mobads.container.x.i
    public void a(Activity activity) {
        this.q = activity;
        this.q.getWindow().addFlags(128);
    }

    @Override // com.baidu.mobads.container.x.i
    public void a(String str) {
        if (this.t != null) {
            this.t.a(str);
        }
        h();
    }

    @Override // com.baidu.mobads.container.x.i
    public void f() {
        if (this.t != null) {
            this.t.b();
            p();
            a(true);
        }
    }

    @Override // com.baidu.mobads.container.x.i
    public void g() {
        if (this.t != null) {
            b();
            this.t.c();
            o();
            a(false);
        }
    }

    public void e() {
        if (this.t != null) {
            this.q.getWindow().clearFlags(128);
            this.t.e();
            p();
            a(true);
        }
    }

    protected void a(boolean z) {
        if (this.e != null) {
            this.e.b(z);
        }
    }

    public void k() {
        if (this.e != null) {
            this.e.setVisibility(4);
        }
    }

    public void l() {
        if (this.e != null) {
            this.e.setVisibility(0);
        }
        this.y.removeMessages(10);
        this.y.sendEmptyMessageDelayed(10, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.e != null) {
            if (this.e.getVisibility() == 0) {
                this.y.removeMessages(10);
                k();
            } else {
                l();
            }
        }
        if (this.q.getRequestedOrientation() == 0) {
            return true;
        }
        if (this.k != null) {
            return this.k.onTouch(this, motionEvent);
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (view.getId() == this.g.getId() && this.t != null) {
            if (this.t.f()) {
                f();
                return;
            } else {
                g();
                return;
            }
        }
        r();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        p();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        int progress = seekBar.getProgress();
        if (this.t != null) {
            this.t.b(progress);
        }
        o();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.baidu.mobads.container.x.i
    public boolean i() {
        try {
            if (this.t != null && this.t.f() && this.q.getRequestedOrientation() == 0) {
                r();
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.mobads.container.x.i
    public void j() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.t == null) {
            return;
        }
        f();
        b(this.q);
        boolean z = false;
        if (this.q.getRequestedOrientation() == 0) {
            this.e.a(true);
            this.q.setRequestedOrientation(1);
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                if (this.u != null && this.u.getParent() != null) {
                    z = true;
                }
                ((ViewGroup) parent).removeView(this);
                if (z && this.u != null) {
                    this.u.addView(this);
                    setLayoutParams(this.s);
                }
            }
        } else {
            this.r.b(this.t.g());
            this.e.a(false);
            this.q.setRequestedOrientation(0);
            View viewFindViewById = getRootView().findViewById(R.id.content);
            ViewParent parent2 = getParent();
            this.s = (RelativeLayout.LayoutParams) getLayoutParams();
            if (parent2 instanceof ViewGroup) {
                if (this.u == null) {
                    this.u = (ViewGroup) parent2;
                }
                this.u.removeView(this);
            }
            if (viewFindViewById instanceof ViewGroup) {
                ((ViewGroup) viewFindViewById).addView(this);
            }
        }
        g();
    }

    private void b(Activity activity) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (x.a(null).a() >= 26) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    public void a(long j) {
        if (this.t != null) {
            this.t.b((int) j);
        }
    }
}
