package com.yxcorp.livestream.longconnection.operation;

import com.kuaishou.common.netty.client.ChannelHandler;
import com.kuaishou.common.netty.client.ConnectionBootstrap;
import com.kuaishou.common.netty.client.ConnectionClient;
import com.kuaishou.common.netty.client.handler.ClientNanoPayloadHandlers;
import com.kuaishou.livestream.message.nano.LiveFansGroupMessages;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kuaishou.socket.nano.SocketMessages;
import com.yxcorp.livestream.longconnection.LiveMessageListener;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import com.yxcorp.livestream.longconnection.LongConnectionContext;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.exception.BootstrapClientException;
import com.yxcorp.livestream.longconnection.exception.ChannelException;
import com.yxcorp.livestream.longconnection.handler.SCErrorHandler;
import com.yxcorp.livestream.longconnection.handler.SCHandler;
import com.yxcorp.livestream.longconnection.handler.SCInfoHandler;
import io.netty.channel.ChannelHandlerContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ConnectOperation implements Runnable {
    private static final String TAG = "ConnectOperation";
    protected final LongConnectionContext mContext;

    public ConnectOperation(LongConnectionContext longConnectionContext) {
        this.mContext = longConnectionContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConnectionBootstrap connectionBootstrap;
        final Throwable th;
        LongConnectionParams longConnectionParams;
        try {
            new DisconnectOperation(this.mContext).run();
            this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.1
                @Override // java.lang.Runnable
                public void run() {
                    LiveMessageListener messageListener = ConnectOperation.this.mContext.getMessageListener();
                    if (messageListener != null) {
                        messageListener.onConnectionStart();
                    }
                }
            });
            longConnectionParams = this.mContext.getLongConnectionParams();
            connectionBootstrap = new ConnectionBootstrap();
        } catch (Throwable th2) {
            connectionBootstrap = null;
            th = th2;
        }
        try {
            LongConnectionParams.ServerUriInfo serverUriInfo = longConnectionParams.getServerUriInfo();
            this.mContext.setCurrentServerUriInfo(serverUriInfo);
            connectionBootstrap.bootstrap();
            ConnectionClient connectionClientConnect = connectionBootstrap.connect(serverUriInfo.getHost(), serverUriInfo.getPort());
            this.mContext.setClient(connectionClientConnect);
            registerPayloadHandlers(connectionClientConnect);
            connectionClientConnect.getChannelHandler().setChannelErrorListener(new ChannelHandler.ChannelErrorListener() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.2
                @Override // com.kuaishou.common.netty.client.ChannelHandler.ChannelErrorListener
                public void onChannelError(final Throwable th3) {
                    ConnectOperation.this.mContext.stopHeartbeat();
                    ConnectOperation.this.mContext.setClient(null);
                    ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            OnConnectionExceptionListener exceptionListener = ConnectOperation.this.mContext.getExceptionListener();
                            if (exceptionListener != null) {
                                exceptionListener.onChannelException(new ChannelException(th3));
                            }
                        }
                    });
                }
            });
            connectionClientConnect.getChannelHandler().setInactiveListener(new ChannelHandler.InactiveListener() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.3
                @Override // com.kuaishou.common.netty.client.ChannelHandler.InactiveListener
                public void onChannelInactive(ChannelHandlerContext channelHandlerContext) {
                    LiveStreamLogger.debugLog(ConnectOperation.TAG, "onChannelInactive", "lastErrorCode", Integer.valueOf(ConnectOperation.this.mContext.getLastErrorCode()));
                    ConnectOperation.this.mContext.stopHeartbeat();
                    ConnectOperation.this.mContext.setClient(null);
                    if (ConnectOperation.this.mContext.getLastErrorCode() == 0) {
                        ConnectOperation.this.mContext.setLastErrorCode(1051);
                        ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LiveMessageListener messageListener = ConnectOperation.this.mContext.getMessageListener();
                                if (messageListener != null) {
                                    messageListener.onConnectionInterrupt();
                                }
                            }
                        });
                    }
                }
            });
            this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.4
                @Override // java.lang.Runnable
                public void run() {
                    LiveMessageListener messageListener = ConnectOperation.this.mContext.getMessageListener();
                    if (messageListener != null) {
                        messageListener.onConnectionEstablished();
                    }
                }
            });
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            if (connectionBootstrap != null) {
                try {
                    connectionBootstrap.shutdownGracefully();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
            this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.5
                @Override // java.lang.Runnable
                public void run() {
                    OnConnectionExceptionListener exceptionListener = ConnectOperation.this.mContext.getExceptionListener();
                    if (exceptionListener != null) {
                        exceptionListener.onClientException(new BootstrapClientException(th));
                    }
                }
            });
        }
    }

    private void registerPayloadHandlers(ConnectionClient connectionClient) {
        ClientNanoPayloadHandlers payloadHandlers = connectionClient.getChannelHandler().getPayloadHandlers();
        payloadHandlers.addHandler(103, new SCErrorHandler(this.mContext));
        payloadHandlers.addHandler(105, new SCInfoHandler(this.mContext));
        payloadHandlers.addHandler(310, new SCHandler<LiveStreamMessages.SCFeedPush>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.6
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCFeedPush sCFeedPush) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onFeedReceived(sCFeedPush);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(301, new SCHandler<LiveStreamMessages.SCAuthorPause>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.7
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCAuthorPause sCAuthorPause) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onAuthorPause(sCAuthorPause);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(302, new SCHandler<LiveStreamMessages.SCAuthorResume>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.8
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCAuthorResume sCAuthorResume) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onAuthorResume(sCAuthorResume);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(311, new SCHandler<LiveStreamMessages.SCAssistantStatus>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.9
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCAssistantStatus sCAssistantStatus) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onAssistantStatusChange(sCAssistantStatus);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(320, new SCHandler<LiveStreamMessages.SCLiveChatCall>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.10
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCLiveChatCall sCLiveChatCall) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onLiveChatCall(sCLiveChatCall);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(323, new SCHandler<LiveStreamMessages.SCLiveChatReady>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.11
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCLiveChatReady sCLiveChatReady) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onLiveChatReady(sCLiveChatReady);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(325, new SCHandler<LiveStreamMessages.SCLiveChatEnded>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.12
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(LiveStreamMessages.SCLiveChatEnded sCLiveChatEnded) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onLiveChatEnded();
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(326, new SCHandler<LiveStreamMessages.SCRenderingMagicFaceDisable>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.13
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(LiveStreamMessages.SCRenderingMagicFaceDisable sCRenderingMagicFaceDisable) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onRenderingMagicFaceDisable();
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(327, new SCHandler<LiveStreamMessages.SCRenderingMagicFaceEnable>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.14
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(LiveStreamMessages.SCRenderingMagicFaceEnable sCRenderingMagicFaceEnable) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onRenderingMagicFaceEnable();
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(340, new SCHandler<LiveStreamMessages.SCLiveWatchingList>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.15
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCLiveWatchingList sCLiveWatchingList) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onFeedReceived(sCLiveWatchingList);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(355, new SCHandler<LiveStreamMessages.SCSuspectedViolation>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.16
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCSuspectedViolation sCSuspectedViolation) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onSuspectedViolationChange(sCSuspectedViolation);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(308, new SCHandler<LiveStreamMessages.SCVoipSignal>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.17
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCVoipSignal sCVoipSignal) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onVoipSignal(sCVoipSignal);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(SocketMessages.PayloadType.SC_WISH_LIST_OPENED, new SCHandler<LiveStreamMessages.SCWishListOpened>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.18
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCWishListOpened sCWishListOpened) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onWishListOpened(sCWishListOpened);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(SocketMessages.PayloadType.SC_WISH_LIST_CLOSED, new SCHandler<LiveStreamMessages.SCWishListClosed>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.19
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCWishListClosed sCWishListClosed) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onWishListClosed(sCWishListClosed);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(521, new SCHandler<LiveStreamMessages.SCLiveFansTopOpened>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.20
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCLiveFansTopOpened sCLiveFansTopOpened) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onFansTopOpen(sCLiveFansTopOpened);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(522, new SCHandler<LiveStreamMessages.SCLiveFansTopClosed>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.21
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCLiveFansTopClosed sCLiveFansTopClosed) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onFansTopClose(sCLiveFansTopClosed);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(587, new SCHandler<LiveStreamMessages.SCLiveDistrictRankInfo>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.22
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCLiveDistrictRankInfo sCLiveDistrictRankInfo) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.22.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onLiveDistrictRankInfoReceived(sCLiveDistrictRankInfo);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(588, new SCHandler<LiveStreamMessages.SCLiveDistrictRankClosed>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.23
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveStreamMessages.SCLiveDistrictRankClosed sCLiveDistrictRankClosed) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onLiveDistrictRankClosed(sCLiveDistrictRankClosed);
                        }
                    }
                });
            }
        });
        payloadHandlers.addHandler(595, new SCHandler<LiveFansGroupMessages.SCLiveFansGroupStatusChanged>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.24
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(final LiveFansGroupMessages.SCLiveFansGroupStatusChanged sCLiveFansGroupStatusChanged) {
                ConnectOperation.this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.ConnectOperation.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConnectOperation.this.mContext.mMessageListener != null) {
                            ConnectOperation.this.mContext.mMessageListener.onLiveFansGroupStatusChanged(sCLiveFansGroupStatusChanged);
                        }
                    }
                });
            }
        });
        this.mContext.registerHandlers();
    }
}
