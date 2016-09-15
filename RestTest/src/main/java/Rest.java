import javax.xml.ws.Response;

/**
 * Created by gauravp.jain on 8/24/2016.
 */
public class Rest {

    public static void main(String args[]) {
        Rest obj=new Rest();
        obj.getApi();
    }

    public void getApi() {
    baseURI="";
        String APIBody="{\"key\":\"+numericValue+\"}";
        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBody(APIBody);
        builder.setContentType("application/json");
        RequestSpecification resSpec=builder.build();

        try {
            try {
                Response response=given().pathParam("key","value").spec(resSpec)
                .when().post("/key/{key}");
                response.then().log().all().body("message",equalTo("success"));
                response.getBody().asString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
