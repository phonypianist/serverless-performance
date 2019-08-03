package phonypianist.search;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;

public class Search implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        context.getLogger().log("started ");

        int number = Integer.parseInt(event.getPathParameters().get("number"));

        int[] numberList = new int[number];
        for (int i = 0; i < number; i++) {
            numberList[i] = i + 1;
        }
        context.getLogger().log("list created");

        boolean result = false;
        for (int i = 0; i < number; i++) {
            if (numberList[i] == number) {
                result = true;
                break;
            }
        }
        context.getLogger().log("number = " + number + ", result = " + result);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(200);
        responseEvent.setHeaders(Collections.singletonMap("Content-Type", "application/json"));
        try {
            responseEvent.setBody(mapper.writeValueAsString(Collections.singletonMap("result", result)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return responseEvent;
    }

}
