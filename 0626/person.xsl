<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<!-- person.xsl -->
    <!-- template: 스타일을 정의하는 단위 -->
    <!-- 
      <xsl:template match="/">
        <xsl:apply-templates/>
      </xsl:template> 
    -->
	<xsl:template match="/persons">
	   <h3>사람목록</h3>
	   <hr/>
	   <table border='1' cellpadding='5' bgcolor="yellow">
	       <tr>
	          <th>이름</th>
	          <th>나이</th>
	          <th>직업</th>
	       </tr>
	       <xsl:apply-templates/><!-- 자식태그 매칭된 템플릿 호출  -->
	   </table>
	</xsl:template>
	
	<xsl:template match="person">
	              <!--XML문서내의 person태그를 만날 때마다 호출되어 적용 -->
	   <tr>
	      <xsl:apply-templates/>
	   </tr>	
	</xsl:template>
	
	<xsl:template match="name">
	   <td><xsl:value-of select="."/></td>
	</xsl:template>
	<xsl:template match="age">
	   <td><xsl:value-of select="."/></td>
	</xsl:template>
	<xsl:template match="job">
	   <td><xsl:value-of select="."/></td>
	</xsl:template>
	
	
	
</xsl:stylesheet>



