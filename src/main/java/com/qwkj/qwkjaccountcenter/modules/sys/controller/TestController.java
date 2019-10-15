
package com.qwkj.qwkjaccountcenter.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qwkj.qwkjaccountcenter.common.annotation.SysLog;
import com.qwkj.qwkjaccountcenter.common.utils.Constant;
import com.qwkj.qwkjaccountcenter.common.utils.RestResponse;
import com.qwkj.qwkjaccountcenter.common.validator.AbstractAssert;
import com.qwkj.qwkjaccountcenter.common.validator.ValidatorUtils;
import com.qwkj.qwkjaccountcenter.common.validator.group.AddGroup;
import com.qwkj.qwkjaccountcenter.common.validator.group.UpdateGroup;
import com.qwkj.qwkjaccountcenter.modules.sys.entity.SysUserEntity;
import com.qwkj.qwkjaccountcenter.modules.sys.form.PasswordForm;
import com.qwkj.qwkjaccountcenter.modules.sys.service.SysUserRoleService;
import com.qwkj.qwkjaccountcenter.modules.sys.service.SysUserService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author 李鹏军
 */
@RestController
@RequestMapping("/test")
public class TestController extends AbstractController {
    @GetMapping("/hello")
    public RestResponse resetPw() {
        return RestResponse.success();
    }
}
