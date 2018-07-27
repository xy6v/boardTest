<%-- 
    Document   : index
    Created on : 2012. 8. 30, 오전 10:17:50
    Author     : u-lab1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*, java.util.*" %>
<% request.setCharacterEncoding("utf-8"); %>

<%
 //데이터베이스 연결과 관련된 변수를 선언
 Connection conn = null;
 Statement stmt = null;
 
 //데이터베이스 연결과 관련된 정보를 문자열로 선언
 String jdbc_driver = "com.mysql.jdbc.Driver";
 String jdbc_url = "jdbc:mysql://localhost/test?user=root&password=1";
 
 try{
     //JDBC 드라이버를 로드한다.
     Class.forName(jdbc_driver);
     //데이터베이스 연결 정보를 이용해서 Connection 인스턴스를 확보한다.
     conn = DriverManager.getConnection(jdbc_url);
     
     //Connection 클래스의 인스턴스로부터 SQL문 작성을 위한 Statement를 준비한다.
     //ResultSet.TYPE_SCROLL_INSENSITIVE -> 커서를 다시 되돌릴수 있게(next()이후에)
     stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     
     //username값을 입력한 경우 SQL문을 수행한다.
     if(request.getParameter("username") != null){
         String sql = "insert into jdbc_test values('" + request.getParameter("username") +"','" + request.getParameter("email")+"')";
         stmt.executeUpdate(sql);
     }
 }catch(Exception e){
     System.out.println(e);
 }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h2>이벤트 등록</h2>
        <form name="form1" method="post">
            등록이름 : <input type="text" name="username">
            email주소 : <input type="text" name="email" size="20">
            <input type="submit" value="등록">
        </form>
        #등록목록 <p>
        <table border="1" cellpadding="5" cellspacing="0">
            <tr><td width="50">번호</td><td width="125">email</td></tr>
            
            <%
             //한페이지에 보여줄 게시물 개수다.
            int PAGE_SIZE=3;
             //그룹의 크기다
            int GROUP_SIZE=2;
            //요청 페이지 :linkPage값이다.
            String reqPage;
            //현재 페이지
            int curPage;
            //전체 게시물 개수
            int totalCount;
            //전체 페이지 수
            int pageCount;
            
            reqPage = request.getParameter("page");
            if(reqPage == null){
                curPage=1;
            }else{
                curPage = Integer.parseInt(reqPage);
            }
            
            String sql = "select count(*) from jdbc_test";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            totalCount = rs.getInt(1);
            
            try{
                //select문을 문자열 형태로 구성한다.
                sql = "select username, email from jdbc_test";
                //select를 수행하면 데이터 정보가 ResultSet클래스의 인스턴스로 리턴된다.
                rs = stmt.executeQuery(sql);
                
                int i=totalCount+1;
                //현재 페이지가 1페이지가 아닌 경우 ResultSet 커서를 해당 페이지까지 이동시킨다.
                if(curPage>1){
                    rs.absolute((curPage-1)*PAGE_SIZE);
                    //전체 게시물을 기준으로 현재 페이지의 게시물 번호를 표시하기 위한 변수다.
                    i = i - ((curPage-1)*PAGE_SIZE);
                }
                //현재 페이지의 게시물 계산을 위한 변수다.
                int j=1;
                
                //현재 페이지에 해당하는 게시물만 보여준다.
                while(rs.next() && (j <=PAGE_SIZE)){
                    i--;
                    out.println("<tr><td>"+i+"</td><td>" + rs.getString(1) + "</td><td>" + rs.getString("email") + "</td></tr>");
                    j++;
                }
                //사용한 자원을 반납한다.
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e){
                System.out.println(e);
            }
            %>        
        </table>
        </p>
        <%
        //페이지 네비게이션을 만든다.
        //전체 게시물수와 페이지크기를 가지고 전체페이지 개수를 계산한다.
        //소수점에 따라 계산에 오류가 없도록 두가지중 한가지를 이용한다.
        //pageCount = totalCount/PAGE_SIZE;
        pageCount = (int) Math.ceil(totalCount / (PAGE_SIZE + 0.0));
        //if((total % PAGE_SIZE) != 0)
        //pageCount++;
        
        //현재 그룹을 설정한다.
        int curGroup = (curPage-1) / GROUP_SIZE;
        
        int linkPage = curGroup * GROUP_SIZE;
        //첫번째 그룹이 아닌 경우에 해당한다.
        if(curGroup > 0){
            out.println("<a href=jdbctest-page.jsp?page=" + linkPage+"><<이전</a>");
        }
        //다음 링크를 위해 증가시킨다.
        linkPage++;
        
        int loopCount = GROUP_SIZE;
        //그룹범위내에서 페이지 링크를 만든다.
        while((loopCount > 0) && (linkPage <= pageCount)){
            out.println("[<a href=jdbctest-page.jsp?page="+linkPage+">" + linkPage+"</a>]&nbsp;");
            linkPage++;
            loopCount--;
        }
        //다음 그룹이 있는 경우에 해당한다.
        if(linkPage <= pageCount){
            out.println("<a href=jdbctest-page.jsp?page="+linkPage+">다음>></a>");
        }
        //변수를 확인하기 위해서 출력한다.
        out.println("<HR>");
        out.println("curPage : " + curPage + "<BR>");
        out.println("curGroup : " + curGroup + "<BR>");
        out.println("totalCount : " + totalCount + "<BR>");
        out.println("pageCount : " + pageCount + "<BR>");
        %>
    </center>
    </body>
</html>
