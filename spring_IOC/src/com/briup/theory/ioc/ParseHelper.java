package com.briup.theory.ioc;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseHelper {
	
	/*注:这里只是简单了解析了实例文本bean.xml中的内容*/
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseXML(String path)throws Exception {
		Map<String, Object> map = 
			new HashMap<String, Object>();
		//创建SAXReader对象
		SAXReader reader = new SAXReader();
		
		//读取xml文件并返回对应的文档对象
		Document document = 
				reader.read(new File(path));
		
		//获得xml文档中的根元素 <beans>....</beans>
		Element rootElement = 
				document.getRootElement();
		
		//获得根元素下面的所有子元素的集合
		List<Element> elements = 
				rootElement.elements();
		
		//循环遍历拿到每一个子元素
		for(Element e:elements){
			//<bean name="stu" class="com.briup.theory.ioc.Student"></bean>
			//获得当前子元素中name属性的值
			String beanName = e.attributeValue("name");
			//获得当前子元素中class属性的值
			String className = e.attributeValue("class");
			
			//反射创建对象
			Object o = Class.forName(className).newInstance();
			
			//对象名字和对象本身 分别作为key和value放到map中
			map.put(beanName,o);
			
			//当前子元素也是有能有它自己的子元素的
			List<Element> elements2 = e.elements();
			for(Element e2:elements2){
				//<property name="student" ref="stu"></property>
				String propertyName = e2.attributeValue("name"); 
				String refName = e2.attributeValue("ref");
				
				//调用当前类中的一个私有方法 通过参数student获得其对应的set方法名:setStudent
				String methodName = getMethodName(propertyName);
				//通过对象名字stu从map中获得其对应的对象
				Object obj = map.get(refName);
				//获得setStudent方法镜像
				Method method = o.getClass().getMethod(methodName, new Class[]{obj.getClass()});
				//反射调用该方法 相当于 t.setStudent(stu);
				method.invoke(o, obj);
			}
		}
		
		return map;
	}
	
	//可以把字符串参数xxx转变为setXxx
	private static String getMethodName(String s) {
		s = s.substring(0,1).toUpperCase()+
				s.substring(1,s.length());
		return "set"+s;
	}

}
