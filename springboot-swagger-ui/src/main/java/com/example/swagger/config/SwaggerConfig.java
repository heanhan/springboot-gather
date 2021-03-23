package com.example.swagger.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/22 5:25 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class SwaggerConfig {

    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * @return Docket
     */
    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        //添加header参数
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("token")
                .description("用户登录获取的token信息")
                .modelRef(new ModelRef("string")).parameterType("header")
                //header中的参数是非必填的。
                .required(false).build();
        pars.add(ticketPar.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .groupName("需要token验证")
                .globalOperationParameters(pars);
    }


    /**
     * api文档的详细信息函数,注意这里的注解引用的是哪个
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // //大标题
                .title("SpringBoot-Swagger-ui 对接口文档进行管理")
                // 版本号
                .version("1.0")
                .termsOfServiceUrl("NO terms of service")
                // 描述
                .description("被服务是对swagger-ui的使用")
                //作者
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
