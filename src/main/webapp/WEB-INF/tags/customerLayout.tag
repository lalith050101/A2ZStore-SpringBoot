<%@ tag description="Home Wrapper Tag" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> ${title} | A2Z</title>
        
        <link href="${contextPath}/resources/css/style.css" rel="stylesheet" />
    </head>
    <body>
    		<jsp:include page="${contextPath}/WEB-INF/jsp/admin/loginValidation.jsp" />	
    
        <div>
            <div>
                <jsp:include page="${contextPath}/WEB-INF/jsp/customer/header.jsp" />
            </div>
            <div>
                <jsp:doBody/>
            </div>
            <div>
                <jsp:include page="${contextPath}/WEB-INF/jsp/footer.jsp" />
            </div>
        </div>
        
    </body>
</html>