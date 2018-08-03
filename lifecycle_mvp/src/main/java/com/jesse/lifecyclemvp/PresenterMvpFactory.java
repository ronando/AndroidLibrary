package com.jesse.lifecyclemvp;

/**
 * PresenterMvpFactory presenter factory ,通过注解运行时生成对应presenter
 *
 * @author wuzhao
 * @Date 2018/1/18
 * @mail： wuzhao@in66.com
 */
public class PresenterMvpFactory<V extends BaseMvpView, P extends BaseMvpPresenter<V>> {

    /**
     * 需要创建的Presenter的类型
     */
    private final Class<P> mPresenterClass;


    /**
     * 根据注解创建Presenter的工厂实现类
     *
     * @param viewClazz 需要创建Presenter的V层实现类
     * @param <V>       当前View实现的接口类型
     * @param <P>       当前要创建的Presenter类型
     * @return 工厂类
     */
    public static <V extends BaseMvpView, P extends BaseMvpPresenter<V>> PresenterMvpFactory<V, P> createFactory(Class<?> viewClazz) {
        CreatePresenter annotation = viewClazz.getAnnotation(CreatePresenter.class);
        Class<P> aClass = null;
        if (annotation != null) {
            aClass = (Class<P>) annotation.value();
        }
        return aClass == null ? null : new PresenterMvpFactory<V, P>(aClass);
    }


    private PresenterMvpFactory(Class<P> presenterClass) {
        this.mPresenterClass = presenterClass;
    }

    public P createMvpPresenter() {
        try {
            return mPresenterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter创建失败!检查是否声明了@CreatePresenter(xx.class)注解或没有默认构造器");
        }
    }
}
