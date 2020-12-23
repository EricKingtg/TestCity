package com.org.citi.bnmxcomponent;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component("utilidades")
public class Utilidades {

	public Map<String, List<String>> getHeaders(HttpServletRequest request){
	
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Stream<String> stream = Collections.list(request.getHeaderNames()).stream();
		stream.forEach(entry -> map.put(entry, (List<String>) request.getHeaders(entry)));
		
		return map;
	}
	
	
	public Map<String, List<String>> getHeaders(HttpServletRequest request, List<String> headerNames){
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Stream<String> stream = Collections.list(request.getHeaderNames()).stream();
		
		stream.forEach(entry -> map.put(entry, (List<String>) request.getHeaders(entry)));
		
		Map<String, List<String>> salida = (Map<String, List<String>>) map.entrySet().stream().filter(header -> headerNames.stream()
				.anyMatch(head -> head.equals(header.getKey())))
				.collect(Collectors.toList());
		
		return null;
	}

}
