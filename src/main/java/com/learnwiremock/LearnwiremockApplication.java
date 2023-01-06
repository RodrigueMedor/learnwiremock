package com.learnwiremock;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
public class LearnwiremockApplication {
	@Value("${movieapp.baseUrl}")
	private String baseUrl;

	@Autowired
	private CloseableHttpClient httpClient;

	@Bean
	public RestTemplate restTemplate() {

		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
		return restTemplate;
	}

	@Bean
	@ConditionalOnMissingBean
	public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {

		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
				= new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setHttpClient(httpClient);
		return clientHttpRequestFactory;
	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		RestTemplate restTemplate = builder
//				.setConnectTimeout(Duration.ofMillis(3000))
//				.setReadTimeout(Duration.ofMillis(3000))
//				.build();
//		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
//
//		return restTemplate;
//	}

//	@Bean
//	public RestTemplate getRestTemplate() {
//		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
////		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
////		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
////		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
////		messageConverters.add(converter);
////		restTemplate.setMessageConverters(messageConverters);
//
//		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
//		return restTemplate;
//	}
//
//	private SimpleClientHttpRequestFactory getClientHttpRequestFactory()
//	{
//		SimpleClientHttpRequestFactory clientHttpRequestFactory
//				= new SimpleClientHttpRequestFactory();
//		//Connect timeout
//		clientHttpRequestFactory.setConnectTimeout(5_000);
//
//		//Read timeout
//		clientHttpRequestFactory.setReadTimeout(5_000);
//		return clientHttpRequestFactory;
//	}

	public static void main(String[] args) {
		SpringApplication.run(LearnwiremockApplication.class, args);
	}

}
