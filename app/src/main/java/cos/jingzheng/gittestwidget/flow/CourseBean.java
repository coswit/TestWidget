package cos.jingzheng.gittestwidget.flow;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Created by zhengjing on 2018/11/21.
 */
@Getter @Setter
public class CourseBean {
    private Long id;
    private String itemName;
    private Long parentId;
    private boolean checked;
}
