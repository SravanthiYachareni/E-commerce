package com.sravs.ecommerce.graphql.handler;

import com.sravs.ecommerce.graphql.exception.InvalidInputException;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class CustomDataFetcherExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof InvalidInputException) {
            return GraphQLError.newError()
                    .errorType(ErrorType.ValidationError)
                    .message(ex.getMessage())
                    .build();
        }
        return null;
    }
}
