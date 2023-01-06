//package com.learnwiremock;
//
//
//import com.atlassian.ta.wiremockpactgenerator.WireMockPactGenerator;
//import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
//import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
//import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
//import com.learnwiremock.service.MoviesRestClient;
//import io.restassured.config.RestAssuredConfig;
//import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
//import io.restassured.specification.RequestSpecification;
//import org.junit.ClassRule;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.contract.wiremock.WireMockSpring;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//
////@RunWith(SpringRunner.class)
//@SpringBootTest(classes = LearnwiremockApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@ContextConfiguration
//@TestPropertySource(properties= {"movieapp.baseUrl=http://localhost:8089"})
//public abstract class SpringIntegrationTest {
//
//    protected RequestSpecification request;
//    protected Response response;
//    protected ValidatableResponse json;
//    protected RestAssuredConfig config;
//
////    @Value("${app.endpoint.timeout}")
////    protected Integer timeOut;
//
////    @Value("${movieapp.baseUrl}")
////    protected String baseUrl;
//
//    @ClassRule
//    public static WireMockClassRule wireMockRule = new WireMockClassRule(
//            WireMockSpring
//                    .options()
//                    .notifier(new ConsoleNotifier(true))
//                    .extensions(new ResponseTemplateTransformer(true))
//                    .port(8089));
////
////    @Value("${app.endpoint.timeout}")
////    protected Integer timeOut;
////
////
////    @Value("${spring.profiles.active}")
////    protected String activeProfile;
////
//    protected WireMockPactGenerator wireMockPact;
//
//    @Autowired
//    protected MoviesRestClient moviesRestClient;
//
////    Options options = wireMockConfig().
////            port(8089)
////            .notifier(new ConsoleNotifier(true))
////            .extensions(new ResponseTemplateTransformer(true));
////
////    @Rule
////    public WireMockRule wireMockRule = new WireMockRule(options);
//
//}
