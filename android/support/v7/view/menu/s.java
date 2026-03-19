package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.g;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class s extends g implements SubMenu {
    private g jo;
    private h jp;

    public s(Context context, g gVar, h hVar) {
        super(context);
        this.jo = gVar;
        this.jp = hVar;
    }

    @Override // android.support.v7.view.menu.g, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.jo.setQwertyMode(z);
    }

    @Override // android.support.v7.view.menu.g
    public final boolean bm() {
        return this.jo.bm();
    }

    @Override // android.support.v7.view.menu.g
    public final boolean bn() {
        return this.jo.bn();
    }

    public final Menu bP() {
        return this.jo;
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.jp;
    }

    @Override // android.support.v7.view.menu.g
    public final void a(g.a aVar) {
        this.jo.a(aVar);
    }

    @Override // android.support.v7.view.menu.g
    public final g bx() {
        return this.jo.bx();
    }

    @Override // android.support.v7.view.menu.g
    final boolean c(g gVar, MenuItem menuItem) {
        return super.c(gVar, menuItem) || this.jo.c(gVar, menuItem);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.jp.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.jp.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.g(drawable);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.N(i);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.c(charSequence);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.M(i);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        return (SubMenu) super.v(view);
    }

    @Override // android.support.v7.view.menu.g
    public final boolean e(h hVar) {
        return this.jo.e(hVar);
    }

    @Override // android.support.v7.view.menu.g
    public final boolean f(h hVar) {
        return this.jo.f(hVar);
    }

    @Override // android.support.v7.view.menu.g, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.jo.setGroupDividerEnabled(z);
    }

    @Override // android.support.v7.view.menu.g
    public final boolean bl() {
        return this.jo.bl();
    }
}
