package uts.ws.SOAP.client;

public class ArticleSOAPProxy implements uts.ws.SOAP.client.ArticleSOAP {
  private String _endpoint = null;
  private uts.ws.SOAP.client.ArticleSOAP articleSOAP = null;
  
  public ArticleSOAPProxy() {
    _initArticleSOAPProxy();
  }
  
  public ArticleSOAPProxy(String endpoint) {
    _endpoint = endpoint;
    _initArticleSOAPProxy();
  }
  
  private void _initArticleSOAPProxy() {
    try {
      articleSOAP = (new uts.ws.SOAP.client.ArticleSOAPServiceLocator()).getArticleSOAPPort();
      if (articleSOAP != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)articleSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)articleSOAP)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (articleSOAP != null)
      ((javax.xml.rpc.Stub)articleSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uts.ws.SOAP.client.ArticleSOAP getArticleSOAP() {
    if (articleSOAP == null)
      _initArticleSOAPProxy();
    return articleSOAP;
  }
  
  public void removeArticle(int arg0) throws java.rmi.RemoteException, uts.ws.SOAP.client.JAXBException, uts.ws.SOAP.client.IOException{
    if (articleSOAP == null)
      _initArticleSOAPProxy();
    articleSOAP.removeArticle(arg0);
  }
  
  public void addArticle(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6) throws java.rmi.RemoteException, uts.ws.SOAP.client.JAXBException, uts.ws.SOAP.client.IOException{
    if (articleSOAP == null)
      _initArticleSOAPProxy();
    articleSOAP.addArticle(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }
  
  public uts.ws.SOAP.client.Article[] fetchArticles() throws java.rmi.RemoteException, uts.ws.SOAP.client.JAXBException, uts.ws.SOAP.client.IOException{
    if (articleSOAP == null)
      _initArticleSOAPProxy();
    return articleSOAP.fetchArticles();
  }
  
  
}