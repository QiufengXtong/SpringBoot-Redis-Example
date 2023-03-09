package cn.xtong.example.user.service;

import cn.xtong.example.user.model.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 张晓童
 * @description 针对表【sys_user】的数据库操作Service
 * @createDate 2023-02-10 13:32:02
 */
public interface SysUserService extends IService<SysUser> {

    List<SysUser> list(SysUser sysUser);

    SysUser detail(String id);

    SysUser add(SysUser sysUser);

    SysUser edit(SysUser sysUser);

    void delete(String id);
}