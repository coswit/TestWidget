package cos.jingzheng.gittestwidget.inject;

import android.app.Activity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import cos.bind.BindingSuffix;

/**
 * @author Created by zhengjing on 2019-06-18.
 */
public class Binding {
    public static <T extends Activity> void bind(T target){

        Class<?> clazz = target.getClass();
        String className = clazz.getName();

        try {
            Class<?> bindClass = clazz.getClassLoader()
                    .loadClass(className + BindingSuffix.GENERATED_CLASS_SUFFIX);
            Constructor<?> constructor = bindClass.getConstructor(clazz);
            constructor.newInstance(target);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
