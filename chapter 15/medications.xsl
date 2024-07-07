<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                exclude-result-prefixes="xs"
                version="2.0">

    <xsl:output method="html" indent="yes" />

    <xsl:template match="/">
        <html>
            <head>
                <title>Medications</title>
            </head>
            <body>
                <h1>Medications</h1>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Pharm</th>
                        <th>Group</th>
                        <th>Type</th>
                        <th>Price</th>
                    </tr>
                    <xsl:for-each select="Medicine/Medication/Versions/Version">
                        <xsl:sort select="Package/Price" data-type="number" order="ascending" />
                        <tr>
                            <td><xsl:value-of select="../../../Name" /></td>
                            <td><xsl:value-of select="../../../Pharm" /></td>
                            <td><xsl:value-of select="../../../Group" /></td>
                            <td><xsl:value-of select="Type" /></td>
                            <td><xsl:value-of select="Package/Price" /></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>