package game.util.impl;

import game.util.JsonUtil;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("jsonUtil")
public class JsonUtilImpl implements JsonUtil{
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public ObjectMapper getMapper() {
		return this.mapper;
	}
	
	@Override
	public String toJsonString(Object obj){
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			logger.error("对象转换成Json字符串出错", e);
		} catch (JsonMappingException e) {
			logger.error("对象转换成Json字符串出错", e);
		} catch (IOException e) {
			logger.error("对象转换成Json字符串出错", e);
		}
		return "";
	}
	
	@Override
	public <T> T fromJsonString(String jsonString, Class<T> t){
		logger.debug("要转换的字符串为：{}", jsonString);
		T rt = null;
		try {
			rt = mapper.readValue(jsonString, t);
		} catch (JsonParseException e) {
			logger.error("字符串转换成Json对象出错", e);
		} catch (JsonMappingException e) {
			logger.error("字符串转换成Json对象出错", e);
		} catch (IOException e) {
			logger.error("字符串转换成Json对象出错", e);
		}
		return rt;
	}

	@Override
	public <T> List<T> fromStringToList(String jsonString,
			TypeReference<List<T>> typeReference) {
		logger.debug("要转换的字符串为：{}", jsonString);
		List<T> lt = null;
		try {
			lt = mapper.readValue(jsonString, typeReference);
		} catch (JsonParseException e) {
			logger.error("字符串转换成Json对象出错", e);
		} catch (JsonMappingException e) {
			logger.error("字符串转换成Json对象出错", e);
		} catch (IOException e) {
			logger.error("字符串转换成Json对象出错", e);
		}
		return lt;
	}

}
