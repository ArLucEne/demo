package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by  Domain
 * on 2019/2/20 14:08;
 */
@RestController
@RequestMapping(value = "/mocktest")
public class controllerTest {
    @RequestMapping(value = "/mockGet",method = RequestMethod.GET)
    public Object mockGet(){
        long start = System.nanoTime();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        return end-start;
    }
    @RequestMapping(value = "/mockGet2",method = RequestMethod.GET)
    public Object mockGet2(){
        long start = System.nanoTime();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        return end-start;
    }

    @RequestMapping(value = "/getWithParams",method = RequestMethod.GET)
    public Object mockGetWithParams(@RequestParam String param,@RequestParam String param2){
        long start = System.nanoTime();
        try{
            Thread.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.nanoTime();
        Map response = new HashMap<String,String>();
        response.put(param,param);
        response.put(param2,param2);
        response.put("responseTime",Long.toString(end-start));
        System.err.println(param+"========="+param2);
        return response;
    }

    @RequestMapping(value = "/getWithParams2",method = RequestMethod.GET)
    public Object mockGetWithParams2(@RequestParam String param,@RequestParam String param2){
        long start = System.nanoTime();/*
        try{
            Thread.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/

        Map response = new HashMap<String,String>();
        response.put(param,param);
        response.put(param2,param2);
        long end = System.nanoTime();
        response.put("responseTime",Long.toString(end-start));
        System.err.println(param+"========="+param2);
        return response;
    }

    @RequestMapping(value = "/mockPost",method = RequestMethod.POST)
    public Object mockPost(@RequestBody Map<String,String> body){
        long start = System.nanoTime();
       try{
            Thread.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.nanoTime();
        body.put("responseTime",Long.toString(end-start));
        return body;
    }
}
