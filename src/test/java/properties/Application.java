package properties;

public class Application {

    public static String  dataFilePath="C:\\Selenium_tut\\Data\\";
    public static String  dataFileName="moneyapp_data.xlsx";
    public static String  baseUrl="https://sixtyfive.co.za/moneyapp_preprod/signin.html";
    public static String  RunIndicatorColumnHeader="RUN";

    //application messages
    public static String  msg_success_create_custom_transaction = "successfully captured new transaction name";
    public static String  msg_success_delete_custom_transaction = "successfully deleted transaction name";
    public static String  msg_success_add_new_budget_item = "successfully captured new budget item";


    //excel tab names
    public static String  login_sheet_name = "001_login";
    public static String  custom_transaction_sheet_name = "002_config";
    public static String  budget_sheet_name = "003_budget";

    public static String  application_username = "demo";
    public static String  application_password = "pass";

}
