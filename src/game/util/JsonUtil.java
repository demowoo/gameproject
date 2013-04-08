package game.util;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface JsonUtil {
	public ObjectMapper getMapper();
	public String toJsonString(Object obj);
	public <T> T fromJsonString(String jsonString, Class<T> t);
	public <T> List<T> fromStringToList(String jsonString, TypeReference<List<T>> typeReference);
}
