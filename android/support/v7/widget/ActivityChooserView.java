package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ActivityChooserView extends ViewGroup {
    PopupWindow.OnDismissListener hH;
    private final b lA;
    private final View lB;
    final FrameLayout lC;
    private final ImageView lD;
    final FrameLayout lE;
    private final int lF;
    android.support.v4.e.c lG;
    final DataSetObserver lH;
    private final ViewTreeObserver.OnGlobalLayoutListener lI;
    private ae lJ;
    boolean lK;
    int lL;
    private int lM;
    final a lz;
    private boolean mIsAttachedToWindow;

    public final void setActivityChooserModel(d dVar) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.lz.a(dVar);
        if (cu()) {
            ct();
            cs();
        }
    }

    public final void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.lD.setImageDrawable(drawable);
    }

    public final void setExpandActivityOverflowButtonContentDescription(int i) {
        this.lD.setContentDescription(getContext().getString(i));
    }

    public final void setProvider(android.support.v4.e.c cVar) {
        this.lG = cVar;
    }

    private boolean cs() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (cu() || !this.mIsAttachedToWindow) {
            return false;
        }
        this.lK = false;
        T(this.lL);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    final void T(int i) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.lz.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.lI);
        ?? r0 = this.lE.getVisibility() == 0 ? 1 : 0;
        int iCi = this.lz.ci();
        if (i != Integer.MAX_VALUE && iCi > i + r0) {
            this.lz.x(true);
            this.lz.U(i - 1);
        } else {
            this.lz.x(false);
            this.lz.U(i);
        }
        ae listPopupWindow = getListPopupWindow();
        if (listPopupWindow.isShowing()) {
            return;
        }
        if (this.lK || r0 == 0) {
            this.lz.a(true, r0);
        } else {
            this.lz.a(false, false);
        }
        listPopupWindow.setContentWidth(Math.min(this.lz.cv(), this.lF));
        listPopupWindow.show();
        android.support.v4.e.c cVar = this.lG;
        if (cVar != null) {
            cVar.h(true);
        }
        listPopupWindow.getListView().setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
        listPopupWindow.getListView().setSelector(new ColorDrawable(0));
    }

    public final boolean ct() {
        if (!cu()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.lI);
        return true;
    }

    private boolean cu() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dataModel = this.lz.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.lH);
        }
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dataModel = this.lz.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.lH);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.lI);
        }
        if (cu()) {
            ct();
        }
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        View view = this.lB;
        if (this.lE.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.lB.layout(0, 0, i3 - i, i4 - i2);
        if (cu()) {
            return;
        }
        ct();
    }

    public final d getDataModel() {
        return this.lz.getDataModel();
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.hH = onDismissListener;
    }

    public final void setInitialActivityCount(int i) {
        this.lL = i;
    }

    public final void setDefaultActionButtonContentDescription(int i) {
        this.lM = i;
    }

    final ae getListPopupWindow() {
        if (this.lJ == null) {
            this.lJ = new ae(getContext());
            this.lJ.setAdapter(this.lz);
            this.lJ.setAnchorView(this);
            this.lJ.setModal(true);
            this.lJ.setOnItemClickListener(this.lA);
            this.lJ.setOnDismissListener(this.lA);
        }
        return this.lJ;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        final /* synthetic */ ActivityChooserView lS;

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            int itemViewType = ((a) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    this.lS.T(Integer.MAX_VALUE);
                    return;
                }
                throw new IllegalArgumentException();
            }
            this.lS.ct();
            if (this.lS.lK) {
                if (i > 0) {
                    this.lS.lz.getDataModel().S(i);
                    return;
                }
                return;
            }
            if (!this.lS.lz.cw()) {
                i++;
            }
            Intent intentR = this.lS.lz.getDataModel().R(i);
            if (intentR != null) {
                intentR.addFlags(524288);
                this.lS.getContext().startActivity(intentR);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (view == this.lS.lE) {
                this.lS.ct();
                Intent intentR = this.lS.lz.getDataModel().R(this.lS.lz.getDataModel().a(this.lS.lz.cj()));
                if (intentR != null) {
                    intentR.addFlags(524288);
                    this.lS.getContext().startActivity(intentR);
                    return;
                }
                return;
            }
            if (view == this.lS.lC) {
                ActivityChooserView activityChooserView = this.lS;
                activityChooserView.lK = false;
                activityChooserView.T(activityChooserView.lL);
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (view == this.lS.lE) {
                if (this.lS.lz.getCount() > 0) {
                    ActivityChooserView activityChooserView = this.lS;
                    activityChooserView.lK = true;
                    activityChooserView.T(activityChooserView.lL);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            cx();
            if (this.lS.lG != null) {
                this.lS.lG.h(false);
            }
        }

        private void cx() {
            if (this.lS.hH != null) {
                this.lS.hH.onDismiss();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class a extends BaseAdapter {
        private d lN;
        private int lO;
        private boolean lP;
        private boolean lQ;
        private boolean lR;
        final /* synthetic */ ActivityChooserView lS;

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final int getViewTypeCount() {
            return 3;
        }

        public final void a(d dVar) {
            d dataModel = this.lS.lz.getDataModel();
            if (dataModel != null && this.lS.isShown()) {
                dataModel.unregisterObserver(this.lS.lH);
            }
            this.lN = dVar;
            if (dVar != null && this.lS.isShown()) {
                dVar.registerObserver(this.lS.lH);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final int getItemViewType(int i) {
            return (this.lR && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            int iCi = this.lN.ci();
            if (!this.lP && this.lN.cj() != null) {
                iCi--;
            }
            int iMin = Math.min(iCi, this.lO);
            return this.lR ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.lP && this.lN.cj() != null) {
                i++;
            }
            return this.lN.Q(i);
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View viewInflate = LayoutInflater.from(this.lS.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    viewInflate.setId(1);
                    ((TextView) viewInflate.findViewById(a.f.title)).setText(this.lS.getContext().getString(a.h.abc_activity_chooser_view_see_all));
                    return viewInflate;
                }
                throw new IllegalArgumentException();
            }
            if (view == null || view.getId() != a.f.list_item) {
                view = LayoutInflater.from(this.lS.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = this.lS.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(a.f.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(a.f.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.lP && i == 0 && this.lQ) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        public final int cv() {
            int i = this.lO;
            this.lO = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int iMax = 0;
            for (int i2 = 0; i2 < count; i2++) {
                view = getView(i2, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.lO = i;
            return iMax;
        }

        public final void U(int i) {
            if (this.lO != i) {
                this.lO = i;
                notifyDataSetChanged();
            }
        }

        public final ResolveInfo cj() {
            return this.lN.cj();
        }

        public final void x(boolean z) {
            if (this.lR != z) {
                this.lR = z;
                notifyDataSetChanged();
            }
        }

        public final int ci() {
            return this.lN.ci();
        }

        public final d getDataModel() {
            return this.lN;
        }

        public final void a(boolean z, boolean z2) {
            if (this.lP == z && this.lQ == z2) {
                return;
            }
            this.lP = z;
            this.lQ = z2;
            notifyDataSetChanged();
        }

        public final boolean cw() {
            return this.lP;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class InnerLayout extends LinearLayout {
        private static final int[] hQ = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            av avVarA = av.a(context, attributeSet, hQ);
            setBackgroundDrawable(avVarA.getDrawable(0));
            avVarA.recycle();
        }
    }
}
