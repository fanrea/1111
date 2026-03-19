package android.support.v7.widget;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.e.a.b;
import android.support.v7.d.a;
import android.support.v7.widget.be;
import android.support.v7.widget.bf;
import android.support.v7.widget.e;
import android.support.v7.widget.s;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.location.LocationRequestCompat;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class al extends Resources {
    private final Resources fK;

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public interface d {
        int eE();
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public interface k {
        void ar(View view);
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static abstract class l {
        public abstract boolean ak(int i, int i2);
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public interface m {
        boolean b(MotionEvent motionEvent);

        void c(MotionEvent motionEvent);
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static abstract class n {
        public void a(al alVar, int i, int i2) {
        }

        public void c(al alVar, int i) {
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public interface q {
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static abstract class v {
        public abstract View fn();
    }

    public al(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.fK = resources;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2) {
        return this.fK.getText(i2);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i2, int i3) {
        return this.fK.getQuantityText(i2, i3);
    }

    @Override // android.content.res.Resources
    public String getString(int i2) {
        return this.fK.getString(i2);
    }

    @Override // android.content.res.Resources
    public String getString(int i2, Object... objArr) {
        return this.fK.getString(i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3, Object... objArr) {
        return this.fK.getQuantityString(i2, i3, objArr);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3) {
        return this.fK.getQuantityString(i2, i3);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2, CharSequence charSequence) {
        return this.fK.getText(i2, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i2) {
        return this.fK.getTextArray(i2);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i2) {
        return this.fK.getStringArray(i2);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i2) {
        return this.fK.getIntArray(i2);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i2) {
        return this.fK.obtainTypedArray(i2);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i2) {
        return this.fK.getDimension(i2);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i2) {
        return this.fK.getDimensionPixelOffset(i2);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i2) {
        return this.fK.getDimensionPixelSize(i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i2, int i3, int i4) {
        return this.fK.getFraction(i2, i3, i4);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) {
        return this.fK.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2, Resources.Theme theme) {
        return this.fK.getDrawable(i2, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i2, int i3) {
        return this.fK.getDrawableForDensity(i2, i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        return this.fK.getDrawableForDensity(i2, i3, theme);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i2) {
        return this.fK.getMovie(i2);
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) {
        return this.fK.getColor(i2);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) {
        return this.fK.getColorStateList(i2);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i2) {
        return this.fK.getBoolean(i2);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i2) {
        return this.fK.getInteger(i2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i2) {
        return this.fK.getLayout(i2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i2) {
        return this.fK.getAnimation(i2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i2) {
        return this.fK.getXml(i2);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) {
        return this.fK.openRawResource(i2);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) {
        return this.fK.openRawResource(i2, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i2) {
        return this.fK.openRawResourceFd(i2);
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.fK.getValue(i2, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.fK.getValueForDensity(i2, i3, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.fK.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.fK.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.fK;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.fK.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.fK.getConfiguration();
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.fK.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i2) {
        return this.fK.getResourceName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i2) {
        return this.fK.getResourcePackageName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i2) {
        return this.fK.getResourceTypeName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i2) {
        return this.fK.getResourceEntryName(i2);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.fK.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.fK.parseBundleExtra(str, attributeSet, bundle);
    }

    /* renamed from: android.support.v7.widget.al$1, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!al.this.sW || al.this.isLayoutRequested()) {
                return;
            }
            if (!al.this.sT) {
                al.this.requestLayout();
            } else if (al.this.sZ) {
                al.this.sY = true;
            } else {
                al.this.dU();
            }
        }
    }

    /* renamed from: android.support.v7.widget.al$2, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (al.this.to != null) {
                al.this.to.cI();
            }
            al.this.tK = false;
        }
    }

    /* renamed from: android.support.v7.widget.al$3, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    static class AnonymousClass3 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }

        AnonymousClass3() {
        }
    }

    /* renamed from: android.support.v7.widget.al$4, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass4 implements bf.b {
        AnonymousClass4() {
        }

        @Override // android.support.v7.widget.bf.b
        public final void c(x xVar, f.b bVar, f.b bVar2) {
            al.this.sE.z(xVar);
            al.this.b(xVar, bVar, bVar2);
        }

        @Override // android.support.v7.widget.bf.b
        public final void d(x xVar, f.b bVar, f.b bVar2) {
            al.this.a(xVar, bVar, bVar2);
        }

        @Override // android.support.v7.widget.bf.b
        public final void e(x xVar, f.b bVar, f.b bVar2) {
            xVar.z(false);
            if (al.this.tf) {
                if (al.this.to.a(xVar, xVar, bVar, bVar2)) {
                    al.this.em();
                }
            } else if (al.this.to.h(xVar, bVar, bVar2)) {
                al.this.em();
            }
        }

        @Override // android.support.v7.widget.bf.b
        public final void l(x xVar) {
            al.this.sO.a(xVar.vu, al.this.sE);
        }
    }

    /* renamed from: android.support.v7.widget.al$5, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass5 implements s.b {
        AnonymousClass5() {
        }

        @Override // android.support.v7.widget.s.b
        public final int getChildCount() {
            return al.this.getChildCount();
        }

        @Override // android.support.v7.widget.s.b
        public final void addView(View view, int i) {
            al.this.addView(view, i);
            al.this.ac(view);
        }

        @Override // android.support.v7.widget.s.b
        public final int indexOfChild(View view) {
            return al.this.indexOfChild(view);
        }

        @Override // android.support.v7.widget.s.b
        public final void removeViewAt(int i) {
            View childAt = al.this.getChildAt(i);
            if (childAt != null) {
                al.this.ab(childAt);
                childAt.clearAnimation();
            }
            al.this.removeViewAt(i);
        }

        @Override // android.support.v7.widget.s.b
        public final View getChildAt(int i) {
            return al.this.getChildAt(i);
        }

        @Override // android.support.v7.widget.s.b
        public final void removeAllViews() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                al.this.ab(childAt);
                childAt.clearAnimation();
            }
            al.this.removeAllViews();
        }

        public final x G(View view) {
            return al.V(view);
        }

        @Override // android.support.v7.widget.s.b
        public final void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
            x xVarV = al.V(view);
            if (xVarV != null) {
                if (!xVarV.fG() && !xVarV.ft()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + xVarV + al.this.dP());
                }
                xVarV.fD();
            }
            al.a(al.this, view, i, layoutParams);
        }

        @Override // android.support.v7.widget.s.b
        public final void detachViewFromParent(int i) {
            x xVarV;
            View childAt = getChildAt(i);
            if (childAt != null && (xVarV = al.V(childAt)) != null) {
                if (xVarV.fG() && !xVarV.ft()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + xVarV + al.this.dP());
                }
                xVarV.addFlags(256);
            }
            al.b(al.this, i);
        }

        public final void H(View view) {
            x xVarV = al.V(view);
            if (xVarV != null) {
                xVarV.m(al.this);
            }
        }

        @Override // android.support.v7.widget.s.b
        public final void I(View view) {
            x xVarV = al.V(view);
            if (xVarV != null) {
                xVarV.n(al.this);
            }
        }
    }

    /* renamed from: android.support.v7.widget.al$6, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass6 implements e.a {
        AnonymousClass6() {
        }

        public final x Z(int i) {
            x xVarC = al.this.c(i, true);
            if (xVarC == null || al.this.sH.C(xVarC.vu)) {
                return null;
            }
            return xVarC;
        }

        @Override // android.support.v7.widget.e.a
        public final void t(int i, int i2) {
            al.this.b(i, i2, true);
            al alVar = al.this;
            alVar.tH = true;
            alVar.tE.vc += i2;
        }

        @Override // android.support.v7.widget.e.a
        public final void u(int i, int i2) {
            al.this.b(i, i2, false);
            al.this.tH = true;
        }

        @Override // android.support.v7.widget.e.a
        public final void b(int i, int i2, Object obj) {
            al.this.c(i, i2, obj);
            al.this.tI = true;
        }

        @Override // android.support.v7.widget.e.a
        public final void h(e.b bVar) {
            j(bVar);
        }

        private void j(e.b bVar) {
            int i = bVar.mF;
            if (i == 1) {
                al.this.sO.c(al.this, bVar.mG, bVar.mI);
                return;
            }
            if (i == 2) {
                al.this.sO.C(bVar.mG, bVar.mI);
            } else if (i == 4) {
                al.this.sO.d(al.this, bVar.mG, bVar.mI);
            } else {
                if (i != 8) {
                    return;
                }
                al.this.sO.D(bVar.mG, bVar.mI);
            }
        }

        @Override // android.support.v7.widget.e.a
        public final void i(e.b bVar) {
            j(bVar);
        }

        @Override // android.support.v7.widget.e.a
        public final void v(int i, int i2) {
            al.this.W(i, i2);
            al.this.tH = true;
        }

        public final void w(int i, int i2) {
            al.this.V(i, i2);
            al.this.tH = true;
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    class w implements Runnable {
        OverScroller ej;
        private int vq;
        private int vr;
        Interpolator mInterpolator = al.tT;
        private boolean vs = false;
        private boolean vt = false;

        w() {
            this.ej = new OverScroller(al.this.getContext(), al.tT);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00f5  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 422
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.al.w.run():void");
        }

        private void fo() {
            this.vt = false;
            this.vs = true;
        }

        private void fp() {
            this.vs = false;
            if (this.vt) {
                fq();
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.support.v7.widget.al, android.view.View] */
        final void fq() {
            if (this.vs) {
                this.vt = true;
            } else {
                al.this.removeCallbacks(this);
                android.support.v4.e.o.a((View) al.this, this);
            }
        }

        public final void an(int i, int i2) {
            al.this.setScrollState(2);
            this.vr = 0;
            this.vq = 0;
            this.ej.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            fq();
        }

        public final void smoothScrollBy(int i, int i2) {
            c(i, i2, 0, 0);
        }

        private void c(int i, int i2, int i3, int i4) {
            h(i, i2, d(i, i2, 0, 0));
        }

        private static float f(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int d(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            al alVar = al.this;
            int width = z ? alVar.getWidth() : alVar.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float f3 = f2 + (f(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(f3 / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final void h(int i, int i2, int i3) {
            b(i, i2, i3, al.tT);
        }

        public final void a(int i, int i2, Interpolator interpolator) {
            int iD = d(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = al.tT;
            }
            b(i, i2, iD, interpolator);
        }

        public final void b(int i, int i2, int i3, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.ej = new OverScroller(al.this.getContext(), interpolator);
            }
            al.this.setScrollState(2);
            this.vr = 0;
            this.vq = 0;
            this.ej.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.ej.computeScrollOffset();
            }
            fq();
        }

        public final void stop() {
            al.this.removeCallbacks(this);
            this.ej.abortAnimation();
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    class r extends c {
        r() {
        }

        @Override // android.support.v7.widget.al.c
        public final void onChanged() {
            al.this.c(null);
            al.this.tE.vf = true;
            al.this.y(true);
            if (al.this.sG.cl()) {
                return;
            }
            al.this.requestLayout();
        }

        @Override // android.support.v7.widget.al.c
        public final void e(int i, int i2, Object obj) {
            al.this.c(null);
            if (al.this.sG.a(i, i2, obj)) {
                fe();
            }
        }

        @Override // android.support.v7.widget.al.c
        public final void ae(int i, int i2) {
            al.this.c(null);
            if (al.this.sG.r(i, i2)) {
                fe();
            }
        }

        @Override // android.support.v7.widget.al.c
        public final void af(int i, int i2) {
            al.this.c(null);
            if (al.this.sG.s(i, i2)) {
                fe();
            }
        }

        @Override // android.support.v7.widget.al.c
        public final void e(int i, int i2, int i3) {
            al.this.c(null);
            if (al.this.sG.d(i, i2, 1)) {
                fe();
            }
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [android.support.v7.widget.al, android.view.View] */
        private void fe() {
            if (al.sy && al.this.sU && al.this.sT) {
                ?? r0 = al.this;
                android.support.v4.e.o.a((View) r0, ((al) r0).sK);
            } else {
                al alVar = al.this;
                alVar.tc = true;
                alVar.requestLayout();
            }
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static class e {
        protected static EdgeEffect g(al alVar) {
            return new EdgeEffect(alVar.getContext());
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static class o {
        SparseArray<a> uA = new SparseArray<>();
        private int uB = 0;

        static class a {
            final ArrayList<x> uC = new ArrayList<>();
            int uD = 5;
            long uE = 0;
            long uF = 0;

            a() {
            }
        }

        private void clear() {
            for (int i = 0; i < this.uA.size(); i++) {
                this.uA.valueAt(i).uC.clear();
            }
        }

        public final x aI(int i) {
            a aVar = this.uA.get(i);
            if (aVar == null || aVar.uC.isEmpty()) {
                return null;
            }
            return aVar.uC.remove(r2.size() - 1);
        }

        public final void u(x xVar) {
            int iFy = xVar.fy();
            ArrayList<x> arrayList = aJ(iFy).uC;
            if (this.uA.get(iFy).uD <= arrayList.size()) {
                return;
            }
            xVar.dA();
            arrayList.add(xVar);
        }

        private static long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        final void a(int i, long j) {
            a aVarAJ = aJ(i);
            aVarAJ.uE = a(aVarAJ.uE, j);
        }

        final void b(int i, long j) {
            a aVarAJ = aJ(i);
            aVarAJ.uF = a(aVarAJ.uF, j);
        }

        final boolean a(int i, long j, long j2) {
            long j3 = aJ(i).uE;
            return j3 == 0 || j + j3 < j2;
        }

        final boolean b(int i, long j, long j2) {
            long j3 = aJ(i).uF;
            return j3 == 0 || j + j3 < j2;
        }

        final void eY() {
            this.uB++;
        }

        final void detach() {
            this.uB--;
        }

        final void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                detach();
            }
            if (!z && this.uB == 0) {
                clear();
            }
            if (aVar2 != null) {
                eY();
            }
        }

        private a aJ(int i) {
            a aVar = this.uA.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.uA.put(i, aVar2);
            return aVar2;
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public final class p {
        final ArrayList<x> uG = new ArrayList<>();
        ArrayList<x> uH = null;
        final ArrayList<x> uI = new ArrayList<>();
        private final List<x> uJ = Collections.unmodifiableList(this.uG);
        private int uK = 2;
        int uL = 2;
        o uM;
        private v uN;

        public p() {
        }

        public final void clear() {
            this.uG.clear();
            fb();
        }

        public final void aK(int i) {
            this.uK = i;
            eZ();
        }

        final void eZ() {
            this.uL = this.uK + (al.this.sO != null ? al.this.sO.un : 0);
            for (int size = this.uI.size() - 1; size >= 0 && this.uI.size() > this.uL; size--) {
                aN(size);
            }
        }

        public final List<x> fa() {
            return this.uJ;
        }

        private boolean v(x xVar) {
            if (xVar.isRemoved()) {
                return al.this.tE.fj();
            }
            if (xVar.rk < 0 || xVar.rk >= al.this.sN.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + xVar + al.this.dP());
            }
            if (al.this.tE.fj() || al.this.sN.getItemViewType(xVar.rk) == xVar.fy()) {
                return !al.this.sN.hasStableIds() || xVar.fx() == al.this.sN.getItemId(xVar.rk);
            }
            return false;
        }

        private boolean a(x xVar, int i, int i2, long j) {
            xVar.vK = al.this;
            int iFy = xVar.fy();
            long nanoTime = al.this.getNanoTime();
            if (j != LocationRequestCompat.PASSIVE_INTERVAL && !this.uM.b(iFy, nanoTime, j)) {
                return false;
            }
            al.this.sN.c((a) xVar, i);
            this.uM.b(xVar.fy(), al.this.getNanoTime() - nanoTime);
            w(xVar);
            if (!al.this.tE.fj()) {
                return true;
            }
            xVar.vz = i2;
            return true;
        }

        public final int aL(int i) {
            if (i >= 0 && i < al.this.tE.getItemCount()) {
                return !al.this.tE.fj() ? i : al.this.sG.X(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + al.this.tE.getItemCount() + al.this.dP());
        }

        public final View aM(int i) {
            return d(i, false);
        }

        private View d(int i, boolean z) {
            return a(i, false, LocationRequestCompat.PASSIVE_INTERVAL).vu;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:105:0x021a A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x021d  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0179 A[PHI: r1 r4
  0x0179: PHI (r1v12 android.support.v7.widget.al$x) = (r1v11 android.support.v7.widget.al$x), (r1v29 android.support.v7.widget.al$x) binds: [B:28:0x005d, B:58:0x00fb] A[DONT_GENERATE, DONT_INLINE]
  0x0179: PHI (r4v3 boolean) = (r4v2 boolean), (r4v6 boolean) binds: [B:28:0x005d, B:58:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x019a  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x01f0  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
        /* JADX WARN: Type inference failed for: r5v4, types: [android.support.v7.widget.al, android.view.ViewGroup] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final android.support.v7.widget.al.x a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 598
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.al.p.a(int, boolean, long):android.support.v7.widget.al$x");
        }

        private void w(x xVar) {
            if (al.this.ej()) {
                View view = xVar.vu;
                if (android.support.v4.e.o.f(view) == 0) {
                    android.support.v4.e.o.c(view, 1);
                }
                if (android.support.v4.e.o.c(view)) {
                    return;
                }
                xVar.addFlags(16384);
                android.support.v4.e.o.a(view, al.this.tL.fP());
            }
        }

        private void x(x xVar) {
            if (xVar.vu instanceof ViewGroup) {
                a((ViewGroup) xVar.vu, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public final void as(View view) {
            x xVarV = al.V(view);
            if (xVarV.fG()) {
                al.this.removeDetachedView(view, false);
            }
            if (xVarV.fz()) {
                xVarV.fA();
            } else if (xVarV.fB()) {
                xVarV.fC();
            }
            y(xVarV);
        }

        private void fb() {
            for (int size = this.uI.size() - 1; size >= 0; size--) {
                aN(size);
            }
            this.uI.clear();
            if (al.sz) {
                al.this.tD.cZ();
            }
        }

        private void aN(int i) {
            a(this.uI.get(i), true);
            this.uI.remove(i);
        }

        final void y(x xVar) {
            boolean z;
            if (xVar.fz() || xVar.vu.getParent() != null) {
                StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(xVar.fz());
                sb.append(" isAttached:");
                sb.append(xVar.vu.getParent() != null);
                sb.append(al.this.dP());
                throw new IllegalArgumentException(sb.toString());
            }
            if (xVar.fG()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + xVar + al.this.dP());
            }
            if (xVar.ft()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + al.this.dP());
            }
            boolean zFN = xVar.fN();
            if (xVar.fL()) {
                if (this.uL <= 0 || xVar.aU(MediaPlayer.MEDIA_PLAYER_OPTION_AVOUTSYNC_MAX_DIFF)) {
                    z = false;
                } else {
                    int size = this.uI.size();
                    if (size >= this.uL && size > 0) {
                        aN(0);
                        size--;
                    }
                    if (al.sz && size > 0 && !al.this.tD.aj(xVar.rk)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!al.this.tD.aj(this.uI.get(i).rk)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.uI.add(size, xVar);
                    z = true;
                }
                if (!z) {
                    a(xVar, true);
                    z = true;
                }
            } else {
                z = false;
            }
            al.this.sI.K(xVar);
            if (z || z || !zFN) {
                return;
            }
            xVar.vK = null;
        }

        final void a(x xVar, boolean z) {
            al.j(xVar);
            if (xVar.aU(16384)) {
                xVar.setFlags(0, 16384);
                android.support.v4.e.o.a(xVar.vu, (android.support.v4.e.b) null);
            }
            if (z) {
                A(xVar);
            }
            xVar.vK = null;
            getRecycledViewPool().u(xVar);
        }

        final void at(View view) {
            x xVarV = al.V(view);
            xVarV.vG = null;
            xVarV.vH = false;
            xVarV.fC();
            y(xVarV);
        }

        final void au(View view) {
            x xVarV = al.V(view);
            if (xVarV.aU(12) || !xVarV.fO() || al.this.i(xVarV)) {
                if (xVarV.fE() && !xVarV.isRemoved() && !al.this.sN.hasStableIds()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + al.this.dP());
                }
                xVarV.a(this, false);
                this.uG.add(xVarV);
                return;
            }
            if (this.uH == null) {
                this.uH = new ArrayList<>();
            }
            xVarV.a(this, true);
            this.uH.add(xVarV);
        }

        final void z(x xVar) {
            if (xVar.vH) {
                this.uH.remove(xVar);
            } else {
                this.uG.remove(xVar);
            }
            xVar.vG = null;
            xVar.vH = false;
            xVar.fC();
        }

        final int fc() {
            return this.uG.size();
        }

        final View aO(int i) {
            return this.uG.get(i).vu;
        }

        final void fd() {
            this.uG.clear();
            ArrayList<x> arrayList = this.uH;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        private x aP(int i) {
            int size;
            int iX;
            ArrayList<x> arrayList = this.uH;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    x xVar = this.uH.get(i2);
                    if (!xVar.fB() && xVar.fu() == i) {
                        xVar.addFlags(32);
                        return xVar;
                    }
                }
                if (al.this.sN.hasStableIds() && (iX = al.this.sG.X(i)) > 0 && iX < al.this.sN.getItemCount()) {
                    long itemId = al.this.sN.getItemId(iX);
                    for (int i3 = 0; i3 < size; i3++) {
                        x xVar2 = this.uH.get(i3);
                        if (!xVar2.fB() && xVar2.fx() == itemId) {
                            xVar2.addFlags(32);
                            return xVar2;
                        }
                    }
                }
            }
            return null;
        }

        private x e(int i, boolean z) {
            View viewAe;
            int size = this.uG.size();
            for (int i2 = 0; i2 < size; i2++) {
                x xVar = this.uG.get(i2);
                if (!xVar.fB() && xVar.fu() == i && !xVar.fE() && (al.this.tE.vg || !xVar.isRemoved())) {
                    xVar.addFlags(32);
                    return xVar;
                }
            }
            if (!z && (viewAe = al.this.sH.ae(i)) != null) {
                x xVarV = al.V(viewAe);
                al.this.sH.E(viewAe);
                int iIndexOfChild = al.this.sH.indexOfChild(viewAe);
                if (iIndexOfChild == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + xVarV + al.this.dP());
                }
                al.this.sH.detachViewFromParent(iIndexOfChild);
                au(viewAe);
                xVarV.addFlags(AVMDLDataLoader.KeyIsEnableSpeedEngine);
                return xVarV;
            }
            int size2 = this.uI.size();
            for (int i3 = 0; i3 < size2; i3++) {
                x xVar2 = this.uI.get(i3);
                if (!xVar2.fE() && xVar2.fu() == i) {
                    if (!z) {
                        this.uI.remove(i3);
                    }
                    return xVar2;
                }
            }
            return null;
        }

        private x a(long j, int i, boolean z) {
            for (int size = this.uG.size() - 1; size >= 0; size--) {
                x xVar = this.uG.get(size);
                if (xVar.fx() == j && !xVar.fB()) {
                    if (i == xVar.fy()) {
                        xVar.addFlags(32);
                        if (xVar.isRemoved() && !al.this.tE.fj()) {
                            xVar.setFlags(2, 14);
                        }
                        return xVar;
                    }
                    if (!z) {
                        this.uG.remove(size);
                        al.this.removeDetachedView(xVar.vu, false);
                        at(xVar.vu);
                    }
                }
            }
            int size2 = this.uI.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                x xVar2 = this.uI.get(size2);
                if (xVar2.fx() == j) {
                    if (i == xVar2.fy()) {
                        if (!z) {
                            this.uI.remove(size2);
                        }
                        return xVar2;
                    }
                    if (!z) {
                        aN(size2);
                        return null;
                    }
                }
            }
        }

        private void A(x xVar) {
            if (al.this.tE != null) {
                al.this.sI.K(xVar);
            }
        }

        final void a(a aVar, a aVar2, boolean z) {
            clear();
            getRecycledViewPool().a(aVar, aVar2, z);
        }

        final void V(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            int size = this.uI.size();
            for (int i6 = 0; i6 < size; i6++) {
                x xVar = this.uI.get(i6);
                if (xVar != null && xVar.rk >= i4 && xVar.rk <= i3) {
                    if (xVar.rk == i) {
                        xVar.f(i2 - i, false);
                    } else {
                        xVar.f(i5, false);
                    }
                }
            }
        }

        final void W(int i, int i2) {
            int size = this.uI.size();
            for (int i3 = 0; i3 < size; i3++) {
                x xVar = this.uI.get(i3);
                if (xVar != null && xVar.rk >= i) {
                    xVar.f(i2, true);
                }
            }
        }

        final void b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.uI.size() - 1; size >= 0; size--) {
                x xVar = this.uI.get(size);
                if (xVar != null) {
                    if (xVar.rk >= i3) {
                        xVar.f(-i2, z);
                    } else if (xVar.rk >= i) {
                        xVar.addFlags(8);
                        aN(size);
                    }
                }
            }
        }

        final void setViewCacheExtension(v vVar) {
            this.uN = vVar;
        }

        final void setRecycledViewPool(o oVar) {
            o oVar2 = this.uM;
            if (oVar2 != null) {
                oVar2.detach();
            }
            this.uM = oVar;
            if (this.uM == null || al.this.getAdapter() == null) {
                return;
            }
            this.uM.eY();
        }

        final o getRecycledViewPool() {
            if (this.uM == null) {
                this.uM = new o();
            }
            return this.uM;
        }

        final void al(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.uI.size() - 1; size >= 0; size--) {
                x xVar = this.uI.get(size);
                if (xVar != null && (i3 = xVar.rk) >= i && i3 < i4) {
                    xVar.addFlags(2);
                    aN(size);
                }
            }
        }

        final void eA() {
            int size = this.uI.size();
            for (int i = 0; i < size; i++) {
                x xVar = this.uI.get(i);
                if (xVar != null) {
                    xVar.addFlags(6);
                    xVar.r(null);
                }
            }
            if (al.this.sN == null || !al.this.sN.hasStableIds()) {
                fb();
            }
        }

        final void ez() {
            int size = this.uI.size();
            for (int i = 0; i < size; i++) {
                this.uI.get(i).fr();
            }
            int size2 = this.uG.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.uG.get(i2).fr();
            }
            ArrayList<x> arrayList = this.uH;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.uH.get(i3).fr();
                }
            }
        }

        final void ex() {
            int size = this.uI.size();
            for (int i = 0; i < size; i++) {
                j jVar = (j) this.uI.get(i).vu.getLayoutParams();
                if (jVar != null) {
                    jVar.uy = true;
                }
            }
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static abstract class a<VH extends x> {
        private final b tW = new b();
        private boolean tX = false;

        public abstract VH b(ViewGroup viewGroup, int i);

        public abstract void b(VH vh, int i);

        public void e(al alVar) {
        }

        public void f(al alVar) {
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void m(VH vh) {
        }

        public void a(VH vh, int i, List<Object> list) {
            b((a<VH>) vh, i);
        }

        public final VH c(ViewGroup viewGroup, int i) {
            try {
                android.support.v4.os.a.beginSection("RV CreateView");
                VH vh = (VH) b(viewGroup, i);
                if (vh.vu.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.vy = i;
                return vh;
            } finally {
                android.support.v4.os.a.endSection();
            }
        }

        public final void c(VH vh, int i) {
            vh.rk = i;
            if (hasStableIds()) {
                vh.vx = getItemId(i);
            }
            vh.setFlags(1, 519);
            android.support.v4.os.a.beginSection("RV OnBindView");
            a(vh, i, vh.fK());
            vh.fJ();
            ViewGroup.LayoutParams layoutParams = vh.vu.getLayoutParams();
            if (layoutParams instanceof j) {
                ((j) layoutParams).uy = true;
            }
            android.support.v4.os.a.endSection();
        }

        public final boolean hasStableIds() {
            return this.tX;
        }

        public final boolean hasObservers() {
            return this.tW.hasObservers();
        }

        public void a(c cVar) {
            this.tW.registerObserver(cVar);
        }

        public void b(c cVar) {
            this.tW.unregisterObserver(cVar);
        }

        public final void notifyDataSetChanged() {
            this.tW.notifyChanged();
        }

        public final void aD(int i) {
            this.tW.Z(i, 1);
        }

        public final void Z(int i, int i2) {
            this.tW.Z(i, i2);
        }

        public final void d(int i, int i2, Object obj) {
            this.tW.d(i, i2, obj);
        }

        public final void aE(int i) {
            this.tW.ab(i, 1);
        }

        public final void aa(int i, int i2) {
            this.tW.aa(i, i2);
        }

        public final void ab(int i, int i2) {
            this.tW.ab(i, i2);
        }

        public final void aF(int i) {
            this.tW.ac(i, 1);
        }

        public final void ac(int i, int i2) {
            this.tW.ac(i, i2);
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static abstract class i {
        private int km;
        al pD;
        android.support.v7.widget.s sH;
        t ui;
        int un;
        boolean uo;
        private int uq;
        private int ur;
        private int us;
        private final be.b ue = new be.b() { // from class: android.support.v7.widget.al.i.1
            @Override // android.support.v7.widget.be.b
            public final View getChildAt(int i) {
                return i.this.getChildAt(i);
            }

            @Override // android.support.v7.widget.be.b
            public final int eS() {
                return i.this.getPaddingLeft();
            }

            @Override // android.support.v7.widget.be.b
            public final int eT() {
                return i.this.getWidth() - i.this.getPaddingRight();
            }

            @Override // android.support.v7.widget.be.b
            public final int ap(View view) {
                return i.this.ah(view) - ((j) view.getLayoutParams()).leftMargin;
            }

            @Override // android.support.v7.widget.be.b
            public final int aq(View view) {
                return i.this.aj(view) + ((j) view.getLayoutParams()).rightMargin;
            }
        };
        private final be.b uf = new be.b() { // from class: android.support.v7.widget.al.i.2
            @Override // android.support.v7.widget.be.b
            public final View getChildAt(int i) {
                return i.this.getChildAt(i);
            }

            @Override // android.support.v7.widget.be.b
            public final int eS() {
                return i.this.getPaddingTop();
            }

            @Override // android.support.v7.widget.be.b
            public final int eT() {
                return i.this.getHeight() - i.this.getPaddingBottom();
            }

            @Override // android.support.v7.widget.be.b
            public final int ap(View view) {
                return i.this.ai(view) - ((j) view.getLayoutParams()).topMargin;
            }

            @Override // android.support.v7.widget.be.b
            public final int aq(View view) {
                return i.this.ak(view) + ((j) view.getLayoutParams()).bottomMargin;
            }
        };
        be ug = new be(this.ue);
        be uh = new be(this.uf);
        boolean uj = false;
        boolean mp = false;
        boolean uk = false;
        private boolean ul = true;
        private boolean um = true;

        public interface a {
            void B(int i, int i2);
        }

        public static class b {
            public int orientation;
            public int uu;
            public boolean uv;
            public boolean uw;
        }

        public void C(int i, int i2) {
        }

        public void D(int i, int i2) {
        }

        public int a(int i, p pVar, u uVar) {
            return 0;
        }

        public View a(View view, int i, p pVar, u uVar) {
            return null;
        }

        public void a(int i, int i2, u uVar, a aVar) {
        }

        public void a(int i, a aVar) {
        }

        public void a(u uVar) {
        }

        public void a(al alVar, p pVar) {
        }

        public boolean a(j jVar) {
            return jVar != null;
        }

        final boolean a(View view, int i, Bundle bundle) {
            return false;
        }

        public void aB(int i) {
        }

        public void ar(int i) {
        }

        public int b(int i, p pVar, u uVar) {
            return 0;
        }

        public void c(al alVar, int i, int i2) {
        }

        public int d(u uVar) {
            return 0;
        }

        public void d(al alVar, int i, int i2) {
        }

        public void dc() {
        }

        public abstract j dd();

        public boolean dh() {
            return false;
        }

        public boolean dm() {
            return false;
        }

        public boolean dn() {
            return false;
        }

        boolean ds() {
            return false;
        }

        public int e(u uVar) {
            return 0;
        }

        public int f(u uVar) {
            return 0;
        }

        public int g(u uVar) {
            return 0;
        }

        public int h(u uVar) {
            return 0;
        }

        public int i(u uVar) {
            return 0;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        final void h(al alVar) {
            if (alVar == null) {
                this.pD = null;
                this.sH = null;
                this.us = 0;
                this.km = 0;
            } else {
                this.pD = alVar;
                this.sH = alVar.sH;
                this.us = alVar.getWidth();
                this.km = alVar.getHeight();
            }
            this.uq = 1073741824;
            this.ur = 1073741824;
        }

        final void ag(int i, int i2) {
            this.us = View.MeasureSpec.getSize(i);
            this.uq = View.MeasureSpec.getMode(i);
            if (this.uq == 0 && !al.sx) {
                this.us = 0;
            }
            this.km = View.MeasureSpec.getSize(i2);
            this.ur = View.MeasureSpec.getMode(i2);
            if (this.ur != 0 || al.sx) {
                return;
            }
            this.km = 0;
        }

        final void ah(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.pD.T(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.pD.ei;
                b(childAt, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.pD.ei.set(i3, i4, i5, i6);
            a(this.pD.ei, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            setMeasuredDimension(f(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), f(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            al alVar = this.pD;
            if (alVar != null) {
                alVar.requestLayout();
            }
        }

        public static int f(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void c(String str) {
            al alVar = this.pD;
            if (alVar != null) {
                alVar.c(str);
            }
        }

        public boolean dl() {
            return this.uk;
        }

        public final boolean eL() {
            return this.um;
        }

        final void i(al alVar) {
            this.mp = true;
        }

        final void b(al alVar, p pVar) {
            this.mp = false;
            a(alVar, pVar);
        }

        public final boolean isAttachedToWindow() {
            return this.mp;
        }

        public final boolean removeCallbacks(Runnable runnable) {
            al alVar = this.pD;
            if (alVar != null) {
                return alVar.removeCallbacks(runnable);
            }
            return false;
        }

        public final boolean getClipToPadding() {
            al alVar = this.pD;
            return alVar != null && alVar.sJ;
        }

        public void c(p pVar, u uVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public j c(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof j) {
                return new j((j) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new j((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new j(layoutParams);
        }

        public j a(Context context, AttributeSet attributeSet) {
            return new j(context, attributeSet);
        }

        public void a(al alVar, u uVar, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public final void a(t tVar) {
            t tVar2 = this.ui;
            if (tVar2 != null && tVar != tVar2 && tVar2.isRunning()) {
                this.ui.stop();
            }
            this.ui = tVar;
            this.ui.a(this.pD, this);
        }

        public final boolean eM() {
            t tVar = this.ui;
            return tVar != null && tVar.isRunning();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.support.v7.widget.al, android.view.View] */
        public final int getLayoutDirection() {
            return android.support.v4.e.o.g(this.pD);
        }

        public final void ad(View view) {
            k(view, -1);
        }

        public final void k(View view, int i) {
            c(view, i, true);
        }

        public final void addView(View view) {
            addView(view, -1);
        }

        public final void addView(View view, int i) {
            c(view, i, false);
        }

        private void c(View view, int i, boolean z) {
            x xVarV = al.V(view);
            if (z || xVarV.isRemoved()) {
                this.pD.sI.I(xVarV);
            } else {
                this.pD.sI.J(xVarV);
            }
            j jVar = (j) view.getLayoutParams();
            if (xVarV.fB() || xVarV.fz()) {
                if (xVarV.fz()) {
                    xVarV.fA();
                } else {
                    xVarV.fC();
                }
                this.sH.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.pD) {
                int iIndexOfChild = this.sH.indexOfChild(view);
                if (i == -1) {
                    i = this.sH.getChildCount();
                }
                if (iIndexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.pD.indexOfChild(view) + this.pD.dP());
                }
                if (iIndexOfChild != i) {
                    this.pD.sO.ai(iIndexOfChild, i);
                }
            } else {
                this.sH.a(view, i, false);
                jVar.uy = true;
                t tVar = this.ui;
                if (tVar != null && tVar.isRunning()) {
                    this.ui.av(view);
                }
            }
            if (jVar.uz) {
                xVarV.vu.invalidate();
                jVar.uz = false;
            }
        }

        private void removeView(View view) {
            this.sH.removeView(view);
        }

        private void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.sH.removeViewAt(i);
            }
        }

        public static int ae(View view) {
            return ((j) view.getLayoutParams()).eX();
        }

        public final View T(View view) {
            View viewT;
            al alVar = this.pD;
            if (alVar == null || (viewT = alVar.T(view)) == null || this.sH.C(viewT)) {
                return null;
            }
            return viewT;
        }

        public View ap(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                x xVarV = al.V(childAt);
                if (xVarV != null && xVarV.fu() == i && !xVarV.ft() && (this.pD.tE.fj() || !xVarV.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        private void aG(int i) {
            getChildAt(i);
            aH(i);
        }

        private void aH(int i) {
            this.sH.detachViewFromParent(i);
        }

        private void a(View view, int i, j jVar) {
            x xVarV = al.V(view);
            if (xVarV.isRemoved()) {
                this.pD.sI.I(xVarV);
            } else {
                this.pD.sI.J(xVarV);
            }
            this.sH.a(view, i, jVar, xVarV.isRemoved());
        }

        private void l(View view, int i) {
            a(view, i, (j) view.getLayoutParams());
        }

        private void ai(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.pD.toString());
            }
            aG(i);
            l(childAt, i2);
        }

        public final void a(View view, p pVar) {
            removeView(view);
            pVar.as(view);
        }

        public final void a(int i, p pVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            pVar.as(childAt);
        }

        public final int getChildCount() {
            android.support.v7.widget.s sVar = this.sH;
            if (sVar != null) {
                return sVar.getChildCount();
            }
            return 0;
        }

        public final View getChildAt(int i) {
            android.support.v7.widget.s sVar = this.sH;
            if (sVar != null) {
                return sVar.getChildAt(i);
            }
            return null;
        }

        public final int eN() {
            return this.uq;
        }

        public final int eO() {
            return this.ur;
        }

        public final int getWidth() {
            return this.us;
        }

        public final int getHeight() {
            return this.km;
        }

        public final int getPaddingLeft() {
            al alVar = this.pD;
            if (alVar != null) {
                return alVar.getPaddingLeft();
            }
            return 0;
        }

        public final int getPaddingTop() {
            al alVar = this.pD;
            if (alVar != null) {
                return alVar.getPaddingTop();
            }
            return 0;
        }

        public final int getPaddingRight() {
            al alVar = this.pD;
            if (alVar != null) {
                return alVar.getPaddingRight();
            }
            return 0;
        }

        public final int getPaddingBottom() {
            al alVar = this.pD;
            if (alVar != null) {
                return alVar.getPaddingBottom();
            }
            return 0;
        }

        public final View getFocusedChild() {
            View focusedChild;
            al alVar = this.pD;
            if (alVar == null || (focusedChild = alVar.getFocusedChild()) == null || this.sH.C(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public final int getItemCount() {
            al alVar = this.pD;
            a adapter = alVar != null ? alVar.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void aA(int i) {
            al alVar = this.pD;
            if (alVar != null) {
                alVar.aA(i);
            }
        }

        public void az(int i) {
            al alVar = this.pD;
            if (alVar != null) {
                alVar.az(i);
            }
        }

        public final void b(p pVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                a(pVar, childCount, getChildAt(childCount));
            }
        }

        private void a(p pVar, int i, View view) {
            x xVarV = al.V(view);
            if (xVarV.ft()) {
                return;
            }
            if (xVarV.fE() && !xVarV.isRemoved() && !this.pD.sN.hasStableIds()) {
                removeViewAt(i);
                pVar.y(xVarV);
            } else {
                aG(i);
                pVar.au(view);
                this.pD.sI.L(xVarV);
            }
        }

        final void c(p pVar) {
            int iFc = pVar.fc();
            for (int i = iFc - 1; i >= 0; i--) {
                View viewAO = pVar.aO(i);
                x xVarV = al.V(viewAO);
                if (!xVarV.ft()) {
                    xVarV.z(false);
                    if (xVarV.fG()) {
                        this.pD.removeDetachedView(viewAO, false);
                    }
                    if (this.pD.to != null) {
                        this.pD.to.e(xVarV);
                    }
                    xVarV.z(true);
                    pVar.at(viewAO);
                }
            }
            pVar.fd();
            if (iFc > 0) {
                this.pD.invalidate();
            }
        }

        final boolean a(View view, int i, int i2, j jVar) {
            return (this.ul && g(view.getMeasuredWidth(), i, jVar.width) && g(view.getMeasuredHeight(), i2, jVar.height)) ? false : true;
        }

        final boolean b(View view, int i, int i2, j jVar) {
            return (!view.isLayoutRequested() && this.ul && g(view.getWidth(), i, jVar.width) && g(view.getHeight(), i2, jVar.height)) ? false : true;
        }

        private static boolean g(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public final void b(View view, int i, int i2) {
            j jVar = (j) view.getLayoutParams();
            Rect rectZ = this.pD.Z(view);
            int i3 = rectZ.left + rectZ.right + 0;
            int i4 = rectZ.top + rectZ.bottom + 0;
            int iA = a(getWidth(), eN(), getPaddingLeft() + getPaddingRight() + jVar.leftMargin + jVar.rightMargin + i3, jVar.width, dm());
            int iA2 = a(getHeight(), eO(), getPaddingTop() + getPaddingBottom() + jVar.topMargin + jVar.bottomMargin + i4, jVar.height, dn());
            if (b(view, iA, iA2, jVar)) {
                view.measure(iA, iA2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int a(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2e
                if (r5 == r2) goto L21
                if (r5 == 0) goto L2e
                if (r5 == r3) goto L21
                goto L2e
            L1a:
                if (r7 < 0) goto L1f
            L1c:
                r6 = 1073741824(0x40000000, float:2.0)
                goto L2f
            L1f:
                if (r7 != r1) goto L24
            L21:
                r7 = r4
                r6 = r5
                goto L2f
            L24:
                if (r7 != r0) goto L2e
                if (r5 == r2) goto L2a
                if (r5 != r3) goto L2c
            L2a:
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
            L2c:
                r7 = r4
                goto L2f
            L2e:
                r7 = 0
            L2f:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.al.i.a(int, int, int, int, boolean):int");
        }

        public static int af(View view) {
            Rect rect = ((j) view.getLayoutParams()).qu;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public static int ag(View view) {
            Rect rect = ((j) view.getLayoutParams()).qu;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public static void d(View view, int i, int i2, int i3, int i4) {
            j jVar = (j) view.getLayoutParams();
            Rect rect = jVar.qu;
            view.layout(i + rect.left + jVar.leftMargin, i2 + rect.top + jVar.topMargin, (i3 - rect.right) - jVar.rightMargin, (i4 - rect.bottom) - jVar.bottomMargin);
        }

        public final void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            Rect rect2 = ((j) view.getLayoutParams()).qu;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            if (this.pD != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.pD.sM;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        private static void b(View view, Rect rect) {
            al.a(view, rect);
        }

        public final int ah(View view) {
            return view.getLeft() - an(view);
        }

        public final int ai(View view) {
            return view.getTop() - al(view);
        }

        public final int aj(View view) {
            return view.getRight() + ao(view);
        }

        public final int ak(View view) {
            return view.getBottom() + am(view);
        }

        public final void c(View view, Rect rect) {
            al alVar = this.pD;
            if (alVar == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(alVar.Z(view));
            }
        }

        public static int al(View view) {
            return ((j) view.getLayoutParams()).qu.top;
        }

        public static int am(View view) {
            return ((j) view.getLayoutParams()).qu.bottom;
        }

        public static int an(View view) {
            return ((j) view.getLayoutParams()).qu.left;
        }

        public static int ao(View view) {
            return ((j) view.getLayoutParams()).qu.right;
        }

        private int[] d(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - paddingLeft;
            int iMin = Math.min(0, i);
            int i2 = top - paddingTop;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - width;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - height);
            if (getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public final boolean a(al alVar, View view, Rect rect, boolean z) {
            return a(alVar, view, rect, z, false);
        }

        public boolean a(al alVar, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrD = d(view, rect);
            int i = iArrD[0];
            int i2 = iArrD[1];
            if ((z2 && !f(alVar, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                alVar.scrollBy(i, i2);
            } else {
                alVar.smoothScrollBy(i, i2);
            }
            return true;
        }

        public final boolean b(View view, boolean z) {
            return !(this.ug.n(view, 24579) && this.uh.n(view, 24579));
        }

        private boolean f(al alVar, int i, int i2) {
            View focusedChild = alVar.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.pD.ei;
            b(focusedChild, rect);
            return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        @Deprecated
        private boolean j(al alVar) {
            return eM() || alVar.el();
        }

        public final boolean a(al alVar, View view, View view2) {
            return j(alVar);
        }

        public final void aj(int i, int i2) {
            this.pD.T(i, i2);
        }

        public final void setMeasuredDimension(int i, int i2) {
            al.e(this.pD, i, i2);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.support.v7.widget.al, android.view.View] */
        public final int getMinimumWidth() {
            return android.support.v4.e.o.h(this.pD);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.support.v7.widget.al, android.view.View] */
        public final int getMinimumHeight() {
            return android.support.v4.e.o.i(this.pD);
        }

        final void eP() {
            t tVar = this.ui;
            if (tVar != null) {
                tVar.stop();
            }
        }

        final void b(t tVar) {
            if (this.ui == tVar) {
                this.ui = null;
            }
        }

        public final void d(p pVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!al.V(getChildAt(childCount)).ft()) {
                    a(childCount, pVar);
                }
            }
        }

        final void a(android.support.v4.e.a.b bVar) {
            a(this.pD.sE, this.pD.tE, bVar);
        }

        public void a(p pVar, u uVar, android.support.v4.e.a.b bVar) {
            if (this.pD.canScrollVertically(-1) || this.pD.canScrollHorizontally(-1)) {
                bVar.addAction(8192);
                bVar.setScrollable(true);
            }
            if (this.pD.canScrollVertically(1) || this.pD.canScrollHorizontally(1)) {
                bVar.addAction(4096);
                bVar.setScrollable(true);
            }
            bVar.m(b.C0008b.a(a(pVar, uVar), b(pVar, uVar), false, 0));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            c(accessibilityEvent);
        }

        private void c(AccessibilityEvent accessibilityEvent) {
            al alVar = this.pD;
            if (alVar == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!alVar.canScrollVertically(1) && !this.pD.canScrollVertically(-1) && !this.pD.canScrollHorizontally(-1) && !this.pD.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (this.pD.sN != null) {
                accessibilityEvent.setItemCount(this.pD.sN.getItemCount());
            }
        }

        final void b(View view, android.support.v4.e.a.b bVar) {
            x xVarV = al.V(view);
            if (xVarV == null || xVarV.isRemoved() || this.sH.C(xVarV.vu)) {
                return;
            }
            a(this.pD.sE, this.pD.tE, view, bVar);
        }

        public void a(p pVar, u uVar, View view, android.support.v4.e.a.b bVar) {
            bVar.n(b.c.a(dn() ? ae(view) : 0, 1, dm() ? ae(view) : 0, 1, false, false));
        }

        public final void eQ() {
            this.uj = true;
        }

        public int a(p pVar, u uVar) {
            al alVar = this.pD;
            if (alVar == null || alVar.sN == null || !dn()) {
                return 1;
            }
            return this.pD.sN.getItemCount();
        }

        public int b(p pVar, u uVar) {
            al alVar = this.pD;
            if (alVar == null || alVar.sN == null || !dm()) {
                return 1;
            }
            return this.pD.sN.getItemCount();
        }

        final boolean performAccessibilityAction(int i, Bundle bundle) {
            return a(this.pD.sE, this.pD.tE, i, bundle);
        }

        public boolean a(p pVar, u uVar, int i, Bundle bundle) {
            int height;
            int width;
            al alVar = this.pD;
            if (alVar == null) {
                return false;
            }
            if (i != 4096) {
                if (i != 8192) {
                    height = 0;
                } else {
                    height = alVar.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                    if (this.pD.canScrollHorizontally(-1)) {
                        width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    }
                }
            } else {
                height = alVar.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                width = this.pD.canScrollHorizontally(1) ? (getWidth() - getPaddingLeft()) - getPaddingRight() : 0;
            }
            if (height == 0 && width == 0) {
                return false;
            }
            this.pD.smoothScrollBy(width, height);
            return true;
        }

        public static b b(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i, i2);
            bVar.orientation = typedArrayObtainStyledAttributes.getInt(a.b.RecyclerView_android_orientation, 1);
            bVar.uu = typedArrayObtainStyledAttributes.getInt(a.b.RecyclerView_spanCount, 1);
            bVar.uv = typedArrayObtainStyledAttributes.getBoolean(a.b.RecyclerView_reverseLayout, false);
            bVar.uw = typedArrayObtainStyledAttributes.getBoolean(a.b.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return bVar;
        }

        final void k(al alVar) {
            ag(View.MeasureSpec.makeMeasureSpec(alVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(alVar.getHeight(), 1073741824));
        }

        final boolean eR() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static abstract class h {
        public void a(Canvas canvas, al alVar) {
        }

        @Deprecated
        private static void b(Rect rect) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, al alVar, u uVar) {
            view.getLayoutParams();
            b(rect);
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static abstract class x {
        private static final List<Object> vC = Collections.emptyList();
        int ht;
        al vK;
        public final View vu;
        WeakReference<al> vv;
        int rk = -1;
        int vw = -1;
        long vx = -1;
        int vy = -1;
        int vz = -1;
        x vA = null;
        x vB = null;
        List<Object> vD = null;
        List<Object> vE = null;
        private int vF = 0;
        p vG = null;
        boolean vH = false;
        private int vI = 0;
        int vJ = -1;

        public x(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.vu = view;
        }

        final void c(int i, int i2, boolean z) {
            addFlags(8);
            f(i2, z);
            this.rk = i;
        }

        final void f(int i, boolean z) {
            if (this.vw == -1) {
                this.vw = this.rk;
            }
            if (this.vz == -1) {
                this.vz = this.rk;
            }
            if (z) {
                this.vz += i;
            }
            this.rk += i;
            if (this.vu.getLayoutParams() != null) {
                ((j) this.vu.getLayoutParams()).uy = true;
            }
        }

        final void fr() {
            this.vw = -1;
            this.vz = -1;
        }

        final void fs() {
            if (this.vw == -1) {
                this.vw = this.rk;
            }
        }

        final boolean ft() {
            return (this.ht & 128) != 0;
        }

        public final int fu() {
            int i = this.vz;
            return i == -1 ? this.rk : i;
        }

        public final int fv() {
            al alVar = this.vK;
            if (alVar == null) {
                return -1;
            }
            return alVar.k(this);
        }

        public final int fw() {
            return this.vw;
        }

        public final long fx() {
            return this.vx;
        }

        public final int fy() {
            return this.vy;
        }

        final boolean fz() {
            return this.vG != null;
        }

        final void fA() {
            this.vG.z(this);
        }

        final boolean fB() {
            return (this.ht & 32) != 0;
        }

        final void fC() {
            this.ht &= -33;
        }

        final void fD() {
            this.ht &= -257;
        }

        final void a(p pVar, boolean z) {
            this.vG = pVar;
            this.vH = z;
        }

        final boolean fE() {
            return (this.ht & 4) != 0;
        }

        final boolean fF() {
            return (this.ht & 2) != 0;
        }

        final boolean isBound() {
            return (this.ht & 1) != 0;
        }

        final boolean isRemoved() {
            return (this.ht & 8) != 0;
        }

        final boolean aU(int i) {
            return (i & this.ht) != 0;
        }

        final boolean fG() {
            return (this.ht & 256) != 0;
        }

        private boolean fH() {
            return (this.ht & 512) != 0 || fE();
        }

        final void setFlags(int i, int i2) {
            this.ht = (i & i2) | (this.ht & (i2 ^ (-1)));
        }

        final void addFlags(int i) {
            this.ht = i | this.ht;
        }

        final void r(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.ht) == 0) {
                fI();
                this.vD.add(obj);
            }
        }

        private void fI() {
            if (this.vD == null) {
                this.vD = new ArrayList();
                this.vE = Collections.unmodifiableList(this.vD);
            }
        }

        final void fJ() {
            List<Object> list = this.vD;
            if (list != null) {
                list.clear();
            }
            this.ht &= -1025;
        }

        final List<Object> fK() {
            if ((this.ht & 1024) == 0) {
                List<Object> list = this.vD;
                if (list == null || list.size() == 0) {
                    return vC;
                }
                return this.vE;
            }
            return vC;
        }

        final void dA() {
            this.ht = 0;
            this.rk = -1;
            this.vw = -1;
            this.vx = -1L;
            this.vz = -1;
            this.vF = 0;
            this.vA = null;
            this.vB = null;
            fJ();
            this.vI = 0;
            this.vJ = -1;
            al.j(this);
        }

        final void m(al alVar) {
            int i = this.vJ;
            if (i != -1) {
                this.vI = i;
            } else {
                this.vI = android.support.v4.e.o.f(this.vu);
            }
            alVar.a(this, 4);
        }

        final void n(al alVar) {
            alVar.a(this, this.vI);
            this.vI = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.rk + " id=" + this.vx + ", oldPos=" + this.vw + ", pLpos:" + this.vz);
            if (fz()) {
                sb.append(" scrap ");
                sb.append(this.vH ? "[changeScrap]" : "[attachedScrap]");
            }
            if (fE()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (fF()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (ft()) {
                sb.append(" ignored");
            }
            if (fG()) {
                sb.append(" tmpDetached");
            }
            if (!fL()) {
                sb.append(" not recyclable(" + this.vF + ")");
            }
            if (fH()) {
                sb.append(" undefined adapter position");
            }
            if (this.vu.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append(com.alipay.sdk.m.u.i.d);
            return sb.toString();
        }

        public final void z(boolean z) {
            int i = this.vF;
            this.vF = z ? i - 1 : i + 1;
            int i2 = this.vF;
            if (i2 < 0) {
                this.vF = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i2 == 1) {
                this.ht |= 16;
            } else if (z && this.vF == 0) {
                this.ht &= -17;
            }
        }

        public final boolean fL() {
            return (this.ht & 16) == 0 && !android.support.v4.e.o.d(this.vu);
        }

        final boolean fM() {
            return (this.ht & 16) != 0;
        }

        final boolean fN() {
            return (this.ht & 16) == 0 && android.support.v4.e.o.d(this.vu);
        }

        final boolean fO() {
            return (this.ht & 2) != 0;
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static class j extends ViewGroup.MarginLayoutParams {
        final Rect qu;
        x ux;
        boolean uy;
        boolean uz;

        public j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.qu = new Rect();
            this.uy = true;
            this.uz = false;
        }

        public j(int i, int i2) {
            super(i, i2);
            this.qu = new Rect();
            this.uy = true;
            this.uz = false;
        }

        public j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.qu = new Rect();
            this.uy = true;
            this.uz = false;
        }

        public j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.qu = new Rect();
            this.uy = true;
            this.uz = false;
        }

        public j(j jVar) {
            super((ViewGroup.LayoutParams) jVar);
            this.qu = new Rect();
            this.uy = true;
            this.uz = false;
        }

        public final boolean eU() {
            return this.ux.fE();
        }

        public final boolean eV() {
            return this.ux.isRemoved();
        }

        public final boolean eW() {
            return this.ux.fO();
        }

        public final int eX() {
            return this.ux.fu();
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static abstract class c {
        public void ad(int i, int i2) {
        }

        public void ae(int i, int i2) {
        }

        public void af(int i, int i2) {
        }

        public void e(int i, int i2, int i3) {
        }

        public void onChanged() {
        }

        public void e(int i, int i2, Object obj) {
            ad(i, i2);
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static abstract class t {
        private i mLayoutManager;
        private al pD;
        private boolean q;
        private boolean uQ;
        private boolean uR;
        private View uS;
        private int uP = -1;
        private final a uT = new a(0, 0);

        public interface b {
            PointF aq(int i);
        }

        protected abstract void a(int i, int i2, a aVar);

        protected abstract void a(View view, a aVar);

        protected abstract void onStop();

        final void a(al alVar, i iVar) {
            if (this.q) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.pD = alVar;
            this.mLayoutManager = iVar;
            if (this.uP == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.pD.tE.uP = this.uP;
            this.uR = true;
            this.uQ = true;
            this.uS = ap(fg());
            this.pD.tB.fq();
            this.q = true;
        }

        public final void aR(int i) {
            this.uP = i;
        }

        public PointF aq(int i) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof b) {
                return ((b) layoutManager).aq(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public final i getLayoutManager() {
            return this.mLayoutManager;
        }

        protected final void stop() {
            if (this.uR) {
                this.uR = false;
                onStop();
                this.pD.tE.uP = -1;
                this.uS = null;
                this.uP = -1;
                this.uQ = false;
                this.mLayoutManager.b(this);
                this.mLayoutManager = null;
                this.pD = null;
            }
        }

        public final boolean ff() {
            return this.uQ;
        }

        public final boolean isRunning() {
            return this.uR;
        }

        public final int fg() {
            return this.uP;
        }

        final void am(int i, int i2) {
            PointF pointFAq;
            al alVar = this.pD;
            if (!this.uR || this.uP == -1 || alVar == null) {
                stop();
            }
            if (this.uQ && this.uS == null && this.mLayoutManager != null && (pointFAq = aq(this.uP)) != null && (pointFAq.x != 0.0f || pointFAq.y != 0.0f)) {
                alVar.a((int) Math.signum(pointFAq.x), (int) Math.signum(pointFAq.y), null);
            }
            this.uQ = false;
            View view = this.uS;
            if (view != null) {
                if (W(view) == this.uP) {
                    a(this.uS, this.uT);
                    this.uT.l(alVar);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.uS = null;
                }
            }
            if (this.uR) {
                a(i, i2, this.uT);
                boolean zFh = this.uT.fh();
                this.uT.l(alVar);
                if (zFh) {
                    if (this.uR) {
                        this.uQ = true;
                        alVar.tB.fq();
                    } else {
                        stop();
                    }
                }
            }
        }

        private int W(View view) {
            return al.Y(view);
        }

        public final int getChildCount() {
            return this.pD.sO.getChildCount();
        }

        private View ap(int i) {
            return this.pD.sO.ap(i);
        }

        protected final void av(View view) {
            if (W(view) == fg()) {
                this.uS = view;
            }
        }

        protected static void a(PointF pointF) {
            float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public static class a {
            private Interpolator mInterpolator;
            private int uU;
            private int uV;
            private int uW;
            private int uX;
            private boolean uY;
            private int uZ;

            public a(int i, int i2) {
                this(0, 0, Integer.MIN_VALUE, null);
            }

            private a(int i, int i2, int i3, Interpolator interpolator) {
                this.uX = -1;
                this.uY = false;
                this.uZ = 0;
                this.uU = i;
                this.uV = i2;
                this.uW = Integer.MIN_VALUE;
                this.mInterpolator = null;
            }

            public final void aS(int i) {
                this.uX = i;
            }

            final boolean fh() {
                return this.uX >= 0;
            }

            final void l(al alVar) {
                int i = this.uX;
                if (i >= 0) {
                    this.uX = -1;
                    alVar.ax(i);
                    this.uY = false;
                } else {
                    if (this.uY) {
                        fi();
                        if (this.mInterpolator == null) {
                            if (this.uW == Integer.MIN_VALUE) {
                                alVar.tB.smoothScrollBy(this.uU, this.uV);
                            } else {
                                alVar.tB.h(this.uU, this.uV, this.uW);
                            }
                        } else {
                            alVar.tB.b(this.uU, this.uV, this.uW, this.mInterpolator);
                        }
                        this.uZ++;
                        if (this.uZ > 10) {
                            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.uY = false;
                        return;
                    }
                    this.uZ = 0;
                }
            }

            private void fi() {
                if (this.mInterpolator != null && this.uW <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.uW <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public final void a(int i, int i2, int i3, Interpolator interpolator) {
                this.uU = i;
                this.uV = i2;
                this.uW = i3;
                this.mInterpolator = interpolator;
                this.uY = true;
            }
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    static class b extends Observable<c> {
        b() {
        }

        public final boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public final void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onChanged();
            }
        }

        public final void Z(int i, int i2) {
            d(i, i2, null);
        }

        public final void d(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).e(i, i2, obj);
            }
        }

        public final void ab(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).ae(i, i2);
            }
        }

        public final void ac(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).af(i, i2);
            }
        }

        public final void aa(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).e(i, i2, 1);
            }
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static class s extends android.support.v4.e.a {
        public static final Parcelable.Creator<s> CREATOR = new Parcelable.ClassLoaderCreator<s>() { // from class: android.support.v7.widget.al.s.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return d(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ s createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object[] newArray(int i) {
                return aQ(i);
            }

            private static s b(Parcel parcel, ClassLoader classLoader) {
                return new s(parcel, classLoader);
            }

            private static s d(Parcel parcel) {
                return new s(parcel, null);
            }

            private static s[] aQ(int i) {
                return new s[i];
            }
        };
        Parcelable uO;

        s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.uO = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        s(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.e.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.uO, 0);
        }

        final void a(s sVar) {
            this.uO = sVar.uO;
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static class u {
        private SparseArray<Object> va;
        int vl;
        long vm;
        int vn;
        int vo;
        int vp;
        int uP = -1;
        int vb = 0;
        int vc = 0;
        int vd = 1;
        int ve = 0;
        boolean vf = false;
        boolean vg = false;
        boolean vh = false;
        boolean vi = false;
        boolean vj = false;
        boolean vk = false;

        final void aT(int i) {
            if ((this.vd & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.vd));
        }

        final void a(a aVar) {
            this.vd = 1;
            this.ve = aVar.getItemCount();
            this.vg = false;
            this.vh = false;
            this.vi = false;
        }

        public final boolean fj() {
            return this.vg;
        }

        public final boolean fk() {
            return this.vk;
        }

        public final int fl() {
            return this.uP;
        }

        public final boolean fm() {
            return this.uP != -1;
        }

        public final int getItemCount() {
            return this.vg ? this.vb - this.vc : this.ve;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.uP + ", mData=" + this.va + ", mItemCount=" + this.ve + ", mIsMeasuring=" + this.vi + ", mPreviousLayoutItemCount=" + this.vb + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.vc + ", mStructureChanged=" + this.vf + ", mInPreLayout=" + this.vg + ", mRunSimpleAnimations=" + this.vj + ", mRunPredictiveAnimations=" + this.vk + '}';
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    class g implements f.a {
        g() {
        }

        @Override // android.support.v7.widget.al.f.a
        public final void r(x xVar) {
            xVar.z(true);
            if (xVar.vA != null && xVar.vB == null) {
                xVar.vA = null;
            }
            xVar.vB = null;
            if (xVar.fM() || al.this.R(xVar.vu) || !xVar.fG()) {
                return;
            }
            al.this.removeDetachedView(xVar.vu, false);
        }
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static abstract class f {
        private a tY = null;
        private ArrayList<Object> tZ = new ArrayList<>();
        private long ua = 120;
        private long ub = 120;
        private long uc = 250;
        private long ud = 250;

        interface a {
            void r(x xVar);
        }

        public abstract boolean a(x xVar, x xVar2, b bVar, b bVar2);

        public abstract void cI();

        public abstract void cK();

        public abstract void e(x xVar);

        public abstract boolean f(x xVar, b bVar, b bVar2);

        public abstract boolean g(x xVar, b bVar, b bVar2);

        public abstract boolean h(x xVar, b bVar, b bVar2);

        public boolean i(x xVar) {
            return true;
        }

        public abstract boolean isRunning();

        public final long eF() {
            return this.uc;
        }

        public final void f(long j) {
            this.uc = 500L;
        }

        public final long eG() {
            return this.ua;
        }

        public final void g(long j) {
            this.ua = 500L;
        }

        public final long eH() {
            return this.ub;
        }

        public final void h(long j) {
            this.ub = 500L;
        }

        public final long eI() {
            return this.ud;
        }

        public final void i(long j) {
            this.ud = 500L;
        }

        final void a(a aVar) {
            this.tY = aVar;
        }

        public final b n(x xVar) {
            return eK().s(xVar);
        }

        public final b o(x xVar) {
            return eK().s(xVar);
        }

        static int p(x xVar) {
            int i = xVar.ht & 14;
            if (xVar.fE()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iFw = xVar.fw();
            int iFv = xVar.fv();
            return (iFw == -1 || iFv == -1 || iFw == iFv) ? i : i | 2048;
        }

        public final void q(x xVar) {
            a aVar = this.tY;
            if (aVar != null) {
                aVar.r(xVar);
            }
        }

        public boolean a(x xVar, List<Object> list) {
            return i(xVar);
        }

        public final void eJ() {
            int size = this.tZ.size();
            for (int i = 0; i < size; i++) {
                this.tZ.get(i);
            }
            this.tZ.clear();
        }

        private static b eK() {
            return new b();
        }

        public static class b {
            public int bottom;
            public int left;
            public int right;
            public int top;

            public final b s(x xVar) {
                return t(xVar);
            }

            private b t(x xVar) {
                View view = xVar.vu;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }
    }
}
