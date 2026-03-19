package com.luck.picture.lib.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.style.TitleBarStyle;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.StyleUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TitleBar extends RelativeLayout implements View.OnClickListener {
    protected SelectorConfig config;
    protected ImageView ivArrow;
    protected ImageView ivDelete;
    protected ImageView ivLeftBack;
    protected RelativeLayout rlAlbumBg;
    protected RelativeLayout titleBarLayout;
    protected View titleBarLine;
    protected OnTitleBarListener titleBarListener;
    protected TextView tvCancel;
    protected MarqueeTextView tvTitle;
    protected View viewAlbumClickArea;
    protected View viewTopStatusBar;

    public static class OnTitleBarListener {
        public void onBackPressed() {
        }

        public void onShowAlbumPopWindow(View view) {
        }

        public void onTitleDoubleClick() {
        }
    }

    protected void handleLayoutUI() {
    }

    public TextView getTitleCancelView() {
        return this.tvCancel;
    }

    public TitleBar(Context context) {
        super(context);
        init();
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void init() {
        Context context;
        int i;
        inflateLayout();
        setClickable(true);
        setFocusable(true);
        this.config = SelectorProviders.getInstance().getSelectorConfig();
        this.viewTopStatusBar = findViewById(R.id.top_status_bar);
        this.titleBarLayout = (RelativeLayout) findViewById(R.id.rl_title_bar);
        this.ivLeftBack = (ImageView) findViewById(R.id.ps_iv_left_back);
        this.rlAlbumBg = (RelativeLayout) findViewById(R.id.ps_rl_album_bg);
        this.ivDelete = (ImageView) findViewById(R.id.ps_iv_delete);
        this.viewAlbumClickArea = findViewById(R.id.ps_rl_album_click);
        this.tvTitle = (MarqueeTextView) findViewById(R.id.ps_tv_title);
        this.ivArrow = (ImageView) findViewById(R.id.ps_iv_arrow);
        this.tvCancel = (TextView) findViewById(R.id.ps_tv_cancel);
        this.titleBarLine = findViewById(R.id.title_bar_line);
        this.ivLeftBack.setOnClickListener(this);
        this.tvCancel.setOnClickListener(this);
        this.rlAlbumBg.setOnClickListener(this);
        this.titleBarLayout.setOnClickListener(this);
        this.viewAlbumClickArea.setOnClickListener(this);
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_grey));
        handleLayoutUI();
        if (TextUtils.isEmpty(this.config.defaultAlbumName)) {
            if (this.config.chooseMode == SelectMimeType.ofAudio()) {
                context = getContext();
                i = R.string.ps_all_audio;
            } else {
                context = getContext();
                i = R.string.ps_camera_roll;
            }
            setTitle(context.getString(i));
            return;
        }
        setTitle(this.config.defaultAlbumName);
    }

    protected void inflateLayout() {
        LayoutInflater.from(getContext()).inflate(R.layout.ps_title_bar, this);
    }

    public ImageView getImageArrow() {
        return this.ivArrow;
    }

    public ImageView getImageDelete() {
        return this.ivDelete;
    }

    public View getTitleBarLine() {
        return this.titleBarLine;
    }

    public void setTitle(String str) {
        this.tvTitle.setText(str);
    }

    public String getTitleText() {
        return this.tvTitle.getText().toString();
    }

    public void setTitleBarStyle() {
        if (this.config.isPreviewFullScreenMode) {
            this.viewTopStatusBar.getLayoutParams().height = DensityUtil.getStatusBarHeight(getContext());
        }
        TitleBarStyle titleBarStyle = this.config.selectorStyle.getTitleBarStyle();
        int titleBarHeight = titleBarStyle.getTitleBarHeight();
        if (StyleUtils.checkSizeValidity(titleBarHeight)) {
            this.titleBarLayout.getLayoutParams().height = titleBarHeight;
        } else {
            this.titleBarLayout.getLayoutParams().height = DensityUtil.dip2px(getContext(), 48.0f);
        }
        if (this.titleBarLine != null) {
            if (titleBarStyle.isDisplayTitleBarLine()) {
                this.titleBarLine.setVisibility(0);
                if (StyleUtils.checkStyleValidity(titleBarStyle.getTitleBarLineColor())) {
                    this.titleBarLine.setBackgroundColor(titleBarStyle.getTitleBarLineColor());
                }
            } else {
                this.titleBarLine.setVisibility(8);
            }
        }
        int titleBackgroundColor = titleBarStyle.getTitleBackgroundColor();
        if (StyleUtils.checkStyleValidity(titleBackgroundColor)) {
            setBackgroundColor(titleBackgroundColor);
        }
        int titleLeftBackResource = titleBarStyle.getTitleLeftBackResource();
        if (StyleUtils.checkStyleValidity(titleLeftBackResource)) {
            this.ivLeftBack.setImageResource(titleLeftBackResource);
        }
        String string = StyleUtils.checkStyleValidity(titleBarStyle.getTitleDefaultTextResId()) ? getContext().getString(titleBarStyle.getTitleDefaultTextResId()) : titleBarStyle.getTitleDefaultText();
        if (StyleUtils.checkTextValidity(string)) {
            this.tvTitle.setText(string);
        }
        int titleTextSize = titleBarStyle.getTitleTextSize();
        if (StyleUtils.checkSizeValidity(titleTextSize)) {
            this.tvTitle.setTextSize(titleTextSize);
        }
        int titleTextColor = titleBarStyle.getTitleTextColor();
        if (StyleUtils.checkStyleValidity(titleTextColor)) {
            this.tvTitle.setTextColor(titleTextColor);
        }
        if (this.config.isOnlySandboxDir) {
            this.ivArrow.setImageResource(R.drawable.ps_ic_trans_1px);
        } else {
            int titleDrawableRightResource = titleBarStyle.getTitleDrawableRightResource();
            if (StyleUtils.checkStyleValidity(titleDrawableRightResource)) {
                this.ivArrow.setImageResource(titleDrawableRightResource);
            }
        }
        int titleAlbumBackgroundResource = titleBarStyle.getTitleAlbumBackgroundResource();
        if (StyleUtils.checkStyleValidity(titleAlbumBackgroundResource)) {
            this.rlAlbumBg.setBackgroundResource(titleAlbumBackgroundResource);
        }
        if (titleBarStyle.isHideCancelButton()) {
            this.tvCancel.setVisibility(8);
        } else {
            this.tvCancel.setVisibility(0);
            int titleCancelBackgroundResource = titleBarStyle.getTitleCancelBackgroundResource();
            if (StyleUtils.checkStyleValidity(titleCancelBackgroundResource)) {
                this.tvCancel.setBackgroundResource(titleCancelBackgroundResource);
            }
            String string2 = StyleUtils.checkStyleValidity(titleBarStyle.getTitleCancelTextResId()) ? getContext().getString(titleBarStyle.getTitleCancelTextResId()) : titleBarStyle.getTitleCancelText();
            if (StyleUtils.checkTextValidity(string2)) {
                this.tvCancel.setText(string2);
            }
            int titleCancelTextColor = titleBarStyle.getTitleCancelTextColor();
            if (StyleUtils.checkStyleValidity(titleCancelTextColor)) {
                this.tvCancel.setTextColor(titleCancelTextColor);
            }
            int titleCancelTextSize = titleBarStyle.getTitleCancelTextSize();
            if (StyleUtils.checkSizeValidity(titleCancelTextSize)) {
                this.tvCancel.setTextSize(titleCancelTextSize);
            }
        }
        int previewDeleteBackgroundResource = titleBarStyle.getPreviewDeleteBackgroundResource();
        if (StyleUtils.checkStyleValidity(previewDeleteBackgroundResource)) {
            this.ivDelete.setBackgroundResource(previewDeleteBackgroundResource);
        } else {
            this.ivDelete.setBackgroundResource(R.drawable.ps_ic_delete);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnTitleBarListener onTitleBarListener;
        int id = view.getId();
        if (id == R.id.ps_iv_left_back || id == R.id.ps_tv_cancel) {
            OnTitleBarListener onTitleBarListener2 = this.titleBarListener;
            if (onTitleBarListener2 != null) {
                onTitleBarListener2.onBackPressed();
                return;
            }
            return;
        }
        if (id == R.id.ps_rl_album_bg || id == R.id.ps_rl_album_click) {
            OnTitleBarListener onTitleBarListener3 = this.titleBarListener;
            if (onTitleBarListener3 != null) {
                onTitleBarListener3.onShowAlbumPopWindow(this);
                return;
            }
            return;
        }
        if (id != R.id.rl_title_bar || (onTitleBarListener = this.titleBarListener) == null) {
            return;
        }
        onTitleBarListener.onTitleDoubleClick();
    }

    public void setOnTitleBarListener(OnTitleBarListener onTitleBarListener) {
        this.titleBarListener = onTitleBarListener;
    }
}
