package com.nhn.pinpoint.plugin.arcus.interceptor;

import com.nhn.pinpoint.bootstrap.interceptor.SimpleAfterInterceptor;
import com.nhn.pinpoint.bootstrap.logging.PLogger;
import com.nhn.pinpoint.bootstrap.logging.PLoggerFactory;
import com.nhn.pinpoint.plugin.arcus.accessor.ServiceCodeAccessor;

/**
 * 
 * @author netspider
 * @author emeroad
 */
public class CacheManagerConstructInterceptor implements SimpleAfterInterceptor {

	private final PLogger logger = PLoggerFactory.getLogger(this.getClass());
    private final boolean isDebug = logger.isDebugEnabled();

	@Override
	public void after(Object target, Object[] args, Object result, Throwable throwable) {
		if (isDebug) {
            logger.afterInterceptor(target, args, result, throwable);
		}
		
		((ServiceCodeAccessor)target).__setServiceCode((String) args[1]);
	}
}