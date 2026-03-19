package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class h {
    private static h mn;
    private boolean mA;
    private WeakHashMap<Context, android.support.v4.d.l<ColorStateList>> mv;
    private android.support.v4.d.a<String, d> mw;
    private android.support.v4.d.l<String> mx;
    private final WeakHashMap<Context, android.support.v4.d.e<WeakReference<Drawable.ConstantState>>> my = new WeakHashMap<>(0);
    private TypedValue mz;
    private static final PorterDuff.Mode mm = PorterDuff.Mode.SRC_IN;
    private static final c mo = new c(6);
    private static final int[] mp = {a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] mq = {a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] mr = {a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};

    /* renamed from: ms, reason: collision with root package name */
    private static final int[] f710ms = {a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] mt = {a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};
    private static final int[] mu = {a.e.abc_btn_check_material, a.e.abc_btn_radio_material};

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public static synchronized h cH() {
        if (mn == null) {
            h hVar = new h();
            mn = hVar;
            a(hVar);
        }
        return mn;
    }

    private static void a(h hVar) {
        if (Build.VERSION.SDK_INT < 24) {
            hVar.a("vector", new e());
            hVar.a("animated-vector", new b());
            hVar.a("animated-selector", new a());
        }
    }

    public final synchronized Drawable a(Context context, int i) {
        return a(context, i, false);
    }

    private synchronized Drawable a(Context context, int i, boolean z) {
        Drawable drawableG;
        h(context);
        drawableG = g(context, i);
        if (drawableG == null) {
            drawableG = f(context, i);
        }
        if (drawableG == null) {
            drawableG = android.support.v4.content.a.a(context, i);
        }
        if (drawableG != null) {
            drawableG = a(context, i, false, drawableG);
        }
        if (drawableG != null) {
            v.k(drawableG);
        }
        return drawableG;
    }

    private static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(Context context, int i) throws Resources.NotFoundException {
        if (this.mz == null) {
            this.mz = new TypedValue();
        }
        TypedValue typedValue = this.mz;
        context.getResources().getValue(i, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        if (i == a.e.abc_cab_background_top_material) {
            drawableA = new LayerDrawable(new Drawable[]{a(context, a.e.abc_cab_background_internal_bg), a(context, a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jA, drawableA);
        }
        return drawableA;
    }

    private Drawable a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList colorStateListH = h(context, i);
        if (colorStateListH != null) {
            if (v.l(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawableC = android.support.v4.graphics.drawable.a.c(drawable);
            android.support.v4.graphics.drawable.a.a(drawableC, colorStateListH);
            PorterDuff.Mode modeAb = ab(i);
            if (modeAb == null) {
                return drawableC;
            }
            android.support.v4.graphics.drawable.a.a(drawableC, modeAb);
            return drawableC;
        }
        if (i == a.e.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(R.id.background), ar.l(context, a.C0010a.colorControlNormal), mm);
            a(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), ar.l(context, a.C0010a.colorControlNormal), mm);
            a(layerDrawable.findDrawableByLayerId(R.id.progress), ar.l(context, a.C0010a.colorControlActivated), mm);
            return drawable;
        }
        if (i == a.e.abc_ratingbar_material || i == a.e.abc_ratingbar_indicator_material || i == a.e.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(R.id.background), ar.n(context, a.C0010a.colorControlNormal), mm);
            a(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), ar.l(context, a.C0010a.colorControlActivated), mm);
            a(layerDrawable2.findDrawableByLayerId(R.id.progress), ar.l(context, a.C0010a.colorControlActivated), mm);
            return drawable;
        }
        if (a(context, i, drawable) || !z) {
            return drawable;
        }
        return null;
    }

    private Drawable g(Context context, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        android.support.v4.d.a<String, d> aVar = this.mw;
        if (aVar == null || aVar.isEmpty()) {
            return null;
        }
        android.support.v4.d.l<String> lVar = this.mx;
        if (lVar != null) {
            String str = lVar.get(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.mw.get(str) == null)) {
                return null;
            }
        } else {
            this.mx = new android.support.v4.d.l<>();
        }
        if (this.mz == null) {
            this.mz = new TypedValue();
        }
        TypedValue typedValue = this.mz;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.mx.append(i, name);
                d dVar = this.mw.get(name);
                if (dVar != null) {
                    drawableA = dVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableA != null) {
                    drawableA.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jA, drawableA);
                }
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e2);
            }
        }
        if (drawableA == null) {
            this.mx.append(i, "appcompat_skip_skip");
        }
        return drawableA;
    }

    private synchronized Drawable a(Context context, long j) {
        android.support.v4.d.e<WeakReference<Drawable.ConstantState>> eVar = this.my.get(context);
        if (eVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReference = eVar.get(j);
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            eVar.delete(j);
        }
        return null;
    }

    private synchronized boolean a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        android.support.v4.d.e<WeakReference<Drawable.ConstantState>> eVar = this.my.get(context);
        if (eVar == null) {
            eVar = new android.support.v4.d.e<>();
            this.my.put(context, eVar);
        }
        eVar.put(j, new WeakReference<>(constantState));
        return true;
    }

    final synchronized Drawable a(Context context, ba baVar, int i) {
        Drawable drawableG = g(context, i);
        if (drawableG == null) {
            drawableG = baVar.bm(i);
        }
        if (drawableG == null) {
            return null;
        }
        return a(context, i, false, drawableG);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = android.support.v7.widget.h.mm
            int[] r1 = android.support.v7.widget.h.mp
            boolean r1 = a(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L15
            int r2 = android.support.v7.a.a.C0010a.colorControlNormal
        L12:
            r7 = 1
            r1 = -1
            goto L44
        L15:
            int[] r1 = android.support.v7.widget.h.mr
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L20
            int r2 = android.support.v7.a.a.C0010a.colorControlActivated
            goto L12
        L20:
            int[] r1 = android.support.v7.widget.h.f710ms
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L2b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L12
        L2b:
            int r1 = android.support.v7.a.a.e.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L3c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = r7
            r7 = 1
            goto L44
        L3c:
            int r1 = android.support.v7.a.a.e.abc_dialog_material_background
            if (r7 != r1) goto L41
            goto L12
        L41:
            r7 = 0
            r1 = -1
            r2 = 0
        L44:
            if (r7 == 0) goto L61
            boolean r7 = android.support.v7.widget.v.l(r8)
            if (r7 == 0) goto L50
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L50:
            int r6 = android.support.v7.widget.ar.l(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = a(r6, r0)
            r8.setColorFilter(r6)
            if (r1 == r3) goto L60
            r8.setAlpha(r1)
        L60:
            return r5
        L61:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.h.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    private void a(String str, d dVar) {
        if (this.mw == null) {
            this.mw = new android.support.v4.d.a<>();
        }
        this.mw.put(str, dVar);
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static PorterDuff.Mode ab(int i) {
        if (i == a.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    final synchronized ColorStateList h(Context context, int i) {
        ColorStateList colorStateListI;
        colorStateListI = i(context, i);
        if (colorStateListI == null) {
            if (i == a.e.abc_edit_text_material) {
                colorStateListI = android.support.v7.b.a.a.b(context, a.c.abc_tint_edittext);
            } else if (i == a.e.abc_switch_track_mtrl_alpha) {
                colorStateListI = android.support.v7.b.a.a.b(context, a.c.abc_tint_switch_track);
            } else if (i == a.e.abc_switch_thumb_material) {
                colorStateListI = g(context);
            } else if (i == a.e.abc_btn_default_mtrl_shape) {
                colorStateListI = d(context);
            } else if (i == a.e.abc_btn_borderless_material) {
                colorStateListI = e(context);
            } else if (i == a.e.abc_btn_colored_material) {
                colorStateListI = f(context);
            } else if (i == a.e.abc_spinner_mtrl_am_alpha || i == a.e.abc_spinner_textfield_background_material) {
                colorStateListI = android.support.v7.b.a.a.b(context, a.c.abc_tint_spinner);
            } else if (a(mq, i)) {
                colorStateListI = ar.m(context, a.C0010a.colorControlNormal);
            } else if (a(mt, i)) {
                colorStateListI = android.support.v7.b.a.a.b(context, a.c.abc_tint_default);
            } else if (a(mu, i)) {
                colorStateListI = android.support.v7.b.a.a.b(context, a.c.abc_tint_btn_checkable);
            } else if (i == a.e.abc_seekbar_thumb_material) {
                colorStateListI = android.support.v7.b.a.a.b(context, a.c.abc_tint_seek_thumb);
            }
            if (colorStateListI != null) {
                b(context, i, colorStateListI);
            }
        }
        return colorStateListI;
    }

    private ColorStateList i(Context context, int i) {
        android.support.v4.d.l<ColorStateList> lVar;
        WeakHashMap<Context, android.support.v4.d.l<ColorStateList>> weakHashMap = this.mv;
        if (weakHashMap == null || (lVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return lVar.get(i);
    }

    private void b(Context context, int i, ColorStateList colorStateList) {
        if (this.mv == null) {
            this.mv = new WeakHashMap<>();
        }
        android.support.v4.d.l<ColorStateList> lVar = this.mv.get(context);
        if (lVar == null) {
            lVar = new android.support.v4.d.l<>();
            this.mv.put(context, lVar);
        }
        lVar.append(i, colorStateList);
    }

    private ColorStateList d(Context context) {
        return j(context, ar.l(context, a.C0010a.colorButtonNormal));
    }

    private ColorStateList e(Context context) {
        return j(context, 0);
    }

    private ColorStateList f(Context context) {
        return j(context, ar.l(context, a.C0010a.colorAccent));
    }

    private static ColorStateList j(Context context, int i) {
        int iL = ar.l(context, a.C0010a.colorControlHighlight);
        return new ColorStateList(new int[][]{ar.vf, ar.PRESSED_STATE_SET, ar.FOCUSED_STATE_SET, ar.EMPTY_STATE_SET}, new int[]{ar.n(context, a.C0010a.colorButtonNormal), android.support.v4.graphics.a.a(iL, i), android.support.v4.graphics.a.a(iL, i), i});
    }

    private static ColorStateList g(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListM = ar.m(context, a.C0010a.colorSwitchThumbNormal);
        if (colorStateListM != null && colorStateListM.isStateful()) {
            iArr[0] = ar.vf;
            iArr2[0] = colorStateListM.getColorForState(iArr[0], 0);
            iArr[1] = ar.vh;
            iArr2[1] = ar.l(context, a.C0010a.colorControlActivated);
            iArr[2] = ar.EMPTY_STATE_SET;
            iArr2[2] = colorStateListM.getDefaultColor();
        } else {
            iArr[0] = ar.vf;
            iArr2[0] = ar.n(context, a.C0010a.colorSwitchThumbNormal);
            iArr[1] = ar.vh;
            iArr2[1] = ar.l(context, a.C0010a.colorControlActivated);
            iArr[2] = ar.EMPTY_STATE_SET;
            iArr2[2] = ar.l(context, a.C0010a.colorSwitchThumbNormal);
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class c extends android.support.v4.d.f<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(6);
        }

        final PorterDuffColorFilter b(int i, PorterDuff.Mode mode) {
            return get(Integer.valueOf(c(i, mode)));
        }

        final PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(c(i, mode)), porterDuffColorFilter);
        }

        private static int c(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    static void a(Drawable drawable, at atVar, int[] iArr) {
        if (v.l(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (atVar.fD || atVar.fE) {
            drawable.setColorFilter(a(atVar.fD ? atVar.ay : null, atVar.fE ? atVar.aB : mm, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterB;
        porterDuffColorFilterB = mo.b(i, mode);
        if (porterDuffColorFilterB == null) {
            porterDuffColorFilterB = new PorterDuffColorFilter(i, mode);
            mo.a(i, mode, porterDuffColorFilterB);
        }
        return porterDuffColorFilterB;
    }

    private static void a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (v.l(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = mm;
        }
        drawable.setColorFilter(a(i, mode));
    }

    private void h(Context context) {
        if (this.mA) {
            return;
        }
        this.mA = true;
        Drawable drawableA = a(context, a.e.abc_vector_test);
        if (drawableA == null || !j(drawableA)) {
            this.mA = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static boolean j(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class e implements d {
        e() {
        }

        @Override // android.support.v7.widget.h.d
        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class b implements d {
        b() {
        }

        @Override // android.support.v7.widget.h.d
        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a implements d {
        a() {
        }

        @Override // android.support.v7.widget.h.d
        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return android.support.v7.c.a.a.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }
}
