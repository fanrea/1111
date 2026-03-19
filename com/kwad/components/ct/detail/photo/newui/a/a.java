package com.kwad.components.ct.detail.photo.newui.a;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ct.detail.photo.comment.CommentLikeButton;
import com.kwad.components.ct.detail.photo.comment.b;
import com.kwad.components.ct.detail.photo.comment.h;
import com.kwad.components.ct.detail.photo.comment.i;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.home.PhotoComment;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.photo.comment.a {
    private TextView apD;
    private ImageView apE;
    private RelativeLayout apG;
    private TextView apH;
    private h apJ;
    private ImageView aub;
    private TextView auc;
    private CommentLikeButton aud;
    private b aue;
    private CharSequence auf;
    boolean aug;

    public a(Context context) {
        super(context);
        this.aug = false;
        initView();
    }

    private void initView() {
        c.d("CommentItemView2", "initView");
        m.a(getContext(), R.layout.ksad_photo_comment_item_2, this, true);
        this.apJ = ((i) d.Kb().a(i.class)).zV();
        this.apE = (ImageView) findViewById(R.id.ksad_photo_comment_item_avatar);
        this.aub = (ImageView) findViewById(R.id.ksad_photo_comment_item_self_img);
        TextView textView = (TextView) findViewById(R.id.ksad_photo_comment_item_name);
        this.apD = textView;
        g.a(textView, this.apJ.asm);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ksad_photo_comment_item_content_frame);
        this.apG = relativeLayout;
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.ksad_photo_comment_item_comment);
        this.apH = textView2;
        textView2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.ct.detail.photo.newui.a.a.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                a.this.As();
                a.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.auc = (TextView) this.apG.findViewById(R.id.ksad_photo_comment_item_created_time);
        this.aud = (CommentLikeButton) findViewById(R.id.ksad_photo_comment_item_like_frame);
    }

    public final void setAuthorIcon(String str) {
        ImageView imageView = this.apE;
        KSImageLoader.loadCircleIcon(imageView, str, imageView.getResources().getDrawable(R.drawable.ksad_photo_default_author_icon));
    }

    public final void setName(String str) {
        this.apD.setText(str);
    }

    public final void setCommentTime(long j) {
        TextView textView = this.auc;
        textView.getContext();
        textView.setText(bq.bK(j));
    }

    private void setComment$505cfb5b(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.auc.setVisibility(8);
        setCommentText(spannableStringBuilder);
        this.apH.post(new Runnable() { // from class: com.kwad.components.ct.detail.photo.newui.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.As();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void As() {
        if (this.aue == null) {
            c.d("CommentItemView2", "layoutCommentSpan mCommentItemData == null");
        } else {
            At();
        }
    }

    private void c(int i, long j) {
        this.aud.b(i, j);
        this.aud.setLikeStateListener(new CommentLikeButton.a() { // from class: com.kwad.components.ct.detail.photo.newui.a.a.3
            @Override // com.kwad.components.ct.detail.photo.comment.CommentLikeButton.a
            public final void bD(int i2) {
                if (a.this.aue == null || a.this.aue.arB == null) {
                    return;
                }
                if (i2 == 2) {
                    com.kwad.components.ct.detail.photo.comment.c.h(a.this.aue.arB.photo_id, a.this.aue.arB.comment_id);
                    com.kwad.components.ct.e.b.JK().c(a.this.aue.arC, a.this.aue.arB.comment_id);
                } else {
                    com.kwad.components.ct.detail.photo.comment.c.i(a.this.aue.arB.photo_id, a.this.aue.arB.comment_id);
                    com.kwad.components.ct.e.b.JK().d(a.this.aue.arC, a.this.aue.arB.comment_id);
                }
            }
        });
    }

    @Override // com.kwad.components.ct.detail.photo.comment.a
    public final void setData(b bVar) {
        if (bVar == null) {
            return;
        }
        c.d("CommentItemView2", "bindCommentItemViewData commentHolderData=" + bVar + " commentPosition=" + bVar.arF + " isCommentOpen=" + bVar.arE);
        this.aug = false;
        this.aue = bVar;
        if (bVar.arE) {
            this.apH.setMaxLines(Integer.MAX_VALUE);
        } else {
            this.apH.setMaxLines(4);
        }
        a(this.aue.arB);
        a(this.aue.arB, com.kwad.components.ct.response.a.c.e(com.kwad.components.ct.response.a.a.ay(bVar.arC)));
    }

    private void a(PhotoComment photoComment, long j) {
        if (photoComment != null) {
            if (j == photoComment.author_id) {
                this.aub.setVisibility(0);
            } else {
                this.aub.setVisibility(8);
            }
        }
    }

    private void a(PhotoComment photoComment) {
        if (photoComment == null) {
            return;
        }
        String str = photoComment.author_name;
        if (!TextUtils.isEmpty(photoComment.authorArea)) {
            str = str + " · " + photoComment.authorArea;
        }
        setName(str);
        setAuthorIcon(photoComment.headurl);
        setCommentTime(photoComment.timestamp);
        setComment$505cfb5b(bq.iK(photoComment.content));
        boolean zJ = com.kwad.components.ct.detail.photo.comment.c.j(photoComment.photo_id, photoComment.comment_id);
        int i = zJ ? 2 : 1;
        long j = photoComment.likedCount;
        if (zJ) {
            j++;
        }
        c(i, j);
    }

    private SpannableStringBuilder e(String str, long j) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.apH.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int width = this.apH.getWidth() - com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(com.kwad.sdk.c.a.a.a(getContext(), 13.0f));
        StringBuilder sb = new StringBuilder("  ");
        getContext();
        float fMeasureText = textPaint.measureText(sb.append(bq.bK(j)).toString()) + com.kwad.sdk.c.a.a.a(getContext(), 6.0f);
        float fMeasureText2 = this.apH.getPaint().measureText(str);
        float fA = fMeasureText + fMeasureText2 + com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(g.parseColor(this.apJ.asn)), 0, str.length(), 17);
        int i = (int) fA;
        int i2 = (i / width) + 1;
        int i3 = i % width;
        int i4 = ((int) fMeasureText2) % width;
        if ((((float) (width * 4)) - fA > 0.0f) && i2 <= 4 && i4 + fMeasureText < width && i3 < width) {
            spannableStringBuilder.append((CharSequence) "  ");
            getContext();
            spannableStringBuilder.append((CharSequence) bq.bK(j));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#888B90")), str.length(), spannableStringBuilder.length(), 17);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(13, true), str.length(), spannableStringBuilder.length(), 17);
            this.auc.setVisibility(8);
        } else {
            this.auc.setVisibility(0);
        }
        return spannableStringBuilder;
    }

    private void At() {
        b bVar;
        if (this.aug) {
            setCommentText(this.auf);
            return;
        }
        Layout layout = this.apH.getLayout();
        if (layout == null || (bVar = this.aue) == null || bVar.arB == null) {
            return;
        }
        int lineCount = layout.getLineCount();
        if (lineCount <= 4 && layout.getEllipsisCount(lineCount - 1) == 0) {
            if (this.aue.arG) {
                return;
            }
            setCommentText(e(this.aue.arB.content, this.aue.arB.timestamp));
            this.apH.setOnClickListener(null);
            this.aug = true;
            return;
        }
        this.aue.arG = true;
        this.auc.setVisibility(0);
    }

    final void setCommentText(CharSequence charSequence) {
        this.auf = charSequence;
        this.apH.setText(charSequence);
    }
}
