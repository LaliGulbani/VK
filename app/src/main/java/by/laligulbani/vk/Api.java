package by.laligulbani.vk;


public class Api {
    public static final String REDIRECT_URL = "https://oauth.vk.com/blank.html";
    public static final String VERSION_VALUE = "5.69";
    public static final String VERSION_PARAM = "v";
    public static final String AUTORIZATION_URL =
            "https://oauth.vk.com/authorize?client_id=6249213&redirect_uri=" +
                    REDIRECT_URL +
                    "&display=mobile&scope=friends&response_type=token&" + VERSION_PARAM + "=" + VERSION_VALUE;
    public static final String BASE_PATH_METHOD = "https://api.vk.com/method/";

    public static final String FRIENDS_GET = BASE_PATH_METHOD + "friends.get";
    public static final String WALL_GET = BASE_PATH_METHOD + "wall.get";
    public static final String NEWS_GET = BASE_PATH_METHOD + "newsfeed.get";
    public static final String USERS_GET = BASE_PATH_METHOD + "users.get";

    public static final String MESSENGES = BASE_PATH_METHOD + "users";
    public static final String MESSENGES_GET = MESSENGES + ".get";
}
