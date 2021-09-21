/**
 */

package com.arcelormittal.casestudy.logging.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Logging aspect for services. Will log arguments and returned values.
 * 
 * @author Pareek 
 */
@Component
@Aspect
public class ServiceLoggingAspect {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ServiceLoggingAspect.class);

    public ServiceLoggingAspect() {
        super();
    }

    /**
     * Logs the returned value after the method is called.
     * 
     * @param joinPoint
     *            point where the aspect is applied
     * @param returnValue
     *            returned value
     */
    @AfterReturning(
            value = "execution(* com.arcelormittal.casestudy..*Service*.*(..))",
            returning = "returnValue")
    public void afterCall(final JoinPoint joinPoint, final Object returnValue) {
        LOGGER.debug("Called {} and returning {}",
                joinPoint.getSignature().toShortString(), returnValue);
    }

    /**
     * Logs the received arguments before the method is called.
     * 
     * @param joinPoint
     *            point where the aspect is applied
     */
    @Before(value = "execution(* com.arcelormittal.casestudy..*Service*.*(..))",
            argNames = "joinPoint")
    public void beforeCall(final JoinPoint joinPoint) {
        LOGGER.debug("Calling {} with arguments {}",
                joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

}
