package cn.xtong.example.user.service.impl;

import cn.xtong.example.user.mapper.SysUserMapper;
import cn.xtong.example.user.model.SysUser;
import cn.xtong.example.user.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张晓童
 * @description 针对表【sys_user】的数据库操作Service实现
 * @createDate 2023-02-10 13:32:02
 */
@CacheConfig(cacheNames = "user")
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Cacheable(cacheNames = "userList", key = "#sysUser", unless = "#result == null || #result.size() == 0")
    @Override
    public List<SysUser> list(SysUser sysUser) {
        return this.baseMapper.list(sysUser);
    }

    @Cacheable(key = "#id", unless = "#result == null")
    @Override
    public SysUser detail(String id) {
        return this.baseMapper.selectById(id);
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "userList", allEntries = true)
            },
            put = @CachePut(value = "user", key = "#sysUser.id")
    )
    @Override
    public SysUser add(SysUser sysUser) {
        this.baseMapper.insert(sysUser);
        return sysUser;
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "userList", allEntries = true)
            },
            put = @CachePut(value = "user", key = "#sysUser.id")
    )
    @Override
    public SysUser edit(SysUser sysUser) {
        this.baseMapper.updateById(sysUser);
        return sysUser;
    }

    @Caching(evict = {
            @CacheEvict(value = "userList", allEntries = true),
            @CacheEvict(value = "user", key = "#id")
    })
    @Override
    public void delete(String id) {
        this.baseMapper.deleteById(id);
    }
}




