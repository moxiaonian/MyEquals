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
		
		//����NULL
		System.out.println(MyEquals.equals(null,null)); 

		
		//���Ի�������
        int a=1,b=1;
        System.out.println(MyEquals.equals(a,b));
        
        Boolean f=Boolean.TRUE,f1=Boolean.TRUE;
        System.out.println(MyEquals.equals(f,f1));

        
        //��������
        int[] array1 = {1,2,3,4};
        int[] array2 = {1,2,3,4};
        System.out.println(MyEquals.equals(array1,array2));
        
        
        
        //�����Զ������
        A vo = new A();
        vo.setId(1l);
        vo.setName("С��");
        School school = new School();
        school.setName("JavaѧУ");
        school.setLevel(LevelEnum.SENIOR);
        vo.setSchool(school);
       
        A vo1 = new A();
        vo1.setId(1l);
        vo1.setName("С��");
        School school1 = new School();
        school1.setName("JavaѧУ");
        school1.setLevel(LevelEnum.SENIOR);
        vo1.setSchool(school1);
      
        System.out.println(MyEquals.equals(vo,vo1));
        
        
        //����List���󣬱��������飬�����ҪList˳��Ҳ���
        vo1.setName("С��1");
        vo1.setName("ѧУ1");
        
        List<A> list = new ArrayList<A>();
        List<A> list1 = new ArrayList<A>();
        list.add(vo);
        list.add(vo1);
        list1.add(vo1);
        list1.add(vo);
        System.out.println(MyEquals.equals(list,list1));  //list,list1�ڲ�Ԫ������ͬ�������
        
        
        //����Set����
        Set<A> set = new HashSet<>();
        Set<A> set1 = new HashSet<>();
        set.add(vo);
        set.add(vo1);
        set1.add(vo1);
        set1.add(vo);
        System.out.println(MyEquals.equals(set,set1));  //TreeSetĿǰ������
        
        
        //����Map
        Map<String,String> map = new TreeMap<>();
        Map<String,String> map1 = new TreeMap<>();
        map.put("name", "jack");
        map.put("age", "11");
        map1.put("age", "11");
        map1.put("name", "jack");
        System.out.println(MyEquals.equals(map,map1));

       
        
        
    }
	
}
