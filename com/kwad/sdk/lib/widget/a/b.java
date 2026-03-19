package com.kwad.sdk.lib.widget.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends RecyclerView.ItemDecoration {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int awg;
    private final int ccP;
    private final int ccQ;
    private final int ccR;

    public b(int i, int i2, int i3) {
        this.awg = i;
        this.ccP = i2;
        this.ccQ = i3;
        this.ccR = 0;
    }

    public b(int i, int i2, int i3, int i4) {
        this.awg = 3;
        this.ccP = i2;
        this.ccQ = i3;
        this.ccR = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        a(rect, view, recyclerView, this.ccR);
    }

    private void a(Rect rect, View view, RecyclerView recyclerView, int i) {
        int iAkX;
        int iAkW;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof d) {
            d dVar = (d) adapter;
            iAkW = dVar.akW();
            iAkX = dVar.akX();
        } else {
            iAkX = 0;
            iAkW = 0;
        }
        int itemCount = adapter.getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition < iAkW || childAdapterPosition >= itemCount - iAkX) {
            return;
        }
        int i2 = childAdapterPosition - iAkW;
        if (i == 0) {
            int i3 = this.awg;
            int i4 = i2 % i3;
            rect.left = (this.ccP * i4) / i3;
            int i5 = this.ccP;
            rect.right = i5 - (((i4 + 1) * i5) / this.awg);
            int i6 = this.ccQ;
            if (i6 != 0) {
                if (i2 < this.awg) {
                    rect.top = 0;
                } else {
                    rect.top = i6 / 2;
                }
                rect.bottom = this.ccQ / 2;
                return;
            }
            return;
        }
        int i7 = this.ccP;
        int i8 = this.awg;
        int i9 = ((i * 2) + (i7 * (i8 - 1))) / i8;
        if (i2 % i8 == 0) {
            rect.left = i;
            rect.right = i9 - i;
        } else if (i2 % i8 == i8 - 1) {
            rect.right = i;
            rect.left = i9 - i;
        } else {
            int i10 = i9 / 2;
            rect.left = i10;
            rect.right = i10;
        }
        if (i2 < this.awg) {
            rect.top = 0;
        } else {
            rect.top = this.ccQ / 2;
        }
        rect.bottom = this.ccQ / 2;
    }
}
