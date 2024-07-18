package dataSources.authorization.utils;

public class Password {

    private String password;

    public Password(String password){
        this.password = encrypt(password);
    }

    public String getPassword(){
        return toString();
    }

    private String encrypt(String password) {
        return String.valueOf(password.hashCode());
    }

    @Override
    public String toString() {
        return password;
    }
}
