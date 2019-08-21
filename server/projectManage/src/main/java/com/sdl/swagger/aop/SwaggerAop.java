/**
 * @author sundonglin
 * @date 2018年12月7日 上午9:55:56
 */
package com.sdl.swagger.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sdl.swagger.entity.Dept;
/**
 * @author sundonglin
 * @date 2018年12月7日 上午9:55:56
 */
@Component
@Aspect
public class SwaggerAop {
	
	
	private static final String SYSTEM_LOG = "@annotation(com.sdl.swagger.aop.SystemLogRecord)";
	
	
	
	@Around(SYSTEM_LOG)
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("前置：123132132");
		Object proceed = proceedingJoinPoint.proceed();
		System.out.println("00000000000000");
		ResponseEntity<List<Dept>> depts = (ResponseEntity<List<Dept>>) proceed;
//		List<Dept> body = depts.getBody();
//		
//		for (Dept dept : body) {
//			System.out.println(dept.getName());
//		}
		System.out.println("后置：" + proceed);
		
		
		//System.out.println(exception.getMessage());
	}
	
	
	@AfterThrowing(value=SYSTEM_LOG, throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		/*String methodName = joinPoint.getSignature().getName();
		System.out.println("异常通知方法 "+methodName+" 发生的异常为 "+ex);*/
		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			
			System.out.println(object);
		}
		System.out.println("异常通知：" + ex.getMessage());
	}
	
	@AfterReturning(value = SYSTEM_LOG, returning="proceed")
	public void afterReturning(JoinPoint joinPoint, Object proceed) throws Throwable{
		ResponseEntity<List<Dept>> depts = (ResponseEntity<List<Dept>>) proceed;
		List<Dept> body = depts.getBody();
		System.out.println(joinPoint.getArgs());
		for (Dept dept : body) {
			System.out.println(dept.getName());
		}
		System.out.println("成功后：" + proceed);
	}
	
}
