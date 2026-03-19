package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.e.c;
import android.support.v7.view.menu.i;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class j extends i {
    j(Context context, android.support.v4.a.a.b bVar) {
        super(context, bVar);
    }

    @Override // android.support.v7.view.menu.i
    final i.a a(ActionProvider actionProvider) {
        return new a(this.mContext, actionProvider);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class a extends i.a implements ActionProvider.VisibilityListener {
        c.b jb;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // android.support.v4.e.c
        public final View onCreateActionView(MenuItem menuItem) {
            return this.iY.onCreateActionView(menuItem);
        }

        @Override // android.support.v4.e.c
        public final boolean overridesItemVisibility() {
            return this.iY.overridesItemVisibility();
        }

        @Override // android.support.v4.e.c
        public final boolean isVisible() {
            return this.iY.isVisible();
        }

        @Override // android.support.v4.e.c
        public final void a(c.b bVar) {
            this.jb = bVar;
            this.iY.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public final void onActionProviderVisibilityChanged(boolean z) {
            c.b bVar = this.jb;
            if (bVar != null) {
                bVar.Y();
            }
        }
    }
}
