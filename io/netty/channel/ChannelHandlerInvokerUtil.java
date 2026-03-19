package io.netty.channel;

import io.netty.channel.AbstractChannel;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ChannelHandlerInvokerUtil {
    public static void invokeChannelRegisteredNow(ChannelHandlerContext channelHandlerContext) {
        try {
            ((ChannelInboundHandler) channelHandlerContext.handler()).channelRegistered(channelHandlerContext);
        } catch (Throwable th) {
            notifyHandlerException(channelHandlerContext, th);
        }
    }

    public static void invokeChannelUnregisteredNow(ChannelHandlerContext channelHandlerContext) {
        try {
            ((ChannelInboundHandler) channelHandlerContext.handler()).channelUnregistered(channelHandlerContext);
        } catch (Throwable th) {
            notifyHandlerException(channelHandlerContext, th);
        }
    }

    public static void invokeChannelActiveNow(ChannelHandlerContext channelHandlerContext) {
        try {
            ((ChannelInboundHandler) channelHandlerContext.handler()).channelActive(channelHandlerContext);
        } catch (Throwable th) {
            notifyHandlerException(channelHandlerContext, th);
        }
    }

    public static void invokeChannelInactiveNow(ChannelHandlerContext channelHandlerContext) {
        try {
            ((ChannelInboundHandler) channelHandlerContext.handler()).channelInactive(channelHandlerContext);
        } catch (Throwable th) {
            notifyHandlerException(channelHandlerContext, th);
        }
    }

    public static void invokeExceptionCaughtNow(ChannelHandlerContext channelHandlerContext, Throwable th) {
        try {
            channelHandlerContext.handler().exceptionCaught(channelHandlerContext, th);
        } catch (Throwable th2) {
            if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                DefaultChannelPipeline.logger.warn("An exception was thrown by a user handler's exceptionCaught() method:", th2);
                DefaultChannelPipeline.logger.warn(".. and the cause of the exceptionCaught() was:", th);
            }
        }
    }

    public static void invokeUserEventTriggeredNow(ChannelHandlerContext channelHandlerContext, Object obj) {
        try {
            ((ChannelInboundHandler) channelHandlerContext.handler()).userEventTriggered(channelHandlerContext, obj);
        } catch (Throwable th) {
            notifyHandlerException(channelHandlerContext, th);
        }
    }

    public static void invokeChannelReadNow(ChannelHandlerContext channelHandlerContext, Object obj) {
        try {
            ((ChannelInboundHandler) channelHandlerContext.handler()).channelRead(channelHandlerContext, obj);
        } catch (Throwable th) {
            notifyHandlerException(channelHandlerContext, th);
        }
    }

    public static void invokeChannelReadCompleteNow(ChannelHandlerContext channelHandlerContext) {
        try {
            ((ChannelInboundHandler) channelHandlerContext.handler()).channelReadComplete(channelHandlerContext);
        } catch (Throwable th) {
            notifyHandlerException(channelHandlerContext, th);
        }
    }

    public static void invokeChannelWritabilityChangedNow(ChannelHandlerContext channelHandlerContext) {
        try {
            ((ChannelInboundHandler) channelHandlerContext.handler()).channelWritabilityChanged(channelHandlerContext);
        } catch (Throwable th) {
            notifyHandlerException(channelHandlerContext, th);
        }
    }

    public static void invokeBindNow(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) {
        try {
            ((ChannelOutboundHandler) channelHandlerContext.handler()).bind(channelHandlerContext, socketAddress, channelPromise);
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    public static void invokeConnectNow(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        try {
            ((ChannelOutboundHandler) channelHandlerContext.handler()).connect(channelHandlerContext, socketAddress, socketAddress2, channelPromise);
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    public static void invokeDisconnectNow(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        try {
            ((ChannelOutboundHandler) channelHandlerContext.handler()).disconnect(channelHandlerContext, channelPromise);
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    public static void invokeCloseNow(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        try {
            ((ChannelOutboundHandler) channelHandlerContext.handler()).close(channelHandlerContext, channelPromise);
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    public static void invokeDeregisterNow(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        try {
            ((ChannelOutboundHandler) channelHandlerContext.handler()).deregister(channelHandlerContext, channelPromise);
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    public static void invokeReadNow(ChannelHandlerContext channelHandlerContext) {
        try {
            ((ChannelOutboundHandler) channelHandlerContext.handler()).read(channelHandlerContext);
        } catch (Throwable th) {
            notifyHandlerException(channelHandlerContext, th);
        }
    }

    public static void invokeWriteNow(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        try {
            ((ChannelOutboundHandler) channelHandlerContext.handler()).write(channelHandlerContext, obj, channelPromise);
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    public static void invokeFlushNow(ChannelHandlerContext channelHandlerContext) {
        try {
            ((ChannelOutboundHandler) channelHandlerContext.handler()).flush(channelHandlerContext);
        } catch (Throwable th) {
            notifyHandlerException(channelHandlerContext, th);
        }
    }

    public static boolean validatePromise(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise, boolean z) {
        if (channelHandlerContext == null) {
            throw new NullPointerException("ctx");
        }
        if (channelPromise == null) {
            throw new NullPointerException("promise");
        }
        if (channelPromise.isDone()) {
            if (channelPromise.isCancelled()) {
                return false;
            }
            throw new IllegalArgumentException("promise already done: " + channelPromise);
        }
        if (channelPromise.channel() != channelHandlerContext.channel()) {
            throw new IllegalArgumentException(String.format("promise.channel does not match: %s (expected: %s)", channelPromise.channel(), channelHandlerContext.channel()));
        }
        if (channelPromise.getClass() == DefaultChannelPromise.class) {
            return true;
        }
        if (!z && (channelPromise instanceof VoidChannelPromise)) {
            throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) VoidChannelPromise.class) + " not allowed for this operation");
        }
        if (!(channelPromise instanceof AbstractChannel.CloseFuture)) {
            return true;
        }
        throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) AbstractChannel.CloseFuture.class) + " not allowed in a pipeline");
    }

    private static void notifyHandlerException(ChannelHandlerContext channelHandlerContext, Throwable th) {
        if (inExceptionCaught(th)) {
            if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                DefaultChannelPipeline.logger.warn("An exception was thrown by a user handler while handling an exceptionCaught event", th);
                return;
            }
            return;
        }
        invokeExceptionCaughtNow(channelHandlerContext, th);
    }

    private static void notifyOutboundHandlerException(Throwable th, ChannelPromise channelPromise) {
        if (channelPromise.tryFailure(th) || (channelPromise instanceof VoidChannelPromise) || !DefaultChannelPipeline.logger.isWarnEnabled()) {
            return;
        }
        DefaultChannelPipeline.logger.warn("Failed to fail the promise because it's done already: {}", channelPromise, th);
    }

    private static boolean inExceptionCaught(Throwable th) {
        do {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement == null) {
                        break;
                    }
                    if ("exceptionCaught".equals(stackTraceElement.getMethodName())) {
                        return true;
                    }
                }
            }
            th = th.getCause();
        } while (th != null);
        return false;
    }

    private ChannelHandlerInvokerUtil() {
    }
}
