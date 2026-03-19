package android.support.v7.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class c<T> extends d<T> {
    private Map<android.support.v4.a.a.b, MenuItem> hg;
    private Map<android.support.v4.a.a.c, SubMenu> hh;
    final Context mContext;

    c(Context context, T t) {
        super(t);
        this.mContext = context;
    }

    final MenuItem b(MenuItem menuItem) {
        if (!(menuItem instanceof android.support.v4.a.a.b)) {
            return menuItem;
        }
        android.support.v4.a.a.b bVar = (android.support.v4.a.a.b) menuItem;
        if (this.hg == null) {
            this.hg = new android.support.v4.d.a();
        }
        MenuItem menuItem2 = this.hg.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem menuItemA = o.a(this.mContext, bVar);
        this.hg.put(bVar, menuItemA);
        return menuItemA;
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof android.support.v4.a.a.c)) {
            return subMenu;
        }
        android.support.v4.a.a.c cVar = (android.support.v4.a.a.c) subMenu;
        if (this.hh == null) {
            this.hh = new android.support.v4.d.a();
        }
        SubMenu subMenu2 = this.hh.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu subMenuA = o.a(this.mContext, cVar);
        this.hh.put(cVar, subMenuA);
        return subMenuA;
    }

    final void bc() {
        Map<android.support.v4.a.a.b, MenuItem> map = this.hg;
        if (map != null) {
            map.clear();
        }
        Map<android.support.v4.a.a.c, SubMenu> map2 = this.hh;
        if (map2 != null) {
            map2.clear();
        }
    }

    final void F(int i) {
        Map<android.support.v4.a.a.b, MenuItem> map = this.hg;
        if (map == null) {
            return;
        }
        Iterator<android.support.v4.a.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    final void G(int i) {
        Map<android.support.v4.a.a.b, MenuItem> map = this.hg;
        if (map == null) {
            return;
        }
        Iterator<android.support.v4.a.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
