/**
 * ArticleSOAPService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uts.ws.SOAP.client;

public interface ArticleSOAPService extends javax.xml.rpc.Service {
    public java.lang.String getArticleSOAPPortAddress();

    public uts.ws.SOAP.client.ArticleSOAP getArticleSOAPPort() throws javax.xml.rpc.ServiceException;

    public uts.ws.SOAP.client.ArticleSOAP getArticleSOAPPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
