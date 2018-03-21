
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="<c:url value='/assets/js/echarts.common.min.js' />" type="text/javascript"></script>
<title>Lengolytics</title>
</head>
<body>
	
	<div class="contianer-fluid">
		<div class="row">
			<div class="jumbotron">
				<div class="text-center">
					<h1> Welcome </h1>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<!-- <div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				${jsonde_df}
				<c:forEach var="one" items="${jsonde_df}">
					
					<p> <c:out value="${one}" /></p>
				</c:forEach>
			</div>
		</div>
	</div> -->
	
	<div class="container">
		<div class="row">
			<div class="col-md-12" id="testChart" style="width: 100%;height:700px;">
				
			</div>
		</div>
	</div> 
	

	<script th:inline="javascript">
	/*<![CDATA[*/
		

		
	    var message = ${jsonde_df};
	    console.log(message);

	    var xData = [];
	    var yData = [];
	    var dData = []; 
	    
	    for(var i = 0; i < message.length; i++)
	    	{
	    		dData.push(message[i]['Country']);
	    		yData.push(message[i]['sum(UnitPrice)']);
	    		xData.push(message[i]['Description']);
	    	}
	    
	    var myChart = echarts.init(document.getElementById('testChart'));
	    
	    var option = {
	            title: {
	                text: 'ECharts entry example'
	            },
	            tooltip: {},
	            legend: {
	                data:xData
	            },
	            xAxis: {
	            	type: 'category',
	                data: xData
	            },
	            yAxis: {
	            	type: 'value',
	            	
	            },
	            series: [{
	                type: 'bar',
	                data: yData
	            }]
	        };

	        // use configuration item and data specified to show chart
	        myChart.setOption(option);
	     
	    
	
	/*]]>*/
	</script>
</body>
</html>