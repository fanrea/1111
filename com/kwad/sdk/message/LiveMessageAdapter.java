package com.kwad.sdk.message;

import android.graphics.Color;
import android.support.v7.widget.aj;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.offline.api.core.adlive.model.LiveMessage;
import com.kwad.sdk.live.R;
import com.kwad.sdk.utils.LiveViewUtils;
import com.kwad.sdk.widget.recycler.LiveBaseRecyclerAdapter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveMessageAdapter extends LiveBaseRecyclerAdapter<LiveMessage, MessageViewHolder> implements View.OnClickListener {
    private static final int VIEW_TYPE_MESSAGE = 1;
    private View.OnClickListener mOnClickListener;

    @Override // android.support.v7.widget.aj.a
    public int getItemViewType(int i) {
        return 1;
    }

    public LiveMessageAdapter(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // android.support.v7.widget.aj.a
    public MessageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = LiveViewUtils.inflate(viewGroup, R.layout.ksad_live_message_item, false);
        viewInflate.setOnClickListener(this);
        return new MessageViewHolder(viewInflate);
    }

    @Override // android.support.v7.widget.aj.a
    public void onBindViewHolder(MessageViewHolder messageViewHolder, int i) {
        bindData(messageViewHolder, (LiveMessage) this.mModelList.get(i));
    }

    private void bindData(MessageViewHolder messageViewHolder, LiveMessage liveMessage) {
        String str = liveMessage.userName + ":  ";
        SpannableString spannableString = new SpannableString(str + liveMessage.content);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#9EE0F7")), 0, str.length(), 17);
        messageViewHolder.mMsgTv.setText(spannableString);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static class MessageViewHolder extends aj.x {
        public TextView mMsgTv;

        public MessageViewHolder(View view) {
            super(view);
            this.mMsgTv = (TextView) view.findViewById(R.id.ksad_msg_tv);
        }
    }
}
