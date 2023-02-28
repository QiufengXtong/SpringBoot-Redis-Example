package cn.xtong.example.user.mapper;

import cn.xtong.example.user.model.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 张晓童
 * @description 针对表【sys_user】的数据库操作Mapper
 * @createDate 2023-02-10 13:32:02
 * @Entity cn.xtong.test.user.model.SysUser
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> list(SysUser sysUser);
}




