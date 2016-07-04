package com.github.vimcmd.javaFundamentals.p01_basics.ch06_interfacesAndAnnotations.sub03_annotations.basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// # 22 # create "proxy-instance" with included SecurityLogic functionality

public class SecurityFactory {

    public static AccountOperationManager createSecurityObject(AccountOperationManager targetObject) {
        return (AccountOperationManager) Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                new SecurityInvocationHandler(targetObject)
        );
    }

    private static class SecurityInvocationHandler implements InvocationHandler {

        private Object targetObject = null;

        public SecurityInvocationHandler(Object targetObject) {
            this.targetObject = targetObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            SecurityLogic logic = new SecurityLogic();
            Method realMethod = targetObject.getClass().getMethod(
                    method.getName(),
                    (Class[]) method.getGenericParameterTypes()
            );
            BankingAnnotation annotation = realMethod.getAnnotation(BankingAnnotation.class);

            if (annotation != null) {
                // annotation and arguments are available
                logic.onInvoke(annotation.securityLevel(), realMethod, args);
                try {
                    return method.invoke(targetObject, args);
                } catch (InvocationTargetException e) {
                    System.out.println(annotation.securityLevel());
                    throw e.getCause();
                }
            } else {
                // in case if annotating method is necessarily, and annotation not present,
                // exception must be thrown:
                // throw new InvocationTargetException(null, "method " + realMethod + " shoul be annotated");
                // ----
                // in case if method annotation not necessarily
                return null;
            }


        }
    }

}
