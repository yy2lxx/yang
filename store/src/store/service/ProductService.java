package store.service;

import store.domain.PageModel;
import store.domain.Product;

import java.util.List;

public interface ProductService {
     List<Product> findHots() throws Exception;
     List<Product> findNews() throws Exception;
     Product   findProductByPid(String pid) throws Exception;
     PageModel findProductsByCidWithPage(String cid, int curNum)throws Exception;
}
