package by.laligulbani.vk;

public class Api {

    public static final String EMPTY = "";

    public static final String REDIRECT_URL = "https://oauth.vk.com/blank.html";
    public static final String VERSION_VALUE = "5.69";
    public static final String VERSION_PARAM = "v";
    public static final String AUTHORIZATION_URL = "https://oauth.vk.com/authorize"
            + "?client_id=6249213"
            + "&redirect_uri=" + REDIRECT_URL
            + "&display=mobile"
            + "&scope=item_friends,messages"
            + "&response_type=token"
            + "&" + VERSION_PARAM + "=" + VERSION_VALUE;

    public static final String BASE_PATH_METHOD = "https://api.vk.com/method/";


    public static final String USERS_GET = BASE_PATH_METHOD + "users.get?fields=photo_50&user_ids=";

    public static final String DIALOGS_GET = BASE_PATH_METHOD + "messages.getDialogs";

    public static final String FRIENDS_GET_ID = BASE_PATH_METHOD + "friends.get?user_id=";
    public static final String FRIENDS_ONLINE= BASE_PATH_METHOD + "friends.getOnline?access_token=";


    public static final String GET_USER_NEWS = BASE_PATH_METHOD + "newsfeed.get?filters=post&end_time&access_token=";

    public static final String MAIN_USER_INFO = BASE_PATH_METHOD + "account.getProfileInfo?access_token=";

    public static final String MESSAGES_GET_LONG_POLL_SERVER = BASE_PATH_METHOD  + "messages.getLongPollServer";
    public static final String MESSAGES_GET_LONG_POLL_HISTORY = BASE_PATH_METHOD  + "messages.getLongPollHistory?need_pts=";
    public static final String MESSAGE_HISTORY_GET = BASE_PATH_METHOD + "messages.getHistory?user_id=";
    public static final String SEND_MESSAGE = BASE_PATH_METHOD + "messages.send?user_id=";

  /* public static final class Builder {
       Map<String, String> token = new HashMap<>(); ;
        String basePathMethod;
        String nameMethod;
        Map<String, String> parameter = new HashMap<>();

        public Builder basePathMethod(String basePathMethod){
            this.basePathMethod = basePathMethod;
            return this;
        }

        public Builder nameMethod(String nameMethod){
            this.nameMethod = nameMethod;
            return this;
        }
        public Builder addParameterToken(String token){
            this.token.put("access_token", token);
            return this;
        }
        public Builder addParameter(String key, String value){
            this.parameter.put(key, value);
            return this;
        }

        public String build () {
            final StringBuilder sb = new StringBuilder();
            sb.append(basePathMethod);
            sb.append(nameMethod);
            sb.append("?");
            sb.append(token);
            for (final Map.Entry<String, String> entry : parameter.entrySet()) {
                sb.append("&")
                        .append(entry.getKey())
                        .append("=")
                        .append(entry.getValue());
            }
            return sb.toString();
        }
    }*/
}
