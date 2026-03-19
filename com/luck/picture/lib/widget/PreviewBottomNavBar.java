package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.utils.StyleUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PreviewBottomNavBar extends BottomNavBar {
    public PreviewBottomNavBar(Context context) {
        super(context);
    }

    public PreviewBottomNavBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreviewBottomNavBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.luck.picture.lib.widget.BottomNavBar
    protected void handleLayoutUI() {
        this.tvPreview.setVisibility(8);
        this.tvImageEditor.setOnClickListener(this);
        this.tvImageEditor.setVisibility(this.config.onEditMediaEventListener != null ? 0 : 8);
    }

    public void isDisplayEditor(boolean z) {
        this.tvImageEditor.setVisibility((this.config.onEditMediaEventListener == null || z) ? 8 : 0);
    }

    public TextView getEditor() {
        return this.tvImageEditor;
    }

    @Override // com.luck.picture.lib.widget.BottomNavBar
    public void setBottomNavBarStyle() {
        super.setBottomNavBarStyle();
        BottomNavBarStyle bottomBarStyle = this.config.selectorStyle.getBottomBarStyle();
        if (StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewNarBarBackgroundColor())) {
            setBackgroundColor(bottomBarStyle.getBottomPreviewNarBarBackgroundColor());
        } else if (StyleUtils.checkSizeValidity(bottomBarStyle.getBottomNarBarBackgroundColor())) {
            setBackgroundColor(bottomBarStyle.getBottomNarBarBackgroundColor());
        }
    }

    @Override // com.luck.picture.lib.widget.BottomNavBar, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() != R.id.ps_tv_editor || this.bottomNavBarListener == null) {
            return;
        }
        this.bottomNavBarListener.onEditImage();
    }
}
