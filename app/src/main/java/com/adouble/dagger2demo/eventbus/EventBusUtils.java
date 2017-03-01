package com.adouble.dagger2demo.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by double on 2017/1/7.
 */

public class EventBusUtils {

    public static void register(Object object){
        EventBus.getDefault().register(object);
    }

    public static void unregister(Object object){
        EventBus.getDefault().unregister(object);
    }

    // send event
    public static void sendXXXEvent(Object object){
        EventBus.getDefault().post(object);
    }


}
