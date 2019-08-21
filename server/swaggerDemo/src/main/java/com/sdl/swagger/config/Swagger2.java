package com.sdl.swagger.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("dev")
public class Swagger2 {
	
	@Bean
	public Docket userServer() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("用户")// 组名称
				.select()// 选择那些路径和api会生成document
				.apis(RequestHandlerSelectors.basePackage("com.sdl.swagger.controller"))//对定义的包下的api进行监控 
				.paths(PathSelectors.any())// 对所有路径进行监控 
				.build()
				.apiInfo(apiInfo());
	}
	
	@Bean
	public Docket deptServer() {
		return new Docket(DocumentationType.SWAGGER_2)
				.globalResponseMessage(RequestMethod.GET, this.globalResponseMessage())
				.globalResponseMessage(RequestMethod.PUT, this.globalResponseMessage())
				.globalResponseMessage(RequestMethod.DELETE, this.globalResponseMessage())
				.globalResponseMessage(RequestMethod.POST, this.globalResponseMessage())
				.groupName("部门")// 组名称
				.select()// 选择那些路径和api会生成document
				.apis(RequestHandlerSelectors.basePackage("com.sdl.swagger.controller"))//对定义的包下的api进行监控 
				.paths(regex("/dept/.*"))// 过滤的接口
				.build()
				.apiInfo(apiInfo());
	}
	
	private List<ResponseMessage> globalResponseMessage(){
		List<ResponseMessage> responseMessageList = new ArrayList<>();
	    responseMessageList.add(new ResponseMessageBuilder().code(200).message("请求成功").responseModel(new ModelRef("ApiError")).build());
	    responseMessageList.add(new ResponseMessageBuilder().code(201).message("资源被正确的创建").responseModel(new ModelRef("ApiError")).build());
	    responseMessageList.add(new ResponseMessageBuilder().code(401).message("没有提供认证信息").responseModel(new ModelRef("ApiError")).build());
	    responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("ApiError")).build());
	    responseMessageList.add(new ResponseMessageBuilder().code(403).message("无权访问").responseModel(new ModelRef("ApiError")).build());
	    responseMessageList.add(new ResponseMessageBuilder().code(404).message("无效的请求路径").responseModel(new ModelRef("ApiError")).build());
	    return responseMessageList;
    }

	
	 @SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("个人测试")	//标题
                .description("个人测试用api")//描述
                .version("1.0")//版本
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")// 设置文档的License信息
                .build();

	 }
	 	 
}
