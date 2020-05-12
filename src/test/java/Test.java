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
                .expectParam("maxHorizontalChunks", ParamType.INTEGER, true)
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
                                System.out.println("Password: " + inputParams.getString("password"));
                                System.out.println("maxHorizontalChunks: " + inputParams.getString("maxHorizontalChunks"));
                            }
                            return new SuccessResponse("hi!", "Success!");
                        }
                    }
                }).build();

        final Response response = CREATE_GAME_SERVICE.processRequest(
                new InputParam("password", "1234"),
                new InputParam("seed",  "12"),
                new InputParam("maxHorizontalChunks", "3")
        );

        System.out.println(response);

    }

}
