package com.kwad.components.ct.detail.ad.presenter.comment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ct.detail.photo.comment.f;
import com.kwad.components.ct.detail.photo.comment.h;
import com.kwad.components.ct.detail.photo.comment.i;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.view.b;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CommentAdItemView extends RelativeLayout {
    private TextView apD;
    private ImageView apE;
    private ImageView apF;
    private RelativeLayout apG;
    private TextView apH;
    private List<f> apI;
    private h apJ;

    public CommentAdItemView(Context context) {
        super(context);
        this.apI = new ArrayList();
        initView();
    }

    public CommentAdItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apI = new ArrayList();
        initView();
    }

    public CommentAdItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apI = new ArrayList();
        initView();
    }

    private void initView() {
        c.d("CommentAdItemView", "initView");
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_ad_item, (ViewGroup) this, true);
        this.apJ = ((i) d.Kb().a(i.class)).zV();
        this.apE = (ImageView) findViewById(R.id.ksad_photo_comment_item_avatar);
        this.apF = (ImageView) findViewById(R.id.ksad_photo_comment_item_flag_img);
        TextView textView = (TextView) findViewById(R.id.ksad_photo_comment_item_name);
        this.apD = textView;
        g.a(textView, this.apJ.asm);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ksad_photo_comment_item_content_frame);
        this.apG = relativeLayout;
        this.apH = (TextView) relativeLayout.findViewById(R.id.ksad_photo_comment_item_comment);
        this.apE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentAdItemView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentAdItemView.this.u(49, 2);
            }
        });
        this.apD.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentAdItemView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentAdItemView.this.u(47, 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2) {
        Iterator<f> it = this.apI.iterator();
        while (it.hasNext()) {
            it.next().u(i, i2);
        }
    }

    public final void a(CtAdTemplate ctAdTemplate, List<f> list) {
        if (ctAdTemplate == null) {
            return;
        }
        if (list != null) {
            this.apI = list;
        }
        setAuthorIcon(com.kwad.components.ct.response.a.a.bf(ctAdTemplate));
        setName(com.kwad.components.ct.response.a.a.aL(ctAdTemplate));
        u(com.kwad.components.ct.response.a.a.aQ(ctAdTemplate), com.kwad.sdk.core.response.b.a.aI(com.kwad.components.ct.response.a.a.eP(ctAdTemplate)));
        this.apF.setVisibility(0);
    }

    public void setAuthorIcon(String str) {
        com.kwad.sdk.glide.c.cy(getContext()).hh(str).d(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).f(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a(new com.kwad.components.ct.widget.b.a()).b(this.apE);
    }

    public void setName(String str) {
        this.apD.setText(str);
    }

    private void u(final String str, final String str2) {
        this.apH.post(new bh() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentAdItemView.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                CommentAdItemView.this.apH.setText(str);
                String str3 = str;
                CommentAdItemView.this.requestLayout();
                Layout layout = CommentAdItemView.this.apH.getLayout();
                if ((layout != null ? layout.getLineCount() : 0) >= 4) {
                    String string = CommentAdItemView.this.apH.getText().toString();
                    String str4 = "";
                    for (int i = 0; i < 4; i++) {
                        str4 = str4 + string.substring(layout.getLineStart(i), layout.getLineEnd(i));
                    }
                    int length = ((str4.length() - str2.length()) - 3) - 3;
                    if (length > 0) {
                        str3 = str4.substring(0, length) + "...";
                    }
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int length2 = spannableStringBuilder.length();
                int length3 = str3.length() + length2;
                spannableStringBuilder.append((CharSequence) str3);
                spannableStringBuilder.setSpan(new a(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentAdItemView.3.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommentAdItemView.this.u(48, 2);
                    }
                }, g.parseColor(CommentAdItemView.this.apJ.asn)), length2, length3, 33);
                spannableStringBuilder.append((CharSequence) " ");
                int length4 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) "${ad}");
                Drawable drawable = g.getDrawable(CommentAdItemView.this.getContext(), CommentAdItemView.this.apJ.ass);
                b bVarI = new b(drawable, "${ad}").I(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                int i2 = length4 + 5;
                spannableStringBuilder.setSpan(bVarI, length4, i2, 33);
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(new a(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentAdItemView.3.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommentAdItemView.this.u(8, 1);
                    }
                }, g.parseColor(CommentAdItemView.this.apJ.ast)), i2, str2.length() + i2, 33);
                CommentAdItemView.this.apH.setMovementMethod(LinkMovementMethod.getInstance());
                CommentAdItemView.this.apH.setText(spannableStringBuilder);
            }
        });
    }

    static class a extends ClickableSpan {
        private View.OnClickListener apO;
        private int color;

        public a(View.OnClickListener onClickListener, int i) {
            this.apO = onClickListener;
            this.color = i;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View view) {
            View.OnClickListener onClickListener = this.apO;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint textPaint) {
            textPaint.linkColor = this.color;
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }
}
