package com.bytedance.sdk.component.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class gb {
    private int b;
    protected final RecyclerView.tt d;
    final Rect hc;

    public abstract int an();

    public abstract int an(View view);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract void d(int i);

    public abstract int gb();

    public abstract int h();

    public abstract int hc(View view);

    public abstract int u();

    public abstract int u(View view);

    private gb(RecyclerView.tt ttVar) {
        this.b = Integer.MIN_VALUE;
        this.hc = new Rect();
        this.d = ttVar;
    }

    public void d() {
        this.b = an();
    }

    public int hc() {
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return an() - this.b;
    }

    public static gb d(RecyclerView.tt ttVar, int i) {
        if (i == 0) {
            return d(ttVar);
        }
        if (i == 1) {
            return hc(ttVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static gb d(RecyclerView.tt ttVar) {
        return new gb(ttVar) { // from class: com.bytedance.sdk.component.widget.recycler.gb.1
            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int c() {
                return this.d.de() - this.d.he();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int u() {
                return this.d.de();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public void d(int i) {
                this.d.tt(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int b() {
                return this.d.np();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int u(View view) {
                RecyclerView.tc tcVar = (RecyclerView.tc) view.getLayoutParams();
                return this.d.u(view) + tcVar.leftMargin + tcVar.rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int an(View view) {
                RecyclerView.tc tcVar = (RecyclerView.tc) view.getLayoutParams();
                return this.d.an(view) + tcVar.topMargin + tcVar.bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int hc(View view) {
                return this.d.tt(view) + ((RecyclerView.tc) view.getLayoutParams()).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int d(View view) {
                return this.d.h(view) - ((RecyclerView.tc) view.getLayoutParams()).leftMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int b(View view) {
                this.d.d(view, true, this.hc);
                return this.hc.right;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int c(View view) {
                this.d.d(view, true, this.hc);
                return this.hc.left;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int an() {
                return (this.d.de() - this.d.np()) - this.d.he();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int h() {
                return this.d.he();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int gb() {
                return this.d.jh();
            }
        };
    }

    public static gb hc(RecyclerView.tt ttVar) {
        return new gb(ttVar) { // from class: com.bytedance.sdk.component.widget.recycler.gb.2
            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int c() {
                return this.d.v() - this.d.vv();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int u() {
                return this.d.v();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public void d(int i) {
                this.d.tc(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int b() {
                return this.d.yi();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int u(View view) {
                RecyclerView.tc tcVar = (RecyclerView.tc) view.getLayoutParams();
                return this.d.an(view) + tcVar.topMargin + tcVar.bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int an(View view) {
                RecyclerView.tc tcVar = (RecyclerView.tc) view.getLayoutParams();
                return this.d.u(view) + tcVar.leftMargin + tcVar.rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int hc(View view) {
                return this.d.tc(view) + ((RecyclerView.tc) view.getLayoutParams()).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int d(View view) {
                return this.d.gb(view) - ((RecyclerView.tc) view.getLayoutParams()).topMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int b(View view) {
                this.d.d(view, true, this.hc);
                return this.hc.bottom;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int c(View view) {
                this.d.d(view, true, this.hc);
                return this.hc.top;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int an() {
                return (this.d.v() - this.d.yi()) - this.d.vv();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int h() {
                return this.d.vv();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gb
            public int gb() {
                return this.d.sy();
            }
        };
    }
}
