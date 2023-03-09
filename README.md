SpringCache 注解实现缓存示例

# 这是一个简单的演示项目，使用步骤如下：

1. 创建`springboot-redis-example`数据库。
2. 导入`init.sql`。
3. 修改`application-dev.yml`里`mysql`、`redis`的配置。
4. 启动项目，并访问 `http://127.0.0.1:8088/user/list` 观察控制台日志输出情况。

# SpringCache 常见注解说明
- `@EnableCaching`：启用`SpringCache`缓存，配置类加上这个注解之后`Spring`才知道你需要使用缓存功能，其他和缓存相关的注解才会生效，`SpringCache`主要通过`AOP`实现缓存功能。
- `@CacheConfig`：类注解，类的全局配置。
- `@Cacheable`：调用方法前先去缓存找，缓存中有直接返回缓存中的数据；若缓存中没有，执行方法并将结果放入缓存。
  - `cacheNames`：缓存名称。
  - `key`：缓存key。
  - `unless`：结果满足`unless`表达式，不将结果放入缓存。
- `@CachePut`：执行方法并将结果放入缓存。
- `@CacheEvict`：删除缓存中的数据。
  - `allEntries`：删除`cacheNames`下的所有缓存。
- `@Caching`：组合多个注解策略在一个方法上。