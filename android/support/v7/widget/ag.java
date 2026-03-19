package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.ListMenuItemView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ag extends ae implements af {
    private static Method rh;
    private af ri;

    static {
        try {
            rh = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public ag(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, null, i, i2);
    }

    @Override // android.support.v7.widget.ae
    final w b(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public final void o(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.rf.setEnterTransition(null);
        }
    }

    public final void p(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.rf.setExitTransition(null);
        }
    }

    public final void setHoverListener(af afVar) {
        this.ri = afVar;
    }

    public final void setTouchModal(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = rh;
        if (method != null) {
            try {
                method.invoke(this.rf, Boolean.FALSE);
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // android.support.v7.widget.af
    public final void b(android.support.v7.view.menu.g gVar, MenuItem menuItem) {
        af afVar = this.ri;
        if (afVar != null) {
            afVar.b(gVar, menuItem);
        }
    }

    @Override // android.support.v7.widget.af
    public final void a(android.support.v7.view.menu.g gVar, MenuItem menuItem) {
        af afVar = this.ri;
        if (afVar != null) {
            afVar.a(gVar, menuItem);
        }
    }

    public static class a extends w {
        private af ri;
        final int rj;
        final int rk;
        private MenuItem rl;

        @Override // android.support.v7.widget.w
        public final /* bridge */ /* synthetic */ int b(int i, int i2, int i3, int i4, int i5) {
            return super.b(i, i2, i3, i4, i5);
        }

        @Override // android.support.v7.widget.w
        public final /* bridge */ /* synthetic */ boolean b(MotionEvent motionEvent, int i) {
            return super.b(motionEvent, i);
        }

        @Override // android.support.v7.widget.w, android.view.ViewGroup, android.view.View
        public final /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // android.support.v7.widget.w, android.view.View
        public final /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // android.support.v7.widget.w, android.view.View
        public final /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // android.support.v7.widget.w, android.view.View
        public final /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // android.support.v7.widget.w, android.widget.AbsListView, android.view.View
        public final /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.support.v7.widget.w, android.widget.AbsListView
        public final /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.rj = 21;
                this.rk = 22;
            } else {
                this.rj = 22;
                this.rk = 21;
            }
        }

        public final void setHoverListener(af afVar) {
            this.ri = afVar;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public final boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.rj) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && i == this.rk) {
                setSelection(-1);
                ((android.support.v7.view.menu.f) getAdapter()).bj().p(false);
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }

        @Override // android.support.v7.widget.w, android.view.View
        public final boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            android.support.v7.view.menu.f fVar;
            int iPointToPosition;
            int i;
            if (this.ri != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    fVar = (android.support.v7.view.menu.f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    fVar = (android.support.v7.view.menu.f) adapter;
                }
                android.support.v7.view.menu.h item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i = iPointToPosition - headersCount) >= 0 && i < fVar.getCount()) {
                    item = fVar.getItem(i);
                }
                MenuItem menuItem = this.rl;
                if (menuItem != item) {
                    android.support.v7.view.menu.g gVarBj = fVar.bj();
                    if (menuItem != null) {
                        this.ri.a(gVarBj, menuItem);
                    }
                    this.rl = item;
                    if (item != null) {
                        this.ri.b(gVarBj, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
