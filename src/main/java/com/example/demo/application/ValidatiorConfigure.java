package com.example.demo.application;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ValidatiorConfigure {

  // メッセージを集約したファイルを読み込みに行く!!
  @Bean
  LocalValidatorFactoryBean validator() {
    LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
    localValidatorFactoryBean.setValidationMessageSource(messageSource());
    return localValidatorFactoryBean;
  }


  // メッセージを集約するファイルを指定
  private MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageResource =
        new ReloadableResourceBundleMessageSource();
    messageResource.setBasenames("classpath:/furutaKazuto", "classpath:/static/messages");
    messageResource.setDefaultEncoding("UTF-8");
    return messageResource;

  }

}

