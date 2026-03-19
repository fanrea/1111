package com.kwad.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.kuaishou.livestream.message.nano.LiveExtraMessages;
import com.kuaishou.livestream.message.nano.LiveShopMessages;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kuaishou.livestream.message.nano.SCActionSignal;
import com.kuaishou.merchant.message.nano.LiveRoomSignalMessage;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopInfoListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.listener.KsAdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.model.LiveMessage;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.sdk.live.R;
import com.kwad.sdk.message.LiveMessageAdapter;
import com.kwad.sdk.message.LiveMessageController;
import com.kwad.sdk.message.LiveMessageCovert;
import com.kwad.sdk.message.LiveMessageLinearLayoutManager;
import com.kwad.sdk.message.LiveMessageRecyclerView;
import com.kwad.sdk.utils.LiveViewUtils;
import com.kwad.sdk.widget.LiveSpacesItemDecoration;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.MessageNanoParser;
import com.yxcorp.livestream.longconnection.SCMessageListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AdLiveViewImpl extends FrameLayout implements View.OnClickListener, IAdLiveOfflineView {
    private static final String ACTION_SALE_ITEM_CHANGE = "liveOnSaleItemChange";
    private static final String INTERPRETATION_CHANGE_PRICE = "liveRecordItemInfoChange";
    private static final int PROFILE_PHOTOS_VERTICAL_SPACING_DP = 4;
    private static final String STATE_START_INTERPRETATION = "liveItemStartRecord";
    private static final String STATE_STOP_INTERPRETATION = "liveItemStopRecord";
    private static final String TAG = "AdLiveViewImpl";
    private int mDefaultHeight;
    private List<AdLiveHandleClickListener> mHandleClickListeners;
    private LiveRoomSignalMessage.ItemInfo mItemInfo;
    private LiveMessageListener mLiveMessageListener;
    private LiveMessageController mMessageController;
    private View mMessageLayout;
    private LiveMessageRecyclerView mMessageRecyclerView;
    private TextView mNewMsgTip;
    private View.OnClickListener mOnClickListener;
    private SCMessageListener mSCMessageListener;
    private View mShopCard;
    private ImageView mShopCardIcon;
    private TextView mShopCardPrice;
    private TextView mShopCardTitle;
    private boolean mShowMessageAndShopCard;
    private TextureView mTextureView;

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public View getView() {
        return this;
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerAdLiveShopInfoListener(AdLiveShopInfoListener adLiveShopInfoListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerKsAdLiveMessageListener(KsAdLiveMessageListener ksAdLiveMessageListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerLiveMessageListener(AdLiveMessageListener adLiveMessageListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerLiveShopListener(AdLiveShopListener adLiveShopListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterAdLiveShopInfoListener(AdLiveShopInfoListener adLiveShopInfoListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterKsAdLiveMessageListener(KsAdLiveMessageListener ksAdLiveMessageListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterLiveMessageListener(AdLiveMessageListener adLiveMessageListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterLiveShopListener(AdLiveShopListener adLiveShopListener) {
    }

    public void setShowMessageAndShopCard(boolean z) {
        this.mShowMessageAndShopCard = z;
        if (!this.mShowMessageAndShopCard) {
            this.mMessageLayout.setVisibility(8);
            this.mShopCard.setVisibility(8);
            this.mShopCard.setOnClickListener(null);
        } else {
            this.mMessageLayout.setVisibility(0);
            this.mShopCard.setOnClickListener(this);
        }
    }

    private String getFormatPrice(String str) {
        if (str.contains(".")) {
            if (str.length() <= 0 || str.substring(str.indexOf(".")).length() - 1 != 1) {
                return str;
            }
            return str + "0";
        }
        return str + ".00";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShopCard(String str, String str2, String str3) throws Resources.NotFoundException {
        Log.d(TAG, "receive onMessageReceived message showShopCard: title:" + str + "  price:" + str3);
        this.mShopCard.setVisibility(0);
        this.mShopCardTitle.setText(str);
        this.mShopCardPrice.setText(getFormatPrice(str3));
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.ksad_live_kwai_logo);
        OfflineHostProvider.getApi().imageLoader().loadImage(this.mShopCardIcon, str2, new IImageLoader.DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(false).cacheInMemory(false).showImageOnFail(drawable).showImageForEmptyUri(drawable).showImageOnLoading(drawable).setCornerRound(10).build(), new IImageLoader.ImageLoadingListener() { // from class: com.kwad.sdk.AdLiveViewImpl.1
            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public boolean onDecode(String str4, InputStream inputStream, Bitmap bitmap) {
                return false;
            }

            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public void onLoadingCancelled(String str4, View view) {
            }

            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public void onLoadingComplete(String str4, View view, Bitmap bitmap) {
            }

            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public void onLoadingFailed(String str4, View view, String str5, Throwable th) {
            }

            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public void onLoadingStarted(String str4, View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideShopCard() {
        this.mShopCard.setVisibility(4);
    }

    private void initLiveMessage() {
        LiveMessageAdapter liveMessageAdapter = new LiveMessageAdapter(this.mOnClickListener);
        LiveMessageLinearLayoutManager liveMessageLinearLayoutManager = new LiveMessageLinearLayoutManager(getContext());
        liveMessageLinearLayoutManager.setStackFromEnd(true);
        this.mMessageRecyclerView.setMathHeight(this.mDefaultHeight);
        this.mMessageRecyclerView.setLayoutManager(liveMessageLinearLayoutManager);
        this.mMessageRecyclerView.setItemAnimator(null);
        this.mMessageRecyclerView.setAdapter(liveMessageAdapter);
        if (this.mMessageRecyclerView.getItemDecorationCount() == 0) {
            this.mMessageRecyclerView.addItemDecoration(new LiveSpacesItemDecoration(LiveViewUtils.dip2px(getContext(), 4.0f)));
        }
        this.mMessageController = new LiveMessageController(this.mMessageRecyclerView, liveMessageAdapter, this.mNewMsgTip);
        this.mMessageController.startRefreshMessage();
    }

    public AdLiveViewImpl(Context context) {
        super(context);
        this.mHandleClickListeners = new ArrayList();
        this.mOnClickListener = new View.OnClickListener() { // from class: com.kwad.sdk.AdLiveViewImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d(AdLiveViewImpl.TAG, "onClick: mMessageLayout" + AdLiveViewImpl.this.mHandleClickListeners.size());
                Iterator it = AdLiveViewImpl.this.mHandleClickListeners.iterator();
                while (it.hasNext()) {
                    ((AdLiveHandleClickListener) it.next()).handleAdLiveClick(2);
                }
            }
        };
        this.mLiveMessageListener = new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.AdLiveViewImpl.3
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
                super.onFeedReceived(sCFeedPush);
                Log.d(AdLiveViewImpl.TAG, "receive onFeedReceived message SCFeedPush mShowMessageAndShopCard:" + AdLiveViewImpl.this.mShowMessageAndShopCard);
                if (AdLiveViewImpl.this.mShowMessageAndShopCard) {
                    for (LiveMessage liveMessage : LiveMessageCovert.fromLiveMessage(sCFeedPush)) {
                        if (AdLiveViewImpl.this.mMessageController != null) {
                            Log.d("live message tag", "live message received SCFeedPush");
                            AdLiveViewImpl.this.mMessageController.addLiveMessage(liveMessage);
                        }
                    }
                }
            }
        };
        this.mSCMessageListener = new SCMessageListener() { // from class: com.kwad.sdk.AdLiveViewImpl.4
            @Override // com.yxcorp.livestream.longconnection.SCMessageListener
            public void onMessageReceived(MessageNano messageNano) throws Resources.NotFoundException {
                Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message mShowMessageAndShopCard:" + AdLiveViewImpl.this.mShowMessageAndShopCard);
                if (AdLiveViewImpl.this.mShowMessageAndShopCard) {
                    Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message");
                    if (messageNano instanceof SCActionSignal) {
                        Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal");
                        for (LiveShopMessages.LiveShopAction liveShopAction : ((SCActionSignal) messageNano).shopAction) {
                            MessageNanoParser messageNanoParser = new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class);
                            Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal payloadType:" + liveShopAction.action.payloadType);
                            if (AdLiveViewImpl.ACTION_SALE_ITEM_CHANGE.equals(liveShopAction.action.payloadType)) {
                                try {
                                    LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal = (LiveRoomSignalMessage.LiveItemChangeSignal) messageNanoParser.apply(liveShopAction.action.payload);
                                    AdLiveViewImpl.this.mItemInfo = liveItemChangeSignal.itemInfo[0];
                                    Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal changeType: " + liveItemChangeSignal.changeType);
                                    int i = liveItemChangeSignal.changeType;
                                    if (i == 0) {
                                        Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSigna l itemInfo :" + AdLiveViewImpl.this.mItemInfo.toString());
                                    } else if (i == 1) {
                                        Log.d(AdLiveViewImpl.TAG, "live item off sale");
                                        AdLiveViewImpl.this.mItemInfo = null;
                                    }
                                } catch (Throwable th) {
                                    Log.d(AdLiveViewImpl.TAG, "parse live item error");
                                    th.printStackTrace();
                                }
                            }
                        }
                        return;
                    }
                    if (messageNano instanceof LiveShopMessages.SCLiveShopState) {
                        Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                        LiveShopMessages.SCLiveShopState sCLiveShopState = (LiveShopMessages.SCLiveShopState) messageNano;
                        Log.d(AdLiveViewImpl.TAG, "receive LiveItemChangeSignal message:" + sCLiveShopState);
                        LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = sCLiveShopState.state;
                        if (liveCommonAbstractSignal == null || liveCommonAbstractSignal.payloadType == null || !AdLiveViewImpl.this.isIntroducingItemChangePayload(liveCommonAbstractSignal.payloadType)) {
                            return;
                        }
                        try {
                            LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal2 = (LiveRoomSignalMessage.LiveItemChangeSignal) new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class).apply(liveCommonAbstractSignal.payload);
                            AdLiveViewImpl.this.mItemInfo = liveItemChangeSignal2.itemInfo[0];
                            int i2 = liveItemChangeSignal2.changeType;
                            if (i2 == 2) {
                                AdLiveViewImpl.this.showShopCard(AdLiveViewImpl.this.mItemInfo.title, AdLiveViewImpl.this.mItemInfo.imageUrl[0].url, AdLiveViewImpl.this.mItemInfo.price);
                                return;
                            }
                            if (i2 != 3) {
                                return;
                            }
                            AdLiveViewImpl.this.hideShopCard();
                            Log.d(AdLiveViewImpl.TAG, "live item stop record" + AdLiveViewImpl.this.mItemInfo.itemId);
                            AdLiveViewImpl.this.mItemInfo = null;
                        } catch (InvalidProtocolBufferNanoException e) {
                            Log.d(AdLiveViewImpl.TAG, "parse live item error");
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        initView();
    }

    public AdLiveViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandleClickListeners = new ArrayList();
        this.mOnClickListener = new View.OnClickListener() { // from class: com.kwad.sdk.AdLiveViewImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d(AdLiveViewImpl.TAG, "onClick: mMessageLayout" + AdLiveViewImpl.this.mHandleClickListeners.size());
                Iterator it = AdLiveViewImpl.this.mHandleClickListeners.iterator();
                while (it.hasNext()) {
                    ((AdLiveHandleClickListener) it.next()).handleAdLiveClick(2);
                }
            }
        };
        this.mLiveMessageListener = new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.AdLiveViewImpl.3
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
                super.onFeedReceived(sCFeedPush);
                Log.d(AdLiveViewImpl.TAG, "receive onFeedReceived message SCFeedPush mShowMessageAndShopCard:" + AdLiveViewImpl.this.mShowMessageAndShopCard);
                if (AdLiveViewImpl.this.mShowMessageAndShopCard) {
                    for (LiveMessage liveMessage : LiveMessageCovert.fromLiveMessage(sCFeedPush)) {
                        if (AdLiveViewImpl.this.mMessageController != null) {
                            Log.d("live message tag", "live message received SCFeedPush");
                            AdLiveViewImpl.this.mMessageController.addLiveMessage(liveMessage);
                        }
                    }
                }
            }
        };
        this.mSCMessageListener = new SCMessageListener() { // from class: com.kwad.sdk.AdLiveViewImpl.4
            @Override // com.yxcorp.livestream.longconnection.SCMessageListener
            public void onMessageReceived(MessageNano messageNano) throws Resources.NotFoundException {
                Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message mShowMessageAndShopCard:" + AdLiveViewImpl.this.mShowMessageAndShopCard);
                if (AdLiveViewImpl.this.mShowMessageAndShopCard) {
                    Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message");
                    if (messageNano instanceof SCActionSignal) {
                        Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal");
                        for (LiveShopMessages.LiveShopAction liveShopAction : ((SCActionSignal) messageNano).shopAction) {
                            MessageNanoParser messageNanoParser = new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class);
                            Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal payloadType:" + liveShopAction.action.payloadType);
                            if (AdLiveViewImpl.ACTION_SALE_ITEM_CHANGE.equals(liveShopAction.action.payloadType)) {
                                try {
                                    LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal = (LiveRoomSignalMessage.LiveItemChangeSignal) messageNanoParser.apply(liveShopAction.action.payload);
                                    AdLiveViewImpl.this.mItemInfo = liveItemChangeSignal.itemInfo[0];
                                    Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal changeType: " + liveItemChangeSignal.changeType);
                                    int i = liveItemChangeSignal.changeType;
                                    if (i == 0) {
                                        Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSigna l itemInfo :" + AdLiveViewImpl.this.mItemInfo.toString());
                                    } else if (i == 1) {
                                        Log.d(AdLiveViewImpl.TAG, "live item off sale");
                                        AdLiveViewImpl.this.mItemInfo = null;
                                    }
                                } catch (Throwable th) {
                                    Log.d(AdLiveViewImpl.TAG, "parse live item error");
                                    th.printStackTrace();
                                }
                            }
                        }
                        return;
                    }
                    if (messageNano instanceof LiveShopMessages.SCLiveShopState) {
                        Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                        LiveShopMessages.SCLiveShopState sCLiveShopState = (LiveShopMessages.SCLiveShopState) messageNano;
                        Log.d(AdLiveViewImpl.TAG, "receive LiveItemChangeSignal message:" + sCLiveShopState);
                        LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = sCLiveShopState.state;
                        if (liveCommonAbstractSignal == null || liveCommonAbstractSignal.payloadType == null || !AdLiveViewImpl.this.isIntroducingItemChangePayload(liveCommonAbstractSignal.payloadType)) {
                            return;
                        }
                        try {
                            LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal2 = (LiveRoomSignalMessage.LiveItemChangeSignal) new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class).apply(liveCommonAbstractSignal.payload);
                            AdLiveViewImpl.this.mItemInfo = liveItemChangeSignal2.itemInfo[0];
                            int i2 = liveItemChangeSignal2.changeType;
                            if (i2 == 2) {
                                AdLiveViewImpl.this.showShopCard(AdLiveViewImpl.this.mItemInfo.title, AdLiveViewImpl.this.mItemInfo.imageUrl[0].url, AdLiveViewImpl.this.mItemInfo.price);
                                return;
                            }
                            if (i2 != 3) {
                                return;
                            }
                            AdLiveViewImpl.this.hideShopCard();
                            Log.d(AdLiveViewImpl.TAG, "live item stop record" + AdLiveViewImpl.this.mItemInfo.itemId);
                            AdLiveViewImpl.this.mItemInfo = null;
                        } catch (InvalidProtocolBufferNanoException e) {
                            Log.d(AdLiveViewImpl.TAG, "parse live item error");
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        initView();
    }

    public AdLiveViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandleClickListeners = new ArrayList();
        this.mOnClickListener = new View.OnClickListener() { // from class: com.kwad.sdk.AdLiveViewImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d(AdLiveViewImpl.TAG, "onClick: mMessageLayout" + AdLiveViewImpl.this.mHandleClickListeners.size());
                Iterator it = AdLiveViewImpl.this.mHandleClickListeners.iterator();
                while (it.hasNext()) {
                    ((AdLiveHandleClickListener) it.next()).handleAdLiveClick(2);
                }
            }
        };
        this.mLiveMessageListener = new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.AdLiveViewImpl.3
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
                super.onFeedReceived(sCFeedPush);
                Log.d(AdLiveViewImpl.TAG, "receive onFeedReceived message SCFeedPush mShowMessageAndShopCard:" + AdLiveViewImpl.this.mShowMessageAndShopCard);
                if (AdLiveViewImpl.this.mShowMessageAndShopCard) {
                    for (LiveMessage liveMessage : LiveMessageCovert.fromLiveMessage(sCFeedPush)) {
                        if (AdLiveViewImpl.this.mMessageController != null) {
                            Log.d("live message tag", "live message received SCFeedPush");
                            AdLiveViewImpl.this.mMessageController.addLiveMessage(liveMessage);
                        }
                    }
                }
            }
        };
        this.mSCMessageListener = new SCMessageListener() { // from class: com.kwad.sdk.AdLiveViewImpl.4
            @Override // com.yxcorp.livestream.longconnection.SCMessageListener
            public void onMessageReceived(MessageNano messageNano) throws Resources.NotFoundException {
                Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message mShowMessageAndShopCard:" + AdLiveViewImpl.this.mShowMessageAndShopCard);
                if (AdLiveViewImpl.this.mShowMessageAndShopCard) {
                    Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message");
                    if (messageNano instanceof SCActionSignal) {
                        Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal");
                        for (LiveShopMessages.LiveShopAction liveShopAction : ((SCActionSignal) messageNano).shopAction) {
                            MessageNanoParser messageNanoParser = new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class);
                            Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal payloadType:" + liveShopAction.action.payloadType);
                            if (AdLiveViewImpl.ACTION_SALE_ITEM_CHANGE.equals(liveShopAction.action.payloadType)) {
                                try {
                                    LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal = (LiveRoomSignalMessage.LiveItemChangeSignal) messageNanoParser.apply(liveShopAction.action.payload);
                                    AdLiveViewImpl.this.mItemInfo = liveItemChangeSignal.itemInfo[0];
                                    Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal changeType: " + liveItemChangeSignal.changeType);
                                    int i2 = liveItemChangeSignal.changeType;
                                    if (i2 == 0) {
                                        Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSigna l itemInfo :" + AdLiveViewImpl.this.mItemInfo.toString());
                                    } else if (i2 == 1) {
                                        Log.d(AdLiveViewImpl.TAG, "live item off sale");
                                        AdLiveViewImpl.this.mItemInfo = null;
                                    }
                                } catch (Throwable th) {
                                    Log.d(AdLiveViewImpl.TAG, "parse live item error");
                                    th.printStackTrace();
                                }
                            }
                        }
                        return;
                    }
                    if (messageNano instanceof LiveShopMessages.SCLiveShopState) {
                        Log.d(AdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                        LiveShopMessages.SCLiveShopState sCLiveShopState = (LiveShopMessages.SCLiveShopState) messageNano;
                        Log.d(AdLiveViewImpl.TAG, "receive LiveItemChangeSignal message:" + sCLiveShopState);
                        LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = sCLiveShopState.state;
                        if (liveCommonAbstractSignal == null || liveCommonAbstractSignal.payloadType == null || !AdLiveViewImpl.this.isIntroducingItemChangePayload(liveCommonAbstractSignal.payloadType)) {
                            return;
                        }
                        try {
                            LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal2 = (LiveRoomSignalMessage.LiveItemChangeSignal) new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class).apply(liveCommonAbstractSignal.payload);
                            AdLiveViewImpl.this.mItemInfo = liveItemChangeSignal2.itemInfo[0];
                            int i22 = liveItemChangeSignal2.changeType;
                            if (i22 == 2) {
                                AdLiveViewImpl.this.showShopCard(AdLiveViewImpl.this.mItemInfo.title, AdLiveViewImpl.this.mItemInfo.imageUrl[0].url, AdLiveViewImpl.this.mItemInfo.price);
                                return;
                            }
                            if (i22 != 3) {
                                return;
                            }
                            AdLiveViewImpl.this.hideShopCard();
                            Log.d(AdLiveViewImpl.TAG, "live item stop record" + AdLiveViewImpl.this.mItemInfo.itemId);
                            AdLiveViewImpl.this.mItemInfo = null;
                        } catch (InvalidProtocolBufferNanoException e) {
                            Log.d(AdLiveViewImpl.TAG, "parse live item error");
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        initView();
    }

    private void initEnvironment() {
        Context context = this.mTextureView.getContext();
        if (LiveViewUtils.getScreenRealHeight(context) < LiveViewUtils.getScreenWidth(context)) {
            ViewGroup.LayoutParams layoutParams = this.mMessageLayout.getLayoutParams();
            layoutParams.width = LiveViewUtils.dip2px(context, 247.0f);
            this.mMessageLayout.setLayoutParams(layoutParams);
        }
    }

    private void initView() {
        inflate(getContext(), R.layout.ksad_live_room_layout, this);
        this.mTextureView = (TextureView) findViewById(R.id.ksad_live_room_texture);
        this.mMessageRecyclerView = (LiveMessageRecyclerView) findViewById(R.id.ksad_message_list);
        this.mMessageLayout = findViewById(R.id.ksad_message_layout);
        this.mNewMsgTip = (TextView) findViewById(R.id.ksad_message_tip);
        this.mDefaultHeight = this.mMessageRecyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.ksad_live_message_default_height);
        this.mShopCard = findViewById(R.id.ksad_live_current_introduce_goods);
        this.mShopCardPrice = (TextView) findViewById(R.id.ksad_goods_price);
        this.mShopCardTitle = (TextView) findViewById(R.id.ksad_goods_name);
        this.mShopCardIcon = (ImageView) findViewById(R.id.ksad_goods_image);
        initLiveMessage();
        initEnvironment();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public TextureView getTextureView() {
        return this.mTextureView;
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void onDestroy() {
        this.mHandleClickListeners.clear();
        this.mMessageController.release();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerClickListener(AdLiveHandleClickListener adLiveHandleClickListener) {
        Log.d(TAG, "registerClickListener: ");
        this.mHandleClickListeners.add(adLiveHandleClickListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterClickListener(AdLiveHandleClickListener adLiveHandleClickListener) {
        Log.d(TAG, "unRegisterClickListener: ");
        this.mHandleClickListeners.remove(adLiveHandleClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Log.d(TAG, "onClick:");
        if (view == this.mShopCard) {
            Log.d(TAG, "onClick: mShopCard" + this.mHandleClickListeners.size());
            Iterator<AdLiveHandleClickListener> it = this.mHandleClickListeners.iterator();
            while (it.hasNext()) {
                it.next().handleAdLiveClick(1);
            }
        }
    }

    public LiveMessageListener getLiveMessageListener() {
        return this.mLiveMessageListener;
    }

    public SCMessageListener getSCMessageListener() {
        return this.mSCMessageListener;
    }

    public LiveRoomSignalMessage.ItemInfo getCurrentShowShopItemInfo() {
        return this.mItemInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isIntroducingItemChangePayload(String str) {
        return STATE_START_INTERPRETATION.equals(str) || STATE_STOP_INTERPRETATION.equals(str) || INTERPRETATION_CHANGE_PRICE.equals(str);
    }
}
