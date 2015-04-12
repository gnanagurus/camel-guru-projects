This project uses the following camel components:

1. Camel-geocoder
2. Camel-xslt
3. Camel-cxf

This camel project exposes a SOAP gateway endpoint, which internally uses camel-geocoder component to get the address details. 

This example will be further improved to support rest gateway and more detailed address response. 

Service URL:

http://127.0.0.1:8181/camel/geo-service/

SOAP Request:

https://github.com/gnanagurus/camel-guru-projects/blob/master/camel-cxf-geocoder-example/src/test/resources/samples/service-request.xml

SOAP Response:

https://github.com/gnanagurus/camel-guru-projects/blob/master/camel-cxf-geocoder-example/src/test/resources/samples/service-response.xml

Note: mvn clean install will generate a war file. Just deploy it to your web container. If you want to deploy this project to Karaf/ServiceMix/Fuse please change the packaging to bundle and add maven-bundle-plugin

