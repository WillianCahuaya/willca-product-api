package Interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lombok.extern.jbosslog.JBossLog;

import java.util.Arrays;

@JBossLog
@Interceptor
@ResourceLogged
public class ResourceLoggingInterceptor {

    @AroundInvoke
    Object logController(InvocationContext context) throws Exception {

        String className = context.getMethod().getDeclaringClass().getSimpleName();

        String methodName = context.getMethod().getName();

        Object[] args = context.getParameters();

        log.infof("CONTROLLER >>> %s.%s | args=%s", className, methodName, Arrays.toString(args));

        return context.proceed();
    }
}
