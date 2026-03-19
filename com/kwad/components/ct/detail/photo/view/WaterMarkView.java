package com.kwad.components.ct.detail.photo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a.a;
import com.kwad.sdk.core.config.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class WaterMarkView extends FrameLayout {
    private TextView arI;

    public WaterMarkView(Context context) {
        this(context, null);
    }

    public WaterMarkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_video_water_mark_2, (ViewGroup) this, true);
        this.arI = (TextView) findViewById(R.id.ksad_video_water_mark_text);
    }

    public void setAlignment(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.arI.getLayoutParams();
        if (i == 1) {
            layoutParams.gravity = 5;
        } else {
            layoutParams.gravity = 3;
        }
        this.arI.setLayoutParams(layoutParams);
    }

    public void setAuthorInfo(CtPhotoInfo.AuthorInfo authorInfo) throws Resources.NotFoundException {
        String string = c.bxO.getValue().intValue() == 1 ? authorInfo.kwaiId : null;
        if (TextUtils.isEmpty(string)) {
            string = authorInfo.authorId == 0 ? null : new StringBuilder().append(authorInfo.authorId).toString();
        }
        if (TextUtils.isEmpty(string)) {
            this.arI.setVisibility(4);
            return;
        }
        this.arI.setVisibility(0);
        this.arI.setText(String.format("＠%s", string));
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.ksad_water_logo);
        setDrawableBounds(drawable);
        this.arI.setCompoundDrawablePadding(a.a(getContext(), 2.0f));
        this.arI.setCompoundDrawables(drawable, null, null, null);
    }

    private void setDrawableBounds(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, a.a(getContext(), 40.0f), a.a(getContext(), 16.0f));
    }
}
