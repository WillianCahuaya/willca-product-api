package Interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lombok.extern.jbosslog.JBossLog;

import java.util.Arrays;

@JBossLog
@Interceptor
@ServiceLogged
public class ServiceLoggingInterceptor {

    @AroundInvoke
    Object logService(InvocationContext context) throws Exception {

        String className = context.getMethod().getDeclaringClass().getSimpleName();

        String methodName = context.getMethod().getName();

        Object[] args = context.getParameters();

        log.infof("SERVICE >>> %s.%s | args=%s", className, methodName, Arrays.toString(args));

        return context.proceed();
    }
}
