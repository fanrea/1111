package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.support.v4.e.f;
import android.support.v7.a.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.i;
import android.support.v7.widget.v;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class d extends MenuInflater {
    static final Class<?>[] fL;
    static final Class<?>[] fM;
    final Object[] fN;
    final Object[] fO;
    private Object fP;
    Context mContext;

    static {
        Class<?>[] clsArr = {Context.class};
        fL = clsArr;
        fM = clsArr;
    }

    public d(Context context) {
        super(context);
        this.mContext = context;
        this.fN = new Object[]{context};
        this.fO = this.fN;
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof android.support.v4.a.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.mContext.getResources().getLayout(i);
                    a(layout, Xml.asAttributeSet(layout), menu);
                } catch (IOException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        int next = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (next == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (next != 2) {
                if (next == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name2.equals("group")) {
                        bVar.aM();
                    } else if (name2.equals("item")) {
                        if (!bVar.aP()) {
                            if (bVar.gq != null && bVar.gq.hasSubMenu()) {
                                bVar.aO();
                            } else {
                                bVar.aN();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.b(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.c(attributeSet);
                } else if (name3.equals("menu")) {
                    a(xmlPullParser, attributeSet, bVar.aO());
                } else {
                    str = name3;
                    z2 = true;
                }
            }
            next = xmlPullParser.next();
        }
    }

    final Object aL() {
        if (this.fP == null) {
            this.fP = n(this.mContext);
        }
        return this.fP;
    }

    private Object n(Object obj) {
        while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            obj = ((ContextWrapper) obj).getBaseContext();
        }
        return obj;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] fQ = {MenuItem.class};
        private Object fP;
        private Method mMethod;

        public a(Object obj, String str) {
            this.fP = obj;
            Class<?> cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, fQ);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.fP, menuItem)).booleanValue();
                }
                this.mMethod.invoke(this.fP, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class b {
        private Menu fR;
        private int fS;
        private int fT;
        private int fU;
        private boolean fV;
        private boolean fW;
        private boolean fX;
        private int fY;
        private int fZ;
        private CharSequence ga;
        private CharSequence gb;
        private int gc;
        private char gd;
        private int ge;
        private char gf;
        private int gg;
        private int gh;
        private boolean gi;
        private boolean gj;
        private boolean gk;
        private int gl;
        private int gm;
        private String gn;
        private String go;
        private String gp;
        android.support.v4.e.c gq;
        private CharSequence gr;
        private int groupId;
        private CharSequence gs;
        private ColorStateList gt = null;
        private PorterDuff.Mode gu = null;

        public b(Menu menu) {
            this.fR = menu;
            aM();
        }

        public final void aM() {
            this.groupId = 0;
            this.fS = 0;
            this.fT = 0;
            this.fU = 0;
            this.fV = true;
            this.fW = true;
        }

        public final void b(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = d.this.mContext.obtainStyledAttributes(attributeSet, a.j.MenuGroup);
            this.groupId = typedArrayObtainStyledAttributes.getResourceId(a.j.MenuGroup_android_id, 0);
            this.fS = typedArrayObtainStyledAttributes.getInt(a.j.MenuGroup_android_menuCategory, 0);
            this.fT = typedArrayObtainStyledAttributes.getInt(a.j.MenuGroup_android_orderInCategory, 0);
            this.fU = typedArrayObtainStyledAttributes.getInt(a.j.MenuGroup_android_checkableBehavior, 0);
            this.fV = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuGroup_android_visible, true);
            this.fW = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public final void c(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = d.this.mContext.obtainStyledAttributes(attributeSet, a.j.MenuItem);
            this.fY = typedArrayObtainStyledAttributes.getResourceId(a.j.MenuItem_android_id, 0);
            this.fZ = (typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_android_menuCategory, this.fS) & SupportMenu.CATEGORY_MASK) | (typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_android_orderInCategory, this.fT) & 65535);
            this.ga = typedArrayObtainStyledAttributes.getText(a.j.MenuItem_android_title);
            this.gb = typedArrayObtainStyledAttributes.getText(a.j.MenuItem_android_titleCondensed);
            this.gc = typedArrayObtainStyledAttributes.getResourceId(a.j.MenuItem_android_icon, 0);
            this.gd = c(typedArrayObtainStyledAttributes.getString(a.j.MenuItem_android_alphabeticShortcut));
            this.ge = typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_alphabeticModifiers, 4096);
            this.gf = c(typedArrayObtainStyledAttributes.getString(a.j.MenuItem_android_numericShortcut));
            this.gg = typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_numericModifiers, 4096);
            if (typedArrayObtainStyledAttributes.hasValue(a.j.MenuItem_android_checkable)) {
                this.gh = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.gh = this.fU;
            }
            this.gi = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuItem_android_checked, false);
            this.gj = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuItem_android_visible, this.fV);
            this.gk = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuItem_android_enabled, this.fW);
            this.gl = typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_showAsAction, -1);
            this.gp = typedArrayObtainStyledAttributes.getString(a.j.MenuItem_android_onClick);
            this.gm = typedArrayObtainStyledAttributes.getResourceId(a.j.MenuItem_actionLayout, 0);
            this.gn = typedArrayObtainStyledAttributes.getString(a.j.MenuItem_actionViewClass);
            this.go = typedArrayObtainStyledAttributes.getString(a.j.MenuItem_actionProviderClass);
            boolean z = this.go != null;
            if (z && this.gm == 0 && this.gn == null) {
                this.gq = (android.support.v4.e.c) a(this.go, d.fM, d.this.fO);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.gq = null;
            }
            this.gr = typedArrayObtainStyledAttributes.getText(a.j.MenuItem_contentDescription);
            this.gs = typedArrayObtainStyledAttributes.getText(a.j.MenuItem_tooltipText);
            if (typedArrayObtainStyledAttributes.hasValue(a.j.MenuItem_iconTintMode)) {
                this.gu = v.d(typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_iconTintMode, -1), this.gu);
            } else {
                this.gu = null;
            }
            if (typedArrayObtainStyledAttributes.hasValue(a.j.MenuItem_iconTint)) {
                this.gt = typedArrayObtainStyledAttributes.getColorStateList(a.j.MenuItem_iconTint);
            } else {
                this.gt = null;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.fX = false;
        }

        private static char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z = false;
            menuItem.setChecked(this.gi).setVisible(this.gj).setEnabled(this.gk).setCheckable(this.gh > 0).setTitleCondensed(this.gb).setIcon(this.gc);
            int i = this.gl;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.gp != null) {
                if (d.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(d.this.aL(), this.gp));
            }
            if (this.gh >= 2) {
                if (menuItem instanceof h) {
                    ((h) menuItem).r(true);
                } else if (menuItem instanceof i) {
                    ((i) menuItem).r(true);
                }
            }
            String str = this.gn;
            if (str != null) {
                menuItem.setActionView((View) a(str, d.fL, d.this.fN));
                z = true;
            }
            int i2 = this.gm;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            android.support.v4.e.c cVar = this.gq;
            if (cVar != null) {
                f.a(menuItem, cVar);
            }
            f.a(menuItem, this.gr);
            f.b(menuItem, this.gs);
            f.b(menuItem, this.gd, this.ge);
            f.a(menuItem, this.gf, this.gg);
            PorterDuff.Mode mode = this.gu;
            if (mode != null) {
                f.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.gt;
            if (colorStateList != null) {
                f.a(menuItem, colorStateList);
            }
        }

        public final void aN() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.fX = true;
            a(this.fR.add(this.groupId, this.fY, this.fZ, this.ga));
        }

        public final SubMenu aO() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.fX = true;
            SubMenu subMenuAddSubMenu = this.fR.addSubMenu(this.groupId, this.fY, this.fZ, this.ga);
            a(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public final boolean aP() {
            return this.fX;
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = d.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
