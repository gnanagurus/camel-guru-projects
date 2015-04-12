This project uses the following camel components:

1. Camel-geocoder
2. Camel-xslt
3. Camel-cxf

This camel project exposes a SOAP gateway endpoint, which internally uses camel-geocoder component to get the address details. 

This example will be further improved to support rest gateway and more detailed address response. 

Service URL:

http://127.0.0.1:8181/camel/geo-service/

SOAP Request:

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:geo="http://www.bushorn.com/camel/geo-service/">
   <soapenv:Header/>
   <soapenv:Body>
      <geo:GeoServiceRequest>
         <address>Chennai, India</address>
      </geo:GeoServiceRequest>
   </soapenv:Body>
</soapenv:Envelope>

SOAP Response:

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:geo="http://www.bushorn.com/camel/geo-service/">
   <soapenv:Header/>
   <soapenv:Body>
      <GeoServiceResponse>
         <details>13.0826802,80.27071840000001</details>
      </GeoServiceResponse>
   </soapenv:Body>
</soapenv:Envelope>

