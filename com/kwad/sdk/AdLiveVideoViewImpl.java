package com.kwad.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.protobuf.nano.MessageNano;
import com.kuaishou.livestream.message.nano.LiveExtraMessages;
import com.kuaishou.livestream.message.nano.LiveShopMessages;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kuaishou.livestream.message.nano.SCActionSignal;
import com.kuaishou.merchant.message.nano.LiveRoomSignalMessage;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopInfoListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.listener.KsAdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.sdk.live.R;
import com.kwad.sdk.message.LiveMessageCovert;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.MessageNanoParser;
import com.yxcorp.livestream.longconnection.SCMessageListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AdLiveVideoViewImpl extends RelativeLayout implements View.OnClickListener, IAdLiveOfflineView {
    private static final String ACTION_SALE_ITEM_CHANGE = "liveOnSaleItemChange";
    private static final String INTERPRETATION_CHANGE_PRICE = "liveRecordItemInfoChange";
    private static final String STATE_START_INTERPRETATION = "liveItemStartRecord";
    private static final String STATE_STOP_INTERPRETATION = "liveItemStopRecord";
    private static final String TAG = "AdLiveVideoViewImpl";
    private final List<AdLiveMessageListener> mAdLiveMessageListeners;
    private final List<AdLiveShopListener> mAdLiveShopListeners;
    private final List<AdLiveHandleClickListener> mHandleClickListeners;
    private LiveMessageListener mLiveMessageListener;
    private SCMessageListener mSCMessageListener;
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
    public void unRegisterAdLiveShopInfoListener(AdLiveShopInfoListener adLiveShopInfoListener) {
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterKsAdLiveMessageListener(KsAdLiveMessageListener ksAdLiveMessageListener) {
    }

    public AdLiveVideoViewImpl(Context context) {
        super(context);
        this.mHandleClickListeners = new ArrayList();
        this.mAdLiveMessageListeners = new ArrayList();
        this.mAdLiveShopListeners = new ArrayList();
        this.mLiveMessageListener = new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.AdLiveVideoViewImpl.1
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
                super.onFeedReceived(sCFeedPush);
                Log.d(AdLiveVideoViewImpl.TAG, "receive onFeedReceived message SCFeedPush");
                List<AdLiveMessageInfo> listCreateSortedLiveMessage = LiveMessageCovert.createSortedLiveMessage(sCFeedPush);
                Iterator it = AdLiveVideoViewImpl.this.mAdLiveMessageListeners.iterator();
                while (it.hasNext()) {
                    ((AdLiveMessageListener) it.next()).handleAdLiveMessage(listCreateSortedLiveMessage);
                }
            }
        };
        this.mSCMessageListener = new SCMessageListener() { // from class: com.kwad.sdk.AdLiveVideoViewImpl.2
            @Override // com.yxcorp.livestream.longconnection.SCMessageListener
            public void onMessageReceived(MessageNano messageNano) {
                Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message");
                try {
                    if (messageNano instanceof SCActionSignal) {
                        Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSignal");
                        for (LiveShopMessages.LiveShopAction liveShopAction : ((SCActionSignal) messageNano).shopAction) {
                            MessageNanoParser messageNanoParser = new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class);
                            Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSignal payloadType:" + liveShopAction.action.payloadType);
                            if (AdLiveVideoViewImpl.ACTION_SALE_ITEM_CHANGE.equals(liveShopAction.action.payloadType)) {
                                LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal = (LiveRoomSignalMessage.LiveItemChangeSignal) messageNanoParser.apply(liveShopAction.action.payload);
                                LiveRoomSignalMessage.ItemInfo itemInfo = liveItemChangeSignal.itemInfo[0];
                                Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSignal changeType: " + liveItemChangeSignal.changeType);
                                int i = liveItemChangeSignal.changeType;
                                if (i == 0) {
                                    Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSigna l itemInfo :" + itemInfo.toString());
                                } else if (i == 1) {
                                    Log.d(AdLiveVideoViewImpl.TAG, "live item off sale");
                                }
                            }
                        }
                        return;
                    }
                    if (messageNano instanceof LiveShopMessages.SCLiveShopState) {
                        Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                        LiveShopMessages.SCLiveShopState sCLiveShopState = (LiveShopMessages.SCLiveShopState) messageNano;
                        Log.d(AdLiveVideoViewImpl.TAG, "receive LiveItemChangeSignal message:" + sCLiveShopState);
                        LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = sCLiveShopState.state;
                        if (liveCommonAbstractSignal == null || liveCommonAbstractSignal.payloadType == null || !AdLiveVideoViewImpl.this.isIntroducingItemChangePayload(liveCommonAbstractSignal.payloadType)) {
                            return;
                        }
                        LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal2 = (LiveRoomSignalMessage.LiveItemChangeSignal) new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class).apply(liveCommonAbstractSignal.payload);
                        LiveRoomSignalMessage.ItemInfo itemInfo2 = liveItemChangeSignal2.itemInfo[0];
                        int i2 = liveItemChangeSignal2.changeType;
                        if (i2 == 2) {
                            AdLiveVideoViewImpl.this.responseAdShopInfo(2, itemInfo2.title, itemInfo2.imageUrl[0].url, itemInfo2.price);
                        } else {
                            if (i2 != 3) {
                                return;
                            }
                            AdLiveVideoViewImpl.this.responseAdShopInfo(3, itemInfo2.title, itemInfo2.imageUrl[0].url, itemInfo2.price);
                            Log.d(AdLiveVideoViewImpl.TAG, "live item stop record" + itemInfo2.itemId);
                        }
                    }
                } catch (Throwable th) {
                    Log.d(AdLiveVideoViewImpl.TAG, "parse live item error");
                    th.printStackTrace();
                }
            }
        };
        initView();
    }

    public AdLiveVideoViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandleClickListeners = new ArrayList();
        this.mAdLiveMessageListeners = new ArrayList();
        this.mAdLiveShopListeners = new ArrayList();
        this.mLiveMessageListener = new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.AdLiveVideoViewImpl.1
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
                super.onFeedReceived(sCFeedPush);
                Log.d(AdLiveVideoViewImpl.TAG, "receive onFeedReceived message SCFeedPush");
                List<AdLiveMessageInfo> listCreateSortedLiveMessage = LiveMessageCovert.createSortedLiveMessage(sCFeedPush);
                Iterator it = AdLiveVideoViewImpl.this.mAdLiveMessageListeners.iterator();
                while (it.hasNext()) {
                    ((AdLiveMessageListener) it.next()).handleAdLiveMessage(listCreateSortedLiveMessage);
                }
            }
        };
        this.mSCMessageListener = new SCMessageListener() { // from class: com.kwad.sdk.AdLiveVideoViewImpl.2
            @Override // com.yxcorp.livestream.longconnection.SCMessageListener
            public void onMessageReceived(MessageNano messageNano) {
                Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message");
                try {
                    if (messageNano instanceof SCActionSignal) {
                        Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSignal");
                        for (LiveShopMessages.LiveShopAction liveShopAction : ((SCActionSignal) messageNano).shopAction) {
                            MessageNanoParser messageNanoParser = new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class);
                            Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSignal payloadType:" + liveShopAction.action.payloadType);
                            if (AdLiveVideoViewImpl.ACTION_SALE_ITEM_CHANGE.equals(liveShopAction.action.payloadType)) {
                                LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal = (LiveRoomSignalMessage.LiveItemChangeSignal) messageNanoParser.apply(liveShopAction.action.payload);
                                LiveRoomSignalMessage.ItemInfo itemInfo = liveItemChangeSignal.itemInfo[0];
                                Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSignal changeType: " + liveItemChangeSignal.changeType);
                                int i = liveItemChangeSignal.changeType;
                                if (i == 0) {
                                    Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSigna l itemInfo :" + itemInfo.toString());
                                } else if (i == 1) {
                                    Log.d(AdLiveVideoViewImpl.TAG, "live item off sale");
                                }
                            }
                        }
                        return;
                    }
                    if (messageNano instanceof LiveShopMessages.SCLiveShopState) {
                        Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                        LiveShopMessages.SCLiveShopState sCLiveShopState = (LiveShopMessages.SCLiveShopState) messageNano;
                        Log.d(AdLiveVideoViewImpl.TAG, "receive LiveItemChangeSignal message:" + sCLiveShopState);
                        LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = sCLiveShopState.state;
                        if (liveCommonAbstractSignal == null || liveCommonAbstractSignal.payloadType == null || !AdLiveVideoViewImpl.this.isIntroducingItemChangePayload(liveCommonAbstractSignal.payloadType)) {
                            return;
                        }
                        LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal2 = (LiveRoomSignalMessage.LiveItemChangeSignal) new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class).apply(liveCommonAbstractSignal.payload);
                        LiveRoomSignalMessage.ItemInfo itemInfo2 = liveItemChangeSignal2.itemInfo[0];
                        int i2 = liveItemChangeSignal2.changeType;
                        if (i2 == 2) {
                            AdLiveVideoViewImpl.this.responseAdShopInfo(2, itemInfo2.title, itemInfo2.imageUrl[0].url, itemInfo2.price);
                        } else {
                            if (i2 != 3) {
                                return;
                            }
                            AdLiveVideoViewImpl.this.responseAdShopInfo(3, itemInfo2.title, itemInfo2.imageUrl[0].url, itemInfo2.price);
                            Log.d(AdLiveVideoViewImpl.TAG, "live item stop record" + itemInfo2.itemId);
                        }
                    }
                } catch (Throwable th) {
                    Log.d(AdLiveVideoViewImpl.TAG, "parse live item error");
                    th.printStackTrace();
                }
            }
        };
        initView();
    }

    public AdLiveVideoViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandleClickListeners = new ArrayList();
        this.mAdLiveMessageListeners = new ArrayList();
        this.mAdLiveShopListeners = new ArrayList();
        this.mLiveMessageListener = new LiveMessageListener.SimpleLiveMessageListener() { // from class: com.kwad.sdk.AdLiveVideoViewImpl.1
            @Override // com.yxcorp.livestream.longconnection.LiveMessageListener.SimpleLiveMessageListener, com.yxcorp.livestream.longconnection.LiveMessageListener
            public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
                super.onFeedReceived(sCFeedPush);
                Log.d(AdLiveVideoViewImpl.TAG, "receive onFeedReceived message SCFeedPush");
                List<AdLiveMessageInfo> listCreateSortedLiveMessage = LiveMessageCovert.createSortedLiveMessage(sCFeedPush);
                Iterator it = AdLiveVideoViewImpl.this.mAdLiveMessageListeners.iterator();
                while (it.hasNext()) {
                    ((AdLiveMessageListener) it.next()).handleAdLiveMessage(listCreateSortedLiveMessage);
                }
            }
        };
        this.mSCMessageListener = new SCMessageListener() { // from class: com.kwad.sdk.AdLiveVideoViewImpl.2
            @Override // com.yxcorp.livestream.longconnection.SCMessageListener
            public void onMessageReceived(MessageNano messageNano) {
                Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message");
                try {
                    if (messageNano instanceof SCActionSignal) {
                        Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSignal");
                        for (LiveShopMessages.LiveShopAction liveShopAction : ((SCActionSignal) messageNano).shopAction) {
                            MessageNanoParser messageNanoParser = new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class);
                            Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSignal payloadType:" + liveShopAction.action.payloadType);
                            if (AdLiveVideoViewImpl.ACTION_SALE_ITEM_CHANGE.equals(liveShopAction.action.payloadType)) {
                                LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal = (LiveRoomSignalMessage.LiveItemChangeSignal) messageNanoParser.apply(liveShopAction.action.payload);
                                LiveRoomSignalMessage.ItemInfo itemInfo = liveItemChangeSignal.itemInfo[0];
                                Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSignal changeType: " + liveItemChangeSignal.changeType);
                                int i2 = liveItemChangeSignal.changeType;
                                if (i2 == 0) {
                                    Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCActionSigna l itemInfo :" + itemInfo.toString());
                                } else if (i2 == 1) {
                                    Log.d(AdLiveVideoViewImpl.TAG, "live item off sale");
                                }
                            }
                        }
                        return;
                    }
                    if (messageNano instanceof LiveShopMessages.SCLiveShopState) {
                        Log.d(AdLiveVideoViewImpl.TAG, "receive onMessageReceived message SCLiveShopState");
                        LiveShopMessages.SCLiveShopState sCLiveShopState = (LiveShopMessages.SCLiveShopState) messageNano;
                        Log.d(AdLiveVideoViewImpl.TAG, "receive LiveItemChangeSignal message:" + sCLiveShopState);
                        LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = sCLiveShopState.state;
                        if (liveCommonAbstractSignal == null || liveCommonAbstractSignal.payloadType == null || !AdLiveVideoViewImpl.this.isIntroducingItemChangePayload(liveCommonAbstractSignal.payloadType)) {
                            return;
                        }
                        LiveRoomSignalMessage.LiveItemChangeSignal liveItemChangeSignal2 = (LiveRoomSignalMessage.LiveItemChangeSignal) new MessageNanoParser(LiveRoomSignalMessage.LiveItemChangeSignal.class).apply(liveCommonAbstractSignal.payload);
                        LiveRoomSignalMessage.ItemInfo itemInfo2 = liveItemChangeSignal2.itemInfo[0];
                        int i22 = liveItemChangeSignal2.changeType;
                        if (i22 == 2) {
                            AdLiveVideoViewImpl.this.responseAdShopInfo(2, itemInfo2.title, itemInfo2.imageUrl[0].url, itemInfo2.price);
                        } else {
                            if (i22 != 3) {
                                return;
                            }
                            AdLiveVideoViewImpl.this.responseAdShopInfo(3, itemInfo2.title, itemInfo2.imageUrl[0].url, itemInfo2.price);
                            Log.d(AdLiveVideoViewImpl.TAG, "live item stop record" + itemInfo2.itemId);
                        }
                    }
                } catch (Throwable th) {
                    Log.d(AdLiveVideoViewImpl.TAG, "parse live item error");
                    th.printStackTrace();
                }
            }
        };
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.ksad_live_video_layout, this);
        this.mTextureView = (TextureView) findViewById(R.id.ksad_live_room_texture);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Log.d("TAGGG", "onClick");
        Iterator<AdLiveHandleClickListener> it = this.mHandleClickListeners.iterator();
        while (it.hasNext()) {
            it.next().handleAdLiveClick(1);
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public TextureView getTextureView() {
        return this.mTextureView;
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void onDestroy() {
        this.mHandleClickListeners.clear();
        this.mAdLiveMessageListeners.clear();
        this.mAdLiveShopListeners.clear();
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

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerLiveMessageListener(AdLiveMessageListener adLiveMessageListener) {
        Log.d(TAG, "registerLiveMessageListener: ");
        this.mAdLiveMessageListeners.add(adLiveMessageListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterLiveMessageListener(AdLiveMessageListener adLiveMessageListener) {
        Log.d(TAG, "unRegisterLiveMessageListener: ");
        this.mAdLiveMessageListeners.remove(adLiveMessageListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void registerLiveShopListener(AdLiveShopListener adLiveShopListener) {
        Log.d(TAG, "registerLiveShopListener: ");
        this.mAdLiveShopListeners.add(adLiveShopListener);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView
    public void unRegisterLiveShopListener(AdLiveShopListener adLiveShopListener) {
        Log.d(TAG, "unRegisterLiveShopListener: ");
        this.mAdLiveShopListeners.remove(adLiveShopListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void responseAdShopInfo(int i, String str, String str2, String str3) {
        AdLiveShopInfo adLiveShopInfo = new AdLiveShopInfo();
        adLiveShopInfo.status = i;
        adLiveShopInfo.title = str;
        adLiveShopInfo.url = str2;
        adLiveShopInfo.price = str3;
        Iterator<AdLiveShopListener> it = this.mAdLiveShopListeners.iterator();
        while (it.hasNext()) {
            it.next().handleAdLiveShop(adLiveShopInfo);
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
