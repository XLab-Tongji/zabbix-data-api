package rainlf.zabbix.domain;




public class User {

    public String username;

    public String password;

    public User(){

    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}