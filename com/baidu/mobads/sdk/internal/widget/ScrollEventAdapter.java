package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = -1;
    private ViewPager2.OnPageChangeCallback g;
    private final ViewPager2 h;
    private final RecyclerView i;
    private final LinearLayoutManager j;
    private int k;
    private int l;
    private ScrollEventValues m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    @Retention(RetentionPolicy.SOURCE)
    private @interface AdapterState {
    }

    ScrollEventAdapter(ViewPager2 viewPager2) {
        this.h = viewPager2;
        RecyclerView recyclerView = viewPager2.j;
        this.i = recyclerView;
        this.j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.m = new ScrollEventValues();
        i();
    }

    private void i() {
        this.k = 0;
        this.l = 0;
        this.m.a();
        this.n = -1;
        this.o = -1;
        this.p = false;
        this.q = false;
        this.s = false;
        this.r = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z = true;
        if ((this.k != 1 || this.l != 1) && i == 1) {
            a(false);
            return;
        }
        if (k() && i == 2) {
            if (this.q) {
                a(2);
                this.p = true;
                return;
            }
            return;
        }
        if (k() && i == 0) {
            j();
            if (!this.q) {
                if (this.m.a != -1) {
                    a(this.m.a, 0.0f, 0);
                }
            } else if (this.m.c != 0) {
                z = false;
            } else if (this.n != this.m.a) {
                b(this.m.a);
            }
            if (z) {
                a(0);
                i();
            }
        }
        if (this.k == 2 && i == 0 && this.r) {
            j();
            if (this.m.c == 0) {
                if (this.o != this.m.a) {
                    b(this.m.a == -1 ? 0 : this.m.a);
                }
                a(0);
                i();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.q = r4
            r3.j()
            boolean r0 = r3.p
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3f
            r3.p = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = r4
            goto L17
        L16:
            r5 = r2
        L17:
            com.baidu.mobads.sdk.internal.widget.ViewPager2 r6 = r3.h
            boolean r6 = r6.c()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = r2
            goto L23
        L22:
            r5 = r4
        L23:
            if (r5 == 0) goto L31
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.c
            if (r5 == 0) goto L31
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.a
            int r5 = r5 + r4
            goto L35
        L31:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.a
        L35:
            r3.o = r5
            int r6 = r3.n
            if (r6 == r5) goto L4d
            r3.b(r5)
            goto L4d
        L3f:
            int r5 = r3.k
            if (r5 != 0) goto L4d
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.a
            if (r5 != r1) goto L4a
            r5 = r2
        L4a:
            r3.b(r5)
        L4d:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.a
            if (r5 != r1) goto L55
            r5 = r2
            goto L59
        L55:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.a
        L59:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r6 = r3.m
            float r6 = r6.b
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r0 = r3.m
            int r0 = r0.c
            r3.a(r5, r6, r0)
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.a
            int r6 = r3.o
            if (r5 == r6) goto L6e
            if (r6 != r1) goto L7e
        L6e:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.c
            if (r5 != 0) goto L7e
            int r5 = r3.l
            if (r5 == r4) goto L7e
            r3.a(r2)
            r3.i()
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    private void j() {
        int top;
        ScrollEventValues scrollEventValues = this.m;
        scrollEventValues.a = this.j.findFirstVisibleItemPosition();
        if (scrollEventValues.a == -1) {
            scrollEventValues.a();
            return;
        }
        View viewFindViewByPosition = this.j.findViewByPosition(scrollEventValues.a);
        if (viewFindViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.j.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.j.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.j.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.j.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = viewFindViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.j.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.i.getPaddingLeft();
            if (this.h.c()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.i.getPaddingTop();
        }
        scrollEventValues.c = -top;
        if (scrollEventValues.c < 0) {
            if (new AnimateLayoutChangeDetector(this.j).a()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.c)));
        }
        scrollEventValues.b = height == 0 ? 0.0f : scrollEventValues.c / height;
    }

    private void a(boolean z) {
        this.s = z;
        this.k = z ? 4 : 1;
        int i = this.o;
        if (i != -1) {
            this.n = i;
            this.o = -1;
        } else if (this.n == -1) {
            this.n = l();
        }
        a(1);
    }

    void a() {
        this.r = true;
    }

    void a(int i, boolean z) {
        this.k = z ? 2 : 3;
        this.s = false;
        boolean z2 = this.o != i;
        this.o = i;
        a(2);
        if (z2) {
            b(i);
        }
    }

    void b() {
        this.k = 4;
        a(true);
    }

    void c() {
        if (!f() || this.s) {
            this.s = false;
            j();
            if (this.m.c == 0) {
                if (this.m.a != this.n) {
                    b(this.m.a);
                }
                a(0);
                i();
                return;
            }
            a(2);
        }
    }

    void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.g = onPageChangeCallback;
    }

    int d() {
        return this.l;
    }

    boolean e() {
        return this.l == 0;
    }

    boolean f() {
        return this.l == 1;
    }

    boolean g() {
        return this.s;
    }

    private boolean k() {
        int i = this.k;
        return i == 1 || i == 4;
    }

    double h() {
        j();
        return this.m.a + this.m.b;
    }

    private void a(int i) {
        if ((this.k == 3 && this.l == 0) || this.l == i) {
            return;
        }
        this.l = i;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i);
        }
    }

    private void b(int i) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i);
        }
    }

    private void a(int i, float f2, int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i, f2, i2);
        }
    }

    private int l() {
        return this.j.findFirstVisibleItemPosition();
    }

    private static final class ScrollEventValues {
        int a;
        float b;
        int c;

        ScrollEventValues() {
        }

        void a() {
            this.a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }
}
