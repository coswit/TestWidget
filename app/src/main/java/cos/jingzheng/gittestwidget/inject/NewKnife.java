package cos.jingzheng.gittestwidget.inject;

import android.app.Activity;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author Created by zhengjing on 2019-06-13.
 */
public class NewKnife {

    public static void bind(Activity target){
        Class<? extends Activity> clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();

        bindViews(target,fields,target.getWindow().getDecorView());
//        for (Field field:fields){
//            BindView bindView = field.getAnnotation(BindView.class);
//            if(bindView!=null){
//                int viewId = bindView.value();
//                try {
//                    field.setAccessible(true);
//                    View view = target.getWindow().getDecorView().findViewById(viewId);
//                    //反射获取会失败
//                   // Method findMethod = clazz.getDeclaredMethod("findViewById",int.class);
//                  // Object view = findMethod.invoke(clazz, viewId);
//                    field.set(target,view);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }



    /*
     * initiate the view for the annotated public fields
     * @param obj is any class instance with annotations
     * @param fields list of methods in the class with annotation
     * @param rootView is the inflated view from the XML
     */
    private static void bindViews(final Object obj, Field[] fields, View rootView){
        for(final Field field : fields) {
            Annotation annotation = field.getAnnotation(BindView.class);
            if (annotation != null) {
                BindView bindView = (BindView) annotation;
                int id = bindView.value();
                View view = rootView.findViewById(id);
                try {
                    field.setAccessible(true);
                    field.set(obj, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
