package com.appliances.appliances.web.client;

import com.appliances.appliances.web.model.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ProductClient extends WebServiceGatewaySupport {

    public ProductListResponse findProductsByName(String name) {
        FindProductsByNameRequest request = new FindProductsByNameRequest(name);
        return (ProductListResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public ProductListResponse findAll() {
        return (ProductListResponse) getWebServiceTemplate().marshalSendAndReceive(new FindAllProductsRequest());
    }

    public FindProductByIdResponse findOneById(int id) {
        FindProductByIdRequest request = new FindProductByIdRequest(id);
        return (FindProductByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public CreatedIdResponse create(Product product) {
        CreateProductRequest request = new CreateProductRequest(product);
        return (CreatedIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public void update(Product product) {
        UpdateProductRequest request = new UpdateProductRequest(product);
        getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public void delete(int id) {
        DeleteProductRequest request = new DeleteProductRequest(id);
        getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
