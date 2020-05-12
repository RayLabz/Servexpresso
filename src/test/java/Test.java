import com.google.gson.JsonObject;
import com.raylabz.responz.ErrorResponse;
import com.raylabz.responz.Response;
import com.raylabz.responz.SecurityResponse;
import com.raylabz.responz.SuccessResponse;
import com.raylabz.servexpresso.*;

public class Test {

    public static void main(String[] args) {
        Service CREATE_GAME_SERVICE = new Service.Builder()
                .expectParam("password", ParamType.STRING, true)
//                .expectParam("name", ParamType.STRING, true)
                .expectParam("seed", ParamType.LONG, true)
//                .expectParam("maxHorizontalChunks", ParamType.INTEGER, true)
//                .expectParam("maxVerticalChunks", ParamType.INTEGER, true)
                .implement(new Serviceable() {
                    @Override
                    public Response serve(InputParams inputParams) {
                        if (!inputParams.getString("password").equals("1234")) {
                            return new SecurityResponse();
                        }
                        else {
                            if (inputParams.paramExists("seed")) {
                                long seed = inputParams.getLong("seed");
                                System.out.println("Seed: " + seed);
                            }
                            return new SuccessResponse("hi!", "Success!");
                        }
                    }
                }).build();

        final Response response = CREATE_GAME_SERVICE.processRequest(
                new ServiceInputParam("password", ParamType.STRING, "1234"),
                new ServiceInputParam("seed", ParamType.UNSIGNED_LONG, "1234")
        );

        System.out.println(response);

    }

}
