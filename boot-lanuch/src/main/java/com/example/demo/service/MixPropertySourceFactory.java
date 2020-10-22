package com.example.demo.service;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.Properties;

public class MixPropertySourceFactory extends DefaultPropertySourceFactory {

    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource)
            throws IOException {
//        return name != null ? new ResourcePropertySource(name, resource) : new ResourcePropertySource(resource);
        String sourceName= name!=null ? name : resource.getResource().getFilename();
        if(sourceName != null &&(sourceName.endsWith(".yml")||sourceName.endsWith(".yaml"))){
            Properties properties=loadYml(resource);
            return new PropertiesPropertySource(sourceName,properties);
        }else{
            return super.createPropertySource(name,resource);
        }
    }

    private Properties loadYml(EncodedResource resource){
        YamlPropertiesFactoryBean factoryBean=new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource.getResource());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

}
