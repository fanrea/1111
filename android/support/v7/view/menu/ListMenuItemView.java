package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.support.v7.view.menu.n;
import android.support.v7.widget.av;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {
    private LayoutInflater ek;
    private h gO;
    private boolean hD;
    private ImageView hS;
    private RadioButton hT;
    private TextView hU;
    private CheckBox hV;
    private TextView hW;
    private ImageView hX;
    private ImageView hY;
    private LinearLayout hZ;
    private Drawable ia;
    private int ib;
    private Context ic;
    private boolean ie;

    /* renamed from: if, reason: not valid java name */
    private Drawable f1if;
    private boolean ig;
    private int ih;

    @Override // android.support.v7.view.menu.n.a
    public final boolean aU() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0010a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        av avVarA = av.a(getContext(), attributeSet, a.j.MenuView, i, 0);
        this.ia = avVarA.getDrawable(a.j.MenuView_android_itemBackground);
        this.ib = avVarA.getResourceId(a.j.MenuView_android_itemTextAppearance, -1);
        this.ie = avVarA.getBoolean(a.j.MenuView_preserveIconSpacing, false);
        this.ic = context;
        this.f1if = avVarA.getDrawable(a.j.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, a.C0010a.dropDownListViewStyle, 0);
        this.ig = typedArrayObtainStyledAttributes.hasValue(0);
        avVarA.recycle();
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        android.support.v4.e.o.a(this, this.ia);
        this.hU = (TextView) findViewById(a.f.title);
        int i = this.ib;
        if (i != -1) {
            this.hU.setTextAppearance(this.ic, i);
        }
        this.hW = (TextView) findViewById(a.f.shortcut);
        this.hX = (ImageView) findViewById(a.f.submenuarrow);
        ImageView imageView = this.hX;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1if);
        }
        this.hY = (ImageView) findViewById(a.f.group_divider);
        this.hZ = (LinearLayout) findViewById(a.f.content);
    }

    @Override // android.support.v7.view.menu.n.a
    public final void a(h hVar, int i) {
        this.gO = hVar;
        this.ih = 0;
        setVisibility(hVar.isVisible() ? 0 : 8);
        setTitle(hVar.a(this));
        setCheckable(hVar.isCheckable());
        setShortcut$25d965e(hVar.bD());
        setIcon(hVar.getIcon());
        setEnabled(hVar.isEnabled());
        setSubMenuArrowVisible(hVar.hasSubMenu());
        setContentDescription(hVar.getContentDescription());
    }

    private void u(View view) {
        e(view, -1);
    }

    private void e(View view, int i) {
        LinearLayout linearLayout = this.hZ;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.hD = z;
        this.ie = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.hU.setText(charSequence);
            if (this.hU.getVisibility() != 0) {
                this.hU.setVisibility(0);
                return;
            }
            return;
        }
        if (this.hU.getVisibility() != 8) {
            this.hU.setVisibility(8);
        }
    }

    @Override // android.support.v7.view.menu.n.a
    public h getItemData() {
        return this.gO;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.hT == null && this.hV == null) {
            return;
        }
        if (this.gO.bE()) {
            if (this.hT == null) {
                bh();
            }
            compoundButton = this.hT;
            compoundButton2 = this.hV;
        } else {
            if (this.hV == null) {
                bi();
            }
            compoundButton = this.hV;
            compoundButton2 = this.hT;
        }
        if (z) {
            compoundButton.setChecked(this.gO.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.hV;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.hT;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.gO.bE()) {
            if (this.hT == null) {
                bh();
            }
            compoundButton = this.hT;
        } else {
            if (this.hV == null) {
                bi();
            }
            compoundButton = this.hV;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.hX;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    private void setShortcut$25d965e(boolean z) {
        int i = (z && this.gO.bD()) ? 0 : 8;
        if (i == 0) {
            this.hW.setText(this.gO.bC());
        }
        if (this.hW.getVisibility() != i) {
            this.hW.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.gO.shouldShowIcon() || this.hD;
        if (z || this.ie) {
            if (this.hS == null && drawable == null && !this.ie) {
                return;
            }
            if (this.hS == null) {
                bg();
            }
            if (drawable != null || this.ie) {
                ImageView imageView = this.hS;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.hS.getVisibility() != 0) {
                    this.hS.setVisibility(0);
                    return;
                }
                return;
            }
            this.hS.setVisibility(8);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.hS != null && this.ie) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hS.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void bg() {
        this.hS = (ImageView) getInflater().inflate(a.g.abc_list_menu_item_icon, (ViewGroup) this, false);
        e(this.hS, 0);
    }

    private void bh() {
        this.hT = (RadioButton) getInflater().inflate(a.g.abc_list_menu_item_radio, (ViewGroup) this, false);
        u(this.hT);
    }

    private void bi() {
        this.hV = (CheckBox) getInflater().inflate(a.g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        u(this.hV);
    }

    private LayoutInflater getInflater() {
        if (this.ek == null) {
            this.ek = LayoutInflater.from(getContext());
        }
        return this.ek;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.hY;
        if (imageView != null) {
            imageView.setVisibility((this.ig || !z) ? 8 : 0);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.hY;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hY.getLayoutParams();
        rect.top += this.hY.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }
}
