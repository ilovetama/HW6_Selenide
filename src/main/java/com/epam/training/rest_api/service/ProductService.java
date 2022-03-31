package com.epam.training.rest_api.service;

import com.epam.training.rest_api.model.ProductFacet;
import com.epam.training.rest_api.utils.GetRequestUtils;
import com.epam.training.rest_api.utils.ResponseBodyUtils;
import io.restassured.response.ResponseBody;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    public List<ProductFacet> getProductFacetItems() {
        String endpoint = "https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla";
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(endpoint, null,
            null);
        LOG.info("Response body: {}", responseBody.asString());
        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, "products",
            ProductFacet.class);
    }

    public List<String> getNameOfProductType() {
        String endpoint = "https://catalog.onliner.by/sdapi/catalog.api/search/"
            + "sushivesla?sushi_typ[0]=roll&sushi_typ[operation]=union";
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(endpoint, null,
            null);
        LOG.info("Response body: {}", responseBody.asString());
        return Collections.singletonList(
            ResponseBodyUtils.getStringJsonValue(responseBody, "products.name_prefix"));
    }

    private Map<String, Object> configureRequestHeaders() {
        return Map.of("", "",
            "", "",
            "", "",
            "", "",
            "", "");
    }
}
