package org.restlet.ext.apispark.internal.introspection.helper;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.restlet.ext.apispark.internal.introspection.IntrospectionHelper;
import org.restlet.ext.apispark.internal.model.Definition;
import org.restlet.ext.apispark.internal.model.Operation;
import org.restlet.ext.apispark.internal.model.Property;
import org.restlet.ext.apispark.internal.model.Representation;
import org.restlet.ext.apispark.internal.model.Resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * Fulfills API Definition from Swagger annotation 1.2.
 * 
 * @author Manuel Boillod
 */
public class SwaggerAnnotationIntrospectionHelper implements
        IntrospectionHelper {

    @Override
    public void processDefinition(Definition definition,
            Class<?> applicationClass) {
        // no annotation exists for root definition
    }

    @Override
    public java.util.List<Class<?>> processOperation(Resource resource, Operation operation,
                                                     Class<?> resourceClass, Method javaMethod) {
        List<Class<?>> representationsUsed = new ArrayList<>();

        ApiOperation apiOperation = javaMethod
                .getAnnotation(ApiOperation.class);
        if (apiOperation != null) {
            SwaggerAnnotationUtils.processApiOperation(apiOperation, resource, operation);
        }
        ApiResponses apiResponses = javaMethod
                .getAnnotation(ApiResponses.class);
        if (apiResponses != null) {
            SwaggerAnnotationUtils.processApiResponses(apiResponses, operation, representationsUsed);
        }
        ApiResponse apiResponse = javaMethod.getAnnotation(ApiResponse.class);
        if (apiResponse != null) {
            SwaggerAnnotationUtils.processApiResponse(apiResponse, operation, representationsUsed);
        }
        ApiImplicitParams apiImplicitParams = javaMethod
                .getAnnotation(ApiImplicitParams.class);
        if (apiImplicitParams != null) {
            SwaggerAnnotationUtils.processApiImplicitParams(apiImplicitParams,
                    operation);
        }
        ApiImplicitParam apiImplicitParam = javaMethod
                .getAnnotation(ApiImplicitParam.class);
        if (apiImplicitParam != null) {
            SwaggerAnnotationUtils.processApiImplicitParam(apiImplicitParam,
                    operation);
        }
        return representationsUsed;
    }

    @Override
    public void processProperty(Property property, Method readMethod) {
        ApiModelProperty apiModelProperty = readMethod
                .getAnnotation(ApiModelProperty.class);
        if (apiModelProperty != null) {
            SwaggerAnnotationUtils.processApiModelProperty(apiModelProperty,
                    property);
        }
    }

    @Override
    public void processRepresentation(Representation representation,
            Class<?> representationClass) {
        ApiModel apiModel = representationClass.getAnnotation(ApiModel.class);
        if (apiModel != null) {
            SwaggerAnnotationUtils.processApiModel(apiModel, representation);
        }
    }

    @Override
    public void processResource(Resource resource, Class<?> resourceClass) {
        Api api = resourceClass.getAnnotation(Api.class);
        if (api != null) {
            SwaggerAnnotationUtils.processApi(api, resource);
        }
    }
}