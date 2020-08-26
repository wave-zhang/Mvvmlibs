package com.wave.mvvm.lbs.utils;

import androidx.fragment.app.Fragment;
import com.wave.mvvm.lbs.ann.Layout;

import java.lang.annotation.Annotation;

public class AnnUtils {

    public static Layout layout(Fragment fragment){
        Annotation annotation = fragment.getClass().getAnnotation(Layout.class);
        if(annotation == null){
            return null;
        }
        if(annotation instanceof Layout){
            return (Layout) annotation;
        }
        return null;
    }
}
