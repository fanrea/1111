package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.aj;
import android.support.v7.widget.e;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class ai {
    protected final aj.i mLayoutManager;
    private int rn;
    final Rect ro;

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    interface a {
        e.b a(int i, int i2, int i3, Object obj);

        void g(e.b bVar);
    }

    public abstract int M(View view);

    public abstract int N(View view);

    public abstract int O(View view);

    public abstract int P(View view);

    public abstract int Q(View view);

    public abstract int R(View view);

    public abstract void ap(int i);

    public abstract int dE();

    public abstract int dF();

    public abstract int dG();

    public abstract int dH();

    public abstract int getEnd();

    public abstract int getEndPadding();

    public abstract int getMode();

    /* synthetic */ ai(aj.i iVar, byte b) {
        this(iVar);
    }

    private ai(aj.i iVar) {
        this.rn = Integer.MIN_VALUE;
        this.ro = new Rect();
        this.mLayoutManager = iVar;
    }

    public final void dC() {
        this.rn = dG();
    }

    public final int dD() {
        if (Integer.MIN_VALUE == this.rn) {
            return 0;
        }
        return dG() - this.rn;
    }

    public static ai a(aj.i iVar, int i) {
        if (i == 0) {
            return a(iVar);
        }
        if (i == 1) {
            return b(iVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    private static ai a(aj.i iVar) {
        return new ai(iVar) { // from class: android.support.v7.widget.ai.1
            {
                byte b = 0;
            }

            @Override // android.support.v7.widget.ai
            public final int dF() {
                return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
            }

            @Override // android.support.v7.widget.ai
            public final int getEnd() {
                return this.mLayoutManager.getWidth();
            }

            @Override // android.support.v7.widget.ai
            public final void ap(int i) {
                this.mLayoutManager.offsetChildrenHorizontal(i);
            }

            @Override // android.support.v7.widget.ai
            public final int dE() {
                return this.mLayoutManager.getPaddingLeft();
            }

            @Override // android.support.v7.widget.ai
            public final int Q(View view) {
                aj.j jVar = (aj.j) view.getLayoutParams();
                return this.mLayoutManager.getDecoratedMeasuredWidth(view) + jVar.leftMargin + jVar.rightMargin;
            }

            @Override // android.support.v7.widget.ai
            public final int R(View view) {
                aj.j jVar = (aj.j) view.getLayoutParams();
                return this.mLayoutManager.getDecoratedMeasuredHeight(view) + jVar.topMargin + jVar.bottomMargin;
            }

            @Override // android.support.v7.widget.ai
            public final int N(View view) {
                return this.mLayoutManager.getDecoratedRight(view) + ((aj.j) view.getLayoutParams()).rightMargin;
            }

            @Override // android.support.v7.widget.ai
            public final int M(View view) {
                return this.mLayoutManager.getDecoratedLeft(view) - ((aj.j) view.getLayoutParams()).leftMargin;
            }

            @Override // android.support.v7.widget.ai
            public final int O(View view) {
                this.mLayoutManager.getTransformedBoundingBox(view, true, this.ro);
                return this.ro.right;
            }

            @Override // android.support.v7.widget.ai
            public final int P(View view) {
                this.mLayoutManager.getTransformedBoundingBox(view, true, this.ro);
                return this.ro.left;
            }

            @Override // android.support.v7.widget.ai
            public final int dG() {
                return (this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft()) - this.mLayoutManager.getPaddingRight();
            }

            @Override // android.support.v7.widget.ai
            public final int getEndPadding() {
                return this.mLayoutManager.getPaddingRight();
            }

            @Override // android.support.v7.widget.ai
            public final int getMode() {
                return this.mLayoutManager.getWidthMode();
            }

            @Override // android.support.v7.widget.ai
            public final int dH() {
                return this.mLayoutManager.getHeightMode();
            }
        };
    }

    private static ai b(aj.i iVar) {
        return new ai(iVar) { // from class: android.support.v7.widget.ai.2
            {
                byte b = 0;
            }

            @Override // android.support.v7.widget.ai
            public final int dF() {
                return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
            }

            @Override // android.support.v7.widget.ai
            public final int getEnd() {
                return this.mLayoutManager.getHeight();
            }

            @Override // android.support.v7.widget.ai
            public final void ap(int i) {
                this.mLayoutManager.offsetChildrenVertical(i);
            }

            @Override // android.support.v7.widget.ai
            public final int dE() {
                return this.mLayoutManager.getPaddingTop();
            }

            @Override // android.support.v7.widget.ai
            public final int Q(View view) {
                aj.j jVar = (aj.j) view.getLayoutParams();
                return this.mLayoutManager.getDecoratedMeasuredHeight(view) + jVar.topMargin + jVar.bottomMargin;
            }

            @Override // android.support.v7.widget.ai
            public final int R(View view) {
                aj.j jVar = (aj.j) view.getLayoutParams();
                return this.mLayoutManager.getDecoratedMeasuredWidth(view) + jVar.leftMargin + jVar.rightMargin;
            }

            @Override // android.support.v7.widget.ai
            public final int N(View view) {
                return this.mLayoutManager.getDecoratedBottom(view) + ((aj.j) view.getLayoutParams()).bottomMargin;
            }

            @Override // android.support.v7.widget.ai
            public final int M(View view) {
                return this.mLayoutManager.getDecoratedTop(view) - ((aj.j) view.getLayoutParams()).topMargin;
            }

            @Override // android.support.v7.widget.ai
            public final int O(View view) {
                this.mLayoutManager.getTransformedBoundingBox(view, true, this.ro);
                return this.ro.bottom;
            }

            @Override // android.support.v7.widget.ai
            public final int P(View view) {
                this.mLayoutManager.getTransformedBoundingBox(view, true, this.ro);
                return this.ro.top;
            }

            @Override // android.support.v7.widget.ai
            public final int dG() {
                return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
            }

            @Override // android.support.v7.widget.ai
            public final int getEndPadding() {
                return this.mLayoutManager.getPaddingBottom();
            }

            @Override // android.support.v7.widget.ai
            public final int getMode() {
                return this.mLayoutManager.getHeightMode();
            }

            @Override // android.support.v7.widget.ai
            public final int dH() {
                return this.mLayoutManager.getWidthMode();
            }
        };
    }
}
