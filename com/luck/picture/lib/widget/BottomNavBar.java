package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.StyleUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BottomNavBar extends RelativeLayout implements View.OnClickListener {
    protected OnBottomNavBarListener bottomNavBarListener;
    protected SelectorConfig config;
    private CheckBox originalCheckbox;
    protected TextView tvImageEditor;
    protected TextView tvPreview;

    public static class OnBottomNavBarListener {
        public void onCheckOriginalChange() {
        }

        public void onEditImage() {
        }

        public void onFirstCheckOriginalSelectedChange() {
        }

        public void onPreview() {
        }
    }

    protected void handleLayoutUI() {
    }

    public BottomNavBar(Context context) {
        super(context);
        init();
    }

    public BottomNavBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BottomNavBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void init() {
        inflateLayout();
        setClickable(true);
        setFocusable(true);
        this.config = SelectorProviders.getInstance().getSelectorConfig();
        this.tvPreview = (TextView) findViewById(R.id.ps_tv_preview);
        this.tvImageEditor = (TextView) findViewById(R.id.ps_tv_editor);
        this.originalCheckbox = (CheckBox) findViewById(R.id.cb_original);
        this.tvPreview.setOnClickListener(this);
        this.tvImageEditor.setVisibility(8);
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_grey));
        this.originalCheckbox.setChecked(this.config.isCheckOriginalImage);
        this.originalCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.luck.picture.lib.widget.BottomNavBar.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BottomNavBar.this.config.isCheckOriginalImage = z;
                BottomNavBar.this.originalCheckbox.setChecked(BottomNavBar.this.config.isCheckOriginalImage);
                if (BottomNavBar.this.bottomNavBarListener != null) {
                    BottomNavBar.this.bottomNavBarListener.onCheckOriginalChange();
                    if (z && BottomNavBar.this.config.getSelectCount() == 0) {
                        BottomNavBar.this.bottomNavBarListener.onFirstCheckOriginalSelectedChange();
                    }
                }
            }
        });
        handleLayoutUI();
    }

    protected void inflateLayout() {
        inflate(getContext(), R.layout.ps_bottom_nav_bar, this);
    }

    public void setBottomNavBarStyle() {
        if (this.config.isDirectReturnSingle) {
            setVisibility(8);
            return;
        }
        BottomNavBarStyle bottomBarStyle = this.config.selectorStyle.getBottomBarStyle();
        if (this.config.isOriginalControl) {
            this.originalCheckbox.setVisibility(0);
            int bottomOriginalDrawableLeft = bottomBarStyle.getBottomOriginalDrawableLeft();
            if (StyleUtils.checkStyleValidity(bottomOriginalDrawableLeft)) {
                this.originalCheckbox.setButtonDrawable(bottomOriginalDrawableLeft);
            }
            String string = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomOriginalTextResId()) ? getContext().getString(bottomBarStyle.getBottomOriginalTextResId()) : bottomBarStyle.getBottomOriginalText();
            if (StyleUtils.checkTextValidity(string)) {
                this.originalCheckbox.setText(string);
            }
            int bottomOriginalTextSize = bottomBarStyle.getBottomOriginalTextSize();
            if (StyleUtils.checkSizeValidity(bottomOriginalTextSize)) {
                this.originalCheckbox.setTextSize(bottomOriginalTextSize);
            }
            int bottomOriginalTextColor = bottomBarStyle.getBottomOriginalTextColor();
            if (StyleUtils.checkStyleValidity(bottomOriginalTextColor)) {
                this.originalCheckbox.setTextColor(bottomOriginalTextColor);
            }
        }
        int bottomNarBarHeight = bottomBarStyle.getBottomNarBarHeight();
        if (StyleUtils.checkSizeValidity(bottomNarBarHeight)) {
            getLayoutParams().height = bottomNarBarHeight;
        } else {
            getLayoutParams().height = DensityUtil.dip2px(getContext(), 46.0f);
        }
        int bottomNarBarBackgroundColor = bottomBarStyle.getBottomNarBarBackgroundColor();
        if (StyleUtils.checkStyleValidity(bottomNarBarBackgroundColor)) {
            setBackgroundColor(bottomNarBarBackgroundColor);
        }
        int bottomPreviewNormalTextColor = bottomBarStyle.getBottomPreviewNormalTextColor();
        if (StyleUtils.checkStyleValidity(bottomPreviewNormalTextColor)) {
            this.tvPreview.setTextColor(bottomPreviewNormalTextColor);
        }
        int bottomPreviewNormalTextSize = bottomBarStyle.getBottomPreviewNormalTextSize();
        if (StyleUtils.checkSizeValidity(bottomPreviewNormalTextSize)) {
            this.tvPreview.setTextSize(bottomPreviewNormalTextSize);
        }
        String string2 = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewNormalTextResId()) ? getContext().getString(bottomBarStyle.getBottomPreviewNormalTextResId()) : bottomBarStyle.getBottomPreviewNormalText();
        if (StyleUtils.checkTextValidity(string2)) {
            this.tvPreview.setText(string2);
        }
        String string3 = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomEditorTextResId()) ? getContext().getString(bottomBarStyle.getBottomEditorTextResId()) : bottomBarStyle.getBottomEditorText();
        if (StyleUtils.checkTextValidity(string3)) {
            this.tvImageEditor.setText(string3);
        }
        int bottomEditorTextSize = bottomBarStyle.getBottomEditorTextSize();
        if (StyleUtils.checkSizeValidity(bottomEditorTextSize)) {
            this.tvImageEditor.setTextSize(bottomEditorTextSize);
        }
        int bottomEditorTextColor = bottomBarStyle.getBottomEditorTextColor();
        if (StyleUtils.checkStyleValidity(bottomEditorTextColor)) {
            this.tvImageEditor.setTextColor(bottomEditorTextColor);
        }
        int bottomOriginalDrawableLeft2 = bottomBarStyle.getBottomOriginalDrawableLeft();
        if (StyleUtils.checkStyleValidity(bottomOriginalDrawableLeft2)) {
            this.originalCheckbox.setButtonDrawable(bottomOriginalDrawableLeft2);
        }
        String string4 = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomOriginalTextResId()) ? getContext().getString(bottomBarStyle.getBottomOriginalTextResId()) : bottomBarStyle.getBottomOriginalText();
        if (StyleUtils.checkTextValidity(string4)) {
            this.originalCheckbox.setText(string4);
        }
        int bottomOriginalTextSize2 = bottomBarStyle.getBottomOriginalTextSize();
        if (StyleUtils.checkSizeValidity(bottomOriginalTextSize2)) {
            this.originalCheckbox.setTextSize(bottomOriginalTextSize2);
        }
        int bottomOriginalTextColor2 = bottomBarStyle.getBottomOriginalTextColor();
        if (StyleUtils.checkStyleValidity(bottomOriginalTextColor2)) {
            this.originalCheckbox.setTextColor(bottomOriginalTextColor2);
        }
    }

    public void setOriginalCheck() {
        this.originalCheckbox.setChecked(this.config.isCheckOriginalImage);
    }

    public void setSelectedChange() {
        calculateFileTotalSize();
        BottomNavBarStyle bottomBarStyle = this.config.selectorStyle.getBottomBarStyle();
        if (this.config.getSelectCount() > 0) {
            this.tvPreview.setEnabled(true);
            int bottomPreviewSelectTextColor = bottomBarStyle.getBottomPreviewSelectTextColor();
            if (StyleUtils.checkStyleValidity(bottomPreviewSelectTextColor)) {
                this.tvPreview.setTextColor(bottomPreviewSelectTextColor);
            } else {
                this.tvPreview.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_fa632d));
            }
            String string = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewSelectTextResId()) ? getContext().getString(bottomBarStyle.getBottomPreviewSelectTextResId()) : bottomBarStyle.getBottomPreviewSelectText();
            if (StyleUtils.checkTextValidity(string)) {
                if (StyleUtils.checkTextFormatValidity(string)) {
                    this.tvPreview.setText(String.format(string, Integer.valueOf(this.config.getSelectCount())));
                    return;
                } else {
                    this.tvPreview.setText(string);
                    return;
                }
            }
            this.tvPreview.setText(getContext().getString(R.string.ps_preview_num, Integer.valueOf(this.config.getSelectCount())));
            return;
        }
        this.tvPreview.setEnabled(false);
        int bottomPreviewNormalTextColor = bottomBarStyle.getBottomPreviewNormalTextColor();
        if (StyleUtils.checkStyleValidity(bottomPreviewNormalTextColor)) {
            this.tvPreview.setTextColor(bottomPreviewNormalTextColor);
        } else {
            this.tvPreview.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_9b));
        }
        String string2 = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewNormalTextResId()) ? getContext().getString(bottomBarStyle.getBottomPreviewNormalTextResId()) : bottomBarStyle.getBottomPreviewNormalText();
        if (StyleUtils.checkTextValidity(string2)) {
            this.tvPreview.setText(string2);
        } else {
            this.tvPreview.setText(getContext().getString(R.string.ps_preview));
        }
    }

    private void calculateFileTotalSize() {
        if (this.config.isOriginalControl) {
            long size = 0;
            for (int i = 0; i < this.config.getSelectCount(); i++) {
                size += this.config.getSelectedResult().get(i).getSize();
            }
            if (size > 0) {
                this.originalCheckbox.setText(getContext().getString(R.string.ps_original_image, PictureFileUtils.formatAccurateUnitFileSize(size)));
                return;
            } else {
                this.originalCheckbox.setText(getContext().getString(R.string.ps_default_original_image));
                return;
            }
        }
        this.originalCheckbox.setText(getContext().getString(R.string.ps_default_original_image));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bottomNavBarListener != null && view.getId() == R.id.ps_tv_preview) {
            this.bottomNavBarListener.onPreview();
        }
    }

    public void setOnBottomNavBarListener(OnBottomNavBarListener onBottomNavBarListener) {
        this.bottomNavBarListener = onBottomNavBarListener;
    }
}
