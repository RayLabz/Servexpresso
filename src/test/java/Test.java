import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.raylabz.responz.ErrorResponse;
import com.raylabz.responz.Response;
import com.raylabz.responz.SecurityResponse;
import com.raylabz.responz.SuccessResponse;
import com.raylabz.servexpresso.*;

public class Test {

    public static void main(String[] args) {
//        Service CREATE_GAME_SERVICE = new Service.Builder()
//                .expectParam("password", ParamType.STRING, true)
//                .expectParam("name", ParamType.STRING, true)
//                .expectParam("seed", ParamType.LONG, true)
//                .expectParam("maxHorizontalChunks", ParamType.INTEGER, true)
//                .expectParam("maxVerticalChunks", ParamType.INTEGER, true)
//                .implement(new Serviceable() {
//                    @Override
//                    public Response serve(InputParams inputParams) {
//                        if (!inputParams.getString("password").equals("1234")) {
//                            return new SecurityResponse();
//                        } else {
//                            return new SuccessResponse("Good!", "good");
//                        }
//                    }
//                }).build();
//
//        final Response response = CREATE_GAME_SERVICE.processRequest(
//                new InputParam("password", "1234"),
//                new InputParam("name", "world"),
//                new InputParam("seed", "12"),
//                new InputParam("maxHorizontalChunks", "3"),
//                new InputParam("maxVerticalChunks", "3")
//        );
//
//        System.out.println(response);

//        Service REQUEST_CHUNK_SERVICE = new Service.Builder()
//                .expectParam("worldID", ParamType.STRING, true)
//                .expectParam("chunkRow", ParamType.INTEGER, true)
//                .expectParam("chunkCol", ParamType.INTEGER, true)
//                .implement(new Serviceable() {
//                    @Override
//                    public Response serve(InputParams inputParams) {
//                        final String worldID = inputParams.getString("worldID");
//                        final int chunkRow = inputParams.getInt("chunkRow");
//                        final int chunkCol = inputParams.getInt("chunkCol");
//                        return new SuccessResponse("Chunk fetched", "Chunk (" + chunkRow + "," + chunkCol + ") @ '"+worldID+"' fetched");
//                    }
//                }).build();
//
//        final Response response = REQUEST_CHUNK_SERVICE.processRequest(
//                new InputParam("worldID", "asdflaskdjfasdf"),
//                new InputParam("chunkRow", 1),
//                new InputParam("chunkCol", 3)
//        );
//
//        System.out.println(response);

        final Service addService = new Service.Builder()
                .expectParam("number1", ParamType.INTEGER, true)
                .expectParam("number2", ParamType.INTEGER, true)
                .expectParam("number3", ParamType.INTEGER, false)
                .implement((input, attributes) -> {
                    CustomObject customObject = (CustomObject) attributes.get("myCustomObject");
                    System.out.println(customObject);
                    int number1 = input.getInt("number1");
                    int number2 = input.getInt("number2");
                    int number3 = 0;
                    if (input.paramExists("number3")) {
                        number3 = input.getInt("number3");
                    }
                    int sum = number1 + number2 + number3;
                    JsonObject data = new JsonObject();
                    data.addProperty("sum", sum);
                    return new SuccessResponse("Success", "Numbers added", data);
                })
                .build();

        InputParam param1 = new InputParam("number1", 3);
        InputParam param2 = new InputParam("number2", 6);
        InputParam param3 = new InputParam("number3", 1);

        InputParams params = new InputParams();
        params.put(param1.getName(), param1);
        params.put(param2.getName(), param2);
        params.put(param3.getName(), param3);

        addService.setAttribute("myCustomObject", new CustomObject(1, 2, 3));
        addService.processRequest(params);

        final Response addResponse = addService.processRequest(
                new InputParam("number1", 3),
                new InputParam("number2", 6),
                new InputParam("number3", 1)
        );

        System.out.println(addResponse);

    }

}
