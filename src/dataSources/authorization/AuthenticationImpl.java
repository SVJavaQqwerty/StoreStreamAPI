package dataSources.authorization;

import dataSources.authorization.utils.Password;
import dto.UserDto;
import entitys.User;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AuthenticationImpl implements Authentication {


    @Override
    public UserDto getUser(String login, String password) {
        User user = authentication(login, password).getUser();

        UserDto userDto = new UserDto(user);

        return userDto;

    }

    @Override
    public UserDto setUser(User user, String password) {
        UserDto newUser = new UserDto(user, password);
        if(registration(newUser)) {
            return newUser;
        }
        return null;
    }

    public static UserDto authentication(String login, String password){
        try (Scanner file = new Scanner(new FileReader("bd.txt"))) {
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] strUser = line.split(":");

                if(strUser[0].equals(login)) {
                    Password pas = new Password(password);
                    if(strUser[3].equals(pas.getPassword())){
                        return new UserDto(strUser[0], strUser[1], strUser[2], pas);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public static boolean registration(UserDto user) {
        if(! isUserByLogin(user.getLogin())) {
            writeUser(user);
            return true;
        } else {
            return false;
        }
    }


    private static boolean writeUser(UserDto user) {
        try (FileWriter writer = new FileWriter("bd.txt", true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(user.getLogin() + ":" + user.getName() + ":" + user.getRole() + ":" + user.getPassword() + "\n");
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static boolean isUserByLogin(String login) {
        try (Scanner file = new Scanner(new FileReader("bd.txt"))) {
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] strUser = line.split(":");

                if(strUser[0].equals(login)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }
}
