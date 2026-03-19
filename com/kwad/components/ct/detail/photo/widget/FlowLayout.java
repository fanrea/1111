package com.kwad.components.ct.detail.photo.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.core.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FlowLayout extends ViewGroup {
    private List<Rect> axq;
    private int axr;
    private int axs;
    private a axt;

    public FlowLayout(Context context) {
        super(context);
        this.axq = new ArrayList();
        this.axr = Integer.MAX_VALUE;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axq = new ArrayList();
        this.axr = Integer.MAX_VALUE;
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axq = new ArrayList();
        this.axr = Integer.MAX_VALUE;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.axq.clear();
        measureChildren(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int[] iArrBN = bN(size);
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? iArrBN[0] : 0;
        }
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? iArrBN[1] : 0;
        }
        setMeasuredDimension(size, size2);
    }

    private int[] bN(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i2 = 0;
        int iMax = 0;
        int i3 = 1;
        boolean z = true;
        while (true) {
            if (i2 >= getChildCount()) {
                break;
            }
            View childAt = getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            int measuredWidth = marginLayoutParams.leftMargin + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin;
            int measuredHeight = marginLayoutParams.topMargin + childAt.getMeasuredHeight() + marginLayoutParams.bottomMargin;
            iMax = Math.max(iMax, measuredHeight);
            if (paddingLeft + measuredWidth + getPaddingRight() > i) {
                paddingTop += iMax;
                paddingLeft = getPaddingLeft();
                i3++;
                z = false;
                if (i3 > this.axr) {
                    iMax = measuredHeight;
                    break;
                }
                iMax = measuredHeight;
            }
            paddingLeft += measuredWidth;
            this.axq.add(new Rect(marginLayoutParams.leftMargin + paddingLeft, marginLayoutParams.topMargin + paddingTop, paddingLeft - marginLayoutParams.rightMargin, (measuredHeight + paddingTop) - marginLayoutParams.bottomMargin));
            i2++;
        }
        int[] iArr = new int[2];
        iArr[0] = paddingTop + iMax + getPaddingBottom();
        if (z) {
            i = getPaddingRight() + paddingLeft;
        }
        iArr[1] = i;
        return iArr;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMin = Math.min(getChildCount(), this.axq.size());
        for (int i5 = 0; i5 < iMin; i5++) {
            View childAt = getChildAt(i5);
            Rect rect = this.axq.get(i5);
            childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
        this.axs = iMin;
    }

    public void setAdapter(a aVar) {
        if (aVar == null) {
            return;
        }
        this.axt = aVar;
        aVar.a(new a.InterfaceC0510a() { // from class: com.kwad.components.ct.detail.photo.widget.FlowLayout.1
            @Override // com.kwad.components.ct.detail.photo.widget.FlowLayout.a.InterfaceC0510a
            public final void onChanged() {
                FlowLayout.this.BR();
            }
        });
        BR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR() {
        if (this.axt == null) {
            return;
        }
        removeAllViews();
        int itemCount = this.axt.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            b bVarM = this.axt.m(this);
            this.axt.a(bVarM, i);
            addView(bVarM.itemView);
        }
    }

    public void setMaxLines(int i) {
        this.axr = i;
    }

    public int getVisibleItemCount() {
        return this.axs;
    }

    public static abstract class a<VH extends b> {
        public List<InterfaceC0510a> axv = new ArrayList();

        /* renamed from: com.kwad.components.ct.detail.photo.widget.FlowLayout$a$a, reason: collision with other inner class name */
        public interface InterfaceC0510a {
            void onChanged();
        }

        public abstract void a(VH vh, int i);

        public abstract int getItemCount();

        public abstract VH m(ViewGroup viewGroup);

        public final void BS() {
            Iterator<InterfaceC0510a> it = this.axv.iterator();
            while (it.hasNext()) {
                it.next().onChanged();
            }
        }

        public final void a(InterfaceC0510a interfaceC0510a) {
            this.axv.add(interfaceC0510a);
        }

        public final void clear() {
            this.axv.clear();
        }
    }

    public static abstract class b {
        public final View itemView;

        public b(View view) {
            if (view == null) {
                c.printStackTrace(new IllegalArgumentException("itemView may not be null"));
            }
            this.itemView = view;
        }
    }
}
