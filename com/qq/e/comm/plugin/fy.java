package com.qq.e.comm.plugin;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class fy {
    private final hy a;
    private RecyclerView.OnFlingListener b;
    private RecyclerView.OnScrollListener c;
    private int d;
    private boolean e = true;
    private int f;
    private Runnable g;

    private int b(int i, int i2, int i3) {
        return (i - i2) - i3;
    }

    private int c(int i, int i2, int i3) {
        return (i + i2) - i3;
    }

    public fy(hy hyVar) {
        this.a = hyVar;
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            jy jyVar;
            int itemCount;
            int iN;
            if (fy.this.d == 0 || (jyVar = (jy) fy.this.a.A()) == null) {
                return;
            }
            if (jyVar.getScrollState() == 0 && (itemCount = jyVar.getAdapter().getItemCount()) > 0) {
                if (itemCount != Integer.MAX_VALUE) {
                    iN = ((gy) fy.this.a.v()).n();
                    if (iN < itemCount - 1) {
                    }
                } else {
                    iN = -2;
                }
                fy.this.a(iN);
            }
            jyVar.postDelayed(this, fy.this.f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void c(int i) {
        if (i <= 0) {
            return;
        }
        this.f = i;
        if (this.g != null) {
            return;
        }
        this.g = new a();
        ((jy) this.a.A()).addOnAttachStateChangeListener(new b());
    }

    /* compiled from: A */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (fy.this.g != null) {
                view.postDelayed(fy.this.g, fy.this.f);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (fy.this.g != null) {
                view.removeCallbacks(fy.this.g);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(int i, boolean z) {
        if (i == -2) {
            i = ((gy) this.a.v()).l();
        }
        if (i == 0) {
            return;
        }
        if (i == -1) {
            i = ((gy) this.a.v()).m();
        }
        if (i < 0) {
            return;
        }
        jy jyVar = (jy) this.a.A();
        if (i > 0) {
            jyVar.smoothScrollToPosition(i - 1);
            return;
        }
        View childAt = jyVar.getChildAt(0);
        if (childAt == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) childAt.getLayoutParams() : null;
        if (z) {
            int iB = b(childAt.getTop(), marginLayoutParams == null ? 0 : marginLayoutParams.topMargin, 0);
            if (iB != 0) {
                jyVar.smoothScrollBy(0, iB);
                return;
            }
            return;
        }
        int iB2 = b(childAt.getLeft(), marginLayoutParams == null ? 0 : marginLayoutParams.leftMargin, 0);
        if (iB2 != 0) {
            jyVar.smoothScrollBy(iB2, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b(int i) {
        this.d = i;
        a aVar = null;
        if (i == 0) {
            ((jy) this.a.A()).setOnScrollListener(null);
            return;
        }
        if (this.c == null) {
            this.c = new d(this, aVar);
        }
        ((jy) this.a.A()).setOnScrollListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(int i, int i2) {
        int childCount;
        jy jyVar = (jy) this.a.A();
        if (jyVar == null || (childCount = jyVar.getChildCount()) == 0) {
            return;
        }
        this.e = true;
        boolean z = ((gy) this.a.v()).p() == 1;
        if (z) {
            i = i2;
        }
        int i3 = this.d;
        if (i3 == 4) {
            a(z, i);
        } else if (i3 == 8) {
            a(z, 0, 0, i);
        } else {
            a(z, childCount - 1, z ? jyVar.getHeight() : jyVar.getWidth(), i);
        }
    }

    /* compiled from: A */
    private class d extends RecyclerView.OnScrollListener {
        private d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (i == 2 || fy.this.e) {
                    return;
                }
                fy.this.a(0, 0);
                return;
            }
            fy.this.e = false;
        }

        /* synthetic */ d(fy fyVar, a aVar) {
            this();
        }
    }

    /* compiled from: A */
    private class c extends RecyclerView.OnFlingListener {
        private c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
        public boolean onFling(int i, int i2) {
            if (fy.this.d == 0) {
                return true;
            }
            fy.this.a(i, i2);
            return true;
        }

        /* synthetic */ c(fy fyVar, a aVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(boolean z, int i) {
        jy jyVar;
        View childAt;
        if (i > 0) {
            a(-2, z, true);
            return;
        }
        if (i < 0) {
            a(-2, z, false);
            return;
        }
        int iK = ((gy) this.a.v()).k();
        if (iK >= 0 && (childAt = (jyVar = (jy) this.a.A()).getChildAt(iK)) != null) {
            if (z) {
                int iA = a(childAt.getTop(), childAt.getBottom(), jyVar.getHeight());
                if (iA != 0) {
                    jyVar.smoothScrollBy(0, iA);
                    return;
                }
                return;
            }
            int iA2 = a(childAt.getLeft(), childAt.getRight(), jyVar.getWidth());
            if (iA2 != 0) {
                jyVar.smoothScrollBy(iA2, 0);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(boolean z, int i, int i2, int i3) {
        jy jyVar = (jy) this.a.A();
        View childAt = jyVar.getChildAt(i);
        if (childAt == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) childAt.getLayoutParams() : null;
        if (z) {
            int iA = a(childAt.getTop(), childAt.getBottom(), marginLayoutParams == null ? 0 : marginLayoutParams.topMargin, marginLayoutParams == null ? 0 : marginLayoutParams.bottomMargin, i2, i3);
            if (iA != 0) {
                jyVar.smoothScrollBy(0, iA);
                return;
            }
            return;
        }
        int iA2 = a(childAt.getLeft(), childAt.getRight(), marginLayoutParams == null ? 0 : marginLayoutParams.leftMargin, marginLayoutParams == null ? 0 : marginLayoutParams.rightMargin, i2, i3);
        if (iA2 != 0) {
            jyVar.smoothScrollBy(iA2, 0);
        }
    }

    private int a(int i, int i2, int i3) {
        return ((i + i2) - i3) / 2;
    }

    private int a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i6 > 0) {
            return c(i2, i4, i5);
        }
        if (i6 < 0) {
            return b(i, i3, i5);
        }
        int iB = b(i, i3, i5);
        int iC = c(i2, i4, i5);
        return iB + iC > 0 ? iB : iC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(int i) {
        int i2 = this.d;
        if (i2 == 8) {
            a();
            return;
        }
        if (i2 == 4) {
            a(i, ((gy) this.a.v()).p() == 1, true);
        } else if (i2 == 16) {
            a(i, ((gy) this.a.v()).p() == 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a() {
        int right;
        int bottom;
        jy jyVar = (jy) this.a.A();
        View childAt = jyVar.getChildAt(0);
        if (childAt == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) childAt.getLayoutParams() : null;
        if (((gy) this.a.v()).p() == 1) {
            if (marginLayoutParams != null && marginLayoutParams.bottomMargin != 0) {
                bottom = childAt.getBottom() + marginLayoutParams.bottomMargin;
            } else {
                bottom = childAt.getBottom();
            }
            if (bottom != 0) {
                jyVar.smoothScrollBy(0, bottom);
                return;
            }
            return;
        }
        if (marginLayoutParams != null && marginLayoutParams.rightMargin != 0) {
            right = childAt.getRight() + marginLayoutParams.rightMargin;
        } else {
            right = childAt.getRight();
        }
        if (right != 0) {
            jyVar.smoothScrollBy(right, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(int i, boolean z, boolean z2) {
        jy jyVar;
        View childAt;
        int iK = ((gy) this.a.v()).k();
        if (iK >= 0 && (childAt = (jyVar = (jy) this.a.A()).getChildAt(iK)) != null) {
            if (z) {
                int height = jyVar.getHeight();
                int iA = a(childAt.getTop(), childAt.getBottom(), height);
                if (!z2 ? iA < 0 : iA > 0) {
                    jyVar.smoothScrollBy(0, iA);
                    return;
                }
                if (!z2 ? iK <= 0 : iK >= jyVar.getChildCount() - 1) {
                    View childAt2 = jyVar.getChildAt(z2 ? iK + 1 : iK - 1);
                    jyVar.smoothScrollBy(0, a(childAt2.getTop(), childAt2.getBottom(), height));
                    return;
                } else if (z2) {
                    a(i, z);
                    return;
                } else {
                    b(i, z);
                    return;
                }
            }
            int width = jyVar.getWidth();
            int iA2 = a(childAt.getLeft(), childAt.getRight(), width);
            if (!z2 ? iA2 < 0 : iA2 > 0) {
                jyVar.smoothScrollBy(iA2, 0);
                return;
            }
            if (!z2 ? iK <= 0 : iK >= jyVar.getChildCount() - 1) {
                View childAt3 = jyVar.getChildAt(z2 ? iK + 1 : iK - 1);
                jyVar.smoothScrollBy(a(childAt3.getLeft(), childAt3.getRight(), width), 0);
            } else if (z2) {
                a(i, z);
            } else {
                b(i, z);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(int i, boolean z) {
        if (i == -2) {
            i = ((gy) this.a.v()).n();
        }
        jy jyVar = (jy) this.a.A();
        int itemCount = jyVar.getAdapter().getItemCount() - 1;
        if (i == itemCount) {
            return;
        }
        if (i == -1) {
            i = ((gy) this.a.v()).o();
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 <= itemCount) {
            jyVar.smoothScrollToPosition(i2);
            return;
        }
        View childAt = jyVar.getChildAt(jyVar.getChildCount() - 1);
        if (childAt == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) childAt.getLayoutParams() : null;
        if (z) {
            int iC = c(childAt.getBottom(), marginLayoutParams == null ? 0 : marginLayoutParams.bottomMargin, jyVar.getHeight());
            if (iC != 0) {
                jyVar.smoothScrollBy(0, iC);
                return;
            }
            return;
        }
        int iC2 = c(childAt.getRight(), marginLayoutParams == null ? 0 : marginLayoutParams.rightMargin, jyVar.getWidth());
        if (iC2 != 0) {
            jyVar.smoothScrollBy(iC2, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void a(boolean z) {
        a aVar = null;
        if (z) {
            ((jy) this.a.A()).setOnFlingListener(null);
            return;
        }
        if (this.b == null) {
            this.b = new c(this, aVar);
        }
        ((jy) this.a.A()).setOnFlingListener(this.b);
    }
}
