package com.example.demo.Controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.DemoApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by  Domain
 * on 2019/2/20 14:21;
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class controllerTestTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        //单个类,项目拦截器无效
//      mvc = MockMvcBuilders.standaloneSetup(new ProductController()).build();
        //项目拦截器有效
        System.err.println("===========start test=============");
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }



    @Test
    public void mockGet() throws Exception {
        RequestBuilder request= MockMvcRequestBuilders.get("/mockTest/mockGet")
                .contentType(MediaType.ALL);
        MvcResult mvcResult = mockMvc.perform(request).andReturn() ;
        System.err.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void mockGetWithParams() throws Exception {
        RequestBuilder request= MockMvcRequestBuilders.get("/mockTest/getWithParams","param1","param2")
                .contentType(MediaType.ALL);
        MvcResult mvcResult = mockMvc.perform(request).andReturn() ;
        System.err.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void mockPost() throws Exception {

        Map body = new HashMap();
        body.put("hello","world");
        body.put("niceto","meetU");
        RequestBuilder request = MockMvcRequestBuilders.post("/mocktest/mockPost")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(body));
        MvcResult mvcResult = mockMvc.perform(request).andReturn() ;
        System.err.println(mvcResult.getResponse().getStatus());
        System.err.println(mvcResult.getResponse().getContentAsString());
    }

    @After
    public void end(){
        System.err.println("============end test==============");
    }
}
