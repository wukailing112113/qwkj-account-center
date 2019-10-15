
package com.qwkj.qwkjaccountcenter.common.aspect;

import com.google.gson.Gson;
import com.qwkj.qwkjaccountcenter.common.annotation.SysLog;
import com.qwkj.qwkjaccountcenter.common.utils.HttpContextUtils;
import com.qwkj.qwkjaccountcenter.common.utils.IpUtils;
import com.qwkj.qwkjaccountcenter.modules.sys.entity.SysLogEntity;
import com.qwkj.qwkjaccountcenter.modules.sys.entity.SysUserEntity;
import com.qwkj.qwkjaccountcenter.modules.sys.service.SysLogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志，切面处理类
 *
 * @author 李鹏军
 */
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.qwkj.qwkjaccountcenter.common.annotation.SysLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveSysLog(point, time);

        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLogEntity sysLog = new SysLogEntity();
        SysLog syslog = method.getAnnotation(SysLog.class);
        if (syslog != null) {
            //注解上的描述
            sysLog.setOperation(syslog.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = new Gson().toJson(args);
            sysLog.setParams(params);

            //获取request
            HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
            //设置IP地址
            sysLog.setIp(IpUtils.getIpAddr(request));

            //用户名
            String userName = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUserName();
            sysLog.setUserName(userName);

            sysLog.setTime(time);
            sysLog.setCreateTime(new Date());
            //保存系统日志
            sysLogService.save(sysLog);
        } catch (Exception ignored) {

        }
    }
}
