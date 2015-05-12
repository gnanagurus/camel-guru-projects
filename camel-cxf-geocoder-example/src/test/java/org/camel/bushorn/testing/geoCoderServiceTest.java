
package org.camel.bushorn.testing;

import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.cxf.helpers.IOUtils;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class geoCoderServiceTest extends CamelSpringTestSupport {

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("/META-INF/spring/camel-config.xml");
    }

    @Test
    public void soapUnwrapperTest_usingMock() throws Exception {
       
    	context.getRouteDefinition("geocoder-service-callout")
        .adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
            	replaceFromWith("direct:geo-coder-gateway");
                weaveById("soap-unwrapper").after().convertBodyTo(String.class).to("mock:intercept-body");
            }
        });
    context.start();
    
    String requestPayload = IOUtils.toString(getClass().getResourceAsStream("/samples/service-request.xml"));

    template.sendBody("direct:geo-coder-gateway", requestPayload);
    
    String response = getMockEndpoint("mock:intercept-body").getExchanges().get(0).getIn().getBody().toString();

    log.info("Response :"+response);
    
    assertTrue(!response.contains("<soapenv:Envelope"));
    	
    }
    
    @Test
    public void soapUnwrapperTest_withoutMock() throws Exception {
       
    	context.getRouteDefinition("geocoder-service-callout")
        .adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
            	replaceFromWith("direct:geo-coder-gateway");
                weaveById("service-response-generator").remove();
                weaveById("soap-wrapper").remove();
                weaveById("reset-body").remove();
            }
        });
    context.start();
    
    String requestPayload = IOUtils.toString(getClass().getResourceAsStream("/samples/service-request.xml"));

    String response = template.requestBody("direct:geo-coder-gateway", requestPayload).toString();

    log.info("Response :"+response);
    
    assertTrue(!response.contains("<soapenv:Envelope"));
    	
    }

}
