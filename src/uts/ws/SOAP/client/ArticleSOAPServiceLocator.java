/**
 * ArticleSOAPServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uts.ws.SOAP.client;

public class ArticleSOAPServiceLocator extends org.apache.axis.client.Service implements uts.ws.SOAP.client.ArticleSOAPService {

    public ArticleSOAPServiceLocator() {
    }


    public ArticleSOAPServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ArticleSOAPServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ArticleSOAPPort
    private java.lang.String ArticleSOAPPort_address = "http://localhost:8080/WebServiceDevelopmentAssessment/soap/articleApp";

    public java.lang.String getArticleSOAPPortAddress() {
        return ArticleSOAPPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ArticleSOAPPortWSDDServiceName = "ArticleSOAPPort";

    public java.lang.String getArticleSOAPPortWSDDServiceName() {
        return ArticleSOAPPortWSDDServiceName;
    }

    public void setArticleSOAPPortWSDDServiceName(java.lang.String name) {
        ArticleSOAPPortWSDDServiceName = name;
    }

    public uts.ws.SOAP.client.ArticleSOAP getArticleSOAPPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ArticleSOAPPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getArticleSOAPPort(endpoint);
    }

    public uts.ws.SOAP.client.ArticleSOAP getArticleSOAPPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uts.ws.SOAP.client.ArticleSOAPPortBindingStub _stub = new uts.ws.SOAP.client.ArticleSOAPPortBindingStub(portAddress, this);
            _stub.setPortName(getArticleSOAPPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setArticleSOAPPortEndpointAddress(java.lang.String address) {
        ArticleSOAPPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uts.ws.SOAP.client.ArticleSOAP.class.isAssignableFrom(serviceEndpointInterface)) {
                uts.ws.SOAP.client.ArticleSOAPPortBindingStub _stub = new uts.ws.SOAP.client.ArticleSOAPPortBindingStub(new java.net.URL(ArticleSOAPPort_address), this);
                _stub.setPortName(getArticleSOAPPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ArticleSOAPPort".equals(inputPortName)) {
            return getArticleSOAPPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://SOAP.ws.uts/", "ArticleSOAPService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://SOAP.ws.uts/", "ArticleSOAPPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ArticleSOAPPort".equals(portName)) {
            setArticleSOAPPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
