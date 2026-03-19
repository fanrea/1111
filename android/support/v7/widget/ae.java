package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ae implements android.support.v7.view.menu.q {
    private static Method qE;
    private static Method qF;
    private static Method qG;
    private int hv;
    private Rect jd;
    private Context mContext;
    private boolean mG;
    final Handler mHandler;
    private int mL;
    private ListAdapter mR;
    private final Rect mTempRect;
    w qH;
    private int qI;
    private int qJ;
    private int qK;
    private int qL;
    private boolean qM;
    private boolean qN;
    private boolean qO;
    private boolean qP;
    private boolean qQ;
    int qR;
    private View qS;
    private int qT;
    private DataSetObserver qU;
    private View qV;
    private Drawable qW;
    private AdapterView.OnItemClickListener qX;
    private AdapterView.OnItemSelectedListener qY;
    final e qZ;
    private final d ra;
    private final c rb;
    private final a rc;
    private Runnable rd;
    private boolean re;
    PopupWindow rf;

    static {
        try {
            qE = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            qF = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            qG = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ae(Context context) {
        this(context, null, a.C0010a.listPopupWindowStyle);
    }

    public ae(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ae(Context context, AttributeSet attributeSet, int i, int i2) {
        this.qI = -2;
        this.mL = -2;
        this.qL = 1002;
        this.qN = true;
        this.hv = 0;
        this.qP = false;
        this.qQ = false;
        this.qR = Integer.MAX_VALUE;
        this.qT = 0;
        this.qZ = new e();
        this.ra = new d();
        this.rb = new c();
        this.rc = new a();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ListPopupWindow, i, i2);
        this.qJ = typedArrayObtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.qK = typedArrayObtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.qK != 0) {
            this.qM = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.rf = new n(context, attributeSet, i, i2);
        this.rf.setInputMethodMode(1);
    }

    public void setAdapter(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.qU;
        if (dataSetObserver == null) {
            this.qU = new b();
        } else {
            ListAdapter listAdapter2 = this.mR;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mR = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.qU);
        }
        w wVar = this.qH;
        if (wVar != null) {
            wVar.setAdapter(this.mR);
        }
    }

    public final void setPromptPosition(int i) {
        this.qT = 0;
    }

    public final void setModal(boolean z) {
        this.re = true;
        this.rf.setFocusable(true);
    }

    public final boolean isModal() {
        return this.re;
    }

    public final Drawable getBackground() {
        return this.rf.getBackground();
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.rf.setBackgroundDrawable(drawable);
    }

    public final void setAnimationStyle(int i) {
        this.rf.setAnimationStyle(0);
    }

    public final View getAnchorView() {
        return this.qV;
    }

    public final void setAnchorView(View view) {
        this.qV = view;
    }

    public final int getHorizontalOffset() {
        return this.qJ;
    }

    public final void setHorizontalOffset(int i) {
        this.qJ = i;
    }

    public final int getVerticalOffset() {
        if (this.qM) {
            return this.qK;
        }
        return 0;
    }

    public final void setVerticalOffset(int i) {
        this.qK = i;
        this.qM = true;
    }

    public final void setEpicenterBounds(Rect rect) {
        this.jd = rect;
    }

    public final void setDropDownGravity(int i) {
        this.hv = i;
    }

    public final int getWidth() {
        return this.mL;
    }

    private void setWidth(int i) {
        this.mL = i;
    }

    public final void setContentWidth(int i) {
        Drawable background = this.rf.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.mL = this.mTempRect.left + this.mTempRect.right + i;
        } else {
            setWidth(i);
        }
    }

    public final void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.qX = onItemClickListener;
    }

    @Override // android.support.v7.view.menu.q
    public void show() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iDB = dB();
        boolean zIsInputMethodNotNeeded = isInputMethodNotNeeded();
        android.support.v4.widget.i.a(this.rf, this.qL);
        if (this.rf.isShowing()) {
            if (android.support.v4.e.o.q(getAnchorView())) {
                int width = this.mL;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = getAnchorView().getWidth();
                }
                int i = this.qI;
                if (i == -1) {
                    if (!zIsInputMethodNotNeeded) {
                        iDB = -1;
                    }
                    if (zIsInputMethodNotNeeded) {
                        this.rf.setWidth(this.mL == -1 ? -1 : 0);
                        this.rf.setHeight(0);
                    } else {
                        this.rf.setWidth(this.mL == -1 ? -1 : 0);
                        this.rf.setHeight(-1);
                    }
                } else if (i != -2) {
                    iDB = i;
                }
                this.rf.setOutsideTouchable((this.qQ || this.qP) ? false : true);
                this.rf.update(getAnchorView(), this.qJ, this.qK, width < 0 ? -1 : width, iDB < 0 ? -1 : iDB);
                return;
            }
            return;
        }
        int width2 = this.mL;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = getAnchorView().getWidth();
        }
        int i2 = this.qI;
        if (i2 == -1) {
            iDB = -1;
        } else if (i2 != -2) {
            iDB = i2;
        }
        this.rf.setWidth(width2);
        this.rf.setHeight(iDB);
        z(true);
        this.rf.setOutsideTouchable((this.qQ || this.qP) ? false : true);
        this.rf.setTouchInterceptor(this.ra);
        if (this.qO) {
            android.support.v4.widget.i.a(this.rf, this.mG);
        }
        Method method = qG;
        if (method != null) {
            try {
                method.invoke(this.rf, this.jd);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        android.support.v4.widget.i.a(this.rf, getAnchorView(), this.qJ, this.qK, this.hv);
        this.qH.setSelection(-1);
        if (!this.re || this.qH.isInTouchMode()) {
            clearListSelection();
        }
        if (this.re) {
            return;
        }
        this.mHandler.post(this.rc);
    }

    @Override // android.support.v7.view.menu.q
    public final void dismiss() {
        this.rf.dismiss();
        dA();
        this.rf.setContentView(null);
        this.qH = null;
        this.mHandler.removeCallbacks(this.qZ);
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.rf.setOnDismissListener(onDismissListener);
    }

    private void dA() {
        View view = this.qS;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.qS);
            }
        }
    }

    public final void setInputMethodMode(int i) {
        this.rf.setInputMethodMode(2);
    }

    public final void setSelection(int i) {
        w wVar = this.qH;
        if (!isShowing() || wVar == null) {
            return;
        }
        wVar.setListSelectionHidden(false);
        wVar.setSelection(i);
        if (wVar.getChoiceMode() != 0) {
            wVar.setItemChecked(i, true);
        }
    }

    public final void clearListSelection() {
        w wVar = this.qH;
        if (wVar != null) {
            wVar.setListSelectionHidden(true);
            wVar.requestLayout();
        }
    }

    @Override // android.support.v7.view.menu.q
    public final boolean isShowing() {
        return this.rf.isShowing();
    }

    public final boolean isInputMethodNotNeeded() {
        return this.rf.getInputMethodMode() == 2;
    }

    @Override // android.support.v7.view.menu.q
    public final ListView getListView() {
        return this.qH;
    }

    w b(Context context, boolean z) {
        return new w(context, z);
    }

    private int dB() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        int i2;
        if (this.qH == null) {
            Context context = this.mContext;
            this.rd = new Runnable() { // from class: android.support.v7.widget.ae.1
                @Override // java.lang.Runnable
                public final void run() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                    View anchorView = ae.this.getAnchorView();
                    if (anchorView == null || anchorView.getWindowToken() == null) {
                        return;
                    }
                    ae.this.show();
                }
            };
            this.qH = b(context, !this.re);
            Drawable drawable = this.qW;
            if (drawable != null) {
                this.qH.setSelector(drawable);
            }
            this.qH.setAdapter(this.mR);
            this.qH.setOnItemClickListener(this.qX);
            this.qH.setFocusable(true);
            this.qH.setFocusableInTouchMode(true);
            this.qH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ae.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j) {
                    w wVar;
                    if (i3 == -1 || (wVar = ae.this.qH) == null) {
                        return;
                    }
                    wVar.setListSelectionHidden(false);
                }
            });
            this.qH.setOnScrollListener(this.rb);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.qY;
            if (onItemSelectedListener != null) {
                this.qH.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.qH;
            View view2 = this.qS;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i3 = this.qT;
                if (i3 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i3 == 1) {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                } else {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.qT);
                }
                int i4 = this.mL;
                if (i4 >= 0) {
                    i2 = Integer.MIN_VALUE;
                } else {
                    i4 = 0;
                    i2 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i4, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.rf.setContentView(view);
        } else {
            this.rf.getContentView();
            View view3 = this.qS;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.rf.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            i = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.qM) {
                this.qK = -this.mTempRect.top;
            }
        } else {
            this.mTempRect.setEmpty();
            i = 0;
        }
        int maxAvailableHeight = getMaxAvailableHeight(getAnchorView(), this.qK, this.rf.getInputMethodMode() == 2);
        if (this.qP || this.qI == -1) {
            return maxAvailableHeight + i;
        }
        int i5 = this.mL;
        if (i5 == -2) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), Integer.MIN_VALUE);
        } else if (i5 == -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        int iB = this.qH.b(iMakeMeasureSpec, 0, -1, maxAvailableHeight - measuredHeight, -1);
        if (iB > 0) {
            measuredHeight += i + this.qH.getPaddingTop() + this.qH.getPaddingBottom();
        }
        return iB + measuredHeight;
    }

    public final void setOverlapAnchor(boolean z) {
        this.qO = true;
        this.mG = true;
    }

    class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (ae.this.isShowing()) {
                ae.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            ae.this.dismiss();
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ae.this.clearListSelection();
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public final void run() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (ae.this.qH == null || !android.support.v4.e.o.q(ae.this.qH) || ae.this.qH.getCount() <= ae.this.qH.getChildCount() || ae.this.qH.getChildCount() > ae.this.qR) {
                return;
            }
            ae.this.rf.setInputMethodMode(2);
            ae.this.show();
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ae.this.rf != null && ae.this.rf.isShowing() && x >= 0 && x < ae.this.rf.getWidth() && y >= 0 && y < ae.this.rf.getHeight()) {
                ae.this.mHandler.postDelayed(ae.this.qZ, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ae.this.mHandler.removeCallbacks(ae.this.qZ);
            return false;
        }
    }

    class c implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (i != 1 || ae.this.isInputMethodNotNeeded() || ae.this.rf.getContentView() == null) {
                return;
            }
            ae.this.mHandler.removeCallbacks(ae.this.qZ);
            ae.this.qZ.run();
        }
    }

    private void z(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = qE;
        if (method != null) {
            try {
                method.invoke(this.rf, Boolean.TRUE);
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int getMaxAvailableHeight(View view, int i, boolean z) {
        Method method = qF;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.rf, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.rf.getMaxAvailableHeight(view, i);
    }
}
