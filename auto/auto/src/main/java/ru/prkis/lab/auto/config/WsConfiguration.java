package ru.prkis.lab.auto.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WsConfiguration extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "bodies")
    public Wsdl11Definition bodiesWsdlDefinition(@Qualifier("bodiesSchema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BodiesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://vyatgu.ru/prkis/lab/auto");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean(name = "bodiesSchema")
    public XsdSchema bodiesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/bodies.xsd"));
    }

    @Bean(name = "cars")
    public Wsdl11Definition carsWsdlDefinition(@Qualifier("carsSchema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CarsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://vyatgu.ru/prkis/lab/auto");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean(name = "carsSchema")
    public XsdSchema carsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/cars.xsd"));
    }

    @Bean(name = "manufacturers")
    public Wsdl11Definition manufacturersWsdlDefinition(@Qualifier("manufacturersSchema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ManufacturersPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://vyatgu.ru/prkis/lab/auto");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean(name = "manufacturersSchema")
    public XsdSchema manufacturersSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/manufacturers.xsd"));
    }

    @Bean(name = "stats")
    public Wsdl11Definition statsWsdlDefinition(@Qualifier("statsSchema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("StatsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://vyatgu.ru/prkis/lab/auto");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean(name = "statsSchema")
    public XsdSchema statsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/stats.xsd"));
    }
}
