package com.jesse.lifecyclemvp;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * $desc$
 *
 * @author wuzhao
 * @Date 2018/1/18
 * @mail： wuzhao@in66.com
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatePresenter {
    Class<? extends BaseMvpPresenter> value();
}
