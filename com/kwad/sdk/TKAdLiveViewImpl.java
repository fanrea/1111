package com.kwad.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.kuaishou.livestream.message.nano.LiveExtraMessages;
import com.kuaishou.livestream.message.nano.LiveShopMessages;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kuaishou.livestream.message.nano.LiveTreasureBoxMessage;
import com.kuaishou.livestream.message.nano.SCActionSignal;
import com.kuaishou.merchant.message.nano.LiveRoomSignalMessage;
import com.kuaishou.protobuf.livestream.nano.SCLiveConditionRedPackInfo;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopInfoListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.listener.KsAdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.model.KSAdLiveRoomItemInfo;
import com.kwad.components.offline.api.core.adlive.model.KSAdLiveShopInfo;
import com.kwad.components.offline.api.core.adlive.model.LiveMessage;
import com.kwad.components.offline.api.core.widget.RcFrameLayout;
import com.kwad.sdk.message.LiveMessageCovert;
import com.kwad.sdk.widget.KSLiveTextureView;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.MessageNanoParser;
import com.yxcorp.livestream.longconnection.SCMessageListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class TKAdLiveViewImpl extends RcFrameLayout implements IAdLiveOfflineView {
    private static final String ACTION_SALE_ITEM_CHANGE = "liveOnSaleItemChange";
    private static final String INTERPRETATION_CHANGE_PRICE = "liveRecordItemInfoChange";
    private static final String STATE_START_INTERPRETATION = "liveItemStartRecord";
    private static final String STATE_STOP_INTERPRETATION = "liveItemStopRecord";
    private static final String TAG = "TKAdLiveViewImpl";
    private final List<KsAdLiveMessageListener> mHandleAdLiveMessageListeners;
    private final List<AdLiveShopInfoListener> mHandleAdLiveShopInfoListeners;
    private RcFrameLayout mLayout;
    private LiveMessageListener mLiveMessageListener;
    private SCMessageListener mSCMessageListener;
    private TextureView mTextureView;

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerClickListener(AdLiveHandleClickListener adLiveHandleClickListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerLiveMessageListener(AdLiveMessageListener adLiveMessageListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerLiveShopListener(AdLiveShopListener adLiveShopListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterClickListener(AdLiveHandleClickListener adLiveHandleClickListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterLiveMessageListener(AdLiveMessageListener adLiveMessageListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterLiveShopListener(AdLiveShopListener adLiveShopListener) {
    }

    public TKAdLiveViewImpl(Context context) {
        super(context);
        this.mHandleAdLiveMessageListeners = new ArrayList();
        this.mHandleAdLiveShopInfoListeners = new ArrayList();
        this.mLiveMessageListener = new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.TKAdLiveViewImpl.1
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
                super.onFeedReceived(sCFeedPush);
                for (LiveMessage liveMessage : LiveMessageCovert.fromLiveMessage(sCFeedPush)) {
                    Iterator it = TKAdLiveViewImpl.this.mHandleAdLiveMessageListeners.iterator();
                    while (it.hasNext()) {
                        ((KsAdLiveMessageListener) it.next()).addLiveMessageData(liveMessage);
                    }
                }
            }
        };
        this.mSCMessageListener = new SCMessageListener() { // from class: com.kwad.sdk.TKAdLiveViewImpl.2
            @Override // com.yxcorp.livestream.longconnection.SCMessageListener
            public void onMessageReceived(MessageNano messageNano) {
                Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message" + messageNano.toString());
                if (messageNano instanceof SCActionSignal) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal");
                    for (LiveShopMessages.LiveShopAction liveShopAction : ((SCActionSignal) messageNano).shopAction) {
                        MessageNanoParser messageNanoParser = new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class);
                        Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal payloadType:" + liveShopAction.action.payloadType);
                        if (TKAdLiveViewImpl.ACTION_SALE_ITEM_CHANGE.equals(liveShopAction.action.payloadType)) {
                            try {
                                LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal = (LiveRoomSignalMessage.LiveItemChangeSignal) messageNanoParser.apply(liveShopAction.action.payload);
                                LiveRoomSignalMessage.ItemInfo itemInfo = liveItemChangeSignal.itemInfo[0];
                                Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal changeType: " + liveItemChangeSignal.changeType);
                                TKAdLiveViewImpl.this.handleLiveRoomSignalMessage(itemInfo, liveItemChangeSignal);
                            } catch (Throwable th) {
                                Log.d(TKAdLiveViewImpl.TAG, "parse live item error");
                                th.printStackTrace();
                            }
                        }
                    }
                    return;
                }
                if (messageNano instanceof LiveShopMessages.SCLiveShopState) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                    LiveShopMessages.SCLiveShopState sCLiveShopState = (LiveShopMessages.SCLiveShopState) messageNano;
                    Log.d(TKAdLiveViewImpl.TAG, "receive LiveItemChangeSignal message:" + sCLiveShopState);
                    LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = sCLiveShopState.state;
                    if (liveCommonAbstractSignal == null || liveCommonAbstractSignal.payloadType == null || !TKAdLiveViewImpl.this.isIntroducingItemChangePayload(liveCommonAbstractSignal.payloadType)) {
                        return;
                    }
                    try {
                        LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal2 = (LiveRoomSignalMessage.LiveItemChangeSignal) new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class).apply(liveCommonAbstractSignal.payload);
                        TKAdLiveViewImpl.this.handleLiveRoomSignalMessage(liveItemChangeSignal2.itemInfo[0], liveItemChangeSignal2);
                        return;
                    } catch (InvalidProtocolBufferNanoException e) {
                        Log.d(TKAdLiveViewImpl.TAG, "parse live item error");
                        e.printStackTrace();
                        return;
                    }
                }
                if (messageNano instanceof SCLiveConditionRedPackInfo) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                    Log.d(TKAdLiveViewImpl.TAG, "receive redPackInfo message:" + ((SCLiveConditionRedPackInfo) messageNano));
                    return;
                }
                if (messageNano instanceof LiveTreasureBoxMessage.SCLiveTreasureBoxShow) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                    Log.d(TKAdLiveViewImpl.TAG, "receive liveTreasureBoxShow message:" + ((LiveTreasureBoxMessage.SCLiveTreasureBoxShow) messageNano));
                }
            }
        };
        initView(context);
    }

    public TKAdLiveViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandleAdLiveMessageListeners = new ArrayList();
        this.mHandleAdLiveShopInfoListeners = new ArrayList();
        this.mLiveMessageListener = new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.TKAdLiveViewImpl.1
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
                super.onFeedReceived(sCFeedPush);
                for (LiveMessage liveMessage : LiveMessageCovert.fromLiveMessage(sCFeedPush)) {
                    Iterator it = TKAdLiveViewImpl.this.mHandleAdLiveMessageListeners.iterator();
                    while (it.hasNext()) {
                        ((KsAdLiveMessageListener) it.next()).addLiveMessageData(liveMessage);
                    }
                }
            }
        };
        this.mSCMessageListener = new SCMessageListener() { // from class: com.kwad.sdk.TKAdLiveViewImpl.2
            @Override // com.yxcorp.livestream.longconnection.SCMessageListener
            public void onMessageReceived(MessageNano messageNano) {
                Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message" + messageNano.toString());
                if (messageNano instanceof SCActionSignal) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal");
                    for (LiveShopMessages.LiveShopAction liveShopAction : ((SCActionSignal) messageNano).shopAction) {
                        MessageNanoParser messageNanoParser = new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class);
                        Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal payloadType:" + liveShopAction.action.payloadType);
                        if (TKAdLiveViewImpl.ACTION_SALE_ITEM_CHANGE.equals(liveShopAction.action.payloadType)) {
                            try {
                                LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal = (LiveRoomSignalMessage.LiveItemChangeSignal) messageNanoParser.apply(liveShopAction.action.payload);
                                LiveRoomSignalMessage.ItemInfo itemInfo = liveItemChangeSignal.itemInfo[0];
                                Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal changeType: " + liveItemChangeSignal.changeType);
                                TKAdLiveViewImpl.this.handleLiveRoomSignalMessage(itemInfo, liveItemChangeSignal);
                            } catch (Throwable th) {
                                Log.d(TKAdLiveViewImpl.TAG, "parse live item error");
                                th.printStackTrace();
                            }
                        }
                    }
                    return;
                }
                if (messageNano instanceof LiveShopMessages.SCLiveShopState) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                    LiveShopMessages.SCLiveShopState sCLiveShopState = (LiveShopMessages.SCLiveShopState) messageNano;
                    Log.d(TKAdLiveViewImpl.TAG, "receive LiveItemChangeSignal message:" + sCLiveShopState);
                    LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = sCLiveShopState.state;
                    if (liveCommonAbstractSignal == null || liveCommonAbstractSignal.payloadType == null || !TKAdLiveViewImpl.this.isIntroducingItemChangePayload(liveCommonAbstractSignal.payloadType)) {
                        return;
                    }
                    try {
                        LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal2 = (LiveRoomSignalMessage.LiveItemChangeSignal) new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class).apply(liveCommonAbstractSignal.payload);
                        TKAdLiveViewImpl.this.handleLiveRoomSignalMessage(liveItemChangeSignal2.itemInfo[0], liveItemChangeSignal2);
                        return;
                    } catch (InvalidProtocolBufferNanoException e) {
                        Log.d(TKAdLiveViewImpl.TAG, "parse live item error");
                        e.printStackTrace();
                        return;
                    }
                }
                if (messageNano instanceof SCLiveConditionRedPackInfo) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                    Log.d(TKAdLiveViewImpl.TAG, "receive redPackInfo message:" + ((SCLiveConditionRedPackInfo) messageNano));
                    return;
                }
                if (messageNano instanceof LiveTreasureBoxMessage.SCLiveTreasureBoxShow) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                    Log.d(TKAdLiveViewImpl.TAG, "receive liveTreasureBoxShow message:" + ((LiveTreasureBoxMessage.SCLiveTreasureBoxShow) messageNano));
                }
            }
        };
        initView(context);
    }

    public TKAdLiveViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandleAdLiveMessageListeners = new ArrayList();
        this.mHandleAdLiveShopInfoListeners = new ArrayList();
        this.mLiveMessageListener = new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.TKAdLiveViewImpl.1
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
                super.onFeedReceived(sCFeedPush);
                for (LiveMessage liveMessage : LiveMessageCovert.fromLiveMessage(sCFeedPush)) {
                    Iterator it = TKAdLiveViewImpl.this.mHandleAdLiveMessageListeners.iterator();
                    while (it.hasNext()) {
                        ((KsAdLiveMessageListener) it.next()).addLiveMessageData(liveMessage);
                    }
                }
            }
        };
        this.mSCMessageListener = new SCMessageListener() { // from class: com.kwad.sdk.TKAdLiveViewImpl.2
            @Override // com.yxcorp.livestream.longconnection.SCMessageListener
            public void onMessageReceived(MessageNano messageNano) {
                Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message" + messageNano.toString());
                if (messageNano instanceof SCActionSignal) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal");
                    for (LiveShopMessages.LiveShopAction liveShopAction : ((SCActionSignal) messageNano).shopAction) {
                        MessageNanoParser messageNanoParser = new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class);
                        Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal payloadType:" + liveShopAction.action.payloadType);
                        if (TKAdLiveViewImpl.ACTION_SALE_ITEM_CHANGE.equals(liveShopAction.action.payloadType)) {
                            try {
                                LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal = (LiveRoomSignalMessage.LiveItemChangeSignal) messageNanoParser.apply(liveShopAction.action.payload);
                                LiveRoomSignalMessage.ItemInfo itemInfo = liveItemChangeSignal.itemInfo[0];
                                Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCActionSignal changeType: " + liveItemChangeSignal.changeType);
                                TKAdLiveViewImpl.this.handleLiveRoomSignalMessage(itemInfo, liveItemChangeSignal);
                            } catch (Throwable th) {
                                Log.d(TKAdLiveViewImpl.TAG, "parse live item error");
                                th.printStackTrace();
                            }
                        }
                    }
                    return;
                }
                if (messageNano instanceof LiveShopMessages.SCLiveShopState) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                    LiveShopMessages.SCLiveShopState sCLiveShopState = (LiveShopMessages.SCLiveShopState) messageNano;
                    Log.d(TKAdLiveViewImpl.TAG, "receive LiveItemChangeSignal message:" + sCLiveShopState);
                    LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = sCLiveShopState.state;
                    if (liveCommonAbstractSignal == null || liveCommonAbstractSignal.payloadType == null || !TKAdLiveViewImpl.this.isIntroducingItemChangePayload(liveCommonAbstractSignal.payloadType)) {
                        return;
                    }
                    try {
                        LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal2 = (LiveRoomSignalMessage.LiveItemChangeSignal) new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class).apply(liveCommonAbstractSignal.payload);
                        TKAdLiveViewImpl.this.handleLiveRoomSignalMessage(liveItemChangeSignal2.itemInfo[0], liveItemChangeSignal2);
                        return;
                    } catch (InvalidProtocolBufferNanoException e) {
                        Log.d(TKAdLiveViewImpl.TAG, "parse live item error");
                        e.printStackTrace();
                        return;
                    }
                }
                if (messageNano instanceof SCLiveConditionRedPackInfo) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                    Log.d(TKAdLiveViewImpl.TAG, "receive redPackInfo message:" + ((SCLiveConditionRedPackInfo) messageNano));
                    return;
                }
                if (messageNano instanceof LiveTreasureBoxMessage.SCLiveTreasureBoxShow) {
                    Log.d(TKAdLiveViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                    Log.d(TKAdLiveViewImpl.TAG, "receive liveTreasureBoxShow message:" + ((LiveTreasureBoxMessage.SCLiveTreasureBoxShow) messageNano));
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        this.mLayout = new RcFrameLayout(context);
        this.mLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.mTextureView = new KSLiveTextureView(context);
        this.mLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.mLayout.addView(this.mTextureView);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public View getView() {
        return this.mLayout;
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public TextureView getTextureView() {
        return this.mTextureView;
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void onDestroy() {
        this.mHandleAdLiveShopInfoListeners.clear();
        this.mHandleAdLiveMessageListeners.clear();
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerKsAdLiveMessageListener(KsAdLiveMessageListener ksAdLiveMessageListener) {
        this.mHandleAdLiveMessageListeners.add(ksAdLiveMessageListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterKsAdLiveMessageListener(KsAdLiveMessageListener ksAdLiveMessageListener) {
        this.mHandleAdLiveMessageListeners.remove(ksAdLiveMessageListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerAdLiveShopInfoListener(AdLiveShopInfoListener adLiveShopInfoListener) {
        this.mHandleAdLiveShopInfoListeners.add(adLiveShopInfoListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterAdLiveShopInfoListener(AdLiveShopInfoListener adLiveShopInfoListener) {
        this.mHandleAdLiveShopInfoListeners.remove(adLiveShopInfoListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLiveRoomSignalMessage(LiveRoomSignalMessage.ItemInfo itemInfo, LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal) {
        KSAdLiveShopInfo kSAdLiveShopInfo = new KSAdLiveShopInfo();
        KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo = new KSAdLiveRoomItemInfo();
        int i = liveItemChangeSignal.changeType;
        if (i == 0) {
            Log.d(TAG, "live item ON_SALE");
            kSAdLiveShopInfo.shopCardType = 2;
            kSAdLiveShopInfo.changeType = 0;
            kSAdLiveRoomItemInfo.itemId = itemInfo.itemId;
            kSAdLiveRoomItemInfo.title = itemInfo.title;
            kSAdLiveRoomItemInfo.imageUrl = itemInfo.imageUrl[0].url;
            kSAdLiveRoomItemInfo.price = itemInfo.price;
            kSAdLiveShopInfo.itemInfo = kSAdLiveRoomItemInfo;
            Iterator<AdLiveShopInfoListener> it = this.mHandleAdLiveShopInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().addKSAdLiveShopInfo(kSAdLiveShopInfo);
            }
            return;
        }
        if (i == 1) {
            kSAdLiveShopInfo.shopCardType = 2;
            kSAdLiveShopInfo.changeType = 1;
            Iterator<AdLiveShopInfoListener> it2 = this.mHandleAdLiveShopInfoListeners.iterator();
            while (it2.hasNext()) {
                it2.next().addKSAdLiveShopInfo(kSAdLiveShopInfo);
            }
            Log.d(TAG, "live item off sale");
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            kSAdLiveShopInfo.shopCardType = 1;
            kSAdLiveShopInfo.changeType = 3;
            Iterator<AdLiveShopInfoListener> it3 = this.mHandleAdLiveShopInfoListeners.iterator();
            while (it3.hasNext()) {
                it3.next().addKSAdLiveShopInfo(kSAdLiveShopInfo);
            }
            Log.d(TAG, "live item stop record" + itemInfo.itemId);
            return;
        }
        Log.d(TAG, "live item start record" + itemInfo.itemId);
        kSAdLiveShopInfo.shopCardType = 1;
        kSAdLiveShopInfo.changeType = 2;
        kSAdLiveRoomItemInfo.itemId = itemInfo.itemId;
        kSAdLiveRoomItemInfo.title = itemInfo.title;
        kSAdLiveRoomItemInfo.imageUrl = itemInfo.imageUrl[0].url;
        kSAdLiveRoomItemInfo.price = itemInfo.price;
        kSAdLiveShopInfo.itemInfo = kSAdLiveRoomItemInfo;
        Iterator<AdLiveShopInfoListener> it4 = this.mHandleAdLiveShopInfoListeners.iterator();
        while (it4.hasNext()) {
            it4.next().addKSAdLiveShopInfo(kSAdLiveShopInfo);
        }
    }

    public LiveMessageListener getLiveMessageListener() {
        return this.mLiveMessageListener;
    }

    public SCMessageListener getSCMessageListener() {
        return this.mSCMessageListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isIntroducingItemChangePayload(String str) {
        return STATE_START_INTERPRETATION.equals(str) || STATE_STOP_INTERPRETATION.equals(str) || INTERPRETATION_CHANGE_PRICE.equals(str);
    }
}
