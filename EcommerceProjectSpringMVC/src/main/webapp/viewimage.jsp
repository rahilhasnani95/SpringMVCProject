<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.rahil.dao.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.Blob" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	int itemid = Integer.parseInt(request.getParameter("itemid"));
	
	DatabaseConnection db = new DatabaseConnection();

	try
	{
		db.connect_db();
		db.prepst = db.con.prepareStatement("select * from items where itemid = ?");
				
		db.prepst.setInt(1, itemid);
		
		db.rs = db.prepst.executeQuery();
		
		if(db.rs.next())
		{			
			Blob blob = db.rs.getBlob("itemimage");
			byte byteArray[] = blob.getBytes(1, (int) blob.length());
			response.setContentType("image/gif");
			OutputStream os = response.getOutputStream();
			os.write(byteArray);
			os.flush();
			os.close();
		} 
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		db.close_db();
	}

%>

</body>
</html>