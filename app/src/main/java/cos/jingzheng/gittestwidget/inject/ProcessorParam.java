package cos.jingzheng.gittestwidget.inject;

/**
 * @author Created by zhengjing on 2019-06-14.
 */

public @interface ProcessorParam {

    String name() default "undefined";

    String text() default "";
}
