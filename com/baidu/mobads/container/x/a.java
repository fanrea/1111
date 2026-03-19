package com.baidu.mobads.container.x;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.x.h;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.component.player.AdVideoViewListener;
import com.style.widget.af;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends RelativeLayout implements i {
    private static final String a = a.class.getSimpleName();
    private static final int b = 12;
    private static final int c = 10000;
    private String d;
    private com.component.player.c e;
    private C0142a f;
    private h.a g;
    private ImageView h;
    private af i;
    private AdVideoViewListener j;
    private Handler k;

    public a(Context context) {
        super(context);
        this.h = null;
        this.j = new c(this);
        this.k = new Handler(new d(this));
        a(context);
        this.i = new af();
        setOnTouchListener(this.i);
    }

    public static a a(ViewGroup viewGroup, int i, int i2) {
        Context context = viewGroup.getContext();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        a aVar = new a(context);
        aVar.setClickable(true);
        int iA = ab.a(context, 10.0f);
        aVar.a(iA);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = iA;
        layoutParams.rightMargin = iA;
        relativeLayout.addView(aVar, layoutParams);
        return aVar;
    }

    public void a(int i) {
        if (this.i != null) {
            this.i.a(i);
        }
    }

    public void a(boolean z) {
        if (this.i != null) {
            this.i.a(z);
        }
    }

    public void b(boolean z) {
        if (this.i != null) {
            this.i.b(z);
        }
    }

    private void a(Context context) {
        this.f = new C0142a(context);
        a();
        addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
        setOnClickListener(new com.baidu.mobads.container.x.b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (this.f != null) {
            this.f.a(z);
        }
    }

    public void a() {
        if (this.f != null) {
            this.f.a(4);
        }
    }

    public void b() {
        if (this.f != null) {
            this.f.a(0);
        }
        this.k.removeMessages(12);
        this.k.sendEmptyMessageDelayed(12, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    @Override // com.baidu.mobads.container.x.i
    public boolean c() {
        if (this.e != null) {
            return this.e.f();
        }
        return false;
    }

    public Bitmap d() {
        if (this.h != null && this.h.getParent() != null) {
            Drawable drawable = this.h.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
        }
        if (this.e != null) {
            return this.e.a();
        }
        return null;
    }

    public void a(Bitmap bitmap) {
        if (this.e != null) {
            if (this.h == null) {
                this.h = new ImageView(getContext());
            }
            if (bitmap != null) {
                this.h.setImageBitmap(bitmap);
            }
            if (this.h.getParent() == null) {
                addView(this.h, 1, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    public void e() {
        if (this.h != null) {
            removeView(this.h);
        }
    }

    @Override // com.baidu.mobads.container.x.i
    public com.component.player.c c(boolean z) {
        if (this.e == null) {
            return null;
        }
        this.e.a((AdVideoViewListener) null);
        this.e.e = z;
        removeView(this.e);
        com.component.player.c cVar = this.e;
        this.e = null;
        return cVar;
    }

    @Override // com.baidu.mobads.container.x.i
    public void a(com.component.player.c cVar) {
        if (cVar != null) {
            this.e = cVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(cVar, 0, layoutParams);
            cVar.a(this.j);
            d(cVar.f());
        }
    }

    @Override // com.baidu.mobads.container.x.i
    public void a(h.a aVar) {
        this.g = aVar;
    }

    @Override // com.baidu.mobads.container.x.i
    public void a(Activity activity) {
    }

    @Override // com.baidu.mobads.container.x.i
    public void a(String str) {
        this.d = str;
    }

    @Override // com.baidu.mobads.container.x.i
    public void f() {
        if (this.e != null) {
            this.e.b();
            d(true);
        }
    }

    @Override // com.baidu.mobads.container.x.i
    public void g() {
        if (this.e != null) {
            e();
            this.e.c();
            d(false);
        }
    }

    @Override // com.baidu.mobads.container.x.i
    public void h() {
        if (this.e != null) {
            e();
            this.e.d();
            d(false);
        }
    }

    @Override // com.baidu.mobads.container.x.i
    public boolean i() {
        return false;
    }

    @Override // com.baidu.mobads.container.x.i
    public void j() {
        if (this.e != null) {
            this.e.e();
            d(true);
        }
    }

    public static class b implements h.a {
        @Override // com.baidu.mobads.container.x.h.a
        public void a(int i) {
        }

        @Override // com.baidu.mobads.container.x.h.a
        public void b() {
        }

        @Override // com.baidu.mobads.container.x.h.a
        public void a() {
        }

        @Override // com.baidu.mobads.container.x.h.a
        public void b(int i) {
        }

        @Override // com.baidu.mobads.container.x.h.a
        public void a(MediaPlayer mediaPlayer) {
        }

        @Override // com.baidu.mobads.container.x.h.a
        public void a(MediaPlayer mediaPlayer, int i, int i2) {
        }

        @Override // com.baidu.mobads.container.x.h.a
        public void c() {
        }

        @Override // com.baidu.mobads.container.x.h.a
        public void d() {
        }

        @Override // com.baidu.mobads.container.x.h.a
        public void e() {
        }
    }

    /* renamed from: com.baidu.mobads.container.x.a$a, reason: collision with other inner class name */
    class C0142a extends RelativeLayout {
        private ImageView b;
        private ImageView c;
        private int d;

        public C0142a(Context context) {
            super(context);
            this.d = 200;
            this.b = new ImageView(context);
            this.c = new ImageView(context);
            getViewTreeObserver().addOnGlobalLayoutListener(new e(this, a.this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context) {
            com.component.b.a.a().a(this.c, "ic_black_cross");
            this.c.setColorFilter(-1);
            int i = this.d / 5;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            int i2 = i / 3;
            layoutParams.rightMargin = i2;
            layoutParams.topMargin = i2;
            this.c.setOnClickListener(new f(this));
            addView(this.c, layoutParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Context context) {
            if (a.this.e != null) {
                a(a.this.e.f());
            }
            this.b.setColorFilter(-1);
            int i = this.d / 3;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(13);
            this.b.setOnClickListener(new g(this));
            addView(this.b, layoutParams);
        }

        public int a() {
            if (this.b != null) {
                return this.b.getVisibility();
            }
            return 4;
        }

        public void a(int i) {
            if (this.b != null) {
                this.b.setVisibility(i);
            }
        }

        public void a(boolean z) {
            Bitmap bitmapB;
            if (this.b == null) {
                return;
            }
            if (z) {
                bitmapB = com.component.b.a.a().b("ic_white_play");
            } else {
                bitmapB = com.component.b.a.a().b("ic_white_pause");
            }
            this.b.setImageBitmap(bitmapB);
        }
    }
}
