package com.xiaowei.feign;

import com.xiaowei.common.common.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MOMO on 2019/1/7.
 */
@FeignClient(name = "xiaowei-platform", fallback = TestFeign.MdFeignaaaaaaaaa.class)
public interface TestFeign {
    @RequestMapping("/platform/insert")
    public JSONResult test();
    @PostMapping("/platform/testDbDAO")
    public JSONResult testDbDAO(
            @RequestHeader(value = "testHeader", required = false) String testHeader) ;
    @Component
    @Slf4j
    static class MdFeignaaaaaaaaa implements TestFeign {
        @Override
        public JSONResult testDbDAO( String testHeader) {
            log.error("调用{}异常{}", "test");
            return JSONResult.errorException(-1,"","调用{}异常:platform");
        }
        @Override
        public JSONResult test() {
            log.error("调用{}异常{}", "test");
            return null;
        }
    }
}
