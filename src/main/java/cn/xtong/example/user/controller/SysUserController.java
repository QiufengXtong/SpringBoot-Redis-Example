package cn.xtong.example.user.controller;

import cn.xtong.example.user.model.SysUser;
import cn.xtong.example.user.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/user")
@RestController
public class SysUserController {
    @Resource
    private SysUserService service;

    @GetMapping("/list")
    public List<SysUser> list(SysUser sysUser) {
        return service.list(sysUser);
    }

    @GetMapping("/detail")
    public SysUser detail(String id) {
        return service.detail(id);
    }

    @GetMapping("/add")
    public String add(SysUser sysUser) {
        service.add(sysUser);
        return "操作成功";
    }

    @GetMapping("/edit")
    public String edit(SysUser sysUser) {
        service.edit(sysUser);
        return "操作成功";
    }

    @GetMapping("/delete")
    public String delete(String id) {
        service.delete(id);
        return "操作成功";
    }
}
