package ones.quzhigang.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}


	/**
	 * 功能描述: <br>
	 * 〈动态路由配置〉
	 *
	 * @param
	 * @return: org.springframework.cloud.netflix.zuul.filters.ZuulProperties
	 * @@throws:
	 * @Version: 1.0.0
	 * @Author: 屈志刚
	 * @Date: 2018/7/17 0017 11:00
	 */
	@ConfigurationProperties("zuul")
	@RefreshScope
	public ZuulProperties zuulProperties(){

		return new ZuulProperties();
	}
}
