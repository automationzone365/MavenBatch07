package bsmartdemoshop.stepdefinitions;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class Authenticatestepdef {
    @Given("a registered user with userid \"(.*)\" and password \"(.*)\"$")
    public void aRegisteredUserWithUseridAndPassword(String userName, String passWord) {
        System.out.println(userName);
        System.out.println(passWord);
    }

    @Given("I am registered user with username \"(.*)\" and with password \"(.*)\"$")
    public void registeredusercreds(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }


    @Given("the user creds in the datatable")
    public void theUserCredsInTheDatatable(DataTable usercreds) {
     List<List<String>> data=usercreds.asLists();
     System.out.println(data.get(0).get(0));
     System.out.println(data.get(0).get(1));
     System.out.println(data.get(1).get(0));
     System.out.println(data.get(1).get(1));
    }

    @Given("the user enters the creds using map")
    public void theUserEntersTheCredsUsingMap(DataTable creds) {
        List<Map<String,String>> data= creds.asMaps(String.class,String.class);
        System.out.println(data.get(0).get("username"));
        System.out.println(data.get(0).get("password"));
        System.out.println(data.get(1).get("username"));
        System.out.println(data.get(1).get("password"));
    }

    @Given("I am using JSON data")
    public void iAmUsingJSONData(String jsonData) {
        String username1=JsonPath.parse(jsonData).read("$.users[0].name");
        String age1=JsonPath.parse(jsonData).read("$.users[0].age");

        String username2=JsonPath.parse(jsonData).read("$.users[1].name");
        String age2=JsonPath.parse(jsonData).read("$.users[1].age");

        System.out.println(username1);
        System.out.println(age1);

        System.out.println(username2);
        System.out.println(age2);



    }
}
