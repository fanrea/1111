package com.bytedance.adsdk.ugeno.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.bytedance.adsdk.ugeno.an.an;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class c {
    static final /* synthetic */ boolean b = true;
    private long[] an;
    private final com.bytedance.adsdk.ugeno.flexbox.d c;
    int[] d;
    long[] hc;
    private boolean[] u;

    int d(long j) {
        return (int) j;
    }

    int hc(long j) {
        return (int) (j >> 32);
    }

    long hc(int i, int i2) {
        return (i & C00oOOo.f362O8oO888) | (i2 << 32);
    }

    c(com.bytedance.adsdk.ugeno.flexbox.d dVar) {
        this.c = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] d(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.c.getFlexItemCount();
        List<hc> listHc = hc(flexItemCount);
        hc hcVar = new hc();
        if (view != null && (layoutParams instanceof com.bytedance.adsdk.ugeno.flexbox.hc)) {
            hcVar.hc = ((com.bytedance.adsdk.ugeno.flexbox.hc) layoutParams).b();
        } else {
            hcVar.hc = 1;
        }
        if (i != -1 && i != flexItemCount && i < this.c.getFlexItemCount()) {
            hcVar.d = i;
            while (i < flexItemCount) {
                listHc.get(i).d++;
                i++;
            }
        } else {
            hcVar.d = flexItemCount;
        }
        listHc.add(hcVar);
        return d(flexItemCount + 1, listHc, sparseIntArray);
    }

    int[] d(SparseIntArray sparseIntArray) {
        int flexItemCount = this.c.getFlexItemCount();
        return d(flexItemCount, hc(flexItemCount), sparseIntArray);
    }

    private List<hc> hc(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.bytedance.adsdk.ugeno.flexbox.hc hcVar = (com.bytedance.adsdk.ugeno.flexbox.hc) this.c.d(i2).getLayoutParams();
            hc hcVar2 = new hc();
            hcVar2.hc = hcVar.b();
            hcVar2.d = i2;
            arrayList.add(hcVar2);
        }
        return arrayList;
    }

    boolean hc(SparseIntArray sparseIntArray) {
        int flexItemCount = this.c.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewD = this.c.d(i);
            if (viewD != null && ((com.bytedance.adsdk.ugeno.flexbox.hc) viewD.getLayoutParams()).b() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] d(int i, List<hc> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (hc hcVar : list) {
            iArr[i2] = hcVar.d;
            sparseIntArray.append(hcVar.d, hcVar.hc);
            i2++;
        }
        return iArr;
    }

    void d(d dVar, int i, int i2) throws NoSuchFieldException {
        d(dVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<b>) null);
    }

    void hc(d dVar, int i, int i2) throws NoSuchFieldException {
        d(dVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<b>) null);
    }

    void d(d dVar, int i, int i2, int i3, int i4, int i5, List<b> list) throws NoSuchFieldException {
        int i6;
        d dVar2;
        int i7;
        int i8;
        int i9;
        List<b> list2;
        int i10;
        View view;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = i;
        int i18 = i2;
        int i19 = i5;
        boolean zD = this.c.d();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<b> arrayList = list == null ? new ArrayList() : list;
        dVar.d = arrayList;
        boolean z = i19 == -1;
        int iD = d(zD);
        int iHc = hc(zD);
        int iB = b(zD);
        int iC = c(zD);
        b bVar = new b();
        int i20 = i4;
        bVar.e = i20;
        int i21 = iHc + iD;
        bVar.u = i21;
        int flexItemCount = this.c.getFlexItemCount();
        boolean z2 = z;
        int i22 = Integer.MIN_VALUE;
        int i23 = 0;
        int iCombineMeasuredStates = 0;
        int i24 = 0;
        while (true) {
            if (i20 >= flexItemCount) {
                i6 = iCombineMeasuredStates;
                dVar2 = dVar;
                break;
            }
            View viewHc = this.c.hc(i20);
            if (viewHc == null) {
                if (d(i20, flexItemCount, bVar)) {
                    d(arrayList, bVar, i20, i23);
                }
            } else if (viewHc.getVisibility() == 8) {
                bVar.tt++;
                bVar.gb++;
                if (d(i20, flexItemCount, bVar)) {
                    d(arrayList, bVar, i20, i23);
                }
            } else {
                if (viewHc instanceof CompoundButton) {
                    d((CompoundButton) viewHc);
                }
                com.bytedance.adsdk.ugeno.flexbox.hc hcVar = (com.bytedance.adsdk.ugeno.flexbox.hc) viewHc.getLayoutParams();
                int i25 = flexItemCount;
                if (hcVar.an() == 4) {
                    bVar.k.add(Integer.valueOf(i20));
                }
                int iD2 = d(hcVar, zD);
                if (hcVar.mq() != -1.0f && mode == 1073741824) {
                    iD2 = Math.round(size * hcVar.mq());
                }
                if (zD) {
                    int iD3 = this.c.d(i17, i21 + b(hcVar, true) + c(hcVar, true), iD2);
                    i7 = size;
                    i8 = mode;
                    int iHc2 = this.c.hc(i18, iB + iC + u(hcVar, true) + an(hcVar, true) + i23, hc(hcVar, true));
                    viewHc.measure(iD3, iHc2);
                    d(i20, iD3, iHc2, viewHc);
                    i9 = iD3;
                } else {
                    i7 = size;
                    i8 = mode;
                    int iD4 = this.c.d(i18, iB + iC + u(hcVar, false) + an(hcVar, false) + i23, hc(hcVar, false));
                    int iHc3 = this.c.hc(i17, b(hcVar, false) + i21 + c(hcVar, false), iD2);
                    viewHc.measure(iD4, iHc3);
                    d(i20, iD4, iHc3, viewHc);
                    i9 = iHc3;
                }
                d(viewHc, i20);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewHc.getMeasuredState());
                int i26 = i23;
                int i27 = i21;
                b bVar2 = bVar;
                int i28 = i20;
                list2 = arrayList;
                int i29 = i9;
                if (d(viewHc, i8, i7, bVar.u, c(hcVar, zD) + d(viewHc, zD) + b(hcVar, zD), hcVar, i28, i24, arrayList.size())) {
                    if (bVar2.hc() > 0) {
                        d(list2, bVar2, i28 > 0 ? i28 - 1 : 0, i26);
                        i23 = bVar2.h + i26;
                    } else {
                        i23 = i26;
                    }
                    if (zD) {
                        if (hcVar.hc() == -1) {
                            com.bytedance.adsdk.ugeno.flexbox.d dVar3 = this.c;
                            i10 = i2;
                            i20 = i28;
                            view = viewHc;
                            view.measure(i29, dVar3.hc(i10, dVar3.getPaddingTop() + this.c.getPaddingBottom() + hcVar.k() + hcVar.cb() + i23, hcVar.hc()));
                            d(view, i20);
                        } else {
                            i10 = i2;
                            view = viewHc;
                            i20 = i28;
                        }
                    } else {
                        i10 = i2;
                        view = viewHc;
                        i20 = i28;
                        if (hcVar.d() == -1) {
                            com.bytedance.adsdk.ugeno.flexbox.d dVar4 = this.c;
                            view.measure(dVar4.d(i10, dVar4.getPaddingLeft() + this.c.getPaddingRight() + hcVar.uo() + hcVar.e() + i23, hcVar.d()), i29);
                            d(view, i20);
                        }
                    }
                    bVar = new b();
                    bVar.gb = 1;
                    i11 = i27;
                    bVar.u = i11;
                    bVar.e = i20;
                    i13 = Integer.MIN_VALUE;
                    i12 = 0;
                } else {
                    i10 = i2;
                    view = viewHc;
                    i20 = i28;
                    bVar = bVar2;
                    i11 = i27;
                    bVar.gb++;
                    i12 = i24 + 1;
                    i23 = i26;
                    i13 = i22;
                }
                bVar.w |= hcVar.c() != 0.0f;
                bVar.yo |= hcVar.u() != 0.0f;
                int[] iArr = this.d;
                if (iArr != null) {
                    iArr[i20] = list2.size();
                }
                bVar.u += d(view, zD) + b(hcVar, zD) + c(hcVar, zD);
                bVar.tc += hcVar.c();
                bVar.mk += hcVar.u();
                this.c.d(view, i20, i12, bVar);
                int iMax = Math.max(i13, hc(view, zD) + u(hcVar, zD) + an(hcVar, zD) + this.c.d(view));
                bVar.h = Math.max(bVar.h, iMax);
                if (zD) {
                    if (this.c.getFlexWrap() != 2) {
                        bVar.mq = Math.max(bVar.mq, view.getBaseline() + hcVar.k());
                    } else {
                        bVar.mq = Math.max(bVar.mq, (view.getMeasuredHeight() - view.getBaseline()) + hcVar.cb());
                    }
                }
                i14 = i25;
                if (d(i20, i14, bVar)) {
                    d(list2, bVar, i20, i23);
                    i23 += bVar.h;
                }
                i15 = i5;
                if (i15 != -1 && list2.size() > 0) {
                    if (list2.get(list2.size() - 1).cb >= i15 && i20 >= i15 && !z2) {
                        i23 = -bVar.d();
                        i16 = i3;
                        z2 = true;
                    }
                    if (i23 <= i16 && z2) {
                        dVar2 = dVar;
                        i6 = iCombineMeasuredStates;
                        break;
                    }
                    i24 = i12;
                    i22 = iMax;
                    i20++;
                    i17 = i;
                    flexItemCount = i14;
                    i18 = i10;
                    i21 = i11;
                    arrayList = list2;
                    mode = i8;
                    i19 = i15;
                    size = i7;
                }
                i16 = i3;
                if (i23 <= i16) {
                }
                i24 = i12;
                i22 = iMax;
                i20++;
                i17 = i;
                flexItemCount = i14;
                i18 = i10;
                i21 = i11;
                arrayList = list2;
                mode = i8;
                i19 = i15;
                size = i7;
            }
            i7 = size;
            i8 = mode;
            i10 = i18;
            i15 = i19;
            list2 = arrayList;
            i11 = i21;
            i14 = flexItemCount;
            i20++;
            i17 = i;
            flexItemCount = i14;
            i18 = i10;
            i21 = i11;
            arrayList = list2;
            mode = i8;
            i19 = i15;
            size = i7;
        }
        dVar2.hc = i6;
    }

    private void d(CompoundButton compoundButton) throws NoSuchFieldException {
        com.bytedance.adsdk.ugeno.flexbox.hc hcVar = (com.bytedance.adsdk.ugeno.flexbox.hc) compoundButton.getLayoutParams();
        int iH = hcVar.h();
        int iGb = hcVar.gb();
        Drawable drawableD = com.bytedance.adsdk.ugeno.an.u.d(compoundButton);
        int minimumWidth = drawableD == null ? 0 : drawableD.getMinimumWidth();
        int minimumHeight = drawableD != null ? drawableD.getMinimumHeight() : 0;
        if (iH == -1) {
            iH = minimumWidth;
        }
        hcVar.d(iH);
        if (iGb == -1) {
            iGb = minimumHeight;
        }
        hcVar.hc(iGb);
    }

    private int d(boolean z) {
        if (z) {
            return this.c.getPaddingStart();
        }
        return this.c.getPaddingTop();
    }

    private int hc(boolean z) {
        if (z) {
            return this.c.getPaddingEnd();
        }
        return this.c.getPaddingBottom();
    }

    private int b(boolean z) {
        if (z) {
            return this.c.getPaddingTop();
        }
        return this.c.getPaddingStart();
    }

    private int c(boolean z) {
        if (z) {
            return this.c.getPaddingBottom();
        }
        return this.c.getPaddingEnd();
    }

    private int d(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int hc(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int d(com.bytedance.adsdk.ugeno.flexbox.hc hcVar, boolean z) {
        if (z) {
            return hcVar.d();
        }
        return hcVar.hc();
    }

    private int hc(com.bytedance.adsdk.ugeno.flexbox.hc hcVar, boolean z) {
        if (z) {
            return hcVar.hc();
        }
        return hcVar.d();
    }

    private int b(com.bytedance.adsdk.ugeno.flexbox.hc hcVar, boolean z) {
        if (z) {
            return hcVar.uo();
        }
        return hcVar.k();
    }

    private int c(com.bytedance.adsdk.ugeno.flexbox.hc hcVar, boolean z) {
        if (z) {
            return hcVar.e();
        }
        return hcVar.cb();
    }

    private int u(com.bytedance.adsdk.ugeno.flexbox.hc hcVar, boolean z) {
        if (z) {
            return hcVar.k();
        }
        return hcVar.uo();
    }

    private int an(com.bytedance.adsdk.ugeno.flexbox.hc hcVar, boolean z) {
        if (z) {
            return hcVar.cb();
        }
        return hcVar.e();
    }

    private boolean d(View view, int i, int i2, int i3, int i4, com.bytedance.adsdk.ugeno.flexbox.hc hcVar, int i5, int i6, int i7) {
        if (this.c.getFlexWrap() == 0) {
            return false;
        }
        if (hcVar.mk()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.c.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iD = this.c.d(view, i5, i6);
        if (iD > 0) {
            i4 += iD;
        }
        return i2 < i3 + i4;
    }

    private boolean d(int i, int i2, b bVar) {
        return i == i2 - 1 && bVar.hc() != 0;
    }

    private void d(List<b> list, b bVar, int i, int i2) {
        bVar.uo = i2;
        this.c.d(bVar);
        bVar.cb = i;
        list.add(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.bytedance.adsdk.ugeno.flexbox.hc r0 = (com.bytedance.adsdk.ugeno.flexbox.hc) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.h()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.h()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.tt()
            if (r1 <= r3) goto L26
            int r1 = r0.tt()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.gb()
            if (r2 >= r5) goto L32
            int r2 = r0.gb()
            goto L3e
        L32:
            int r5 = r0.tc()
            if (r2 <= r5) goto L3d
            int r2 = r0.tc()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L50
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.d(r8, r1, r0, r7)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.c.d(android.view.View, int):void");
    }

    void d(int i, int i2) {
        d(i, i2, 0);
    }

    void d(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        b(this.c.getFlexItemCount());
        if (i3 >= this.c.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.c.getFlexDirection();
        int flexDirection2 = this.c.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.c.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.c.getPaddingLeft();
            paddingRight = this.c.getPaddingRight();
        } else if (flexDirection2 == 2 || flexDirection2 == 3) {
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.c.getLargestMainSize();
            }
            paddingLeft = this.c.getPaddingTop();
            paddingRight = this.c.getPaddingBottom();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.d;
        int i5 = iArr != null ? iArr[i3] : 0;
        List<b> flexLinesInternal = this.c.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i6 = i5; i6 < size2; i6++) {
            b bVar = flexLinesInternal.get(i6);
            if (bVar.u < size && bVar.w) {
                d(i, i2, bVar, size, i4, false);
            } else if (bVar.u > size && bVar.yo) {
                hc(i, i2, bVar, size, i4, false);
            }
        }
    }

    private void b(int i) {
        boolean[] zArr = this.u;
        if (zArr == null) {
            this.u = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.u = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void d(int i, int i2, b bVar, int i3, int i4, boolean z) {
        int i5;
        int iMax;
        double d2;
        int i6;
        double d3;
        float f = 0.0f;
        if (bVar.tc <= 0.0f || i3 < bVar.u) {
            return;
        }
        int i7 = bVar.u;
        float f2 = (i3 - bVar.u) / bVar.tc;
        bVar.u = i4 + bVar.an;
        if (!z) {
            bVar.h = Integer.MIN_VALUE;
        }
        int i8 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i9 = 0;
        while (i8 < bVar.gb) {
            int i10 = bVar.e + i8;
            View viewHc = this.c.hc(i10);
            if (viewHc == null || viewHc.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.hc hcVar = (com.bytedance.adsdk.ugeno.flexbox.hc) viewHc.getLayoutParams();
                int flexDirection = this.c.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i7;
                    int measuredWidth = viewHc.getMeasuredWidth();
                    long[] jArr = this.an;
                    if (jArr != null) {
                        measuredWidth = d(jArr[i10]);
                    }
                    int measuredHeight = viewHc.getMeasuredHeight();
                    long[] jArr2 = this.an;
                    i5 = i11;
                    if (jArr2 != null) {
                        measuredHeight = hc(jArr2[i10]);
                    }
                    if (!this.u[i10] && hcVar.c() > 0.0f) {
                        float fC = measuredWidth + (hcVar.c() * f2);
                        if (i8 == bVar.gb - 1) {
                            fC += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fC);
                        if (iRound > hcVar.tt()) {
                            iRound = hcVar.tt();
                            this.u[i10] = true;
                            bVar.tc -= hcVar.c();
                            z2 = true;
                        } else {
                            f3 += fC - iRound;
                            double d4 = f3;
                            if (d4 > 1.0d) {
                                iRound++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound--;
                                d2 = d4 + 1.0d;
                            }
                            f3 = (float) d2;
                        }
                        int iHc = hc(i2, hcVar, bVar.uo);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewHc.measure(iMakeMeasureSpec, iHc);
                        int measuredWidth2 = viewHc.getMeasuredWidth();
                        int measuredHeight2 = viewHc.getMeasuredHeight();
                        d(i10, iMakeMeasureSpec, iHc, viewHc);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, measuredHeight + hcVar.k() + hcVar.cb() + this.c.d(viewHc));
                    bVar.u += measuredWidth + hcVar.uo() + hcVar.e();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewHc.getMeasuredHeight();
                    long[] jArr3 = this.an;
                    if (jArr3 != null) {
                        measuredHeight3 = hc(jArr3[i10]);
                    }
                    int measuredWidth3 = viewHc.getMeasuredWidth();
                    long[] jArr4 = this.an;
                    if (jArr4 != null) {
                        measuredWidth3 = d(jArr4[i10]);
                    }
                    if (this.u[i10] || hcVar.c() <= f) {
                        i6 = i7;
                    } else {
                        float fC2 = measuredHeight3 + (hcVar.c() * f2);
                        if (i8 == bVar.gb - 1) {
                            fC2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fC2);
                        if (iRound2 > hcVar.tc()) {
                            iRound2 = hcVar.tc();
                            this.u[i10] = true;
                            bVar.tc -= hcVar.c();
                            i6 = i7;
                            z2 = true;
                        } else {
                            f3 += fC2 - iRound2;
                            i6 = i7;
                            double d5 = f3;
                            if (d5 > 1.0d) {
                                iRound2++;
                                d3 = d5 - 1.0d;
                            } else if (d5 < -1.0d) {
                                iRound2--;
                                d3 = d5 + 1.0d;
                            }
                            f3 = (float) d3;
                        }
                        int iD = d(i, hcVar, bVar.uo);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewHc.measure(iD, iMakeMeasureSpec2);
                        measuredWidth3 = viewHc.getMeasuredWidth();
                        int measuredHeight4 = viewHc.getMeasuredHeight();
                        d(i10, iD, iMakeMeasureSpec2, viewHc);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, measuredWidth3 + hcVar.uo() + hcVar.e() + this.c.d(viewHc));
                    bVar.u += measuredHeight3 + hcVar.k() + hcVar.cb();
                    i5 = i6;
                }
                bVar.h = Math.max(bVar.h, iMax);
                i9 = iMax;
            }
            i8++;
            i7 = i5;
            f = 0.0f;
        }
        int i12 = i7;
        if (!z2 || i12 == bVar.u) {
            return;
        }
        d(i, i2, bVar, i3, i4, true);
    }

    private void hc(int i, int i2, b bVar, int i3, int i4, boolean z) {
        int i5;
        int iMax;
        int i6 = bVar.u;
        float f = 0.0f;
        if (bVar.mk <= 0.0f || i3 > bVar.u) {
            return;
        }
        float f2 = (bVar.u - i3) / bVar.mk;
        bVar.u = i4 + bVar.an;
        if (!z) {
            bVar.h = Integer.MIN_VALUE;
        }
        int i7 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i8 = 0;
        while (i7 < bVar.gb) {
            int i9 = bVar.e + i7;
            View viewHc = this.c.hc(i9);
            if (viewHc == null || viewHc.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.hc hcVar = (com.bytedance.adsdk.ugeno.flexbox.hc) viewHc.getLayoutParams();
                int flexDirection = this.c.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i7;
                    int measuredWidth = viewHc.getMeasuredWidth();
                    long[] jArr = this.an;
                    if (jArr != null) {
                        measuredWidth = d(jArr[i9]);
                    }
                    int measuredHeight = viewHc.getMeasuredHeight();
                    long[] jArr2 = this.an;
                    if (jArr2 != null) {
                        measuredHeight = hc(jArr2[i9]);
                    }
                    if (!this.u[i9] && hcVar.u() > 0.0f) {
                        float fU = measuredWidth - (hcVar.u() * f2);
                        if (i5 == bVar.gb - 1) {
                            fU += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fU);
                        if (iRound < hcVar.h()) {
                            iRound = hcVar.h();
                            this.u[i9] = true;
                            bVar.mk -= hcVar.u();
                            z2 = true;
                        } else {
                            f3 += fU - iRound;
                            double d2 = f3;
                            if (d2 > 1.0d) {
                                iRound++;
                                f3 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound--;
                                f3 += 1.0f;
                            }
                        }
                        int iHc = hc(i2, hcVar, bVar.uo);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewHc.measure(iMakeMeasureSpec, iHc);
                        int measuredWidth2 = viewHc.getMeasuredWidth();
                        int measuredHeight2 = viewHc.getMeasuredHeight();
                        d(i9, iMakeMeasureSpec, iHc, viewHc);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i8, measuredHeight + hcVar.k() + hcVar.cb() + this.c.d(viewHc));
                    bVar.u += measuredWidth + hcVar.uo() + hcVar.e();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewHc.getMeasuredHeight();
                    long[] jArr3 = this.an;
                    if (jArr3 != null) {
                        measuredHeight3 = hc(jArr3[i9]);
                    }
                    int measuredWidth3 = viewHc.getMeasuredWidth();
                    long[] jArr4 = this.an;
                    if (jArr4 != null) {
                        measuredWidth3 = d(jArr4[i9]);
                    }
                    if (this.u[i9] || hcVar.u() <= f) {
                        i5 = i7;
                    } else {
                        float fU2 = measuredHeight3 - (hcVar.u() * f2);
                        if (i7 == bVar.gb - 1) {
                            fU2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fU2);
                        if (iRound2 < hcVar.gb()) {
                            iRound2 = hcVar.gb();
                            this.u[i9] = true;
                            bVar.mk -= hcVar.u();
                            i5 = i7;
                            z2 = true;
                        } else {
                            f3 += fU2 - iRound2;
                            i5 = i7;
                            double d3 = f3;
                            if (d3 > 1.0d) {
                                iRound2++;
                                f3 -= 1.0f;
                            } else if (d3 < -1.0d) {
                                iRound2--;
                                f3 += 1.0f;
                            }
                        }
                        int iD = d(i, hcVar, bVar.uo);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewHc.measure(iD, iMakeMeasureSpec2);
                        measuredWidth3 = viewHc.getMeasuredWidth();
                        int measuredHeight4 = viewHc.getMeasuredHeight();
                        d(i9, iD, iMakeMeasureSpec2, viewHc);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i8, measuredWidth3 + hcVar.uo() + hcVar.e() + this.c.d(viewHc));
                    bVar.u += measuredHeight3 + hcVar.k() + hcVar.cb();
                }
                bVar.h = Math.max(bVar.h, iMax);
                i8 = iMax;
            }
            i7 = i5 + 1;
            f = 0.0f;
        }
        if (!z2 || i6 == bVar.u) {
            return;
        }
        hc(i, i2, bVar, i3, i4, true);
    }

    private int d(int i, com.bytedance.adsdk.ugeno.flexbox.hc hcVar, int i2) {
        com.bytedance.adsdk.ugeno.flexbox.d dVar = this.c;
        int iD = dVar.d(i, dVar.getPaddingLeft() + this.c.getPaddingRight() + hcVar.uo() + hcVar.e() + i2, hcVar.d());
        int size = View.MeasureSpec.getSize(iD);
        if (size > hcVar.tt()) {
            return View.MeasureSpec.makeMeasureSpec(hcVar.tt(), View.MeasureSpec.getMode(iD));
        }
        return size < hcVar.h() ? View.MeasureSpec.makeMeasureSpec(hcVar.h(), View.MeasureSpec.getMode(iD)) : iD;
    }

    private int hc(int i, com.bytedance.adsdk.ugeno.flexbox.hc hcVar, int i2) {
        com.bytedance.adsdk.ugeno.flexbox.d dVar = this.c;
        int iHc = dVar.hc(i, dVar.getPaddingTop() + this.c.getPaddingBottom() + hcVar.k() + hcVar.cb() + i2, hcVar.hc());
        int size = View.MeasureSpec.getSize(iHc);
        if (size > hcVar.tc()) {
            return View.MeasureSpec.makeMeasureSpec(hcVar.tc(), View.MeasureSpec.getMode(iHc));
        }
        return size < hcVar.gb() ? View.MeasureSpec.makeMeasureSpec(hcVar.gb(), View.MeasureSpec.getMode(iHc)) : iHc;
    }

    void hc(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.c.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else if (flexDirection == 2 || flexDirection == 3) {
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        List<b> flexLinesInternal = this.c.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.c.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).h = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.c.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    b bVar = new b();
                    bVar.h = i5;
                    flexLinesInternal.add(0, bVar);
                    return;
                }
                if (alignContent == 2) {
                    this.c.setFlexLines(d(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < size) {
                        float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size4 = flexLinesInternal.size();
                        float f = 0.0f;
                        while (i4 < size4) {
                            arrayList.add(flexLinesInternal.get(i4));
                            if (i4 != flexLinesInternal.size() - 1) {
                                b bVar2 = new b();
                                if (i4 == flexLinesInternal.size() - 2) {
                                    bVar2.h = Math.round(f + size3);
                                    f = 0.0f;
                                } else {
                                    bVar2.h = Math.round(size3);
                                }
                                f += size3 - bVar2.h;
                                if (f > 1.0f) {
                                    bVar2.h++;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    bVar2.h--;
                                    f += 1.0f;
                                }
                                arrayList.add(bVar2);
                            }
                            i4++;
                        }
                        this.c.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.c.setFlexLines(d(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    b bVar3 = new b();
                    bVar3.h = size5;
                    for (b bVar4 : flexLinesInternal) {
                        arrayList2.add(bVar3);
                        arrayList2.add(bVar4);
                        arrayList2.add(bVar3);
                    }
                    this.c.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i4 < size7) {
                        b bVar5 = flexLinesInternal.get(i4);
                        float f3 = bVar5.h + size6;
                        if (i4 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int iRound = Math.round(f3);
                        f2 += f3 - iRound;
                        if (f2 > 1.0f) {
                            iRound++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            iRound--;
                            f2 += 1.0f;
                        }
                        bVar5.h = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    private List<b> d(List<b> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.h = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    void d() {
        d(0);
    }

    void d(int i) {
        View viewHc;
        if (i >= this.c.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.c.getFlexDirection();
        if (this.c.getAlignItems() == 4) {
            int[] iArr = this.d;
            List<b> flexLinesInternal = this.c.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                b bVar = flexLinesInternal.get(i2);
                int i3 = bVar.gb;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = bVar.e + i4;
                    if (i4 < this.c.getFlexItemCount() && (viewHc = this.c.hc(i5)) != null && viewHc.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.flexbox.hc hcVar = (com.bytedance.adsdk.ugeno.flexbox.hc) viewHc.getLayoutParams();
                        if (hcVar.an() == -1 || hcVar.an() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                d(viewHc, bVar.h, i5);
                            } else if (flexDirection == 2 || flexDirection == 3) {
                                hc(viewHc, bVar.h, i5);
                            } else {
                                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                        }
                    }
                }
            }
            return;
        }
        for (b bVar2 : this.c.getFlexLinesInternal()) {
            for (Integer num : bVar2.k) {
                View viewHc2 = this.c.hc(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    d(viewHc2, bVar2.h, num.intValue());
                } else if (flexDirection == 2 || flexDirection == 3) {
                    hc(viewHc2, bVar2.h, num.intValue());
                } else {
                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                }
            }
        }
    }

    private void d(View view, int i, int i2) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.flexbox.hc hcVar = (com.bytedance.adsdk.ugeno.flexbox.hc) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - hcVar.k()) - hcVar.cb()) - this.c.d(view), hcVar.gb()), hcVar.tc());
        long[] jArr = this.an;
        if (jArr != null) {
            measuredWidth = d(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        d(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    private void hc(View view, int i, int i2) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.flexbox.hc hcVar = (com.bytedance.adsdk.ugeno.flexbox.hc) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - hcVar.uo()) - hcVar.e()) - this.c.d(view), hcVar.h()), hcVar.tt());
        long[] jArr = this.an;
        if (jArr != null) {
            measuredHeight = hc(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        d(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    void d(View view, b bVar, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.flexbox.hc hcVar = (com.bytedance.adsdk.ugeno.flexbox.hc) view.getLayoutParams();
        int alignItems = this.c.getAlignItems();
        if (hcVar.an() != -1) {
            alignItems = hcVar.an();
        }
        int i5 = bVar.h;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.c.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - hcVar.cb(), i3, i6 - hcVar.cb());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + hcVar.k(), i3, (i4 - i5) + view.getMeasuredHeight() + hcVar.k());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + hcVar.k()) - hcVar.cb()) / 2;
                if (this.c.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.c.getFlexWrap() != 2) {
                    int iMax = Math.max(bVar.mq - view.getBaseline(), hcVar.k());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((bVar.mq - view.getMeasuredHeight()) + view.getBaseline(), hcVar.cb());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.c.getFlexWrap() != 2) {
            view.layout(i, i2 + hcVar.k(), i3, i4 + hcVar.k());
        } else {
            view.layout(i, i2 - hcVar.cb(), i3, i4 - hcVar.cb());
        }
    }

    void d(View view, b bVar, boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.flexbox.hc hcVar = (com.bytedance.adsdk.ugeno.flexbox.hc) view.getLayoutParams();
        int alignItems = this.c.getAlignItems();
        if (hcVar.an() != -1) {
            alignItems = hcVar.an();
        }
        int i5 = bVar.h;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - hcVar.e(), i2, ((i3 + i5) - view.getMeasuredWidth()) - hcVar.e(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + hcVar.uo(), i2, (i3 - i5) + view.getMeasuredWidth() + hcVar.uo(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + an.d(marginLayoutParams)) - an.hc(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i + hcVar.uo(), i2, i3 + hcVar.uo(), i4);
        } else {
            view.layout(i - hcVar.e(), i2, i3 - hcVar.e(), i4);
        }
    }

    private void d(int i, int i2, int i3, View view) {
        long[] jArr = this.hc;
        if (jArr != null) {
            jArr[i] = hc(i2, i3);
        }
        long[] jArr2 = this.an;
        if (jArr2 != null) {
            jArr2[i] = hc(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private static class hc implements Comparable<hc> {
        int d;
        int hc;

        private hc() {
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(hc hcVar) {
            int i = this.hc;
            int i2 = hcVar.hc;
            return i != i2 ? i - i2 : this.d - hcVar.d;
        }

        public String toString() {
            return "Order{order=" + this.hc + ", index=" + this.d + '}';
        }
    }

    static class d {
        List<b> d;
        int hc;

        d() {
        }

        void d() {
            this.d = null;
            this.hc = 0;
        }
    }
}
