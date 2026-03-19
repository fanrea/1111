package com.luck.picture.lib.magical;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MagicalViewWrapper {
    private final ViewGroup.MarginLayoutParams params;
    private final View viewWrapper;

    public MagicalViewWrapper(View view) {
        this.viewWrapper = view;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.params = marginLayoutParams;
        if (marginLayoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) marginLayoutParams).gravity = GravityCompat.START;
        }
    }

    public int getWidth() {
        return this.params.width;
    }

    public int getHeight() {
        return this.params.height;
    }

    public void setWidth(float f) {
        this.params.width = Math.round(f);
        this.viewWrapper.setLayoutParams(this.params);
    }

    public void setHeight(float f) {
        this.params.height = Math.round(f);
        this.viewWrapper.setLayoutParams(this.params);
    }

    public void setMarginTop(int i) {
        this.params.topMargin = i;
        this.viewWrapper.setLayoutParams(this.params);
    }

    public void setMarginBottom(int i) {
        this.params.bottomMargin = i;
        this.viewWrapper.setLayoutParams(this.params);
    }

    public int getMarginTop() {
        return this.params.topMargin;
    }

    public void setMarginRight(int i) {
        this.params.rightMargin = i;
        this.viewWrapper.setLayoutParams(this.params);
    }

    public void setMarginLeft(int i) {
        this.params.leftMargin = i;
        this.viewWrapper.setLayoutParams(this.params);
    }

    public int getMarginRight() {
        return this.params.rightMargin;
    }

    public int getMarginLeft() {
        return this.params.leftMargin;
    }

    public int getMarginBottom() {
        return this.params.bottomMargin;
    }
}
