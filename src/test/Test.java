package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import util.MyEquals;

public class Test {

	public static void main(String[] args) {
		
		//测试NULL
		System.out.println(MyEquals.equals(null,null)); 

		
		//测试基本类型
        int a=1,b=1;
        System.out.println(MyEquals.equals(a,b));
        
        Boolean f=Boolean.TRUE,f1=Boolean.TRUE;
        System.out.println(MyEquals.equals(f,f1));

        
        //测试数组
        int[] array1 = {1,2,3,4};
        int[] array2 = {1,2,3,4};
        System.out.println(MyEquals.equals(array1,array2));
        
        
        
        //测试自定义对象
        A vo = new A();
        vo.setId(1l);
        vo.setName("小明");
        School school = new School();
        school.setName("Java学校");
        school.setLevel(LevelEnum.SENIOR);
        vo.setSchool(school);
       
        A vo1 = new A();
        vo1.setId(1l);
        vo1.setName("小明");
        School school1 = new School();
        school1.setName("Java学校");
        school1.setLevel(LevelEnum.SENIOR);
        vo1.setSchool(school1);
      
        System.out.println(MyEquals.equals(vo,vo1));
        
        
        //测试List对象，本质是数组，相等需要List顺序也相等
        vo1.setName("小明1");
        vo1.setName("学校1");
        
        List<A> list = new ArrayList<A>();
        List<A> list1 = new ArrayList<A>();
        list.add(vo);
        list.add(vo1);
        list1.add(vo1);
        list1.add(vo);
        System.out.println(MyEquals.equals(list,list1));  //list,list1内部元素排序不同，不相等
        
        
        //测试Set对象
        Set<A> set = new HashSet<>();
        Set<A> set1 = new HashSet<>();
        set.add(vo);
        set.add(vo1);
        set1.add(vo1);
        set1.add(vo);
        System.out.println(MyEquals.equals(set,set1));  //TreeSet目前有问题
        
        
        //测试Map
        Map<String,String> map = new TreeMap<>();
        Map<String,String> map1 = new TreeMap<>();
        map.put("name", "jack");
        map.put("age", "11");
        map1.put("age", "11");
        map1.put("name", "jack");
        System.out.println(MyEquals.equals(map,map1));

       
        
        
    }
	
}
