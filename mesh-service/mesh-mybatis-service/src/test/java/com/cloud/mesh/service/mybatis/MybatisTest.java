/*
 *  Copyright 2019 https://github.com/romeoblog/spring-cloud.git Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.cloud.mesh.service.mybatis;

import com.baomidou.mybatisplus.plugins.Page;
import com.cloud.mesh.model.mybatis.TestVO;
import com.cloud.mesh.service.mybatis.service.IMybatisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * The type JUnit Test
 *
 * @author willlu.zheng
 * @date 2019-07-29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MybatisTest {

    @Autowired
    private IMybatisService mybatisService;

    @Autowired
    private Environment environment;

    @Value("${server.port}")
    private String post;

    @Test
    public void testSecKill() {

        Page<TestVO> testVOPage = mybatisService.listRecord(1, 10);

        System.out.println(testVOPage.getRecords());
    }

    @Test
    public void test() {
        String property = environment.getProperty("spring.application.name");
        System.out.println(property);
        System.out.println(post);
    }
}