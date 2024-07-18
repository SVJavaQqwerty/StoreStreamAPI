package dataSources.authorization;

import dto.UserDto;
import entitys.User;

public interface Authentication {

    UserDto getUser(String login, String password);

    UserDto setUser(User user, String password);

}
