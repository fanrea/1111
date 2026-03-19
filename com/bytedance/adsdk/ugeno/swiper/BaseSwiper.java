package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.d.b;
import com.bytedance.adsdk.ugeno.swiper.indicator.BaseIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.DotIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.RectangleIndicator;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;
import com.bytedance.sdk.component.utils.mq;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class BaseSwiper<T> extends FrameLayout implements ViewPager.c {
    private static final Interpolator he = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int an;
    protected Context b;
    private int c;
    private boolean cb;
    protected List<T> d;
    private FrameLayout de;
    private boolean e;
    private int gb;
    private int h;
    protected ViewPager hc;
    private int jh;
    private boolean k;
    private float mk;
    private boolean mq;
    private d np;
    private int rf;
    private int sy;
    private String tc;
    private int tt;
    private int u;
    private boolean uo;
    private BaseIndicator v;
    private final Runnable vv;
    private boolean w;
    private com.bytedance.adsdk.ugeno.swiper.d yi;
    private int yo;
    private final Runnable zw;

    public abstract View h(int i);

    public BaseSwiper(Context context) {
        super(context);
        this.d = new CopyOnWriteArrayList();
        this.c = 2000;
        this.u = 500;
        this.an = 500;
        this.h = 0;
        this.gb = -1;
        this.tt = -1;
        this.tc = "normal";
        this.mk = 1.0f;
        this.mq = true;
        this.uo = true;
        this.k = true;
        this.e = true;
        this.yo = 0;
        this.rf = 0;
        this.jh = 0;
        this.sy = 0;
        this.vv = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.2
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                int currentItem = BaseSwiper.this.hc.getCurrentItem() + 1;
                if (BaseSwiper.this.k) {
                    if (currentItem >= 1024) {
                        BaseSwiper.this.hc.d(512, false);
                        return;
                    } else {
                        BaseSwiper.this.hc.d(currentItem, true);
                        return;
                    }
                }
                com.bytedance.adsdk.ugeno.viewpager.hc adapter = BaseSwiper.this.hc.getAdapter();
                if (adapter != null) {
                    if (currentItem >= adapter.d()) {
                        BaseSwiper.this.hc.d(0, false);
                    } else {
                        BaseSwiper.this.hc.d(currentItem, true);
                    }
                }
            }
        };
        this.zw = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.3
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                if (BaseSwiper.this.uo) {
                    int currentItem = BaseSwiper.this.hc.getCurrentItem() + 1;
                    if (BaseSwiper.this.k) {
                        if (currentItem >= 1024) {
                            BaseSwiper.this.hc.d(512, false);
                        } else {
                            BaseSwiper.this.hc.d(currentItem, true);
                        }
                        BaseSwiper baseSwiper = BaseSwiper.this;
                        baseSwiper.postDelayed(baseSwiper.zw, BaseSwiper.this.c);
                        return;
                    }
                    com.bytedance.adsdk.ugeno.viewpager.hc adapter = BaseSwiper.this.hc.getAdapter();
                    if (adapter != null) {
                        if (currentItem >= adapter.d()) {
                            BaseSwiper.this.hc.d(0, false);
                            BaseSwiper baseSwiper2 = BaseSwiper.this;
                            baseSwiper2.postDelayed(baseSwiper2.zw, BaseSwiper.this.c);
                        } else {
                            BaseSwiper.this.hc.d(currentItem, true);
                            BaseSwiper baseSwiper3 = BaseSwiper.this;
                            baseSwiper3.postDelayed(baseSwiper3.zw, BaseSwiper.this.c);
                        }
                    }
                }
            }
        };
        this.b = context;
        this.de = new FrameLayout(context);
        this.hc = d();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.de.addView(this.hc, layoutParams);
        addView(this.de);
    }

    public ViewPager d() {
        return new SwiperViewPager(getContext());
    }

    public BaseSwiper d(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.v = new RectangleIndicator(this.b);
        } else {
            this.v = new DotIndicator(this.b);
        }
        addView(this.v, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public BaseSwiper d(boolean z) {
        this.uo = z;
        b();
        return this;
    }

    public BaseSwiper d(int i) {
        this.c = i;
        b();
        return this;
    }

    public BaseSwiper hc(boolean z) {
        this.e = z;
        return this;
    }

    public BaseSwiper b(boolean z) {
        this.mq = z;
        return this;
    }

    public BaseSwiper hc(int i) {
        this.v.setSelectedColor(i);
        return this;
    }

    public BaseSwiper b(int i) {
        this.v.setUnSelectedColor(i);
        return this;
    }

    public BaseSwiper c(boolean z) throws Resources.NotFoundException {
        this.v.setLoop(z);
        if (this.k != z) {
            int iD = hc.d(z, this.hc.getCurrentItem(), this.d.size());
            this.k = z;
            d dVar = this.np;
            if (dVar != null) {
                dVar.b();
                this.hc.setCurrentItem(iD);
            }
        }
        return this;
    }

    public BaseSwiper d(float f) {
        this.mk = f;
        return this;
    }

    public BaseSwiper hc(String str) throws Resources.NotFoundException {
        this.tc = str;
        d(str, this.h, this.gb, this.tt, true);
        return this;
    }

    public BaseSwiper c(int i) throws Resources.NotFoundException {
        this.h = i;
        d(this.tc, i, this.gb, this.tt, true);
        return this;
    }

    public BaseSwiper<T> u(int i) throws Resources.NotFoundException {
        this.gb = i;
        d(this.tc, this.h, i, this.tt, true);
        return this;
    }

    public BaseSwiper an(int i) throws Resources.NotFoundException {
        this.tt = i;
        d(this.tc, this.h, this.gb, i, true);
        return this;
    }

    public void d(String str, int i, int i2, int i3, boolean z) throws Resources.NotFoundException {
        d dVar = this.np;
        if (dVar != null) {
            dVar.b();
        }
        this.hc.setPageMargin(i);
        if (i2 > 0 || i3 > 0) {
            if (this.sy == 1) {
                this.hc.setPadding(0, i2 + i, 0, i3 + i);
            } else {
                this.hc.setPadding(i2 + i, 0, i3 + i, 0);
            }
            this.de.setClipChildren(false);
            this.hc.setClipChildren(false);
            this.hc.setClipToPadding(false);
        }
        if (this.sy == 1) {
            b bVar = new b();
            bVar.d(str);
            this.hc.d(true, (ViewPager.u) bVar);
            this.hc.setOverScrollMode(2);
        } else if (TextUtils.equals(str, "linear")) {
            this.hc.d(false, (ViewPager.u) new com.bytedance.adsdk.ugeno.swiper.d.hc());
        } else if (TextUtils.equals(str, "cube")) {
            this.hc.d(false, (ViewPager.u) new com.bytedance.adsdk.ugeno.swiper.d.d());
        } else {
            this.hc.d(false, (ViewPager.u) null);
        }
        this.hc.setOffscreenPageLimit((int) this.mk);
    }

    public void hc() throws Resources.NotFoundException {
        int i;
        d(this.tc, this.h, this.gb, this.tt, true);
        if (this.np == null) {
            this.np = new d();
            this.hc.d((ViewPager.c) this);
            this.hc.setAdapter(this.np);
        }
        int i2 = this.yo;
        if (i2 < 0 || i2 >= this.d.size()) {
            this.yo = 0;
        }
        if (this.k) {
            i = this.yo + 512;
        } else {
            i = this.yo;
        }
        this.hc.d(i, true);
        if (!this.k) {
            gb(i);
        }
        if (this.uo) {
            b();
        }
    }

    public void setTwoItems(boolean z) {
        this.w = z;
    }

    public View d(int i, int i2) {
        if (this.d.size() == 0) {
            return new View(getContext());
        }
        View viewH = h(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewH instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (h()) {
            viewH.setTag("two_items_tag");
        }
        if (viewH.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewH.getParent()).removeView(viewH);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewH, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (h()) {
            frameLayout.setTag(Integer.valueOf(i));
        }
        return frameLayout;
    }

    public BaseSwiper<T> d(T t) {
        if (t != null) {
            this.d.add(t);
            if (this.mq) {
                this.v.d();
            }
        }
        d dVar = this.np;
        if (dVar != null) {
            dVar.b();
            this.v.d(this.yo, this.hc.getCurrentItem());
        }
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.c
    public void d(int i, float f, int i2) {
        if (this.yi != null) {
            hc.d(this.k, i, this.d.size());
        }
        if (h()) {
            d(i, findViewWithTag(Integer.valueOf(i)));
            if (f > 0.0f) {
                int i3 = i + 1;
                d(i3, findViewWithTag(Integer.valueOf(i3)));
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.c
    public void gb(int i) {
        if (this.yi != null) {
            int iD = hc.d(this.k, i, this.d.size());
            this.yi.d(this.k, iD, i, iD == 0, iD == this.d.size() - 1);
        }
        if (this.mq) {
            this.v.d(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.c
    public void tt(int i) {
        if (i == 1 && this.cb) {
            c();
        }
    }

    class d extends com.bytedance.adsdk.ugeno.viewpager.hc {
        @Override // com.bytedance.adsdk.ugeno.viewpager.hc
        public int d(Object obj) {
            return -2;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hc
        public boolean d(View view, Object obj) {
            return view == obj;
        }

        d() {
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hc
        public int d() {
            if (BaseSwiper.this.k) {
                return 1024;
            }
            return BaseSwiper.this.d.size();
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hc
        public Object d(ViewGroup viewGroup, int i) {
            View viewD = BaseSwiper.this.d(i, hc.d(BaseSwiper.this.k, i, BaseSwiper.this.d.size()));
            viewGroup.addView(viewD);
            return viewD;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hc
        public void d(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hc
        public float d(int i) {
            if (BaseSwiper.this.mk <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / BaseSwiper.this.mk;
        }
    }

    public void b() {
        removeCallbacks(this.zw);
        postDelayed(this.zw, this.c);
    }

    public void c() {
        removeCallbacks(this.zw);
    }

    public void u() throws Resources.NotFoundException {
        int i;
        d(this.tc, this.h, this.gb, this.tt, true);
        if (this.np == null) {
            this.np = new d();
            this.hc.d((ViewPager.c) this);
            this.hc.setAdapter(this.np);
        }
        int i2 = this.yo;
        if (i2 < 0 || i2 >= this.d.size()) {
            this.yo = 0;
        }
        if (this.k) {
            i = this.yo + 512;
        } else {
            i = this.yo;
        }
        this.hc.d(i, true);
    }

    public void tc(int i) throws Resources.NotFoundException {
        d(this.tc, this.h, this.gb, this.tt, true);
        if (this.np == null) {
            this.np = new d();
            this.hc.d((ViewPager.c) this);
            this.hc.setAdapter(this.np);
        }
        if (this.k) {
            if (i >= 1024) {
                this.hc.d(512, false);
                return;
            } else {
                this.hc.d(i, true);
                return;
            }
        }
        if (i < 0 || i >= this.d.size()) {
            return;
        }
        this.hc.d(i, true);
    }

    public void mk(int i) {
        removeCallbacks(this.vv);
        postDelayed(this.vv, i);
    }

    public void an() {
        removeCallbacks(this.vv);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.uo) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.cb) {
                    b();
                }
            } else if (action == 0) {
                c();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        return this.hc.getCurrentItem();
    }

    public com.bytedance.adsdk.ugeno.viewpager.hc getAdapter() {
        return this.hc.getAdapter();
    }

    public ViewPager getViewPager() {
        return this.hc;
    }

    public void setOnPageChangeListener(com.bytedance.adsdk.ugeno.swiper.d dVar) {
        this.yi = dVar;
    }

    public class SwiperViewPager extends ViewPager {
        public SwiperViewPager(Context context) {
            super(context);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
            if (!BaseSwiper.this.e) {
                return false;
            }
            try {
                if (BaseSwiper.this.sy == 1) {
                    boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(d(motionEvent));
                    d(motionEvent);
                    return zOnInterceptTouchEvent;
                }
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e) {
                mq.d(e);
                return false;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.e) {
                return false;
            }
            try {
                if (BaseSwiper.this.sy == 1) {
                    return super.onTouchEvent(d(motionEvent));
                }
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException e) {
                mq.d(e);
                return false;
            }
        }

        private MotionEvent d(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }
    }

    private void d(int i, View view) {
        View viewFindViewWithTag;
        if ((view instanceof ViewGroup) && (viewFindViewWithTag = view.findViewWithTag("two_items_tag")) == null) {
            T t = this.d.get(hc.d(true, i, this.d.size()));
            if (t == null) {
                return;
            }
            if (t instanceof com.bytedance.adsdk.ugeno.hc.b) {
                viewFindViewWithTag = ((com.bytedance.adsdk.ugeno.hc.b) t).tt();
            } else if (t instanceof View) {
                viewFindViewWithTag = (View) t;
            }
            if (viewFindViewWithTag == null) {
                return;
            }
            if (viewFindViewWithTag.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewFindViewWithTag.getParent()).removeView(viewFindViewWithTag);
            }
            ((ViewGroup) view).addView(viewFindViewWithTag);
        }
    }

    private boolean h() {
        return this.d.size() <= 2 && this.k;
    }
}
