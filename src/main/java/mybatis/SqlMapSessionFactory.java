package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapSessionFactory {
	
	private static SqlSessionFactory sqlMapSessionFactory; //db에 있는 정보를 xml파일을 통해 저장하고 dao에서 꺼내쓴다.
	
	static{		
		String resource = "kr/or/ddit/mybatis/mybatis-config.xml";
		InputStream inputStream = null; 
		try{
			 inputStream= Resources.getResourceAsStream(resource);
			 sqlMapSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public static SqlSessionFactory getSqlMapSessionFactory() {
		return sqlMapSessionFactory;
	}
	
}
