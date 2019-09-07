package com.server.feign;

import com.server.bean.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liulei
 * @Description 用户远程调用接口
 * @create 2017/10/10 14:27
 */
//@FeignClient(name = "user")
// 在feign调用中增加hystrix,需要添加fallback参数,同时需要启用配置 feign.hystrix.enabled=true
//@FeignClient(name = "user", fallback = UserFeignClient.FeignClientFallback.class)

@FeignClient(name = "user", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable("id") String id);

    @Component
    public static class FeignClientFallback implements UserFeignClient {

        @Override
        public User findById(String id) {
            System.out.println("已触发回调方法...");
            return new User("-1", "default name");
        }
    }
}

@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    private static final Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(String id) {
                logger.info("factory: 错误原因: " + throwable);
                return new User("-2", "factory ");
            }
        };
    }
}