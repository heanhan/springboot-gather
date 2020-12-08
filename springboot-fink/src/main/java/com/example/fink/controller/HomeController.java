package com.example.fink.controller;

import com.alibaba.fastjson.JSON;
import com.example.fink.pojo.Location;
import com.example.fink.utils.RestClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/5 2:16 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Slf4j
@RequestMapping(value = "/home")
@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping("/get_map")
    public void getMap(HttpServletResponse response) throws Exception{
        RestClientUtils restClientUtils = new RestClientUtils();
        String searchJSON="{\n" +
                "  \"query\": {\n" +
                "    \"bool\": {\n" +
                "      \"filter\": {\n" +
                "        \"range\": {\n" +
                "          \"{{time}}\": {\n" +
                "            \"{{gte}}\": \"{{value1}}\", \n" +
                "            \"{{lt}}\": \"{{now}}\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"aggs\": {\n" +
                "    \"{{group_by_jing}}\": {\n" +
                "      \"terms\": {\n" +
                "        \"script\": \"{{doc['jing'].values +'#split#'+ doc['wei'].values}}\"\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Map<String, Object> map = new HashMap<>();
        map.put("time","time");
        map.put("gte","gte");
        map.put("value1","now-20s");
        map.put("lt","lt");
        map.put("now","now");
        map.put("group_by_jing","group_by_jing");
        map.put("doc['jing'].values +'#split#'+ doc['wei'].values","doc['jing'].values +'#split#'+ doc['wei'].values");

        List<Location> locations = restClientUtils.searchTemplate("location-index", searchJSON, map);
        restClientUtils.closeClient();
        String json = JSON.toJSONString(locations);
        response.getWriter().print(json);
    }

}
