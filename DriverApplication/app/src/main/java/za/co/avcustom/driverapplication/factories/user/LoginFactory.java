package za.co.avcustom.driverapplication.factories.user;

import za.co.avcustom.driverapplication.domain.user.Impl.Login;

/**
 * Created by cfebruary on 2016/12/10.
 */
public class LoginFactory {
    public static Login getInstance(String username, String password)
    {
        Login login = new Login.Builder()
                .username(username)
                .password(password)
                .build();
        return login;
    }

}
