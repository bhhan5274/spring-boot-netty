package org.kgusarov.integration.spring.netty.support.resolvers.impl;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.kgusarov.integration.spring.netty.support.resolvers.NettyOnMessageParameterResolver;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;

/**
 * Internal API: resolver for {@link Channel}
 */
@Component
public class ChannelOnMessageResolver implements NettyOnMessageParameterResolver {
    @Override
    public boolean canResolve(final MethodParameter methodParameter) {
        final Class<?> parameterType = methodParameter.getParameterType();
        return Channel.class.isAssignableFrom(parameterType);
    }

    @Override
    public Object resolve(final ChannelHandlerContext ctx, final Object msg) {
        return ctx.channel();
    }
}
