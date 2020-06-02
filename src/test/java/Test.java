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

        Service REQUEST_CHUNK_SERVICE = new Service.Builder()
                .expectParam("worldID", ParamType.STRING, true)
                .expectParam("chunkRow", ParamType.INTEGER, true)
                .expectParam("chunkCol", ParamType.INTEGER, true)
                .implement(new Serviceable() {
                    @Override
                    public Response serve(InputParams inputParams) {
                        final String worldID = inputParams.getString("worldID");
                        final int chunkRow = inputParams.getInt("chunkRow");
                        final int chunkCol = inputParams.getInt("chunkCol");
                        return new SuccessResponse("Chunk fetched", "Chunk (" + chunkRow + "," + chunkCol + ") @ '"+worldID+"' fetched");
                    }
                }).build();

        final Response response = REQUEST_CHUNK_SERVICE.processRequest(
                new InputParam("worldID", "asdflaskdjfasdf"),
                new InputParam("chunkRow", 1),
                new InputParam("chunkCol", 3)
        );

        System.out.println(response);

    }

}
