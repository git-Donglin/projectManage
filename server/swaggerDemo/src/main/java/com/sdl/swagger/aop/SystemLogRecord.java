package com.sdl.swagger.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 系统日志标志
 * 
 * @author ranran.ye
 * @date 2018年3月26日
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface SystemLogRecord {

	String operational();

	String type();

	String[] ignore() default {};

}
