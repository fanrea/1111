package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.an.h;
import com.bytedance.adsdk.ugeno.flexbox.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class FlexboxLayout extends ViewGroup implements com.bytedance.adsdk.ugeno.flexbox.d {
    private int an;
    private int b;
    private int c;
    private List<b> cb;
    private int d;
    private c e;
    private Drawable gb;
    private Drawable h;
    private int hc;
    private SparseIntArray k;
    private int mk;
    private int mq;
    private int tc;
    private int tt;
    private int u;
    private int[] uo;
    private com.bytedance.adsdk.ugeno.b w;
    private c.d yo;

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int d(View view) {
        return 0;
    }

    public FlexboxLayout(Context context) {
        super(context, null);
        this.an = -1;
        this.e = new c(this);
        this.cb = new ArrayList();
        this.yo = new c.d();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) throws NoSuchFieldException {
        com.bytedance.adsdk.ugeno.b bVar = this.w;
        if (bVar != null) {
            int[] iArrD = bVar.d(i, i2);
            d(iArrD[0], iArrD[1]);
        } else {
            d(i, i2);
        }
        com.bytedance.adsdk.ugeno.b bVar2 = this.w;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    private void d(int i, int i2) throws NoSuchFieldException {
        if (this.k == null) {
            this.k = new SparseIntArray(getChildCount());
        }
        if (this.e.hc(this.k)) {
            this.uo = this.e.d(this.k);
        }
        int i3 = this.d;
        if (i3 == 0 || i3 == 1) {
            hc(i, i2);
        } else {
            if (i3 == 2 || i3 == 3) {
                b(i, i2);
                return;
            }
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.d);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public View d(int i) {
        return getChildAt(i);
    }

    public View b(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.uo;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public View hc(int i) {
        return b(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.k == null) {
            this.k = new SparseIntArray(getChildCount());
        }
        this.uo = this.e.d(view, i, layoutParams, this.k);
        super.addView(view, i, layoutParams);
    }

    private void hc(int i, int i2) throws NoSuchFieldException {
        this.cb.clear();
        this.yo.d();
        this.e.d(this.yo, i, i2);
        this.cb = this.yo.d;
        this.e.d(i, i2);
        if (this.c == 3) {
            for (b bVar : this.cb) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < bVar.gb; i3++) {
                    View viewB = b(bVar.e + i3);
                    if (viewB != null && viewB.getVisibility() != 8) {
                        d dVar = (d) viewB.getLayoutParams();
                        if (this.hc != 2) {
                            iMax = Math.max(iMax, viewB.getMeasuredHeight() + Math.max(bVar.mq - viewB.getBaseline(), dVar.topMargin) + dVar.bottomMargin);
                        } else {
                            iMax = Math.max(iMax, viewB.getMeasuredHeight() + dVar.topMargin + Math.max((bVar.mq - viewB.getMeasuredHeight()) + viewB.getBaseline(), dVar.bottomMargin));
                        }
                    }
                }
                bVar.h = iMax;
            }
        }
        this.e.hc(i, i2, getPaddingTop() + getPaddingBottom());
        this.e.d();
        d(this.d, i, i2, this.yo.hc);
    }

    private void b(int i, int i2) throws NoSuchFieldException {
        this.cb.clear();
        this.yo.d();
        this.e.hc(this.yo, i, i2);
        this.cb = this.yo.d;
        this.e.d(i, i2);
        this.e.hc(i, i2, getPaddingLeft() + getPaddingRight());
        this.e.d();
        d(this.d, i, i2, this.yo.hc);
    }

    private void d(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (i == 2 || i == 3) {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int getLargestMainSize() {
        Iterator<b> it = this.cb.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().u);
        }
        return iMax;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int getSumOfCrossSize() {
        int i;
        int i2;
        int size = this.cb.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = this.cb.get(i4);
            if (c(i4)) {
                if (d()) {
                    i2 = this.mk;
                } else {
                    i2 = this.mq;
                }
                i3 += i2;
            }
            if (an(i4)) {
                if (d()) {
                    i = this.mk;
                } else {
                    i = this.mq;
                }
                i3 += i;
            }
            i3 += bVar.h;
        }
        return i3;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public boolean d() {
        int i = this.d;
        return i == 0 || i == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        com.bytedance.adsdk.ugeno.b bVar = this.w;
        if (bVar != null) {
            bVar.c();
        }
        int iD = h.d(this);
        int i5 = this.d;
        if (i5 == 0) {
            d(iD == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            d(iD != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            z2 = iD == 1;
            d(this.hc == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            z2 = iD == 1;
            d(this.hc == 2 ? !z2 : z2, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.d);
        }
        com.bytedance.adsdk.ugeno.b bVar2 = this.w;
        if (bVar2 != null) {
            bVar2.d(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.d(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.d(boolean, boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.gb == null && this.h == null) {
            return;
        }
        if (this.tt == 0 && this.tc == 0) {
            return;
        }
        int iD = h.d(this);
        int i = this.d;
        if (i == 0) {
            d(canvas, iD == 1, this.hc == 2);
            return;
        }
        if (i == 1) {
            d(canvas, iD != 1, this.hc == 2);
            return;
        }
        if (i == 2) {
            boolean z = iD == 1;
            if (this.hc == 2) {
                z = !z;
            }
            hc(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = iD == 1;
        if (this.hc == 2) {
            z2 = !z2;
        }
        hc(canvas, z2, true);
    }

    private void d(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.cb.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.cb.get(i3);
            for (int i4 = 0; i4 < bVar.gb; i4++) {
                int i5 = bVar.e + i4;
                View viewB = b(i5);
                if (viewB != null && viewB.getVisibility() != 8) {
                    d dVar = (d) viewB.getLayoutParams();
                    if (c(i5, i4)) {
                        if (z) {
                            left = viewB.getRight() + dVar.rightMargin;
                        } else {
                            left = (viewB.getLeft() - dVar.leftMargin) - this.mq;
                        }
                        d(canvas, left, bVar.hc, bVar.h);
                    }
                    if (i4 == bVar.gb - 1 && (this.tc & 4) > 0) {
                        if (z) {
                            right = (viewB.getLeft() - dVar.leftMargin) - this.mq;
                        } else {
                            right = viewB.getRight() + dVar.rightMargin;
                        }
                        d(canvas, right, bVar.hc, bVar.h);
                    }
                }
            }
            if (c(i3)) {
                if (z2) {
                    i2 = bVar.c;
                } else {
                    i2 = bVar.hc - this.mk;
                }
                hc(canvas, paddingLeft, i2, iMax);
            }
            if (an(i3) && (this.tt & 4) > 0) {
                if (z2) {
                    i = bVar.hc - this.mk;
                } else {
                    i = bVar.c;
                }
                hc(canvas, paddingLeft, i, iMax);
            }
        }
    }

    private void hc(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.cb.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.cb.get(i3);
            for (int i4 = 0; i4 < bVar.gb; i4++) {
                int i5 = bVar.e + i4;
                View viewB = b(i5);
                if (viewB != null && viewB.getVisibility() != 8) {
                    d dVar = (d) viewB.getLayoutParams();
                    if (c(i5, i4)) {
                        if (z2) {
                            top = viewB.getBottom() + dVar.bottomMargin;
                        } else {
                            top = (viewB.getTop() - dVar.topMargin) - this.mk;
                        }
                        hc(canvas, bVar.d, top, bVar.h);
                    }
                    if (i4 == bVar.gb - 1 && (this.tt & 4) > 0) {
                        if (z2) {
                            bottom = (viewB.getTop() - dVar.topMargin) - this.mk;
                        } else {
                            bottom = viewB.getBottom() + dVar.bottomMargin;
                        }
                        hc(canvas, bVar.d, bottom, bVar.h);
                    }
                }
            }
            if (c(i3)) {
                if (z) {
                    i2 = bVar.b;
                } else {
                    i2 = bVar.d - this.mq;
                }
                d(canvas, i2, paddingTop, iMax);
            }
            if (an(i3) && (this.tc & 4) > 0) {
                if (z) {
                    i = bVar.d - this.mq;
                } else {
                    i = bVar.b;
                }
                d(canvas, i, paddingTop, iMax);
            }
        }
    }

    private void d(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.gb;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.mq + i, i3 + i2);
        this.gb.draw(canvas);
    }

    private void hc(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.mk + i2);
        this.h.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new d(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int getFlexDirection() {
        return this.d;
    }

    public void setFlexDirection(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int getFlexWrap() {
        return this.hc;
    }

    public void setFlexWrap(int i) {
        if (this.hc != i) {
            this.hc = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.b;
    }

    public void setJustifyContent(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int getAlignItems() {
        return this.c;
    }

    public void setAlignItems(int i) {
        if (this.c != i) {
            this.c = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int getAlignContent() {
        return this.u;
    }

    public void setAlignContent(int i) {
        if (this.u != i) {
            this.u = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int getMaxLine() {
        return this.an;
    }

    public void setMaxLine(int i) {
        if (this.an != i) {
            this.an = i;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.cb.size());
        for (b bVar : this.cb) {
            if (bVar.hc() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int d(View view, int i, int i2) {
        int i3;
        int i4;
        if (d()) {
            i3 = c(i, i2) ? 0 + this.mq : 0;
            if ((this.tc & 4) <= 0) {
                return i3;
            }
            i4 = this.mq;
        } else {
            i3 = c(i, i2) ? 0 + this.mk : 0;
            if ((this.tt & 4) <= 0) {
                return i3;
            }
            i4 = this.mk;
        }
        return i3 + i4;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public void d(b bVar) {
        if (d()) {
            if ((this.tc & 4) > 0) {
                bVar.u += this.mq;
                bVar.an += this.mq;
                return;
            }
            return;
        }
        if ((this.tt & 4) > 0) {
            bVar.u += this.mk;
            bVar.an += this.mk;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int d(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public int hc(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public void d(View view, int i, int i2, b bVar) {
        if (c(i, i2)) {
            if (d()) {
                bVar.u += this.mq;
                bVar.an += this.mq;
            } else {
                bVar.u += this.mk;
                bVar.an += this.mk;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public void setFlexLines(List<b> list) {
        this.cb = list;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.d
    public List<b> getFlexLinesInternal() {
        return this.cb;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.h;
    }

    public Drawable getDividerDrawableVertical() {
        return this.gb;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.h) {
            return;
        }
        this.h = drawable;
        if (drawable != null) {
            this.mk = drawable.getIntrinsicHeight();
        } else {
            this.mk = 0;
        }
        hc();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.gb) {
            return;
        }
        this.gb = drawable;
        if (drawable != null) {
            this.mq = drawable.getIntrinsicWidth();
        } else {
            this.mq = 0;
        }
        hc();
        requestLayout();
    }

    public int getShowDividerVertical() {
        return this.tc;
    }

    public int getShowDividerHorizontal() {
        return this.tt;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.tc) {
            this.tc = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.tt) {
            this.tt = i;
            requestLayout();
        }
    }

    private void hc() {
        if (this.h == null && this.gb == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean c(int i, int i2) {
        return u(i, i2) ? d() ? (this.tc & 1) != 0 : (this.tt & 1) != 0 : d() ? (this.tc & 2) != 0 : (this.tt & 2) != 0;
    }

    private boolean u(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View viewB = b(i - i3);
            if (viewB != null && viewB.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean c(int i) {
        if (i >= 0 && i < this.cb.size()) {
            if (u(i)) {
                return d() ? (this.tt & 1) != 0 : (this.tc & 1) != 0;
            }
            if (d()) {
                return (this.tt & 2) != 0;
            }
            if ((this.tc & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean u(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.cb.get(i2).hc() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean an(int i) {
        if (i >= 0 && i < this.cb.size()) {
            for (int i2 = i + 1; i2 < this.cb.size(); i2++) {
                if (this.cb.get(i2).hc() > 0) {
                    return false;
                }
            }
            if (d()) {
                return (this.tt & 4) != 0;
            }
            if ((this.tc & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    public static class d extends ViewGroup.MarginLayoutParams implements hc {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.d.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        };
        private int an;
        private float b;
        private int c;
        private int d;
        private int gb;
        private int h;
        private float hc;
        private boolean tc;
        private int tt;
        private float u;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public d(d dVar) {
            super((ViewGroup.MarginLayoutParams) dVar);
            this.d = 1;
            this.hc = 0.0f;
            this.b = 0.0f;
            this.c = -1;
            this.u = -1.0f;
            this.an = -1;
            this.h = -1;
            this.gb = 16777215;
            this.tt = 16777215;
            this.d = dVar.d;
            this.hc = dVar.hc;
            this.b = dVar.b;
            this.c = dVar.c;
            this.u = dVar.u;
            this.an = dVar.an;
            this.h = dVar.h;
            this.gb = dVar.gb;
            this.tt = dVar.tt;
            this.tc = dVar.tc;
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.d = 1;
            this.hc = 0.0f;
            this.b = 0.0f;
            this.c = -1;
            this.u = -1.0f;
            this.an = -1;
            this.h = -1;
            this.gb = 16777215;
            this.tt = 16777215;
        }

        public d(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.d = 1;
            this.hc = 0.0f;
            this.b = 0.0f;
            this.c = -1;
            this.u = -1.0f;
            this.an = -1;
            this.h = -1;
            this.gb = 16777215;
            this.tt = 16777215;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.d = 1;
            this.hc = 0.0f;
            this.b = 0.0f;
            this.c = -1;
            this.u = -1.0f;
            this.an = -1;
            this.h = -1;
            this.gb = 16777215;
            this.tt = 16777215;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int d() {
            return this.width;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int hc() {
            return this.height;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int b() {
            return this.d;
        }

        public void b(int i) {
            this.d = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public float c() {
            return this.hc;
        }

        public void d(float f) {
            this.hc = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public float u() {
            return this.b;
        }

        public void hc(float f) {
            this.b = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int an() {
            return this.c;
        }

        public void c(int i) {
            this.c = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int h() {
            return this.an;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public void d(int i) {
            this.an = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int gb() {
            return this.h;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public void hc(int i) {
            this.h = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int tt() {
            return this.gb;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int tc() {
            return this.tt;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public boolean mk() {
            return this.tc;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public float mq() {
            return this.u;
        }

        public void b(float f) {
            this.u = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int uo() {
            return this.leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int k() {
            return this.topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int e() {
            return this.rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hc
        public int cb() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.d);
            parcel.writeFloat(this.hc);
            parcel.writeFloat(this.b);
            parcel.writeInt(this.c);
            parcel.writeFloat(this.u);
            parcel.writeInt(this.an);
            parcel.writeInt(this.h);
            parcel.writeInt(this.gb);
            parcel.writeInt(this.tt);
            parcel.writeByte(this.tc ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        protected d(Parcel parcel) {
            super(0, 0);
            this.d = 1;
            this.hc = 0.0f;
            this.b = 0.0f;
            this.c = -1;
            this.u = -1.0f;
            this.an = -1;
            this.h = -1;
            this.gb = 16777215;
            this.tt = 16777215;
            this.d = parcel.readInt();
            this.hc = parcel.readFloat();
            this.b = parcel.readFloat();
            this.c = parcel.readInt();
            this.u = parcel.readFloat();
            this.an = parcel.readInt();
            this.h = parcel.readInt();
            this.gb = parcel.readInt();
            this.tt = parcel.readInt();
            this.tc = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public void d(com.bytedance.adsdk.ugeno.hc.b bVar) {
        this.w = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.b bVar = this.w;
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.b bVar = this.w;
        if (bVar != null) {
            bVar.an();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.adsdk.ugeno.b bVar = this.w;
        if (bVar != null) {
            bVar.d(z);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.b bVar = this.w;
        if (bVar != null) {
            bVar.hc(i, i2, i3, i4);
        }
    }
}
