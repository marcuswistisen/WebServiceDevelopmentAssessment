/**
 * ArticleSOAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uts.ws.SOAP.client;

public interface ArticleSOAP extends java.rmi.Remote {
    public void removeArticle(int arg0) throws java.rmi.RemoteException, uts.ws.SOAP.client.JAXBException, uts.ws.SOAP.client.IOException;
    public void addArticle(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6) throws java.rmi.RemoteException, uts.ws.SOAP.client.JAXBException, uts.ws.SOAP.client.IOException;
    public uts.ws.SOAP.client.Article[] fetchArticles() throws java.rmi.RemoteException, uts.ws.SOAP.client.JAXBException, uts.ws.SOAP.client.IOException;
}
