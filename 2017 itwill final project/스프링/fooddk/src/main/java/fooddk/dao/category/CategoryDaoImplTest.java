package fooddk.dao.category;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Category;

public class CategoryDaoImplTest {
	public static void main(String[] args) {
		System.out.println("-------appication context[bean factory]초기화 전-------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml"); 
		System.out.println("-------appication context[bean factory]초기화 후-------");
		
		CategoryDaoImpl cdi = (CategoryDaoImpl) applicationContext.getBean("categoryDao");
		System.out.println(cdi);
		
		/*Category inCategory = new Category("일식");
		cdi.insertCategory(inCategory);*/
		
	/*	Category upca = new Category(2, "헤잉");
		cdi.updateCategory(upca);
		System.out.println(upca);*/
		
	
	/*	Category df = cdi.selectCategoryNumber(1);
		System.out.println(df);
		
		cdi.deleteCategory(2);
	*/
		List<Category> list = cdi.AllCategory();
		System.out.println(list);
	}
}
