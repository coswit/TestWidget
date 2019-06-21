package cos.jingzheng.gittestwidget.dagger;

import dagger.Component;

/**
 * @author Created by zhengjing on 2019-06-21.
 */

@Component(modules = DripCoffeeModule.class)
public interface CoffeeShop {
    CoffeeMaker maker();
}
