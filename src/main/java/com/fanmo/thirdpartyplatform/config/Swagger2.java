package com.fanmo.thirdpartyplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    /*
	swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	1.apiInfo()方法用来创建该API的基本信息，这些信息会展现在文档页面上。信息包括：
	2.select()函数返回一个ApiSelectorBuilder实例来控制那些接口暴露给swagger2来展示。
	3.apis(RequestHandlerSelectors.basePackage("路径"))需要展示的接口通过扫描包的路径来获取路径下的
		controller定义api，并产生文档内容（除了那些被@ApiIgnore指定忽略的请求）多包可以使用逗号分隔。
	4.paths(PathSelectors.any())扫描路径下的所有API。
	5.build()创建生效。
	*/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //这里要改为自己项目包名
                .apis(RequestHandlerSelectors.basePackage("com.fanmo.thirdpartyplatform.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /*
        构建 api文档的展示基本信息函数；这些信息将会展示在接口文档Swagger-ui.html上面
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("第三方平台API")
                //描述
                .description("第三方平台API")
                .termsOfServiceUrl("http://localhost:9999/swagger-ui.html")//http://localhost:8080
                .version("1.1.0")
                .build();
    }


}
