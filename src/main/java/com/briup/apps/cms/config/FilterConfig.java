package com.briup.apps.cms.config;

import com.briup.apps.cms.filter.CmsTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cms
 * @description
 * @author: tianya
 * @create: 2019-11-17 13:47
 **/
@Configuration
public class FilterConfig {

    @Bean
    public CmsTokenFilter tokenFilter(){
        return new CmsTokenFilter();
    }
}
