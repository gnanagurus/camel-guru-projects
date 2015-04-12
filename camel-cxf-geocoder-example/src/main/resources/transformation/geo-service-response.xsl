<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:param name="CamelGeoCoderLatlng" />


	<xsl:template match="/">

		<GeoServiceResponse>
			<details>
				<xsl:value-of select="$CamelGeoCoderLatlng" />
			</details>
		</GeoServiceResponse>

	</xsl:template>

</xsl:stylesheet>