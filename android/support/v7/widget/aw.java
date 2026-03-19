package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class aw implements t {
    private Drawable gP;
    CharSequence gz;
    private CharSequence jK;
    private View jM;
    Toolbar wa;
    private int wb;
    private Drawable wc;
    private Drawable wd;
    private boolean we;
    private CharSequence wf;
    Window.Callback wg;
    boolean wh;
    private int wi;
    private int wj;
    private Drawable wk;

    public aw(Toolbar toolbar, boolean z) {
        this(toolbar, true, a.h.abc_action_bar_up_description);
    }

    private aw(Toolbar toolbar, boolean z, int i) {
        Drawable drawable;
        this.wi = 0;
        this.wj = 0;
        this.wa = toolbar;
        this.gz = toolbar.getTitle();
        this.jK = toolbar.getSubtitle();
        this.we = this.gz != null;
        this.wd = toolbar.getNavigationIcon();
        av avVarA = av.a(toolbar.getContext(), null, a.j.ActionBar, a.C0010a.actionBarStyle, 0);
        this.wk = avVarA.getDrawable(a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = avVarA.getText(a.j.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = avVarA.getText(a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = avVarA.getDrawable(a.j.ActionBar_logo);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = avVarA.getDrawable(a.j.ActionBar_icon);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.wd == null && (drawable = this.wk) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(avVarA.getInt(a.j.ActionBar_displayOptions, 0));
            int resourceId = avVarA.getResourceId(a.j.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.wa.getContext()).inflate(resourceId, (ViewGroup) this.wa, false));
                setDisplayOptions(this.wb | 16);
            }
            int layoutDimension = avVarA.getLayoutDimension(a.j.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.wa.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.wa.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = avVarA.getDimensionPixelOffset(a.j.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = avVarA.getDimensionPixelOffset(a.j.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.wa.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = avVarA.getResourceId(a.j.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar2 = this.wa;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), resourceId2);
            }
            int resourceId3 = avVarA.getResourceId(a.j.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar3 = this.wa;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), resourceId3);
            }
            int resourceId4 = avVarA.getResourceId(a.j.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.wa.setPopupTheme(resourceId4);
            }
        } else {
            this.wb = fw();
        }
        avVarA.recycle();
        bl(i);
        this.wf = this.wa.getNavigationContentDescription();
        this.wa.setNavigationOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.aw.1
            final android.support.v7.view.menu.a wl;

            {
                this.wl = new android.support.v7.view.menu.a(aw.this.wa.getContext(), 0, R.id.home, 0, 0, aw.this.gz);
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (aw.this.wg == null || !aw.this.wh) {
                    return;
                }
                aw.this.wg.onMenuItemSelected(0, this.wl);
            }
        });
    }

    private void bl(int i) {
        if (i == this.wj) {
            return;
        }
        this.wj = i;
        if (TextUtils.isEmpty(this.wa.getNavigationContentDescription())) {
            setNavigationContentDescription(this.wj);
        }
    }

    private int fw() {
        if (this.wa.getNavigationIcon() == null) {
            return 11;
        }
        this.wk = this.wa.getNavigationIcon();
        return 15;
    }

    private Context getContext() {
        return this.wa.getContext();
    }

    @Override // android.support.v7.widget.t
    public final void setWindowCallback(Window.Callback callback) {
        this.wg = callback;
    }

    @Override // android.support.v7.widget.t
    public final void setWindowTitle(CharSequence charSequence) {
        if (this.we) {
            return;
        }
        i(charSequence);
    }

    @Override // android.support.v7.widget.t
    public final CharSequence getTitle() {
        return this.wa.getTitle();
    }

    private void setTitle(CharSequence charSequence) {
        this.we = true;
        i(charSequence);
    }

    private void i(CharSequence charSequence) {
        this.gz = charSequence;
        if ((this.wb & 8) != 0) {
            this.wa.setTitle(charSequence);
        }
    }

    private void setSubtitle(CharSequence charSequence) {
        this.jK = charSequence;
        if ((this.wb & 8) != 0) {
            this.wa.setSubtitle(charSequence);
        }
    }

    @Override // android.support.v7.widget.t
    public final void setIcon(int i) {
        setIcon(i != 0 ? android.support.v7.b.a.a.a(getContext(), i) : null);
    }

    @Override // android.support.v7.widget.t
    public final void setIcon(Drawable drawable) {
        this.gP = drawable;
        fx();
    }

    @Override // android.support.v7.widget.t
    public final void setLogo(int i) {
        setLogo(i != 0 ? android.support.v7.b.a.a.a(getContext(), i) : null);
    }

    private void setLogo(Drawable drawable) {
        this.wc = drawable;
        fx();
    }

    private void fx() {
        Drawable drawable;
        int i = this.wb;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.wc) == null) {
            drawable = this.gP;
        }
        this.wa.setLogo(drawable);
    }

    private void setDisplayOptions(int i) {
        View view;
        int i2 = this.wb ^ i;
        this.wb = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    fz();
                }
                fy();
            }
            if ((i2 & 3) != 0) {
                fx();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.wa.setTitle(this.gz);
                    this.wa.setSubtitle(this.jK);
                } else {
                    this.wa.setTitle((CharSequence) null);
                    this.wa.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.jM) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.wa.addView(view);
            } else {
                this.wa.removeView(view);
            }
        }
    }

    private void setCustomView(View view) {
        View view2 = this.jM;
        if (view2 != null && (this.wb & 16) != 0) {
            this.wa.removeView(view2);
        }
        this.jM = view;
        if (view == null || (this.wb & 16) == 0) {
            return;
        }
        this.wa.addView(this.jM);
    }

    private void setNavigationIcon(Drawable drawable) {
        this.wd = drawable;
        fy();
    }

    private void fy() {
        if ((this.wb & 4) != 0) {
            Toolbar toolbar = this.wa;
            Drawable drawable = this.wd;
            if (drawable == null) {
                drawable = this.wk;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.wa.setNavigationIcon((Drawable) null);
    }

    private void setNavigationContentDescription(CharSequence charSequence) {
        this.wf = charSequence;
        fz();
    }

    private void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : getContext().getString(i));
    }

    private void fz() {
        if ((this.wb & 4) != 0) {
            if (TextUtils.isEmpty(this.wf)) {
                this.wa.setNavigationContentDescription(this.wj);
            } else {
                this.wa.setNavigationContentDescription(this.wf);
            }
        }
    }
}
