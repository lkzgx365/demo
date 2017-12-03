package com.jackson.demo.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.jackson.demo.demo.config.MyBeanSerializerModifier;
import com.jackson.demo.demo.entity.NullTest;
import com.jackson.demo.demo.entity.ReleaseNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Bean
	public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper mapper = converter.getObjectMapper();
		// 为mapper注册一个带有SerializerModifier的Factory，此modifier主要做的事情为：当序列化类型为array，list、set时，当值为空时，序列化成[]
		mapper.setSerializerFactory(mapper.getSerializerFactory().withSerializerModifier(new MyBeanSerializerModifier()));

		converter.setSupportedMediaTypes(ImmutableList.of(MediaType.TEXT_HTML, MediaType.APPLICATION_JSON));
		return converter;
	}

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		SpringApplication.run(DemoApplication.class, args);
		/*Class clz = ReleaseNull.class;
//		Constructor f = clz.getDeclaredConstructor(int.class);
		Constructor[] c = clz.getConstructors();
		Object o = c[0].newInstance();
		Object o1 = c[1].newInstance(-1);
		System.out.println(o);
		System.out.println(o1);*/

	}

	@RequestMapping("test/aaa")
	@ResponseBody
	public NullTest test() {
		return new NullTest();
	}
}
