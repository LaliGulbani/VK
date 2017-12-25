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


    public static final String WALL_GET = BASE_PATH_METHOD + "wall.get?filters=owner&fields=photo_100&extended=1";
    public static final String NEWS_GET = BASE_PATH_METHOD + "newsfeed.get?filters=post&fields=photo_130\"+\"&count=50";

    public static final String USERS_GET = BASE_PATH_METHOD + "users.get";
    public static final String PHOTOS_GET = BASE_PATH_METHOD + "photos.get";


    public static final String MESSAGES = BASE_PATH_METHOD + "messages.getDialogs";

    public static final String FRIENDS_GET = BASE_PATH_METHOD + "friends.get";
    public static final String FRIENDS_ONLINE= BASE_PATH_METHOD+ "friends.getOnline";
}
