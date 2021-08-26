package com.nixsolutions.configure.invoker;

public interface ObjectInvoker {

    <I> void invoke(Class<I> type, I i);
}
