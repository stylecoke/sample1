package com.myapp.junit;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 단위테스트를 스프링과 연동
@RunWith(SpringJUnit4ClassRunner.class)
// 환경설정 파일 명시
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest 
{
	@Autowired
    private SqlSessionFactory sqlFactory;
    
    @Test
    public void testFactory(){
        System.out.println("\n >>>>>>>>>> sqlFactory 출력 : "+sqlFactory);
    }
    
    @Test
    public void testSession() throws Exception{
        
        try(SqlSession session = sqlFactory.openSession()){
            
            System.out.println(" >>>>>>>>>> session 출력 : "+session+"\n");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
