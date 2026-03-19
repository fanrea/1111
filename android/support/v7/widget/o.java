package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import java.lang.reflect.InvocationTargetException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class o extends Spinner implements android.support.v4.e.n {
    private static final int[] mH = {R.attr.spinnerMode};
    private z gR;
    private final Context jr;
    private SpinnerAdapter mI;
    private final boolean mJ;
    b mK;
    int mL;
    final Rect mTempRect;
    private final g mf;

    public o(Context context, AttributeSet attributeSet, int i) {
        this(context, null, i, -1);
    }

    private o(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, -1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[PHI: r1 r11
  0x004c: PHI (r1v12 android.content.res.TypedArray) = (r1v11 android.content.res.TypedArray), (r1v14 android.content.res.TypedArray) binds: [B:26:0x005e, B:17:0x004a] A[DONT_GENERATE, DONT_INLINE]
  0x004c: PHI (r11v4 int) = (r11v0 int), (r11v6 int) binds: [B:26:0x005e, B:17:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private o(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r12 = new android.graphics.Rect
            r12.<init>()
            r7.mTempRect = r12
            int[] r12 = android.support.v7.a.a.j.Spinner
            r0 = 0
            android.support.v7.widget.av r12 = android.support.v7.widget.av.a(r8, r9, r12, r10, r0)
            android.support.v7.widget.g r1 = new android.support.v7.widget.g
            r1.<init>(r7)
            r7.mf = r1
            int r1 = android.support.v7.a.a.j.Spinner_popupTheme
            int r1 = r12.getResourceId(r1, r0)
            r2 = 0
            if (r1 == 0) goto L27
            android.support.v7.view.c r3 = new android.support.v7.view.c
            r3.<init>(r8, r1)
            goto L30
        L27:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r1 >= r3) goto L2f
            r3 = r8
            goto L30
        L2f:
            r3 = r2
        L30:
            r7.jr = r3
            android.content.Context r1 = r7.jr
            r3 = 1
            if (r1 == 0) goto La0
            r1 = -1
            if (r11 != r1) goto L68
            int[] r1 = android.support.v7.widget.o.mH     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            android.content.res.TypedArray r1 = r8.obtainStyledAttributes(r9, r1, r10, r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            boolean r4 = r1.hasValue(r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L61
            if (r4 == 0) goto L4a
            int r11 = r1.getInt(r0, r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L61
        L4a:
            if (r1 == 0) goto L68
        L4c:
            r1.recycle()
            goto L68
        L50:
            r4 = move-exception
            goto L57
        L52:
            r8 = move-exception
            r1 = r2
            goto L62
        L55:
            r4 = move-exception
            r1 = r2
        L57:
            java.lang.String r5 = "AppCompatSpinner"
            java.lang.String r6 = "Could not read android:spinnerMode"
            android.util.Log.i(r5, r6, r4)     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L68
            goto L4c
        L61:
            r8 = move-exception
        L62:
            if (r1 == 0) goto L67
            r1.recycle()
        L67:
            throw r8
        L68:
            if (r11 != r3) goto La0
            android.support.v7.widget.o$b r11 = new android.support.v7.widget.o$b
            android.content.Context r1 = r7.jr
            r11.<init>(r1, r9, r10)
            android.content.Context r1 = r7.jr
            int[] r4 = android.support.v7.a.a.j.Spinner
            android.support.v7.widget.av r0 = android.support.v7.widget.av.a(r1, r9, r4, r10, r0)
            int r1 = android.support.v7.a.a.j.Spinner_android_dropDownWidth
            r4 = -2
            int r1 = r0.getLayoutDimension(r1, r4)
            r7.mL = r1
            int r1 = android.support.v7.a.a.j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)
            r11.setBackgroundDrawable(r1)
            int r1 = android.support.v7.a.a.j.Spinner_android_prompt
            java.lang.String r1 = r12.getString(r1)
            r11.d(r1)
            r0.recycle()
            r7.mK = r11
            android.support.v7.widget.o$1 r0 = new android.support.v7.widget.o$1
            r0.<init>(r7)
            r7.gR = r0
        La0:
            int r11 = android.support.v7.a.a.j.Spinner_android_entries
            java.lang.CharSequence[] r11 = r12.getTextArray(r11)
            if (r11 == 0) goto Lb8
            android.widget.ArrayAdapter r0 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r0.<init>(r8, r1, r11)
            int r8 = android.support.v7.a.a.g.support_simple_spinner_dropdown_item
            r0.setDropDownViewResource(r8)
            r7.setAdapter(r0)
        Lb8:
            r12.recycle()
            r7.mJ = r3
            android.widget.SpinnerAdapter r8 = r7.mI
            if (r8 == 0) goto Lc6
            r7.setAdapter(r8)
            r7.mI = r2
        Lc6:
            android.support.v7.widget.g r8 = r7.mf
            r8.a(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.o.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    @Override // android.widget.Spinner
    public final Context getPopupContext() {
        if (this.mK != null) {
            return this.jr;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public final void setPopupBackgroundDrawable(Drawable drawable) {
        b bVar = this.mK;
        if (bVar != null) {
            bVar.setBackgroundDrawable(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public final void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v7.b.a.a.a(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public final Drawable getPopupBackground() {
        b bVar = this.mK;
        if (bVar != null) {
            return bVar.getBackground();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public final void setDropDownVerticalOffset(int i) {
        b bVar = this.mK;
        if (bVar != null) {
            bVar.setVerticalOffset(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public final int getDropDownVerticalOffset() {
        b bVar = this.mK;
        if (bVar != null) {
            return bVar.getVerticalOffset();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public final void setDropDownHorizontalOffset(int i) {
        b bVar = this.mK;
        if (bVar != null) {
            bVar.setHorizontalOffset(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public final int getDropDownHorizontalOffset() {
        b bVar = this.mK;
        if (bVar != null) {
            return bVar.getHorizontalOffset();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public final void setDropDownWidth(int i) {
        if (this.mK != null) {
            this.mL = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public final int getDropDownWidth() {
        if (this.mK != null) {
            return this.mL;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.mJ) {
            this.mI = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mK != null) {
            Context context = this.jr;
            if (context == null) {
                context = getContext();
            }
            this.mK.setAdapter(new a(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.mK;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.mK.dismiss();
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        z zVar = this.gR;
        if (zVar == null || !zVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mK == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        b bVar = this.mK;
        if (bVar != null) {
            if (bVar.isShowing()) {
                return true;
            }
            this.mK.show();
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public final void setPrompt(CharSequence charSequence) {
        b bVar = this.mK;
        if (bVar != null) {
            bVar.d(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public final CharSequence getPrompt() {
        b bVar = this.mK;
        return bVar != null ? bVar.getHintText() : super.getPrompt();
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        g gVar = this.mf;
        if (gVar != null) {
            gVar.aa(i);
        }
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        g gVar = this.mf;
        if (gVar != null) {
            gVar.cE();
        }
    }

    @Override // android.support.v4.e.n
    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        g gVar = this.mf;
        if (gVar != null) {
            gVar.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v4.e.n
    public final ColorStateList getSupportBackgroundTintList() {
        g gVar = this.mf;
        if (gVar != null) {
            return gVar.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // android.support.v4.e.n
    public final void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        g gVar = this.mf;
        if (gVar != null) {
            gVar.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v4.e.n
    public final PorterDuff.Mode getSupportBackgroundTintMode() {
        g gVar = this.mf;
        if (gVar != null) {
            return gVar.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        g gVar = this.mf;
        if (gVar != null) {
            gVar.cF();
        }
    }

    final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.mTempRect);
        return iMax2 + this.mTempRect.left + this.mTempRect.right;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mO;
        private ListAdapter mP;

        @Override // android.widget.Adapter
        public final int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.mO = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.mP = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || Build.VERSION.SDK_INT < 23 || !(spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                return;
            }
            ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.mO;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.mO;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.mO;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.mO;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.mO;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.mO;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.mO;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mP;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.mP;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class b extends ae {
        private CharSequence mQ;
        ListAdapter mR;
        private final Rect mS;

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mS = new Rect();
            setAnchorView(o.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.o.b.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    o.this.setSelection(i2);
                    if (o.this.getOnItemClickListener() != null) {
                        o.this.performItemClick(view, i2, b.this.mR.getItemId(i2));
                    }
                    b.this.dismiss();
                }
            });
        }

        @Override // android.support.v7.widget.ae
        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mR = listAdapter;
        }

        public final CharSequence getHintText() {
            return this.mQ;
        }

        public final void d(CharSequence charSequence) {
            this.mQ = charSequence;
        }

        final void cJ() {
            Drawable background = getBackground();
            int i = 0;
            if (background != null) {
                background.getPadding(o.this.mTempRect);
                i = bd.ah(o.this) ? o.this.mTempRect.right : -o.this.mTempRect.left;
            } else {
                Rect rect = o.this.mTempRect;
                o.this.mTempRect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = o.this.getPaddingLeft();
            int paddingRight = o.this.getPaddingRight();
            int width = o.this.getWidth();
            if (o.this.mL == -2) {
                int iA = o.this.a((SpinnerAdapter) this.mR, getBackground());
                int i2 = (o.this.getContext().getResources().getDisplayMetrics().widthPixels - o.this.mTempRect.left) - o.this.mTempRect.right;
                if (iA > i2) {
                    iA = i2;
                }
                setContentWidth(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (o.this.mL == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(o.this.mL);
            }
            setHorizontalOffset(bd.ah(o.this) ? i + ((width - paddingRight) - getWidth()) : i + paddingLeft);
        }

        @Override // android.support.v7.widget.ae, android.support.v7.view.menu.q
        public final void show() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            ViewTreeObserver viewTreeObserver;
            boolean zIsShowing = isShowing();
            cJ();
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(1);
            setSelection(o.this.getSelectedItemPosition());
            if (zIsShowing || (viewTreeObserver = o.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.o.b.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                    b bVar = b.this;
                    if (!bVar.B(o.this)) {
                        b.this.dismiss();
                    } else {
                        b.this.cJ();
                        b.super.show();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.o.b.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = o.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        final boolean B(View view) {
            return android.support.v4.e.o.q(view) && view.getGlobalVisibleRect(this.mS);
        }
    }
}
